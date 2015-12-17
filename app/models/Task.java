package models;
import java.util.Date;
import java.util.List;
import siena.*;
public class Task extends Model {
 @Id(Generator.AUTO_INCREMENT)
 public Long taskId;
 @Column("projectId") @NotNull
 public Long projectId;
 @Column("task") @NotNull
 public String task;
 @Column("status") @NotNull
 public String status;
 @Column("createdDate") @NotNull
 public Date createdDate;
 @Column("updatedDate") @NotNull
 public Date updatedDate;
 public static Query<Task> all() {
	 return Model.all(Task.class);
	 }
	 public static List<Task> findAll() {
	 return all().fetch();
	 }
	 public static int getCountAllTaskByProjectId(Long projectId) {
	 return all().filter("projectId", projectId).count();
	 }
	 public static int getCountCheckedTaskByProjectId(Long projectId) {
	 return all().filter("projectId", projectId).filter("status", "checked").count();
	 }
	 public static Task findByTaskId(Long taskId) {
	 return all().filter("taskId", taskId).get();
	 }
	 public static List<Task> findAllByProjectId(Long projectId) {
		 return all().filter("projectId", projectId).order("createdDate").fetch();
		 }
		 public static int deleteByTaskId(Long taskId) {
		 return all().filter("taskId", taskId).delete();
		 }
		 public static int deleteAllByProjectId(Long projectId) {
		 return all().filter("projectId", projectId).delete();
		 }
		}
