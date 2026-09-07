package com.smaato.sdk.richmedia.widget;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.openmeasurement.ViewabilityVerificationResource;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.ui.ProgressView;
import com.smaato.sdk.core.ui.WatermarkImageButton;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.Whatever;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia.mraid.RichMediaWebViewFactory;
import com.smaato.sdk.richmedia.mraid.Views;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidExpandProperties;
import com.smaato.sdk.richmedia.mraid.mvp.BaseView;
import com.smaato.sdk.richmedia.mraid.presenter.MraidPresenter;
import com.smaato.sdk.richmedia.mraid.presenter.ResizeParams;
import com.smaato.sdk.richmedia.util.ViewUtils;
import com.smaato.sdk.richmedia_light.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class RichMediaAdContentView extends AdContentView implements BaseView {
    private final FrameLayout content;
    private ExpandManager expandManager;
    private final Logger logger;
    private final MraidEnvironmentProperties mraidEnvironmentProperties;
    private final MraidPresenter mraidPresenter;
    private ResizeManager resizeManager;
    private final String richMediaCreative;
    private final Callback richMediaViewCallback;
    private RichMediaWebView twoPartWebView;
    private final RichMediaWebView webView;
    private final RichMediaWebViewFactory webViewFactory;

    public interface Callback {
        default void onAdCollapsed(RichMediaAdContentView richMediaAdContentView) {
        }

        default void onAdExpanded(RichMediaAdContentView richMediaAdContentView) {
        }

        default void onAdResized(RichMediaAdContentView richMediaAdContentView) {
        }

        default void onAdViolation(String str, String str2) {
        }

        default void onHidden(RichMediaAdContentView richMediaAdContentView) {
        }

        default void onPlayVideo(RichMediaAdContentView richMediaAdContentView, String str) {
        }

        default void onRenderProcessGone(RichMediaAdContentView richMediaAdContentView) {
        }

        default void onUnloadView(RichMediaAdContentView richMediaAdContentView) {
        }

        default void onUrlClicked(RichMediaAdContentView richMediaAdContentView, String str) {
        }

        default void onUseCustomClose(Boolean bool) {
        }

        default void onWebViewError() {
        }

        default void onWebViewLoaded(RichMediaAdContentView richMediaAdContentView) {
        }

        default void registerFriendlyObstruction(View view) {
        }

        default void removeFriendlyObstruction(View view) {
        }

        default void updateAdView(RichMediaWebView richMediaWebView) {
        }
    }

    @Override // com.smaato.sdk.core.ui.AdContentView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.smaato.sdk.core.ui.AdContentView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private RichMediaAdContentView(Logger logger, Context context, String str, final Callback callback, RichMediaWebViewFactory richMediaWebViewFactory, final RichMediaWebView richMediaWebView, MraidPresenter mraidPresenter, MraidEnvironmentProperties mraidEnvironmentProperties, int i, int i2) {
        super(context);
        this.logger = logger;
        this.richMediaCreative = str;
        this.richMediaViewCallback = callback;
        this.webViewFactory = richMediaWebViewFactory;
        this.mraidPresenter = mraidPresenter;
        this.webView = richMediaWebView;
        this.mraidEnvironmentProperties = mraidEnvironmentProperties;
        i = i > 0 ? UIUtils.dpToPx(context, i) : i;
        i2 = i2 > 0 ? UIUtils.dpToPx(context, i2) : i2;
        FrameLayout frameLayout = new FrameLayout(context);
        this.content = frameLayout;
        addView(frameLayout, AdContentView.generateDefaultLayoutParams(i, i2));
        richMediaWebView.setCallback(createRichMediaWebViewCallback());
        richMediaWebView.setId(R.id.webView);
        frameLayout.addView(richMediaWebView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(new WatermarkImageButton(getContext()));
        setLayoutParams(new FrameLayout.LayoutParams(i, i2, 17));
        mraidPresenter.setOnExpandCallback(new BiConsumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m5694x3d229eed(richMediaWebView, (String) obj, (MraidExpandProperties) obj2);
            }
        });
        mraidPresenter.setOnOpenCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5695x3e58f1cc(richMediaWebView, callback, (String) obj);
            }
        });
        mraidPresenter.setOnPlayVideoCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5696x3f8f44ab(richMediaWebView, callback, (String) obj);
            }
        });
        mraidPresenter.setOnUnloadCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5697x40c5978a(callback, (Whatever) obj);
            }
        });
        mraidPresenter.setResizeCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5698x41fbea69(richMediaWebView, (ResizeParams) obj);
            }
        });
        mraidPresenter.setOnCollapseCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5699x43323d48((Whatever) obj);
            }
        });
        mraidPresenter.setOnHideCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5700x44689027(callback, (Whatever) obj);
            }
        });
        Objects.requireNonNull(callback);
        mraidPresenter.setAdViolationCallback(new BiConsumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.BiConsumer
            public final void accept(Object obj, Object obj2) {
                callback.onAdViolation((String) obj, (String) obj2);
            }
        });
        mraidPresenter.setUseCustomCloseCallback(new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                callback.onUseCustomClose((Boolean) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5694x3d229eed(RichMediaWebView richMediaWebView, String str, MraidExpandProperties mraidExpandProperties) {
        richMediaWebView.resetClickedFlag();
        expand(str);
    }

    /* JADX INFO: renamed from: lambda$new$1$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5695x3e58f1cc(RichMediaWebView richMediaWebView, Callback callback, String str) {
        richMediaWebView.resetClickedFlag();
        callback.onUrlClicked(this, str);
    }

    /* JADX INFO: renamed from: lambda$new$2$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5696x3f8f44ab(RichMediaWebView richMediaWebView, Callback callback, String str) {
        richMediaWebView.resetClickedFlag();
        callback.onPlayVideo(this, str);
    }

    /* JADX INFO: renamed from: lambda$new$3$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5697x40c5978a(Callback callback, Whatever whatever) {
        callback.onUnloadView(this);
    }

    /* JADX INFO: renamed from: lambda$new$4$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5698x41fbea69(RichMediaWebView richMediaWebView, ResizeParams resizeParams) {
        richMediaWebView.resetClickedFlag();
        resize(resizeParams);
    }

    /* JADX INFO: renamed from: lambda$new$5$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5699x43323d48(Whatever whatever) {
        restoreDefaultSize();
    }

    /* JADX INFO: renamed from: lambda$new$6$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5700x44689027(Callback callback, Whatever whatever) {
        callback.onHidden(this);
    }

    public static RichMediaAdContentView create(Logger logger, Context context, String str, Callback callback, RichMediaWebViewFactory richMediaWebViewFactory, RichMediaWebView richMediaWebView, MraidPresenter mraidPresenter, MraidEnvironmentProperties mraidEnvironmentProperties, int i, int i2) {
        return new RichMediaAdContentView((Logger) com.smaato.sdk.core.util.Objects.requireNonNull(logger), (Context) com.smaato.sdk.core.util.Objects.requireNonNull(context), (String) com.smaato.sdk.core.util.Objects.requireNonNull(str), (Callback) com.smaato.sdk.core.util.Objects.requireNonNull(callback), (RichMediaWebViewFactory) com.smaato.sdk.core.util.Objects.requireNonNull(richMediaWebViewFactory), (RichMediaWebView) com.smaato.sdk.core.util.Objects.requireNonNull(richMediaWebView), (MraidPresenter) com.smaato.sdk.core.util.Objects.requireNonNull(mraidPresenter), (MraidEnvironmentProperties) com.smaato.sdk.core.util.Objects.requireNonNull(mraidEnvironmentProperties), i, i2);
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void startShowingView() {
        Threads.ensureMainThread();
        this.webView.loadData(this.richMediaCreative, this.mraidEnvironmentProperties);
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void showProgressIndicator(boolean z) {
        Threads.ensureMainThread();
        if (z) {
            this.content.addView(new ProgressView(getContext()));
        } else {
            this.content.removeView((ProgressView) this.content.findViewById(R.id.smaato_sdk_core_progress_view_id));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mraidPresenter.attachView(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mraidPresenter.detachView();
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForVisibilityTracking() {
        View rootView = getRootView();
        if (rootView != null) {
            return rootView;
        }
        throw new IllegalStateException("No root view for RichMediaAdContentView found");
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForOmTracking() {
        return getWebView();
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public Map<String, List<ViewabilityVerificationResource>> getViewabilityVerificationResourcesMap() {
        return new HashMap();
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void destroy() {
        Threads.ensureMainThread();
        restoreDefaultSize();
        com.smaato.sdk.core.util.Objects.onNotNull(this.twoPartWebView, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((RichMediaWebView) obj).destroy();
            }
        });
        this.mraidPresenter.destroy();
        Handler handlerNewUiHandler = Threads.newUiHandler();
        final RichMediaWebView richMediaWebView = this.webView;
        Objects.requireNonNull(richMediaWebView);
        handlerNewUiHandler.postDelayed(new Runnable() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                richMediaWebView.destroy();
            }
        }, 1000L);
    }

    public RichMediaWebView getWebView() {
        return this.webView;
    }

    private void expand(String str) {
        if (this.expandManager != null) {
            return;
        }
        final boolean z = !TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str);
        if (z) {
            final FrameLayout frameLayout = new FrameLayout(getContext());
            WatermarkImageButton watermarkImageButton = new WatermarkImageButton(getContext());
            RichMediaWebView richMediaWebViewCreate = this.webViewFactory.create(getContext(), true);
            this.twoPartWebView = richMediaWebViewCreate;
            frameLayout.addView(richMediaWebViewCreate);
            frameLayout.addView(watermarkImageButton);
            this.twoPartWebView.setCallback(new RichMediaWebViewCallbackAdapter() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView.1
                private boolean violation;

                @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
                public void onWebViewLoaded() {
                    if (this.violation) {
                        RichMediaAdContentView.this.mraidPresenter.onFailedToExpand();
                    } else {
                        if (RichMediaAdContentView.this.expandManager != null) {
                            return;
                        }
                        RichMediaAdContentView.this.performExpand(frameLayout, z);
                        RichMediaAdContentView.this.richMediaViewCallback.updateAdView(RichMediaAdContentView.this.twoPartWebView);
                    }
                }

                @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
                public void onAdViolation(String str2, String str3) {
                    this.violation = true;
                    RichMediaAdContentView.this.richMediaViewCallback.onAdViolation(str2, str3);
                }

                @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
                public void onUrlClicked(String str2) {
                    RichMediaAdContentView.this.richMediaViewCallback.onUrlClicked(RichMediaAdContentView.this, str2);
                }

                @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
                public void onRenderProcessGone() {
                    RichMediaAdContentView.this.mraidPresenter.onFailedToExpand();
                }
            });
            this.twoPartWebView.loadUrlContent(str);
            return;
        }
        performExpand(this.content, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performExpand(View view, final boolean z) {
        ExpandManager expandManager = new ExpandManager();
        this.expandManager = expandManager;
        expandManager.expand(view, new ExpandManager.Listener() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView.2
            @Override // com.smaato.sdk.richmedia.widget.ExpandManager.Listener
            public void onExpanded(ImageButton imageButton) {
                RichMediaAdContentView.this.mraidPresenter.onWasExpanded();
                RichMediaAdContentView.this.richMediaViewCallback.onAdExpanded(RichMediaAdContentView.this);
            }

            @Override // com.smaato.sdk.richmedia.widget.ExpandManager.Listener
            public void onFailedToExpand() {
                RichMediaAdContentView.this.logger.error(LogDomain.RICH_MEDIA, "Failed to expand creative", new Object[0]);
                RichMediaAdContentView.this.mraidPresenter.onFailedToExpand();
            }

            @Override // com.smaato.sdk.richmedia.widget.ExpandManager.Listener
            public void onCloseClicked(ImageButton imageButton) {
                RichMediaAdContentView.this.mraidPresenter.handleClose();
                RichMediaAdContentView.this.richMediaViewCallback.removeFriendlyObstruction(imageButton);
                if (z) {
                    RichMediaAdContentView.this.richMediaViewCallback.updateAdView(RichMediaAdContentView.this.webView);
                }
            }
        });
    }

    private void resize(ResizeParams resizeParams) {
        if (this.resizeManager == null) {
            ResizeManager resizeManager = new ResizeManager(this.logger, this.content, resizeParams.maxSizeRectInPx);
            this.resizeManager = resizeManager;
            resizeManager.setListener(new ResizeManager.Listener() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView.3
                @Override // com.smaato.sdk.richmedia.widget.ResizeManager.Listener
                public void onResized(ImageButton imageButton) {
                    RichMediaAdContentView.this.mraidPresenter.onWasResized();
                    RichMediaAdContentView.this.richMediaViewCallback.onAdResized(RichMediaAdContentView.this);
                }

                @Override // com.smaato.sdk.richmedia.widget.ResizeManager.Listener
                public void onCloseClicked(ImageButton imageButton) {
                    RichMediaAdContentView.this.mraidPresenter.handleClose();
                    RichMediaAdContentView.this.richMediaViewCallback.removeFriendlyObstruction(imageButton);
                }

                @Override // com.smaato.sdk.richmedia.widget.ResizeManager.Listener
                public void onResizeFailed(String str) {
                    RichMediaAdContentView.this.mraidPresenter.onFailedToResize(str);
                }
            });
        }
        this.resizeManager.resize(resizeParams.resizeRectInPx);
    }

    private void restoreDefaultSize() {
        if (this.resizeManager != null || this.expandManager != null) {
            ViewUtils.removeFromParent(this.content);
            addView(this.content);
            Views.addOnPreDrawListener(this.content, new Runnable() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5701x1d13e798();
                }
            });
        }
        com.smaato.sdk.core.util.Objects.onNotNull(this.resizeManager, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5702x1e4a3a77((ResizeManager) obj);
            }
        });
        com.smaato.sdk.core.util.Objects.onNotNull(this.expandManager, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5703x1f808d56((ExpandManager) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$restoreDefaultSize$7$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5701x1d13e798() {
        this.mraidPresenter.onWasClosed();
        this.richMediaViewCallback.onAdCollapsed(this);
    }

    /* JADX INFO: renamed from: lambda$restoreDefaultSize$8$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5702x1e4a3a77(ResizeManager resizeManager) {
        resizeManager.collapse();
        this.resizeManager = null;
    }

    /* JADX INFO: renamed from: lambda$restoreDefaultSize$9$com-smaato-sdk-richmedia-widget-RichMediaAdContentView, reason: not valid java name */
    /* synthetic */ void m5703x1f808d56(ExpandManager expandManager) {
        expandManager.collapse();
        this.expandManager = null;
    }

    private RichMediaWebView.Callback createRichMediaWebViewCallback() {
        return new RichMediaWebViewCallbackAdapter() { // from class: com.smaato.sdk.richmedia.widget.RichMediaAdContentView.4
            @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
            public void onWebViewLoaded() {
                RichMediaAdContentView.this.richMediaViewCallback.onWebViewLoaded(RichMediaAdContentView.this);
                RichMediaAdContentView.this.mraidPresenter.onHtmlLoaded();
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
            public void onUrlClicked(String str) {
                RichMediaAdContentView.this.richMediaViewCallback.onUrlClicked(RichMediaAdContentView.this, str);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
            public void handleMraidUrl(String str, boolean z) {
                RichMediaAdContentView.this.mraidPresenter.handleMraidUrl(str, z);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
            public void onAdViolation(String str, String str2) {
                RichMediaAdContentView.this.richMediaViewCallback.onAdViolation(str, str2);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
            public void onRenderProcessGone() {
                RichMediaAdContentView.this.richMediaViewCallback.onRenderProcessGone(RichMediaAdContentView.this);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaWebViewCallbackAdapter, com.smaato.sdk.richmedia.widget.RichMediaWebView.Callback
            public void onError() {
                super.onError();
                RichMediaAdContentView.this.richMediaViewCallback.onWebViewError();
            }
        };
    }
}
