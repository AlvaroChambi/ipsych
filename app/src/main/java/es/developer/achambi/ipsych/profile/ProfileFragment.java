package es.developer.achambi.ipsych.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.R;
import es.developer.achambi.ipsych.login.LoginActivity;

public class ProfileFragment extends BaseFragment {
    @Override
    public int getLayoutResource() {
        return R.layout.profile_fragment_layout;
    }

    @Override
    public void onViewSetup(View view, @Nullable Bundle savedInstanceState) {
        View logoutButton = view.findViewById(R.id.profile_logout_button);
        TextView profileName = view.findViewById(R.id.profile_user_name_text);

        profileName.setText( FirebaseAuth.getInstance().getCurrentUser().getDisplayName() );

        logoutButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(LoginActivity.getStartIntent( getActivity() ) );
                        getActivity().finish();
                    }
                }
        );
    }
}
