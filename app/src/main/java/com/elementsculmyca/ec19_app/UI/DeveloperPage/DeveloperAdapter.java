package com.elementsculmyca.ec19_app.UI.DeveloperPage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.EventPage.SingleEventActivity;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder>{
    private ArrayList<DeveloperModel> developerList;
    private Context context;

    private ArrayList<EventDataModel> eventListcopy;

    public DeveloperAdapter(ArrayList<DeveloperModel> developers,Context context)
    {
        this.developerList = developers;
        this.context = context;
    }
    public DeveloperAdapter()
    {

    }

    @Override
    public DeveloperAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_developers, viewGroup, false);
        return new DeveloperAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeveloperAdapter.ViewHolder viewHolder, int i) {
        final DeveloperModel developer = developerList.get(i);
        viewHolder.name.setText(developer.getName());
        viewHolder.designation.setText(developer.getDesignation());
        Picasso.get().load(developer.getImageUri()).into(viewHolder.photo);
        final Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(developer.getFacebookLink()));
        final Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(developer.getInstagramLink()));
        final Intent githubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(developer.getGithubLink()));
        final Intent linkedInIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(developer.getLinkedInLink()));
        viewHolder.facebookLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(facebookIntent);
            }
        });
        viewHolder.instagramLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(instagramIntent);
            }
        });

        viewHolder.githubLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(githubIntent);
            }
        });

        viewHolder.linkedInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(linkedInIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,designation;
        ImageView facebookLink,githubLink,instagramLink,linkedInLink,photo;

        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            designation = view.findViewById(R.id.designation);
            facebookLink = view.findViewById(R.id.facebook);
            githubLink = view.findViewById(R.id.github);
            linkedInLink=view.findViewById(R.id.linkedin);
            instagramLink = view.findViewById(R.id.instagram);
            photo = view.findViewById(R.id.phto);
        }
    }
}


