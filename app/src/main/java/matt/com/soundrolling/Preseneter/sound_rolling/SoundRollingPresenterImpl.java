package matt.com.soundrolling.Preseneter.sound_rolling;

import matt.com.soundrolling.SoundRollingActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.soundrolling.R;

/**
 * Created by prateekarora on 06/04/16.
 */
public class SoundRollingPresenterImpl implements SoundRollingPresenter {

    Context ctx;
    SoundRollingView soundRollingView;
    
    public SoundRollingPresenterImpl(Context ctx, SoundRollingView soundRollingView){
        this.ctx = ctx;
        this.soundRollingView = soundRollingView;
    }

    @Override
    public void navigateTo(Fragment fragment) {
        FragmentTransaction fts = ((SoundRollingActivity) ctx).getSupportFragmentManager().beginTransaction();
        fts.replace(R.id.fragmentHolder, fragment);
        fts.addToBackStack(fragment.getClass().getSimpleName());
        fts.commit();
    }

    @Override
    public void navigateWithBundle(Fragment fragment, Bundle bundle) {
        FragmentTransaction fts = ((SoundRollingActivity) ctx).getSupportFragmentManager().beginTransaction();
        fts.replace(R.id.fragmentHolder, fragment);
        fragment.setArguments(bundle);
        fts.addToBackStack(fragment.getClass().getSimpleName());
        fts.commit();
    }

    @Override
    public void navigateReplacingCurrentWithBundle(Fragment currentFragment, Fragment fragmentToNavigate, Bundle bundle) {
        fragmentToNavigate.setArguments(bundle);
        FragmentTransaction fts = ((SoundRollingActivity) ctx).getSupportFragmentManager().beginTransaction();
        ((SoundRollingActivity) ctx).getSupportFragmentManager().popBackStack();
        fts.replace(R.id.fragmentHolder, fragmentToNavigate);
        fts.addToBackStack(fragmentToNavigate.getClass().getSimpleName());
        fts.remove(currentFragment).commit();
    }

    @Override
    public void oneStepBack() {
        FragmentTransaction fts = ((SoundRollingActivity) ctx).getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = ((SoundRollingActivity) ctx).getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() >= 2) {
            fragmentManager.popBackStackImmediate();
            fts.commit();
        } else {
            ((SoundRollingActivity) ctx).finish();
        }
    }

    @Override
    public void navigateReplacingCurrent(Fragment currentFragment, Fragment fragmentToNavigate) {
        FragmentTransaction fts = ((SoundRollingActivity) ctx).getSupportFragmentManager().beginTransaction();
        ((SoundRollingActivity) ctx).getSupportFragmentManager().popBackStack();
        fts.replace(R.id.fragmentHolder, fragmentToNavigate);
        fts.addToBackStack(fragmentToNavigate.getClass().getSimpleName());
        fts.remove(currentFragment).commit();
    }

    @Override
    public void navigateReplacingCurrentWithChild(Fragment currentFragment, Fragment fragmentToNavigate) {
        FragmentTransaction fts = ((SoundRollingActivity) ctx).getSupportFragmentManager().beginTransaction();
        ((SoundRollingActivity) ctx).getSupportFragmentManager().popBackStack();
        fts.replace(R.id.fragmentHolder, fragmentToNavigate);
        fts.addToBackStack(fragmentToNavigate.getClass().getSimpleName());
        fts.remove(currentFragment).commit();
    }

    @Override
    public void hideBackNavigation() {
        soundRollingView.hideNavigationButton();
    }

    @Override
    public void showBackNavigation() {
        soundRollingView.showNavigationButton();
    }

    @Override
    public void backToParent() {
        FragmentTransaction fts = ((SoundRollingActivity) ctx).getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = ((SoundRollingActivity) ctx).getSupportFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            fragmentManager.popBackStackImmediate();
        }
        fts.commit();
    }

    @Override
    public void changeTitle(String title) {
        soundRollingView.changeTitle(title);
    }
}
