package com.amazon.aps.ads.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.amazon.aps.ads.ApsAdView;
import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.ads.R;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.ads.util.ApsMraidCloseButtonListener;
import com.amazon.aps.ads.util.ApsMraidHandler;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.DTBAdMRAIDController;
import com.amazon.device.ads.DTBAdUtil;
import com.amazon.device.ads.DTBMRAIDCloseButtonListener;
import com.amazon.device.ads.DtbOmSdkSessionManager;
import com.iab.omid.library.amazon.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApsInterstitialActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/amazon/aps/ads/activity/ApsInterstitialActivity;", "Landroid/app/Activity;", "Lcom/amazon/aps/ads/util/ApsMraidCloseButtonListener;", "()V", "TAG", "", "apsAdViewRef", "Ljava/lang/ref/WeakReference;", "Lcom/amazon/aps/ads/ApsAdView;", "closeIndicatorRegion", "Landroid/widget/LinearLayout;", "getCloseIndicatorRegion", "()Landroid/widget/LinearLayout;", "setCloseIndicatorRegion", "(Landroid/widget/LinearLayout;)V", "imageParams", "Landroid/widget/LinearLayout$LayoutParams;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "attachWebView", "", "clean", "cleanAndFinishAdView", "getUseCustomClose", "", "handleApsAdView", "apsAdView", "initActivity", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "prepareCloseButtonRegion", "useCustomButtonUpdated", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsInterstitialActivity extends Activity implements ApsMraidCloseButtonListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<ApsAdView> adViewRefPassed;
    private final String TAG = "ApsInterstitialActivity";
    private WeakReference<ApsAdView> apsAdViewRef;
    private LinearLayout closeIndicatorRegion;
    private final LinearLayout.LayoutParams imageParams;

    /* JADX INFO: renamed from: imageView$delegate, reason: from kotlin metadata */
    private final Lazy imageView;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.A, me);
        return super.dispatchTouchEvent(me);
    }

    public ApsInterstitialActivity() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DTBAdUtil.sizeToDevicePixels(24), DTBAdUtil.sizeToDevicePixels(24));
        layoutParams.setMargins(DTBAdUtil.sizeToDevicePixels(14), DTBAdUtil.sizeToDevicePixels(14), 0, 0);
        this.imageParams = layoutParams;
        this.imageView = LazyKt.lazy(new Function0<ImageView>() { // from class: com.amazon.aps.ads.activity.ApsInterstitialActivity$imageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0);
                imageView.setImageDrawable(AppCompatResources.getDrawable(this.this$0, R.drawable.mraid_close));
                return imageView;
            }
        });
    }

    private final ImageView getImageView() {
        return (ImageView) this.imageView.getValue();
    }

    public final void setCloseIndicatorRegion(LinearLayout linearLayout) {
        this.closeIndicatorRegion = linearLayout;
    }

    public final LinearLayout getCloseIndicatorRegion() {
        return (LinearLayout) findViewById(R.id.mraid_close_indicator);
    }

    private final void handleApsAdView(ApsAdView apsAdView) {
        if (apsAdView == null) {
            return;
        }
        try {
            ApsLog.d(this.TAG, "Received the ApsAdView");
            this.apsAdViewRef = new WeakReference<>(apsAdView);
            adViewRefPassed = null;
            attachWebView();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error rendering the ApsInterstitial activity ApsAdView", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            initActivity();
            WeakReference<ApsAdView> weakReference = adViewRefPassed;
            if (weakReference != null) {
                handleApsAdView(weakReference == null ? null : weakReference.get());
            } else {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to create ApsInterstitialActivity as the ad view is null");
                finish();
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to create ApsInterstitialActivity", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.inter_container);
            if (relativeLayout != null) {
                WeakReference<ApsAdView> weakReference = this.apsAdViewRef;
                relativeLayout.removeView(weakReference == null ? null : weakReference.get());
            }
            WeakReference<ApsAdView> weakReference2 = this.apsAdViewRef;
            if (weakReference2 != null) {
                ApsAdView apsAdView = weakReference2.get();
                if (apsAdView != null) {
                    apsAdView.evaluateJavascript(DTBAdMRAIDController.MRAID_CLOSE, null);
                }
                clean();
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to remove DTBAdView on Activity Destroy", e);
        }
        super.onDestroy();
    }

    private final void attachWebView() {
        ApsLog.d(this.TAG, "Attaching the ApsAdView");
        WeakReference<ApsAdView> weakReference = this.apsAdViewRef;
        ApsAdView apsAdView = weakReference == null ? null : weakReference.get();
        if (apsAdView != null) {
            apsAdView.setScrollEnabled(false);
            ViewParent parent = apsAdView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(apsAdView);
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.inter_container);
        if (relativeLayout != null) {
            relativeLayout.addView(apsAdView, -1, -1);
        }
        prepareCloseButtonRegion();
    }

    private final void prepareCloseButtonRegion() {
        DTBAdMRAIDController mraidHandler;
        LinearLayout closeIndicatorRegion = getCloseIndicatorRegion();
        if (closeIndicatorRegion == null) {
            return;
        }
        WeakReference<ApsAdView> weakReference = this.apsAdViewRef;
        ApsAdView apsAdView = weakReference == null ? null : weakReference.get();
        if (apsAdView != null && (mraidHandler = apsAdView.getMraidHandler()) != null) {
            mraidHandler.setCustomButtonListener(new DTBMRAIDCloseButtonListener() { // from class: com.amazon.aps.ads.activity.ApsInterstitialActivity$$ExternalSyntheticLambda0
                @Override // com.amazon.device.ads.DTBMRAIDCloseButtonListener
                public final void useCustomButtonUpdated() {
                    ApsInterstitialActivity.m4359prepareCloseButtonRegion$lambda10$lambda8$lambda6(this.f$0);
                }
            });
            DtbOmSdkSessionManager omSdkManager = apsAdView.getOmSdkManager();
            if (omSdkManager != null) {
                omSdkManager.addFriendlyObstruction(findViewById(R.id.mraid_close_indicator), FriendlyObstructionPurpose.CLOSE_AD);
            }
        }
        closeIndicatorRegion.setVisibility(getUseCustomClose() ? 4 : 0);
        closeIndicatorRegion.bringToFront();
        closeIndicatorRegion.setBackgroundColor(0);
        closeIndicatorRegion.setOrientation(1);
        closeIndicatorRegion.addView(getImageView(), this.imageParams);
        closeIndicatorRegion.setOnTouchListener(new View.OnTouchListener() { // from class: com.amazon.aps.ads.activity.ApsInterstitialActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ApsInterstitialActivity.m4360prepareCloseButtonRegion$lambda10$lambda9(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareCloseButtonRegion$lambda-10$lambda-8$lambda-6, reason: not valid java name */
    public static final void m4359prepareCloseButtonRegion$lambda10$lambda8$lambda6(ApsInterstitialActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.useCustomButtonUpdated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareCloseButtonRegion$lambda-10$lambda-9, reason: not valid java name */
    public static final boolean m4360prepareCloseButtonRegion$lambda10$lambda9(ApsInterstitialActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this$0.cleanAndFinishAdView();
        return true;
    }

    private final boolean getUseCustomClose() {
        DTBAdMRAIDController mraidHandler;
        try {
            WeakReference<ApsAdView> weakReference = this.apsAdViewRef;
            ApsAdView apsAdView = weakReference == null ? null : weakReference.get();
            if (apsAdView != null && (mraidHandler = apsAdView.getMraidHandler()) != null) {
                return mraidHandler.isUseCustomClose();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            ApsAdExtensionsKt.e(this, Intrinsics.stringPlus("Error in using the flag isUseCustomClose:", Unit.INSTANCE));
            return false;
        }
    }

    private final void initActivity() {
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.aps_interstitial_activity);
            ApsLog.d(this.TAG, "Init window completed");
        } catch (RuntimeException e) {
            ApsLog.e(this.TAG, Intrinsics.stringPlus("Error in calling the initActivity: ", e));
        }
    }

    private final void cleanAndFinishAdView() {
        WeakReference<ApsAdView> weakReference = this.apsAdViewRef;
        ApsAdView apsAdView = weakReference == null ? null : weakReference.get();
        if (apsAdView != null && apsAdView.getMraidHandler() != null) {
            apsAdView.evaluateJavascript(ApsMraidHandler.INSTANCE.getMRAID_CLOSE(), null);
        }
        clean();
        finish();
    }

    private final void clean() {
        WeakReference<ApsAdView> weakReference = this.apsAdViewRef;
        if (weakReference == null) {
            return;
        }
        weakReference.clear();
        this.apsAdViewRef = null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if (getUseCustomClose()) {
                return;
            }
            cleanAndFinishAdView();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute onBackPressed method", e);
        }
    }

    @Override // com.amazon.aps.ads.util.ApsMraidCloseButtonListener
    public void useCustomButtonUpdated() {
        WeakReference<ApsAdView> weakReference;
        ApsAdView apsAdView;
        DTBAdMRAIDController controller;
        DtbOmSdkSessionManager dtbOmSdkSessionManager;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.ads.activity.ApsInterstitialActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ApsInterstitialActivity.m4361useCustomButtonUpdated$lambda15(this.f$0);
            }
        });
        try {
            if (!getUseCustomClose() && (weakReference = this.apsAdViewRef) != null && (apsAdView = weakReference.get()) != null && (controller = apsAdView.getController()) != null && (dtbOmSdkSessionManager = controller.getDtbOmSdkSessionManager()) != null) {
                dtbOmSdkSessionManager.addFriendlyObstruction(findViewById(R.id.mraid_close_indicator), FriendlyObstructionPurpose.CLOSE_AD);
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, " OMSDK : Unable to add close icon as friendly obstruction on geometry change", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: useCustomButtonUpdated$lambda-15, reason: not valid java name */
    public static final void m4361useCustomButtonUpdated$lambda15(ApsInterstitialActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.findViewById(R.id.mraid_close_indicator).setVisibility(this$0.getUseCustomClose() ? 4 : 0);
    }

    /* JADX INFO: compiled from: ApsInterstitialActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/amazon/aps/ads/activity/ApsInterstitialActivity$Companion;", "", "()V", "adViewRefPassed", "Ljava/lang/ref/WeakReference;", "Lcom/amazon/aps/ads/ApsAdView;", "getAdViewRefPassed", "()Ljava/lang/ref/WeakReference;", "setAdViewRefPassed", "(Ljava/lang/ref/WeakReference;)V", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WeakReference<ApsAdView> getAdViewRefPassed() {
            return ApsInterstitialActivity.adViewRefPassed;
        }

        public final void setAdViewRefPassed(WeakReference<ApsAdView> weakReference) {
            ApsInterstitialActivity.adViewRefPassed = weakReference;
        }
    }
}
