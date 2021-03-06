package lkwid.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lkwid.bean.ProjectApi;
import lkwid.dao.ProjectDao;
import lkwid.entity.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public Collection<Project> getAllProjects() {
		List<Project> projects = (List<Project>) projectDao.findAll();
		projects.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		return projects;
	}

	public Project getProject(long id) {
		return projectDao.findOne(id);
	}

	public ProjectApi printProject(long id) {
		return new ProjectApi(getProject(id));
	}

	public List<Project> getOpenProjects() {
		List<Project> openProjects = new ArrayList<>();
		for (Project p : projectDao.findAll()) {
			if (!p.isClosed())
				openProjects.add(p);
		}
		return openProjects;
	}

	public void changeProjectStatus(long id) {
		Project project = getProject(id);
		if (project.isClosed())
			System.out.println("Project already closed");
		else
			project.setClosed(true);
		projectDao.save(project);
	}

}
