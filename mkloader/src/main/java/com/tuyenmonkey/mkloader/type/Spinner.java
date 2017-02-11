package com.tuyenmonkey.mkloader.type;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.exception.InvalidNumberOfCircleException;
import com.tuyenmonkey.mkloader.model.Circle;

/**
 * Created by Tuyen Nguyen on 2/10/17.
 */

public class Spinner extends LoaderView {
  private Circle[] circles;

  @Override public void calculatePosition() {
    try {
      initializeCircles(8, this.color, this.width, this.height);
    } catch (InvalidNumberOfCircleException ex) {
      ex.printStackTrace();
    }
  }

  @Override public void draw(Canvas canvas) {
    for (Circle circle : circles) {
      circle.draw(canvas);
    }
  }

  private void initializeCircles(int numberOfCircle, int color, int width, int height) throws InvalidNumberOfCircleException {
    if (numberOfCircle != 8) {
      throw new InvalidNumberOfCircleException();
    }

    final float size = Math.min(width, height);
    final float circleRadius = size / 10.0f;
    final PointF center = new PointF(width / 2.0f, height / 2.0f);
    final float spinnerRadius = size / 2.0f - circleRadius;
    final float d = (float)Math.pow(2, 1.0 / 2);
    circles = new Circle[numberOfCircle];

    for (int i = 0; i < numberOfCircle; i++) {
      circles[i] = new Circle();
      circles[i].setAlpha(1);
      circles[i].setColor(color);
      circles[i].setRadius(circleRadius);
    }

    circles[0].setCenter(center.x, circleRadius);
    circles[1].setCenter(center.x + spinnerRadius / d, center.y - spinnerRadius / d);
    circles[2].setCenter(center.x + spinnerRadius, center.y);
    circles[3].setCenter(center.x + spinnerRadius / d, center.y + spinnerRadius / d);
    circles[4].setCenter(center.x, center.y + spinnerRadius);
    circles[5].setCenter(center.x - spinnerRadius / d, center.y + spinnerRadius / d);
    circles[6].setCenter(circleRadius, center.y);
    circles[7].setCenter(center.x - spinnerRadius / d, center.y - spinnerRadius / d);
  }
}
