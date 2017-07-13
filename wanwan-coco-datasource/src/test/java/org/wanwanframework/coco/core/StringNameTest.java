package org.wanwanframework.coco.core;

import java.util.Properties;

import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.StringRefAddr;

import org.wanwanframwork.file.Log;

@SuppressWarnings("serial")
public class StringNameTest extends Reference{

	protected String vv;
	
	
	public StringNameTest(String className, RefAddr addr) {
		super(className, addr);
		vv= "123...";
	}

	public String getVV() {
		return "vv";
	}
	
	public static void main(String[] args) {
		RefAddr addr = new StringRefAddr("vv", "cc");
		Reference ref = (Reference) (new StringNameTest(StringNameTest.class.getName(), addr));
		Properties properties = new Properties();
		String propertyName = "vv";
		RefAddr ra = ref.get(propertyName);
		if (ra != null) {
			String propertyValue = ra.getContent().toString();
			Log.log(propertyValue);
			properties.setProperty(propertyName, propertyValue);
		}
		Log.log("end");
	}
}
