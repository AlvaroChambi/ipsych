package es.developer.achambi.ipsych.profile;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.auth.FirebaseAuth;

import es.developer.achambi.coreframework.ui.Presenter;
import es.developer.achambi.ipsych.NavigationFragment;
import es.developer.achambi.ipsych.R;
import es.developer.achambi.ipsych.login.LoginActivity;

public class ProfileFragment extends NavigationFragment implements View.OnClickListener {
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    private ProfilePresenter presenter;

    @Override
    public int getLayoutResource() {
        return R.layout.profile_fragment_layout;
    }

    @Override
    public Presenter setupPresenter() {
        if( presenter == null ) {
            presenter = new ProfilePresenter();
        }
        return presenter;
    }

    @Override
    public void onViewSetup(View view, @Nullable Bundle savedInstanceState) {
        View logoutButton = view.findViewById(R.id.profile_logout_button);
        final TextView profileName = view.findViewById(R.id.profile_user_name_text);
        ImageView profilePhoto = view.findViewById(R.id.profile_photo_image_view);
        profileName.setText( presenter.getProfileName() );
        Glide.with(getActivity())
                .load(presenter.getPhotoUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(profilePhoto);
        logoutButton.setOnClickListener(this);
    }

    @Override
    public int getTitleResource() {
        return R.string.profile_activity_title;
    }

    @Override
    public void onClick(View view) {
        if( view.getId() == R.id.profile_logout_button ) {
            FirebaseAuth.getInstance().signOut();
            startActivity(LoginActivity.getStartIntent( getActivity() ) );
            getActivity().finish();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
