package assignment.swd.toannb.swd_assignment.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import assignment.swd.toannb.swd_assignment.Models.FEVInventoryItem;

import assignment.swd.toannb.swd_assignment.R;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder>  {
    private List<FEVInventoryItem> listInventory;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView inventory_name, inventory_address, inventory_price, inventory_note;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            inventory_name = (TextView) itemView.findViewById(R.id.inventory_name);
            inventory_address = (TextView) itemView.findViewById(R.id.inventory_address);
            inventory_price = (TextView) itemView.findViewById(R.id.inventory_price);
            inventory_note = (TextView) itemView.findViewById(R.id.inventory_note);

        }
    }

    @NonNull
    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View memberView = inflater.inflate(R.layout.item_inventory, viewGroup, false);

        InventoryAdapter.ViewHolder viewHolder = new InventoryAdapter.ViewHolder(memberView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryAdapter.ViewHolder viewHolder, int i) {
        FEVInventoryItem inventoryItem = listInventory.get(i);

        TextView inventory_name = viewHolder.inventory_name;
        inventory_name.setText(inventoryItem.getName());

        TextView inventory_address = viewHolder.inventory_address;
        inventory_address.setText("Address: " + inventoryItem.getAddress());

        TextView inventory_price = viewHolder.inventory_price;
        inventory_price.setText("Price: " + inventoryItem.getPrice().toString());

        TextView inventory_note = viewHolder.inventory_note;
        inventory_note.setText("Note: " + inventoryItem.getNote());

    }

    @Override
    public int getItemCount() {
        return listInventory.size();
    }

    public InventoryAdapter(List<FEVInventoryItem> listInventory){
        this.listInventory = listInventory;
    }
}
