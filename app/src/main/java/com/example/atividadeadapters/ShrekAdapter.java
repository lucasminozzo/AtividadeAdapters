package com.example.atividadeadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShrekAdapter extends RecyclerView.Adapter<ShrekAdapter.ViewHolder> {
    private final List<Shrek> localDataSet;

    public ShrekAdapter(List<Shrek> localDataSet){this.localDataSet = localDataSet; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shrek shrek = localDataSet.get(position);
        holder.getImageView().setImageResource(shrek.img);
        holder.getTextView().setText(shrek.nome);

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.txtShrek);
            imageView= itemView.findViewById(R.id.imgShrek);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Filme: "+getTextView().getText(), Toast.LENGTH_SHORT).show();
        }
    }
}

