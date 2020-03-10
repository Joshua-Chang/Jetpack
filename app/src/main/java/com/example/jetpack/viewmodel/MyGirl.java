package com.example.jetpack.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jetpack.R;
import com.example.jetpack.bean.Girl;

import java.util.ArrayList;
import java.util.List;

public class MyGirl extends ViewModel {
    //定义一个对象,相当于一个用来存放数据的仓库 //static 让其全局公共起来
    private static MutableLiveData<List<Girl>> liveData;
    //用来获取数据
    public LiveData<List<Girl>> getDataBean(){
        if (liveData == null) {
            liveData=new MutableLiveData<>();
        }
        loadData();
        return liveData;
    }

    private void loadData() {
        List<Girl> data = new ArrayList<>();
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
        liveData.setValue(data);//把数据存入仓库
    }


    public void changeValue(int position,String s){
        List<Girl> value = liveData.getValue();
        value.get(position).setLike(s);
        liveData.setValue(value);
    }
}
