package matt.com.soundrolling.View.Fragment;

import matt.com.soundrolling.Preseneter.sound_rolling.login.LoginPresenter;
import matt.com.soundrolling.Preseneter.sound_rolling.login.LoginPresenterImpl;
import matt.com.soundrolling.Preseneter.sound_rolling.login.LoginView;
import matt.com.soundrolling.Utils.ViewUtils;
import matt.com.soundrolling.View.Activity.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.soundrolling.R;

import org.json.JSONObject;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import matt.com.soundrolling.Widget.progress.ProgressDialog;

/**
 * Created by prateekarora on 30/04/16.
 */
public class LoginFragment extends Fragment implements LoginView {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Bind(R.id.email)
    MaterialEditText etEmail;
    @Bind(R.id.password)
    MaterialEditText etPassword;
    CallbackManager callbackManager;

    LoginPresenter loginPresenter;

    ProgressDialog progressDialog;
    String social_emailId;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        /* hide navigation back button and set screen title */
        ((LoginActivity) getActivity()).hideNavigationButton();
        ((LoginActivity) getActivity()).tv_toolbar_title.
                setText(getActivity().getResources().getString(R.string.welcome));

        loginPresenter = new LoginPresenterImpl(this, getActivity());

        callbackManager = CallbackManager.Factory.create();
        registerCallback();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((LoginActivity) getActivity()).toolbar.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.new_user)
    void onNewUserClick(){
        ((LoginActivity) getActivity()).soundRollingPresenter.navigateTo(SignUpFragment.newInstance());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.facebook)
    void onFacebookClick() {
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().logInWithReadPermissions(getActivity(),
                Arrays.asList("email", "public_profile", "user_birthday"));

    }

    @OnClick(R.id.sign_in)
    void onSignInClick() {
        loginPresenter.onlogin(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void showProgress() {
        if (!getActivity().isFinishing()) {
            if (progressDialog == null)
                progressDialog = new ProgressDialog(getActivity());
            progressDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (!getActivity().isFinishing()) {
            if (progressDialog != null)
                progressDialog.dismiss();
        }
    }

    @Override
    public void onSuccess(String message) {
        ViewUtils.showMessage(getActivity(), message);
    }

    @Override
    public void onError(String message) {
        ViewUtils.showMessage(getActivity(), message);
    }

    public void registerCallback() {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        if (!getActivity().isFinishing()) {
                            GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

                                @Override
                                public void onCompleted(JSONObject object, GraphResponse response) {
                                    //get the detail and move to social login password fragment
                                    try {
                                        social_emailId = object.getString("email");

                                        hideProgress();

                                    } catch (Exception e) {
                                        hideProgress();
                                        e.printStackTrace();
                                    }
                                }
                            });
                            Bundle parameters = new Bundle();
                            parameters.putString("fields", "id, name, first_name, last_name, email, gender, birthday, picture");
                            request.setParameters(parameters);
                            request.executeAsync();
                        }
                    }

                    @Override
                    public void onCancel() {
                        hideProgress();
                        Log.d("On Cancel called", "On Cancel Called.");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        hideProgress();
                        Log.d("On Error Occur", "On Error Occur");
                    }
                });
    }
}
