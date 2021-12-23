package com.example.Client.controller;

import com.example.Client.Service.ImageWorkerService;
import com.example.Client.dto.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;


@Controller
@RequestMapping("ImageController")
public class ImageController {

    @PostMapping("filterPicture")
    public String filterPicture(@ModelAttribute Form form, Model model) {
        File[] files = ImageWorkerService.filter(form);
        if (files == null) {
            return "error";
        }
        form.setFile1(files[0].getAbsolutePath());
        form.setFile2(files[1].getAbsolutePath());
        model.addAttribute("Form", form);
        model.addAttribute("ResultFile", null);
        return getPicture(model);
    }

    @GetMapping("initPicture")
    public String initPicture(Model model) {
        model.addAttribute("Form", new Form());
        model.addAttribute("ResultFile", null);
        return "init";
    }

    public String getPicture(Model model) {
        File inputFile = new File("src/main/resources/static/out/image1.jpg");
        File result = new File("src/main/resources/static/out/image2.jpg");
        model.addAttribute("ResultFile", new File[]{inputFile, result});
        return "result";
    }
}