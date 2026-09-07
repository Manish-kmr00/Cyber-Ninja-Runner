package com.smaato.sdk.nativead.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.mvvm.view.ViewVisibilityObserver;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.NativeAdRenderer;
import com.smaato.sdk.nativead.NativeAdView;
import com.smaato.sdk.nativead.viewmodel.NativeAdViewModel;
import com.smaato.sdk.richmedia.mraid.MraidConfigurator;
import com.smaato.sdk.richmedia.mraid.RichMediaWebViewFactory;
import com.smaato.sdk.richmedia.widget.RichMediaAdContentView;
import com.smaato.sdk.richmedia.widget.RichMediaWebView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class NativeAdRendererImpl implements NativeAdRenderer {

    @Inject
    private static MraidConfigurator mraidConfigurator;

    @Inject
    private static RichMediaWebViewFactory richMediaWebViewFactory;
    private final AdType adType;
    private WeakReference contentViewRichMediaRef = new WeakReference(null);
    private WeakReference contentViewVideoRef = new WeakReference(null);
    private final ImpressionCountingType impressionCountingType;
    private final String mraidWrappedVast;
    private final NativeAdAssets nativeAdAssets;
    private final NativeAdViewModel nativeAdViewModel;

    public NativeAdRendererImpl(NativeAdAssets nativeAdAssets, NativeAdViewModel nativeAdViewModel, String str, ImpressionCountingType impressionCountingType, AdType adType) {
        this.nativeAdAssets = nativeAdAssets;
        this.nativeAdViewModel = nativeAdViewModel;
        this.mraidWrappedVast = str;
        this.impressionCountingType = impressionCountingType;
        this.adType = adType;
        AndroidsInjector.injectStatic(NativeAdRendererImpl.class);
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public NativeAdAssets getAssets() {
        return this.nativeAdAssets;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public String creativeId() {
        return this.nativeAdViewModel.getCreativeId();
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public String sessionId() {
        return this.nativeAdViewModel.getSessionId();
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public void renderInView(NativeAdView nativeAdView) {
        View viewVideoView;
        View viewRichMediaView;
        BiConsumer<Uri, ImageView> imageLoader = this.nativeAdViewModel.getImageLoader();
        RendererHelper.renderText(nativeAdView.titleView(), this.nativeAdAssets.title());
        RendererHelper.renderText(nativeAdView.textView(), this.nativeAdAssets.text());
        RendererHelper.renderText(nativeAdView.sponsoredView(), this.nativeAdAssets.sponsored());
        RendererHelper.renderText(nativeAdView.ctaView(), this.nativeAdAssets.cta());
        RendererHelper.renderRating(nativeAdView.ratingView(), this.nativeAdAssets.rating());
        RendererHelper.renderImage(imageLoader, nativeAdView.iconView(), this.nativeAdAssets.icon());
        if (!this.nativeAdAssets.images().isEmpty()) {
            RendererHelper.renderImage(imageLoader, nativeAdView.mediaView(), this.nativeAdAssets.images());
        }
        if (this.nativeAdAssets.mraidJs() != null && !this.nativeAdAssets.mraidJs().isEmpty() && (viewRichMediaView = nativeAdView.richMediaView()) != null) {
            RichMediaAdContentView richMediaAdContentViewCreateRichMediaAdContentView = createRichMediaAdContentView(viewRichMediaView, this.nativeAdAssets.mraidJs());
            RendererHelper.renderRichMedia(viewRichMediaView, richMediaAdContentViewCreateRichMediaAdContentView);
            this.contentViewRichMediaRef = new WeakReference(richMediaAdContentViewCreateRichMediaAdContentView);
        }
        String str = this.mraidWrappedVast;
        if (str != null && !str.isEmpty() && (viewVideoView = nativeAdView.videoView()) != null) {
            RichMediaAdContentView richMediaAdContentViewCreateRichMediaAdContentView2 = createRichMediaAdContentView(viewVideoView, this.mraidWrappedVast);
            RendererHelper.renderRichMedia(viewVideoView, richMediaAdContentViewCreateRichMediaAdContentView2);
            this.contentViewVideoRef = new WeakReference(richMediaAdContentViewCreateRichMediaAdContentView2);
        }
        View viewPrivacyView = nativeAdView.privacyView();
        final NativeAdViewModel nativeAdViewModel = this.nativeAdViewModel;
        Objects.requireNonNull(nativeAdViewModel);
        RendererHelper.renderPrivacyIcon(viewPrivacyView, new Runnable() { // from class: com.smaato.sdk.nativead.view.NativeAdRendererImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                nativeAdViewModel.launchPrivacyUrl();
            }
        });
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public void registerForImpression(View view) {
        this.nativeAdViewModel.onRegisterForImpression(view);
        new ViewVisibilityObserver(view, this.impressionCountingType, this.adType, this.nativeAdViewModel).startObserving();
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public void registerForClicks(View... viewArr) {
        registerForClicks(Arrays.asList(viewArr));
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public void registerForClicks(Iterable<? extends View> iterable) {
        for (View view : iterable) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.nativead.view.NativeAdRendererImpl$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.m5626x998d44ed(view2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$registerForClicks$0$com-smaato-sdk-nativead-view-NativeAdRendererImpl, reason: not valid java name */
    /* synthetic */ void m5626x998d44ed(View view) {
        this.nativeAdViewModel.executeCtaLink(null, null);
    }

    private RichMediaAdContentView createRichMediaAdContentView(View view, String str) {
        Context context = view.getContext();
        return mraidConfigurator.createView(context, str, -1, -1, false, richMediaWebViewFactory.create(context), createRichMediaCallback());
    }

    private RichMediaAdContentView.Callback createRichMediaCallback() {
        return new RichMediaAdContentView.Callback() { // from class: com.smaato.sdk.nativead.view.NativeAdRendererImpl.1
            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onUrlClicked(RichMediaAdContentView richMediaAdContentView, String str) {
                NativeAdRendererImpl.this.nativeAdViewModel.executeCtaLink(null, null);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void updateAdView(RichMediaWebView richMediaWebView) {
                NativeAdRendererImpl.this.nativeAdViewModel.onUpdateAdView(richMediaWebView);
            }
        };
    }

    @Override // com.smaato.sdk.nativead.NativeAdRenderer
    public void onDestroyView() {
        com.smaato.sdk.core.util.Objects.onNotNull((RichMediaAdContentView) this.contentViewRichMediaRef.get(), new Consumer() { // from class: com.smaato.sdk.nativead.view.NativeAdRendererImpl$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5624x2a68ca5d((RichMediaAdContentView) obj);
            }
        });
        com.smaato.sdk.core.util.Objects.onNotNull((RichMediaAdContentView) this.contentViewVideoRef.get(), new Consumer() { // from class: com.smaato.sdk.nativead.view.NativeAdRendererImpl$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5625x6df3e81e((RichMediaAdContentView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onDestroyView$1$com-smaato-sdk-nativead-view-NativeAdRendererImpl, reason: not valid java name */
    /* synthetic */ void m5624x2a68ca5d(RichMediaAdContentView richMediaAdContentView) {
        this.contentViewRichMediaRef.clear();
        richMediaAdContentView.destroy();
    }

    /* JADX INFO: renamed from: lambda$onDestroyView$2$com-smaato-sdk-nativead-view-NativeAdRendererImpl, reason: not valid java name */
    /* synthetic */ void m5625x6df3e81e(RichMediaAdContentView richMediaAdContentView) {
        this.contentViewVideoRef.clear();
        richMediaAdContentView.destroy();
    }
}
