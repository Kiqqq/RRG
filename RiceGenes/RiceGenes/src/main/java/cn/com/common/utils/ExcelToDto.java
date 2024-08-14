package cn.com.common.utils;

import lombok.Data;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 读取excel文件转为指定对象
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
public class ExcelToDto {

    /**
     * 将 Excel 数据映射到实体类对象并返回对象的集合。
     *
     * @param file       Excel文件
     * @param objectType 实体类对象的类型
     * @param <T>        实体类对象类型
     * @return 包含映射数据的实体类对象集合
     */
    public static <T> List<T> excelToObjects(MultipartFile file, Class<T> objectType) {
        List<T> objectList = new ArrayList<>();

        try {
            InputStream fileInputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            int lastColumn = headerRow.getLastCellNum();

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                T yourObject = objectType.getDeclaredConstructor().newInstance();

                for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
                    Cell headerCell = headerRow.getCell(columnIndex);
                    Cell cell = row.getCell(columnIndex);

                    String fieldName = headerCell.getStringCellValue();
                    DataFormatter dataFormatter = new DataFormatter();
                    String cellValue = dataFormatter.formatCellValue(cell);

                    // 使用反射将单元格数据映射到实体类对象的相应属性
                    setFieldUsingReflection(yourObject, fieldName, cellValue);
                }

                objectList.add(yourObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    /**
     * 使用反射将单元格数据映射到实体类对象的相应属性。
     *
     * @param object    实体类对象
     * @param fieldName Excel 表头字段名
     * @param cellValue Excel 单元格值
     * @param <T>       实体类对象类型
     */
    private static <T> void setFieldUsingReflection(T object, String fieldName, String cellValue) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            if (field.getType() == String.class) {
                field.set(object, cellValue);
            } else if (field.getType() == int.class) {
                field.setInt(object, Integer.parseInt(cellValue));
            } // 可根据需要扩展其他数据类型的处理
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取excel中的列名
     *
     * @param file 文件
     * @return List<String>
     */
    public static List<String> getColumnNames(MultipartFile file) {
        try {
            InputStream fileInputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            int lastColumn = headerRow.getLastCellNum();

            List<String> columnNames = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
                Cell headerCell = headerRow.getCell(columnIndex);
                columnNames.add(headerCell.getStringCellValue());
            }
            return columnNames;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Map<String, String>> getDataList(MultipartFile file, List<String> selectedColumns) {
        // 获取需要插入的数据
        List<Map<String, String>> dataList = new ArrayList<>();
        try {
            InputStream fileInputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            // 获取列名列表
            List<String> columnNames = new ArrayList<>();
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                columnNames.add(headerRow.getCell(i).getStringCellValue());
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // 根据 GeneID 构建数据
                Map<String, String> dataMap = new HashMap<>();
                dataMap.put("GeneID", row.getCell(0).getStringCellValue());

                // 获取特定列的数据
                for (String columnName : selectedColumns) {
                    int columnIndex = columnNames.indexOf(columnName);
                    if (columnIndex != -1) {
                        Cell cell = row.getCell(columnIndex);
                        if (cell != null) {
                            // 根据实际情况获取单元格的值
                            DataFormatter dataFormatter = new DataFormatter();
                            String cellValue = dataFormatter.formatCellValue(cell);
                            dataMap.put(columnName, cellValue);
                        }
                    }
                }

                dataList.add(dataMap);
            }

            // 关闭 workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

}
