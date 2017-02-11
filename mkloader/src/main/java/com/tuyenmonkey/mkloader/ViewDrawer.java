package com.tuyenmonkey.mkloader;

import android.graphics.Canvas;

/**
 * Created by Tuyen Nguyen on 2/9/17.
 */

public interface ViewDrawer {

  void setColor(int color);
  void setSize(int width, int height);
  void draw(Canvas canvas);
}
