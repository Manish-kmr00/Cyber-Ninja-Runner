package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.h0;
import com.fyber.inneractive.sdk.util.H;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.W;
import com.json.cc;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.net.URLDecoder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1664a;
    public String b;
    public final boolean c;
    public o d;
    public h0 h;
    public W j;
    public boolean k;
    public com.fyber.inneractive.sdk.ignite.m l;
    public volatile boolean e = false;
    public long g = 0;
    public final ArrayList i = new ArrayList();
    public final ArrayList f = new ArrayList();
    public final boolean m = IAConfigManager.O.u.b.a(false, "should_decode_url");

    public r(boolean z) {
        this.c = true;
        this.c = z;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.p);
        p0.startActivity(p1);
    }

    public final void a(Context context, String str, o oVar, W w, boolean z, com.fyber.inneractive.sdk.ignite.m mVar, String str2) {
        Uri uri;
        this.f1664a = context;
        this.b = str;
        this.d = oVar;
        this.k = z;
        this.g = System.currentTimeMillis();
        this.j = w;
        this.l = mVar;
        b bVarA = a(this.b);
        IAlog.d("%s EVENT_CLICK %s %s", "VAST_EVENT", bVarA, str);
        if (bVarA == null) {
            String str3 = this.b;
            try {
                try {
                    if (this.m) {
                        uri = !H.c(str3) ? Uri.parse(URLDecoder.decode(str3, cc.N)) : Uri.parse(str3);
                    } else {
                        uri = H.c(str3) ? Uri.parse(URLDecoder.decode(str3, cc.N)) : Uri.parse(str3);
                    }
                } catch (Exception unused) {
                    IAlog.a("%sgetDecodedUri: Failed parsing Uri!", "SuperClickHandler");
                    uri = null;
                }
                if (a(uri)) {
                    IAlog.a("%sfollowRedirects: Fetching uri: %s", IAlog.a(this), uri.toString());
                    String string = uri.toString();
                    h0 h0Var = new h0(new m(this, string, str2), string);
                    this.h = h0Var;
                    IAConfigManager.O.s.b(h0Var);
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    return;
                }
                IAlog.b("%sfailed followRedirects %s", IAlog.a(this), e);
                this.f.add(new j(str3, false, q.INTERNAL_REDIRECT, null));
                a(new b(str3, q.FAILED, "followRedirects", e));
            }
        }
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            IAlog.a("%s followRedirects: Got a url which is not valid: null", IAlog.a(this));
            this.f.add(new j(null, false, null, "Invalid url"));
            a(a(uri.toString(), "followRedirects", "Invalid url"));
            return false;
        }
        String scheme = uri.getScheme();
        if (scheme != null && (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https"))) {
            return true;
        }
        IAlog.a("%scould not follow redirects for scheme: %s", IAlog.a(this), uri.getScheme());
        IAlog.a("%sfull url: %s", IAlog.a(this), uri.toString());
        this.f.add(new j(uri.toString(), false, null, "Invalid scheme: " + uri.getScheme()));
        a(a(uri.toString(), "followRedirects", "Invalid scheme: " + uri.getScheme()));
        return false;
    }

    public final b a(String str) {
        Uri uri;
        try {
            uri = Uri.parse(str);
        } catch (Exception unused) {
            IAlog.a("IAJavaUtil: getValidUri: Invalid url %s", str);
            uri = null;
        }
        if (uri == null) {
            this.f.add(new j(str, false, null, "illegal uri"));
            return a(a(str, null, "illegal uri"));
        }
        if (this.i.isEmpty()) {
            this.f.add(new j(str, false, null, "no click handlers found"));
            return a(a(str, null, "no click handlers found"));
        }
        for (a aVar : this.i) {
            if (aVar.a(uri, this)) {
                Context context = this.f1664a;
                b bVarA = context != null ? aVar.a(context, uri, this.f) : null;
                if (bVarA != null) {
                    return a(bVarA);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Throwable] */
    public static void a(r rVar, String str, String str2, String str3, Exception exc) {
        String message;
        if (rVar.c) {
            Intent intent = new Intent(rVar.f1664a, (Class<?>) InneractiveInternalBrowserActivity.class);
            if (!TextUtils.isEmpty(str)) {
                InneractiveInternalBrowserActivity.setHtmlExtra(str);
            }
            intent.putExtra("extra_url", str2);
            intent.putExtra("spotId", str3);
            if (!(rVar.f1664a instanceof Activity)) {
                intent.setFlags(268435456);
            }
            try {
                Context context = rVar.f1664a;
                if (context != null) {
                    safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                }
                ArrayList arrayList = rVar.f;
                boolean z = exc == 0;
                q qVar = q.OPENED_IN_INTERNAL_BROWSER;
                if (exc == 0) {
                    message = null;
                } else {
                    do {
                        message = exc.getMessage();
                        exc = exc.getCause();
                    } while (exc != 0);
                }
                arrayList.add(new j(str2, z, qVar, message));
                rVar.a(new b(str2, qVar, "followRedirects", null));
                return;
            } catch (ActivityNotFoundException unused) {
                rVar.f.add(new j(str2, false, q.OPENED_IN_INTERNAL_BROWSER, "internal browser not registered"));
                rVar.a(a(str2, "followRedirects", "internal browser not registered"));
                return;
            }
        }
        rVar.f.add(new j(str2, false, q.OPENED_IN_INTERNAL_BROWSER, "internal browser not usable"));
        rVar.a(a(str2, "followRedirects", "internal browser not usable"));
    }

    public static b a(String str, String str2, String str3) {
        return new b(str, q.FAILED, str2, new p(str3));
    }

    public final b a(b bVar) {
        ArrayList arrayList = this.f;
        bVar.f.clear();
        bVar.f.addAll(arrayList);
        bVar.e = System.currentTimeMillis() - this.g;
        IAlog.a("%s reporting result: %s", IAlog.a(this), bVar);
        com.fyber.inneractive.sdk.util.r.b.post(new n(this, bVar));
        return bVar;
    }
}
