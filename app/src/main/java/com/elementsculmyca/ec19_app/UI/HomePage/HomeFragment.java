package com.elementsculmyca.ec19_app.UI.HomePage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.DayAdapter;
import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.ClubEventListPage.EventAdapter;
import com.elementsculmyca.ec19_app.UI.EventPage.SingleEventActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ApiInterface apiInterface;
    SearchView searchView;
    ViewPager viewPager;
    private ProgressBar bar;
    private EventAdapter adapter;
    private ArrayList<ClubEventModel> allSampleData = new ArrayList<ClubEventModel>();
    private RecyclerView recyclerView;
    Button day1,day2,day3;




    ViewPager.OnPageChangeListener onchange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {



        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate( R.layout.fragment_main_screen, container, false );
        viewPager= root.findViewById(R.id.days_viewpager);
        searchView=  root.findViewById(R.id.search_view);
        searchView.setQueryHint("Search for Events");
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
       // recyclerView=root.findViewById(R.id.schedule_recyclerView);
       // bar = (ProgressBar)root.findViewById(R.id.pb);
        //bar.setVisibility(View.VISIBLE);
      //  getAllEvents();
        day1=root.findViewById(R.id.btn_day1);
        day2=root.findViewById(R.id.btn_day2);
        day3=root.findViewById(R.id.btn_day3);
        DayAdapter adapterday= new DayAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapterday);
        viewPager.addOnPageChangeListener(onchange);


        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0,true);

            }
        });

        day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,true);
            }
        });

        day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2,true);
            }
        });
      //  day1.setOnClickListener(new View.OnClickListener() {
            //@Override
       //     public void onClick(View view) {
       //         startActivity(new Intent(getActivity(),SingleEventActivity.class));
            //}
       // });
        addData();
        EventCategoryAdapter adapter = new EventCategoryAdapter(getActivity(), allSampleData);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        RecyclerView categoryRecycleview = (RecyclerView) root.findViewById(R.id.categories_recyclerView);
        categoryRecycleview.setLayoutManager(linearLayoutManager);
        categoryRecycleview.setAdapter(adapter);
        return root;
    }

    private int getCurrItem() {
        return viewPager.getCurrentItem();
    }

    void getAllEvents() {
        Call<ArrayList<EventDataModel>> call = apiInterface.getEventList();
        call.enqueue( new Callback<ArrayList<EventDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<EventDataModel>> call, Response<ArrayList<EventDataModel>> response) {
                //TODO YAHAN PE LIST AAEGI API SE UI ME LAGA LENA
                ArrayList<EventDataModel> eventList= response.body();
                adapter = new EventAdapter(eventList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);
                bar.setVisibility(View.GONE);
                Log.e( "Response", response.body().size() + "" );

            }

            @Override
            public void onFailure(Call<ArrayList<EventDataModel>> call, Throwable t) {
                Log.e( "Response", call.request().url() + "" + call.request().body() );

            }

        } );

    }
    private void addData() {

        ClubEventModel manan = new ClubEventModel();
        manan.setClubName("Manan");
        manan.setDisplayName("Coding");
        //manan.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.manan));
        allSampleData.add(manan);

        ClubEventModel ananya = new ClubEventModel();
        ananya.setClubName("Ananya");
        ananya.setDisplayName("Lit-Deb");
        //ananya.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.ananya));
        allSampleData.add(ananya);

        ClubEventModel vividha = new ClubEventModel();
        vividha.setClubName("Vividha");
        vividha.setDisplayName("Dramatics");
        //vividha.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.vividha));
        allSampleData.add(vividha);

        ClubEventModel jhalak = new ClubEventModel();
        jhalak.setClubName("Jhalak");
        jhalak.setDisplayName("Photography & Designing");
        //jhalak.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.jhalak));
        allSampleData.add(jhalak);

        ClubEventModel eklavya = new ClubEventModel();
        eklavya.setClubName("Eklavya");
        eklavya.setDisplayName("Fun Events");
        //eklavya.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.eklavya));
        allSampleData.add(eklavya);

        ClubEventModel ieee = new ClubEventModel();
        ieee.setClubName("IEEE");
        ieee.setDisplayName("Techno Fun");
        //ieee.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.ieee));
        allSampleData.add(ieee);

        ClubEventModel mechnext = new ClubEventModel();
        mechnext.setClubName("Mechnext");
        mechnext.setDisplayName("Mechanical");
        //mechnext.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.mechnext));
        allSampleData.add(mechnext);

        ClubEventModel microbird = new ClubEventModel();
        microbird.setClubName("Microbird");
        microbird.setDisplayName("Electronics");
        //microbird.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.microbird));
        allSampleData.add(microbird);

        ClubEventModel natraja = new ClubEventModel();
        natraja.setClubName("Nataraja");
        natraja.setDisplayName("Dance");
        //natraja.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.natraja));
        allSampleData.add(natraja);

        ClubEventModel sae = new ClubEventModel();
        sae.setClubName("SAE");
        sae.setDisplayName("Automobiles");
        //sae.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.sae));
        allSampleData.add(sae);

        ClubEventModel samarpan = new ClubEventModel();
        samarpan.setClubName("Samarpan");
        samarpan.setDisplayName("Electrical");
        //samarpan.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.samarpan));
        allSampleData.add(samarpan);

        ClubEventModel srijan = new ClubEventModel();
        srijan.setClubName("Srijan");
        srijan.setDisplayName("Arts");
        //srijan.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.srijan));
        allSampleData.add(srijan);

        ClubEventModel tarannum = new ClubEventModel();
        tarannum.setClubName("Taranuum");
        tarannum.setDisplayName("Music");
        //tarannum.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.tarannum));
        allSampleData.add(tarannum);

        ClubEventModel vivekanand = new ClubEventModel();
        vivekanand.setClubName("Vivekanand Manch");
        vivekanand.setDisplayName("Socio-Cultural");
        //vivekanand.setImage(BitmapFactory.decodeResource(ContentActivity.this.getResources(), R.raw.vivekanand));
        allSampleData.add(vivekanand);
    }

}
