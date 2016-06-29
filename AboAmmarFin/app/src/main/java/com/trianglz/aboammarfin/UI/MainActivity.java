package com.trianglz.aboammarfin.UI;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.trianglz.aboammarfin.Fragment.AboutFragment;
import com.trianglz.aboammarfin.Fragment.AccessoriesFragment;
import com.trianglz.aboammarfin.Fragment.ElectronicFragment;
import com.trianglz.aboammarfin.Fragment.HomeFragment;
import com.trianglz.aboammarfin.Fragment.LaptopFragment;
import com.trianglz.aboammarfin.Fragment.MobileFragment;
import com.trianglz.aboammarfin.Fragment.SettingsFragment;
import com.trianglz.aboammarfin.R;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity {
    HomeFragment FRAGMENT_HOME;
    AboutFragment FRAGMENT_ABOUT;
    AccessoriesFragment FRAGMENT_ACCESSORIES;
    ElectronicFragment FRAGMENT_ELECTRONICS;
    LaptopFragment FRAGMENT_LAPTOP;
    MobileFragment FRAGMENT_MOBILE;
    SettingsFragment FRAGMENT_SETTINGS;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;
    private FloatingActionButton fabEdit;
    private List<FloatingActionMenu> menus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigation bottomNavigation = (BottomNavigation) findViewById(R.id.BottomNavigation);
        bottomNavigation.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(@IdRes int i, int i1) {
                switch (i){
                    case R.id.item1:
                        drawHome();
                        break;
                    case R.id.item2:
                        drawMobile();
                        break;
                    case R.id.item3:
                        drawLaptop();
                        break;
                    case R.id.item4:
                        drawElectronics();
                        break;
                    case R.id.item5:
                        drawAccessories();
                        break;

                }
            }

            @Override
            public void onMenuItemReselect(@IdRes int i, int i1) {

            }
        });
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Call",Toast.LENGTH_LONG).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Email",Toast.LENGTH_LONG).show();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Facebook",Toast.LENGTH_LONG).show();
            }
        });
        drawHome();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item_settings:
                drawSettings();
                break;
            case R.id.item_about:
                drawAbout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void drawHome(){
        FRAGMENT_HOME = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_HOME);
        transaction.commit();
    }
    public void drawAbout(){
        FRAGMENT_ABOUT = new AboutFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_ABOUT);
        transaction.commit();
    }
    public void drawAccessories(){
        FRAGMENT_ACCESSORIES = new AccessoriesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_ACCESSORIES);
        transaction.commit();
    }
    public void drawElectronics(){
        FRAGMENT_ELECTRONICS = new ElectronicFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_ELECTRONICS);
        transaction.commit();
    }
    public void drawLaptop(){
        FRAGMENT_LAPTOP = new LaptopFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_LAPTOP);
        transaction.commit();
    }
    public void drawMobile(){
        FRAGMENT_MOBILE = new MobileFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_MOBILE);
        transaction.commit();
    }
    public void drawSettings(){
        FRAGMENT_SETTINGS = new SettingsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, FRAGMENT_SETTINGS);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
