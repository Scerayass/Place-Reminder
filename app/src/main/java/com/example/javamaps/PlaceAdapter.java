package com.example.javamaps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javamaps.databinding.RecylerRowBinding;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {

    List<Place> placeArrayList;

    public PlaceAdapter(List<Place> placeArrayList){
        this.placeArrayList = placeArrayList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerRowBinding recylerRowBinding = RecylerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new PlaceHolder(recylerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.textView.setText(placeArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(holder.itemView.getContext(),MapsActivity.class);
                intent.putExtra("info","old");
                intent.putExtra("place",placeArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeArrayList.size();
    }


    public class PlaceHolder extends RecyclerView.ViewHolder{
        private RecylerRowBinding binding;

        public PlaceHolder(RecylerRowBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
