package com.example.team.permissiondemo.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Binder on 2018/1/14.
 */

public class PermissionsResult {

    public static void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults, Activity activity){


        if (grantResults.length>0){
            //点击授权
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
               // listener.onSucceed(requestCode,permissions);
                Log.e("同意了","======");

            }
            //点击拒绝调用shouldShowRequestPermissionRationale来判断是否不再允许
            else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
              //  listener.onFailed(requestCode,permissions);
                Log.e("拒绝了","=========");
                for (String mission : permissions){
                    Log.e("权限信息",mission);
                    //没有点不再询问
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity,mission)){
                        //告诉小婊砸，为何要弹这个权限
                        Log.e("告诉用户为何要提示这个权限","就这样");
                        ActivityCompat.requestPermissions(activity,permissions,requestCode);
                    }
                    //返回false则表示不再询问
                    else {
                        Log.e("这里勾选了不再询问","提示用户禁止权限后果");
                        //该弹Dialog了
                    }
                }


           /* if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity,mission)){

            }*/

            }

            Log.e("===",requestCode+":"+grantResults.length+":"+permissions.length);
            List<String> deniedPermissions = new ArrayList<>();
            for (int i = 0; i < grantResults.length; i++)
            {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED)
                {
                    deniedPermissions.add(permissions[i]);
                }
            }
        }



    }
}
