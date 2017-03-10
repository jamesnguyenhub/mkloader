package com.tuyenmonkey.sample;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Tuyen Monkey on 3/10/17.
 */

public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();

    LeakCanary.install(this);
  }
}
