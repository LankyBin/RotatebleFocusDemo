package com.lanky.rotateblefocusdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class FocusDialog extends Dialog{
    private Context mContext = null;

    private ImageView focus_bg;
    private ImageView focus_in;
    private ImageView focus_out;
    int angle_in = 0;
    int angle_out = 0;
    int step = 2;

    public FocusDialog(Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focus_dialog);
        initView();
        Window w = getWindow();
        Display display = w.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.width = (int) (display.getWidth() * 0.46);
        lp.height = (int) (display.getHeight() * 0.75);
        lp.gravity = Gravity.CENTER;
        lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        w.setAttributes(lp);
    }

    /**
     * lankybin add for rotate focus
     */
    private void initView() {
        focus_bg = (ImageView) findViewById(R.id.iv_focus_bg);
        focus_in = (ImageView) findViewById(R.id.iv_focus_in);
        focus_out = (ImageView) findViewById(R.id.iv_focus_out);
        centerFocusPics();

    }

    @Override
    public void show() {
        Log.d("lanky", "focus dialog show");
        super.show();
    }

    public void centerFocusPics(){
        focus_in.setPivotX(focus_in.getWidth() / 2);
        focus_in.setPivotY(focus_in.getHeight() / 2);
        focus_in.setRotation(0);
        focus_out.setPivotX(focus_out.getWidth() / 2);
        focus_out.setPivotY(focus_out.getHeight() / 2);
        focus_out.setRotation(0);
    }

    public void showFocus(int focus_direction){
        Log.d("lanky", "focus_direction: " + focus_direction);
        switch (focus_direction ) {
            case 0:
                focus_far();
                break;
            case 1:
                focus_near();
                break;
            case 2:
                xz();
                break;
            default:
                break;
        }
    }

    private void xz (){
        Animation rotateAnimation  = new RotateAnimation(15, 50, Animation.RELATIVE_TO_SELF, 175f, Animation.RELATIVE_TO_SELF, 175f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(50);
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        focus_bg.startAnimation(rotateAnimation);
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
