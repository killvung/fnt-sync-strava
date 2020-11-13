package com.killvung.frontsyncstrava.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.killvung.frontsyncstrava.dto.model.ActivityDto;
import com.killvung.frontsyncstrava.repository.ActivityRepository;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.JSON;
import io.swagger.client.api.ActivitiesApi;
import io.swagger.client.api.AthletesApi;
import io.swagger.client.model.SummaryActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Observable;

@Component
public class ActivityServiceImpl implements ActivityService {
	private final ActivityRepository activityRepository;

	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@Override
	public List<ActivityDto> fetchActivities() {
		// TODO: Move this to elsewhere
		ApiClient apiClient = new ApiClient();
//		apiClient.setAccessToken("");
		ActivitiesApi api = new ActivitiesApi(apiClient);
		try {
			// TODO: Follow examples to refactor mapping to mapper
			// https://github.com/khandelwal-arpit/springboot-starterkit/blob/master/src/main/java/com/starterkit/springboot/brs/service/BusReservationServiceImpl.java#L349
			// https://github.com/khandelwal-arpit/springboot-starterkit/blob/master/src/main/java/com/starterkit/springboot/brs/dto/mapper/TicketMapper.java
			Call call = api.getLoggedInAthleteActivitiesCall(null, null, null, null, null, null);
			Type localVarReturnType = (new TypeToken<JsonArray>() {}).getType();
			ApiResponse<JsonArray> a = api.getApiClient().execute(call, localVarReturnType);
			System.out.println(a.getData().get(0).getAsJsonObject().get("distance"));
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}
}
