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
		String code = getCode("add", mathMap);
		Log.log("code:" + code);
	}
	
	/**
	 * 获取代码
	 * @param codeName
	 * @param codeMap
	 * @return
	 */
	private String getCode(String codeName, Map<String, String> codeMap) {
		for(String key:codeMap.keySet()) {
			if(key.indexOf(codeName) >= 0) {
				return codeMap.get(key);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Instruction instruction = new Instruction();
		instruction.init();
		Log.log("instruction...");
	}
}
