package me.imid.swipebacklayout.lib;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

public class j {
    public static void a(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            c(activity);
        } else {
            b(activity);
        }
    }

    public static void b(Activity activity) {
        Class cls = null;
        try {
            Class[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (i < length) {
                Class cls2 = declaredClasses[i];
                if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls2 = cls;
                }
                i++;
                cls = cls2;
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[]{null});
        } catch (Throwable th) {
        }
    }

    private static void c(Activity activity) {
        Class cls = null;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (i < length) {
                Class cls2 = declaredClasses[i];
                if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls2 = cls;
                }
                i++;
                cls = cls2;
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, new Object[]{null, invoke});
        } catch (Throwable th) {
        }
    }
}
