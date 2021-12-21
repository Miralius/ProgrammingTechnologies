package com.example.Client.model;

import java.io.Serializable;

public class Matrix implements Serializable {

    private int rows;
    private int columns;
    private Double[][] elements;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new Double[rows][columns];
    }

    public Matrix(int rows, int columns, Double[] elements) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (columns >= 0) System.arraycopy(elements, i * columns, this.elements[i], 0, columns);
        }
    }

    public void set(Object obj, int i, int j) {
        this.elements[i][j] = (Double) obj;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Double[][] getElements() {
        return elements;
    }

    public void setElements(Double[][] elements) {
        this.elements = elements;
    }


}
