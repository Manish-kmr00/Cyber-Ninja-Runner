package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.util.D;
import com.fyber.inneractive.sdk.util.E;
import com.fyber.inneractive.sdk.util.F;
import com.fyber.inneractive.sdk.util.G;
import com.fyber.inneractive.sdk.util.H;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1659a;
    public final boolean b;
    public boolean c = false;

    public i(boolean z, String str) {
        this.f1659a = str;
        this.b = z;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.p);
        p0.startActivity(p1);
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        return !this.c && ("fybernativebrowser".equalsIgnoreCase(uri.getScheme()) || "fybernativebrowser".equalsIgnoreCase(this.f1659a) || this.b || uri.toString().contains("FYBER_OPEN_BROWSER"));
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.c = true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    @Override // com.fyber.inneractive.sdk.click.a
    public final b a(Context context, Uri uri, List list) {
        String queryParameter;
        D d;
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            queryParameter = null;
        } else {
            Uri uri2 = Uri.parse(string);
            String scheme = uri2.getScheme();
            String host = uri2.getHost();
            if (scheme == null || !scheme.equals("fybernativebrowser") || host == null || !host.equals("navigate")) {
                queryParameter = null;
            } else {
                queryParameter = uri2.getQueryParameter("url");
            }
        }
        if (queryParameter != null) {
            try {
                uri = Uri.parse(queryParameter);
            } catch (Exception unused) {
                IAlog.a("IAJavaUtil: getValidUri: Invalid url %s", queryParameter);
                uri = null;
            }
            string = queryParameter;
        }
        if (this.c) {
            return r.a(uri.toString(), null, "The process was cancelled");
        }
        F f = F.OPEN_EVERYTHING;
        try {
            context.getClass();
        } catch (Throwable unused2) {
        }
        try {
            IAlog.a("IAJavaUtil - valid url found: '%s' opening browser", string);
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                d = new D(G.OPEN_IN_EXTERNAL_BROWSER, null);
            } catch (ActivityNotFoundException unused3) {
                if (H.a(context, string)) {
                    d = new D(G.OPENED_USING_CHROME_NAVIGATE, null);
                } else {
                    d = new D(G.FAILED, new E("tryOpeningChromeGracefully has failed and couldn't open the url"));
                }
            } catch (Throwable unused4) {
                if (!H.d(string) && !H.c(string) && f != F.DO_NOT_OPEN_IN_INTERNAL_BROWSER) {
                    Intent intent2 = new Intent(context, (Class<?>) InneractiveInternalBrowserActivity.class);
                    intent2.putExtra("extra_url", string);
                    intent2.putExtra("spotId", (String) null);
                    if (!(context instanceof Activity)) {
                        intent2.setFlags(268435456);
                    }
                    safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent2);
                    d = new D(G.OPENED_IN_INTERNAL_BROWSER, null);
                } else {
                    d = new D(G.FAILED, new E("canOpenInExternalBrowser has decided it cant be opened and shouldUseInternalBrowser was set to true"));
                }
            }
        } catch (Throwable th) {
            IAlog.a("IAJavaUtil - could not open a browser for url: %s", string);
            d = new D(G.FAILED, th);
        }
        if (list != null) {
            Throwable th2 = d.b;
            if (th2 != null) {
                list.add(new j(string, false, null, th2.toString()));
            } else {
                list.add(new j(string, true, q.OPENED_IN_EXTERNAL_BROWSER, null));
            }
        }
        return new b(uri.toString(), q.OPENED_IN_EXTERNAL_BROWSER, "FyberNativeBrowser", null);
    }
}
