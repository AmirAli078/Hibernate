package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Project {
	@Id
	private int pid;
	
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany(mappedBy="projects")
	private List<Empolyee> employee;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Empolyee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Empolyee> employee) {
		this.employee = employee;
	}

	public Project(int pid, String projectName, List<Empolyee> employee) {
		super();
		this.pid = pid;
		this.projectName = projectName;
		this.employee = employee;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
