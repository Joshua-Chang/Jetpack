package com.example.jetpack;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.jetpack.Bus.HuaWei;
import com.example.jetpack.Bus.LiveDataBus;
import com.example.jetpack.viewmodel.MyGirl;


public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
//        MyGirl myGirl = new ViewModelProvider(this).get(MyGirl.class);
        //一定要在主线程中调用
//        myGirl.changeValue(0, "第二个activity");

/*---------------------bus---------------*/

        //消费者订阅消息
        LiveDataBus.getInstance().with("huawei", HuaWei.class).observe(
                this,
                new Observer<HuaWei>() {//观查者
                    @Override
                    public void onChanged(HuaWei huawei) {
                        if (huawei != null) {
//                            Toast.makeText(SecActivity.this, huawei.getType(), Toast.LENGTH_SHORT).show();
                            Log.e(Cons.TAG,"Sec:"+huawei.getType());
                        }
                    }
                }

        );
    }

    /**
     * 发布者
     *
     * @param view
     */
    public void sendMessage(View view) {
        HuaWei huawei = new HuaWei("META-20");
        //厂家发布消息
        LiveDataBus.getInstance().with("huawei", HuaWei.class).postValue(huawei);
    }
}