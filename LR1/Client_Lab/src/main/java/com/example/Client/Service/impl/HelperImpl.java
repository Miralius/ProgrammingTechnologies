package com.example.Client.Service.impl;

import com.example.Client.Service.Helper;
import com.example.Client.Service.Matrices;
import com.example.Client.model.MatrixMapping;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class HelperImpl implements Helper
{
    public HelperImpl() {
    }
    Matrices matrices = new MatricesImpl();

    public MatrixMapping loadMatrix(String name) {
        try (ObjectInputStream matrixReader = new ObjectInputStream(new FileInputStream(name)))
        {
            return Matrices.transferMatrix(matrices.deserialize(matrixReader));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new MatrixMapping();
    }

    public void saveMatrix(MatrixMapping matrixMapping) {
        try (
                ObjectOutputStream MatrixWriter = new ObjectOutputStream(new FileOutputStream(matrixMapping.getFilename()))) {
            matrices.serialize(MatrixWriter, Matrices.transferMatrix(matrixMapping));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
