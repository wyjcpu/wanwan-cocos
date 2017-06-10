package org.wanwanframework.coco.lab;

import java.util.Timer;
import java.util.TimerTask;

import org.wanwanframework.coco.lab.excel.ExcelReadController;
import org.wanwanframework.coco.lab.excel.ExcelReadLoopController;
import org.wanwanframwork.file.core.FileController;

public class TimerController extends FileController<Timer> {

	public TimerController() {
		core = new Timer();
	}
	
	@Override
	protected void process() {
		core.schedule(new TimerTask() {
			
			@Override
			public void run() {
				ExcelReadController.call(new ExcelReadLoopController());
			}
		}, 0, 1000);
	}
	
	public static void main(String[] args) {
		TimerController.call(new TimerController());
	}
}
