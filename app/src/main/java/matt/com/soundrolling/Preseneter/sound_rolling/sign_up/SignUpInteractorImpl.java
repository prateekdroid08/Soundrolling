package matt.com.soundrolling.Preseneter.sound_rolling.sign_up;

import android.util.Log;

import matt.com.soundrolling.WebApi.RestClient;
import matt.com.soundrolling.WebApi.models.login.LoginResponse;
import matt.com.soundrolling.WebApi.models.login.sign_up.SignUpParams;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by prateekarora on 04/05/16.
 */
public class SignUpInteractorImpl implements SignUpInteractor {
    @Override
    public void onSignUp(SignUpParams params, final SignUpListener listener) {
        RestClient.get().signUpUser(params, new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                Log.d("response", loginResponse.getMessage());
                listener.onSuccess(loginResponse.getMessage());
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onError(error.getLocalizedMessage());
            }
        });
    }
}
