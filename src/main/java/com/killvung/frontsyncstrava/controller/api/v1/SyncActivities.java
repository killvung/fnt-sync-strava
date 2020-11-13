package com.killvung.frontsyncstrava.controller.api.v1;

import com.killvung.frontsyncstrava.dto.model.ActivityDto;
import com.killvung.frontsyncstrava.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sync")
public class SyncActivities {

	private final ActivityService activityService;

	@Autowired
	public SyncActivities(ActivityService activityService) {
		this.activityService = activityService;
	}

	@PostMapping("/activities")
	public void syncActivities(){
		List<ActivityDto> activities = activityService.fetchActivities();
	}
}
