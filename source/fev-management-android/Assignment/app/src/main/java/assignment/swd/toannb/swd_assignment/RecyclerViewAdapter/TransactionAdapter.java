package assignment.swd.toannb.swd_assignment.RecyclerViewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


import assignment.swd.toannb.swd_assignment.Models.FEVTransaction;
import assignment.swd.toannb.swd_assignment.R;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder>  {
    private List<FEVTransaction> listTransaction;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView transaction_content, transaction_price, transaction_note;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            transaction_content = (TextView) itemView.findViewById(R.id.transaction_content);
            transaction_price = (TextView) itemView.findViewById(R.id.transaction_price);
            transaction_note = (TextView) itemView.findViewById(R.id.transaction_note);


        }
    }

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View memberView = inflater.inflate(R.layout.item_transaction, viewGroup, false);

        TransactionAdapter.ViewHolder viewHolder = new TransactionAdapter.ViewHolder(memberView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder viewHolder, int i) {
        FEVTransaction transaction = listTransaction.get(i);

        TextView transaction_content = viewHolder.transaction_content;
        transaction_content.setText(transaction.getContent());


        TextView transaction_price = viewHolder.transaction_price;
        transaction_price.setText("Price: " + transaction.getMoney());

        TextView transaction_note = viewHolder.transaction_note;
        transaction_note.setText("Note: " + transaction.getNote());

    }

    @Override
    public int getItemCount() {
        return listTransaction.size();
    }

    public TransactionAdapter(List<FEVTransaction> listTransaction){
        this.listTransaction = listTransaction;
    }
}

