package com.elementsculmyca.ec19_app.UI.ClubEventListPage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<EventDataModel> eventList;

    public EventAdapter(ArrayList<EventDataModel> events)
    {
        this.eventList = events;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_event_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder viewHolder, int i) {
        viewHolder.eventName.setText(eventList.get(i).getTitle());
       // viewHolder.eventDescription.setText(eventList.get(i).getDesc());
        viewHolder.eventVenue.setText(eventList.get(i).getVenue());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView eventName, eventDescription, eventTime,eventVenue;

        public ViewHolder(View view) {
            super(view);

            eventName = (TextView) view.findViewById(R.id.event_name);
            //eventDescription.setTypeface( Typeface.defaultFromStyle(R.font.overpass_black ));
            eventDescription = (TextView) view.findViewById(R.id.tv_event_description);
            eventTime = (TextView) view.findViewById(R.id.event_time);
            eventVenue=(TextView)view.findViewById(R.id.event_venue);

        }
    }
}

