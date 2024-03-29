package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    private SpuService spuService;


    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }


    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {

        System.out.println(pmsProductInfo);
        return "success";
    }


    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {

        System.out.println("fileUpload");
        return "success";
    }
}
