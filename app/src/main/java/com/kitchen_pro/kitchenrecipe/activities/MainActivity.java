package com.kitchen_pro.kitchenrecipe.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.kitchen_pro.kitchenrecipe.R;
import com.kitchen_pro.kitchenrecipe.fragments.CocinaDelMundoFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation_drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_cocina_del_mundo));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int menuItemId = menuItem.getItemId();
        Fragment fragment = getFragment(menuItem);

        if (fragment != null) {
            navigationView.setCheckedItem(menuItemId);

            // Highlight the selected item, update the title, and close the drawer
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            drawerLayout.closeDrawers();

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit();
        }
        return true;
    }

    private Fragment getFragment(MenuItem menuItem) {
        Class fragmentClass = null;
        Fragment fragment = null;
        int menuItemId = menuItem.getItemId();

        switch (menuItemId) {
            case R.id.nav_cocina_del_mundo:
                fragmentClass = CocinaDelMundoFragment.class;
                break;
            case R.id.nav_gallery:
//                fragmentClass = StarredFragment.class;
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
//                Toast.makeText(MainActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
//                startActivity(intent);
                break;
            case R.id.nav_send:
//                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }

        if(fragmentClass != null) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return fragment;
    }
}
