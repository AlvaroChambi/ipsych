package es.developer.achambi.ipsych.login;

import android.content.Intent;

import es.developer.achambi.coreframework.ui.login.BaseLoginFragment;
import es.developer.achambi.ipsych.NavigationActivity;

public class LoginFragment extends BaseLoginFragment {
    @Override
    public Intent getNextScreenIntent() {
        return new Intent( getActivity(), NavigationActivity.class );
    }
}
