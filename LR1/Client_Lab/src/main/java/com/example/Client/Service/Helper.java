package com.example.Client.Service;

import com.example.Client.model.MatrixMapping;

public interface Helper {
    MatrixMapping loadMatrix(String name);

    void saveMatrix(MatrixMapping matrixMapping);
}
