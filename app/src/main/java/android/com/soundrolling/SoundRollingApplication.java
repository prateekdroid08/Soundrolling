package android.com.soundrolling;

import android.app.Application;
import android.com.soundrolling.WebApi.RestClient;
import android.content.ContextWrapper;

import com.drivemode.android.typeface.TypefaceHelper;
import com.pixplicity.easyprefs.library.Prefs;
import com.rollbar.android.Rollbar;

/**
 * Created by prateekarora on 06/04/16.
 */
public class SoundRollingApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new RestClient(this); // Initialise REST client
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        // Initialise typeface helper
        TypefaceHelper.initialize(this);

        Rollbar.init(this, getResources().getString(R.string.rollbar_token),
                getResources().getString(R.string.environment));
    }
}
