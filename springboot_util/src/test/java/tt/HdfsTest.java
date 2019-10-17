package tt;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;
import java.net.URI;

/**
 * @Version
 * @Author tan.jie
 * @Created 2019年10月17  10:56:05
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年10月17  JerryTan  create file
 */
public class HdfsTest {
    public @Test void Test01() throws Exception {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 配置在集群上运行
        configuration.set("fs.defaultFS", "hdfs://bigdata1:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        fileSystem.copyFromLocalFile(new Path("D:\\sys_office.sql"), new Path("/sys_office.sql"));
        // 3 关闭资源
        fileSystem.close();
        System.out.println("over");
    }

    /**
     * hadoop fs -get /HDFS文件系统
     * @throws Exception
     */
    @Test
    public void getFileFromHDFS() throws Exception {
        //1.创建配置信息对象  Configuration:配置
        Configuration conf = new Configuration();

        //2.找到文件系统
        //final URI uri     ：HDFS地址
        //final Configuration conf：配置信息
        // String user ：Linux用户名
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata1:9000"), conf, "root");

        //3.下载文件
        //boolean delSrc:是否将原文件删除
        //Path src ：要下载的路径
        //Path dst ：要下载到哪
        //boolean useRawLocalFileSystem ：是否校验文件
        fs.copyToLocalFile(false,new Path("hdfs://bigdata1:9000/sys_office.sq"),
                new Path("D:\\sys_office.sql"),true);
        //4.关闭fs
        //alt + enter 找错误
        //ctrl + alt + o  可以快速的去除没有用的导包
        fs.close();
        System.out.println("下载成功");
    }

}
