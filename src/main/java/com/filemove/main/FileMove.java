package com.filemove.main;

import java.io.File;
import java.io.IOException;

public class FileMove {
    public static void main(String[] args) throws IOException {
        fileMove(new File("E:/data"),"E:/");
    }

    public static void fileMove(File file,String address) throws IOException {
        System.out.println(file.getName());
        if(file.isDirectory()){
            address+=file.getName()+"/";
            File[] files = file.listFiles();
            for(int i = 0;i<files.length;i++){
                fileMove(files[i],address);
            }
        }else{
            System.out.println(address);
        }
    }

}
