package com.example.Client.Service;

import com.example.Client.model.FileNames;
import com.example.Client.model.Matrix;
import com.example.Client.model.MatrixMapping;
import org.springframework.ui.Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Matrices {
    void serialize(ObjectOutputStream outputStream, Matrix matrix);

    Matrix deserialize(ObjectInputStream inputStream);

    MatrixMapping postMethod(FileNames fileNames, Model model, MatrixMapping[] matrices);

    static MatrixMapping transferMatrix(Matrix matrix) {
        return new MatrixMapping(matrix.getRows(), matrix.getColumns(), matrix.getElements());
    }

    static Matrix transferMatrix(MatrixMapping matrixMapping) {
        return new Matrix(matrixMapping.getRows(), matrixMapping.getColumns(), matrixMapping.getElements());
    }
}
