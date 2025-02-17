package io.penguinstats.api.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import io.penguinstats.api.filter.annotation.ReadUserIDCookie;
import io.penguinstats.util.APIUtil;

@ReadUserIDCookie
public class ReadUserIDCookieFilter implements ContainerRequestFilter {

	@Context
	private HttpServletRequest request;
	@Context
	private HttpHeaders headers;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		APIUtil.setUserIDInSession(request, APIUtil.getUserIDFromCookies(request, headers));
	}

}
