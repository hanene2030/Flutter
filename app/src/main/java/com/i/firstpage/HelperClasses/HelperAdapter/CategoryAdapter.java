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

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<CategoryHelperClass>  categoryLocations;

    public CategoryAdapter(ArrayList<CategoryHelperClass> categoryLocations) {

        this.categoryLocations = categoryLocations;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card_design,parent,false);
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card_design,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);


        //  CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);




        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        CategoryHelperClass categoryHelperClass = categoryLocations.get(position );
        holder.image.setImageResource(categoryHelperClass.getImage());
        holder.title.setText(categoryHelperClass.getTitle());



    }

    @Override
    public int getItemCount() {
        return categoryLocations.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title ,description;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            title = itemView.findViewById(R.id.category_title);

        }
    }


}
