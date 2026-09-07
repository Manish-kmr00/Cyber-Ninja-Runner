package io.bidmachine.util;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u0002¢\u0006\u0002\u0010\t\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0002\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"applyFullscreenActivity", "", "Landroid/app/Activity;", "isNoStatusBar", "", "applySystemUiVisibility", "Landroid/view/Window;", "finishActivityWithoutAnimation", "hideKeyboard", "(Landroid/app/Activity;)Ljava/lang/Boolean;", "setActivityBackgroundColor", "color", "", "(Landroid/app/Activity;I)Lkotlin/Unit;", "setNoActivityTransition", "setWindowBackgroundColor", "(Landroid/view/Window;I)Lkotlin/Unit;", "bidmachine-android-util_d_0_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UiUtilsKt {
    public static final Unit setWindowBackgroundColor(Window window, int i) {
        if (window == null) {
            return null;
        }
        window.setBackgroundDrawable(new ColorDrawable(i));
        return Unit.INSTANCE;
    }

    public static final Unit setActivityBackgroundColor(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return UiUtils.setWindowBackgroundColor(activity.getWindow(), i);
    }

    public static final void setNoActivityTransition(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (Build.VERSION.SDK_INT >= 34) {
            activity.overrideActivityTransition(0, 0, 0);
            activity.overrideActivityTransition(1, 0, 0);
        } else {
            activity.overridePendingTransition(0, 0);
        }
    }

    public static final void finishActivityWithoutAnimation(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.finish();
        setNoActivityTransition(activity);
    }

    public static /* synthetic */ void applyFullscreenActivity$default(Activity activity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        applyFullscreenActivity(activity, z);
    }

    public static final void applyFullscreenActivity(Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.requestWindowFeature(1);
        Window window = activity.getWindow();
        if (window != null) {
            window.addFlags(128);
            applySystemUiVisibility(window, z);
        }
        hideKeyboard(activity);
    }

    public static /* synthetic */ void applySystemUiVisibility$default(Window window, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        applySystemUiVisibility(window, z);
    }

    public static final void applySystemUiVisibility(Window window, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController windowInsetsController = window.getDecorView().getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.setSystemBarsBehavior(2);
                if (z) {
                    windowInsetsController.hide(WindowInsets.Type.statusBars());
                    return;
                }
                return;
            }
            return;
        }
        if (z) {
            window.setFlags(1024, 1024);
            i = 4;
        } else {
            i = 0;
        }
        if (i > 0) {
            window.getDecorView().setSystemUiVisibility(i);
        }
    }

    public static final Boolean hideKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Activity activity2 = activity;
        InputMethodManager inputMethodManager = UtilsKt.getInputMethodManager(activity2);
        if (inputMethodManager == null) {
            return null;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity2);
        }
        return Boolean.valueOf(inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0));
    }
}
