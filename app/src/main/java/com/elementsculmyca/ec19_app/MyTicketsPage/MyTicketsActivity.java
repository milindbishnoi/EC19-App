package com.elementsculmyca.ec19_app.MyTicketsPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;
import java.util.List;

public class MyTicketsActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<TicketsModel> ticketsDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        recyclerView= (RecyclerView) findViewById(R.id.recyclertickets);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyTicketsActivity.this,LinearLayoutManager.VERTICAL,false));
        ticketsDetails= new ArrayList<>();
        for (int i =0;i<=5;i++){
            TicketsModel ticketDetail= new TicketsModel(
                    "Code Relay" + (i+1),
                    "80",
                    "Lab",
                    "Shubham Sharma",
                    "PAID"
            );
            ticketsDetails.add(ticketDetail);
        }
        adapter=new TicketsAdapter(ticketsDetails,this);
        recyclerView.setAdapter(adapter);
    }
}
