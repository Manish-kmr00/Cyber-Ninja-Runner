package io.bidmachine.iab.mraid;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.rendering.model.PrivacySheetParams;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes12.dex */
public class MraidInterstitial {
    private static final AtomicInteger j = new AtomicInteger(0);
    static final /* synthetic */ boolean k = true;
    MraidView c;
    private MraidInterstitialListener d;
    public final int id = j.getAndIncrement();
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f12198a = new AtomicBoolean(false);
    final MraidViewListener b = new b();

    public class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MraidView.Builder f12199a = new MraidView.Builder(MraidPlacementType.INTERSTITIAL);

        public Builder() {
        }

        public MraidInterstitial build(Context context) {
            this.f12199a.setListener(MraidInterstitial.this.b);
            MraidInterstitial.this.c = this.f12199a.build(context);
            return MraidInterstitial.this;
        }

        public Builder forceUseNativeCloseButton(boolean forceUseNativeCloseButton) {
            this.f12199a.forceUseNativeCloseButton(forceUseNativeCloseButton);
            return this;
        }

        public Builder setAdMeasurer(MraidAdMeasurer mraidAdMeasurer) {
            this.f12199a.setAdMeasurer(mraidAdMeasurer);
            return this;
        }

        public Builder setAllowedNativeFeatures(String[] allowedNativeFeatures) {
            this.f12199a.setAllowedNativeFeatures(allowedNativeFeatures);
            return this;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.f12199a.setBaseUrl(baseUrl);
            return this;
        }

        public Builder setCacheControl(CacheControl cacheControl) {
            this.f12199a.setCacheControl(cacheControl);
            return this;
        }

        public Builder setCloseStyle(IabElementStyle closeStyle) {
            this.f12199a.setCloseStyle(closeStyle);
            return this;
        }

        public Builder setCloseTime(float closeTime) {
            this.f12199a.setCloseTimeSec(closeTime);
            return this;
        }

        public Builder setCountDownStyle(IabElementStyle countDownStyle) {
            this.f12199a.setCountDownStyle(countDownStyle);
            return this;
        }

        public Builder setDurationSec(float durationSec) {
            this.f12199a.setDurationSec(durationSec);
            return this;
        }

        public Builder setIsTag(boolean isTag) {
            this.f12199a.setIsTag(isTag);
            return this;
        }

        public Builder setListener(MraidInterstitialListener listener) {
            MraidInterstitial.this.d = listener;
            return this;
        }

        public Builder setLoadingStyle(IabElementStyle loadingStyle) {
            this.f12199a.setLoadingStyle(loadingStyle);
            return this;
        }

        public Builder setPageFinishedScript(String pageFinishedScript) {
            this.f12199a.setPageFinishedScript(pageFinishedScript);
            return this;
        }

        public Builder setPlaceholderTimeoutSec(float placeholderTimeoutSec) {
            this.f12199a.setPlaceholderTimeoutSec(placeholderTimeoutSec);
            return this;
        }

        public Builder setProductLink(String productLink) {
            this.f12199a.setProductLink(productLink);
            return this;
        }

        public Builder setProgressStyle(IabElementStyle progressStyle) {
            this.f12199a.setProgressStyle(progressStyle);
            return this;
        }

        public Builder setR1(boolean r1) {
            this.f12199a.setR1(r1);
            return this;
        }

        public Builder setR2(boolean r2) {
            this.f12199a.setR2(r2);
            return this;
        }
    }

    private class b implements MraidViewListener {
        private b() {
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onCalendarEvent(MraidView mraidView, String str, IabClickCallback iabClickCallback) {
            MraidLog.d("MraidInterstitial", "ViewListener - onCalendarEvent (%s)", str);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onCalendarEvent(MraidInterstitial.this, str, iabClickCallback);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onClose(MraidView mraidView) {
            MraidLog.d("MraidInterstitial", "ViewListener - onClose", new Object[0]);
            MraidInterstitial.this.a();
            MraidInterstitial.this.b();
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onExpand(MraidView mraidView) {
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onExpired(MraidView mraidView, IabError iabError) {
            MraidLog.d("MraidInterstitial", "ViewListener - onExpired (%s)", iabError);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onExpired(MraidInterstitial.this, iabError);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onLoadFailed(MraidView mraidView, IabError iabError) {
            MraidLog.d("MraidInterstitial", "ViewListener - onLoadFailed (%s)", iabError);
            MraidInterstitial.this.a();
            MraidInterstitial.this.a(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onLoaded(MraidView mraidView) {
            MraidLog.d("MraidInterstitial", "ViewListener - onLoaded", new Object[0]);
            MraidInterstitial.this.c();
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onOpenPrivacySheet(MraidView mraidView, PrivacySheetParams privacySheetParams) {
            MraidLog.d("MraidInterstitial", "ViewListener - onOpenPrivacySheet (%s)", privacySheetParams.toString());
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onOpenPrivacySheet(MraidInterstitial.this, privacySheetParams);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onOpenUrl(MraidView mraidView, String str, IabClickCallback iabClickCallback) {
            MraidLog.d("MraidInterstitial", "ViewListener - onOpenBrowser (%s)", str);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onOpenUrl(MraidInterstitial.this, str, iabClickCallback);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onPlayVideo(MraidView mraidView, String str) {
            MraidLog.d("MraidInterstitial", "ViewListener - onPlayVideo (%s)", str);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onPlayVideo(MraidInterstitial.this, str);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onShowFailed(MraidView mraidView, IabError iabError) {
            MraidLog.d("MraidInterstitial", "ViewListener - onShowFailed (%s)", iabError);
            MraidInterstitial.this.a();
            MraidInterstitial.this.b(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onShown(MraidView mraidView) {
            MraidLog.d("MraidInterstitial", "ViewListener - onShown", new Object[0]);
            MraidInterstitial.this.d();
        }

        @Override // io.bidmachine.iab.mraid.MraidViewListener
        public void onStorePicture(MraidView mraidView, String str, IabClickCallback iabClickCallback) {
            MraidLog.d("MraidInterstitial", "ViewListener - onCalendarEvent (%s)", str);
            if (MraidInterstitial.this.d != null) {
                MraidInterstitial.this.d.onStorePicture(MraidInterstitial.this, str, iabClickCallback);
            }
        }
    }

    private MraidInterstitial() {
    }

    public static Builder newBuilder() {
        return new MraidInterstitial().new Builder();
    }

    void c() {
        this.e = true;
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onLoaded(this);
        }
    }

    public boolean canBeClosed() {
        MraidView mraidView = this.c;
        return mraidView == null || mraidView.canBeClosed() || isReceivedError();
    }

    void d() {
        this.f12198a.set(true);
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onShown(this);
        }
    }

    public void destroy() {
        MraidLog.d("MraidInterstitial", "destroy", new Object[0]);
        this.e = false;
        this.d = null;
        MraidView mraidView = this.c;
        if (mraidView != null) {
            mraidView.destroy();
            this.c = null;
        }
    }

    public void dispatchClose() {
        if (this.c == null || !canBeClosed()) {
            return;
        }
        this.c.f();
    }

    public boolean isClosed() {
        return this.f;
    }

    public boolean isReady() {
        return this.e && this.c != null;
    }

    public boolean isReceivedError() {
        return this.g;
    }

    public boolean isShown() {
        return this.f12198a.get();
    }

    public void load(String data) {
        MraidView mraidView = this.c;
        if (mraidView == null) {
            throw new IllegalStateException("MraidView not created (mraidView == null)");
        }
        mraidView.load(data);
    }

    public Context peekContext() {
        MraidView mraidView = this.c;
        if (mraidView == null) {
            return null;
        }
        return mraidView.peekContext();
    }

    public void show(Context context, MraidType mraidType) {
        MraidActivity.show(context, this, mraidType);
    }

    public void showInView(ViewGroup parent, boolean destroyOnClose) {
        a(null, parent, false, destroyOnClose);
    }

    void b() {
        if (isClosed()) {
            return;
        }
        this.f = true;
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onClose(this);
        }
        if (this.h) {
            destroy();
        }
    }

    void c(IabError iabError) {
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onShowFailed(this, iabError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        MraidView mraidView;
        Activity activityPeekActivity;
        if (!this.i || (mraidView = this.c) == null || (activityPeekActivity = mraidView.peekActivity()) == null) {
            return;
        }
        Utils.finishActivityWithoutAnimation(activityPeekActivity);
    }

    void b(IabError iabError) {
        this.e = false;
        this.g = true;
        c(iabError);
    }

    void a(IabError iabError) {
        this.e = false;
        this.g = true;
        MraidInterstitialListener mraidInterstitialListener = this.d;
        if (mraidInterstitialListener != null) {
            mraidInterstitialListener.onLoadFailed(this, iabError);
        }
    }

    void a(Activity activity, boolean z) {
        a(activity, (ViewGroup) activity.findViewById(R.id.content), true, z);
    }

    void a(Activity activity, ViewGroup viewGroup, boolean z, boolean z2) {
        if (!isReady()) {
            if (activity != null && z) {
                Utils.finishActivityWithoutAnimation(activity);
            }
            c(IabError.incorrectState("Interstitial is not ready"));
            MraidLog.w("MraidInterstitial", "Show failed: interstitial is not ready", new Object[0]);
            return;
        }
        if (!k && this.c == null) {
            throw new AssertionError();
        }
        this.h = z2;
        this.i = z;
        Utils.removeFromParent(this.c);
        viewGroup.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
        this.c.show(activity);
    }
}
