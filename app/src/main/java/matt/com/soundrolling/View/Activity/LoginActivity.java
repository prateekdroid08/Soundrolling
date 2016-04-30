package matt.com.soundrolling.View.Activity;

import matt.com.soundrolling.SoundRollingActivity;
import matt.com.soundrolling.View.Fragment.LoginFragment;
import android.os.Bundle;

/**
 * Created by prateekarora on 06/04/16.
 */
public class LoginActivity extends SoundRollingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        kulcarePresenter.navigateTo(LoginFragment.newInstance());
    }
}
