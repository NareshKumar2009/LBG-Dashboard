package com.nareshkumar.LBGDashboard.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/lbg")
@Api(value="LBG Kanban Dashboard", description= "Displays LBG Dashboard ")
public class KanbanDashboard {
	
	@ApiOperation(value = "Displays Backlogs of All Existing Projects")
	@ApiResponses(
			value = {
					@ApiResponse(code = 100, message="Response Code 100"),
					@ApiResponse(code = 150, message="Response Code 150")
			})
	@GetMapping
	public List<Backlog> getBacklogItemsForAllProjects()
	{
		return Arrays.asList(new Backlog("KnightRiders", 1101L,"Allow 30% discount for all Premium Customers")
				,new Backlog("SunRisers", 2201L,"Update Customers Address and Validate Shipping Address")
				,new Backlog("Cards Team", 3301L,"Update Card Info"));
	}
	
	@ApiOperation(value = "Get BackLog Details")
	@ApiResponses(
			value = {
					@ApiResponse(code = 100, message="Response Code 100"),
					@ApiResponse(code = 150, message="Response Code 150")
			})
	@GetMapping("/{backlogId}")
	public Backlog getBacklogDetails(@PathVariable("backlogId") final Long  backlogId)
	{
		return getBacklogInfo(backlogId);
	}

	public Backlog getBacklogInfo(Long backlogId) {
	
		Backlog bklog = new Backlog();
		List<Backlog> bklogList = Arrays.asList(new Backlog("KnightRiders", 1101L,"Allow 30% discount for all Premium Customers")
				,new Backlog("SunRisers", 2201L,"Update Customers Address and Validate Shipping Address")
				,new Backlog("Cards Team", 3301L,"Update Card Info"));
		
		for(Backlog b1 : bklogList) {
			if(b1.getBacklogId().equals(backlogId)) {
				return b1;
			}
		}
		return bklog;
	}
	
	private class Backlog
	{
		@ApiModelProperty(notes = "Name of the Project")
		private String projectName;
		
		@ApiModelProperty(notes = "Backlog ID")
		private Long backlogId;
		
		@ApiModelProperty(notes = "Backlog Description")
		private String backlogDesc;
		
		public Backlog() {
		}

		public Backlog(String projectName, Long backlogId, String backlogDesc) {
			super();
			this.projectName = projectName;
			this.backlogId = backlogId;
			this.backlogDesc = backlogDesc;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public Long getBacklogId() {
			return backlogId;
		}

		public void setBacklogId(Long backlogId) {
			this.backlogId = backlogId;
		}

		public String getBacklogDesc() {
			return backlogDesc;
		}

		public void setBacklogDesc(String backlogDesc) {
			this.backlogDesc = backlogDesc;
		}
		
	}
	
}
