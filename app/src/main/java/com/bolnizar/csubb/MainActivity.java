package com.bolnizar.csubb;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.bolnizar.csubb.fragments.FIlterFragment;
import com.bolnizar.csubb.fragments.NewsFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;
    private Fragment mNewsFragment;
    private Fragment mFilterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNewsFragment = new NewsFragment();
        mFilterFragment = new FIlterFragment();
        setupBottomBar(savedInstanceState);
    }

    private void setupBottomBar(Bundle savedInstanceState) {
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottom_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottom_menu_filter) {
                    showFilters();
                } else {
                    showList();
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
    }

    private void showList() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_root, mNewsFragment).commit();
    }

    private void showFilters() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_root, mFilterFragment).commit();
    }
}
