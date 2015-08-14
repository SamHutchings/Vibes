package com.vibes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.vibes.data.FriendsDataSource;
import com.vibes.data.VibesDataSource;
import com.vibes.domain.Vibe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VibesFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private FriendsDataSource mFriendsDataSource;

    ArrayAdapter<Vibe> adapter;
    ListView mTop5VibeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vibes_fragment, container, false);

        mVibesDataSource = new VibesDataSource(getActivity());
        mFriendsDataSource = new FriendsDataSource(getActivity());

        mTop5VibeList = (ListView) rootView.findViewById(R.id.top5_vibes_list);
        List<Vibe> topVibes = new ArrayList<Vibe>();
        try {
            mVibesDataSource.open();
            mFriendsDataSource.open();
            topVibes = mVibesDataSource.getLast5Vibes();
        }
        catch (SQLException e){
            Log.w("vibes", "VIBES FRAGMNET FAILED");
        }

        adapter=new ArrayAdapter<Vibe>(getActivity(),
                android.R.layout.simple_list_item_1,
                topVibes);

        mTop5VibeList.setAdapter(adapter);

        mVibesDataSource.close();
        mFriendsDataSource.close();
        TextView friendsTextView = (TextView) rootView.findViewById(R.id.vibes_label);
        return rootView;
    }
}
