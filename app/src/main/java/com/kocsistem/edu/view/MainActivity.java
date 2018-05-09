package com.kocsistem.edu.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.kocsistem.edu.R;
import com.kocsistem.edu.adapter.FilmListAdapter;
import com.kocsistem.edu.adapter.MainPageFragmentsAdapter;
import com.kocsistem.edu.model.FilmModel;
import com.kocsistem.networking.KSNetworkConfig;
import com.kocsistem.networking.KSNetworkingFactory;
import com.kocsistem.networking.listener.KSNetworkResponseListener;
import com.kocsistem.networking.model.ErrorModel;
import com.kocsistem.networking.model.ResultModel;

import java.util.List;

/**
 * Created by umutboz on 07,May,2018
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);
        KSNetworkingFactory.init(getApplicationContext());
        KSNetworkConfig.getInstance().enableLog(true);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_title);
        setUpNavigationView();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        MainPageFragmentsAdapter mainPageFragmentsAdapter = new MainPageFragmentsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPageFragmentsAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);


    }

    void  setUpNavigationView()
    {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView =(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_open);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });

    }
    void openDrawer()
    {
        drawerLayout.openDrawer(Gravity.START);
    }

    void closeDrawer()
    {
        drawerLayout.closeDrawer(Gravity.START);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        String menuTitle = item.getTitle().toString();
        //centerText.setText(menuTitle);
        closeDrawer();
        return true;
    }

}
