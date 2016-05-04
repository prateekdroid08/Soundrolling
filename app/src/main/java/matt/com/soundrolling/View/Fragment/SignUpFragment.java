package matt.com.soundrolling.View.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.soundrolling.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import matt.com.soundrolling.Preseneter.sound_rolling.sign_up.SignUpView;
import matt.com.soundrolling.Utils.ViewUtils;
import matt.com.soundrolling.Widget.progress.ProgressDialog;

/**
 * Created by prateekarora on 04/05/16.
 */
public class SignUpFragment extends Fragment implements SignUpView {

    @Bind(R.id.first_name)
    MaterialEditText etFirstName;
    @Bind(R.id.last_name)
    MaterialEditText etLastName;
    @Bind(R.id.country)
    MaterialEditText etCountry;
    @Bind(R.id.email)
    MaterialEditText etEmail;
    @Bind(R.id.password)
    MaterialEditText etPassword;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_signup)
    void onSignUpClick(){

    }

    @OnClick(R.id.btn_facebook)
    void onFacebookClick(){

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
