package org.wanwanframework.coco.partition;

import org.wanwanframwork.file.core.FileController;

public class PartitionController extends FileController<String>{

	public PartitionController() {

	}
	
	@Override
	protected void process() {
		content = "...vvv...";
	}
	
	public static void main(String[] args) {
		PartitionController.call(new PartitionController());
	}
}
