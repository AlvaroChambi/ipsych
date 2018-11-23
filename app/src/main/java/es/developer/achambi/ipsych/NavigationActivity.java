package es.developer.achambi.ipsych;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import es.developer.achambi.ipsych.home.HomeFragment;
import es.developer.achambi.ipsych.profile.ProfileFragment;

public class NavigationActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String HOME_FRAGMENT_TAG = "home_fragment_tag";
    private static final String PROFILE_FRAGMENT_TAG = "profile_fragment_tag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_layout);
        if( savedInstanceState == null ) {
            replaceFragment( HomeFragment.newInstance(), HOME_FRAGMENT_TAG );
        }
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    private void replaceFragment( Fragment fragment, String tag ) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace( R.id.navigation_fragment_frame, fragment, tag )
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.navigation_menu_home:
                replaceFragment( HomeFragment.newInstance(), HOME_FRAGMENT_TAG );
                break;
            case R.id.navigation_menu_profile:
                replaceFragment( ProfileFragment.newInstance(), PROFILE_FRAGMENT_TAG );
                break;
        }
        return true;
    }
}
