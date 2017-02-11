package com.tuyenmonkey.mkloader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import com.tuyenmonkey.mkloader.callback.InvalidateListener;
import com.tuyenmonkey.mkloader.type.LoaderView;
import com.tuyenmonkey.mkloader.type.Spinner;

/**
 * Created by Tuyen Nguyen on 2/5/17.
 */

public class MKLoader extends View implements InvalidateListener {
  private LoaderView loaderView;

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
    loaderView = new Spinner();
    loaderView.setInvalidateListener(this);

    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MKLoader);

    loaderView.setColor(typedArray.getColor(R.styleable.MKLoader_mk_color, Color.parseColor("#ffffff")));

    typedArray.recycle();
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    final int desiredSize = 300;
    final int measuredWidth = resolveSize(desiredSize, widthMeasureSpec);
    final int measuredHeight = resolveSize(desiredSize, heightMeasureSpec);

    setMeasuredDimension(measuredWidth, measuredHeight);
  }

  @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
    loaderView.setSize(getWidth(), getHeight());
    loaderView.calculatePosition();
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    loaderView.draw(canvas);
  }

  @Override public void triggerDraw() {
    invalidate();
  }
}
