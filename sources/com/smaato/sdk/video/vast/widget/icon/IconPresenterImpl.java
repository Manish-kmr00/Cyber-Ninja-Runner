package com.smaato.sdk.video.vast.widget.icon;

import android.os.Handler;
import android.os.SystemClock;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.utils.AnimationHelper;
import com.smaato.sdk.video.vast.browser.VastWebComponentSecurityPolicy;
import com.smaato.sdk.video.vast.model.IconClicks;
import com.smaato.sdk.video.vast.model.VastIconScenario;
import com.smaato.sdk.video.vast.widget.element.VastElementErrorCodeStrategy;
import com.smaato.sdk.video.vast.widget.element.VastElementPresentationManager;
import com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl;
import com.smaato.sdk.video.vast.widget.element.VastElementView;

/* JADX INFO: loaded from: classes12.dex */
class IconPresenterImpl extends VastElementPresenterImpl {
    private final AnimationHelper animationHelper;
    private boolean delayHandlerScheduled;
    private final VastIconScenario iconScenario;
    private final Handler showAfterDelayHandler;
    private long startedLoadingAtMillis;

    IconPresenterImpl(Logger logger, VastElementPresentationManager vastElementPresentationManager, VastWebComponentSecurityPolicy vastWebComponentSecurityPolicy, VastElementErrorCodeStrategy vastElementErrorCodeStrategy, VastIconScenario vastIconScenario, AnimationHelper animationHelper, long j) {
        super(logger, vastElementPresentationManager, vastWebComponentSecurityPolicy, vastElementErrorCodeStrategy);
        this.showAfterDelayHandler = new Handler();
        this.delayHandlerScheduled = false;
        this.iconScenario = (VastIconScenario) Objects.requireNonNull(vastIconScenario);
        this.animationHelper = (AnimationHelper) Objects.requireNonNull(animationHelper);
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl, com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onContentStartedToLoad() {
        this.startedLoadingAtMillis = SystemClock.uptimeMillis();
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl, com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onClicked(String str) {
        IconClicks iconClicks = this.iconScenario.iconClicks;
        super.onClicked(iconClicks == null ? null : iconClicks.iconClickThrough);
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl, com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onContentLoaded() {
        super.onContentLoaded();
        showAfterDelay(Math.max(this.iconScenario.offset - (SystemClock.uptimeMillis() - this.startedLoadingAtMillis), 0L));
    }

    private void showAfterDelay(long j) {
        Runnable runnable = new Runnable() { // from class: com.smaato.sdk.video.vast.widget.icon.IconPresenterImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5770x793868bd();
            }
        };
        Threads.ensureHandlerThread(this.showAfterDelayHandler);
        if (this.delayHandlerScheduled) {
            return;
        }
        this.delayHandlerScheduled = true;
        this.showAfterDelayHandler.postDelayed(runnable, j);
    }

    /* JADX INFO: renamed from: lambda$showAfterDelay$0$com-smaato-sdk-video-vast-widget-icon-IconPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5770x793868bd() {
        this.delayHandlerScheduled = false;
        VastElementView view = getView();
        final AnimationHelper animationHelper = this.animationHelper;
        java.util.Objects.requireNonNull(animationHelper);
        Objects.onNotNull(view, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.icon.IconPresenterImpl$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                animationHelper.showWithAnim((VastElementView) obj);
            }
        });
    }
}
