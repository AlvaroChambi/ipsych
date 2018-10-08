package es.developer.achambi.ipsych;

import android.os.Bundle;

import es.developer.achambi.coreframework.ui.BaseActivity;
import es.developer.achambi.coreframework.ui.BaseFragment;

public class ChatActivity extends BaseActivity {
    @Override
    public int getScreenTitle() {
        return R.string.app_name;
    }

    @Override
    public BaseFragment getFragment(Bundle args) {
        return new ChatFragment();
    }
}
