package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	public enum StatusProject {
		PENDING, ACTIVE, INACTIVE, DELETED, COMPLELETED;
	}

	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private int project_id;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public StatusProject getStatusProject() {
		return statusProject;
	}

	public void setStatusProject(StatusProject statusProject) {
		this.statusProject = statusProject;
	}

	public List<String> getListBeneficiaries() {
		return listBeneficiaries;
	}

	public void setListBeneficiaries(List<String> listBeneficiaries) {
		this.listBeneficiaries = listBeneficiaries;
	}

	public Collection<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(Collection<Task> taskList) {
		this.taskList = taskList;
	}

	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private StatusProject statusProject;
	@ElementCollection
	private List<String> listBeneficiaries = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_Task")
	private Collection<Task> taskList = new ArrayList<>();

	public Project() {

	}

	public Project(String description, Date startDate, Date endDate, StatusProject statusProduct,
			List<String> listBeneficiaries) {
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statusProject = statusProduct;
		this.listBeneficiaries = listBeneficiaries;
	}

}
