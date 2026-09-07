package com.iab.omid.library.odeeoio.publisher;

import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iab.omid.library.odeeoio.adsession.AdEvents;
import com.iab.omid.library.odeeoio.adsession.AdSessionConfiguration;
import com.iab.omid.library.odeeoio.adsession.AdSessionContext;
import com.iab.omid.library.odeeoio.adsession.ErrorType;
import com.iab.omid.library.odeeoio.adsession.VerificationScriptResource;
import com.iab.omid.library.odeeoio.adsession.media.MediaEvents;
import com.iab.omid.library.odeeoio.b.d;
import com.iab.omid.library.odeeoio.b.e;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.iab.omid.library.odeeoio.e.b f2782a;
    private AdEvents b;
    private MediaEvents c;
    private a d;
    private long e;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        i();
        this.f2782a = new com.iab.omid.library.odeeoio.e.b(null);
    }

    public void a() {
    }

    public void a(float f) {
        e.a().a(getWebView(), f);
    }

    void a(WebView webView) {
        this.f2782a = new com.iab.omid.library.odeeoio.e.b(webView);
    }

    public void a(AdEvents adEvents) {
        this.b = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        e.a().a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        e.a().a(getWebView(), errorType, str);
    }

    public void a(com.iab.omid.library.odeeoio.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, null);
    }

    protected void a(com.iab.omid.library.odeeoio.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        com.iab.omid.library.odeeoio.d.b.a(jSONObject2, "environment", "app");
        com.iab.omid.library.odeeoio.d.b.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        com.iab.omid.library.odeeoio.d.b.a(jSONObject2, POBCrashAnalyticsConstants.DEVICE_INFO_KEY, com.iab.omid.library.odeeoio.d.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        com.iab.omid.library.odeeoio.d.b.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        com.iab.omid.library.odeeoio.d.b.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, adSessionContext.getPartner().getName());
        com.iab.omid.library.odeeoio.d.b.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, adSessionContext.getPartner().getVersion());
        com.iab.omid.library.odeeoio.d.b.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        com.iab.omid.library.odeeoio.d.b.a(jSONObject4, "libraryVersion", "1.3.26-Odeeoio");
        com.iab.omid.library.odeeoio.d.b.a(jSONObject4, RemoteConfigConstants.RequestFieldKey.APP_ID, d.a().b().getApplicationContext().getPackageName());
        com.iab.omid.library.odeeoio.d.b.a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            com.iab.omid.library.odeeoio.d.b.a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            com.iab.omid.library.odeeoio.d.b.a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            com.iab.omid.library.odeeoio.d.b.a(jSONObject5, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        e.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.c = mediaEvents;
    }

    public void a(String str) {
        e.a().a(getWebView(), str, (JSONObject) null);
    }

    public void a(String str, long j) {
        if (j >= this.e) {
            this.d = a.AD_STATE_VISIBLE;
            e.a().b(getWebView(), str);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        e.a().a(getWebView(), str, jSONObject);
    }

    public void a(JSONObject jSONObject) {
        e.a().b(getWebView(), jSONObject);
    }

    public void a(boolean z) {
        if (e()) {
            e.a().c(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    public void b() {
        this.f2782a.clear();
    }

    public void b(String str, long j) {
        if (j < this.e || this.d == a.AD_STATE_NOTVISIBLE) {
            return;
        }
        this.d = a.AD_STATE_NOTVISIBLE;
        e.a().b(getWebView(), str);
    }

    public AdEvents c() {
        return this.b;
    }

    public MediaEvents d() {
        return this.c;
    }

    public boolean e() {
        return this.f2782a.get() != null;
    }

    public void f() {
        e.a().a(getWebView());
    }

    public void g() {
        e.a().b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f2782a.get();
    }

    public void h() {
        e.a().c(getWebView());
    }

    public void i() {
        this.e = com.iab.omid.library.odeeoio.d.d.a();
        this.d = a.AD_STATE_IDLE;
    }
}
