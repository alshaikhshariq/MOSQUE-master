package com.example.mymosque.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymosque.API;
import com.example.mymosque.AdArrayList;
import com.example.mymosque.AdModel;
import com.example.mymosque.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentMyMosque extends Fragment
{
    private ArrayList adList= new ArrayList();
    private AdModel adModel;

    private ImageView AdBanner;

    View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getAdvert("http://masjidi.co.uk/api/", 33);
    }//end of onCreate method

    public void getAdvert(String url, int userid)
    {
        Retrofit retrofit2 = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        API api = retrofit2.create(API.class);

        Call<ArrayList<AdModel>> call = api.getAds(userid);

        call.enqueue(new Callback<ArrayList<AdModel>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<ArrayList<AdModel>> call, Response<ArrayList<AdModel>> response)
            {
                adList = response.body();
                
            }

            @Override
            public void onFailure(Call<ArrayList<AdModel>> call, Throwable t) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_my_masjid, container, false);
        //<For Toolbar>
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("My Mosque");
        //</For Toolbar>

        Button prayertimesBtn = (Button) v.findViewById(R.id.PrayerTimesBTN);
        prayertimesBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.Screen_Area,new FragmentAskImam()).commit();
            }
        });

        Button mosqueBtn = (Button) v.findViewById(R.id.MosqueBTN);
        mosqueBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.Screen_Area,new FragmentPrayerTimes()).commit();
            }
        });

        return v;
    }//End onCreateView Method






}
