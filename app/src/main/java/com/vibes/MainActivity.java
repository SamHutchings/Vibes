package com.vibes;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.vibes.data.ContactsDataSource;
import com.vibes.data.VibesDataSource;

/*
    The main screen for the app
 */
public class MainActivity extends Activity {

    private VibesDataSource vibesDataSource;
    private ContactsDataSource contactsDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
        setContentView(R.layout.activity_main);
    }
}
