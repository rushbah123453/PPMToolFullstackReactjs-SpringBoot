package com.ppmtool.PPM.Repository;

import com.ppmtool.PPM.Domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository  extends CrudRepository<Project,Long> {


    Project findByProjectIdentifier (String identify);


    @Override
    Iterable<Project> findAll();

}
