package com.service.maintenance.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO: 別プロジェクトに移動予定　動作確認用に作成
@Controller
public class SampleController {
    
    @RequestMapping({"/", "/dashboard"})
    public String home(Model model) {
        return "dashboard/index";
    }
    
    @RequestMapping("/contract/regist.html")
    public String contractRegist(Model model) {
        return "contract/regist";
    }

    @RequestMapping("/contract/list.html")
    public String contractList(Model model) {
        return "contract/list";
    }

}