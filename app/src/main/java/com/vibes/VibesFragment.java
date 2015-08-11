package com.vibes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vibes.data.FriendsDataSource;
import com.vibes.data.VibesDataSource;
import com.vibes.domain.Vibe;

import java.sql.SQLException;
import java.util.List;

public class VibesFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private FriendsDataSource mFriendsDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vibes_fragment, container, false);

        mVibesDataSource = new VibesDataSource(getActivity());
        mFriendsDataSource = new FriendsDataSource(getActivity());

        try {
            mVibesDataSource.open();
            mFriendsDataSource.open();
        }
        catch (SQLException e){

        }

        List<Vibe> topVibes = mVibesDataSource.getLast5Vibes();

        mVibesDataSource.close();
        mFriendsDataSource.close();
        TextView friendsTextView = (TextView) rootView.findViewById(R.id.vibes_label);
        return rootView;
    }
}
