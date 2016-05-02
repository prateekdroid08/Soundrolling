package matt.com.soundrolling.Preseneter.sound_rolling.login;

/**
 * Created by prateekarora on 30/04/16.
 */
public interface LoginView {
    void showProgress();
    void hideProgress();
    void onSuccess(String message);
    void onError(String message);
}
