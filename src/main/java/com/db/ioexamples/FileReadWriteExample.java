package com.db.ioexamples;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadWriteExample {

    /**
     * Readers/Writers (Character , ASCII Data) Textual Content
     * InputStream/OutputStream (Binary Zip, Images, Fiiles non textual)
     *
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // readFile();
        readFileUsingReader();
          long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    /**
     * java.io.InputStream is;  // used to read file (Binary)
     * java.io.OutputStream os ;  // used to write file (Binary)
     * <p>
     * java.io.Reader reader ;  // read the text content
     * java.io.Writer writer;   // text content
     * <p>
     * java.io.File  file ;   // File System isDirectory , isFile, isReadOny  , isWrite, Absoulute paths
     * java.nio.file.Files nfiles;  // native io non java ---> Deals natively with os (Faster v.fast) as much low level os ops
     */
    public static void readFile() {
        // declared the is variable out of the try so i can use it in finally block
        InputStream is = null;
        try {
            // Reading the file using the java.io.FileInputStream
            is = new FileInputStream("c:/example.txt");
            // delcaring a buffer so that i can decide how much data read
            byte[] buffer = new byte[is.available()];
            // read the file in the buffer
            is.read(buffer);
            // convert the data string from byte ...
            System.out.println(new String(buffer));
        } catch (IOException e) {
            // incase file does not exist of any other io exception
            System.out.println(e);
        } finally {
            if (is != null) {
                try {
                    // release the file else it will be reserved.....
                    is.close();
                } catch (IOException e) {
                    // TODO
                }
            }
        }
    }

    /**
     * this example uses data using Reader and Writer and will allow you read text data line by line
     */
    public static void readFileUsingReader() {
        // a varaible to store each line
        String data = "";
        // the buffered reader
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("d:/airportsdata/airports.csv"));
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (Exception fe) {
            System.out.println(fe);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void readFilesNativeWithStreams() {
        try {
            System.out.println(Files.readString(Paths.get("d:/airportsdata/airports.csv")));
        } catch (Exception exception) {
        } finally {
        }
    }
}













