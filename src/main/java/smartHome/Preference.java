/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartHome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nhannt
 */
public class Preference {

    public static final String PATH = "/home/hoang/Documents/the_new_cling/src/main/java/smartHome";

    public static void saveSettingFile(List<Map<String, Object>> listMap) {
        try {
            File file = new File(PATH + "/pref.ser");
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(listMap);
            oos.close();
            fout.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static List<Map<String, Object>> readSettingFile() {
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        try {
            File file = new File(PATH + "/pref.ser");
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            listMap = (List<Map<String, Object>>) oi.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listMap;
    }
    
    
    public static void savePref(Boolean isSave){
       try {
            File file = new File(PATH + "/save.ser");
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(isSave);
            oos.close();
            fout.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public static Boolean readPref(){
        Boolean isSave = false;
        try {
            File file = new File(PATH + "/save.ser");
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            isSave = (Boolean) oi.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isSave;
    }
}
