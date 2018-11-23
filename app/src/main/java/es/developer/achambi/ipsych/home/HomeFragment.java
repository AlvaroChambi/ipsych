package es.developer.achambi.ipsych.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;
import es.developer.achambi.ipsych.chat.ChatActivity;
import es.developer.achambi.ipsych.info.InfoActivity;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    @Override
    public int getLayoutResource() {
        return R.layout.home_fragment_layout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle(R.string.home_activity_title);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewSetup(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.home_chat_button).setOnClickListener(this);
        view.findViewById(R.id.home_info_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if( view.getId() == R.id.home_chat_button ) {
            startActivity(ChatActivity.getStartIntent( getActivity() ));
        } else if( view.getId() == R.id.home_info_button ) {
            startActivity(InfoActivity.getStartIntent( getActivity() ));
        }
    }
}
