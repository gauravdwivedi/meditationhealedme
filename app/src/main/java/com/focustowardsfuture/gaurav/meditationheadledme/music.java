package com.focustowardsfuture.gaurav.meditationheadledme;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link music#newInstance} factory method to
 * create an instance of this fragment.
 */
public class music extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView txt1,txt2,timertext;
    MediaPlayer mediaPlayer;
    Button btnStop,btnPlay;
    private CountDownTimer countDownTimer;
    private long timeleftinmiliseconds =900000; //15 min 00 sec
    boolean isTimmerRunning =false;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public music() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment music.
     */
    // TODO: Rename and change types and number of parameters
    public static music newInstance() {
        music fragment = new music();
        Bundle args = new Bundle();
      //  args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_music, container, false);
        timertext =view.findViewById(R.id.txtfragment2);
        btnPlay= view.findViewById(R.id.btnplay2);
        btnStop=view.findViewById(R.id.btnstop2);
        updateTimer();
        //text.setText(getArguments().getString(ARG_PARAM1));
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
                if(isTimmerRunning){
                    stopTimer();
                }else{
                    startTimer();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSong();
                stopTimer();
                updateTimer();
            }
        });

        return view;
    }
    private void stopSong() {

        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
            btnStop.setVisibility(View.INVISIBLE);
            btnPlay.setVisibility(View.VISIBLE);

        }
        else{
            if(mediaPlayer==null) {
                Toast.makeText(getContext(), "Music already Stopped", Toast.LENGTH_SHORT).show();
            }else{
                btnStop.setVisibility(View.INVISIBLE);
                btnPlay.setVisibility(View.VISIBLE);
            }
        }
    }

    private void playSong() {

        mediaPlayer=new MediaPlayer();
        if(mediaPlayer.isPlaying()){
            Toast.makeText(getContext(), "Music is Already Playing", Toast.LENGTH_SHORT).show();

        }
        else {
            //mediaPlayer.setDataSource("https://dwiveditech.000webhostapp.com/meditation/kundaliniguidedmeditation.mp3");
            // mediaPlayer.setDataSource("https://sg2plcpnl0010.prod.sin2.secureserver.net:2083/cpsess2606629521/frontend/paper_lantern/filemanager/showfile.html?file=kundaliniguidedmeditation.mp3&fileop=&dir=%2Fhome%2Fg49olcw8wyvz%2Fpublic_html&dirop=&charset=&file_charset=&baseurl=&basedir=");
            mediaPlayer =MediaPlayer.create(getContext(),R.raw.min15music);
            mediaPlayer.start();
            btnPlay.setVisibility(View.INVISIBLE);
            btnStop.setVisibility(View.VISIBLE);
           /*     mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                        btnPlay.setVisibility(View.INVISIBLE);
                        btnStop.setVisibility(View.VISIBLE);

                    }
                });*/



        }
    }



    public  void startTimer() {

        countDownTimer=new CountDownTimer(timeleftinmiliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmiliseconds=millisUntilFinished;
                if(timeleftinmiliseconds==0){
                    stopSong();
                }else{
                    updateTimer();}
            }



            @Override
            public void onFinish() {

            }
        }.start();
        isTimmerRunning =true;

    }

    private void updateTimer() {

        int minutes =(int) timeleftinmiliseconds/60000;
        int seconds =(int) timeleftinmiliseconds%60000/1000;

        String timeLeftText;

        timeLeftText=""+minutes;
        timeLeftText +=":";
        if(seconds<10) timeLeftText+="0";
        timeLeftText+=seconds;

        timertext.setText(timeLeftText);


    }

    public void stopTimer() {
        countDownTimer.cancel();
        isTimmerRunning=false;
        timeleftinmiliseconds=900000; //15 min 00 sec

    }

    /*@Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(this.isVisible()){

            if(!isVisibleToUser) {

            stopSong();
            }
        }

    }*/
}
