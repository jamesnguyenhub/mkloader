package com.tuyenmonkey.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Tuyen Monkey on 8/1/17.
 */

public class ListTestActivity extends AppCompatActivity {
  RecyclerView rvContacts;

  private ContactsAdapter adapter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_test);

    rvContacts = (RecyclerView)findViewById(R.id.rvContacts);

    adapter = new ContactsAdapter();

    rvContacts.setAdapter(adapter);
    rvContacts.setLayoutManager(new LinearLayoutManager(this));
  }
}
