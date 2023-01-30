package com.example.pizza_4_u.Cus_Cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza_4_u.Cus_Menu.CusFood;
import com.example.pizza_4_u.Cus_Menu.RecyclerViewInterface;
import com.example.pizza_4_u.Customer.FoodAdapter;
import com.example.pizza_4_u.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.myViewHolder> {

    ArrayList<CartItemModel> dataholder;
    private Context context;

    public CartAdapter(ArrayList<CartItemModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.recid.setText(String.valueOf(dataholder.get(position).getId()));
        holder.recpname.setText(dataholder.get(position).getName());
        holder.recqnt.setText(String.valueOf(dataholder.get(position).getQty()));
        holder.Qtotal.setText(String.valueOf(dataholder.get(position).getQ_total()));
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView recid,recpname,recqnt, recpprice,Qtotal;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            recid=(TextView) itemView.findViewById(R.id.txtIdCart);
            recpname=(TextView) itemView.findViewById(R.id.txtNameCart);
            recqnt=(TextView) itemView.findViewById(R.id.txtQtyCart);
            Qtotal=(TextView) itemView.findViewById(R.id.txtTotalCart);
        }
    }
}
