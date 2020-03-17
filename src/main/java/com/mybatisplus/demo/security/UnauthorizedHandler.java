package com.mybatisplus.demo.security;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint, Serializable {

  private static final long serialVersionUID = 3798723588865329956L;

  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException {
    // 因为我们是REST接口，后台不能直接跳转到login页面。
    // 因此直接返回401，前端或移动端可以根据Status Code跳转
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "没有权限");
  }
}
