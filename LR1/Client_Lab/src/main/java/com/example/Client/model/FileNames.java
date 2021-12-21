package com.example.Client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileNames
{
   private String file1;
   private String file2;

    public FileNames() {
    }

    public FileNames(String file1, String file2) {
        this.file1 = file1;
        this.file2 = file2;
    }

    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
    }

    public String getFile2() {
        return file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2;
    }
}
