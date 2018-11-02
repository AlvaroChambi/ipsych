package es.developer.achambi.ipsych.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import es.developer.achambi.ipsych.NavigationFragment;
import es.developer.achambi.ipsych.R;

public class ChatFragment extends NavigationFragment {
    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.base_activity;
    }

    @Override
    public void onViewSetup(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public int getTitleResource() {
        return R.string.chat_activity_title;
    }
}
