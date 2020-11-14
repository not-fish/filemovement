package com.filemove.utils;

import java.io.File;
import java.io.IOException;

public class PrintDir {
    public static void main(String[] args) throws IOException {
        showDir(-1,new File("E:/data")); //这里写上目标项目
    }

    public static void showDir(int indent, File file) throws IOException {
        for(int i = 0;i<=indent;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i = 0;i<files.length;i++){
                showDir(indent+2,files[i]);
            }
        }
    }

}
