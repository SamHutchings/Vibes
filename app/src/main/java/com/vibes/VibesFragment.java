package com.vibes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibes.data.ContactsDataSource;
import com.vibes.data.VibesDataSource;

public class VibesFragment extends Fragment {
    private VibesDataSource vibesDataSource;
    private ContactsDataSource contactsDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vibes_fragment, container, false);
        return rootView;
    }
}
