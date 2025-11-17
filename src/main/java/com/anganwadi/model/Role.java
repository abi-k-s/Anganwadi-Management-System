package com.anganwadi.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	TEACHER, ASSISTANT;

	@Override
	public String getAuthority() {
		return name();
	}
}
