package lkwid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lkwid.entity.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project,Long> {	
}
