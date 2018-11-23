package es.developer.achambi.ipsych.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;

public class InfoFragment extends BaseFragment{
    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.base_activity;
    }

    @Override
    public void onViewSetup(View view, @Nullable Bundle savedInstanceState) {

    }
}
