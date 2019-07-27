package com.ppmtool.PPM.Controller;

import com.ppmtool.PPM.Domain.Project;
import com.ppmtool.PPM.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){

        Project project1=projectService.saveOrUpdateRepository(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

}
