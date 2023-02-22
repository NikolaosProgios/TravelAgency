package com.MyApp.TravelAgency;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPreferenceConfig {
    SharedPreferences sharedPreferences;
    Context context;

    public sharedPreferenceConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().
                getString(R.string.login_perference), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().
                getString(R.string.login_status), status);
        editor.commit();
    }

    public boolean readLoginStatus() {
        boolean status /* = false */;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status), false);
        return status;
    }
}
