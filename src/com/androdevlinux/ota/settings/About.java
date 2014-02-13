package com.androdevlinux.ota.settings;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;


import com.androdevlinux.center.androdevlinuxCenter;
import com.androdevlinux.ota.R;

public class About extends Activity {
    @SuppressWarnings("unused")
    private static final String TAG = "About";

    private static final int ID_HOME_URL = R.id.about_home;
    private static final int ID_CONTACT = R.id.about_contact;
    private static final int ID_LICENSE = R.id.about_license_url;

    private TextView mHomeURL;
    private TextView mContact;
    private TextView mLicense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        mHomeURL = (TextView) findViewById(ID_HOME_URL);
        mContact = (TextView) findViewById(ID_CONTACT);
        mLicense = (TextView) findViewById(ID_LICENSE);

        mHomeURL.setMovementMethod(LinkMovementMethod.getInstance());
        mContact.setMovementMethod(LinkMovementMethod.getInstance());
        mLicense.setMovementMethod(LinkMovementMethod.getInstance());

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayHomeAsUpEnabled(true);

     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, androdevlinuxCenter.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
