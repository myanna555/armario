package com.android.gatofalante.armario.utilities;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by gatofalante on 12/29/17.
 */

public class ArmarioApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
