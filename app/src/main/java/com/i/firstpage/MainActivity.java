package com.i.firstpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.i.firstpage.HelperClasses.HelperAdapter.CategoryAdapter;
import com.i.firstpage.HelperClasses.HelperAdapter.CategoryHelperClass;
import com.i.firstpage.HelperClasses.HelperAdapter.FeaturedAdapter;
import com.i.firstpage.HelperClasses.HelperAdapter.FeaturedHelperClass;
import com.i.firstpage.HelperClasses.HelperAdapter.MostViewedAdapter;
import com.i.firstpage.HelperClasses.HelperAdapter.MostViewedHelperClass;
import com.i.firstpage.User.AllCategories;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

static final float END_SCALE =  0.7f;
    RecyclerView featuredRecycler, categoryRecycler, mostViewedRecycler;
    RecyclerView.Adapter adapter, adapterCategory, adapterMostViewed;


    //Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    //menu
    ImageView menu;

    LinearLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        featuredRecycler = findViewById(R.id.featured_recycle);
        featuredRecycler();

        categoryRecycler = findViewById(R.id.category_recycle);
        categoryRecycler();


        mostViewedRecycler = findViewById(R.id.most_viewed_recycle);
        mostViewedRecycler();


        //menu hooks

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menu = findViewById(R.id.menu_icon);

        contentView = findViewById(R.id.content);
//Navigation Dawer

        navigationDrawer();
        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
       drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener(){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
              //  super.onDrawerSlide(drawerView, slideOffset);
                final float diffScaleOffset = slideOffset *(1 - END_SCALE);
                final float offsetScale = 1 - diffScaleOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //Translate the view
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaleOffset / 2 ;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);


            }


        });


    }

    //Navigation Drawers fonctions
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
        super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_all_categories:
                startActivity( new Intent(getApplicationContext(), AllCategories.class));
                break;
        }




        return true;
    }


    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.disc, "First step", "Quis nostrud exercitation ullamco "));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.phone, "Second step", "Aaliquip ex ea commodo consequat."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.sound, "Third step", "Nemo enim ipsam"));
        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff440, 0xffaff600});

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            featuredRecycler.setBackground(gradient1);
        }


    }

    private void categoryRecycler() {

        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> categoryLocations = new ArrayList<>();

        categoryLocations.add(new CategoryHelperClass(R.drawable.disc, "Category 3"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.phone, "Category 4"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.sound, "Category 1"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.good, "Category 2"));
        adapterCategory = new CategoryAdapter(categoryLocations);
        categoryRecycler.setAdapter(adapterCategory);


    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.disc, "Category 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit,", 5, R.color.card3));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.phone, "Category 2", "Sed do eiusmod tempor incididunt ", 4, R.color.card4));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.sound, "Category 3", "Duis aute irure dolor in", 3, R.color.card1));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.good, "Category 4", "Excepteur sint occaecat cupidatat", 4, R.color.card2));
        adapterMostViewed = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapterMostViewed);


    }


}
