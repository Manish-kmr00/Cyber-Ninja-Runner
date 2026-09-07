package com.five_corp.ad.internal.handler;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.five_corp.ad.e;
import com.five_corp.ad.internal.ad.r;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.w;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1378a;
    public final w b;
    public final r c;
    public final com.five_corp.ad.internal.logger.a d;

    public a(Context context, w wVar, r rVar, com.five_corp.ad.internal.logger.a aVar) {
        this.f1378a = context;
        this.b = wVar;
        this.c = rVar;
        this.d = aVar;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "com.five_corp.ad");
        p0.startActivity(p1);
    }

    public final void a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.f1378a, intent);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00a3  */
    public final void a(int i, double d) {
        String strA;
        this.b.d();
        int iA = e.a(this.c.f1309a);
        if (iA != 0) {
            if (iA == 1) {
                this.d.a("REDIRECT_IN_WEBVIEW feature is no more supported.", 4);
                w wVar = this.b;
                a(wVar.d.a(wVar.a(i, d, false)));
            } else if (iA == 2) {
                w wVar2 = this.b;
                wVar2.c.a(wVar2.a(i, d, true));
            } else if (iA == 3) {
                String str = this.c.d;
                if (str == null) {
                    w wVar3 = this.b;
                    strA = wVar3.d.a(wVar3.a(i, d, false));
                } else {
                    w wVar4 = this.b;
                    long j = i;
                    wVar4.c.a(wVar4.a(j, d, true));
                    try {
                        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.f1378a, Intent.parseUri(str, 1));
                    } catch (Exception e) {
                        com.five_corp.ad.internal.logger.a aVar = this.d;
                        p pVar = p.d;
                        aVar.a("DetailedErrorCode: AD_CONTROLLER_FAIL_TO_OPEN_APP_URL, information: " + String.valueOf("failed to open appUrl: " + str + ", fallback to redirect in browser...") + ", exception: " + Log.getStackTraceString(e) + ", cause: null", 5);
                        w wVar5 = this.b;
                        strA = wVar5.d.a(wVar5.a(j, d, false));
                        a(strA);
                    }
                }
                a(strA);
            } else if (iA == 4) {
                w wVar6 = this.b;
                wVar6.c.a(wVar6.a(i, d, true));
            }
        } else if (this.c.b != null) {
            w wVar7 = this.b;
            long j2 = i;
            wVar7.c.a(wVar7.a(j2, d, true));
            try {
                a(this.c.b);
            } catch (ActivityNotFoundException e2) {
                if (this.c.c == null) {
                    throw e2;
                }
                this.b.a(21, j2, d, null, null);
                a(this.c.c);
            }
        } else {
            w wVar8 = this.b;
            a(wVar8.d.a(wVar8.a(i, d, false)));
        }
        this.b.c();
    }
}
