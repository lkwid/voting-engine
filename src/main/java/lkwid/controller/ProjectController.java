package lkwid.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lkwid.bean.ProjectApi;
import lkwid.entity.Project;
import lkwid.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public Collection<Project> showAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping("/{id}")
	public ProjectApi showProject(@PathVariable("id") long id) {
		return projectService.printProject(id);
	}
	
	@PatchMapping("/{id}")
	public void changeStatus(@PathVariable("id") long id) {
		projectService.changeProjectStatus(id);
	}	

}
