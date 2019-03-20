package com.elementsculmyca.ec19_app.UI.HomePage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.ClubEventListPage.ClubEventListActivity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class EventCategoryAdapter extends RecyclerView.Adapter<EventCategoryAdapter.Viewholder1> {
    public static String TAG="RecyclerVew";

    private ArrayList<ClubEventModel> itemsList;
    private Context mContext;

    public EventCategoryAdapter(Context context, ArrayList<ClubEventModel> itemsList)
    {
        this.itemsList = itemsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public Viewholder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_categories_view,viewGroup,false);
        return new Viewholder1(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder1 viewholder, int i) {
        final ClubEventModel singleItem = itemsList.get(i);
        String displayName;
        if (singleItem.getDisplayName().length() <= 12) {
            displayName = singleItem.getDisplayName();
        } else {
            displayName = singleItem.getDisplayName().substring(0, 9);
            displayName += "...";
        }
        viewholder.mgenres.setText(displayName);
        viewholder.mimage.setImageResource(R.drawable.drama_x_9_ad_782);
        viewholder.mimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ClubEventListActivity.class)
                        .putExtra("clubname", singleItem.getClubName())
                        .putExtra("clubdisplay", singleItem.getDisplayName()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class Viewholder1 extends RecyclerView.ViewHolder{
           private ImageView mimage;
           private TextView mgenres;

          public  Viewholder1(View itemView)
            {
                super(itemView);
                mimage=(ImageView) itemView.findViewById(R.id.Categories_image);
                mgenres=(TextView) itemView.findViewById(R.id.categories_genre);
                }
        }

}
