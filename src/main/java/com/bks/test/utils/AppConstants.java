package com.bks.test.utils;

import org.springframework.stereotype.Component;

@Component
public final class AppConstants {
	public static final String USER_REST_CONTROLLER_MAPPING = "/user";

	public static final String BY_ID = "/{id}";

	public static final String EMAIL_DATA = "/email";

	public static final String PHONE_DATA = "/phone";

	private AppConstants() {
	}
}
