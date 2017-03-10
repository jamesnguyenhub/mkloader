package com.tuyenmonkey.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tuyen Monkey on 3/10/17.
 */

public class TestActivity extends AppCompatActivity {

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, TestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
  }
}
