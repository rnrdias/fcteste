/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Julio M. C. Dias
 */
public class FilesJava implements Serializable{
    private final ArrayList<File> files;
    private String directory;
    private static final long serialVersionUID = 1L;
    private boolean reading = false;
    
    public FilesJava(String directory) {
        this.directory = directory;
        files = new ArrayList<>();
    }

    public FilesJava() {
        files = new ArrayList<>();
    }
    
    
    public void findFiles(){
        reading = true;
        listf(directory, files);
        reading = false;
    }
    
    
    private void listf(String directoryName, ArrayList<File> files) {
    File fDirectory = new File(directoryName);

    // Get all files from a directory.
    File[] fList = fDirectory.listFiles();
        
    if(fList != null)
        for (File file : fList) {      
            if (file.isFile()) {
                if(getFileExtensionJava(file)){
                    files.add(file);
                }    
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }

    private boolean getFileExtensionJava(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf('.') != -1 && fileName.lastIndexOf('.') != 0 &&
                fileName.matches("^.+[.]java$"))
            return true;
        return false;
    }
    
    
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public ArrayList<File> getFiles() {
        return files;
    }
    
    public ArrayList<String> getFilesName() {
        ArrayList<String> lFName = new ArrayList<>();
        for (File file : files) {
            lFName.add(file.getName());
        }
        return lFName;
    }

    public boolean isReading() {
        return reading;
    }
    
    public void cleanArrayFiles(){
        files.clear();
    }
    
}
