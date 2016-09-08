package com.abdullahalimran.cardview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder>{

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_mobile;
        private TextView tv_email;
        private TextView tv_address;
        private RelativeLayout clickable_layout;

        public ViewHolder(View view) {
            super(view);
            tv_name = (TextView)view.findViewById(R.id.card_name);
            tv_mobile = (TextView)view.findViewById(R.id.card_mobile);
            tv_email = (TextView)view.findViewById(R.id.card_email);
            tv_address = (TextView)view.findViewById(R.id.card_address);
            clickable_layout = (RelativeLayout) itemView.findViewById(R.id.clickable);
        }
    }

    private ArrayList<Person> persons;

    public CardViewAdapter(ArrayList<Person> persons, Context context) {
        this.persons = persons;
        this.context=context;
    }

    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewAdapter.ViewHolder holder, final int position) {
        holder.tv_name.setText(persons.get(position).getName());
        holder.tv_mobile.setText("Mobile: "+persons.get(position).getMobile());
        holder.tv_email.setText("Email: "+persons.get(position).getEmail());
        holder.tv_address.setText("Address: "+persons.get(position).getAddress());

        holder.clickable_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, persons.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
