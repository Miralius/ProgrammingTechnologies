package com.example.client.service.impl;

import com.example.client.model.MatrixMapping;
import com.example.client.service.MatrixService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatrixServiceImpl implements MatrixService {
    public MatrixMapping addition(MatrixMapping first, MatrixMapping second)
    {
        Double[][] elements = new Double[first.getRows()][first.getColumns()];
        int rows = first.getRows();
        int column = first.getColumns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                elements[i][j] = first.get(i, j) + second.get(i, j);
            }
        }
        return new MatrixMapping(rows, column, elements);
    }
}
