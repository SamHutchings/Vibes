package com.vibes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * OpenActivity. Checks whether the user is registered and redirects to main or register as appropriate
 */
public class OpenActivity extends Activity {

    private String deviceGuidSettingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        deviceGuidSettingName = getResources().getString(R.string.device_guid_variable_name);

        SharedPreferences settings = getPreferences(0);
        String deviceGuid = settings.getString(deviceGuidSettingName, null);

        if (deviceGuid != null && !deviceGuid.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
        } else {
            Intent intent = new Intent(this, RegisterActivity.class);

            startActivity(intent);
        }
    }
}



