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

import java.util.Calendar;

/**
 * Activity for the contacts page
 */
public class ContactsFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private ContactsDataSource mContactsDataSource;

    public ContactsFragment() {
        mVibesDataSource = new VibesDataSource(getActivity());
        mContactsDataSource = new ContactsDataSource(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contacts_fragment, container, false);

        Vibe vibe = new Vibe();
        Contact contact = new Contact();

        contact.setUsername("mr test " + Calendar.getInstance().get(Calendar.SECOND));
        contact.setPhoneNumber("1701570157");

        mContactsDataSource.createContact(contact);

        vibe.setVibeType(VibeType.Good);
        vibe.setContact(contact.getId());

        mVibesDataSource.createVibe(vibe);

        String test = "";

        for (Vibe item : mVibesDataSource.getAllVibes()) {
            test += (" " + vibe.getContactId());
        }

        TextView friendsTextView = (TextView) rootView.findViewById(R.id.contacts_label);
        friendsTextView.setText(test);
        return rootView;
    }

}
