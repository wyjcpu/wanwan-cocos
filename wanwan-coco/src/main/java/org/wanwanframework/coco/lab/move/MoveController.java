package org.wanwanframework.coco.lab.move;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.wanwanframwork.file.core.FileController;

public class MoveController extends FileController<List<File>>{

	protected List<File> list = new ArrayList<File>();
	
	public MoveController() {

	}
	
	@Override
	protected void process() {
		core = getFile(list, new File("./src/main/resources/config"));
		content = core.toString();
	}
	
	protected List<File> getFile(List<File> list, File dirPath) {
		File[] files = dirPath.listFiles(file -> file.isFile()? true : false);
		list.addAll(Arrays.asList(files));
		File[] nodeDirs = dirPath.listFiles(file -> file.isFile()? false : true);
		Arrays.asList(nodeDirs).stream().forEach(file ->{
			getFile(list, file);
		});
		return list;
	}
	
	public static void main(String[] args) {
		MoveController.call(new MoveController());
	}
}
