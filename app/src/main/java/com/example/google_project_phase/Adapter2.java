package com.example.google_project_phase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {
    LayoutInflater inflater;
    List<Name2> name;

    public Adapter2(Context ctx, List<Name2> name){
        this.inflater=LayoutInflater.from(ctx);
        this.name=name;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_list_layout2,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Bind the data
        holder.nameTitle.setText(name.get(position).getName());
        holder.countryTitle.setText(name.get(position).getCountry());
        holder.scoreTitle.setText(name.get(position).getScore());
        Picasso.get().load(name.get(position).getBadgeUrl()).into(holder.learningImage2);

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTitle,countryTitle,scoreTitle;
        ImageView learningImage2;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            nameTitle=itemView.findViewById(R.id.name2);
            countryTitle=itemView.findViewById(R.id.Country2);
            scoreTitle=itemView.findViewById(R.id.skill2);
            learningImage2=itemView.findViewById(R.id.imagetest2);
        }
    }
}
