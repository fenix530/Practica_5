package com.example.diegoorozco.practica_5;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        double n=getDiagonalInch(this);

        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        if(n>7)
        {
            ActionBar.Tab tab = actionBar.newTab().setText("HOME").setTabListener(this);
            tab.setIcon(R.drawable.home);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText(getString(R.string.Cine)).setTabListener(this);
            tab.setIcon(R.drawable.cine);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText(R.string.Teatro).setTabListener(this);
            tab.setIcon(R.drawable.ic_action_mscaras_del_teatro_22305789);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText(getString(R.string.Rumba)).setTabListener(this);
            tab.setIcon(R.drawable.ic_action_cerveza);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText(getString(R.string.Rest)).setTabListener(this);
            tab.setIcon(R.drawable.ic_action_food);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText(getString(R.string.Sitos)).setTabListener(this);
            tab.setIcon(R.drawable.ic_action_travel);
            actionBar.addTab(tab);
        }
        else
        {
            ActionBar.Tab tab = actionBar.newTab().setIcon(R.drawable.home).setTabListener(this);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setIcon(R.drawable.cine).setTabListener(this);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setIcon(R.drawable.ic_action_mscaras_del_teatro_22305789).setTabListener(this);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setIcon(R.drawable.ic_action_cerveza).setTabListener(this);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setIcon(R.drawable.ic_action_food).setTabListener(this);
            actionBar.addTab(tab);

            tab = actionBar.newTab().setIcon(R.drawable.ic_action_travel).setTabListener(this);
            actionBar.addTab(tab);
        }

    }

    public static double getDiagonalInch  ( Activity Actividad )   { //Funcion para determinar el tamaño de la pantalla
        DisplayMetrics metrics = new DisplayMetrics();

        WindowManager wm = (WindowManager) Actividad.getSystemService(
                Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        final int measuredwidth = metrics.widthPixels;
        final int measuredheight = metrics.heightPixels;

        final double diagonal = Math.sqrt((measuredwidth * measuredwidth)
                + (measuredheight * measuredheight));


        double diaInch = diagonal / metrics.densityDpi;

        return diaInch;

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new PrinListFragment();
                case 1:
                    return new CineFragment();
                case 2:
                    return new TeatroFragment();
                case 3:
                    return new RumbaFragment();
                case 4:
                    return new RestauranteFrag();
                case 5:
                    return new SitiosFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 6; //Se retorna el numero total de fragments de la app
        }
    }
}