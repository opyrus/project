package models;
import java.util.Date;
import java.util.List;
import siena.*;
public class Project extends Model {
 @Id(Generator.AUTO_INCREMENT)
 public Long projectId;
 @Column("projectName") @NotNull
 public String projectName;
 @Column("checkedTask") @NotNull
 public int checkedTask;
 @Column("allTask") @NotNull
 public int allTask;
@Column("createdDate") @NotNull
 public Date createdDate;
 @Column("updatedDate") @NotNull
 public Date updatedDate;
 public static Query<Project> all() {
 return Model.all(Project.class);
 }
 public static List<Project> findAll() {
 return all().order("createdDate").fetch();
 }
 public static Project findByProjectId(Long projectId) {
 return all().filter("projectId", projectId).get();
 }
 public static int deleteByProjectId(Long projectId) {
 return all().filter("projectId", projectId).delete();
 }
}