package ga.linuxcafe.pms.projects.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ga.linuxcafe.pms.parameters.models.PercentComplete;
import ga.linuxcafe.pms.parameters.models.ProjectStage;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProjectStatusDummy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne(mappedBy="projectStatus")
    @JsonIgnore
    private Project project;

    @ManyToOne
    @JoinColumn(name="percentcompleteid", insertable=false, updatable=false)
    private PercentComplete percentComplete;
    private Integer percentcompleteid;

    @ManyToOne
    @JoinColumn(name="projectstageid", insertable=false, updatable=false)
    private ProjectStage projectStage;
    private Integer projectstageid;

    public ProjectStatusDummy() {
    }

    public ProjectStatusDummy(int id, Project project, PercentComplete percentComplete, Integer percentcompleteid, ProjectStage projectStage, Integer projectstageid) {
        this.id = id;
        this.project = project;
        this.percentComplete = percentComplete;
        this.percentcompleteid = percentcompleteid;
        this.projectStage = projectStage;
        this.projectstageid = projectstageid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public PercentComplete getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(PercentComplete percentComplete) {
        this.percentComplete = percentComplete;
    }

    public Integer getPercentcompleteid() {
        return percentcompleteid;
    }

    public void setPercentcompleteid(Integer percentcompleteid) {
        this.percentcompleteid = percentcompleteid;
    }

    public ProjectStage getProjectStage() {
        return projectStage;
    }

    public void setProjectStage(ProjectStage projectStage) {
        this.projectStage = projectStage;
    }

    public Integer getProjectstageid() {
        return projectstageid;
    }

    public void setProjectstageid(Integer projectstageid) {
        this.projectstageid = projectstageid;
    }
}
