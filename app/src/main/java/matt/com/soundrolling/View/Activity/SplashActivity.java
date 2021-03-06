package matt.com.soundrolling.View.Activity;

import matt.com.soundrolling.Utils.Constants;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pixplicity.easyprefs.library.Prefs;
import com.soundrolling.R;

/**
 * Created by prateekarora on 06/04/16.
 */
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = null;
                if (!Prefs.getBoolean(Constants.IS_LOGIN, false))
                    i = new Intent(getBaseContext(), LoginActivity.class);
                else
                    i = new Intent(getBaseContext(), HomeActivity.class);

                startActivity(i);
                //Remove activity
                finish();
            }
        }, Constants.SPLASH_TIME);
    }

}
