package org.wanwanframework.coco.lab;

import java.util.Timer;
import java.util.TimerTask;

import org.wanwanframwork.file.Log;
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
				Log.log("...vvvv...");
			}
		}, 0, 1000);
	}
	
	public static void main(String[] args) {
		TimerController.call(new TimerController());
	}
}
