package matt.com.soundrolling.View.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pixplicity.easyprefs.library.Prefs;
import com.soundrolling.R;

import java.util.ArrayList;

import matt.com.soundrolling.Preseneter.sound_rolling.sound_chat.SoundChatPresenter;
import matt.com.soundrolling.Preseneter.sound_rolling.sound_chat.SoundChatPresenterImpl;
import matt.com.soundrolling.Preseneter.sound_rolling.sound_chat.SoundChatView;
import matt.com.soundrolling.Utils.Constants;
import matt.com.soundrolling.Utils.ViewUtils;
import matt.com.soundrolling.View.Activity.HomeActivity;
import matt.com.soundrolling.WebApi.rss_parser.RssItem;
import matt.com.soundrolling.WebApi.rss_parser.RssReader;
import matt.com.soundrolling.Widget.progress.ProgressDialog;

/**
 * Created by prateekarora on 31/05/16.
 */
public class SoundChatFragment extends Fragment implements SoundChatView {

    public static SoundChatFragment newInstance() {
        return new SoundChatFragment();
    }

    SoundChatPresenter soundChatPresenter;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_soundrolling, container, false);

        soundChatPresenter = new SoundChatPresenterImpl(this, getActivity());
        soundChatPresenter.onSoundChatData();

        return view;

    }

    @Override
    public void showProgress() {
    if (!getActivity().isFinishing()) {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
    }
}

    @Override
    public void hideProgress() {
        if (!getActivity().isFinishing()) {
            if (progressDialog != null)
                progressDialog.dismiss();
        }
    }

    @Override
    public void onSuccess(String message) {
        /* Save login Prefs */
        ViewUtils.showMessage(getActivity(), message);
    }

    @Override
    public void onError(String message) {
        ViewUtils.showMessage(getActivity(), message);
    }
}
