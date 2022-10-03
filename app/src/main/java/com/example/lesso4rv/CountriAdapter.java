package com.example.lesso4rv;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CountriAdapter extends RecyclerView.Adapter<CountriAdapter.CountriViewHolder> {

    private ArrayList<Countri> Countris;
    private OnItemklic onItemklic;


    public CountriAdapter(ArrayList<Countri> countris,OnItemklic onItemklic) {
       this.Countris = countris;
       this.onItemklic = onItemklic;
    }
    @NonNull
    @Override
    public CountriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountriViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_countri,parent,false)) ;
    }
    @Override
    public void onBindViewHolder(@NonNull CountriViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(Countris.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemklic.OnItemClick(Countris.get(position));
            }
        });
    }
    @Override
    public int getItemCount() {
        return Countris.size();
    }

    static class CountriViewHolder extends RecyclerView.ViewHolder {
     private TextView tvCountri,tvCopital;
     private ImageView ivFlag;
        public CountriViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountri=itemView.findViewById(R.id.tv_countri);
            tvCopital=itemView.findViewById(R.id.tv_capital);
            ivFlag=itemView.findViewById(R.id.iv_flag);
        }
        public void bind(Countri countri){
            tvCountri.setText(countri.getName());
            tvCopital.setText(countri.getCapital());
            Picasso.get().load(countri.getFlag()).into(ivFlag);
        }
    }
}
