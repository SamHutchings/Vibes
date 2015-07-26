package com.vibes;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vibes.data.ContactsDataSource;
import com.vibes.data.VibesDataSource;

/**
 * Activity for the contacts page
 */
public class ContactsFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private ContactsDataSource mContactsDataSource;

    public ContactsFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.contacts_fragment, container, false);
            TextView friendsTextView = (TextView) rootView.findViewById(R.id.contacts_label);
            friendsTextView.setText("CONTACTS");
            return rootView;
        }

}
