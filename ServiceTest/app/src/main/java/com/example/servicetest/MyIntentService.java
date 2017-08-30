package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by heyujie on 2017/8/30.
 */

public class MyIntentService extends IntentService {
    public  MyIntentService(){
       super("MyIntentService");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService","onDestroy executed");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
       Log.d("MyIntentService","Thread id is " + Thread.currentThread().getId());
    }
}
