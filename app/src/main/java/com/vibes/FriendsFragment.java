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
import com.vibes.services.DisconnectedVibesAPI;

/**
 * Activity for the friends page
 */
public class FriendsFragment extends Fragment {
    private VibesDataSource vibesDataSource;
    private ContactsDataSource contactsDataSource;
    private DisconnectedVibesAPI api;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.friends_fragment, container, false);
        TextView friendsTextView = (TextView) rootView.findViewById(R.id.friends_label);
        friendsTextView.setText("FRIENDS");
        return rootView;
    }
}
