package com.demo.utill;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReading {

    public static void geekforgeeks() throws IOException
    {

        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir")+"\\TestData\\testData.xlsx");
        System.out.println(file);
        XSSFWorkbook wb = new XSSFWorkbook(file);

        XSSFSheet sh = wb.getSheet("Sheet1");

        HashMap<Integer, String> map
                = new HashMap<Integer, String>();

        for (int r = 1; r <= sh.getLastRowNum(); r++) {
            int key = (int)sh.getRow(r)
                    .getCell(0)
                    .getNumericCellValue();
            String value = sh.getRow(r)
                    .getCell(1)
                    .getStringCellValue();
            map.put(key, value);
        }

        // Displaying HashMap
        Iterator<Entry<Integer, String> > new_Iterator
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

    public static Map<String, String> getData(String sheetName,String secondSheet,String testCaseID){
        Map<String,String> storeData = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet, sheet1 = null;
        XSSFRow row, roow = null;
        ArrayList headList = null;
        String key, value, value1 = null;

        try{
            storeData = new HashMap<String,String>();
            String path = System.getProperty("user.dir")+"\\TestData\\testData.xlsx";
            FileInputStream file = new FileInputStream(path);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
            sheet1 = workbook.getSheet(secondSheet);
            headList = new ArrayList();
            row = sheet.getRow(0);
            roow = sheet1.getRow(0);

            for(int head = 0; head < row.getLastCellNum(); head++){
                value = row.getCell(head).getStringCellValue();
                headList.add(value);
            }

            for(int headVal = 1; headVal < roow.getLastCellNum(); headVal++){
                value = roow.getCell(headVal).getStringCellValue();
                headList.add(value);
            }

            for(int head = 0; head < row.getLastCellNum(); head++){
                int cell = row.getCell(head).getColumnIndex();
                int rowsCount = sheet.getLastRowNum();

                for(int row1 = 1; row1 <= rowsCount; row1++){
                    String cellName = sheet.getRow(row1).getCell(cell).getStringCellValue();
                    String secondCellName = sheet1.getRow(row1).getCell(cell).getStringCellValue();
                    if(!cellName.isEmpty()){
                        if(cellName.equals(testCaseID) && secondCellName.equals(testCaseID)){
                            for(int head1=0; head1 < row.getLastCellNum(); head1++){
                                String headValue1 = row.getCell(head1).getStringCellValue();
                                String headValue2 = roow.getCell(head1).getStringCellValue();
                                if(headValue1.equals(headList.get(head1))){
                                    key = headList.get(head1).toString();
                                    value1 = sheet.getRow(row1).getCell(head1).getStringCellValue();
                                    if(headValue2.equals("Json")){
                                        key = headList.get(2).toString();
                                        value1 = sheet1.getRow(1).getCell(1).getStringCellValue();
                                        storeData.put(key,value1);
                                    }
                                    storeData.put(key,value1);
                                }
                            }
                        }
                    }
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return storeData;
    }

    public static String jsonValue(String ftSheet, String scSheet,String tcID){
        String json = null;
        Map<String,String> print = getData(ftSheet,scSheet,tcID);

        for(String key : print.keySet()){
            if(key.equals("Json"))
               json = print.get(key);
        }
        return json;
    }

    public static void main(String[] args) throws IOException {
        //geekforgeeks();


    }
}
