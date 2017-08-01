package com.tuyenmonkey.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Tuyen Monkey on 8/1/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
  private List<String> contacts;

  public ContactsAdapter() {
    contacts = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      contacts.add(String.format(Locale.US, "contact %d", i));
    }
  }

  @Override public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(R.layout.item_contact, parent, false);
    return new ContactViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ContactViewHolder holder, int position) {
    final String contact = contacts.get(position);
    holder.bind(contact);
  }

  @Override public int getItemCount() {
    return contacts != null ? contacts.size() : 0;
  }

  public static class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView tvName;

    public ContactViewHolder(View itemView) {
      super(itemView);
      tvName = (TextView)itemView.findViewById(R.id.tvName);
    }

    public void bind(String contact) {
      tvName.setText(contact);
    }
  }
}
