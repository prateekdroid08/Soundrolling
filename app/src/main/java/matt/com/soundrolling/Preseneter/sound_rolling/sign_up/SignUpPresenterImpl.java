package matt.com.soundrolling.Preseneter.sound_rolling.sign_up;

import android.content.Context;

import com.soundrolling.R;

import matt.com.soundrolling.Utils.AppUtils;
import matt.com.soundrolling.WebApi.models.login.sign_up.SignUpParams;

/**
 * Created by prateekarora on 04/05/16.
 */
public class SignUpPresenterImpl implements SignUpPresenter, SignUpListener {

    SignUpView signUpView;
    Context context;
    SignUpInteractor interactor;

    public SignUpPresenterImpl(SignUpView signUpView, Context mContext) {
        this.signUpView = signUpView;
        this.context = mContext;
        interactor = new SignUpInteractorImpl();
    }

    @Override
    public void onSignUp(SignUpParams params) {
        if (params.getF_name().trim().length() < 4)
            signUpView.onError(context.getResources().getString(R.string.first_name_validation));
        else if (params.getL_name().trim().length() < 4)
            signUpView.onError(context.getResources().getString(R.string.last_name_validation));
        else if (params.getCountry().trim().length() < 0)
            signUpView.onError(context.getResources().getString(R.string.country));
        else if (params.getEmail().trim().length() == 0 || AppUtils.isEmailValid(params.getEmail().toString()))
            signUpView.onError(context.getResources().getString(R.string.valid_email));
        else if (params.getPassword().trim().length() < 4)
            signUpView.onError(context.getResources().getString(R.string.valid_password));
        else {
            signUpView.showProgress();
            interactor.onSignUp(params, this);
        }

    }

    @Override
    public void onSuccess(String message) {
        signUpView.hideProgress();
        signUpView.onSuccess(message);
    }

    @Override
    public void onError(String message) {
        signUpView.hideProgress();
        signUpView.onError(message);
    }
}
