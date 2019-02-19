package com.focustowardsfuture.gaurav.meditationheadledme.Adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.focustowardsfuture.gaurav.meditationheadledme.dailyquote;
import com.focustowardsfuture.gaurav.meditationheadledme.guided;
import com.focustowardsfuture.gaurav.meditationheadledme.music;
import com.focustowardsfuture.gaurav.meditationheadledme.relax;


public class PagerAdapter extends FragmentPagerAdapter {



    public PagerAdapter(FragmentManager fm){
        super(fm);
      }


    @Override
    public Fragment getItem(int i) {
      /*  guided g =new guided();

        Bundle bundle =new Bundle();
        bundle.putString("message","Fragment : "+i);
        g.setArguments(bundle);
         return g;*/

    /*  Fragment fragment =guided.newInstance(myString);
        return fragment;
    */
        switch (i) {

            case 0:
                dailyquote frag0=dailyquote.newInstance();
                return frag0;

            case 1:
                guided frag1 = guided.newInstance();
                return frag1;
            case 2:
                music frag2 = music.newInstance();
                return frag2;
            case 3:
                relax frag3 = relax.newInstance();
                return frag3;
            default:
                return null;

        }
    }





    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch(position){

            case 0:
                return "Daily Quotes";

            case 1:
                return "Half an Hour Mediation";

            case 2:

                return "15 min meditation ";

            case 3:
                return "Relaxing Music";


                default:

                return null;

        }



    }
}
