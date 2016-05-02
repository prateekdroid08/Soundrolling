package matt.com.soundrolling.WebApi;


import matt.com.soundrolling.WebApi.models.login.LoginParams;
import matt.com.soundrolling.WebApi.models.login.LoginResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by prateek arora on 26/07/15.
 */
public interface WebApi {

    @POST("/Signup")
    void signUpUser(@Body LoginParams mLoginParams, Callback<LoginResponse> cb);

    @POST("/Login")
    void loginUser(@Body LoginParams mLoginParams, Callback<LoginResponse> cb);

}

