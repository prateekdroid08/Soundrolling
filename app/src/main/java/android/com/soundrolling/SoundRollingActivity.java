package android.com.soundrolling;

import android.com.soundrolling.Preseneter.sound_rolling.SoundRollingPresenter;
import android.com.soundrolling.Preseneter.sound_rolling.SoundRollingPresenterImpl;
import android.com.soundrolling.Preseneter.sound_rolling.SoundRollingView;
import android.com.soundrolling.Widget.CustomTextView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class SoundRollingActivity extends AppCompatActivity implements SoundRollingView {

    public SoundRollingPresenter kulcarePresenter;

    public Toolbar toolbar;

    CustomTextView tv_toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_toolbar_title = (CustomTextView) findViewById(R.id.tv_toolbar_title);
        kulcarePresenter = new SoundRollingPresenterImpl(this, this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setNavigationIcon(R.drawable.ic_navigation_arrow_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kulcarePresenter.oneStepBack();
                }
            });
        }
    }

    @Override
    public void hideNavigationButton() {
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public void showNavigationButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void changeTitle(String title) {
        if (tv_toolbar_title != null) {
            tv_toolbar_title.setText(title);
        }
    }
}
