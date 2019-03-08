package com.example.gaoying20190308;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edit;
    private Button button;
    private TagFlowLayout flaw;
    private List<String> list;
    private Button button2;
    private TextView tv;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            flaw.setAdapter(new TagAdapter<String>(list) {
                @Override
                public View getView(FlowLayout parent, int position, String o) {
                    tv=(TextView)from.inflate(R.layout.item,flaw,false);
                    tv.setText(o);
                    return tv;
                }
            });
        }
    };
    private LayoutInflater from;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit= findViewById(R.id.edit);
        button= findViewById(R.id.button);
        button2= findViewById(R.id.button2);
        flaw=findViewById(R.id.flaw);
        from = LayoutInflater.from(this);
        list=new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = edit.getText().toString().trim();
                list.add(trim);
                handler.sendEmptyMessageDelayed(1,0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }


}
