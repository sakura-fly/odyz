package com.odyz.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odyz.model.AdminModel;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(value="/login",method=POST)
	public void lgoin(@Validated AdminModel u, Errors e, PrintWriter out){
		
	}
}
