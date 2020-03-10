package com.example.jetpack.Bus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.jetpack.Cons;
import com.example.jetpack.R;
import com.example.jetpack.SecActivity;


public class BusActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        //消费者订阅消息
        LiveDataBus.getInstance().with("huawei",HuaWei.class)
                .observe(this, new Observer<HuaWei>() {
                    @Override
                    public void onChanged(HuaWei huaWei) {
                        if (huaWei != null) {
//                            Toast.makeText(BusActivity.this, ""+huaWei.type, Toast.LENGTH_SHORT).show();
                            Log.e(Cons.TAG,"main:"+huaWei.getType());
                        }
                    }
                });
    }
    /**
     * 这里就是一个发布者(苹果，华为)
     * @param view
     */
    public void sendMessage(View view) {
        HuaWei huawei=new HuaWei("META-20");
        //厂家发布消息
        LiveDataBus.getInstance().with("huawei",HuaWei.class).postValue(huawei);
    }

    public void startSecActivity(View view) {
        Intent intent=new Intent(this, SecActivity.class);
        startActivity(intent);
    }
}