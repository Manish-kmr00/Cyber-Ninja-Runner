package com.pubmatic.sdk.webrendering.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.cache.POBAdViewCacheService;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.ui.POBFullScreenActivityBackPressListener;
import com.pubmatic.sdk.common.ui.POBFullScreenActivityListener;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.webrendering.R;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class POBFullScreenActivity extends Activity {
    public static final String ALLOW_ORIENTATION_CHANGE = "AllowOrientation";
    public static final String ENABLE_BACK_PRESS = "EnableBackPress";
    public static final String RENDERER_IDENTIFIER = "RendererIdentifier";
    public static final String REQUESTED_ORIENTATION = "RequestedOrientation";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f7927a;
    private int b;
    private LocalBroadcastManager c;
    private POBFullScreenActivityListener d;
    private POBFullScreenActivityBackPressListener e;
    private boolean g = false;
    private BroadcastReceiver f = new a();

    public enum ACTIONS {
        POB_CLOSE,
        POB_BACK_PRESS
    }

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Integer.valueOf(intent.getIntExtra(POBFullScreenActivity.RENDERER_IDENTIFIER, 0)).equals(Integer.valueOf(POBFullScreenActivity.this.b))) {
                POBFullScreenActivity.this.onBroadcastReceived(intent);
            }
        }
    }

    public static void closeActivity(Context context, int i) {
        String strName = ACTIONS.POB_CLOSE.name();
        Intent intent = new Intent(strName);
        intent.putExtra(RENDERER_IDENTIFIER, i);
        try {
            sendBroadcast(context, intent);
        } catch (Exception e) {
            POBLog.warn("POBFullScreenActivity", "Unable to close full screen activity for %s. Error: %s", strName, e.getMessage());
        }
    }

    public static void safedk_POBFullScreenActivity_startActivity_9b43eeb3a2c956a47043e4be8e9dab59(Context p0, Intent p1) throws Exception {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/pubmatic/sdk/webrendering/ui/POBFullScreenActivity;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.F);
        startActivity(p0, p1);
    }

    public static void safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(Context p0, Intent p1) throws Exception {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/pubmatic/sdk/common/utility/POBUtils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.F);
        POBUtils.startActivity(p0, p1);
    }

    public static void sendBroadcast(Context context, Intent intent) throws Exception {
        try {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        } catch (Exception e) {
            POBLog.warn("POBFullScreenActivity", "Unable to send broadcast for %s", intent.getAction());
            throw new Exception(e);
        }
    }

    public static void startActivity(Context context, Intent intent) throws Exception {
        intent.setClass(context, POBFullScreenActivity.class);
        intent.addFlags(268435456);
        safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(context, intent);
    }

    public static void startFullScreenActivity(Context context, int i, POBAdDescriptor pOBAdDescriptor, int i2) throws Exception {
        Intent intent = new Intent();
        intent.putExtra(REQUESTED_ORIENTATION, i);
        intent.putExtra(RENDERER_IDENTIFIER, i2);
        intent.putExtra(ENABLE_BACK_PRESS, false);
        if (!pOBAdDescriptor.isVideo()) {
            intent.putExtra(ALLOW_ORIENTATION_CHANGE, Boolean.FALSE);
        }
        safedk_POBFullScreenActivity_startActivity_9b43eeb3a2c956a47043e4be8e9dab59(context, intent);
    }

    public static void updateBackButtonState(Context context, int i, boolean z) {
        String strName = ACTIONS.POB_BACK_PRESS.name();
        Intent intent = new Intent(strName);
        intent.putExtra(RENDERER_IDENTIFIER, i);
        intent.putExtra(ENABLE_BACK_PRESS, z);
        try {
            sendBroadcast(context, intent);
        } catch (Exception e) {
            POBLog.warn("POBFullScreenActivity", "Unable to update back button state for %s. Error: %s", strName, e.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.F, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.g) {
            POBFullScreenActivityBackPressListener pOBFullScreenActivityBackPressListener = this.e;
            if (pOBFullScreenActivityBackPressListener != null) {
                pOBFullScreenActivityBackPressListener.onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    protected void onBroadcastReceived(Intent intent) {
        String action = intent.getAction();
        if (Objects.equals(action, ACTIONS.POB_CLOSE.name())) {
            finish();
        } else if (Objects.equals(action, ACTIONS.POB_BACK_PRESS.name())) {
            this.g = intent.getBooleanExtra(ENABLE_BACK_PRESS, false);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(REQUESTED_ORIENTATION, POBUtils.getDeviceOrientation(getApplicationContext()));
        boolean booleanExtra = intent.getBooleanExtra(ALLOW_ORIENTATION_CHANGE, true);
        this.g = intent.getBooleanExtra(ENABLE_BACK_PRESS, false);
        int intExtra2 = intent.getIntExtra(RENDERER_IDENTIFIER, 0);
        this.b = intExtra2;
        if (intExtra2 != 0) {
            POBAdViewCacheService.AdViewConfig adViewConfigPopStoredAdView = POBInstanceProvider.getAdViewCacheService().popStoredAdView(Integer.valueOf(this.b));
            if (adViewConfigPopStoredAdView == null) {
                POBLog.error("POBFullScreenActivity", "Unable to retrieve stored ad view config for %s", Integer.valueOf(this.b));
                finish();
                return;
            }
            this.f7927a = (ViewGroup) adViewConfigPopStoredAdView.getAdView();
            this.d = adViewConfigPopStoredAdView.getEventListener();
            this.e = adViewConfigPopStoredAdView.getBackPressListener();
            this.f7927a.setId(R.id.pob_modal_view);
            if (Build.VERSION.SDK_INT >= 30) {
                POBUtils.setSystemFitWindowsForEdgeToEdge(this.f7927a, getWindow());
            }
            setContentView(this.f7927a);
            try {
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
                this.c = localBroadcastManager;
                localBroadcastManager.registerReceiver(this.f, a());
            } catch (Exception e) {
                POBLog.warn("POBFullScreenActivity", "Unable to register broadcast receiver for %s. Error: %s", Integer.valueOf(this.b), e.getMessage());
            }
            POBFullScreenActivityListener pOBFullScreenActivityListener = this.d;
            if (pOBFullScreenActivityListener != null) {
                pOBFullScreenActivityListener.onCreate(this);
            }
        }
        if (booleanExtra) {
            setRequestedOrientation(-1);
        } else {
            a(intExtra);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup = this.f7927a;
        if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f7927a.getParent()).removeView(this.f7927a);
            this.f7927a.removeAllViews();
        }
        super.onDestroy();
        setRequestedOrientation(-1);
        POBFullScreenActivityListener pOBFullScreenActivityListener = this.d;
        if (pOBFullScreenActivityListener != null) {
            pOBFullScreenActivityListener.onDestroy();
        }
        try {
            LocalBroadcastManager localBroadcastManager = this.c;
            if (localBroadcastManager != null) {
                localBroadcastManager.unregisterReceiver(this.f);
            }
        } catch (Exception e) {
            POBLog.warn("POBFullScreenActivity", "Unable to unregister broadcast receiver for %s. Error: %s", Integer.valueOf(this.b), e.getMessage());
        }
    }

    private IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTIONS.POB_CLOSE.name());
        intentFilter.addAction(ACTIONS.POB_BACK_PRESS.name());
        return intentFilter;
    }

    private void a(int i) {
        if (i == 0) {
            setRequestedOrientation(-1);
        } else if (i == 2) {
            setRequestedOrientation(6);
        } else if (i == 1) {
            setRequestedOrientation(7);
        }
    }

    public static void startFullScreenActivity(Context context, boolean z, int i) throws Exception {
        Intent intent = new Intent();
        intent.putExtra(RENDERER_IDENTIFIER, i);
        if (z) {
            intent.putExtra(ENABLE_BACK_PRESS, false);
        } else {
            intent.putExtra(ALLOW_ORIENTATION_CHANGE, Boolean.FALSE);
        }
        safedk_POBFullScreenActivity_startActivity_9b43eeb3a2c956a47043e4be8e9dab59(context, intent);
    }
}
