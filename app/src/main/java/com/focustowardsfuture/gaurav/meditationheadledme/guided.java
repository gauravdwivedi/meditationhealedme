package com.focustowardsfuture.gaurav.meditationheadledme;

import android.media.MediaMetadataRetriever;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

import static com.focustowardsfuture.gaurav.meditationheadledme.R.raw.halfan;


public class guided extends Fragment {
    FirebaseDatabase database ;
    DatabaseReference myRef;
    MediaMetadataRetriever mediaMetadataRetriever;

     public final static String PAR_KEY="content";

    int I;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView timertext;
    boolean isTimmerRunning =false;
    Button btnPlay,btnStop;
    private MediaPlayer mediaPlayer;
    private String mParam1;
    private String mParam2;
    private MainActivity mainActivity;
    private CountDownTimer countDownTimer;
    private long timeleftinmiliseconds =2015000; //33 min 35 sec



    public guided() {
        // Required empty public constructor
    }

    public static guided newInstance() {

        guided fragment = new guided();
        Bundle args = new Bundle();
       // args.putString(ARG_PARAM1, param1);
      //  args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
       // database =FirebaseDatabase.getInstance();
        //myRef=database.getReference();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guided, container, false);
        timertext =view.findViewById(R.id.txtfragment);
        btnPlay= view.findViewById(R.id.btnplay);
        btnStop=view.findViewById(R.id.btnstop);
        updateTimer();
           // timertext.setText(getArguments().getString(ARG_PARAM1));
            mediaPlayer=null;
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
            }
        });

        return view;





    }

  /*  public void startStop() {

        if(isTimmerRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }*/

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
        timeleftinmiliseconds=2015000; //33 min 35 sec

    }

    private void stopSong() {

        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            btnStop.setVisibility(View.INVISIBLE);
            btnPlay.setVisibility(View.VISIBLE);
            stopTimer();
            updateTimer();


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
                mediaPlayer =MediaPlayer.create(getContext(), halfan);
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

  /*  @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
try {
    if (this.isVisible()) {

        if (!isVisibleToUser) {

            stopSong();

        }
    }
}catch (Exception e){
    Log.d("MediaplayerError", String.valueOf(e.getStackTrace()));
}
    }*/

}
