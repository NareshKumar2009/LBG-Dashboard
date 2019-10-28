package com.nareshkumar.LBGDashboard.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/myproject")
@Api(value="Project Naresh Kanban Dashboard", description= "Project Naresh's Dashboard ")
public class MyProjectKanban {
	
	@ApiOperation(value = "Fetches All the Tasks")
	@ApiResponses(
			value = {
					@ApiResponse(code = 100, message="Response Code 100"),
					@ApiResponse(code = 150, message="Response Code 150")
			})
	@GetMapping
	public List<Task> getListofTasks()
	{
		return Arrays.asList(new Task(111,"Description for Task111","Product Owner","NONE",Status.BACKLOG)
				,new Task(222,"Description for Task222","Product Owner","NONE",Status.BACKLOG)
				,new Task(333,"Description for Task333","Product Owner","Naresh Kumar",Status.WIP)
				,new Task(444,"Description for Task444","Product Owner","Sean Kroah",Status.COMPLETED)
				,new Task(555,"Description for Task555","Product Owner","Naresh Kumar",Status.COMPLETED)
				,new Task(666,"Description for Task666","Product Owner","Sean Kroah",Status.WIP));
	}
	
	@ApiOperation(value = "Gets Task Assigned to a User")
	@ApiResponses(
			value = {
					@ApiResponse(code = 100, message="Response Code 100"),
					@ApiResponse(code = 150, message="Response Code 150")
			})
	@GetMapping("/{userName}")
	public List<Task> getTask(@PathVariable("userName") final String  userName)
	{
		List<Task> tasksList = getListofTasks();
		
		List<Task> userTasks = new ArrayList<MyProjectKanban.Task>();
		
		for(Task t1 : tasksList) {
			if(t1.getAssignedTo().equals(userName)) {
				userTasks.add(t1);
			}
		}
		return userTasks;
	}

	public Task getTaskinfo(int taskId) {
	
		List<Task> tasksList = getListofTasks();
		
		for(Task t1 : tasksList) {
			if(t1.getTaskId() == taskId) {
				return t1;
			}
		}
		return new Task();
	}
	enum Status{
		BACKLOG,WIP,COMPLETED;
	}
	
	private class Task{

		private int taskId;
		private String taskDesc;
		private String taskCreatedBy;
		private String assignedTo;
		private Status status;
		public Task(int taskId, String taskDesc, String taskCreatedBy, String assignedTo, Status status) {
			this.taskId = taskId;
			this.taskDesc = taskDesc;
			this.taskCreatedBy = taskCreatedBy;
			this.assignedTo = assignedTo;
			this.status = status;
		}
		public Task() {
		}
		public int getTaskId() {
			return taskId;
		}
		public void setTaskId(int taskId) {
			this.taskId = taskId;
		}
		public String getTaskDesc() {
			return taskDesc;
		}
		public void setTaskDesc(String taskDesc) {
			this.taskDesc = taskDesc;
		}
		public String getTaskCreatedBy() {
			return taskCreatedBy;
		}
		public void setTaskCreatedBy(String taskCreatedBy) {
			this.taskCreatedBy = taskCreatedBy;
		}
		public String getAssignedTo() {
			return assignedTo;
		}
		public void setAssignedTo(String assignedTo) {
			this.assignedTo = assignedTo;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		
		
		
		
	}
	
}
