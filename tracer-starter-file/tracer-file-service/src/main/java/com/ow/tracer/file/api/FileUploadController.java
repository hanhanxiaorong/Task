package com.ow.tracer.file.api;

import cn.hutool.Hutool;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import com.ow.tracer.common.base.BaseController;
import com.ow.tracer.common.base.FileResult;
import com.ow.tracer.common.base.Result;
import com.ow.tracer.common.util.Results;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author easy
 * @auther easy
 * @date 18-11-19 17:38
 * @description
 */
@RestController
@RequestMapping("/file")
public class FileUploadController  extends BaseController {
    /**
     * 文件上传接口
     * 有第三方传入，根据项目名-模块名-文件类型-日期进行分类
     */
    @PostMapping(value="/fileUplod")
    public Result fileUplod(MultipartFile file,String projectName,String modelName) throws  Exception{
        if(file.isEmpty()){
            return Results.failure("文件为空，请核查后在进行上传");
        }
        if(projectName.isEmpty()){
            return Results.failure("所属项目名不允许为空，请核查后重试") ;
        }

        if(modelName.isEmpty()){
            return Results.failure("所属模块名不允许为空，请核查后重试");
        }

        int size  = (int)file.getSize();
        if(size>1024*1024*1024){
            return Results.failure("文件超过1G，请缩小后上传") ;
        }
        //指定文件名称
        String fileName =IdUtil.fastSimpleUUID();
        // 获取文件后缀
        String prefix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //获取当前时间
        DateTime dateTime = DateTime.now();
        //获得当前项目路径
        String filePath =  FileUploadController.class.getProtectionDomain()
                .getCodeSource().getLocation().getFile();
        //创建文件
        File  dest = new File(projectName+"/"+modelName+"/"+dateTime.getYear()+dateTime.getMonth()+dateTime.getDay()+"/"+fileName+"."+prefix);
        String url=projectName+"/"+modelName+"/"+dateTime.getYear()+dateTime.getMonth()+dateTime.getDay()+"/"+fileName+"."+prefix;
        //将MultipartFile转为File
        FileUtil.writeFromStream(file.getInputStream(),dest);
        //创建文件
        FileUtil.touch(dest);
        url="http://127.0.0.1:80/"+url;
        //用于上传文件用的返回类，集成了基础返回类，传值为图片名称（自定义），和编辑好的图片路径（同本方法内的url）
        return  new FileResult("head", url);
    }
}
