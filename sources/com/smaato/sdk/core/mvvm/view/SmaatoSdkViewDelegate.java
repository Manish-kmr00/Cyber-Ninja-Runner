package com.smaato.sdk.core.mvvm.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.csm.CsmImageAdContentView;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.imagead.Extension;
import com.smaato.sdk.core.mvvm.model.imagead.ImageAdContentView;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.openmeasurement.VideoProps;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.diinjection.InjectOrNull;
import com.smaato.sdk.core.util.fi.Consumer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SmaatoSdkViewDelegate implements AndroidsInjector.InjectionAllowed {
    protected WeakReference<AdContentView> adContentViewReference = new WeakReference<>(null);

    @Inject
    private AppBackgroundDetector appBackgroundDetector;

    @Inject
    private Logger logger;

    @Inject
    protected RichMediaAdContentViewCreator richMediaAdContentViewCreator;
    protected SmaatoSdkViewModel smaatoSdkViewModel;

    @InjectOrNull
    private VideoAdContentViewCreator videoAdContentViewCreator;
    private ViewVisibilityObserver viewVisibilityObserver;

    public interface VideoActivityLifecycleListener {
        void onActivityPause();

        void onActivityResume();
    }

    public void hideRichMediaAd() {
    }

    protected abstract void onPredrawOfAdContentView(AdContentView adContentView);

    public void onUseCustomClose() {
    }

    public void onVideoClosed() {
    }

    public void onWebViewError() {
    }

    public void setVideoPlayerCloser(Runnable runnable) {
    }

    protected SmaatoSdkViewDelegate(SmaatoSdkViewModel smaatoSdkViewModel) {
        AndroidsInjector.inject(this);
        this.smaatoSdkViewModel = smaatoSdkViewModel;
    }

    protected SmaatoSdkViewDelegate() {
        AndroidsInjector.inject(this);
    }

    public void executeCtaLink(String str) {
        if (str == null) {
            throw new NullPointerException("'url' specified as non-null is null");
        }
        handleUrl(str, true);
    }

    public void showLink(String str) {
        if (str == null) {
            throw new NullPointerException("'url' specified as non-null is null");
        }
        handleUrl(str, false);
    }

    public void onRichMediaWebViewLoaded(WebView webView) {
        AdContentView adContentView = this.adContentViewReference.get();
        if (adContentView == null || adContentView.getViewForOmTracking() != webView) {
            this.logger.error(LogDomain.CORE, "Wrong view for OM tracking: " + webView, new Object[0]);
        }
        this.smaatoSdkViewModel.onRichMediaWebViewLoaded(adContentView);
    }

    public void onRichMediaWebViewExpanded() {
        this.smaatoSdkViewModel.onRichMediaWebViewExpanded();
    }

    public void onRichMediaWebViewUnloaded() {
        this.smaatoSdkViewModel.onRichMediaWebViewUnloaded();
    }

    public void onRichMediaWebViewResized() {
        this.smaatoSdkViewModel.onRichMediaWebViewResized();
    }

    public void registerFriendlyObstruction(View view) {
        if (view == null) {
            throw new NullPointerException("'view' specified as non-null is null");
        }
        this.smaatoSdkViewModel.registerFriendlyObstruction(view);
    }

    public void removeFriendlyObstruction(View view) {
        if (view == null) {
            throw new NullPointerException("'view' specified as non-null is null");
        }
        this.smaatoSdkViewModel.removeFriendlyObstruction(view);
    }

    public void onRichMediaWebViewCollapsed() {
        this.smaatoSdkViewModel.onRichMediaWebViewCollapsed();
    }

    public void reportRichMediaAdViolation(String str, String str2) {
        this.smaatoSdkViewModel.reportRichMediaAdViolation(str, str2);
    }

    public void onUpdateAdView(WebView webView) {
        this.smaatoSdkViewModel.onUpdateAdView(webView);
    }

    public void onRichMediaAdRendererProcessGone() {
        this.smaatoSdkViewModel.onRichMediaAdRendererProcessGone();
    }

    public void destroy() {
        withAdContentView(new Consumer() { // from class: com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((AdContentView) obj).destroy();
            }
        });
        Objects.onNotNull(this.viewVisibilityObserver, new Consumer() { // from class: com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ViewVisibilityObserver) obj).finishObserving();
            }
        });
    }

    protected void setViewModel(SmaatoSdkViewModel smaatoSdkViewModel) {
        if (smaatoSdkViewModel == null) {
            throw new NullPointerException("'smaatoSdkViewModel' specified as non-null is null");
        }
        this.smaatoSdkViewModel = smaatoSdkViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createImageAdContentView(Context context, Bitmap bitmap, int i, int i2, List<Extension> list, ImpressionCountingType impressionCountingType) {
        if (context == null) {
            throw new NullPointerException("'context' specified as non-null is null");
        }
        if (bitmap == null) {
            throw new NullPointerException("'bitmap' specified as non-null is null");
        }
        try {
            prepareAndSaveAdContentView(impressionCountingType, ImageAdContentView.create(context, bitmap, i, i2, new View.OnClickListener() { // from class: com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m5559x7c419d06(view);
                }
            }, list, this.logger), AdType.IMAGE);
        } catch (Exception e) {
            this.smaatoSdkViewModel.onFailedToCreateContentView(e);
        }
    }

    /* JADX INFO: renamed from: lambda$createImageAdContentView$0$com-smaato-sdk-core-mvvm-view-SmaatoSdkViewDelegate, reason: not valid java name */
    /* synthetic */ void m5559x7c419d06(View view) {
        executeCtaLink();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createRichMediaAdContentView(RichMediaAdContentViewCreator richMediaAdContentViewCreator, Context context, String str, int i, int i2, boolean z, ImpressionCountingType impressionCountingType) {
        if (context == null) {
            throw new NullPointerException("'context' specified as non-null is null");
        }
        if (str == null) {
            throw new NullPointerException("'content' specified as non-null is null");
        }
        if (impressionCountingType == null) {
            throw new NullPointerException("'impressionCountingType' specified as non-null is null");
        }
        try {
            prepareAndSaveAdContentView(impressionCountingType, richMediaAdContentViewCreator.createAdContentView(context, str, i, i2, z, impressionCountingType, this), str.contains("VAST>") ? AdType.VIDEO : AdType.RICH_MEDIA);
        } catch (Exception e) {
            this.smaatoSdkViewModel.onFailedToCreateContentView(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createVideoAdContentView(Object obj, boolean z, boolean z2, final ImpressionCountingType impressionCountingType, final Runnable runnable, Consumer<VideoActivityLifecycleListener> consumer) {
        if (obj == null) {
            throw new NullPointerException("'vastObject' specified as non-null is null");
        }
        if (impressionCountingType == null) {
            throw new NullPointerException("'impressionCountingType' specified as non-null is null");
        }
        if (runnable == null) {
            throw new NullPointerException("'onAdContentViewCreated' specified as non-null is null");
        }
        try {
            VideoAdContentViewCreator videoAdContentViewCreator = this.videoAdContentViewCreator;
            if (videoAdContentViewCreator != null) {
                videoAdContentViewCreator.createAdContentView(obj, z, z2, impressionCountingType, this, new Consumer() { // from class: com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate$$ExternalSyntheticLambda4
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj2) {
                        this.f$0.m5560xfee28f67(impressionCountingType, runnable, (AdContentView) obj2);
                    }
                }, consumer);
            } else {
                this.smaatoSdkViewModel.onFailedToCreateContentView(new Exception());
            }
        } catch (Exception e) {
            this.smaatoSdkViewModel.onFailedToCreateContentView(e);
        }
    }

    /* JADX INFO: renamed from: lambda$createVideoAdContentView$1$com-smaato-sdk-core-mvvm-view-SmaatoSdkViewDelegate, reason: not valid java name */
    /* synthetic */ void m5560xfee28f67(ImpressionCountingType impressionCountingType, Runnable runnable, AdContentView adContentView) {
        prepareAndSaveAdContentView(impressionCountingType, adContentView, AdType.VIDEO);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createCsmImageAdContentView(View view, ImpressionCountingType impressionCountingType) {
        if (view == null) {
            throw new NullPointerException("'csmView' specified as non-null is null");
        }
        if (impressionCountingType == null) {
            throw new NullPointerException("'impressionCountingType' specified as non-null is null");
        }
        try {
            prepareAndSaveAdContentView(impressionCountingType, new CsmImageAdContentView(view.getContext(), view), AdType.IMAGE);
        } catch (Exception e) {
            this.smaatoSdkViewModel.onFailedToCreateContentView(e);
        }
    }

    protected void withAdContentView(Consumer<AdContentView> consumer) {
        Objects.onNotNull(this.adContentViewReference.get(), consumer);
    }

    public void onVideoViewAttached(boolean z, long j) {
        VideoProps videoPropsBuildForNonSkippableVideo;
        if (z) {
            videoPropsBuildForNonSkippableVideo = VideoProps.buildForSkippableVideo(j * 1000);
        } else {
            videoPropsBuildForNonSkippableVideo = VideoProps.buildForNonSkippableVideo();
        }
        this.smaatoSdkViewModel.onVideoTrackLoaded(videoPropsBuildForNonSkippableVideo);
    }

    public void onVideoViewDetached() {
        this.smaatoSdkViewModel.stopOMVideoTracking();
    }

    public void onVideoClicked() {
        this.smaatoSdkViewModel.onVideoClicked();
    }

    public void onVideoStarted(float f, float f2, Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("'onVideoImpressed' specified as non-null is null");
        }
        this.smaatoSdkViewModel.onVideoStarted(f, f2, runnable);
    }

    public void onVideoFirstQuartileReached() {
        this.smaatoSdkViewModel.onVideoFirstQuartileReached();
    }

    public void onVideoMidpointReached() {
        this.smaatoSdkViewModel.onVideoMidpointReached();
    }

    public void onVideoThirdQuartileReached() {
        this.smaatoSdkViewModel.onVideoThirdQuartileReached();
    }

    public void onVideoCompleted(boolean z) {
        this.smaatoSdkViewModel.onVideoCompleted();
    }

    public void onVideoPaused() {
        this.smaatoSdkViewModel.onVideoPaused();
    }

    public void onVideoResumed() {
        this.smaatoSdkViewModel.onVideoResumed();
    }

    public void onMuteClicked() {
        this.smaatoSdkViewModel.onMuteClicked();
    }

    public void onUnmuteClicked() {
        this.smaatoSdkViewModel.onUnmuteClicked();
    }

    public void onVideoSkipped() {
        this.smaatoSdkViewModel.onVideoSkipped();
    }

    public void onVideoPlayerBuildError(SomaException somaException) {
        this.smaatoSdkViewModel.onVideoPlayerBuildError(somaException);
    }

    public String onWrongVastObjectCreated(Object obj) {
        String str = "Wrong VAST object created: " + obj;
        this.logger.error(LogDomain.CORE, str, new Object[0]);
        return str;
    }

    public void onCompanionShown() {
        this.smaatoSdkViewModel.onCompanionAdImpressed();
    }

    public void onCompanionAdClicked() {
        this.smaatoSdkViewModel.onCompanionAdClicked();
    }

    private void prepareAndSaveAdContentView(ImpressionCountingType impressionCountingType, AdContentView adContentView, AdType adType) {
        this.adContentViewReference = new WeakReference<>(adContentView);
        this.smaatoSdkViewModel.onAdContentViewCreated(adContentView, adType);
        adContentView.setVisibility(4);
        setPreDrawListener(adContentView);
        createVisibilityObserver(adContentView.getViewForVisibilityTracking(), impressionCountingType, adType).startObserving();
        adContentView.startShowingView();
    }

    private void setPreDrawListener(final AdContentView adContentView) {
        adContentView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                adContentView.getViewTreeObserver().removeOnPreDrawListener(this);
                SmaatoSdkViewDelegate.this.onPredrawOfAdContentView(adContentView);
                adContentView.setVisibility(0);
                adContentView.setWillNotDraw(false);
                return true;
            }
        });
    }

    private ViewVisibilityObserver createVisibilityObserver(View view, ImpressionCountingType impressionCountingType, AdType adType) {
        ViewVisibilityObserver viewVisibilityObserver = new ViewVisibilityObserver(view, impressionCountingType, adType, this.smaatoSdkViewModel);
        this.viewVisibilityObserver = viewVisibilityObserver;
        return viewVisibilityObserver;
    }

    private void executeCtaLink() {
        handleUrl(null, true);
    }

    private void handleUrl(final String str, final boolean z) {
        if (!this.appBackgroundDetector.isAppInBackground()) {
            withAdContentView(new Consumer() { // from class: com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5562xffea22fa(z, str, (AdContentView) obj);
                }
            });
        } else if (str == null) {
            this.logger.info(LogDomain.AD, "skipping click event, because app is in background", new Object[0]);
        } else {
            this.logger.info(LogDomain.AD, "skipping url handling, because app is in background, url = " + str, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: lambda$handleUrl$3$com-smaato-sdk-core-mvvm-view-SmaatoSdkViewDelegate, reason: not valid java name */
    /* synthetic */ void m5562xffea22fa(boolean z, String str, final AdContentView adContentView) {
        adContentView.showProgressIndicator(true);
        Consumer<Boolean> consumer = new Consumer() { // from class: com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5561x72af7179(adContentView, (Boolean) obj);
            }
        };
        if (z) {
            this.smaatoSdkViewModel.executeCtaLink(str, consumer);
        } else {
            this.smaatoSdkViewModel.handleLink(str, consumer);
        }
    }

    /* JADX INFO: renamed from: lambda$handleUrl$2$com-smaato-sdk-core-mvvm-view-SmaatoSdkViewDelegate, reason: not valid java name */
    /* synthetic */ void m5561x72af7179(AdContentView adContentView, Boolean bool) {
        adContentView.showProgressIndicator(false);
        if (bool.booleanValue()) {
            return;
        }
        this.logger.error(LogDomain.BANNER, "The url seems to be invalid", new Object[0]);
    }

    public String getBundleId() {
        return this.smaatoSdkViewModel.getBundleId();
    }
}
