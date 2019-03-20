package com.elementsculmyca.ec19_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategoriesRecyclerView extends RecyclerView.Adapter<AdapterCategoriesRecyclerView.Viewholder> {
    public static String TAG="RecyclerVew";
    private ArrayList<Bitmap> mImages;
    private ArrayList<String> genres;
    private  Context mcontext;
    public AdapterCategoriesRecyclerView(ArrayList<Bitmap> mImages,ArrayList<String> mgenres,Context context)
    {
     this.mImages=mImages;
     this.genres=mgenres;
     this.mcontext=context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_categories_view,viewGroup,false);
        return new Viewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
     viewholder.mgenres.setText(genres.get(i));
        Drawable drawable = new BitmapDrawable(mcontext.getResources(), mImages.get(i));
        viewholder.mimage.setImageDrawable(drawable);

    }

    @Override
    public int getItemCount() {
        return genres.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder{
           private ImageView mimage;
           private TextView mgenres;

          public  Viewholder(View itemView)
            {
                super(itemView);
                mimage=(ImageView) itemView.findViewById(R.id.Categories_image);
                mgenres=(TextView) itemView.findViewById(R.id.categories_genre);
                }
        }

}
