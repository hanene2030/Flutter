package com.i.firstpage.HelperClasses.HelperAdapter;

        import android.content.Context;
        import android.graphics.drawable.ColorDrawable;
        import android.graphics.drawable.GradientDrawable;
        import android.os.Build;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.RatingBar;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.RequiresApi;
        import androidx.core.content.ContextCompat;
        import androidx.recyclerview.widget.RecyclerView;

        import com.i.firstpage.R;

        import java.util.ArrayList;



    public class MostViewedAdapter  extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {

        ArrayList<MostViewedHelperClass>  mostViewedLocations;

        public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedLocations) {

            this.mostViewedLocations = mostViewedLocations;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @NonNull
        @Override
        public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
            MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);




            return mostViewedViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {

            MostViewedHelperClass mostViewedHelperClass = mostViewedLocations.get(position );
            holder.image.setImageResource(mostViewedHelperClass.getImage());
            holder.title.setText(mostViewedHelperClass.getTitle());
            holder.description.setText(mostViewedHelperClass.getDescription());
            holder.mRatingBar.setRating((float) mostViewedHelperClass.getRating());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                ColorDrawable color = new ColorDrawable(ContextCompat.getColor(holder.itemView.getContext(),mostViewedHelperClass.getColor()));
                holder.itemView.setBackground(color);
            }


        }

        @Override
        public int getItemCount() {
            return mostViewedLocations.size();
        }

        public static class MostViewedViewHolder extends RecyclerView.ViewHolder{

            ImageView image;
            TextView title ,description;
            RatingBar mRatingBar;
     //  private   int iColor = R.color.banner_background;
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public MostViewedViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.mv_image);
                title = itemView.findViewById(R.id.mv_title);
                description = itemView.findViewById(R.id.mv_description);
                mRatingBar = itemView.findViewById(R.id.mv_rating);

              //  GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff440,0xffaff600});







            }
        }


    }
