package com.example.sqlitecurd_operation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private final RecyclerViewItemClick recyclerViewItemClick;
    private ArrayList <item_Model> itemsModels;
    public ItemsAdapter(ArrayList<item_Model> itemsModels,RecyclerViewItemClick recyclerViewItemClick){
        this.recyclerViewItemClick=recyclerViewItemClick;
        this.itemsModels=itemsModels;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate
                (R.layout.single_items,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        item_Model itemsModel=itemsModels.get(position);
        holder.txt_name.setText(itemsModel.getName());
        holder.txt_age.setText(itemsModel.getAge());
        holder.txt_msg.setText(itemsModel.getMsg());
    }

    @Override
    public int getItemCount() {
        return itemsModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name, txt_age, txt_msg;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name=itemView.findViewById(R.id.txt_name);
            txt_age=itemView.findViewById(R.id.txt_age);
            txt_msg=itemView.findViewById(R.id.txt_msg);
            itemView.setOnClickListener(this::itemViewOnClick);
        }
        private void itemViewOnClick(View view){
            recyclerViewItemClick.onItemClick(view, getAdapterPosition());
        }

    }
}