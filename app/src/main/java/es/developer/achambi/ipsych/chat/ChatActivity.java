package es.developer.achambi.ipsych.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import es.developer.achambi.coreframework.ui.BaseActivity;
import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;

public class ChatActivity extends BaseActivity {
    @Override
    public int getScreenTitle() {
        return R.string.chat_activity_title;
    }

    @Override
    public BaseFragment getFragment(Bundle args) {
        return new ChatFragment();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent( context, ChatActivity.class );
        return intent;
    }
}
