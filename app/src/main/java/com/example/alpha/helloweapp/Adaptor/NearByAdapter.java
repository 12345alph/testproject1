package com.example.alpha.helloweapp.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alpha.helloweapp.Activity_BookMark_Details;
import com.example.alpha.helloweapp.Activity_NearBy_Details;
import com.example.alpha.helloweapp.Model.Costume;
import com.example.alpha.helloweapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by alpha on 1/2/17.
 */

public class NearByAdapter extends RecyclerView.Adapter<NearByAdapter.MyViewHolder> {

    private List<Costume>  costumeList;
     private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageviewCostume;
        public TextView TextVieTitle,TextVieDesc;
       public CardView card_view;
        public MyViewHolder(View view) {
            super(view);
            imageviewCostume = (ImageView) view.findViewById(R.id.imageviewCostume);
            TextVieTitle = (TextView) view.findViewById(R.id.TextVieTitle);
            TextVieDesc = (TextView) view.findViewById(R.id.TextVieDesc);
            card_view= (CardView) view.findViewById(R.id.card_view);

        }
    }


    public NearByAdapter(List<Costume> costumeList, Context context) {
        this.costumeList = costumeList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_bookmark, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Costume movie = costumeList.get(position);
        //holder.imageviewCostume.setText(movie.getTitle());
       // holder.genre.setText(movie.getGenre());
       // holder.year.setText(movie.getYear());


        Picasso.with(context)
                .load(movie.getCostumeImage())
                .placeholder(R.mipmap.ic_launcher)   // optional
                .error(R.mipmap.ic_launcher)      // optional
                .resize(300, 300)                        // optional
                                // optional
                .into(holder.imageviewCostume);


        holder.TextVieTitle.setText(movie.getCostumeName());
        holder.TextVieDesc.setText(movie.getCostumeDesc());


           holder.card_view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Intent i=new Intent(context, Activity_NearBy_Details.class);
                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   context.startActivity(i);

               }
           });


    }

    @Override
    public int getItemCount() {
        return costumeList.size();
    }
}