package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jetpack.adapter.GirlAdapter;
import com.example.jetpack.bean.Girl;
import com.example.jetpack.viewmodel.MyGirl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Girl> data;
    MyGirl myGirl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
//        init();
//        listView.setAdapter(new GirlAdapter(MainActivity.this, data));
        //todo Lifecycle完成绑定
//        getLifecycle().addObserver(new MyLifeObserver());
        //todo liveData 调用系统API初始化这个对象
//        myGirl= ViewModelProviders.of(this).get(MyGirl.class);//弃用
        myGirl= new ViewModelProvider(this).get(MyGirl.class);
        //添加观察者注册
        myGirl.getDataBean().observe(this, new Observer<List<Girl>>() {
            @Override
            public void onChanged(List<Girl> girls) {
                //数据发生变化时
                listView.setAdapter(new GirlAdapter(MainActivity.this,girls));
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                myGirl.changeValue(position,"hhhhhh");
                startActivity(new Intent(MainActivity.this,SecActivity.class));
                return false;
            }
        });
    }
    //初始化默认数据
    private void init() {
        data = new ArrayList<>();
        data.add(new Girl(R.drawable.f1, "一星", "****"));
        data.add(new Girl(R.drawable.f2, "一星", "****"));
        data.add(new Girl(R.drawable.f3, "一星", "****"));
        data.add(new Girl(R.drawable.f4, "一星", "****"));
        data.add(new Girl(R.drawable.f5, "一星", "****"));
        data.add(new Girl(R.drawable.f6, "一星", "****"));
        data.add(new Girl(R.drawable.f7, "一星", "****"));
        data.add(new Girl(R.drawable.f8, "一星", "****"));
        data.add(new Girl(R.drawable.f9, "一星", "****"));
        data.add(new Girl(R.drawable.f10, "一星", "****"));
    }
}