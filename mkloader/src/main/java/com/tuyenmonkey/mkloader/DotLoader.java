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
    }
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
