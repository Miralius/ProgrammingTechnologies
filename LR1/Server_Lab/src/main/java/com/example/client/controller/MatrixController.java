package com.example.client.controller;

import com.example.client.model.MatrixMapping;
import com.example.client.service.impl.MatrixServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("MatrixController")
@RequiredArgsConstructor
public class MatrixController {
    private final MatrixServiceImpl matrixService = new MatrixServiceImpl();

    @PostMapping("addition")
    public MatrixMapping additionMatrix(@RequestBody MatrixMapping[] dto) {
        System.out.println(Arrays.toString(dto));
        return matrixService.addition(dto[0], dto[1]);
    }
}
