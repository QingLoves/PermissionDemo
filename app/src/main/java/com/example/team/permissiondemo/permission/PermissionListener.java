package com.example.team.permissiondemo.permission;

import java.util.List;

/**
 * Created by Team丶长相守 on 2018/1/12.
 * 权限回调接口
 */

public interface PermissionListener {



    public void onSucceed(int requestCode, String... grantPermissions);

    public void onFailed(int requestCode, String... grantPermissions);


}
