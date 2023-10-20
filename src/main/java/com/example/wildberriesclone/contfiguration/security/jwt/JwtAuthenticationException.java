package com.example.wildberriesclone.contfiguration.security.jwt;

import javax.naming.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
  public JwtAuthenticationException(String msg) {
    super(msg);
  }
}
