package es.developer.achambi.ipsych.profile;

import android.content.Intent;

import es.developer.achambi.coreframework.ui.profile.BaseProfileFragment;
import es.developer.achambi.ipsych.login.LoginActivity;

public class ProfileFragment extends BaseProfileFragment {
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onUserLoggedOut() {
        startActivity( new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }
}
