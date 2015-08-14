package com.vibes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vibes.data.FriendsDataSource;
import com.vibes.data.VibesDataSource;
import com.vibes.domain.Vibe;

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

        mSendVibeButton = (Button) getView().findViewById(R.id.sendvibebutton);

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
        Friend friend = mFriendsDataSource.getContact()
        Vibe newVibe = new Vibe();
    }

}
