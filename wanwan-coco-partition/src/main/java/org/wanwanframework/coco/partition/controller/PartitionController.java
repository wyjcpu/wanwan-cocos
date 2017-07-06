package org.wanwanframework.coco.partition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PartitionController {

    @RequestMapping(value="/",method=RequestMethod.GET)
    @ResponseBody
	public String getId() {
		return "hehe...";
	}
}
