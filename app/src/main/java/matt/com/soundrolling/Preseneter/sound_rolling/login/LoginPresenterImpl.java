package matt.com.soundrolling.Preseneter.sound_rolling.login;

import matt.com.soundrolling.Utils.AppUtils;

import android.content.Context;

import com.soundrolling.R;

/**
 * Created by prateekarora on 30/04/16.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginListener {

    LoginView loginView;
    Context context;
    LoginInteractor interactor;

    public LoginPresenterImpl(LoginView mLoginView, Context mContext) {
        this.loginView = mLoginView;
        this.context = mContext;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void onlogin(String email, String password) {
        if (!AppUtils.isEmailValid(email))
            loginView.onError(context.getResources().getString(R.string.valid_email));
        else if (password.length() < 4)
            loginView.onError(context.getResources().getString(R.string.valid_password));
        else {
            loginView.showProgress();
            interactor.onLogin(email, password, this);
        }


    }

    @Override
    public void onSuccess(String message) {
        loginView.hideProgress();
        loginView.onSuccess(message);
    }

    @Override
    public void onError(String message) {
        loginView.hideProgress();
        loginView.onError(message);
    }
}
