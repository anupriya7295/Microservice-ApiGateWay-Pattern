/**
 * ****************************************************************************
 * Copyright ©2002-2018 Skava - All rights reserved.
 *
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof,
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *
 * For further information contact Skava at info@skava.com.
 * ****************************************************************************
 */
package com.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class GateWayFilter extends ZuulFilter {
  
  private static Logger log = LoggerFactory.getLogger(GateWayFilter.class);

  @Override
  public String filterType() {
      return "pre";
  }

  @Override
  public int filterOrder() {
      return 1;
  }

  @Override
  public boolean shouldFilter() {
      return true;
  }

  @Override
  public Object run() {
      RequestContext ctx = RequestContext.getCurrentContext();
      HttpServletRequest request = ctx.getRequest();

      log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

      return null;
  }

}
