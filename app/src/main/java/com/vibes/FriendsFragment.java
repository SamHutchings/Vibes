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
import com.vibes.domain.Friend;
import com.vibes.domain.Vibe;
import com.vibes.services.DisconnectedVibesAPI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Activity for the friends page
 */
public class FriendsFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private FriendsDataSource mFriendsDataSource;
    private DisconnectedVibesAPI api;

    ArrayAdapter<Friend> adapter;
    ListView mFriendList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {mVibesDataSource = new VibesDataSource(getActivity());

        View rootView = inflater.inflate(R.layout.friends_fragment, container, false);

        mFriendsDataSource = new FriendsDataSource(getActivity());

        mFriendList = (ListView) rootView.findViewById(R.id.friends_list);
        List<Friend> friends = new ArrayList<Friend>();
        try {
            mFriendsDataSource.open();
            friends = mFriendsDataSource.getAllFriends();
        }
        catch (SQLException e){
            Log.w("vibes", "FRIENDS FRAGMNET FAILED");
        }

        adapter=new ArrayAdapter<Friend>(getActivity(),
                android.R.layout.simple_list_item_1,
                friends);

        mFriendList.setAdapter(adapter);

        mVibesDataSource.close();
        mFriendsDataSource.close();
        TextView friendsTextView = (TextView) rootView.findViewById(R.id.vibes_label);
        return rootView;
    }
}
