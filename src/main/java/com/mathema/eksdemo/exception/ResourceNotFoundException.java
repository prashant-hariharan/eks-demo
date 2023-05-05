package com.mathema.eksdemo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceNotFoundException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = 5353555401274036513L;

  String message;
  Long resourceId;
  Throwable exception;

  public ResourceNotFoundException() {
    super();
  }

  public ResourceNotFoundException(String message, Throwable exception) {
    super(message, exception);
  }

  public ResourceNotFoundException(Object resourceId) {
    super("Resource not found for resource Id " + resourceId);
  }

}
