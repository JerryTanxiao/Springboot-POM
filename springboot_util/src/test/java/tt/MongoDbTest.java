package tt;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Version
 * @Author tan.jie
 * @Created 2019年10月17  11:30:53
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年10月17  JerryTan  create file
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbTest {
    // 获得SpringBoot提供的mongodb的GridFS对象
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Test
    public void fileupload() throws Exception {
        FileInputStream fis = new FileInputStream("F:\\20170818171013_BNSZR.jpeg");
        ObjectId jpeg = gridFsTemplate.store(fis, "20170818171013_BNSZR.jpeg", "jpeg");
        System.out.println("保存成功"+jpeg);
    }

    /**
     * 文件下载
     */
    public @Test void fileDownload() throws Exception {
        System.out.println("开始下载。。");
        Query query = Query.query(Criteria.where("_id").is("5d91f9ed034b6417440398ea"));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        if (gridFSFile == null) {
            return;
        }
        String filename=gridFSFile.getFilename().replace(",","");
        String contentType = gridFSFile.getMetadata().get("_contentType").toString();
        GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDbFactory.getDb());
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\"+filename);
        IOUtils.copy(gridFsResource.getInputStream(),fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("下载结束、、、");
    }
    /**
     * 删除
     */
    public @Test
    void deleteFileById(){
        Query query = Query.query(Criteria.where("_id").is("5d91f9ed034b6417440398ea"));
        //查询当个文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        if (gridFSFile == null) {
            System.out.println("文件不存在");
            // return ServiceResultHelper.genResultWithFaild(Constant.ErrorCode.FILE_NOT_EXIST_ERROR_MSG, Constant.ErrorCode.FILE_NOT_EXIST_ERROR);
            return;
        }
        gridFsTemplate.delete(query);
        System.out.println("删除文件成功！");
    }

}
