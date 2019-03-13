package com.example.ts7.weartherapplication;


import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class FileEntity {
    public String TAG = "LY--FileEntity";
    File extDir = Environment.getExternalStorageDirectory();

    void write(ArrayList<String> arrayList) throws IOException {


        String filename = "cityList.txt";
        File fullFilename = new File(extDir, filename);

        try {
            if (!fullFilename.exists()){
                fullFilename.createNewFile();
                fullFilename.setWritable(Boolean.TRUE);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        FileWriter fw = new FileWriter(fullFilename,false);
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String line = iterator.next();
            fw.write(line+"\r\n");
        }
        fw.close();
        Log.d(TAG, "write: ");
    }

    ArrayList<String> read() throws IOException {

        String filename = "cityList.txt";
        File fullFilename = new File(extDir, filename);

        try {
            if (!fullFilename.exists()){
                fullFilename.createNewFile();
                fullFilename.setWritable(Boolean.TRUE);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        ArrayList<String> arrayList = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(fullFilename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bf = new BufferedReader(fr);
        String str;
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            arrayList.add(str);
        }
        bf.close();
        fr.close();
        Log.d(TAG, "read: ");
        return arrayList;
    }
}
