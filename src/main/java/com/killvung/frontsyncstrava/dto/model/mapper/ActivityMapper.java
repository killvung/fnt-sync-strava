package com.killvung.frontsyncstrava.dto.model.mapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.killvung.frontsyncstrava.dto.model.ActivityDto;
import io.swagger.client.model.DetailedActivity;

import java.util.Date;

public class ActivityMapper {
	public static ActivityDto toActivityDtoFromJsonElement(JsonElement activity) {
		JsonObject element = activity.getAsJsonObject();
		return new ActivityDto()
				.setId(element.get("id").getAsLong())
				.setExternal_id(element.get("external_id").getAsString())
				.setUpload_id(element.get("upload_id").getAsLong())
				.setName(element.get("name").getAsString())
				.setDistance(element.get("distance").getAsFloat())
				.setMoving_time(element.get("moving_time").getAsInt())
				.setElapsed_time(element.get("elapsed_time").getAsInt())
				.setTotal_elevation_gain(element.get("total_elevation_gain").getAsFloat())
				.setElev_high(element.get("elev_high").getAsFloat())
				.setElev_low(element.get("elev_low").getAsFloat())
				.setStart_date(element.get("start_date").getAsString())
				.setStart_date_local(element.get("start_date_local").getAsString())
				.setTimezone(element.get("timezone").getAsString())
				.setAverage_speed(element.get("average_speed").getAsFloat())
				.setMax_speed(element.get("max_speed").getAsFloat());
	}
}
