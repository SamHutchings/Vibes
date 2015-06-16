package com.vibes;

import android.app.Activity;

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
}
