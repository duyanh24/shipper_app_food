package com.leduyanh.shipper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leduyanh.shipper.R;
import com.leduyanh.shipper.model.orderdetail.DataOrderDetail;

import java.util.List;

public class AdapterRecycOrderDetail extends RecyclerView.Adapter<AdapterRecycOrderDetail.OrderDetailViewHolder> {
    List<DataOrderDetail> listItem;
    Context mContext;

    public AdapterRecycOrderDetail(List<DataOrderDetail> listItem, Context mContext) {
        this.listItem = listItem;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public OrderDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_order_detail,parent,false);
        OrderDetailViewHolder viewHolder = new OrderDetailViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailViewHolder holder, int position) {
        holder.txtName.setText(listItem.get(position).getDish().getName());
        holder.txtCount.setText(String.valueOf(listItem.get(position).getQuantity()));
        holder.txtPrice.setText(String.valueOf(listItem.get(position).getCurrent_price()));
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class OrderDetailViewHolder extends RecyclerView.ViewHolder{
        ImageView imgItem;
        TextView txtName;
        TextView txtPrice;
        TextView txtCount;
        public OrderDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = (ImageView)itemView.findViewById(R.id.imgItemOderDetail);
            txtName = (TextView)itemView.findViewById(R.id.txtItemOderDetailName);
            txtCount = (TextView)itemView.findViewById(R.id.txtItemOderDetailCount);
            txtPrice = (TextView)itemView.findViewById(R.id.txtItemOderDetailPrice);
        }
    }
}
