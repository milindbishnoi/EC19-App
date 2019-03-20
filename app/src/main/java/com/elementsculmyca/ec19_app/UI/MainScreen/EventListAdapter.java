package com.elementsculmyca.ec19_app.UI.MainScreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.R;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {

    private List<EventListModel> eventlist;

    public EventListAdapter(List<EventListModel> eventlist) {
        this.eventlist = eventlist;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.event_list_layout, parent, false);

        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

        EventListModel el = eventlist.get(position);



    }

    @Override
    public int getItemCount() {
        return eventlist.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView image_event;
        TextView text_head_event;
        TextView text_content_event;
        public EventViewHolder(View itemView) {
            super(itemView);

            image_event = itemView.findViewById(R.id.image_event);
            text_head_event = itemView.findViewById(R.id.text_head_event);
            text_content_event  = itemView.findViewById(R.id.text_content_event);
        }
    }

}



