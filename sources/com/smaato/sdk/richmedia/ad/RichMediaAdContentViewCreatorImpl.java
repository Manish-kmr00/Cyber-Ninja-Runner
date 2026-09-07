package com.smaato.sdk.richmedia.ad;

import android.content.Context;
import android.view.View;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.RichMediaAdContentViewCreator;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.richmedia.mraid.MraidConfigurator;
import com.smaato.sdk.richmedia.mraid.RichMediaWebViewFactory;
import com.smaato.sdk.richmedia.widget.RichMediaAdContentView;
import com.smaato.sdk.richmedia.widget.RichMediaWebView;

/* JADX INFO: loaded from: classes7.dex */
public class RichMediaAdContentViewCreatorImpl implements RichMediaAdContentViewCreator {
    AppBackgroundDetector appBackgroundDetector;
    Logger logger;
    private final MraidConfigurator mraidConfigurator;
    private final RichMediaWebViewFactory richMediaWebViewFactory;

    public RichMediaAdContentViewCreatorImpl(MraidConfigurator mraidConfigurator, RichMediaWebViewFactory richMediaWebViewFactory, AppBackgroundDetector appBackgroundDetector, Logger logger) {
        this.mraidConfigurator = mraidConfigurator;
        this.richMediaWebViewFactory = richMediaWebViewFactory;
        this.appBackgroundDetector = appBackgroundDetector;
        this.logger = logger;
    }

    @Override // com.smaato.sdk.core.mvvm.view.RichMediaAdContentViewCreator
    public AdContentView createAdContentView(Context context, String str, int i, int i2, boolean z, ImpressionCountingType impressionCountingType, SmaatoSdkViewDelegate smaatoSdkViewDelegate) {
        return this.mraidConfigurator.createView(context, str, i, i2, z, this.richMediaWebViewFactory.create(context), createRichMediaAdContentViewCallback(smaatoSdkViewDelegate));
    }

    private RichMediaAdContentView.Callback createRichMediaAdContentViewCallback(final SmaatoSdkViewDelegate smaatoSdkViewDelegate) {
        return new RichMediaAdContentView.Callback() { // from class: com.smaato.sdk.richmedia.ad.RichMediaAdContentViewCreatorImpl.1
            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onWebViewLoaded(RichMediaAdContentView richMediaAdContentView) {
                smaatoSdkViewDelegate.onRichMediaWebViewLoaded(richMediaAdContentView.getWebView());
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onUrlClicked(RichMediaAdContentView richMediaAdContentView, String str) {
                smaatoSdkViewDelegate.executeCtaLink(str);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onAdExpanded(RichMediaAdContentView richMediaAdContentView) {
                if (RichMediaAdContentViewCreatorImpl.this.appBackgroundDetector.isAppInBackground()) {
                    RichMediaAdContentViewCreatorImpl.this.logger.info(LogDomain.AD, "skipping expand event, because app is in background", new Object[0]);
                } else {
                    smaatoSdkViewDelegate.onRichMediaWebViewExpanded();
                }
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onUnloadView(RichMediaAdContentView richMediaAdContentView) {
                smaatoSdkViewDelegate.onRichMediaWebViewUnloaded();
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onAdResized(RichMediaAdContentView richMediaAdContentView) {
                if (RichMediaAdContentViewCreatorImpl.this.appBackgroundDetector.isAppInBackground()) {
                    RichMediaAdContentViewCreatorImpl.this.logger.info(LogDomain.AD, "skipping resize event, because app is in background", new Object[0]);
                } else {
                    smaatoSdkViewDelegate.onRichMediaWebViewResized();
                }
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void registerFriendlyObstruction(View view) {
                smaatoSdkViewDelegate.registerFriendlyObstruction(view);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void removeFriendlyObstruction(View view) {
                smaatoSdkViewDelegate.removeFriendlyObstruction(view);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onAdCollapsed(RichMediaAdContentView richMediaAdContentView) {
                smaatoSdkViewDelegate.onRichMediaWebViewCollapsed();
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onAdViolation(String str, String str2) {
                smaatoSdkViewDelegate.reportRichMediaAdViolation(str, str2);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void updateAdView(RichMediaWebView richMediaWebView) {
                smaatoSdkViewDelegate.onUpdateAdView(richMediaWebView);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onRenderProcessGone(RichMediaAdContentView richMediaAdContentView) {
                smaatoSdkViewDelegate.onRichMediaAdRendererProcessGone();
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onPlayVideo(RichMediaAdContentView richMediaAdContentView, String str) {
                smaatoSdkViewDelegate.showLink(str);
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onHidden(RichMediaAdContentView richMediaAdContentView) {
                smaatoSdkViewDelegate.hideRichMediaAd();
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onUseCustomClose(Boolean bool) {
                if (bool.booleanValue()) {
                    smaatoSdkViewDelegate.onUseCustomClose();
                }
            }

            @Override // com.smaato.sdk.richmedia.widget.RichMediaAdContentView.Callback
            public void onWebViewError() {
                smaatoSdkViewDelegate.onWebViewError();
            }
        };
    }
}
