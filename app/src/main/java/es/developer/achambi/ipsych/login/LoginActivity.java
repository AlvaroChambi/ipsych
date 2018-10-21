package es.developer.achambi.ipsych.login;

import android.os.Bundle;

import es.developer.achambi.coreframework.ui.BaseActivity;
import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;

public class LoginActivity extends BaseActivity {
    @Override
    public int getScreenTitle() {
        return R.string.login_activity_title;
    }

    @Override
    public BaseFragment getFragment(Bundle args) {
        return new LoginFragment();
    }
}
