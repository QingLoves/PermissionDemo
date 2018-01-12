package com.example.team.permissiondemo.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by Team丶长相守 on 2018/1/12.
 */

/*检查权限*/
public class CheckSelfPermission {
    private static String TAG = CheckSelfPermission.class.getName();

    private Activity mActivity;
    private String [] permission;



    public CheckSelfPermission(Activity context,String... permission){
        this.mActivity = context;
        this.permission = permission;

    }


    /*请求权限*/
    public boolean hasPermission(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

            for (String misson : permission){
                Log.e(TAG,misson);
                int permissionRequestCode = ContextCompat.checkSelfPermission(mActivity,misson);
                Log.e(TAG,permissionRequestCode+"");
                return  permissionRequestCode ==PackageManager.PERMISSION_DENIED? true:false;
                //返回PackageManager.PERMISSION_DENIED则需要申请权限

            }
        }
        return  false;
    }





}
