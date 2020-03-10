package com.example.jetpack.mvvm;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;

import com.example.jetpack.R;
import com.example.jetpack.databinding.ActivityMvvmBinding;

import java.util.ArrayList;
import java.util.List;

public class MvvmListActivity extends AppCompatActivity {
    ListView list;
    List<User> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm_list);
        list=(ListView)findViewById(R.id.listView);
        data.add(new User("1","1","http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg"));
        data.add(new User("2","2","http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg"));
        data.add(new User("3","3","http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg"));
        data.add(new User("4","4","http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg"));
        list.setAdapter(new CommAdapter<User>(this,getLayoutInflater(),R.layout.item2vm, BR.user,data));
    }

}