package com.example.jetpack.mvvm;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;

import com.squareup.picasso.Picasso;


public class User extends BaseObservable {
    private String name;
    private String password;

    private String header;
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
    @Bindable
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
        notifyPropertyChanged(BR.header);
    }

    public User(String name, String password, String header) {
        this.name = name;
        this.password = password;
        this.header=header;
    }
    @BindingAdapter("bind:header")
    public static void getImage(ImageView view,String url){
        Picasso.with(view.getContext()).load(url).into(view);
    }
    public void click(View view){
        Toast.makeText(view.getContext(), "password:"+password, Toast.LENGTH_SHORT).show();
        
    }

}
