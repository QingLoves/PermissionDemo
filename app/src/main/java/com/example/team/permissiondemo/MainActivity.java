package com.example.team.permissiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.team.permissiondemo.permission.PermissionListener;
import com.example.team.permissiondemo.permission.PermissionsRequest;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   PermissionsRequest.getInstance().setPermissionListener(new PermissionListener() {
            @Override
            public void onSucceed(int requestCode, String... grantPermissions) {

            }

            @Override
            public void onFailed(int requestCode, String... grantPermissions) {

            }
        }).checkSelfPermission();*/

    }
}
