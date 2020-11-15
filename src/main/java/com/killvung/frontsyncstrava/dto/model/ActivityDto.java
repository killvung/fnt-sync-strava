package com.killvung.frontsyncstrava.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityDto {
	private Long id;
	private String external_id;
	private Long upload_id;
	private String name;
	private Float distance;
	private Integer moving_time;
	private Integer elapsed_time;
	private Float total_elevation_gain;
	private Float elev_high;
	private Float elev_low;
	private String start_date;
	private String start_date_local;
	private String timezone;
	private Float average_speed;
	private Float max_speed;
}
