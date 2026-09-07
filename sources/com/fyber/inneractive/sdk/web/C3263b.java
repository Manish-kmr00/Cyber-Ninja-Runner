package com.fyber.inneractive.sdk.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3263b extends j0 {
    public final com.fyber.inneractive.sdk.flow.endcard.p N;

    public C3263b(com.fyber.inneractive.sdk.flow.endcard.p pVar, boolean z) {
        super(z, C.INTERSTITIAL, null);
        this.N = pVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final boolean a(String str, com.fyber.inneractive.sdk.util.h0 h0Var) {
        String str2;
        if (str == null || !str.toLowerCase().startsWith("fmpendcard://".toLowerCase())) {
            return false;
        }
        com.fyber.inneractive.sdk.flow.endcard.p pVar = this.N;
        if (pVar != null) {
            InterfaceC3268g interfaceC3268g = this.f;
            k0 k0Var = this.g;
            Uri uri = Uri.parse(str);
            String authority = uri != null ? uri.getAuthority() : null;
            if (!TextUtils.isEmpty(authority)) {
                authority.getClass();
                authority.hashCode();
                switch (authority) {
                    case "success":
                        String queryParameter = uri.getQueryParameter("version");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            pVar.c = queryParameter;
                        }
                        InterfaceC3268g interfaceC3268g2 = this.f;
                        if (interfaceC3268g2 != null) {
                            interfaceC3268g2.a(this);
                            break;
                        }
                        break;
                    case "failure":
                        String queryParameter2 = uri.getQueryParameter("version");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            pVar.c = queryParameter2;
                        }
                        String queryParameter3 = uri.getQueryParameter("error");
                        if (interfaceC3268g != null) {
                            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_LOAD_FMP_ENDCARD_TO_WEBVIEW);
                            if (!TextUtils.isEmpty(queryParameter3)) {
                                inneractiveInfrastructureError.setCause(new Exception(queryParameter3));
                            }
                            interfaceC3268g.a(inneractiveInfrastructureError);
                            break;
                        }
                        break;
                    case "click":
                        if (k0Var != null) {
                            com.fyber.inneractive.sdk.model.vast.b bVar = pVar.b;
                            com.fyber.inneractive.sdk.flow.endcard.i iVar = bVar.o;
                            if (iVar != null) {
                                com.fyber.inneractive.sdk.flow.endcard.b bVarA = iVar.a();
                                str2 = iVar.f1793a.e.b;
                                com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Other);
                                if (cVar == null && (cVar = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Html)) == null && (cVar = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Iframe)) == null) {
                                    cVar = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Static);
                                }
                                if (bVarA != null && bVarA.i() && cVar != null) {
                                    String str3 = cVar.e.g;
                                    if (!TextUtils.isEmpty(str3)) {
                                        str2 = str3;
                                    }
                                }
                            } else {
                                str2 = bVar.b;
                            }
                            k0Var.a(str2, h0Var);
                            break;
                        }
                        break;
                }
            } else if (interfaceC3268g != null) {
                InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_LOAD_FMP_ENDCARD_TO_WEBVIEW);
                if (!TextUtils.isEmpty("empty type")) {
                    inneractiveInfrastructureError2.setCause(new Exception("empty type"));
                }
                interfaceC3268g.a(inneractiveInfrastructureError2);
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3273l
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3273l
    public final void c() {
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i, com.fyber.inneractive.sdk.web.InterfaceC3271j
    public final void d() {
        if (this.N == null || this.f == null) {
            return;
        }
        this.f.a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.WEBVIEW_FMP_ENDCARD_ERROR));
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final com.fyber.inneractive.sdk.measurement.tracker.f f() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i, com.fyber.inneractive.sdk.web.InterfaceC3271j
    public final void a(WebView webView) {
        String string;
        if (webView == null || this.N == null) {
            return;
        }
        webView.setLongClickable(false);
        webView.setOnLongClickListener(new com.fyber.inneractive.sdk.util.P());
        com.fyber.inneractive.sdk.flow.endcard.p pVar = this.N;
        com.fyber.inneractive.sdk.flow.endcard.o oVar = (com.fyber.inneractive.sdk.flow.endcard.o) pVar.d.f();
        oVar.getClass();
        try {
            JSONObject jSONObject = new JSONObject();
            com.fyber.inneractive.sdk.util.d0.a(jSONObject, "name", oVar.i);
            JSONArray jSONArray = new JSONArray();
            String str = oVar.j;
            if (!TextUtils.isEmpty(str)) {
                jSONArray.put(str);
            }
            com.fyber.inneractive.sdk.util.d0.a(jSONObject, "icons", jSONArray);
            string = jSONObject.toString();
        } catch (Exception e) {
            IAlog.a("%s FMP End-Card JSON error: %s", e, oVar.f1788a, e.getMessage());
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            IAlog.f("%s FMP End-Card JSON required", pVar.f1797a);
            return;
        }
        com.fyber.inneractive.sdk.util.Q.a(webView, "loadAssets(" + string + ");");
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i, com.fyber.inneractive.sdk.web.InterfaceC3271j
    public final void a() {
        super.a();
        if (this.f != null) {
            this.f.a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.WEBVIEW_FMP_ENDCARD_ERROR, new WebViewRendererProcessHasGoneError()));
        }
    }
}
