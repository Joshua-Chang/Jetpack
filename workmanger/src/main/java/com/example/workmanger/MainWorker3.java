package com.example.workmanger;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MainWorker3 extends Worker {
    public MainWorker3(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    //这个方法是在子线程执行的
    @NonNull
    @Override
    public Result doWork() {
        //获取mainActivity传入进来的数据
        String inputData = getInputData().getString("input_data");
        Log.i(">>>","Worker3 接收成功： "+inputData);

        //上传，下载，同步数据。。。。。。
        Log.i(">>>","Worker3 执行了----------------上传，下载，同步数据----------------\n");

        //把任务中的数据回传到activity中
        Data outputData = new Data.Builder().putString("output_data", "回传数据 3").build();//封装
        return Result.success(outputData);//回传
    }
}