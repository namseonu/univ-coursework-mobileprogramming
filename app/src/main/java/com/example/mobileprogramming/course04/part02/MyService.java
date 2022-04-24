package com.example.mobileprogramming.course04.part02;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() { }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//    }

    @Override
    public int onStartCommand(Intent intent, int flags,int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_LONG).show();

        // START_STICKY
        // --> tells the OS to recreate the service after it has enough memory and call onStartCommand() again with a null intent.
        // --> 즉, 서비스가 강제종료 되었을 경우, 재시작함
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(), "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet Implemented");
    }
}
