package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tuyenmonkey.mkloader.model.Arc;

/**
 * Created by Tuyen Nguyen on 2/13/17.
 */

public class PhoneWave extends LoaderView {
  private Arc[] arcs;
  private int numberOfArc;

  public PhoneWave() {
    numberOfArc = 3;
  }

  @Override public void initializeObjects() {
    float r = Math.min(width, height) / 2f;
    arcs = new Arc[numberOfArc];

    for (int i = 0; i < numberOfArc; i++) {
      float d = r / 4 + i * r / 4;
      arcs[i] = new Arc();
      arcs[i].setColor(color);
      arcs[i].setAlpha(126);
      arcs[i].setOval(new RectF(center.x - d, center.y - d + r / 3, center.x + d, center.y + d + r / 3));
      arcs[i].setStartAngle(225);
      arcs[i].setSweepAngle(90);
      arcs[i].setStyle(Paint.Style.STROKE);
      arcs[i].setWidth(r / 10f);
    }
  }

  @Override public void setUpAnimation() {
    for (int i = 0; i < numberOfArc; i++) {
      final int index = i;

      ValueAnimator fadeAnimator = ValueAnimator.ofInt(126, 255, 126);
      fadeAnimator.setRepeatCount(ValueAnimator.INFINITE);
      fadeAnimator.setDuration(1000);
      fadeAnimator.setStartDelay(i * 120);
      fadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          arcs[index].setAlpha((int)animation.getAnimatedValue());
          if (invalidateListener != null) {
            invalidateListener.reDraw();
          }
        }
      });

      fadeAnimator.start();
    }
  }

  @Override public void draw(Canvas canvas) {
    for (int i = 0; i < numberOfArc; i++) {
      arcs[i].draw(canvas);
    }
  }
}
