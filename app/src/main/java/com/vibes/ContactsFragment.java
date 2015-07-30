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
import com.vibes.domain.Contact;
import com.vibes.domain.Vibe;
import com.vibes.enums.VibeType;

import java.sql.SQLException;
import java.util.Calendar;

/**
 * Activity for the contacts page
 */
public class ContactsFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private ContactsDataSource mContactsDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mVibesDataSource = new VibesDataSource(getActivity());
        mContactsDataSource = new ContactsDataSource(getActivity());

        View rootView = inflater.inflate(R.layout.contacts_fragment, container, false);

        return rootView;
    }

}
