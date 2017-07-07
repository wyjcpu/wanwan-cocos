package org.wanwanframework.coco.partition.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wanwanframework.coco.partition.persistent.DataIdDao;

@Controller
public class PartitionController {

	@Resource
	private DataIdDao dao;
	
    @RequestMapping(value="/",method=RequestMethod.GET)
    @ResponseBody
	public String getId() {
		return "getId:" + dao.getDataId();
	}
}
