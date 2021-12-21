package com.example.Client.controller;

import com.example.Client.Service.Helper;
import com.example.Client.Service.Matrices;
import com.example.Client.Service.impl.HelperImpl;
import com.example.Client.Service.impl.MatricesImpl;
import com.example.Client.model.FileNames;
import com.example.Client.model.MatrixMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MatrixController {
    private final Matrices matrices = new MatricesImpl();
    private final Helper helperService = new HelperImpl();

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String matrixForm(Model model) {
        model.addAttribute("FileNames", new FileNames());
        model.addAttribute("matrixMapping", new MatrixMapping());
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String matrixSubmit(@ModelAttribute FileNames fileNames, Model model) {
        model.addAttribute("matrixMapping",
                matrices.postMethod(fileNames, model,
                        new MatrixMapping[]{
                                helperService.loadMatrix(fileNames.getFile1()),
                                helperService.loadMatrix(fileNames.getFile2())
                        }
                )
        );
        return "result";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMatrix(@ModelAttribute MatrixMapping matrixMapping, Model model) {
        helperService.saveMatrix(matrixMapping);
        return this.matrixForm(model);
    }
}
