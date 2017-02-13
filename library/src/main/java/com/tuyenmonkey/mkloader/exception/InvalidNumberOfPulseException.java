package com.tuyenmonkey.mkloader.exception;

/**
 * Created by Tuyen Nguyen on 2/12/17.
 */

public class InvalidNumberOfPulseException extends Exception {

  @Override public String getMessage() {
    return "The number of pulse must be between 2 and 6";
  }
}
