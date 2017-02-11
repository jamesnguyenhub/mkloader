package com.tuyenmonkey.mkloader.exception;

/**
 * Created by Tuyen Nguyen on 2/11/17.
 */

public class InvalidNumberOfCircleException extends Exception {

  @Override public String getMessage() {
    return "Number of circle must be 8";
  }
}
