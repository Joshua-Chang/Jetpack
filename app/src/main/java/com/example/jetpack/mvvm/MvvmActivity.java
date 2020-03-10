package com.example.jetpack.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;

import com.example.jetpack.R;
import com.example.jetpack.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {
    Handler handler=new Handler();
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);
        ActivityMvvmBinding activityMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        user=new User("Tom","123456", "1");
        activityMvvmBinding.setUser(user);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                user.setName("jim");
                user.setPassword("98765");
                user.setHeader("http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg");
            }
        },5000);

    }

}