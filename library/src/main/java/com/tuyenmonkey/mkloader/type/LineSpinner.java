package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.model.Line;

/**
 * Created by Tuyen Nguyen on 2/12/17.
 */

public class LineSpinner extends LoaderView {
  private Line[] lines;
  private int numberOfLine;

  public LineSpinner() {
    numberOfLine = 8;
  }

  @Override public void initializeObjects() {
    int size = Math.min(width, height);
    float lineWidth = size / 10f;
    lines = new Line[numberOfLine];

    for (int i = 0; i < numberOfLine; i++) {
      lines[i] = new Line();
      lines[i].setColor(color);
      lines[i].setAlpha(126);
      lines[i].setWidth(lineWidth);
      lines[i].setPoint1(new PointF(center.x, center.y - size / 2f + lineWidth));
      lines[i].setPoint2(new PointF(center.x, lines[i].getPoint1().y + 2 * lineWidth));
    }
  }

  @Override public void setUpAnimation() {
    for (int i = 0; i < numberOfLine; i++) {
      final int index = i;

      ValueAnimator fadeAnimator = ValueAnimator.ofInt(126, 255, 126);
      fadeAnimator.setRepeatCount(ValueAnimator.INFINITE);
      fadeAnimator.setDuration(1000);
      fadeAnimator.setStartDelay(index * 120);
      fadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          lines[index].setAlpha((int)animation.getAnimatedValue());
          if (invalidateListener != null) {
            invalidateListener.reDraw();
          }
        }
      });

      fadeAnimator.start();
    }
  }

  @Override public void draw(Canvas canvas) {
    for (int i = 0; i < numberOfLine; i++) {
      canvas.save();
      canvas.rotate(45 * i, center.x, center.y);
      lines[i].draw(canvas);
      canvas.restore();
    }
  }
}
