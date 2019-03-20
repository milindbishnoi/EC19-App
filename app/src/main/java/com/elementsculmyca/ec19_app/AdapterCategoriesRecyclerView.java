package com.elementsculmyca.ec19_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategoriesRecyclerView extends RecyclerView.Adapter<AdapterCategoriesRecyclerView.Viewholder1> {
    public static String TAG="RecyclerVew";

    private ArrayList<String> genre;

    public AdapterCategoriesRecyclerView()
    {
        genre =new ArrayList<String>();
        genre.add("manan");
        genre.add("manan");
        genre.add("manan");
        genre.add("manan");
    }

    @NonNull
    @Override
    public Viewholder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_categories_view,viewGroup,false);
        return new Viewholder1(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder1 viewholder, int i) {
     viewholder.mgenres.setText(genre.get(i));
        viewholder.mimage.setImageResource(R.drawable.drama_x_9_ad_782);

    }

    @Override
    public int getItemCount() {
        return genre.size();
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
