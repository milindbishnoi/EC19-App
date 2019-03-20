package com.elementsculmyca.ec19_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Tickets extends AppCompatActivity {



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<TicketsDetails> ticketsDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        recyclerView= (RecyclerView) findViewById(R.id.recyclertickets);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ticketsDetails= new ArrayList<>();
        for (int i =0;i<=5;i++){
            TicketsDetails ticketDetail= new TicketsDetails(
                    "Code Relay" + (i+1),
                    "Fees:",
                    "Venue:",
                    "Name:",
                    "PAID"
            );
            ticketsDetails.add(ticketDetail);
        }
        adapter=new TicketsAdapter(ticketsDetails,this);
        recyclerView.setAdapter(adapter);
    }
}
