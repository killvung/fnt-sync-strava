package com.killvung.frontsyncstrava.service;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.killvung.frontsyncstrava.dto.model.ActivityDto;
import com.killvung.frontsyncstrava.dto.model.mapper.ActivityMapper;
import com.killvung.frontsyncstrava.exception.ApplicationException;
import com.killvung.frontsyncstrava.model.Activity;
import com.killvung.frontsyncstrava.repository.ActivityRepository;
import com.squareup.okhttp.Call;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.api.ActivitiesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityServiceImpl implements ActivityService {
	Type localVarReturnType = (new TypeToken<List<JsonElement>>() {}).getType();
	private final ActivitiesApi activitiesApi;
	private final ActivityRepository activityRepository;

	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository, ActivitiesApi activitiesApi) {
		this.activityRepository = activityRepository;
		this.activitiesApi = activitiesApi;
	}

	@Override
	public List<ActivityDto> fetchActivities() {
		try {
			Call call = activitiesApi.getLoggedInAthleteActivitiesCall(null, null, null, 200, null, null);
			ApiResponse<List<JsonElement>> response = activitiesApi.getApiClient().execute(call, localVarReturnType);
			return response.getData().stream().map(ActivityMapper::toActivityDtoFromJsonElement).collect(Collectors.toList());
		} catch (ApiException e) {
			throw exception("Error occurred while calling ActivitiesApi from Strava" + "\nMessage: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public List<ActivityDto> saveActivities(List<ActivityDto> activityDtos){
		List<Activity> activities = activityDtos.stream().map((activityDto) -> (
				new Activity()
						.setId(activityDto.getId())
						.setExternal_id(activityDto.getExternal_id())
						.setName(activityDto.getName())
						.setDistance(activityDto.getDistance())
						.setMoving_time(activityDto.getMoving_time())
						.setElapsed_time(activityDto.getElapsed_time())
						.setTotal_elevation_gain(activityDto.getTotal_elevation_gain())
						.setElev_high(activityDto.getElev_high())
						.setElev_low(activityDto.getElev_low())
						.setStart_date(activityDto.getStart_date())
						.setStart_date_local(activityDto.getStart_date_local())
						.setTimezone(activityDto.getTimezone())
						.setAverage_speed(activityDto.getAverage_speed())
						.setMax_speed(activityDto.getMax_speed())
		)).collect(Collectors.toList());
		activityRepository.saveAll(activities);
		return activityDtos;
	}

	private RuntimeException exception(String message) {
		return ApplicationException.throwException(message);
	}
}
