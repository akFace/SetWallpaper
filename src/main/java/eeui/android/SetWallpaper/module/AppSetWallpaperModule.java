package eeui.android.SetWallpaper.module;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import cc.shinichi.wallpaperlib.SetWallpaper;

public class AppSetWallpaperModule extends WXModule {

    /**
     * 简单演示
     * @param path
     */
    @JSMethod
    public void setWallpaper(String path) {
        if (requestPermission()) {
            SetWallpaper.setWallpaper(mWXSDKInstance.getContext(), // 上下文
                    path, // 图片绝对路径
                    mWXSDKInstance.getContext().getPackageName()+ ".FileProvider");// authority（7.0 文件共享权限）
        }
    }
    /**
     * 同步返回演示
     * @return
     */
    @JSMethod(uiThread = false)
    public boolean hasWriteStorage() {
        return requestPermission();
    }

    public boolean requestPermission() {
        Activity activity = (Activity) mWXSDKInstance.getContext();
        if (!(hasWriteStoragePermission(mWXSDKInstance.getContext()))) {
            ActivityCompat.requestPermissions(activity, new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        return hasWriteStoragePermission(activity);
    }

    private boolean hasWriteStoragePermission(Context context) {
        boolean result = ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        return result;
    }
}
