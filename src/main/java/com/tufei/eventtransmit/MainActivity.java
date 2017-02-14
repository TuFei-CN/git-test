package com.tufei.eventtransmit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnTouchListener {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView my_textview = (TextView) findViewById(R.id.my_textview);
        my_textview.setOnClickListener(this);
        my_textview.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent ACTION_DOWN");
//                无论是返回true还是false  日志都如下
//                E/MainActivity: dispatchTouchEvent ACTION_DOWN
//                E/MainActivity: dispatchTouchEvent ACTION_UP
//                E/MainActivity: onTouchEvent ACTION_UP
//                return true;
//                return false;
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent ACTION_UP");
//                无论是返回true还是false
//                第一次点击日志都如下
//                E/MainActivity: dispatchTouchEvent ACTION_DOWN
//                E/MyTextView: dispatchTouchEvent ACTION_DOWN
//                E/MainActivity: MyTextView onTouch ACTION_DOWN
//                E/MyTextView: onTouchEvent ACTION_DOWN
//                E/MainActivity: dispatchTouchEvent ACTION_UP

//                但第二次点击 日志如下
//                E/MainActivity: dispatchTouchEvent ACTION_DOWN
//                E/MyTextView: dispatchTouchEvent ACTION_CANCEL
//                E/MainActivity: MyTextView onTouch ACTION_CANCEL
//                E/MyTextView: onTouchEvent ACTION_CANCEL
//                E/MyTextView: dispatchTouchEvent ACTION_DOWN
//                E/MainActivity: MyTextView onTouch ACTION_DOWN
//                E/MyTextView: onTouchEvent ACTION_DOWN
//                E/MainActivity: dispatchTouchEvent ACTION_UP

//                return true;
//                return false;
//                break;j
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "dispatchTouchEvent ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onTouchEvent ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_textview:
                Log.e(TAG, "MyTextView onClick");
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyTextView onTouch ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyTextView onTouch ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "MyTextView onTouch ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "MyTextView onTouch ACTION_CANCEL");
                break;
            default:
                break;
        }
        //onTouch返回false  MyTextView的onTouchEvent才能执行
        return false;
    }
}
