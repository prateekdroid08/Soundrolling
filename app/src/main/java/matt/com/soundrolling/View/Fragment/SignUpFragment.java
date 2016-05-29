package matt.com.soundrolling.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.soundrolling.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import matt.com.soundrolling.Preseneter.sound_rolling.sign_up.SignUpPresenter;
import matt.com.soundrolling.Preseneter.sound_rolling.sign_up.SignUpPresenterImpl;
import matt.com.soundrolling.Preseneter.sound_rolling.sign_up.SignUpView;
import matt.com.soundrolling.Utils.ViewUtils;
import matt.com.soundrolling.View.Activity.LoginActivity;
import matt.com.soundrolling.WebApi.models.login.sign_up.SignUpParams;
import matt.com.soundrolling.Widget.CustomTextView;
import matt.com.soundrolling.Widget.progress.ProgressDialog;

/**
 * Created by prateekarora on 04/05/16.
 */
public class SignUpFragment extends Fragment implements SignUpView {

    @Bind(R.id.first_name)
    MaterialEditText etFirstName;
    @Bind(R.id.last_name)
    MaterialEditText etLastName;
    @Bind(R.id.email)
    MaterialEditText etEmail;
    @Bind(R.id.password)
    MaterialEditText etPassword;
    @Bind(R.id.toolbar_title_with_back)
    Toolbar toolbar;

    CustomTextView tvToolbarTitle;

    ProgressDialog progressDialog;

    SignUpPresenter presenter;

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        ButterKnife.bind(this, view);

        // hide toolbar of login screen
        ((LoginActivity) getActivity()).toolbar.setVisibility(View.GONE);

        if (toolbar != null) {
            ((LoginActivity) getActivity()).setSupportActionBar(toolbar);
            ((LoginActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((LoginActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
            ((LoginActivity) getActivity()).getSupportActionBar().setDisplayUseLogoEnabled(true);
            ((LoginActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((LoginActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            tvToolbarTitle = (CustomTextView) toolbar.findViewById(R.id.tv_toolbar_title);
            tvToolbarTitle.setText(getActivity().getResources().getString(R.string.join_community));
            toolbar.setNavigationIcon(R.drawable.ic_navigation_arrow_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((LoginActivity) getActivity()).soundRollingPresenter.oneStepBack();
                }
            });
        }

        presenter = new SignUpPresenterImpl(this, getActivity());


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        /* show navigation back button and set screen title */
        ((LoginActivity) getActivity()).toolbar.setVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_signup)
    void onSignUpClick() {
        SignUpParams params = new SignUpParams();
        params.setF_name(etFirstName.getText().toString());
        params.setL_name(etLastName.getText().toString());
        params.setEmail(etEmail.getText().toString());
        params.setPassword(etPassword.getText().toString());
        presenter.onSignUp(params);
    }

    @OnClick(R.id.btn_facebook)
    void onFacebookClick() {

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
