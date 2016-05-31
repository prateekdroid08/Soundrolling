package matt.com.soundrolling.Preseneter.sound_rolling.sound_chat;

import android.content.Context;

import com.soundrolling.R;

import matt.com.soundrolling.Utils.AppUtils;

/**
 * Created by prateekarora on 30/04/16.
 */
public class SoundChatPresenterImpl implements SoundChatPresenter, SoundChatListener {

    SoundChatView soundChatView;
    Context context;
    SoundChatInteractor interactor;

    public SoundChatPresenterImpl(SoundChatView mSoundChatView, Context mContext) {
        this.soundChatView = mSoundChatView;
        this.context = mContext;
        interactor = new SoundChatInteractorImpl();
    }

    @Override
    public void onSoundChatData() {
        soundChatView.showProgress();
        interactor.onSoundChatData(context, this);
    }

    @Override
    public void onSuccess(String message) {
        soundChatView.hideProgress();
        soundChatView.onSuccess(message);
    }

    @Override
    public void onError(String message) {
        soundChatView.hideProgress();
        soundChatView.onError(message);
    }
}
