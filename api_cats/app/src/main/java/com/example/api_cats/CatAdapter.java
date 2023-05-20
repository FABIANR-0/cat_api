package com.example.api_cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private ArrayList<Cat> dataset;
    private Context context;

    public CatAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cat p = dataset.get(position);
        holder.name.setText(p.getName());
        holder.origin.setText(p.getOrigin());
        holder.inteligence.setText(p.getIntelligence()+"" );
        Glide.with(context)
                .load("https://cdn2.thecatapi.com/images/"+p.getImage()+".jpg")
                .into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaCats(List<Cat> listaBreed) {
        dataset.addAll(listaBreed);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView name;
        private TextView origin;
        private TextView inteligence;

        public ViewHolder(View itemView) {
            super(itemView);
            foto= itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            origin = itemView.findViewById(R.id.country);
            inteligence = itemView.findViewById(R.id.inteligence);
        }
    }
}
