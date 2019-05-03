package com.technorapper.staroyis.apater;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.technorapper.staroyis.R;
import com.technorapper.staroyis.databinding.AddressCellBinding;
import com.technorapper.staroyis.databinding.SelectedItemCellBinding;
import com.technorapper.staroyis.interfaces.RecyclerViewClickListener;
import com.technorapper.staroyis.ui.order.model.Item;
import com.technorapper.staroyis.ui.order.model.adress.AddressDetail;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.MyViewHolder> {

    private List<AddressDetail> material;
    private RecyclerViewClickListener mListener;

    public AddressListAdapter(List<AddressDetail> material, RecyclerViewClickListener mListener) {
        this.material = material;
        this.mListener = mListener;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AddressCellBinding binding;

        public MyViewHolder(AddressCellBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public AddressListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AddressCellBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.address_cell, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final AddressListAdapter.MyViewHolder holder, final int position) {
        holder.binding.setModel(material.get(position));

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

