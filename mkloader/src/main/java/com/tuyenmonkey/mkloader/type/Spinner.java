package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.model.Circle;

/**
 * Created by Tuyen Nguyen on 2/10/17.
 */

public class Spinner extends LoaderView {
  private Circle[] circles;
  private int circlesSize;
  private PointF center;

  public Spinner() {
    circlesSize = 8;
  }

  @Override public void compute() {
    center = new PointF(width / 2.0f, height / 2.0f);

    initializeCircles(this.color, this.width, this.height);
    startAnimation();
  }

  @Override public void draw(Canvas canvas) {
    for (int i = 0; i < circles.length; i++) {
      canvas.save();
      canvas.rotate(45 * i, center.x, center.y);
      circles[i].draw(canvas);
      canvas.restore();
    }
  }

  @Override public int getDesiredWidth() {
    return 300;
  }

  @Override public int getDesiredHeight() {
    return 300;
  }

  private void initializeCircles(int color, int width, int height) {
    final float size = Math.min(width, height);
    final float circleRadius = size / 10.0f;
    circles = new Circle[circlesSize];

    for (int i = 0; i < circlesSize; i++) {
      circles[i] = new Circle();
      circles[i].setCenter(center.x, circleRadius);
      circles[i].setColor(color);
      circles[i].setAlpha(126);
      circles[i].setRadius(circleRadius);
    }
  }

  private void startAnimation() {
    int[] delayTimes = new int[]{0, 120, 240, 360, 480, 600, 720, 840};

    for (int i = 0; i < circlesSize; i++) {
      final int index = i;

      ValueAnimator fadeAnimator = ValueAnimator.ofInt(126, 255, 126);
      fadeAnimator.setRepeatCount(ValueAnimator.INFINITE);
      fadeAnimator.setDuration(1000);
      fadeAnimator.setStartDelay(delayTimes[i]);
      fadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          circles[index].setAlpha((int)animation.getAnimatedValue());
          invalidateListener.reDraw();
        }
      });

      fadeAnimator.start();
    }
  }
}
