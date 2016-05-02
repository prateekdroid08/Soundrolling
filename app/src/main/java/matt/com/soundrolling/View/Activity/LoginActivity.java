package matt.com.soundrolling.View.Activity;

import matt.com.soundrolling.SoundRollingActivity;
import matt.com.soundrolling.View.Fragment.LoginFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.soundrolling.R;

/**
 * Created by prateekarora on 06/04/16.
 */
public class LoginActivity extends SoundRollingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        kulcarePresenter.navigateTo(LoginFragment.newInstance());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            LoginFragment fragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
            fragment.onActivityResult(requestCode, resultCode, data);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
