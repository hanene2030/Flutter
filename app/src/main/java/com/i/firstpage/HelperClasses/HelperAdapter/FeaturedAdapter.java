package com.i.firstpage.HelperClasses.HelperAdapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.i.firstpage.R;

import java.util.ArrayList;

public class FeaturedAdapter  extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass>  featuredLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations) {

        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);




        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

FeaturedHelperClass featuredHelperClass = featuredLocations.get(position );
holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.description.setText(featuredHelperClass.getDescription());


    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

ImageView image;
TextView title ,description;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            description = itemView.findViewById(R.id.featured_desc);
        }
    }


}
