package com.sabthok.aapp;

import android.os.Bundle;
import com.getbase.floatingactionbutton.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    int Counter = 0;
//    Menu DrawerMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_action_1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu menu = navigationView.getMenu();
                menu.add("Menu Item " + Counter++);

                Snackbar.make(view, "Menu Item Added", Snackbar.LENGTH_SHORT).show();
            }
        });

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        Menu DrawerMenu = navigationView.getMenu();
        InflateDrawerMenu(DrawerMenu);

        navigationView.setNavigationItemSelectedListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }

    private void InflateDrawerMenu(Menu DrawerMenu) {
        final int groupId = 9952;
        DrawerMenu.add("Home");
        DrawerMenu.getItem(0).setIcon(R.drawable.ic_home);


        SubMenu ShopMenu = DrawerMenu.addSubMenu("Shop");

        ShopMenu.add("Premium");
        ShopMenu.add("Featured");
        ShopMenu.add("Recommended");

        for (int i=0; i< ShopMenu.size();i++){
            // TODO change the icon resource
            ShopMenu.getItem(i).setIcon(R.drawable.ic_drawer);
        }

        SubMenu CategoriesMenu = DrawerMenu.addSubMenu("Categories");
        CategoriesMenu.add("Mobile Phones");
        CategoriesMenu.add("Automobiles");
        CategoriesMenu.add("Furniture");

        for (int i=0; i< CategoriesMenu.size();i++){
            // TODO change the icon resource
            CategoriesMenu.getItem(i).setIcon(R.drawable.ic_drawer);
        }

        Menu ActionMenu = navigationView.getMenu().addSubMenu("Actions");
        getMenuInflater().inflate(R.menu.menu_actions, ActionMenu);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actions, menu);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Toast.makeText(this, item.getTitle()+ " | " + id, Toast.LENGTH_SHORT).show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
