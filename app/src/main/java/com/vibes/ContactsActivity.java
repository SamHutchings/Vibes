package com.vibes;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import com.vibes.data.ContactsDataSource;
import com.vibes.data.VibesDataSource;

/**
 * Activity for the contacts page
 */
public class ContactsActivity extends Activity {
    private VibesDataSource vibesDataSource;
    private ContactsDataSource contactsDataSource;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
        setContentView(R.layout.activity_main);
    }
}
