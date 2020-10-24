package com.lanky.rotateblefocusdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext = MainActivity.this;
    FocusDialog mFocusDialog;
    private Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_show = (Button) findViewById(R.id.btn_show);

        btn_show.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
                // if (mFocusDialog.isShowing()) {
//                mFocusDialog.showFocus(1);




                Date date = new Date();
                date.setTime(1589923220000L);
                SimpleDateFormat format0=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat format1=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                String date_str0=format0.format(date);
                String date_str1=format1.format(date);
                Log.d("lanky", "date1:" + date_str0);
                Log.d("lanky", "date2:" + date_str1);



                // }
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                // if (mFocusDialog.isShowing()) {
                mFocusDialog.showFocus(0);
                // }
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                // if (mFocusDialog.isShowing()) {
                mFocusDialog.showFocus(2);
                // }
                break;
            default:break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:

                mFocusDialog = new FocusDialog(mContext);
                if (mFocusDialog == null) {
                    mFocusDialog = new FocusDialog(mContext);
                }
                else {
                    if (!mFocusDialog.isShowing()) {
                        mFocusDialog.show();
                    }
                }
                break;
        }
    }
}