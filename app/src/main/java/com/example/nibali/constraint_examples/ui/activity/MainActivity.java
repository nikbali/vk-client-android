package com.example.nibali.constraint_examples.ui.activity;


import android.databinding.*;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;



import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.base.AbstractBaseActivity;
import com.example.nibali.constraint_examples.ui.fragment.friends.FriendsFragment;
import com.example.nibali.constraint_examples.ui.fragment.news.NewsfeedFragment;


import com.vk.sdk.api.model.VKApiUser;


import javax.inject.Inject;

public class MainActivity extends AbstractBaseActivity{

    @Inject
    VKApiUser user;

    private NewsfeedFragment newsfeedFragment;
    private FriendsFragment friendsFragment;

    private DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
   protected void inject() {
        ((Application) getApplication()).getUserComponent().inject(this);
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
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(menuItem -> {
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

//public class MainActivity extends AbstractBaseActivity{
//
//    private static final String TAG = MainActivity.class.getSimpleName();
//
//    @Inject
//    VKApiUser user;
//
//    private Drawer drawer;
//    private PrimaryDrawerItem newsItem;
//    private PrimaryDrawerItem friendsItem;
//    private PrimaryDrawerItem searchItem;
//
//    private NewsfeedFragment newsfeedFragment;
//    private FriendsFragment friendsFragment;
//
//    private ActivityMainBinding binding;
//
//    @Override
//    protected void inject() {
//        ((Application) getApplication()).getUserComponent().inject(this);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setSupportActionBar(binding.toolbar);
//
//        Toast.makeText(this, getSupportActionBar().getTitle(), Toast.LENGTH_LONG).show();
//
//
//        createNavigationDrawer();
//
//        newsfeedFragment = new NewsfeedFragment();
//        friendsFragment = new FriendsFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.content_main, newsfeedFragment, NewsfeedFragment.class.getName())
//                .commit();
//
//    }
//    private void createNavigationDrawer() {
//        String photo = getString(R.string.url_empty_avatar);
//        try {
//            photo = user.fields.getString("photo_big");
//        } catch (Exception ignored) {
//        }
//        AccountHeader header = new AccountHeaderBuilder()
//                .withActivity(this)
//                .withHeaderBackground(R.drawable.side_nav_bar)
//                .addProfiles(
//                        new ProfileDrawerItem()
//                                .withEmail(user.first_name +" "+  user.last_name)
//                                .withIcon(photo)
//                )
//                .build();
//
//        PrimaryDrawerItem aboutItem = new PrimaryDrawerItem()
//                .withName(getString(R.string.about))
//                .withSelectable(false)
//                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
//                    new LibsBuilder()
//                            .withActivityTitle(getString(R.string.about))
//                            .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
//                            .start(MainActivity.this);
//                    return false;
//                })
//                .withIcon(GoogleMaterial.Icon.gmd_info);
//
//
//        newsItem = new PrimaryDrawerItem()
//                .withName(R.string.news)
//                .withIcon(GoogleMaterial.Icon.gmd_event)
//                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
//
//                    return true;
//                });
//        friendsItem = new PrimaryDrawerItem()
//                .withName(R.string.friends)
//                .withIcon(GoogleMaterial.Icon.gmd_event)
//                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
//                    showFriendFragment();
//                    return true;
//                });
//
//        searchItem = new PrimaryDrawerItem()
//                .withName(R.string.search)
//                .withIcon(GoogleMaterial.Icon.gmd_search)
//                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
//
//                    return true;
//                });
//
//
//        drawer = new DrawerBuilder().withActivity(this)
//                .withToolbar(binding.toolbar)
//                .withAccountHeader(header)
//                .addDrawerItems(
//                        newsItem,
//                        friendsItem,
//                        searchItem
//                )
//                .addStickyDrawerItems(aboutItem)
//                .build();
//
//        drawer.setOnDrawerItemLongClickListener((view, position, drawerItem) -> {
//            Object tag = drawerItem.getTag();
//            if (tag != null ) {
//                return true;
//            }
//            return false;
//        });
//    }
//
//    private void showFriendFragment() {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.content_main, friendsFragment, FriendsFragment.class.getName())
//                .commit();
//
//        drawer.closeDrawer();
//        drawer.setSelection(friendsItem, false);
//    }
//
//    public void setActionBarTitle(String title) {
//        binding.toolbar.setTitle("ff");
//        getSupportActionBar().setTitle(title);
//    }
//}
