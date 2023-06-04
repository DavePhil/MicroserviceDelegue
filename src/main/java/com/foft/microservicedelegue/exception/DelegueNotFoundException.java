package com.foft.microservicedelegue.exception;

 import org.springframework.web.bind.annotation.ResponseStatus;
 import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DelegueNotFoundException extends RuntimeException {
  public DelegueNotFoundException(String message) {
      super(message);
  }
}