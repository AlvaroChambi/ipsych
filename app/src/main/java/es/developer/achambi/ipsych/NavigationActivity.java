package es.developer.achambi.ipsych;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import es.developer.achambi.ipsych.chat.ChatFragment;
import es.developer.achambi.ipsych.profile.ProfileFragment;

public class NavigationActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String CHAT_FRAGMENT_TAG = "chat_fragment_tag";
    private static final String PROFILE_FRAGMENT_TAG = "profile_fragment_tag";
    private NavigationFragment chatFragment;
    private NavigationFragment profileFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_layout);
        if( savedInstanceState == null ) {
            chatFragment = ChatFragment.newInstance();
            profileFragment = ProfileFragment.newInstance();

            replaceFragment( chatFragment, CHAT_FRAGMENT_TAG );
        }
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    private void replaceFragment( NavigationFragment fragment, String tag ) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace( R.id.navigation_fragment_frame, fragment, tag )
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.navigation_menu_chat:
                replaceFragment( chatFragment, CHAT_FRAGMENT_TAG );
                break;
            case R.id.navigation_menu_profile:
                replaceFragment( profileFragment, PROFILE_FRAGMENT_TAG );
                break;
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        chatFragment = (NavigationFragment) getSupportFragmentManager()
                .findFragmentByTag( CHAT_FRAGMENT_TAG );
        if( chatFragment == null ) {
            chatFragment = ChatFragment.newInstance();
        }
        profileFragment = (NavigationFragment) getSupportFragmentManager()
                .findFragmentByTag( PROFILE_FRAGMENT_TAG );
        if( profileFragment == null ) {
            profileFragment = ProfileFragment.newInstance();
        }
    }
}
