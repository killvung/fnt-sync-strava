package com.killvung.frontsyncstrava.dto.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

	private Status status;
	private T payload;
	private Object metadata;

	public static <T> Response<T> ok() {
		Response<T> response = new Response<>();
		response.setStatus(Status.OK);
		return response;
	}

	public enum Status { OK }

	@Getter
	@Accessors(chain = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PageMetadata {
		private final int size;
		private final long totalElements;
		private final int totalPages;
		private final int number;

		public PageMetadata(int size, long totalElements, int totalPages, int number) {
			this.size = size;
			this.totalElements = totalElements;
			this.totalPages = totalPages;
			this.number = number;
		}
	}
}
