package org.wanwanframework.coco;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.LinkedMap;
import org.wanwanframework.coco.lab.set.HashedMap;

public class MapTest {

	private Map<String, String> map = new HashMap<>();
	private Map<String, String> map2 = new LinkedMap<>();
	
	public static void main(String[] args) {
		HashedMap<String, String> map = new HashedMap<>();
		map.put("vv", "123");
		System.out.println(map.get("vv"));
	}
}
