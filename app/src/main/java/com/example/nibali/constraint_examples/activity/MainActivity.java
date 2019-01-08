package com.example.nibali.constraint_examples.activity;


import android.databinding.*;
import android.os.Bundle;


import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.base.AbstractBaseActivity;

import com.example.nibali.constraint_examples.databinding.ActivityMainBinding;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

import com.vk.sdk.api.model.VKApiUser;


import javax.inject.Inject;


public class MainActivity extends AbstractBaseActivity{

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    VKApiUser user;

    private Drawer drawer;
    private PrimaryDrawerItem newsItem;
    private PrimaryDrawerItem searchItem;

    //TODO свой фрагмент вставить
   // private AudioListFragment myAudioFragment;

    private ActivityMainBinding binding;

    @Override
    protected void inject() {
        ((Application) getApplication()).getUserComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        createNavigationDrawer();
    }
    private void createNavigationDrawer() {
        String photo = getString(R.string.url_empty_avatar);
        try {
            photo = user.fields.getString("photo_big");
        } catch (Exception ignored) {
        }
        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.side_nav_bar)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withEmail(user.first_name)
                                .withIcon(photo)
                )
                .build();

        PrimaryDrawerItem aboutItem = new PrimaryDrawerItem()
                .withName(getString(R.string.about))
                .withSelectable(false)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    new LibsBuilder()
                            .withActivityTitle(getString(R.string.about))
                            .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                            .start(MainActivity.this);
                    return false;
                })
                .withIcon(GoogleMaterial.Icon.gmd_info);


        newsItem = new PrimaryDrawerItem()
                .withName(R.string.news)
                .withIcon(GoogleMaterial.Icon.gmd_event)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {

                    return true;
                });

        searchItem = new PrimaryDrawerItem()
                .withName(R.string.search)
                .withIcon(GoogleMaterial.Icon.gmd_search)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {

                    return true;
                });


        drawer = new DrawerBuilder().withActivity(this)
                .withToolbar(binding.toolbar)
                .withAccountHeader(header)
                .addDrawerItems(
                        newsItem,
                        searchItem
                )
                .addStickyDrawerItems(aboutItem)
                .build();

        drawer.setOnDrawerItemLongClickListener((view, position, drawerItem) -> {
            Object tag = drawerItem.getTag();
            if (tag != null ) {
                return true;
            }
            return false;
        });
    }


}
