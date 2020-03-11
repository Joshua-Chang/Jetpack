package com.example.workmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    OneTimeWorkRequest request;//单次
    OneTimeWorkRequest request2;//单次
    OneTimeWorkRequest request3;//单次
    OneTimeWorkRequest request4;//单次
    OneTimeWorkRequest request5;//单次
    PeriodicWorkRequest periodicWorkRequest;//多次（最小间隔15分钟）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data inputData = new Data.Builder().putString("input_data", "传入数据 ：的撒风；离开的发生").build();//传入任务的数据

        request = new OneTimeWorkRequest.Builder(MainWorker.class).setInputData(inputData).build();//初始化
        /*WorkManager.getInstance(this).enqueue(request);//放入队列,
        Log.i(">>>","Main 工作入队： "+inputData);
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.getId())//有工作状态
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if (workInfo != null&&workInfo.getState().isFinished()) {
                            //在任务执行完成后
                            Log.e(">>>","Main 回传接收到："+workInfo.getOutputData().getString("output_data"));
                        }
                    }
                });*/

        request2 = new OneTimeWorkRequest.Builder(MainWorker2.class).setInputData(inputData).build();
        request3 = new OneTimeWorkRequest.Builder(MainWorker3.class).setInputData(inputData).build();
        request4 = new OneTimeWorkRequest.Builder(MainWorker4.class).setInputData(inputData).build();
        request5 = new OneTimeWorkRequest.Builder(MainWorker5.class).setInputData(inputData).build();
        //链式执行，场景：下游需要上游的结果，再继续执行
/*        WorkManager.getInstance(this)
                .beginWith(request3)
                .then(request2)
                .then(request4)
                .then(request5)
                .enqueue();*/
        //链式执行二，场景：下游需要多个上游同步执行的结果，再继续执行
        /*List<OneTimeWorkRequest> requestList = new ArrayList<>();
        requestList.add(request3);
        requestList.add(request2);
        WorkManager.getInstance(this)
        .beginWith(requestList)
                .then(request4)
                .enqueue();*/
        //链式执行三
        /*List<OneTimeWorkRequest> requestList = new ArrayList<>();
        requestList.add(request3);
        requestList.add(request2);
        WorkContinuation workContinuation1 = WorkManager.getInstance(this)
                .beginWith(requestList);
        WorkContinuation workContinuation2 = WorkManager.getInstance(this)
                .beginWith(request4).then(request5);
        List<WorkContinuation> workContinuations = new ArrayList<>();
        workContinuations.add(workContinuation1);
        workContinuations.add(workContinuation2);
        WorkContinuation.combine(workContinuations).then(request)//合并任务链
                .enqueue();*/

        //任务唯一性，防止多次执行
        //ExistingWorkPolicy.REPLACE替换、KEEP、APPEND
//        WorkManager.getInstance(this).beginUniqueWork("unique", ExistingWorkPolicy.REPLACE,request).enqueue();





//        重复任务 每天一次
//        periodicWorkRequest=new PeriodicWorkRequest.Builder(MainWorker.class,1, TimeUnit.DAYS).build();



//        约束条件
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)//有网络连接
                .setRequiresBatteryNotLow(true)//电量充足下执行
                .setRequiresStorageNotLow(true)//存储充足下执行
                .setRequiresDeviceIdle(true)//api23后 待机状态下
                .setRequiresCharging(true)//充电下执行
                .build();
        request = new OneTimeWorkRequest.Builder(MainWorker2.class)
                .setInputData(inputData)
                .setConstraints(constraints)//设置约束
                .build();
    }
}
