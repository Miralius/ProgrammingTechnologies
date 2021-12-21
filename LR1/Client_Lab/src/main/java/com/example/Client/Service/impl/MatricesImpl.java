package com.example.Client.Service.impl;

import com.example.Client.Service.Matrices;
import com.example.Client.model.FileNames;
import com.example.Client.model.Matrix;
import com.example.Client.model.MatrixMapping;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Arrays;

public class MatricesImpl implements Matrices {
    private final RestTemplate restTemplate = new RestTemplate();

    public MatricesImpl() {
    }


    public void serialize(ObjectOutputStream outputStream, Matrix matrix) {
        try {
            outputStream.writeInt(matrix.getRows());
            outputStream.writeInt(matrix.getColumns());
            Double[][] elements = matrix.getElements();
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    outputStream.writeObject(elements[i][j]);
                }
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Matrix deserialize(ObjectInputStream inputStream) {
        Matrix matrix = null;
        try {
            int rows = inputStream.readInt();
            int columns = inputStream.readInt();
            matrix = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix.set(inputStream.readObject(), i, j);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    @Override
    public MatrixMapping postMethod(FileNames fileNames, Model model, MatrixMapping[] matrices) {
        if (matrices[0].getColumns() == matrices[1].getColumns() && matrices[0].getRows() == matrices[1].getRows()) {
            System.out.println(Arrays.toString(matrices));
            return restTemplate.postForObject("http://localhost:8081/MatrixController/addition", matrices, MatrixMapping.class);
    }
        return new MatrixMapping();
    }
}
