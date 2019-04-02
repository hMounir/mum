package library.dataaccess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageUtility<T> {
    private String OUTPUT_DIR = "";

    public StorageUtility(String className) {
        OUTPUT_DIR = System.getProperty("java.io.tmpdir")
                + "\\storage\\" + className + ".txt";
        String folderDir = System.getProperty("java.io.tmpdir")
                + "\\storage";

        File folder = new File(folderDir);
        if(!folder.exists()){
            folder.mkdir();
        }
        if (!isExists())
            try {
                new File(OUTPUT_DIR).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void write(List<T> obj) {
        try {

            // Store Serialized User Object in File
            FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_DIR);
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(obj);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<T> read() {
        try {
            //Read from the stored file
            FileInputStream fileInputStream = new FileInputStream(new File(OUTPUT_DIR));
            if(fileInputStream.available()!=0){
                ObjectInputStream input = new ObjectInputStream(fileInputStream);
                List<T> obj = (List<T>) input.readObject();
                input.close();
                return obj;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private boolean isExists() {
        return new File(OUTPUT_DIR).isFile();

    }


}
