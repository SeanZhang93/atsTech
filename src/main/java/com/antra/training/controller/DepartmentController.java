package com.antra.training.controller;

import com.antra.training.model.Department;
//import com.antra.training.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

@RestController
public class DepartmentController {

   // @Autowired
    //private DepartmentService departmentService;
//
  //  private Logger logger = LoggerFactory.getLogger(getClass());

    private Logger logger = LoggerFactory.getLogger(getClass());
    //@Autowired
    //private DepartmentService departmentService;  --add back


    @RequestMapping(value = "/department", method = RequestMethod.GET)
   // public List<Department> getDepartments(){
        //return departmentService.getDepartments();
    public void getDepartments(){
        logger.info("I am in with Logger");

        System.out.println("I'm here");
    }

//    @RequestMapping(value = "department/{Id}", method = RequestMethod.GET)
//    public void getDepartmentById(@PathVariable(name = "Id") Long id){
//        logger.debug("I am in the department controller get by" +id);
//        return departmentService.findById(Id);
//    }



}
