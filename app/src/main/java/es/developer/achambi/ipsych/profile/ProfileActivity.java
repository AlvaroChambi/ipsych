package es.developer.achambi.ipsych.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import es.developer.achambi.coreframework.ui.BaseActivity;
import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;

public class ProfileActivity extends BaseActivity {
    public static Intent getStartIntent( Context context ) {
        Intent intent = new Intent( context, ProfileActivity.class );
        return intent;
    }

    @Override
    public int getScreenTitle() {
        return R.string.profile_activity_title;
    }

    @Override
    public BaseFragment getFragment(Bundle args) {
        return new ProfileFragment();
    }
}
