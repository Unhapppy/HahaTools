package android.haha.com.hahalibrary.statusBar;

import android.app.Activity;
import android.os.Build;
import android.view.View;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class SetStatus {
    public static void setStatusBarColor(Activity activity,int var1) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            activity.getWindow().setStatusBarColor(var1);
            //透明状态栏
            //activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
