package matt.com.soundrolling;

import matt.com.soundrolling.Preseneter.sound_rolling.SoundRollingPresenter;
import matt.com.soundrolling.Preseneter.sound_rolling.SoundRollingPresenterImpl;
import matt.com.soundrolling.Preseneter.sound_rolling.SoundRollingView;
import matt.com.soundrolling.Widget.CustomTextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.soundrolling.R;

public class SoundRollingActivity extends AppCompatActivity implements SoundRollingView {

    public SoundRollingPresenter soundRollingPresenter;

    public Toolbar toolbar;

    public CustomTextView tv_toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_toolbar_title = (CustomTextView) findViewById(R.id.tv_toolbar_title);
        soundRollingPresenter = new SoundRollingPresenterImpl(this, this);
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
                    soundRollingPresenter.oneStepBack();
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
