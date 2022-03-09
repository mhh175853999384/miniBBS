package com.mhh.controller;


import com.mhh.mapper.DownloadMapper;
import com.mhh.pojo.Download;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class DownloadController {

    @Autowired
    DownloadMapper downloadMapper;

    @GetMapping({"/download"})
    public String download(Model model){
        List<Download> downloadList = downloadMapper.selectList(null);
        model.addAttribute("downloadList",downloadList);
        return "page/download";
    }

}

