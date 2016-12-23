package com.ecomm.suraj.qapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.ecomm.suraj.qapp.adapter.CommonBaseAdapter;
import com.ecomm.suraj.qapp.adapter.CommonOptionAdapter;
import com.ecomm.suraj.qapp.divideBy.CommonClickListener;
import com.ecomm.suraj.qapp.divideBy.DivideByNumber;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements CommonClickListener {

    /* @BindView(R.id.number_recycler_view)
    RecyclerView numberRecyclerView;*/
   @BindView(R.id.number_recycler_view)
    ListView   numberListView;
    Unbinder unbinder;
    ArrayList<String> numberOptionsList;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String> inputList;
    @BindView(R.id.number_edit_text_view)
    AppCompatEditText numberEditText;
    @BindView(R.id.option_submit_button)
    AppCompatButton submitChoice;
    private static final String TAG = "MainActivity";
    CommonBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder= ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        inputList=new ArrayList<>();

        numberOptionsList=new ArrayList<>();
        numberOptionsList.add("DivideBy Two");
        numberOptionsList.add("DivideBy Three");
        numberOptionsList.add("DivideBy Four");
        numberOptionsList.add("DivideBy Five");
        numberOptionsList.add("DivideBy Six");
        numberOptionsList.add("DivideBy Eight");
        numberOptionsList.add("DivideBy Nine");
        numberOptionsList.add("DivideBy Ten");
        numberOptionsList.add("DivideBy Eleven");

       /*linearLayoutManager=new LinearLayoutManager(this);
        numberRecyclerView.setLayoutManager(linearLayoutManager);*/
        //CommonOptionAdapter adapter=new CommonOptionAdapter(MainActivity.this,numberOptionsList,this);
        adapter=new CommonBaseAdapter(MainActivity.this,numberOptionsList,this);
        numberListView.setAdapter(adapter);
        //numberRecyclerView.setAdapter(adapter);


        submitChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=Integer.parseInt(numberEditText.getText().toString());
                String response=getOutput(inputList,number);
                Toast.makeText(MainActivity.this,"OutPut="+response,Toast.LENGTH_LONG).show();

            }
        });


    }

    private String getOutput(ArrayList<String> inputList, int number) {
        final String output=DivideByNumber.getInstance().numberDivisibleOutput(inputList,number);
        return  output;
    }

    @Override
    public void onSwitchClicked(String selected) {
        inputList.add(selected);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStateUnChecked(String selected) {

        inputList.contains(selected);
        inputList.remove(selected);
        Log.i(TAG, "onStateUnChecked: List State="+inputList);
    }
}
