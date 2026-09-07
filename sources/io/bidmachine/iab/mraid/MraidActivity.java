package io.bidmachine.iab.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.Utils;

/* JADX INFO: loaded from: classes9.dex */
public class MraidActivity extends Activity {
    private static final SparseArray d = new SparseArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f12187a;
    private MraidInterstitial b;
    private boolean c = false;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12188a;

        static {
            int[] iArr = new int[MraidType.values().length];
            f12188a = iArr;
            try {
                iArr[MraidType.Static.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12188a[MraidType.Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12188a[MraidType.Rewarded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static void a(MraidInterstitial mraidInterstitial) {
        d.put(mraidInterstitial.id, mraidInterstitial);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "io.bidmachine");
        p0.startActivity(p1);
    }

    public static void show(Context context, MraidInterstitial mraidInterstitial, MraidType mraidType) {
        if (mraidInterstitial == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.g, "MraidInterstitial is null during showing MraidActivity", new Object[0]);
            return;
        }
        if (context == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.g, "Context is null during showing MraidActivity", new Object[0]);
            mraidInterstitial.c(IabError.noRequiredArguments("Context is null during showing MraidActivity"));
            return;
        }
        if (mraidType == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.g, "MraidType is null during showing MraidActivity", new Object[0]);
            mraidInterstitial.c(IabError.noRequiredArguments("MraidType is null during showing MraidActivity"));
            return;
        }
        try {
            a(mraidInterstitial);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, a(context, mraidType, mraidInterstitial.id));
        } catch (Throwable th) {
            MraidLog.e("Exception during showing MraidActivity", th);
            mraidInterstitial.c(IabError.throwable("Exception during showing MraidActivity", th));
            a(Integer.valueOf(mraidInterstitial.id));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("io.bidmachine", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.c) {
            MraidInterstitial mraidInterstitial = this.b;
            if (mraidInterstitial != null) {
                mraidInterstitial.dispatchClose();
            } else {
                Utils.finishActivityWithoutAnimation(this);
            }
        }
    }

    public void onBeforeCreate(Window window) {
        Utils.setWindowBackgroundColor(window, ViewCompat.MEASURED_STATE_MASK);
    }

    public void onBeforeShowContent() {
        Utils.applyFullscreenActivityFlags(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        onBeforeCreate(getWindow());
        Utils.setDefaultActivityTransition(this);
        super.onCreate(bundle);
        if (!getIntent().hasExtra("InterstitialId")) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.g, "Mraid display cache id not provided", new Object[0]);
            Utils.finishActivityWithoutAnimation(this);
            return;
        }
        Integer numValueOf = Integer.valueOf(getIntent().getIntExtra("InterstitialId", 0));
        this.f12187a = numValueOf;
        MraidInterstitial mraidInterstitial = (MraidInterstitial) d.get(numValueOf.intValue());
        this.b = mraidInterstitial;
        if (mraidInterstitial == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.g, "Mraid interstitial not found in display cache, id=%s", this.f12187a);
            Utils.finishActivityWithoutAnimation(this);
            return;
        }
        MraidType mraidType = (MraidType) getIntent().getSerializableExtra("InterstitialType");
        if (mraidType == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.g, "MraidType is null", new Object[0]);
            Utils.finishActivityWithoutAnimation(this);
            this.b.c(IabError.internal("MraidType is null"));
            return;
        }
        onBeforeShowContent();
        int i = a.f12188a[mraidType.ordinal()];
        if (i == 1 || i == 2) {
            this.c = true;
        } else if (i == 3) {
            this.c = false;
        }
        try {
            this.b.a((Activity) this, false);
        } catch (Exception e) {
            MraidLog.e("Exception during showing MraidInterstial in MraidActivity", e);
            Utils.finishActivityWithoutAnimation(this);
            this.b.c(IabError.throwable("Exception during showing MraidInterstial in MraidActivity", e));
            a();
        }
        Utils.applyWindowInsets(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.b == null || isChangingConfigurations()) {
            return;
        }
        this.b.b();
        a();
    }

    static Intent a(Context context, Class cls, MraidType mraidType, int i) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.putExtra("InterstitialId", i);
        intent.putExtra("InterstitialType", mraidType);
        return intent;
    }

    static Intent a(Context context, MraidType mraidType, int i) {
        Intent intentA = a(context, MraidActivity.class, mraidType, i);
        intentA.addFlags(268435456);
        intentA.addFlags(8388608);
        return intentA;
    }

    private void a() {
        a(this.f12187a);
    }

    static void a(Integer num) {
        if (num == null) {
            return;
        }
        d.remove(num.intValue());
    }
}
