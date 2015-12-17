package controllers;
import play.mvc.*;
import java.util.*;
import models.Project;
import models.Task;
public class Tasks extends Controller {
 public static void list(Long projectId) {
 notFoundIfNull(projectId);
 Project project = Project.findByProjectId(projectId);
 List<Task> tasks = Task.findAllByProjectId(projectId);
 render(project, tasks);
 }
 public static void create(Long projectId, String newTask) {
	 if(projectId == null || newTask == null || newTask.isEmpty()){
	 list(projectId);
	 } else {
	 Task task = new Task();
	 task.projectId = projectId;
	 task.task = newTask;
	 task.status = "";
	 task.createdDate = new Date();
	 task.updatedDate = new Date();
	 task.insert();
	 Project project = Project.findByProjectId(projectId);
	 project.checkedTask = Task.getCountCheckedTaskByProjectId(projectId);
	 project.allTask = Task.getCountAllTaskByProjectId(projectId);
	 project.updatedDate = new Date();
	 project.update();
	 list(projectId);
	 }
	 }
 public static void edit(Long projectId, Long taskId, String status) {
 Task task = Task.findByTaskId(taskId);
 task.status = status;
 task.updatedDate = new Date();
 task.update();
 Project project = Project.findByProjectId(projectId);
 project.checkedTask = Task.getCountCheckedTaskByProjectId(projectId);
 project.allTask = Task.getCountAllTaskByProjectId(projectId);
 project.updatedDate = new Date();
 project.update();
 list(projectId);
 }
 public static void delete(Long projectId, Long taskId) {
	 notFoundIfNull(taskId);
	 int deleteTask = Task.deleteByTaskId(taskId);
	 Project project = Project.findByProjectId(projectId);
	 project.checkedTask = Task.getCountCheckedTaskByProjectId(projectId);
	 project.allTask = Task.getCountAllTaskByProjectId(projectId);
	 project.update();
	 list(projectId);
	 }
}