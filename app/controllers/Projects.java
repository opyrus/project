package controllers;
import play.mvc.*;
import java.util.Date;
import java.util.List;
import models.*;
public class Projects extends Controller {
 public static void index() {
 list();
 }
 public static void list() {
	 List<Project> projects = Project.findAll();
	 render(projects);
 }
 public static void create(String projectName) {
 if(projectName == null || projectName.isEmpty()){
 render();
 } else {
 Project project = new Project();
 project.projectName = projectName;
 project.checkedTask = 0;
 project.allTask = 0;
 project.createdDate = new Date();
 project.updatedDate = new Date();
 project.insert();
 list();
 }
 }
 public static void edit(Long projectId, String
		 projectName) {
		  notFoundIfNull(projectId);
		  Project project = Project.findByProjectId(projectId);
		  if(projectName == null || projectName.isEmpty()) {
		  render(project);
		  } else {
		  project.projectName = projectName;
		  project.updatedDate = new Date();
		  project.update();
		  list();
		  }
		  }
 public static void delete(Long projectId) {
 notFoundIfNull(projectId);
 int deleteProject = Project.deleteByProjectId(projectId);
 list();
 }
}
