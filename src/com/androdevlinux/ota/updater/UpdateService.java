package com.androdevlinux.ota.updater;

import android.content.Intent;
import android.util.Log;

import com.commonsware.cwac.wakeful.WakefulIntentService;

public class UpdateService extends WakefulIntentService {
    private static final String TAG = "UpdateService";

    private static boolean mNoLog = true;

    public UpdateService(String name) {
        super(name);
    }

    public UpdateService() {
        super("OtaService");
    }

    /* (non-Javadoc)
     * @see com.commonsware.cwac.wakeful.WakefulIntentService#doWakefulWork(android.content.Intent)
     */
    @Override
    protected void doWakefulWork(Intent intent) {
       if (mNoLog == false) Log.d(TAG, "OTA Update service called!");
       UpdateChecker otaChecker = new UpdateChecker();
       otaChecker.execute(getBaseContext());
    }

}
