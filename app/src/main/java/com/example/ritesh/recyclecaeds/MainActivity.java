package com.example.ritesh.recyclecaeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Exampleitem> exampleList;


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText editText;
    private EditText editText2;
    private Button buttonadd;
    private Button buttonremove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generaterightdate();
        recycleconfig();

        editText=findViewById(R.id.edittextadd);
        editText2=findViewById(R.id.editextdelete);
        buttonadd=findViewById(R.id.buttonadd);
        buttonremove=findViewById(R.id.buttondelete);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.length()==0)
                {
                    editText.setError("Enter Number");
                }
                else {

                    int position=Integer.parseInt(editText.getText().toString());
                    addCard(position);
                }

            }
        });

        buttonremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (editText2.length()==0){
                    editText2.setError("Enter Number");
                }
                else {
                    int  position=Integer.parseInt(editText2.getText().toString());
                    deletecard(position);
                }
            }
        });

    }

    public void generaterightdate(){
        exampleList=new ArrayList<>();

        exampleList.add(new Exampleitem(R.drawable.node,"Clicked at Studio"));
        exampleList.add(new Exampleitem(R.drawable.oner,"Clicked at Italy"));
        exampleList.add(new Exampleitem(R.drawable.twor,"Clicked at Rome"));
        exampleList.add(new Exampleitem(R.drawable.threer,"Clicked at Greece"));
        exampleList.add(new Exampleitem(R.drawable.fourr,"Clicked at Rome"));
        exampleList.add(new Exampleitem(R.drawable.fiver,"Clicked at Santorini"));
        exampleList.add(new Exampleitem(R.drawable.sixr,"Clicked at India"));
    }

    public void recycleconfig(){

        recyclerView=findViewById(R.id.recyclerView);

        //performance line
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);

        adapter=new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard(int position){
        exampleList.add(position,new Exampleitem(R.drawable.node,"new Card Added"));
     //   adapter.notifyDataSetChanged(); we can use this also but not every time

        adapter.notifyItemInserted(position);
    }

    public void deletecard(int position){

        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    }

