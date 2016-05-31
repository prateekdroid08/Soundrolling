package matt.com.soundrolling.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soundrolling.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import matt.com.soundrolling.View.Activity.HomeActivity;

/**
 * Created by prateekarora on 29/05/16.
 */
public class HomeFragment extends Fragment {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        /* hide navigation back button and set screen title */
        ((HomeActivity) getActivity()).hideNavigationButton();
        ((HomeActivity) getActivity()).tv_toolbar_title.
                setText(getActivity().getResources().getString(R.string.sound_rolling));

        return view;
    }

    @OnClick(R.id.rl_lay4)
    void onSoundBlockClick() {
        ((HomeActivity) getActivity()).soundRollingPresenter.navigateTo(SoundChatFragment.newInstance());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
