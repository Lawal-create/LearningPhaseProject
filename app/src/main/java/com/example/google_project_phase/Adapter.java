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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Name> name;

    public Adapter(Context ctx,List<Name> name){
        this.inflater=LayoutInflater.from(ctx);
        this.name=name;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_list_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Bind the data
        holder.nameTitle.setText(name.get(position).getName());
        holder.countryTitle.setText(name.get(position).getCountry());
        holder.hoursTitle.setText(name.get(position).getHours());
        Picasso.get().load(name.get(position).getBadgeUrl()).into(holder.learningImage);

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTitle,countryTitle,hoursTitle;
        ImageView learningImage;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            nameTitle=itemView.findViewById(R.id.name);
            countryTitle=itemView.findViewById(R.id.Country);
            hoursTitle=itemView.findViewById(R.id.hoursofLearning);
            learningImage=itemView.findViewById(R.id.imagetest);
        }
    }
}
