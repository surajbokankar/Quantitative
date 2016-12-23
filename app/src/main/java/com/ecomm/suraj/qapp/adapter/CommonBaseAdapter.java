package com.ecomm.suraj.qapp.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;

import com.ecomm.suraj.qapp.R;
import com.ecomm.suraj.qapp.divideBy.CommonClickListener;

import java.util.ArrayList;

/**
 * Created by surajbokankar on 23/12/16.
 */

public class CommonBaseAdapter extends BaseAdapter {

    ArrayList<String> numberOptionList;
    Context context;

    CommonClickListener commonClickListener;

    private static final String TAG = "CommonBaseAdapter";

    public CommonBaseAdapter(Context context, ArrayList<String> List,CommonClickListener listener){
        this.numberOptionList=List;
        this.context=context;
        this.commonClickListener=listener;
    }

    @Override
    public int getCount() {
        return numberOptionList.size();
    }

    @Override
    public Object getItem(int i) {
        return numberOptionList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertview, ViewGroup viewGroup) {
        ViewHolder viewHolder=new ViewHolder();
        if(convertview==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview=inflater.inflate(R.layout.layout_divide_number,null,false);
            viewHolder.numberOptionText= (AppCompatTextView) convertview.findViewById(R.id.option_text_view);
            viewHolder.selectNumberOption= (SwitchCompat) convertview.findViewById(R.id.option_selection_switch);
            convertview.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertview.getTag();
        }

        viewHolder.numberOptionText.setText(numberOptionList.get(position));

        viewHolder.selectNumberOption.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Log.i(TAG, "onCheckedChanged: Selected Option="+numberOptionList.get(position));
                    commonClickListener.onSwitchClicked(numberOptionList.get(position));
                }else if(!isChecked){
                    Log.i(TAG, "onCheckedChanged: UnChecked="+numberOptionList.get(position));
                    commonClickListener.onStateUnChecked(numberOptionList.get(position));
                }
            }
        });

        return convertview;
    }

    public class ViewHolder{
        AppCompatTextView numberOptionText;
        SwitchCompat selectNumberOption;
    }
}
