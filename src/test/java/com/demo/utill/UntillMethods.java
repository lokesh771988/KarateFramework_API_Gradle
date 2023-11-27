package com.demo.utill;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.noggit.ObjectBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class UntillMethods {

    public static String jsonFile(String fileName) {
        String path="";
        String requestBody = "";
        try {
            path = System.getProperty("user.dir")+"\\src\\test\\resources\\JsonFiles\\"+fileName;
            requestBody = new String(Files.readAllBytes(Paths.get(path)));
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return requestBody;
    }

    public static String getFile(String fileName) {
        String path="";
        String requestBody = "";
        try {
            path = System.getProperty("user.dir")+"\\src\\test\\resources\\images\\"+fileName;

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return path;
    }

    public Map<String, Object> doWork(String fromJs) {
        Map<String, Object> map = new HashMap<>();
        map.put("someKey", "hello " + fromJs);
        return map;
    }

    public static String doWorkStatic(String fromJs) {
        return "hello " + fromJs;
    }

    public static Map<String,Object> getJsonFile(){
        Map<String,Object> jsonValue=null;
        String jsonText = null;
        try{
            jsonValue = (Map<String,Object>) ObjectBuilder.fromJSON(jsonFile("CreateUser.xml"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return jsonValue;
    }

    public static void geekforgeeks() throws IOException
    {

        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir")+"\\TestData\\testData.xlsx");
        System.out.println(file);
        XSSFWorkbook wb = new XSSFWorkbook(file);

        XSSFSheet sh = wb.getSheet("Sheet1");

        HashMap<Integer, String> map
                = new HashMap<Integer, String>();

        for (int r = 0; r <= sh.getLastRowNum(); r++) {
            int key = (int)sh.getRow(r)
                    .getCell(0)
                    .getNumericCellValue();
            String value = sh.getRow(r)
                    .getCell(1)
                    .getStringCellValue();
            map.put(key, value);
        }

        // Displaying HashMap
        Iterator<Map.Entry<Integer, String>> new_Iterator
                = map.entrySet().iterator();

        while (new_Iterator.hasNext()) {
            Map.Entry<Integer, String> new_Map
                    = (Map.Entry<Integer, String>)
                    new_Iterator.next();

            System.out.println(new_Map.getKey() + "|"
                    + new_Map.getValue());
        }
        wb.close();
        file.close();
    }

    public static void main(String[] args) throws IOException {
        geekforgeeks();
    }

}
