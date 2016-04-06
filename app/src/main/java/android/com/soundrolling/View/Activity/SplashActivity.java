package android.com.soundrolling.View.Activity;

import android.com.soundrolling.R;
import android.com.soundrolling.SoundRollingActivity;
import android.com.soundrolling.Utils.Constants;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by prateekarora on 06/04/16.
 */
public class SplashActivity extends SoundRollingActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.splash_activity);

        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(i);
                //Remove activity
                finish();
            }
        }, Constants.SPLASH_TIME);
    }

}
