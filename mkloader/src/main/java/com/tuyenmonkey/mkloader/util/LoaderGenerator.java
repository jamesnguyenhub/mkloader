package com.tuyenmonkey.mkloader.util;

import com.tuyenmonkey.mkloader.exception.InvalidNumberOfPulseException;
import com.tuyenmonkey.mkloader.type.ClassicSpinner;
import com.tuyenmonkey.mkloader.type.FishSpinner;
import com.tuyenmonkey.mkloader.type.LineSpinner;
import com.tuyenmonkey.mkloader.type.LoaderView;
import com.tuyenmonkey.mkloader.type.Pulse;
import com.tuyenmonkey.mkloader.type.Radar;
import com.tuyenmonkey.mkloader.type.TwinFishesSpinner;
import com.tuyenmonkey.mkloader.type.Whirlpool;
import com.tuyenmonkey.mkloader.type.Worm;

/**
 * Created by Tuyen Nguyen on 2/13/17.
 */

public class LoaderGenerator {

  public static LoaderView generateLoaderView(int type) {
    switch (type) {
      case 0:
        return new ClassicSpinner();
      case 1:
        return new FishSpinner();
      case 2:
        return new LineSpinner();
      case 3:
        try {
          return new Pulse(3);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case 4:
        try {
          return new Pulse(4);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case 5:
        try {
          return new Pulse(5);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case 6:
        return new Radar();
      case 7:
        return new TwinFishesSpinner();
      case 8:
        return new Worm();
      case 9:
        return new Whirlpool();
      default:
        return new ClassicSpinner();
    }
  }
}
