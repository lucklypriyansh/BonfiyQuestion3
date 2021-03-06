package com.bonify3.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bonfiy3.main.constant.DataTypeFactory;
import com.bonfiy3.main.constant.DataTypesEnum;

@RestController
public class MainController {

	@Autowired
	ApplicationContext appx;

	@Autowired
	DataTypeFactory factory;

	@GetMapping("/executedsl/{dsltype}")
	public String executeDsl(@PathVariable("dsltype") String dsltype) {
		if (DataTypesEnum.findbyName(dsltype) != null) {
			return factory.getDataType(DataTypesEnum.findbyName(dsltype)).process();
		}
		return dsltype;

	}

}
