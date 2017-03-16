package com.example.alpha.helloweapp.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alpha.helloweapp.Model.Kids;
import com.example.alpha.helloweapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by alpha on 1/2/17.
 */

public class MightLikes_Adapter extends RecyclerView.Adapter<MightLikes_Adapter.MyViewHolder> {

    private List<Kids> kidsList ;
     private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageviewCostume;

        public MyViewHolder(View view) {
            super(view);
            imageviewCostume = (ImageView) view.findViewById(R.id.imageviewCostume);

        }
    }


    public MightLikes_Adapter(List<Kids> KidsList, Context context) {
        this.kidsList = KidsList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_home_mightlikes, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Kids movie = kidsList.get(position);
        //holder.imageviewCostume.setText(movie.getTitle());
       // holder.genre.setText(movie.getGenre());
       // holder.year.setText(movie.getYear());


        Picasso.with(context)
                .load(movie.getCostume_url())
                .placeholder(R.mipmap.ic_launcher)   // optional
                .error(R.mipmap.ic_launcher)      // optional
                .resize(500, 500)                        // optional
                                // optional
                .into(holder.imageviewCostume);


    }

    @Override
    public int getItemCount() {
        return kidsList.size();
    }
}