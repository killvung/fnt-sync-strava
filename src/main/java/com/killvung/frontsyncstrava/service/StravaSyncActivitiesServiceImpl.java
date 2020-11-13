package com.killvung.frontsyncstrava.service;

import com.killvung.frontsyncstrava.dto.model.ActivityDto;
import com.killvung.frontsyncstrava.model.Activity;
import com.killvung.frontsyncstrava.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StravaSyncActivitiesServiceImpl implements StravaSyncActivitiesService {
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<ActivityDto> fetchActivities() {
		List<Activity> activities = activityRepository.findAll();
		System.out.println(activities.get(0).getDistance());
		return null;
	}
}
