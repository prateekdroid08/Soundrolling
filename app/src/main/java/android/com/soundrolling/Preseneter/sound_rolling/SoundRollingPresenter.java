package android.com.soundrolling.Preseneter.sound_rolling;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by prateekarora on 06/04/16.
 */
public interface SoundRollingPresenter {

    void navigateTo(Fragment fragment);

    void navigateWithBundle(Fragment fragment, Bundle bundle);

    void oneStepBack();

    void navigateReplacingCurrent(Fragment currentFragment, Fragment fragmentToNavigate);

    void navigateReplacingCurrentWithChild(Fragment currentFragment, Fragment fragmentToNavigate);

    void navigateReplacingCurrentWithBundle(Fragment currentFragment, Fragment fragmentToNavigate, Bundle bundle);

    void hideBackNavigation();

    void showBackNavigation();

    void backToParent();

    void changeTitle(String title);

}
