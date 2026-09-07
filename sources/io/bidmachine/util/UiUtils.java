package io.bidmachine.util;

import android.app.Activity;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.Window;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.handler.UIHandlerTaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiUtils.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\nH\u0007J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0007J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u001e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0012H\u0007J!\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010%\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J#\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010%\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lio/bidmachine/util/UiUtils;", "", "()V", "TASK_MANAGER", "Lio/bidmachine/util/taskmanager/TaskManager;", "applyFullscreenActivity", "", "activity", "Landroid/app/Activity;", "isNoStatusBar", "", "applySystemUiVisibility", "window", "Landroid/view/Window;", "cancelOnUiThread", "runnable", "Ljava/lang/Runnable;", "defineOrientationBySize", "", "width", "height", "finishActivityWithoutAnimation", "hideKeyboard", "(Landroid/app/Activity;)Ljava/lang/Boolean;", "isUiThread", "obtainMotionEvent", "Landroid/view/MotionEvent;", "action", VastAttributes.HORIZONTAL_POSITION, VastAttributes.VERTICAL_POSITION, "onUiThread", "delayMs", "", "orientationToString", "", "orientation", "setActivityBackgroundColor", "color", "(Landroid/app/Activity;I)Lkotlin/Unit;", "setNoActivityTransition", "setWindowBackgroundColor", "(Landroid/view/Window;I)Lkotlin/Unit;", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UiUtils {
    public static final UiUtils INSTANCE = new UiUtils();
    private static final TaskManager TASK_MANAGER = new UIHandlerTaskManager();

    @JvmStatic
    public static final int defineOrientationBySize(int width, int height) {
        return width > height ? 2 : 1;
    }

    private UiUtils() {
    }

    @JvmStatic
    public static final boolean isUiThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static final boolean onUiThread(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        TASK_MANAGER.execute(runnable);
        return true;
    }

    @JvmStatic
    public static final boolean onUiThread(Runnable runnable, long delayMs) {
        if (runnable == null) {
            return false;
        }
        TASK_MANAGER.schedule(runnable, delayMs);
        return true;
    }

    @JvmStatic
    public static final void cancelOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        TASK_MANAGER.cancel(runnable);
    }

    @JvmStatic
    public static final Unit setWindowBackgroundColor(Window window, int color) {
        return UiUtilsKt.setWindowBackgroundColor(window, color);
    }

    @JvmStatic
    public static final Unit setActivityBackgroundColor(Activity activity, int color) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return UiUtilsKt.setActivityBackgroundColor(activity, color);
    }

    @JvmStatic
    public static final void setNoActivityTransition(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        UiUtilsKt.setNoActivityTransition(activity);
    }

    @JvmStatic
    public static final void finishActivityWithoutAnimation(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        UiUtilsKt.finishActivityWithoutAnimation(activity);
    }

    @JvmStatic
    public static final void applyFullscreenActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        applyFullscreenActivity(activity, true);
    }

    public static /* synthetic */ void applyFullscreenActivity$default(Activity activity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        applyFullscreenActivity(activity, z);
    }

    @JvmStatic
    public static final void applyFullscreenActivity(Activity activity, boolean isNoStatusBar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        UiUtilsKt.applyFullscreenActivity(activity, isNoStatusBar);
    }

    @JvmStatic
    public static final void applySystemUiVisibility(Window window, boolean isNoStatusBar) {
        Intrinsics.checkNotNullParameter(window, "window");
        UiUtilsKt.applySystemUiVisibility(window, isNoStatusBar);
    }

    @JvmStatic
    public static final Boolean hideKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return UiUtilsKt.hideKeyboard(activity);
    }

    @JvmStatic
    public static final String orientationToString(int orientation) {
        if (orientation == 0) {
            return "UNDEFINED";
        }
        if (orientation == 1) {
            return "PORTRAIT";
        }
        if (orientation == 2) {
            return "LANDSCAPE";
        }
        return "UNKNOWN";
    }

    @JvmStatic
    public static final MotionEvent obtainMotionEvent(int action, int x, int y) {
        MotionEvent motionEventObtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), action, x, y, 0);
        Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(\n            Syst…,\n            0\n        )");
        return motionEventObtain;
    }
}
