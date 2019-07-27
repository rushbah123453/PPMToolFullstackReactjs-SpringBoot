package com.ppmtool.PPM.Services;


import com.ppmtool.PPM.Domain.Project;
import com.ppmtool.PPM.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateRepository(Project project){
        return  projectRepository.save(project);
    }



}
