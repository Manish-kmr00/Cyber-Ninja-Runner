package io.bidmachine.iab.vast.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.measurer.VastAdMeasurer;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.VastActivityListener;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.VastPlaybackListener;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastRequestManager;
import io.bidmachine.iab.vast.VastViewListener;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public class VastActivity extends Activity {
    public static final int VAST_VIEW_ID = 1;
    static final Map h = new ConcurrentHashMap();
    static final Map i = new ConcurrentHashMap();
    private static WeakReference j;
    private static WeakReference k;
    private static WeakReference l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VastRequest f12273a;
    private VastView b;
    private VastActivityListener c;
    private boolean e;
    private boolean f;
    private boolean d = false;
    private final VastViewListener g = new a();

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private VastRequest f12274a;
        private VastActivityListener b;
        private VastView c;
        private VastPlaybackListener d;
        private VastAdMeasurer e;
        private MraidAdMeasurer f;

        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            BrandSafetyUtils.detectAdClick(p1, "io.bidmachine");
            p0.startActivity(p1);
        }

        Intent a(Context context) {
            Intent intent = new Intent(context, (Class<?>) VastActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return intent;
        }

        public IabError display(Context context) {
            VastRequest vastRequest = this.f12274a;
            if (vastRequest == null) {
                VastLog.e("VastActivity", "VastRequest is null", new Object[0]);
                return IabError.internal("VastRequest is null");
            }
            try {
                VastRequestManager.store(vastRequest);
                Intent intentA = a(context);
                intentA.putExtra("vast_request_id", this.f12274a.getId());
                VastActivityListener vastActivityListener = this.b;
                if (vastActivityListener != null) {
                    VastActivity.b(this.f12274a, vastActivityListener);
                }
                VastView vastView = this.c;
                if (vastView != null) {
                    VastActivity.b(this.f12274a, vastView);
                }
                if (this.d != null) {
                    WeakReference unused = VastActivity.j = new WeakReference(this.d);
                } else {
                    WeakReference unused2 = VastActivity.j = null;
                }
                if (this.e != null) {
                    WeakReference unused3 = VastActivity.k = new WeakReference(this.e);
                } else {
                    WeakReference unused4 = VastActivity.k = null;
                }
                if (this.f != null) {
                    WeakReference unused5 = VastActivity.l = new WeakReference(this.f);
                } else {
                    WeakReference unused6 = VastActivity.l = null;
                }
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentA);
                return null;
            } catch (Throwable th) {
                VastLog.e("VastActivity", th);
                VastActivity.f(this.f12274a);
                VastActivity.g(this.f12274a);
                WeakReference unused7 = VastActivity.j = null;
                WeakReference unused8 = VastActivity.k = null;
                WeakReference unused9 = VastActivity.l = null;
                return IabError.throwable("Exception during displaying VastActivity", th);
            }
        }

        public Builder setAdMeasurer(VastAdMeasurer vastAdMeasurer) {
            this.e = vastAdMeasurer;
            return this;
        }

        public Builder setListener(VastActivityListener listener) {
            this.b = listener;
            return this;
        }

        public Builder setPlaybackListener(VastPlaybackListener vastPlaybackListener) {
            this.d = vastPlaybackListener;
            return this;
        }

        public Builder setPostBannerAdMeasurer(MraidAdMeasurer mraidAdMeasurer) {
            this.f = mraidAdMeasurer;
            return this;
        }

        public Builder setRequest(VastRequest vastRequest) {
            this.f12274a = vastRequest;
            return this;
        }

        public Builder setVastView(VastView vastView) {
            this.c = vastView;
            return this;
        }
    }

    class a implements VastViewListener {
        a() {
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onClick(VastView vastView, VastRequest vastRequest, IabClickCallback iabClickCallback, String str) {
            if (VastActivity.this.c != null) {
                VastActivity.this.c.onVastClick(VastActivity.this, vastRequest, iabClickCallback, str);
            }
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onComplete(VastView vastView, VastRequest vastRequest) {
            if (VastActivity.this.c != null) {
                VastActivity.this.c.onVastComplete(VastActivity.this, vastRequest);
            }
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onFinish(VastView vastView, VastRequest vastRequest, boolean z) {
            VastActivity.this.a(vastRequest, z);
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onOrientationRequested(VastView vastView, VastRequest vastRequest, int i) {
            int forceOrientation = vastRequest.getForceOrientation();
            if (forceOrientation > -1) {
                i = forceOrientation;
            }
            VastActivity.this.a(i);
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onShowFailed(VastView vastView, VastRequest vastRequest, IabError iabError) {
            VastActivity.this.a(vastRequest, iabError);
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onShown(VastView vastView, VastRequest vastRequest) {
            if (VastActivity.this.c != null) {
                VastActivity.this.c.onVastShown(VastActivity.this, vastRequest);
            }
        }
    }

    private static VastActivityListener d(VastRequest vastRequest) {
        WeakReference weakReference = (WeakReference) h.get(vastRequest.getId());
        if (weakReference != null && weakReference.get() != null) {
            return (VastActivityListener) weakReference.get();
        }
        f(vastRequest);
        return null;
    }

    private static VastView e(VastRequest vastRequest) {
        WeakReference weakReference = (WeakReference) i.get(vastRequest.getId());
        if (weakReference != null && weakReference.get() != null) {
            return (VastView) weakReference.get();
        }
        g(vastRequest);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(VastRequest vastRequest) {
        h.remove(vastRequest.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(VastRequest vastRequest) {
        i.remove(vastRequest.getId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("io.bidmachine", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        VastView vastView = this.b;
        if (vastView != null) {
            vastView.handleBackPress();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Integer numC;
        Utils.setWindowBackgroundColor(getWindow(), ViewCompat.MEASURED_STATE_MASK);
        Utils.setDefaultActivityTransition(this);
        super.onCreate(bundle);
        this.f12273a = VastRequestManager.get(getIntent().getStringExtra("vast_request_id"));
        if (bundle != null && bundle.getBoolean("isFinishedPerformed")) {
            finish();
            return;
        }
        VastRequest vastRequest = this.f12273a;
        if (vastRequest == null) {
            a((VastRequest) null, IabError.internal("VastRequest is null"));
            a((VastRequest) null, false);
            return;
        }
        if (bundle == null && (numC = c(vastRequest)) != null) {
            a(numC.intValue());
            try {
                if ((getPackageManager().getActivityInfo(getComponentName(), 65536).configChanges & 128) == 0) {
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        this.c = d(this.f12273a);
        VastView vastViewE = e(this.f12273a);
        this.b = vastViewE;
        if (vastViewE == null) {
            this.d = true;
            this.b = new VastView(this);
        }
        this.b.setId(1);
        this.b.setListener(this.g);
        WeakReference weakReference = j;
        if (weakReference != null) {
            this.b.setPlaybackListener((VastPlaybackListener) weakReference.get());
        }
        WeakReference weakReference2 = k;
        if (weakReference2 != null) {
            this.b.setAdMeasurer((VastAdMeasurer) weakReference2.get());
        }
        WeakReference weakReference3 = l;
        if (weakReference3 != null) {
            this.b.setPostBannerAdMeasurer((MraidAdMeasurer) weakReference3.get());
        }
        if (bundle == null || !bundle.getBoolean("isLoadPerformed")) {
            this.e = true;
            if (!this.b.display(this.f12273a, Boolean.TRUE)) {
                return;
            }
        }
        a(this.b);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        VastRequest vastRequest;
        VastView vastView;
        super.onDestroy();
        if (isChangingConfigurations() || (vastRequest = this.f12273a) == null) {
            return;
        }
        VastView vastView2 = this.b;
        a(vastRequest, vastView2 != null && vastView2.isFinished());
        if (this.d && (vastView = this.b) != null) {
            vastView.destroy();
        }
        f(this.f12273a);
        g(this.f12273a);
        j = null;
        k = null;
        l = null;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isLoadPerformed", this.e);
        bundle.putBoolean("isFinishedPerformed", this.f);
    }

    private Integer c(VastRequest vastRequest) {
        int forceOrientation = vastRequest.getForceOrientation();
        if (forceOrientation > -1) {
            return Integer.valueOf(forceOrientation);
        }
        int preferredVideoOrientation = vastRequest.getPreferredVideoOrientation();
        if (preferredVideoOrientation == 0 || preferredVideoOrientation == getResources().getConfiguration().orientation) {
            return null;
        }
        return Integer.valueOf(preferredVideoOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(VastRequest vastRequest, VastActivityListener vastActivityListener) {
        h.put(vastRequest.getId(), new WeakReference(vastActivityListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(VastRequest vastRequest, VastView vastView) {
        i.put(vastRequest.getId(), new WeakReference(vastView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VastRequest vastRequest, boolean z) {
        VastActivityListener vastActivityListener = this.c;
        if (vastActivityListener != null && !this.f) {
            vastActivityListener.onVastDismiss(this, vastRequest, z);
        }
        this.f = true;
        try {
            getWindow().clearFlags(128);
        } catch (Exception e) {
            VastLog.e("VastActivity", e.getMessage(), new Object[0]);
        }
        if (vastRequest != null) {
            a(vastRequest.getRequestedOrientation());
        }
        finish();
        Utils.setDefaultActivityTransition(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VastRequest vastRequest, IabError iabError) {
        VastActivityListener vastActivityListener = this.c;
        if (vastActivityListener != null) {
            vastActivityListener.onVastShowFailed(vastRequest, iabError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        int i3;
        if (i2 == 1) {
            i3 = 7;
        } else {
            i3 = i2 == 2 ? 6 : 4;
        }
        setRequestedOrientation(i3);
    }

    private void a(VastView vastView) {
        Utils.applyFullscreenActivityFlags(this);
        Utils.removeFromParent(vastView);
        setContentView(vastView);
        Utils.applyWindowInsets(this);
    }
}
