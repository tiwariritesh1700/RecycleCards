package com.example.ritesh.recyclecaeds;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    //6.2
    private ArrayList<Exampleitem> mExampleItem;

    //1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView;
         //2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textview);
        }
    }
    //6.1
    public ExampleAdapter(ArrayList<Exampleitem> exampleList){

        mExampleItem=exampleList;
    }

    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //5
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item,viewGroup,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        //7
        Exampleitem currentItem=mExampleItem.get(i);
        exampleViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.textView.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return mExampleItem.size();
    }




}
