package matt.com.soundrolling.Preseneter.sound_rolling.login;

/**
 * Created by prateekarora on 01/05/16.
 */
public interface LoginInteractor {
    void onLogin(String email, String password, LoginListener listener);
}
