package com.tuyenmonkey.mkloader;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by Tuyen Nguyen on 2/5/17.
 */

public class DotPainter {
  private Paint paint;
  private PointF center;
  private int radius;

  public DotPainter() {
    paint = new Paint();
    paint.setAntiAlias(true);
    center = new PointF();
  }

  public void setColor(int color) {
    paint.setColor(color);
  }

  public void setAlpha(int alpha) {
    paint.setAlpha(alpha);
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void setCenter(float x, float y) {
    center.set(x, y);
  }

  public void draw(Canvas canvas) {
    canvas.drawCircle(center.x, center.y, radius, paint);
  }
}
