package com.killvung.frontsyncstrava.controller.api.v1;

import com.killvung.frontsyncstrava.service.StravaSyncActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sync")
public class SyncActivities {

	private final StravaSyncActivitiesService stravaSyncActivitiesService;

	@Autowired
	public SyncActivities(StravaSyncActivitiesService stravaSyncActivitiesService) {
		this.stravaSyncActivitiesService = stravaSyncActivitiesService;
	}

	@PostMapping("/activities")
	public void syncActivities(){
		stravaSyncActivitiesService.fetchActivities();
	}
}
