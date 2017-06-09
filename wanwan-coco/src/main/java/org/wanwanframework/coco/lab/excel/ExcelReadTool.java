package org.wanwanframework.coco.lab.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelReadTool {

	public static List<String> readSheet(Sheet sheet) {
		List<String> list = new ArrayList<>();
		for (Row row : sheet) {
			list.addAll(readLine(row));
			list.add("\r\n");
		}
		return list;
	}
	
	public static List<String> readLine(Row row) {
		List<String> list = new ArrayList<String>();
		for(Cell cell: row) {
			String value = getCellValue(cell);
			if(value != null) {
				list.add(value);
			}
		}
		return list;
	}
	
	public static String getCellValue(Cell cell) {
		return cell.getStringCellValue();
	}
}
