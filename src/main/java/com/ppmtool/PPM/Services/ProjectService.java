package com.ppmtool.PPM.Services;


import com.ppmtool.PPM.Domain.Project;
import com.ppmtool.PPM.Exceptions.ProjectIdException;
import com.ppmtool.PPM.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateRepository(Project project){


        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toLowerCase());
            return  projectRepository.save(project);

        }catch(Exception e){

            throw new ProjectIdException("Project ID"+project.getProjectIdentifier().toUpperCase()+"Already Exists");


        }





    }


    public Project getProjectByProjectIdentifier(String identify){

        Project byProjectIdentifier = projectRepository.findByProjectIdentifier(identify.toLowerCase());
            System.out.println(byProjectIdentifier);
    return byProjectIdentifier;

    }



}
