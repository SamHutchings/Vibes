package com.vibes;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import com.vibes.data.ContactsDataSource;
import com.vibes.data.VibesDataSource;
import com.vibes.services.DisconnectedVibesAPI;

/**
 * Activity for the friends page
 */
public class FriendsActivity extends Activity {
    private VibesDataSource vibesDataSource;
    private ContactsDataSource contactsDataSource;
    private DisconnectedVibesAPI api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
        setContentView(R.layout.activity_main);
    }
}
