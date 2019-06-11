package com.example.mymosque;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymosque.Fragments.FragmentAddMosque;
import com.example.mymosque.Fragments.FragmentDua;
import com.example.mymosque.Fragments.FragmentFavorite;
import com.example.mymosque.Fragments.FragmentFeedback;
import com.example.mymosque.Fragments.FragmentHome;
import com.example.mymosque.Fragments.FragmentMasajidList;
import com.example.mymosque.Fragments.FragmentMyMosque;
import com.example.mymosque.Fragments.FragmentNearestJummah;
import com.example.mymosque.Fragments.FragmentNearestMasajid;
import com.example.mymosque.Fragments.FragmentNotification;
import com.example.mymosque.Fragments.FragmentQiblaDirection;
import com.example.mymosque.Fragments.FragmentSettings;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
{

    private ImageView       Humbburger;
    private DrawerLayout    mDrawerLayout;
    private ImageView       backbutton;
    private TextView        shareapp;

    private TextView home_;
    private TextView Feedback_;
    private TextView Dua_;
    private TextView fragmentmassajilist_;
    private TextView fragmentnearestmassajid_;
    private TextView fragmentnearestjummah_ ;
    private TextView fragmentsettings_;
    private TextView fragmentnotification_;
    private TextView fragmentaddmosque_;
    private TextView fragqibla;
    private TextView fragmentfavorite;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    private void Init()
    {
        //Button Initialization
        backbutton                  = findViewById(R.id.backButton);
        Humbburger                  = findViewById(R.id.humburgerIcon);
        mDrawerLayout               = findViewById(R.id.drawer_layout);

        //TextView Initialization
        shareapp                    = findViewById(R.id.text12);
        home_                       = findViewById(R.id.text1);
        Feedback_                   = findViewById(R.id.text11);
        Dua_                        = findViewById(R.id.text9);
        fragmentmassajilist_        = findViewById(R.id.text3);
        fragmentnearestmassajid_    = findViewById(R.id.text4);
        fragmentnearestjummah_      = findViewById(R.id.text5);
        fragmentsettings_           = findViewById(R.id.text10);
        fragmentnotification_       = findViewById(R.id.text7);
        fragmentaddmosque_          = findViewById(R.id.text8);
        fragqibla                   = findViewById(R.id.text6);
        fragmentfavorite            = findViewById(R.id.text2);

        //NavigationView Initialization
        navigationView              = findViewById(R.id.nav_view);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        shareapp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        Humbburger.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("RtlHardcoded")
            @Override
            public void onClick(View v)
            {
                mDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showHome();
            }
        });


        home_       .setOnClickListener(this);
        Feedback_   .setOnClickListener(this);
        Dua_        .setOnClickListener(this);
        fragmentnearestmassajid_    .setOnClickListener(this);
        fragmentnearestjummah_      .setOnClickListener(this);
        fragmentsettings_           .setOnClickListener(this);
        fragmentnotification_       .setOnClickListener(this);
        fragmentaddmosque_          .setOnClickListener(this);
        fragqibla                   .setOnClickListener(this);
        fragmentfavorite            .setOnClickListener(this);

        FragmentHome myf = new FragmentHome();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.Screen_Area, myf);
        transaction.commit();


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,  R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {

            @Override
            public void onDrawerClosed(View v)
            {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v)
            {
                super.onDrawerOpened(v);
            }

            @SuppressLint("RtlHardcoded")
            @Override
            public boolean onOptionsItemSelected(MenuItem item)
            {
                if (item != null && item.getItemId() == android.R.id.home)
                {
                    if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT))
                    {
                        mDrawerLayout.closeDrawer(Gravity.RIGHT);
                    } else
                    {
                        mDrawerLayout.openDrawer(Gravity.RIGHT);
                    }
                }
                return false;
            }
        };

        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (doubleBackToExitPressedOnce)
        {
            super.onBackPressed();
            return;
        }
        else
            {
            showHome();
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            // Handle the camera action
        }
        else if (id == R.id.nav_gallery)    { }
        else if (id == R.id.nav_slideshow)  { }
        else if (id == R.id.nav_manage)     { }
        else if (id == R.id.nav_share)      { }
        else if (id == R.id.nav_send)       { }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    Fragment fragment = null;
    private  void showHome()
    {
        fragment = new FragmentHome();
        if(fragment!=null)
        {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Screen_Area, fragment ,fragment.getTag()).commit();
        }
    }

    @Override
    public void onClick(View v)
    {
        Fragment fragment = null;
        Class fragmentClass = null;
        if(v.getId() == R.id.text1)
        {
            //do something here if button1 is clicked
            fragmentClass = FragmentMyMosque.class;
        }

        else if (v.getId() == R.id.text4)
        {
            fragmentClass = FragmentNearestMasajid.class;
            //do something here if button3 is clicked
           // fragmentClass = FragmentLevel.class;
        }
        else if (v.getId() == R.id.text5){
            //do something here if button3 is clicked
           // fragmentClass = FragmentNotification.class;
            fragmentClass = FragmentNearestJummah.class;
        }
        else if (v.getId() == R.id.text6)
        {
            //do something here if button3 is clicked
           // fragmentClass = FragmentAboutUS.class;
            fragmentClass = FragmentQiblaDirection.class;
        }
        else if (v.getId() == R.id.text11)
        {
            //do something here if button3 is clicked
           fragmentClass = FragmentFeedback.class;
        }
        else if (v.getId() == R.id.text9)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentDua.class;
        }
        else if (v.getId() == R.id.text3)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentMasajidList.class;
        }
        else if (v.getId() == R.id.text10)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentSettings.class;
        }

        else if (v.getId() == R.id.text7)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentNotification.class;
        }

        else if (v.getId() == R.id.text8)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentAddMosque.class;
        }
        else if (v.getId() == R.id.text2)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentFavorite.class;
        }


        if(fragment!=null)
        {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Screen_Area, fragment ,fragment.getTag()).commit();
        }

        try
        {
            assert fragmentClass != null;
            fragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        assert fragment != null;
        fragmentManager.beginTransaction().replace(R.id.Screen_Area, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
