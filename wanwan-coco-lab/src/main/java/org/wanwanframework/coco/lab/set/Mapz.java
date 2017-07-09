package org.wanwanframework.coco.lab.set;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现的一个简单map
 * @author coco
 *
 * @param <K>
 * @param <V>
 */
public class Mapz<K, V> {

	private List<KeyValue<K, V>> list = new ArrayList<>();
	private List<K> keySet = new ArrayList<>();
	
	private V v;
	
	public Mapz() {

	}
	
	public void put(K key, V value) {
		KeyValue<K, V> keyValue = new KeyValue<>();
		keyValue.setKey(key);
		keyValue.setValue(value);
		list.add(keyValue);
		keySet.add(key);
	}
	
	public V get(K key) {
		list.forEach(keyValue -> {
			if(keyValue.getKey().equals(key)) {
				v = keyValue.getValue();
			}
		});
		return v;
	}

	public List<K> getKeySet() {
		return keySet;
	}

	public void setKeySet(List<K> keySet) {
		this.keySet = keySet;
	}

	public static void main(String[] args) {
		Mapz<String, String> map = new Mapz<String, String>();
		map.put("hahah", "2333........");
		System.out.println(map.get("hahah"));
	}
}
