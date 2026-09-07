package io.bidmachine.rendering.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.model.Orientation;
import io.bidmachine.rendering.utils.taskmanager.TaskManager;
import io.bidmachine.rendering.utils.taskmanager.UITaskManager;
import io.bidmachine.util.Executable;

/* JADX INFO: loaded from: classes7.dex */
public class UiUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TaskManager f12436a = new UITaskManager();

    class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12437a;

        a(int i) {
            this.f12437a = i;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            Insets insets = windowInsets.getInsets(this.f12437a);
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            return windowInsets;
        }
    }

    public static void applyInsets(Activity activity, View contentView) {
        applyInsets(activity, contentView, true);
    }

    public static void cancelOnUiThread(Runnable runnable) {
        f12436a.cancel(runnable);
    }

    public static int dpToPx(Context context, float value) {
        if (value == 0.0f) {
            return 0;
        }
        return io.bidmachine.iab.utils.Utils.dpToPx(context, value);
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static Rect getLocationInWindow(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], view.getWidth() + iArr[0], view.getHeight() + iArr[1]);
    }

    public static float getNotOverlappedAreaPercent(Rect mainRect, Rect coverRect) {
        int iWidth = mainRect.width() * mainRect.height();
        if (iWidth == 0) {
            return 0.0f;
        }
        return (iWidth - (Math.max(0, Math.min(mainRect.right, coverRect.right) - Math.max(mainRect.left, coverRect.left)) * Math.max(0, Math.min(mainRect.bottom, coverRect.bottom) - Math.max(mainRect.top, coverRect.top)))) / iWidth;
    }

    public static boolean isViewTransparent(View view) {
        return view.getAlpha() == 0.0f;
    }

    public static boolean isViewVisible(int visibility) {
        return visibility == 0;
    }

    public static void onUiThread(Runnable runnable) {
        f12436a.execute(runnable);
    }

    public static <I> void onUiThreadWithArgSafely(final I input, final Executable<I> postMethod) {
        if (postMethod == null) {
            return;
        }
        io.bidmachine.util.UiUtils.onUiThread(new l() { // from class: io.bidmachine.rendering.utils.UiUtils$$ExternalSyntheticLambda2
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                postMethod.execute(input);
            }
        });
    }

    public static void safeHideView(final View view) {
        if (view == null) {
            return;
        }
        onUiThread(new l() { // from class: io.bidmachine.rendering.utils.UiUtils$$ExternalSyntheticLambda1
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                view.setVisibility(8);
            }
        });
    }

    public static void safeSetBackgroundColor(View view, Integer backgroundColor) {
        if (view == null || backgroundColor == null) {
            return;
        }
        try {
            view.setBackgroundColor(backgroundColor.intValue());
        } catch (Throwable th) {
            m.b(th);
        }
    }

    public static void safeShowView(final View view) {
        if (view == null) {
            return;
        }
        onUiThread(new l() { // from class: io.bidmachine.rendering.utils.UiUtils$$ExternalSyntheticLambda0
            @Override // io.bidmachine.rendering.utils.SafeRunnable
            public final void onRun() {
                view.setVisibility(0);
            }
        });
    }

    public static void setActivityBackgroundColor(Activity activity, int color) {
        setWindowBackgroundColor(activity.getWindow(), color);
    }

    public static void setDefaultActivityTransition(Activity activity) {
        if (Build.VERSION.SDK_INT < 34) {
            activity.overridePendingTransition(0, 0);
        } else {
            activity.overrideActivityTransition(0, 0, 0);
            activity.overrideActivityTransition(1, 0, 0);
        }
    }

    public static void setInsetsChanger(View view) {
        setInsetsChanger(view, WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
    }

    public static void setWindowBackgroundColor(Window window, int color) {
        if (window == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(color));
    }

    public static void setupActivityOrientation(Activity activity, Orientation orientation) {
        activity.setRequestedOrientation(orientation != null ? orientation.getActivityOrientation() : 4);
    }

    public static int spToPx(Context context, float value) {
        return (int) TypedValue.applyDimension(2, value, context.getResources().getDisplayMetrics());
    }

    public static String toString(int visibility) {
        if (visibility == 0) {
            return "VISIBLE";
        }
        if (visibility != 4) {
            return visibility != 8 ? "unknown" : "GONE";
        }
        return "INVISIBLE";
    }

    public static void applyInsets(Activity activity, View contentView, boolean isRequestApplyInsets) {
        if (Build.VERSION.SDK_INT >= 35) {
            Window window = activity.getWindow();
            View decorView = window != null ? window.getDecorView() : contentView;
            contentView.setPadding(0, 0, 0, 0);
            setInsetsChanger(decorView);
            if (isRequestApplyInsets) {
                decorView.requestApplyInsets();
            }
        }
    }

    public static boolean isViewVisible(View view) {
        return isViewVisible(view.getVisibility());
    }

    public static void onUiThread(Runnable runnable, long delayMs) {
        f12436a.schedule(runnable, delayMs);
    }

    public static void setInsetsChanger(View view, int typeInsets) {
        view.setOnApplyWindowInsetsListener(new a(typeInsets));
    }
}
