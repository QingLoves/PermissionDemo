package com.example.team.permissiondemo.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Team丶长相守 on 2018/1/12.
 */

public class PermissionsRequest  {

    private volatile static  PermissionsRequest request = null;
    private PermissionListener listener;
    private Activity mActivity;
    private String[] permission;
    private int requestCode;

    private PermissionsRequest(){
    }

    public static PermissionsRequest getInstance(){
        if (request == null){
            synchronized (PermissionsRequest.class){
                if (request == null){
                    request = new PermissionsRequest();
                }
            }
        }
        return request;
    }


    /**
     * 检查权限
     * */
    public void checkSelfPermission(Activity mActivity,int requestCode, String... permission){
        this.mActivity = mActivity;
        this.requestCode =requestCode;
        this.permission = permission;
        CheckSelfPermission checkSelfPermission = new CheckSelfPermission(mActivity,permission);
        if (checkSelfPermission.hasPermission()){
            listener.onFailed(requestCode,permission);
            ActivityCompat.requestPermissions(mActivity,permission,requestCode);
        }
        else {
            //权限允许
            Log.e("====","权限允许");
            listener.onSucceed(requestCode,permission);
        }

    }
    public PermissionsRequest setPermissionListener(PermissionListener listener){
        this.listener = listener;
        return this;
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){


        if (grantResults.length>0){
            //点击授权
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                listener.onSucceed(requestCode,permissions);
                Log.e("同意了","======");

            }
            //点击拒绝调用shouldShowRequestPermissionRationale来判断是否不再允许
            else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                listener.onFailed(requestCode,permissions);
                Log.e("拒绝了","=========");
                for (String mission : permissions){
                    Log.e("权限信息",mission);
                    //没有点不再询问
                    if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity,mission)){
                        //告诉小婊砸，为何要弹这个权限
                        Log.e("小婊砸","哼");
                        ActivityCompat.requestPermissions(mActivity,permission,requestCode);
                    }
                    //返回false则表示不再询问
                    else {
                        Log.e("这里勾选了不再询问，","要提示用户手动去设置");
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
