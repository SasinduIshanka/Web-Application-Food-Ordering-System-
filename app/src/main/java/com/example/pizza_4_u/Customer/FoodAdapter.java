package com.example.pizza_4_u.Customer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza_4_u.Cus_Menu.CusFood;
import com.example.pizza_4_u.Cus_Menu.FoodItemInfo;
import com.example.pizza_4_u.Cus_Menu.RecyclerViewInterface;
import com.example.pizza_4_u.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.myViewHolder>{

    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList<CusFood> dataholder;
    private Context context;

    public FoodAdapter(ArrayList<CusFood> dataholder,RecyclerViewInterface recyclerViewInterface) {
        this.dataholder = dataholder;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cus_food_items,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txtname.setText(dataholder.get(position).getName());
        holder.txtprice.setText(dataholder.get(position).getPrice());

        byte[] foodImage= dataholder.get(position).getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(foodImage,0,foodImage.length);
        holder.imageView.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView txtname, txtprice;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname = (TextView) itemView.findViewById(R.id.txtCusFoodName);
            txtprice = (TextView) itemView.findViewById(R.id.txtCusFoodPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewCusItem);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(recyclerViewInterface != null){
                int position=getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    recyclerViewInterface.onItemClick(position);
                }
            }
        }
    }

}