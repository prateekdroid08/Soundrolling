package matt.com.soundrolling.Preseneter.sound_rolling.login;

import android.content.res.Resources;
import android.util.Log;

import com.pixplicity.easyprefs.library.Prefs;
import com.soundrolling.R;

import matt.com.soundrolling.Utils.Constants;
import matt.com.soundrolling.WebApi.RestClient;
import matt.com.soundrolling.WebApi.models.login.LoginParams;
import matt.com.soundrolling.WebApi.models.login.LoginResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by prateekarora on 01/05/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void onLogin(String email, String password, final LoginListener listener) {
        LoginParams params = new LoginParams();
        params.setEmail(email);
        params.setPassword(password);
        params.setDeviceType("android");
        params.setDeviceToken(Prefs.getString(Constants.DEVICE_TOKEN, ""));
        RestClient.get().loginUser(params, new Callback<LoginResponse>() {
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
