package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import com.tuyenmonkey.mkloader.model.Circle;

/**
 * Created by Tuyen Nguyen on 2/12/17.
 */

public class Worm extends LoaderView {
  private Circle[] circles;
  private int circlesSize;
  private float radius;
  private int[] transformations;

  public Worm() {
    circlesSize = 5;
    transformations = new int[]{-2, -1, 0, 1, 2};
  }

  @Override public void initializeObjects() {
    circles = new Circle[circlesSize];
    radius = width / 10f - width / 100f;

    for (int i = 0; i < circlesSize; i++) {
      circles[i] = new Circle();
      circles[i].setColor(color);
      circles[i].setRadius(radius);
      circles[i].setCenter(center.x, center.y);
    }
  }

  @Override public void setUpAnimation() {
    if(circles == null) return;
    removeUpdateListener();
    for (int i = 0; i < circlesSize; i++) {
      final int index = i;
      ValueAnimator translateAnimator = ValueAnimator.ofFloat(center.y, height / 4f, height * 3 / 4f, center.y);
      translateAnimator.setDuration(1000);
      translateAnimator.setStartDelay(index * 120);
      translateAnimator.setRepeatCount(ValueAnimator.INFINITE);
      translateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          circles[index].setCenter(center.x, (float)animation.getAnimatedValue());
          if (invalidateListener != null) {
            invalidateListener.reDraw();
          }
        }
      });

      translateAnimator.start();
      valueAnimators.add(translateAnimator);
    }
  }

  @Override public void draw(Canvas canvas) {
    for (int i = 0; i < circlesSize; i++) {
      canvas.save();
      canvas.translate(2 * radius * transformations[i], 0);
      circles[i].draw(canvas);
      canvas.restore();
    }
  }

}
