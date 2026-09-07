package com.amazon.aps.ads.util.adview;

import android.content.Context;
import android.webkit.WebView;
import com.json.nu;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApsAdWebViewSupportClientBase.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J$\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\tH&J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\fH&J\b\u0010\u0016\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdWebViewClientListener;", "", "adViewContext", "Landroid/content/Context;", "getAdViewContext", "()Landroid/content/Context;", "isTwoPartExpand", "", nu.k, "", "onCrash", "webView", "Landroid/webkit/WebView;", "errorInfo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "errorDetail", "", "onLoadError", "onPageFinished", "url", "view", "onPageLoaded", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApsAdWebViewClientListener {
    Context getAdViewContext();

    boolean isTwoPartExpand();

    void onAdLeftApplication();

    void onCrash(WebView webView, StringBuilder errorInfo, String errorDetail);

    void onLoadError();

    void onPageFinished(String url, WebView view);

    void onPageLoaded();
}
