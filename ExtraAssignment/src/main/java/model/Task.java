package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	public enum status_task {
		PENDING, INACTIVE, ACTIVE, DELETED, COMPLELETED;
	}

	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private int task_id;
	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getDetailTask() {
		return detailTask;
	}

	public void setDetailTask(String detailTask) {
		this.detailTask = detailTask;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	public status_task getStatus_task() {
		return status_task;
	}

	public void setStatus_task(status_task status_task) {
		this.status_task = status_task;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}



	private String detailTask;
	
	@Temporal(TemporalType.TIME)
	private Date duration;
	
	@ElementCollection
	private List<String> resources = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private status_task status_task;
	@Column(name = "image")
	private byte[] image;

	public Task() {

	}

	public Task(String detailTask, Date duration, List<String> resources, status_task inactive, byte[] image) {
		this.detailTask = detailTask;
		this.resources = resources;
		this.duration = duration;
		this.status_task = inactive;
		this.image = image;
	}

	

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", detailTask=" + detailTask + ", duration=" + duration + ", resources="
				+ resources + ", status_task=" + status_task + "]";
	}

}
