package com.example.allen.allenbasemvp.utility;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.allen.allenbasemvp.R;

import org.jetbrains.annotations.NotNull;

import io.reactivex.annotations.NonNull;

/**
 * Created by allen on 2018/12/25.
 */
public class ProgressBar {


    private static ProgressBar instance;

    private Dialog mDialog;


    public static ProgressBar getInstance() {
        if(null == instance) {
            synchronized (ProgressBar.class) {
                if(null == instance) {
                    instance = new ProgressBar();
                }
            }
        }
        return instance;
    }
    public Dialog createDialog(Context context){
        if(mDialog ==null){
            synchronized (Dialog.class){
                if(mDialog == null){
                    mDialog = new Dialog(context);
                    mDialog.setContentView(LayoutInflater.from(context).inflate(R.layout.progress,null));
                }
            }
        }
        return mDialog;
    }
    public void dismiss(){
        if(mDialog!=null){
            mDialog.dismiss();
        }
    }
}
