package com.focustowardsfuture.gaurav.meditationheadledme;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class dailyquote extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private static final String BASE_URL="https://dwiveditech.000webhostapp.com/";
     public static TextView pName,pEmail,pPhone;
     Button getDatabtn;
     MainActivity mainActivity;
    Context context;
    String name,mobile,email;
    public dailyquote() {
        // Required empty public constructor
    }

    public static dailyquote  newInstance() {

        dailyquote fragment = new dailyquote();
        Bundle args = new Bundle();
        // args.putString(ARG_PARAM1, param1);
        //  args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dailyquote, container, false);
        getDatabtn=(Button) view.findViewById(R.id.getDatabtn);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            // mParam2 = getArguments().getString(ARG_PARAM2);
          /*  fetchData process =new fetchData();
            process.execute();*/

        }

           context = mainActivity.getApplicationContext();
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        dwiveditech dwiveditech =retrofit.create(com.focustowardsfuture.gaurav.meditationheadledme.dwiveditech.class);
        Call<Content> call = dwiveditech.getData();

        call.enqueue(new Callback<Content>() {
            @Override
            public void onResponse(Call<Content> call, Response<Content> response) {


                Log.d("TAG","onResponse : Server Response"+response.toString());
                Log.d("TAG","onResponse: received information"+response.body().toString());

                name =response.body().getpName();
                email=response.body().getpEmail();
                mobile=response.body().getpMobile();

                Log.d("TAG", "onResponse: \n ");

            }

            @Override
            public void onFailure(Call<Content> call, Throwable t) {
                Log.e("ErrorOccured","on Failure :Something went wrong"+t.getMessage());
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
