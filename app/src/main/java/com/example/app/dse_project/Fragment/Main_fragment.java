package com.example.app.dse_project.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.app.dse_project.All_adapter.FragmentDrawer;
import com.example.app.dse_project.R;

public class Main_fragment extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {


    // decalre android lime toolbar object
    Toolbar androidlime_toolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        // linking with xml
        androidlime_toolbar = findViewById(R.id.toolbar);
        // giving actionbar support
        setSupportActionBar(androidlime_toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), androidlime_toolbar);
        drawerFragment.setDrawerListener(this);

        if (savedInstanceState == null) {
            displayView(0);
        }

    }


    //back button

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.iconwa).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                }).setNegativeButton("No", null).show();
    }

    //back button end

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new Dashboard_Fragment();
                title = getString(R.string.title_dashboard);
                break;
            case 1:
                fragment = new Home_Web_update_Fragment();
                title = getString(R.string.title_home);
                break;
            case 2:
                fragment = new Update_Fragment();
                title = getString(R.string.title_updatemarket);
                break;
            case 3:
                fragment = new About_Fragment();
                title = getString(R.string.title_about);
                break;
            default:
                fragment = new Home_Web_update_Fragment();
                title = getString(R.string.title_dashboard);
                break;

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
