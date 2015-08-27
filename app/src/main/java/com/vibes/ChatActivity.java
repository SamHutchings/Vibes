package com.vibes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vibes.data.FriendsDataSource;
import com.vibes.data.VibesDataSource;
import com.vibes.domain.Friend;
import com.vibes.domain.Vibe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A chat with a friend
 */
public class ChatActivity extends Activity {

    private VibesDataSource mVibesDataSource;
    private FriendsDataSource mFriendsDataSource;

    ArrayAdapter<Vibe> adapter;
    ListView mVibesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        long friendId = savedInstanceState.getLong("friendId");

        Friend friend = new Friend();

        mVibesDataSource = new VibesDataSource(this);
        mFriendsDataSource = new FriendsDataSource(this);

        mVibesList = (ListView) findViewById(R.id.top5_vibes_list);
        List<Vibe> vibes = new ArrayList<Vibe>();
        try {
            mVibesDataSource.open();
            mFriendsDataSource.open();
            friend = mFriendsDataSource.getFriend(friendId);
            vibes = mVibesDataSource.getLastVibesForContact(friendId);

        } catch (SQLException e) {
            Log.w("vibes", "CHAT FAILED");
        }

        getActionBar().setTitle("Vibes with " + friend.getUsername());

        adapter = new ArrayAdapter<Vibe>(this,
                android.R.layout.simple_list_item_1,
                vibes);

        mVibesList.setAdapter(adapter);

        mVibesDataSource.close();
        mFriendsDataSource.close();
    }
}
