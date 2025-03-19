package cn.yang.shopdemo.utils;

import cn.yang.shopdemo.entity.Shop;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: ExcelUtil
 * @author: yang
 * @date: 2025/3/19 22:48
 * @Version: 1.0
 * @description:
 */
public class ExcelUtil {

    public static List<Shop> parseExcel(InputStream inputStream) {
        List<Shop> shops = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header
                Shop shop = new Shop();

                row.getCell(0).setCellType(CellType.STRING);
                row.getCell(1).setCellType(CellType.STRING);
                shop.setWater(row.getCell(0).getStringCellValue());
                shop.setNa(row.getCell(1).getStringCellValue());
                shops.add(shop);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
        return shops;
    }

    public static void exportExcel(List<Shop> shops, HttpServletResponse response) {
        try (Workbook workbook = new XSSFWorkbook()) {
            // 创建工作表
            Sheet sheet = workbook.createSheet("Shops");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Water");
            headerRow.createCell(1).setCellValue("Na");

            // 填充数据
            int rowNum = 1;
            for (Shop shop : shops) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(shop.getWater());
                row.createCell(1).setCellValue(shop.getNa());
            }

            // 设置响应头
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=shops.xlsx");

            // 将工作簿写入响应输出流
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("Failed to export Excel file: " + e.getMessage());
        }
    }
}