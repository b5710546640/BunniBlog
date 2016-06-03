package com.example.salilthip.myblog.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Salilthip on 6/3/2016.
 */
public class WriteIntoDatabase {


    private static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyBlogDB";

    public static void writeBlogIntoDB(Storage.Memento memo,Context context){
        File dir = new File(path);
        if(!dir.exists()) dir.mkdir();

        File file = new File("database.txt");

        try{
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(memo);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            Log.e("File ", "not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("File ","IOException");
            e.printStackTrace();
        }
    }


}
