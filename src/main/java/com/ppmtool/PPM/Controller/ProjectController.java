package com.ppmtool.PPM.Controller;

import com.ppmtool.PPM.Domain.Project;
import com.ppmtool.PPM.Services.MapValidationError;
import com.ppmtool.PPM.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/project",consumes = "application/json")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationError mapValidationError;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bindingResult){


        ResponseEntity<?> errorMap=mapValidationError.mapValidationError(bindingResult);
        if(errorMap!=null)
            return errorMap;
        Project project1=projectService.saveOrUpdateRepository(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }


    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier){

        System.out.println("projid"+projectIdentifier);
        Project projectByProjectIdentifier = projectService.getProjectByProjectIdentifier(projectIdentifier);
        return new ResponseEntity<>(projectByProjectIdentifier,HttpStatus.OK);



    }

    @GetMapping("/all")
    public Iterable<Project> getAllProject(){

        return projectService.getAllProject();
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllProject(){
        projectService.delleteAllProject();
        return new ResponseEntity<String>("Deleted all project", HttpStatus.OK);
    }

    @DeleteMapping("/{projectIdentifier}")
    public ResponseEntity<String> deletebyProjectIdentifier(@PathVariable String projectIdentifier){

projectService.deleteProjectByIdentifier(projectIdentifier);
        return new ResponseEntity<String>("Deleted  project " +projectIdentifier, HttpStatus.OK);
    }


}
