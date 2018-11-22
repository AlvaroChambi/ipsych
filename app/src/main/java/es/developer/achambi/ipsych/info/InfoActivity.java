package es.developer.achambi.ipsych.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import es.developer.achambi.coreframework.ui.BaseActivity;
import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;

public class InfoActivity extends BaseActivity{
    @Override
    public int getScreenTitle() {
        return R.string.info_activity_title;
    }

    @Override
    public BaseFragment getFragment(Bundle args) {
        return InfoFragment.newInstance();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent( context, InfoActivity.class );
        return intent;
    }
}
