package org.wanwanframework.coco.lab.excel;

import java.io.File;
import java.util.Arrays;

import org.wanwanframework.file.config.ConfigController;
import org.wanwanframwork.file.Log;
import org.wanwanframwork.file.core.FileController;

/**
 * 循环调用器
 * @author coco
 *
 */
public class ExcelReadLoopController extends FileController<File[]>{

	protected String dirPath;
	protected ConfigController configController = new ConfigController();
	
	public ExcelReadLoopController() {
		this.dirPath = configController.getCore().get("loopPath").trim();
		File dir = new File(dirPath);
		core = dir.listFiles(file -> file.getName().endsWith("xlsx") ? true: false);
		configController.init();
	}
	
	@Override
	protected void process() {
		Arrays.asList(core).stream().forEach(file ->{
			Log.log("....file:" + file.getName());
		});
	}
	
	public static void main(String[] args) {
		ExcelReadController.call(new ExcelReadLoopController());
	}
}
