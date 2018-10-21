package es.developer.achambi.ipsych.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import java.util.Arrays;
import java.util.List;

import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;
import es.developer.achambi.ipsych.chat.ChatActivity;

import static android.app.Activity.RESULT_OK;

public class LoginFragment extends BaseFragment {
    private static final int SIGN_IN_REQUEST_CODE = 101;

    @Override
    public int getLayoutResource() {
        return R.layout.base_activity;
    }

    @Override
    public void onViewSetup(View view, @Nullable Bundle savedInstanceState) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build() );
        startActivityForResult( AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders( providers )
                .build(), SIGN_IN_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == SIGN_IN_REQUEST_CODE ) {
            IdpResponse response = IdpResponse.fromResultIntent( data );

            if( resultCode == RESULT_OK ) {
                startActivity( new Intent( getActivity(), ChatActivity.class) );
            } else {
                if( response != null ){
                    Snackbar snackbar = Snackbar.make( getView(),
                            response.getError().getMessage(), Snackbar.LENGTH_INDEFINITE );
                    snackbar.show();
                }
            }
        }
    }
}
