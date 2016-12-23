package com.ecomm.suraj.qapp.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.ecomm.suraj.qapp.R;
import com.ecomm.suraj.qapp.divideBy.CommonClickListener;

import java.util.ArrayList;

/**
 * Created by surajbokankar on 23/12/16.
 */

public class CommonOptionAdapter extends RecyclerView.Adapter<CommonOptionAdapter.CustomHolder>  {

    ArrayList<String> numberOptionList;
    Context context;
    AppCompatTextView numberOptionText;
    SwitchCompat selectNumberOption;
    CommonClickListener commonClickListener;
    private static final String TAG = "CommonOptionAdapter";
    public CommonOptionAdapter(Context context, ArrayList<String> list,CommonClickListener listener){
        this.context=context;
        this.numberOptionList=list;
        this.commonClickListener=listener;
    }


    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_divide_number,parent,false);
        CustomHolder customHolder=new CustomHolder(view);
        return customHolder;
    }

    @Override
    public void onBindViewHolder(CustomHolder holder, final int position) {

        numberOptionText.setText(numberOptionList.get(position));

        selectNumberOption.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Log.i(TAG, "onCheckedChanged: Selected Option="+numberOptionList.get(position));
                    commonClickListener.onSwitchClicked(numberOptionList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return numberOptionList.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder {


        public CustomHolder(View itemView) {
            super(itemView);
            numberOptionText= (AppCompatTextView) itemView.findViewById(R.id.option_text_view);
            selectNumberOption= (SwitchCompat) itemView.findViewById(R.id.option_selection_switch);



        }
    }
}
