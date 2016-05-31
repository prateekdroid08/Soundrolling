package matt.com.soundrolling.Preseneter.sound_rolling.sound_chat;

/**
 * Created by prateekarora on 30/04/16.
 */
public interface SoundChatView {
    void showProgress();
    void hideProgress();
    void onSuccess(String message);
    void onError(String message);
}
