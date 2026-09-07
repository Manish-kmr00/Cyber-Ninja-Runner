package com.pubmatic.sdk.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBTrackerHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.view.POBWebView;
import com.pubmatic.sdk.nativead.response.POBNativeAdResponseEventTracker;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class POBNativeTrackerHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBTrackerHandler f7693a;

    class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBWebView f7694a;

        a(POBWebView pOBWebView) {
            this.f7694a = pOBWebView;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.F, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(h.F, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(h.F, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(h.F, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            this.f7694a.destroy();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.F, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.F, view, url, zShouldOverrideUrlLoading);
            return zShouldOverrideUrlLoading;
        }
    }

    public POBNativeTrackerHandler(POBTrackerHandler pOBTrackerHandler) {
        this.f7693a = pOBTrackerHandler;
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList();
        if (!POBUtils.isListNullOrEmpty(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((POBNativeAdResponseEventTracker) it.next()).getUrl());
            }
        }
        return arrayList;
    }

    public void executeClickTrackers(List<String> list) {
        this.f7693a.sendTrackers(list);
    }

    public void executeImpressionTracker(Context context, List<POBNativeAdResponseEventTracker> list, List<POBNativeAdResponseEventTracker> list2, List<String> list3, String str) {
        this.f7693a.sendTrackers(a(list2, list3));
        List listA = a(list, str);
        if (listA.isEmpty()) {
            POBLog.error("POBNativeTrackerHandler", "Failed to execute tracker url: " + listA, new Object[0]);
            return;
        }
        POBWebView pOBWebViewCreateInstance = POBWebView.createInstance(context);
        if (pOBWebViewCreateInstance != null) {
            pOBWebViewCreateInstance.setWebViewClient(new a(pOBWebViewCreateInstance));
            this.f7693a.executeJsScripts(pOBWebViewCreateInstance, POBUtils.parseJsTracker(listA));
        }
    }

    private List a(List list, String str) {
        ArrayList arrayList = new ArrayList();
        if (!POBUtils.isNullOrEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(a(list));
        return arrayList;
    }

    private List a(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        if (!POBUtils.isListNullOrEmpty(list2)) {
            arrayList.addAll(list2);
        }
        arrayList.addAll(a(list));
        return arrayList;
    }
}
