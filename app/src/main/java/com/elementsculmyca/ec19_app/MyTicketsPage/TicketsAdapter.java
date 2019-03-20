package com.elementsculmyca.ec19_app.MyTicketsPage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.R;

import java.util.List;

public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.ViewHolder> {

    private List<TicketsModel> ticketsDetails;
    private Context context;
    public TicketsAdapter(List<TicketsModel> ticketsDetails, Context context){
        this.ticketsDetails=ticketsDetails;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_tickets_details,viewGroup,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TicketsModel ticketDetail = ticketsDetails.get(i);
        viewHolder.textViewevent.setText(ticketDetail.getEvent());
        viewHolder.textViewfees.setText(ticketDetail.getFees());
        viewHolder.textViewvenue.setText(ticketDetail.getVenue());
        viewHolder.textViewname.setText(ticketDetail.getName());
        viewHolder.textViewstatus.setText(ticketDetail.getStatus());

    }

    @Override
    public int getItemCount() {
        return ticketsDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewevent;
        public TextView textViewfees;
        public TextView textViewvenue;
        public TextView textViewname;
        public TextView textViewstatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewevent= (TextView) itemView.findViewById(R.id.eventname);
            textViewfees= (TextView) itemView.findViewById(R.id.eventfees);
            textViewvenue=(TextView) itemView.findViewById(R.id.eventvenue);
            textViewname=(TextView) itemView.findViewById(R.id.username);
            textViewstatus=(TextView) itemView.findViewById(R.id.feestatus);
        }
    }
}
