package com.elementsculmyca.ec19_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterCategoriesRecyclerView extends RecyclerView.Adapter<AdapterCategoriesRecyclerView.Viewholder> {
    public static String TAG="RecyclerVew";
    private ArrayList<String> mImagesUrls;
    private ArrayList<String> genres;
    private  Context mcontext;
    public AdapterCategoriesRecyclerView(Context context,ArrayList<String> mImages,ArrayList<String> mgenres)
    {
     this.mImagesUrls=mImages;
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
     viewholder.mgenres.setText(this.genres.get(i));
     // image set karne ka code ayega yaha
     //viewholder.mimage.setImageBitmap();

    viewholder.mimage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(mcontext, "apna time ayega", Toast.LENGTH_SHORT).show();
        }
    });
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
