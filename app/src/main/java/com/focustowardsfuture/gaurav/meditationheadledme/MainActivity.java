package com.focustowardsfuture.gaurav.meditationheadledme;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.focustowardsfuture.gaurav.meditationheadledme.Adapter.PagerAdapter;


public class MainActivity extends AppCompatActivity  {

    TabLayout tabLayout;
    ViewPager viewPager;
    int CurrentPosition=0;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* toolbar=findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);*/
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


        viewPager=findViewById(R.id.myviewpager);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


      viewPager.setOffscreenPageLimit(4);



    }

   }
