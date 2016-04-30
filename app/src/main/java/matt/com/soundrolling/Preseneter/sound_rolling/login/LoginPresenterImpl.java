package matt.com.soundrolling.Preseneter.sound_rolling.login;

import matt.com.soundrolling.Utils.AppUtils;
import android.content.Context;

import com.soundrolling.R;

/**
 * Created by prateekarora on 30/04/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    LoginView loginView;
    Context context;

    public LoginPresenterImpl(LoginView mLoginView, Context mContext) {
        this.loginView = mLoginView;
        this.context = mContext;
    }

    @Override
    public void onlogin(String email, String password) {
        if (!AppUtils.isEmailValid(email))
            loginView.onError(context.getResources().getString(R.string.valid_email));
        else if (password.length() < 4)
            loginView.onError(context.getResources().getString(R.string.valid_password));

    }
}
