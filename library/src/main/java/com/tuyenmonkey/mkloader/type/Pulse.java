package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.exception.InvalidNumberOfPulseException;
import com.tuyenmonkey.mkloader.model.Line;

/**
 * Created by Tuyen Nguyen on 2/12/17.
 */

public class Pulse extends LoaderView {
  private Line[] lines;
  private int numberOfLines;
  private float lineWidth;
  private float lineDistance;
  private float[] scaleY;

  public Pulse(int numberOfLines) throws InvalidNumberOfPulseException {
    if (numberOfLines < 3 || numberOfLines > 5) {
      throw new InvalidNumberOfPulseException();
    }

    this.numberOfLines = numberOfLines;
    lines = new Line[numberOfLines];
    scaleY = new float[numberOfLines];
  }

  @Override public void initializeObjects() {
    lineWidth = width / (2 * numberOfLines);
    lineDistance = lineWidth / 4f;
    float firstX = (width - (lineWidth * numberOfLines + lineDistance * (numberOfLines - 1))) / 2f + lineWidth / 2f;
    for (int i = 0; i < numberOfLines; i++) {
      lines[i] = new Line();
      lines[i].setColor(color);
      lines[i].setWidth(lineWidth);
      lines[i].setPoint1(new PointF(firstX, center.y - height / 4f));
      lines[i].setPoint2(new PointF(firstX, center.y + height / 4f));
    }
  }

  @Override public void setUpAnimation() {
    for (int i = 0; i < numberOfLines; i++) {
      final int index = i;
      ValueAnimator scaleAnimator = ValueAnimator.ofFloat(1f, 1.5f, 1f);
      scaleAnimator.setDuration(1000);
      scaleAnimator.setStartDelay(i * 120);
      scaleAnimator.setRepeatCount(ValueAnimator.INFINITE);
      scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          scaleY[index] = (float)animation.getAnimatedValue();
          if (invalidateListener != null) {
            invalidateListener.reDraw();
          }
        }
      });

      scaleAnimator.start();
    }
  }

  @Override public void draw(Canvas canvas) {
    for (int i = 0; i < numberOfLines; i++) {
      canvas.save();
      canvas.translate(i * (lineWidth + lineDistance), 0);
      canvas.scale(1, scaleY[i], lines[i].getPoint1().x, center.y);
      lines[i].draw(canvas);
      canvas.restore();
    }
  }
}
