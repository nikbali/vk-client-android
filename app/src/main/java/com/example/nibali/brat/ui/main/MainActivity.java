package com.example.nibali.brat.ui.main;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.example.nibali.brat.BratApplication;
import com.example.nibali.brat.R;
import com.example.nibali.brat.ui.base.AbstractBaseActivity;
import com.example.nibali.brat.ui.friends.FriendsFragment;
import com.example.nibali.brat.ui.news.NewsfeedFragment;


import com.squareup.picasso.Picasso;
import com.vk.sdk.api.model.VKApiUser;


import javax.inject.Inject;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AbstractBaseActivity{

    @Inject
    VKApiUser user;

    private NewsfeedFragment newsfeedFragment;
    private FriendsFragment friendsFragment;
    private DrawerLayout drawerLayout;

    Toolbar toolbar;
    NavigationView mNavigationView;

    private TextView mNameTextView;
    private TextView mEmailTextView;
    private CircleImageView mProfileImageView;

    @Override
   protected void inject() {
        ((BratApplication) getApplication()).getUserComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsfeedFragment = new NewsfeedFragment();
        friendsFragment = new FriendsFragment();

        configureNavigationDrawer();
        configureToolbar();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_main, newsfeedFragment, NewsfeedFragment.class.getName())
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_items, menu);
        return true;
    }
    private void configureToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        actionbar.setDisplayHomeAsUpEnabled(true);

    }
    private void configureNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation);

        View headerLayout = mNavigationView.getHeaderView(0);
        mProfileImageView = (CircleImageView) headerLayout.findViewById(R.id.userImageView);
        Picasso.get().load(user.photo_100)
                .into(mProfileImageView);

        mNameTextView = (TextView) headerLayout.findViewById(R.id.name);
        mNameTextView.setText(user.last_name + " " + user.first_name);

        mNavigationView.setNavigationItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.friends) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main, friendsFragment);
                transaction.commit();
                drawerLayout.closeDrawers();
                return true;
            } else if (itemId == R.id.news) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main, newsfeedFragment);
                transaction.commit();
                drawerLayout.closeDrawers();
                return true;
            }
            return false;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch(itemId) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return true;
    }
    public void setActionBarTitle(String title) {
       getSupportActionBar().setTitle(title);
  }
}
