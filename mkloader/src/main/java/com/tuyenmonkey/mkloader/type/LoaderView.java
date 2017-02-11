package com.tuyenmonkey.mkloader.type;

import android.graphics.Canvas;
import com.tuyenmonkey.mkloader.callback.InvalidateListener;

/**
 * Created by Tuyen Nguyen on 2/11/17.
 */

public abstract class LoaderView {
  protected int color;
  protected int width, height;
  protected InvalidateListener invalidateListener;

  public void setColor(int color) {
    this.color = color;
  }

  public void setSize(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public void setInvalidateListener(InvalidateListener invalidateListener) {
    this.invalidateListener = invalidateListener;
  }

  public abstract void calculatePosition();

  public abstract void draw(Canvas canvas);
}
