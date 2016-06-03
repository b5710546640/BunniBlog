package com.example.salilthip.myblog.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

/**
 * Created by Salilthip on 6/3/2016.
 */
public class ReadFromDatabase {

    private static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyBlogDB";

    public static Storage.Memento readFromFile(Context context){
        File file = new File(path+"database.txt");
        try{
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream oin = new ObjectInputStream(fileIn);
            Storage.Memento m = (Storage.Memento) oin.readObject();
            fileIn.close();
            oin.close();
            return  m;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
