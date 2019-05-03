package com.technorapper.staroyis.apater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorapper.staroyis.R;
import com.technorapper.staroyis.databinding.ItemListCellBinding;
import com.technorapper.staroyis.databinding.SelectedItemCellBinding;
import com.technorapper.staroyis.interfaces.RecyclerViewClickListener;
import com.technorapper.staroyis.ui.home.model.Product;
import com.technorapper.staroyis.ui.order.model.Item;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CartProductListAdapter extends RecyclerView.Adapter<CartProductListAdapter.MyViewHolder> {

    private List<Item> material;
    private RecyclerViewClickListener mListener;

    public CartProductListAdapter(List<Item> material, RecyclerViewClickListener mListener) {
        this.material = material;
        this.mListener = mListener;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private SelectedItemCellBinding binding;

        public MyViewHolder(SelectedItemCellBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }

    @Override
    public CartProductListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SelectedItemCellBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.selected_item_cell, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final CartProductListAdapter.MyViewHolder holder, final int position) {
        holder.binding.setModel(material.get(position));
        holder.binding.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onClick(v, position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return material.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

