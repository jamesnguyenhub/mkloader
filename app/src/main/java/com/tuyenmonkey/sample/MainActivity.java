package com.tuyenmonkey.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_loader2);

    final Button btOpen = (Button)findViewById(R.id.btOpen);
    btOpen.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        startActivity(TestActivity.getCallingIntent(MainActivity.this));
        finish();
      }
    });
  }
}
