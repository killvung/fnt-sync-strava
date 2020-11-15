package com.killvung.frontsyncstrava.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "activities")
public class Activity {
	@Id
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
