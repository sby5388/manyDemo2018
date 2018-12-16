package com.by5388.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;


/**
 * @author by5388 on 20181216.
 */


public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private Handler handlerOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        findViewById(R.id.button_main).setOnClickListener(v -> mainThing());
        findViewById(R.id.button_other).setOnClickListener(v -> otherThing());
    }

    private void otherThing() {
//        Message message = handlerOther.obtainMessage();
        Message message =Message.obtain();
        message.what = 2;
        message.obj = "来自主线程2的问候";
//        message.sendToTarget();
        handlerOther.sendMessageDelayed(message,1000L);
    }

    private void mainThing() {
        new Thread(() -> {
            SystemClock.sleep(1000);
            Message message = Message.obtain();
            message.what = 1;
            message.obj = "来自子线程的问候";
            handler.sendMessage(message);
        }).start();
    }

    private void initData() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        Toast toast = Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 100, 50);
                        toast.show();
                        break;
                    default:
                        break;
                }
            }
        };

        new Thread(() -> {
            //1.创建Looper对象,然后Looper对象中创建了MessageQuene
            //2.将当前的Looper对象与当前线程(子线程)绑定ThreadLocal
            Looper.prepare();
            //3.创建handler对象，然后从当前线程中去的Looper对象，进而获取到MessageQuene对象
            handlerOther = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 2:
                            Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                }
            };
            //4.从当前线程中找到之前创建的Looper对象，再找到MessageQuene对象
            //5.开启死循环，便利消息池中的消息
            //6.获取到Message时 调用Message中的handler的disPatchMessage方法，执行Message
            Looper.loop();
        }).start();
    }

}

