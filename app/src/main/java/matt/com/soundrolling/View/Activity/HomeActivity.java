package matt.com.soundrolling.View.Activity;

import android.os.Bundle;

import matt.com.soundrolling.SoundRollingActivity;
import matt.com.soundrolling.View.Fragment.HomeFragment;

/**
 * Created by prateekarora on 29/05/16.
 */
public class HomeActivity extends SoundRollingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        soundRollingPresenter.navigateTo(HomeFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        soundRollingPresenter.oneStepBack();
    }
}
