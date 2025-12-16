package com.example.demo.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ReportDao;
import com.example.demo.entity.Report;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportService {

	@Autowired
	private ReportDao dao;

	public void saveReport(List<Report> report) {
		dao.saveReport(report);
	}

	public List<Report> getReport() {
		return dao.getReport();
	}

	public void export(HttpServletResponse response) throws IOException {
		List<Report> data = dao.getReport();
		List<String> header = new ArrayList<>(Arrays.asList("id", "Report Code", "Report Name"));

		String exportType = "xlsx";
		Workbook workbook = exportType.equals("xlsx") ? new XSSFWorkbook() : new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sample Sheet");

		CellStyle cellStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		cellStyle.setFont(font);

		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < header.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(header.get(i));
			cell.setCellStyle(cellStyle);
		}

		int rowCount = 1;
		for (Report report : data) {
			Row dataRow = sheet.createRow(rowCount++);
			dataRow.createCell(0).setCellValue(report.getId());
			dataRow.createCell(1).setCellValue(report.getReportCode());
			dataRow.createCell(2).setCellValue(report.getReportName());
		}

		for (int i = 0; i < header.size(); i++) {
			sheet.autoSizeColumn(i);
		}

		String fileName = "Report.xlsx";
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		workbook.write(response.getOutputStream());
		workbook.close();
		response.getOutputStream().flush();
	}

	public void exportData(HttpServletResponse response) throws IOException {
		
		String reportCode ="Details_report";
		List<?> data = dao.getReportDetails(reportCode);
		
		if (data == null || data.isEmpty()) {
			throw new IllegalArgumentException("Data list is empty!");
		}

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1");

		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		headerStyle.setFont(font);

		Class<?> clazz = data.get(0).getClass();
		Field[] fields = clazz.getDeclaredFields();

		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < fields.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(fields[i].getName());
			cell.setCellStyle(headerStyle);
		}

		int rowCount = 1;
		for (Object item : data) {
			Row row = sheet.createRow(rowCount++);
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true); // allow access to private fields
				Object value;
				try {
					value = fields[i].get(item);
				} catch (IllegalAccessException e) {
					value = "";
				}
				row.createCell(i).setCellValue(value != null ? value.toString() : "");
			}
		}

		for (int i = 0; i < fields.length; i++) {
			sheet.autoSizeColumn(i);
		}
		
		String fileName ="Export.xlsx";

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		workbook.write(response.getOutputStream());
		workbook.close();
		response.getOutputStream().flush();
	}

}
