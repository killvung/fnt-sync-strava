package com.killvung.frontsyncstrava.service;

import com.killvung.frontsyncstrava.dto.model.ActivityDto;

import java.util.List;

public interface StravaSyncActivitiesService {
	List<ActivityDto> fetchActivities();
}
