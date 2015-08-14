package com.vibes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vibes.data.FriendsDataSource;
import com.vibes.data.VibesDataSource;
import com.vibes.domain.Friend;
import com.vibes.domain.Vibe;
import com.vibes.enums.VibeType;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Activity for the contacts page
 */
public class ContactsFragment extends Fragment {
    private VibesDataSource mVibesDataSource;
    private FriendsDataSource mFriendsDataSource;
    Button mSendVibeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contacts_fragment, container, false);

        mSendVibeButton = (Button) rootView.findViewById(R.id.sendvibebutton);

        mVibesDataSource = new VibesDataSource(getActivity());
        mFriendsDataSource = new FriendsDataSource(getActivity());

        mSendVibeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVibe();
            }
        });
        return rootView;
    }

    void sendVibe()
    {
        Friend friendToSend;

        try {
            mFriendsDataSource.open();
            mVibesDataSource.open();
            List<Friend> friends = mFriendsDataSource.getAllFriends();

            if (friends.isEmpty()) {
                Friend friend = new Friend();
                friend.setPhoneNumber("07931204393");
                friend.setUsername("Sam");

                friendToSend = mFriendsDataSource.createFriend(friend);
            } else {
                friendToSend = friends.get(0);
            }

            Vibe newVibe = new Vibe();
            newVibe.setContact(friendToSend.getId());
            Calendar c = Calendar.getInstance();
            int seconds = c.get(Calendar.SECOND);

            if (seconds % 2 == 0) {

                newVibe.setVibeType(VibeType.Good);
            } else {
                newVibe.setVibeType(VibeType.Bad);
            }

            newVibe.setSent(true);

            newVibe = mVibesDataSource.createVibe(newVibe);
        }
        catch (SQLException e){

            Log.w("vibes", "CONTACTS FRAGMNET FAILED");
        }
    }
}
