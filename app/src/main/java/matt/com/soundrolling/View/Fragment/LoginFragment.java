package matt.com.soundrolling.View.Fragment;

import matt.com.soundrolling.Preseneter.sound_rolling.login.LoginPresenter;
import matt.com.soundrolling.Preseneter.sound_rolling.login.LoginPresenterImpl;
import matt.com.soundrolling.Preseneter.sound_rolling.login.LoginView;
import matt.com.soundrolling.Utils.ViewUtils;
import matt.com.soundrolling.View.Activity.LoginActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.soundrolling.R;

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

    LoginPresenter loginPresenter;

    ProgressDialog progressDialog;


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

        return view;
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
}
