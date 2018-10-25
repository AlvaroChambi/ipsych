package es.developer.achambi.ipsych;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import es.developer.achambi.coreframework.ui.BaseFragment;
import es.developer.achambi.ipsych.chat.ChatFragment;
import es.developer.achambi.ipsych.profile.ProfileFragment;

public class NavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_layout);

        addFragment( new ChatFragment() );

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch ( item.getItemId() ) {
                    case R.id.navigation_menu_chat:
                        addFragment( new ChatFragment() );
                        break;
                    case R.id.navigation_menu_profile:
                        addFragment( new ProfileFragment() );
                        break;
                }
                return true;
            }
        });
    }

    private void addFragment( NavigationFragment fragment ) {
        setTitle( fragment.getTitleText() );
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace( R.id.navigation_fragment_frame, fragment )
        .commit();
    }
}
