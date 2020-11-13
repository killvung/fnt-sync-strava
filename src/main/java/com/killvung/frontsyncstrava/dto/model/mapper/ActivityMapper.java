package com.killvung.frontsyncstrava.dto.model.mapper;

import com.killvung.frontsyncstrava.dto.model.ActivityDto;
import io.swagger.client.model.DetailedActivity;

public class ActivityMapper {
	public static ActivityDto toActivityDtoFromDetailedActivity(DetailedActivity detailedActivity) {
		return new ActivityDto().setDistance(detailedActivity.getDistance());
	}
}
