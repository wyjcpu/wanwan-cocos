package org.wanwanframework.coco.lab.excel;

import java.io.File;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.wanwanframework.file.poi.ExcelUtils;
import org.wanwanframwork.file.core.FileController;

public class ExcelReadController extends FileController<Workbook>{

	public ExcelReadController() {
		core = ExcelUtils.getWorkBook(new File("./src/main/resources/config/lab/u000100120170608002.xlsx"));
	}
	
	@Override
	protected void process() {
		for (Sheet sheet : core) {
			content += ExcelReadTool.readSheet(sheet).toString();
		}
	}
	
	public static void main(String[] args) {
		ExcelReadController.call(new ExcelReadController());
		
	}
}
