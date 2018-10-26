package com.zzq.zhangzq.controller;

import com.zzq.util.JsonResult;
import com.zzq.zhangzq.po.Userinfo;
import com.zzq.zhangzq.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class UserInfoController {

    @Value("${web.webupload}")
    private String uploadpath;

    @Autowired
    private UserInfoService userInfoService;

    private static final Logger logger = LoggerFactory.getLogger( UserInfoController.class );

    @RequestMapping("/user/addUser")
    @ResponseBody
    public JsonResult addUser(Userinfo userinfo , MultipartFile file){
        try{
            String filename ;
            if(file.isEmpty()){
                filename = "";
            }else{
                // 存放上传文件根目录
                File base = new File(uploadpath);
                // 不存在就创建
                if(!base.exists()){
                    base.mkdirs();
                }
                filename = uploadpath + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File saveFile = new File(filename);
                BufferedInputStream bis = new BufferedInputStream( file.getInputStream() );
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream( saveFile ));
                byte [] data = new byte[1024];
                int len = 0;
                while ( (len=bis.read(data)) != -1 ){
                    bos.write(data,0,len);
                }
                bos.flush();
                bos.close();
                bis.close();
            }

            userinfo.setUserimg( filename );
            userInfoService.insertUser(userinfo);
            logger.debug("user 存储成功！");
            return new JsonResult(true,"");
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("user 存储失败！");
            return new JsonResult(false,e.getMessage());
        }
    }

}
