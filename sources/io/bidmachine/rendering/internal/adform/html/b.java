package io.bidmachine.rendering.internal.adform.html;

import android.webkit.WebView;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.mraid.MraidAdView;
import io.bidmachine.iab.mraid.MraidOrientationProperties;
import io.bidmachine.iab.mraid.MraidResizeProperties;
import io.bidmachine.iab.mraid.MraidScreenMetrics;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;

/* JADX INFO: loaded from: classes11.dex */
public class b implements MraidAdView.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12332a;
    private final c b;
    private final io.bidmachine.rendering.internal.event.a c;
    private final HtmlMeasurer d;

    public b(a aVar, c cVar, io.bidmachine.rendering.internal.event.a aVar2, HtmlMeasurer htmlMeasurer) {
        this.f12332a = aVar;
        this.b = cVar;
        this.c = aVar2;
        this.d = htmlMeasurer;
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onCalendarEventIntention(MraidAdView mraidAdView, String str) {
        onOpenUrlIntention(mraidAdView, str);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onChangeOrientationIntention(MraidAdView mraidAdView, MraidOrientationProperties mraidOrientationProperties) {
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onCloseIntention(MraidAdView mraidAdView) {
        this.c.onClose();
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public boolean onExpandIntention(MraidAdView mraidAdView, WebView webView, MraidOrientationProperties mraidOrientationProperties, boolean z) {
        return false;
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onExpanded(MraidAdView mraidAdView) {
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewExpired(MraidAdView mraidAdView, IabError iabError) {
        this.b.b(this.f12332a, new Error(iabError.getMessage()));
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewLoadFailed(MraidAdView mraidAdView, IabError iabError) {
        this.f12332a.a(new Error(iabError.getMessage()));
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewPageLoaded(MraidAdView mraidAdView, String str, WebView webView, boolean z) {
        HtmlMeasurer htmlMeasurer = this.d;
        if (htmlMeasurer != null) {
            htmlMeasurer.onViewReady(webView);
        }
        this.b.b(this.f12332a);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewShowFailed(MraidAdView mraidAdView, IabError iabError) {
        this.f12332a.b(new Error(iabError.getMessage()));
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewShown(MraidAdView mraidAdView) {
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidLoadedIntention(MraidAdView mraidAdView) {
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onOpenPrivacySheet(MraidAdView mraidAdView, PrivacySheetParams privacySheetParams) {
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onOpenUrlIntention(MraidAdView mraidAdView, String str) {
        HtmlMeasurer htmlMeasurer = this.d;
        if (htmlMeasurer != null) {
            htmlMeasurer.onClicked();
        }
        this.c.a(str);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onPlayVideoIntention(MraidAdView mraidAdView, String str) {
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public boolean onResizeIntention(MraidAdView mraidAdView, WebView webView, MraidResizeProperties mraidResizeProperties, MraidScreenMetrics mraidScreenMetrics) {
        return false;
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onStorePictureIntention(MraidAdView mraidAdView, String str) {
        onOpenUrlIntention(mraidAdView, str);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onSyncCustomCloseIntention(MraidAdView mraidAdView, boolean z) {
        this.c.onUseCustomClose(z);
    }
}
