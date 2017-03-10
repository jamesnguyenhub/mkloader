package com.tuyenmonkey.mkloader.type;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tuyenmonkey.mkloader.model.Circle;

/**
 * Created by Tuyen Nguyen on 2/13/17.
 */

public class Sharingan extends LoaderView {
  private Circle eye;
  private Circle eyeBound;
  private Circle[] sharingans;
  private int numberOfSharingan;
  private float rotate;
  private float scale;
  private float eyeBoundRadius;
  private float eyeBoundRadiusScale;

  public Sharingan() {
    numberOfSharingan = 3;
  }

  @Override public void initializeObjects() {
    float r = Math.min(width, height) / 2f;
    eyeBoundRadius = r / 1.5f;

    eye = new Circle();
    eye.setCenter(center.x, center.y);
    eye.setColor(color);
    eye.setRadius(r / 4);

    eyeBound = new Circle();
    eyeBound.setCenter(center.x, center.y);
    eyeBound.setColor(color);
    eyeBound.setRadius(eyeBoundRadius);
    eyeBound.setStyle(Paint.Style.STROKE);
    eyeBound.setWidth(r / 20f);

    sharingans = new Circle[numberOfSharingan];
    for (int i = 0; i < numberOfSharingan; i++) {
      sharingans[i] = new Circle();
      sharingans[i].setCenter(center.x, center.y - eyeBoundRadius);
      sharingans[i].setColor(color);
      sharingans[i].setRadius(r / 6);
    }
  }

  @Override public void setUpAnimation() {
    ValueAnimator rotateAnimator = ValueAnimator.ofFloat(0, 360);
    rotateAnimator.setDuration(1500);
    rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
    rotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        rotate = (float)animation.getAnimatedValue();
        if (invalidateListener != null) {
          invalidateListener.reDraw();
        }
      }
    });

    ValueAnimator scaleAnimator = ValueAnimator.ofFloat(1f, 0.8f, 1f);
    scaleAnimator.setDuration(1000);
    scaleAnimator.setRepeatCount(ValueAnimator.INFINITE);
    scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        scale = (float)animation.getAnimatedValue();
        if (invalidateListener != null) {
          invalidateListener.reDraw();
        }
      }
    });

    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.play(rotateAnimator).with(scaleAnimator);
    animatorSet.start();
  }

  @Override public void draw(Canvas canvas) {
    canvas.save();
    canvas.scale(scale, scale, center.x, center.y);
    canvas.rotate(rotate, center.x, center.y);
    eye.draw(canvas);
    eyeBound.draw(canvas);
    for (int i = 0; i < numberOfSharingan; i++) {
      canvas.save();
      canvas.rotate(i * 120, center.x, center.y);
      sharingans[i].draw(canvas);
      canvas.restore();
    }
    canvas.restore();
  }
}
