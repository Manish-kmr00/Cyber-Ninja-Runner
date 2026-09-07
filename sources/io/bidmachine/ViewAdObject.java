package io.bidmachine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.bidmachine.AdRequest;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.internal.utils.visibility.VisibilityTrackerHolder;
import io.bidmachine.internal.utils.visibility.VisibilityTrackerListener;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.unified.UnifiedViewAd;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ViewHelper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewAdObject<AdRequestType extends AdRequest<AdRequestType, ?, UnifiedAdRequestParamsType>, UnifiedAdType extends UnifiedViewAd<UnifiedBannerAdCallback, UnifiedAdRequestParamsType>, UnifiedAdRequestParamsType extends UnifiedAdRequestParams> extends AdObjectImpl<AdRequestType, AdObjectParams, UnifiedAdType, UnifiedBannerAdCallback, UnifiedAdRequestParamsType> {
    private View adView;
    private int height;
    private MeasureMode heightMeasureMode;
    private final VisibilityTrackerHolder visibilityTrackerHolder;
    private int width;
    private MeasureMode widthMeasureMode;

    public ViewAdObject(ContextProvider contextProvider, AdProcessCallback adProcessCallback, AdRequestType adrequesttype, AdObjectParams adObjectParams, UnifiedAdType unifiedadtype) {
        super(contextProvider, adProcessCallback, adrequesttype, adObjectParams, unifiedadtype);
        this.widthMeasureMode = MeasureMode.Direct;
        this.heightMeasureMode = MeasureMode.Direct;
        this.visibilityTrackerHolder = new VisibilityTrackerHolder();
    }

    @Override // io.bidmachine.models.AdObject
    public UnifiedBannerAdCallback createUnifiedCallback(AdProcessCallback adProcessCallback) {
        return new UnifiedViewAdCallbackImpl(this, adProcessCallback);
    }

    void show(ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        if (viewGroup == null) {
            getUnifiedAdCallback().onAdShowFailed(BMError.notFound("Target container"));
            return;
        }
        View view = this.adView;
        if (view == null) {
            getUnifiedAdCallback().onAdShowFailed(BMError.internal("Ad view is null"));
            return;
        }
        if ((getWidthMeasureMode() == MeasureMode.Direct && getWidth() == 0) || (getHeightMeasureMode() == MeasureMode.Direct && getHeight() == 0)) {
            getUnifiedAdCallback().onAdShowFailed(BMError.incorrectContent("Width or height are not provided"));
            return;
        }
        Context context = viewGroup.getContext();
        if (viewGroup instanceof FrameLayout) {
            layoutParams = new FrameLayout.LayoutParams(getScaledWidth(context), getScaledHeight(context), 17);
        } else {
            layoutParams = new ViewGroup.LayoutParams(getScaledWidth(context), getScaledHeight(context));
        }
        getProcessCallback().processStartVisibilityTracker();
        this.visibilityTrackerHolder.startTracking(view, getParams().getVisibilityParams(), new VisibilityTrackerListener() { // from class: io.bidmachine.ViewAdObject.1
            @Override // io.bidmachine.internal.utils.visibility.VisibilityTrackerListener
            public boolean onViewShown() {
                return ViewAdObject.this.getProcessCallback().processVisibilityTrackerShown();
            }

            @Override // io.bidmachine.internal.utils.visibility.VisibilityTrackerListener
            public void onViewTrackingFinished() {
                ViewAdObject.this.getProcessCallback().processVisibilityTrackerImpression();
            }
        });
        ViewHelper.safeAddSingleView(viewGroup, view, layoutParams);
        getProcessCallback().processFillAd();
        try {
            getUnifiedAd().prepareToShow();
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onImpression() {
        super.onImpression();
        this.visibilityTrackerHolder.stopTracking();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void hide() {
        super.hide();
        this.visibilityTrackerHolder.stopTracking();
        View view = this.adView;
        if (view != null) {
            ViewHelper.removeViewFromParent(view);
        }
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onDestroy() {
        hide();
        super.onDestroy();
    }

    public MeasureMode getWidthMeasureMode() {
        return this.widthMeasureMode;
    }

    public void setWidthMeasureMode(MeasureMode measureMode) {
        this.widthMeasureMode = measureMode;
    }

    public MeasureMode getHeightMeasureMode() {
        return this.heightMeasureMode;
    }

    public void setHeightMeasureMode(MeasureMode measureMode) {
        this.heightMeasureMode = measureMode;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    private int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    private int getHeight() {
        return this.height;
    }

    private int getScaledWidth(Context context) {
        return this.widthMeasureMode.getSize(context, getWidth());
    }

    private int getScaledHeight(Context context) {
        return this.heightMeasureMode.getSize(context, getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdView(View view) {
        hide();
        this.adView = view;
    }

    /* JADX INFO: renamed from: io.bidmachine.ViewAdObject$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$ViewAdObject$MeasureMode;

        static {
            int[] iArr = new int[MeasureMode.values().length];
            $SwitchMap$io$bidmachine$ViewAdObject$MeasureMode = iArr;
            try {
                iArr[MeasureMode.Direct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$ViewAdObject$MeasureMode[MeasureMode.Wrap.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum MeasureMode {
        Match,
        Wrap,
        Direct;

        int getSize(Context context, int i) {
            int i2 = AnonymousClass2.$SwitchMap$io$bidmachine$ViewAdObject$MeasureMode[ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? -1 : -2;
            }
            return Math.round(i * Utils.getScreenDensity(context));
        }
    }

    private static final class UnifiedViewAdCallbackImpl extends AdObjectImpl.BaseUnifiedAdCallback implements UnifiedBannerAdCallback {
        private final WeakReference<ViewAdObject<?, ?, ?>> weakAdObject;

        UnifiedViewAdCallbackImpl(ViewAdObject<?, ?, ?> viewAdObject, AdProcessCallback adProcessCallback) {
            super(adProcessCallback);
            this.weakAdObject = new WeakReference<>(viewAdObject);
        }

        @Override // io.bidmachine.unified.UnifiedBannerAdCallback
        public void onAdLoaded(View view) {
            ViewAdObject<?, ?, ?> viewAdObject = this.weakAdObject.get();
            if (viewAdObject != null) {
                viewAdObject.setAdView(view);
                this.processCallback.processLoadSuccess();
            } else {
                this.processCallback.processLoadFail(BMError.internal("ViewAdObject is null"));
            }
        }
    }
}
