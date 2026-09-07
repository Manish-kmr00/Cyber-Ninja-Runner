package com.fyber.inneractive.sdk.util;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.web.AbstractC3270i;
import com.fyber.inneractive.sdk.web.C3266e;
import com.iab.omid.library.fyber.ScriptInjector;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3240d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object[] f2359a = null;
    public final /* synthetic */ C3266e b;

    public RunnableC3240d(C3266e c3266e) {
        this.b = c3266e;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0078  */
    /* JADX WARN: Code duplicated, block: B:21:0x0083  */
    /* JADX WARN: Code duplicated, block: B:24:0x0091  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:46:0x0110  */
    /* JADX WARN: Code duplicated, block: B:49:0x0116  */
    /* JADX WARN: Code duplicated, block: B:56:0x0129  */
    /* JADX WARN: Code duplicated, block: B:58:0x0136  */
    /* JADX WARN: Code duplicated, block: B:61:0x0143  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:66:0x015f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0161  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zA;
        String strB;
        com.fyber.inneractive.sdk.flow.x xVar;
        com.fyber.inneractive.sdk.response.e eVarC;
        com.fyber.inneractive.sdk.measurement.e eVar;
        String string;
        StringBuilder sb;
        C3266e c3266e = this.b;
        Object[] objArr = this.f2359a;
        c3266e.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string2 = c3266e.g;
        if (c3266e.h) {
            AbstractC3270i abstractC3270i = c3266e.l;
            String str = c3266e.i;
            String str2 = c3266e.j;
            com.fyber.inneractive.sdk.web.j0 j0Var = (com.fyber.inneractive.sdk.web.j0) abstractC3270i;
            j0Var.getClass();
            StringBuilder sb2 = new StringBuilder("<html><title>DigitalTurbine Ad</title><head><link rel=\"icon\" href=\"data:,\">");
            boolean z = false;
            if (TextUtils.isEmpty(string2)) {
                IAlog.a("loadHtml called with an empty HTML!", new Object[0]);
            } else if (j0Var.F) {
                String strB2 = AbstractC3251o.b("ia_js_load_monitor.txt");
                if (!TextUtils.isEmpty(strB2)) {
                    sb2.append(strB2);
                    sb2.append("<script> window.iaPreCachedAd = true; </script>");
                    IAConfigManager iAConfigManager = IAConfigManager.O;
                    zA = iAConfigManager.u.b.a(false, "use_js_inline");
                    if (zA || iAConfigManager.H.b == null) {
                        sb2.append("<script src=\"https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js\"></script>");
                    } else {
                        sb2.append("<script type=\"text/javascript\">").append(iAConfigManager.H.b).append("</script>");
                    }
                    if (!TextUtils.isEmpty(str)) {
                        sb2.append(str);
                    }
                    sb2.append("<script>var prevWindowOnError = window.onerror; window.onerror = function(err) {if (typeof prevWindowOnError === 'function') {prevWindowOnError.apply();} console.log('WINDOW.ONERROR Javascript Error: ' + err);};</script></head><style>body{text-align:center !important;margin:0;padding:0;}");
                    if (!TextUtils.isEmpty(str2)) {
                        sb2.append(str2);
                    }
                    sb2.append("</style><body id=\"iaBody\">");
                    if (j0Var.B && j0Var.m()) {
                        if (zA || iAConfigManager.H.c == null) {
                            sb2.append("<link rel=\"stylesheet\" href=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css\">");
                        } else {
                            sb2.append("<style type=\"text/css\">").append(iAConfigManager.H.c).append("</style>");
                        }
                        if (zA || iAConfigManager.H.d == null) {
                            sb2.append("<script src=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js\"></script>");
                        } else {
                            sb2.append("<script type=\"text/javascript\">").append(iAConfigManager.H.d).append("</script>");
                        }
                    }
                    strB = AbstractC3251o.b("ia_mraid_bridge.txt");
                    if (!TextUtils.isEmpty(strB)) {
                        sb2.append("<div id='iaScriptBr' style='display:none;'>");
                        sb2.append(strB);
                        sb2.append("</div>");
                        if (IAlog.f2345a >= 2) {
                            sb2.append("<script type=\"text/javascript\">window.mraidbridge.loggingEnabled = true;</script>");
                        }
                    }
                    sb2.append(string2);
                    sb2.append("</body></html>");
                    if (j0Var.H != null) {
                        xVar = j0Var.s;
                        if (xVar == null) {
                            eVarC = xVar.c();
                            if (eVarC != null && eVarC.J) {
                                z = true;
                            }
                            eVar = j0Var.H;
                            string = sb2.toString();
                            if (z) {
                                sb = new StringBuilder();
                                if (!TextUtils.isEmpty(eVar.c)) {
                                    sb.append(eVar.c);
                                }
                                if (!TextUtils.isEmpty(eVar.d)) {
                                    sb.append(eVar.d);
                                }
                                string = ScriptInjector.injectScriptContentIntoHtml(sb.toString(), string);
                            }
                            if (TextUtils.isEmpty(eVar.b)) {
                                string2 = string;
                            } else {
                                string2 = ScriptInjector.injectScriptContentIntoHtml(eVar.b, string);
                            }
                        }
                    } else {
                        string2 = sb2.toString();
                    }
                }
            } else {
                sb2.append("<script> window.iaPreCachedAd = true; </script>");
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                zA = iAConfigManager2.u.b.a(false, "use_js_inline");
                if (zA) {
                    sb2.append("<script src=\"https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js\"></script>");
                } else {
                    sb2.append("<script src=\"https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js\"></script>");
                }
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(str);
                }
                sb2.append("<script>var prevWindowOnError = window.onerror; window.onerror = function(err) {if (typeof prevWindowOnError === 'function') {prevWindowOnError.apply();} console.log('WINDOW.ONERROR Javascript Error: ' + err);};</script></head><style>body{text-align:center !important;margin:0;padding:0;}");
                if (!TextUtils.isEmpty(str2)) {
                    sb2.append(str2);
                }
                sb2.append("</style><body id=\"iaBody\">");
                if (j0Var.B) {
                    if (zA) {
                        sb2.append("<link rel=\"stylesheet\" href=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css\">");
                    } else {
                        sb2.append("<link rel=\"stylesheet\" href=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css\">");
                    }
                    if (zA) {
                        sb2.append("<script src=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js\"></script>");
                    } else {
                        sb2.append("<script src=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js\"></script>");
                    }
                }
                strB = AbstractC3251o.b("ia_mraid_bridge.txt");
                if (!TextUtils.isEmpty(strB)) {
                    sb2.append("<div id='iaScriptBr' style='display:none;'>");
                    sb2.append(strB);
                    sb2.append("</div>");
                    if (IAlog.f2345a >= 2) {
                        sb2.append("<script type=\"text/javascript\">window.mraidbridge.loggingEnabled = true;</script>");
                    }
                }
                sb2.append(string2);
                sb2.append("</body></html>");
                if (j0Var.H != null) {
                    xVar = j0Var.s;
                    if (xVar == null) {
                        eVarC = xVar.c();
                        if (eVarC != null) {
                            z = true;
                        }
                        eVar = j0Var.H;
                        string = sb2.toString();
                        if (z) {
                            sb = new StringBuilder();
                            if (!TextUtils.isEmpty(eVar.c)) {
                                sb.append(eVar.c);
                            }
                            if (!TextUtils.isEmpty(eVar.d)) {
                                sb.append(eVar.d);
                            }
                            string = ScriptInjector.injectScriptContentIntoHtml(sb.toString(), string);
                        }
                        if (TextUtils.isEmpty(eVar.b)) {
                            string2 = ScriptInjector.injectScriptContentIntoHtml(eVar.b, string);
                        } else {
                            string2 = string;
                        }
                    }
                } else {
                    string2 = sb2.toString();
                }
            }
            string2 = null;
        }
        AbstractC3270i abstractC3270i2 = c3266e.l;
        abstractC3270i2.getClass();
        IAlog.a("%sbuild html string took %d msec", IAlog.a(abstractC3270i2), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        C3266e c3266e2 = this.b;
        if (c3266e2.f) {
            return;
        }
        c3266e2.c = new RunnableC3241e(c3266e2, string2);
        c3266e2.a().post(this.b.c);
    }
}
