package com.facebook.unity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FBUnityAppLinkBaseActivity extends Activity {
    public static void safedk_FBUnityAppLinkBaseActivity_startActivity_b24ee302b8eae4bf360d19ab4d98a69f(FBUnityAppLinkBaseActivity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/facebook/unity/FBUnityAppLinkBaseActivity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "com.facebook");
        p0.startActivity(p1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.facebook", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Log.v(FB.TAG, "Saving deep link from deep linking activity");
        FB.SetIntent(getIntent());
        Log.v(FB.TAG, "Returning to main activity");
        safedk_FBUnityAppLinkBaseActivity_startActivity_b24ee302b8eae4bf360d19ab4d98a69f(this, new Intent(this, getMainActivityClass()));
        finish();
    }

    private Class<?> getMainActivityClass() {
        try {
            return Class.forName(getPackageManager().getLaunchIntentForPackage(getPackageName()).getComponent().getClassName());
        } catch (Exception unused) {
            Log.e(FB.TAG, "Unable to find Main Activity Class");
            return null;
        }
    }
}
