package org.springframework.samples.controller;

import org.springframework.stereotype.Component;

@Component
public class MockAuthenticator implements Authenticator {

	@Override
	public void authenticate(String id, String password) {
		if (!id.equals("madvirus")) {
			throw new AuthenticationException("invalid id "+id);
		}
	}

}
