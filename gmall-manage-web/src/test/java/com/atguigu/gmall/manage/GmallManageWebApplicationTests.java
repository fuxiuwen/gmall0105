package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {



    @Test
    public void contextLoads() throws IOException, MyException {


        //获得配置文件历经,配置fastdfs的全局连接地址
        String tracker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();

        //获得trackerServer实例
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(trackerServer,null);

        String[] uploadInfos = storageClient.upload_file("D:\\手机相册\\iPhone x\\微博\\2019_05_28_14_59_IMG_4729.JPG", "JPG", null);

        String url = "http://192.168.171.132";

        for (String uploadInfo : uploadInfos) {
            url += "/" + uploadInfo;
        }

        System.out.println(url);
    }

}
