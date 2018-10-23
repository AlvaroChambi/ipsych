package es.developer.achambi.ipsych.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import es.developer.achambi.coreframework.ui.BaseActivity;
import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;

public class LoginActivity extends BaseActivity {
    public static Intent getStartIntent( Context context ) {
        Intent intent = new Intent( context, LoginActivity.class );
        return intent;
    }

    @Override
    public int getScreenTitle() {
        return R.string.login_activity_title;
    }

    @Override
    public BaseFragment getFragment(Bundle args) {
        return new LoginFragment();
    }
}
