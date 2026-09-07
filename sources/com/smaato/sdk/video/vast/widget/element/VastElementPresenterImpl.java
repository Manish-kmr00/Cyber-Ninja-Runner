package com.smaato.sdk.video.vast.widget.element;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.browser.VastWebComponentSecurityPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public class VastElementPresenterImpl implements VastElementPresenter {
    private final VastElementErrorCodeStrategy errorCodeStrategy;
    private VastElementPresenter.Listener listener;
    private final Logger logger;
    private final VastElementPresentationManager presentationManager;
    private final VastWebComponentSecurityPolicy securityPolicy;
    private WeakReference weakView = new WeakReference(null);

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onContentStartedToLoad() {
    }

    public VastElementPresenterImpl(Logger logger, VastElementPresentationManager vastElementPresentationManager, VastWebComponentSecurityPolicy vastWebComponentSecurityPolicy, VastElementErrorCodeStrategy vastElementErrorCodeStrategy) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.presentationManager = (VastElementPresentationManager) Objects.requireNonNull(vastElementPresentationManager);
        this.securityPolicy = (VastWebComponentSecurityPolicy) Objects.requireNonNull(vastWebComponentSecurityPolicy);
        this.errorCodeStrategy = (VastElementErrorCodeStrategy) Objects.requireNonNull(vastElementErrorCodeStrategy);
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public boolean isValidUrl(String str) {
        if (this.securityPolicy.validateUrl(str)) {
            return true;
        }
        onError(new SecurityViolationException());
        return false;
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onContentLoaded() {
        VastElementView vastElementView = (VastElementView) this.weakView.get();
        if (vastElementView != null) {
            vastElementView.setOnViewVisible(new Runnable() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5764x24b7abcc();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onContentLoaded$0$com-smaato-sdk-video-vast-widget-element-VastElementPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5764x24b7abcc() {
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter.Listener) obj).onVastElementRendered();
            }
        });
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onConfigurationChanged() {
        Objects.onNotNull((VastElementView) this.weakView.get(), new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5763x746c4705((VastElementView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onConfigurationChanged$1$com-smaato-sdk-video-vast-widget-element-VastElementPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5763x746c4705(VastElementView vastElementView) {
        this.presentationManager.prepare(vastElementView, new VastElementPresenterImpl$$ExternalSyntheticLambda5(this));
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void attachView(VastElementView vastElementView) {
        this.weakView = new WeakReference(vastElementView);
        this.presentationManager.prepare(vastElementView, new VastElementPresenterImpl$$ExternalSyntheticLambda5(this));
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void detachView() {
        this.weakView.clear();
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onClicked(final String str) {
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter.Listener) obj).onVastElementClicked(str);
            }
        });
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onError(final VastElementException vastElementException) {
        this.logger.debug(LogDomain.VAST, String.format("VastElement error: %s", vastElementException), new Object[0]);
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5765x87fbee39(vastElementException, (VastElementPresenter.Listener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onError$3$com-smaato-sdk-video-vast-widget-element-VastElementPresenterImpl, reason: not valid java name */
    /* synthetic */ void m5765x87fbee39(VastElementException vastElementException, VastElementPresenter.Listener listener) {
        listener.onVastElementError(this.errorCodeStrategy.getVastErrorCode(vastElementException));
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void logError(VastElementException vastElementException) {
        this.logger.debug(LogDomain.VAST, String.format("VastElement error: %s", vastElementException), new Object[0]);
    }

    protected VastElementView getView() {
        return (VastElementView) this.weakView.get();
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void setListener(VastElementPresenter.Listener listener) {
        this.listener = listener;
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onRenderProcessGone() {
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter.Listener) obj).onRenderProcessGone();
            }
        });
    }
}
