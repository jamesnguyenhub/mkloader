package com.tuyenmonkey.mkloader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tuyen Nguyen on 2/5/17.
 */

public class MKLoader extends View {
  private ViewDrawer viewDrawer;
  private int color;

  public MKLoader(Context context) {
    super(context);
    initialize(context, null, 0);
  }

  public MKLoader(Context context, AttributeSet attrs) {
    super(context, attrs);
    initialize(context, attrs, 0);
  }

  public MKLoader(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialize(context, attrs, defStyleAttr);
  }

  private void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
    viewDrawer = new Spinner();
    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MKLoader);

    this.color = typedArray.getColor(R.styleable.MKLoader_mk_color, Color.parseColor("#ffffff"));

    viewDrawer.setColor(color);

    typedArray.recycle();
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

    final int desiredSize = 300;

    final int measuredWidth = resolveSize(desiredSize, widthMeasureSpec);
    final int measuredHeight = resolveSize(desiredSize, heightMeasureSpec);

    int size = Math.min(widthSize, heightSize);
    setMeasuredDimension(measuredWidth, measuredHeight);
  }

  @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
    viewDrawer.setSize(getWidth(), getHeight());
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    viewDrawer.draw(canvas);
  }
}
