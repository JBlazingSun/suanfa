package com.blazings.suanfa.springboot.springmvc.config.exception;

import lombok.Data;

@Data
public class RestfulErrorTest extends RuntimeException {

  String id;

  public RestfulErrorTest(String message, String id) {
    super(message);
    this.id = id;
  }
}