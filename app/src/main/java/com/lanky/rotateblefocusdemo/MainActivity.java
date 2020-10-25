package com.lanky.rotateblefocusdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity{
    private static String TAG = "lanky";
    private Context mContext = MainActivity.this;

    private ImageView focus_bg;
    private ImageView focus_in;
    private ImageView focus_out;
    int angle_in = 0;
    int angle_out = 0;
    int step = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Window w = getWindow();
//        Display display = w.getWindowManager().getDefaultDisplay();
//        WindowManager.LayoutParams lp = w.getAttributes();
//        lp.width = (int) (display.getWidth() * 0.46);
//        lp.height = (int) (display.getHeight() * 0.75);
//        lp.gravity = Gravity.CENTER;
//        lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//        w.setAttributes(lp);
        initView();
    }

    private void initView() {
        focus_bg = (ImageView) findViewById(R.id.iv_focus_bg);
        focus_in = (ImageView) findViewById(R.id.iv_focus_in);
        focus_out = (ImageView) findViewById(R.id.iv_focus_out);
//        centerFocusPics();
    }

    public void centerFocusPics(){
        focus_in.setPivotX(focus_in.getWidth() / 2);
        focus_in.setPivotY(focus_in.getHeight() / 2);
        focus_in.setRotation(0);
        focus_out.setPivotX(focus_out.getWidth() / 2);
        focus_out.setPivotY(focus_out.getHeight() / 2);
        focus_out.setRotation(0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                focus_far();
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_LEFT:
                focus_near();
                break;
            default:break;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void focus_far() {
        angle_in = angle_in + step;
        focus_in.setRotation(angle_in);
        focus_in.setPivotX(focus_in.getWidth() / 2);
        focus_in.setPivotY(focus_in.getHeight() / 2);

        angle_out = angle_out - step;
        focus_out.setRotation(angle_out);
        focus_out.setPivotX(focus_out.getWidth() / 2);
        focus_out.setPivotY(focus_out.getHeight() / 2);
    }

    public void focus_near() {
        angle_in = angle_in - step;
        focus_in.setRotation(angle_in);
        focus_in.setPivotX(focus_in.getWidth() / 2);
        focus_in.setPivotY(focus_in.getHeight() / 2);

        angle_out = angle_out + step;
        focus_out.setRotation(angle_out);
        focus_out.setPivotX(focus_out.getWidth() / 2);
        focus_out.setPivotY(focus_out.getHeight() / 2);
    }
}