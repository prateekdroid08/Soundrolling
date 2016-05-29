package matt.com.soundrolling.Preseneter.sound_rolling.sign_up;

/**
 * Created by prateekarora on 04/05/16.
 */
public interface SignUpView {
    void showProgress();
    void hideProgress();
    void onSuccess(String message);
    void onError(String message);
}
