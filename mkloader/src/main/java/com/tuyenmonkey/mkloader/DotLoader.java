package com.tuyenmonkey.mkloader;

import android.graphics.Canvas;
import android.graphics.Color;

/**
 * Created by Tuyen Nguyen on 2/5/17.
 */

public class DotLoader {
  private final int DEFAULT_DOT_SIZE = 8;
  private DotPainter[] dotPainters;

  public DotLoader() {
    initialize(DEFAULT_DOT_SIZE);
  }

  public DotLoader(int dotSize) {
    initialize(dotSize);
  }

  private void initialize(int dotSize) {
    dotPainters = new DotPainter[dotSize];

    for (int i = 0; i < dotSize; i++) {
      dotPainters[i] = new DotPainter();
      dotPainters[i].setAlpha(1);
      dotPainters[i].setColor(Color.parseColor("#0000ff"));
      dotPainters[i].setRadius(30);
    }

    float r = 150;
    float d = (float)Math.pow(2, 1.0 / 2.0);
    dotPainters[0].setCenter(r, 0);
    dotPainters[1].setCenter(r + r / d, r - r / d);
    dotPainters[2].setCenter(2 * r, r);
    dotPainters[3].setCenter(r + r / d, r + r / d);
    dotPainters[4].setCenter(r, 2 * r);
    dotPainters[5].setCenter(r - r / d, r + r / d);
    dotPainters[6].setCenter(0, r);
    dotPainters[7].setCenter(r - r / d, r - r / d);
  }

  public void setDotRadius(int radius) {
    for (DotPainter painter : dotPainters) {
      painter.setRadius(radius);
    }
  }

  public void draw(Canvas canvas) {
    for (DotPainter painter : dotPainters) {
      painter.draw(canvas);
    }
  }
}
