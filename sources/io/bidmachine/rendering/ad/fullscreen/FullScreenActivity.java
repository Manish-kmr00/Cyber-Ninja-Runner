package io.bidmachine.rendering.ad.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.window.OnBackInvokedCallback;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.UiUtils;

/* JADX INFO: loaded from: classes5.dex */
public class FullScreenActivity extends Activity {
    private static FullScreenAd b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FullScreenAd f12324a;

    private void a() {
        Utils.finishActivityWithoutAnimation(this);
        FullScreenAd fullScreenAd = this.f12324a;
        if (fullScreenAd != null) {
            fullScreenAd.r();
            this.f12324a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "io.bidmachine");
        p0.startActivity(p1);
    }

    public static void show(Context context, FullScreenAd fullScreenAd) {
        try {
            b = fullScreenAd;
            Intent intent = new Intent(context, (Class<?>) FullScreenActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(8388608);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        } catch (Throwable unused) {
            b = null;
            fullScreenAd.d(new Error("Ad is null"));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("io.bidmachine", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT < 33) {
            b();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        UiUtils.setActivityBackgroundColor(this, ViewCompat.MEASURED_STATE_MASK);
        UiUtils.setDefaultActivityTransition(this);
        super.onCreate(bundle);
        FullScreenAd fullScreenAd = b;
        this.f12324a = fullScreenAd;
        if (fullScreenAd == null) {
            a();
            return;
        }
        fullScreenAd.b(this);
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: io.bidmachine.rendering.ad.fullscreen.FullScreenActivity$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    this.f$0.b();
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isChangingConfigurations()) {
            return;
        }
        if (b == this.f12324a) {
            b = null;
        }
        a();
    }
}
