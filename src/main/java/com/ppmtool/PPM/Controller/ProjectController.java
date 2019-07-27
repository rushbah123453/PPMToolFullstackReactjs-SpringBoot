package com.ppmtool.PPM.Controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ppmtool.PPM.Domain.Project;
import com.ppmtool.PPM.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/project",consumes = "application/json")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {

            Map<String,String> errorMap=new HashMap<>();

            for(FieldError field:bindingResult.getFieldErrors()){

                errorMap.put(field.getField(),field.getDefaultMessage());

            }

            return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
        }
        Project project1=projectService.saveOrUpdateRepository(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }


}
