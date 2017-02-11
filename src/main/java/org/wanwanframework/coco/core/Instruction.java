package org.wanwanframework.coco.core;

import java.util.Map;

import org.wanwanframework.file.map.LineTool;
import org.wanwanframwork.file.Log;

/**
 * 原子指令
 * @author coco
 *
 */
public class Instruction {

	private Map<String, String>[] configs;
	
	public Instruction() {
		Map<String, String> url = LineTool.getLine("./src/main/resources/instruction/config.txt", ":\t");
		configs = LineTool.getConfigs(url.get("url"), ":\t");
	}
	
	public void init() {
		for(int i = 0; i < configs.length; i++) {
			readConfig(configs[i]);
		}
	}
	
	private void readConfig(Map<String, String> config) {
		String path = config.get("math");
		Map<String, String> mathMap = LineTool.getLine(path, ":\r\n");
		Log.log(mathMap);
	}
	
	public static void main(String[] args) {
		Instruction instruction = new Instruction();
		instruction.init();
		Log.log("instruction...");
	}
}
