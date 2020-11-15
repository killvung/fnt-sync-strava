package com.killvung.frontsyncstrava.service;

import com.killvung.frontsyncstrava.dto.model.ActivityDto;

import java.util.List;

public interface ActivityService {
	List<ActivityDto> fetchActivities();
	ActivityDto saveActivity(ActivityDto activity);
	ActivityDto updateActivity(ActivityDto activity);
}
