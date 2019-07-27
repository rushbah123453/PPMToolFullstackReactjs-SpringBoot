package com.ppmtool.PPM.Repository;

import com.ppmtool.PPM.Domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository  extends CrudRepository<Project,Long> {

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}
