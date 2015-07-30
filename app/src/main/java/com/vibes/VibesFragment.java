package com.vibes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vibes.data.ContactsDataSource;
import com.vibes.data.VibesDataSource;
import com.vibes.domain.Vibe;

import java.sql.SQLException;
import java.util.List;

public class VibesFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private ContactsDataSource mContactsDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vibes_fragment, container, false);

        mVibesDataSource = new VibesDataSource(getActivity());
        mContactsDataSource = new ContactsDataSource(getActivity());

        try {
            mVibesDataSource.open();
            mContactsDataSource.open();
        }
        catch (SQLException e){

        }

        List<Vibe> topVibes = mVibesDataSource.getLast5Vibes();

        mVibesDataSource.close();
        mContactsDataSource.close();
        TextView friendsTextView = (TextView) rootView.findViewById(R.id.vibes_label);
        return rootView;
    }
}
