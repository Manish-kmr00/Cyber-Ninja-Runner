package com.five_corp.ad.internal.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import android.util.Patterns;
import androidx.browser.customtabs.CustomTabsIntent;
import com.five_corp.ad.AdReportDialogActivity;
import com.five_corp.ad.internal.E;
import com.five_corp.ad.internal.view.C3045c;
import com.five_corp.ad.internal.view.C3047e;
import com.five_corp.ad.internal.view.I;
import com.five_corp.ad.internal.view.InterfaceC3043a;
import com.five_corp.ad.internal.view.InterfaceC3044b;
import com.five_corp.ad.internal.view.J;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1304a;
    public final com.five_corp.ad.internal.context.h b;
    public final j c;
    public final String d;
    public final E e;
    public final com.five_corp.ad.f f;

    public k(Context context, com.five_corp.ad.internal.context.h hVar, j jVar, String str, E e, com.five_corp.ad.f fVar) {
        this.f1304a = context;
        this.b = hVar;
        this.c = jVar;
        this.d = str;
        this.e = e;
        this.f = fVar;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "com.five_corp.ad");
        p0.startActivity(p1);
    }

    public static void safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(CustomTabsIntent p0, Context p1, Uri p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroidx/browser/customtabs/CustomTabsIntent;->launchUrl(Landroid/content/Context;Landroid/net/Uri;)V");
        if (p2 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p2, "com.five_corp.ad");
        p0.launchUrl(p1, p2);
    }

    public final Runnable a(final AdReportDialogActivity adReportDialogActivity, final I i, final h hVar, final String str) {
        int iA = com.five_corp.ad.e.a(hVar.b);
        if (iA == 0) {
            return new Runnable() { // from class: com.five_corp.ad.internal.ad.k$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(i);
                }
            };
        }
        if (iA == 1) {
            return new Runnable() { // from class: com.five_corp.ad.internal.ad.k$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(adReportDialogActivity, i, str);
                }
            };
        }
        if (iA == 2) {
            return new Runnable() { // from class: com.five_corp.ad.internal.ad.k$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(hVar, i);
                }
            };
        }
        throw new RuntimeException();
    }

    public final void b(final String str) {
        Objects.requireNonNull(this.c, "informationIconConfig cannot be null");
        final ArrayList arrayList = this.c.f1303a.b;
        Objects.requireNonNull(arrayList, "Parser validates, so choiceConfigList cannot be null");
        Context context = this.f1304a;
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.INTERSTITIAL;
        com.five_corp.ad.internal.context.h hVar2 = this.b;
        boolean z = hVar == hVar2 || com.five_corp.ad.internal.context.h.VIDEO_REWARD == hVar2;
        com.five_corp.ad.internal.ad_report.c cVar = new com.five_corp.ad.internal.ad_report.c() { // from class: com.five_corp.ad.internal.ad.k$$ExternalSyntheticLambda5
            @Override // com.five_corp.ad.internal.ad_report.c
            public final void a(AdReportDialogActivity adReportDialogActivity) {
                this.f$0.a(arrayList, str, adReportDialogActivity);
            }
        };
        com.five_corp.ad.internal.ad_report.b bVar = new com.five_corp.ad.internal.ad_report.b() { // from class: com.five_corp.ad.internal.ad.k$$ExternalSyntheticLambda6
            @Override // com.five_corp.ad.internal.ad_report.b
            public final void a() {
                this.f$0.a();
            }
        };
        if (com.five_corp.ad.internal.ad_report.d.f1315a == null) {
            com.five_corp.ad.internal.ad_report.d.f1315a = new com.five_corp.ad.internal.ad_report.a();
        }
        com.five_corp.ad.internal.ad_report.a aVar = com.five_corp.ad.internal.ad_report.d.f1315a;
        if (aVar.b != null) {
            return;
        }
        aVar.f1314a = cVar;
        aVar.b = bVar;
        try {
            Intent intent = new Intent(context, (Class<?>) AdReportDialogActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(65536);
            intent.putExtra(AdReportDialogActivity.EXTRA_IS_FULLSCREEN, z);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
            if (Build.VERSION.SDK_INT >= 34 || !(context instanceof Activity)) {
                return;
            }
            ((Activity) context).overridePendingTransition(0, 0);
        } catch (Exception unused) {
            bVar.a();
            aVar.f1314a = null;
            aVar.b = null;
        }
    }

    public final void a(I i) {
        a(this.d);
        i.a();
    }

    public final void a(Activity activity, I i, String str) {
        Objects.requireNonNull(this.c, "informationIconConfig cannot be null");
        if (str != null && Patterns.WEB_URL.matcher(str).matches()) {
            safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(new CustomTabsIntent.Builder().build(), activity, Uri.parse(str));
        }
        C3047e c3047e = this.c.b.f1305a != null ? new C3047e(this.f1304a, this.c.b.f1305a) : null;
        com.five_corp.ad.f fVar = this.f;
        com.five_corp.ad.internal.view.l lVar = fVar.c;
        if (lVar != null) {
            J.a(lVar.b.f1416a);
            if (c3047e != null) {
                lVar.addView(c3047e);
            }
        } else {
            com.five_corp.ad.internal.fullscreen.c cVar = fVar.v;
            if (cVar != null && cVar != null) {
                int currentPositionMs = fVar.h.getCurrentPositionMs();
                fVar.a(currentPositionMs);
                com.five_corp.ad.internal.fullscreen.c cVar2 = fVar.v;
                if (!cVar2.m.getAndSet(true)) {
                    cVar2.g.removeAllViews();
                    cVar2.k = null;
                    cVar2.l = null;
                    cVar2.f1377a.finish();
                }
                fVar.v = null;
                fVar.o.l(currentPositionMs, fVar.t);
            }
        }
        i.a();
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(List list, String str, AdReportDialogActivity adReportDialogActivity) {
        final I i = new I(adReportDialogActivity);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            arrayList.add(new Pair(hVar.f1302a, a(adReportDialogActivity, i, hVar, str)));
        }
        final E e = this.e;
        Objects.requireNonNull(e);
        i.a(new C3045c(adReportDialogActivity, arrayList, new InterfaceC3043a() { // from class: com.five_corp.ad.internal.ad.k$$ExternalSyntheticLambda0
            @Override // com.five_corp.ad.internal.view.InterfaceC3043a
            public final int a(int i2) {
                return e.a(i2);
            }
        }, new InterfaceC3044b() { // from class: com.five_corp.ad.internal.ad.k$$ExternalSyntheticLambda1
            @Override // com.five_corp.ad.internal.view.InterfaceC3044b
            public final void a() {
                i.a();
            }
        }));
    }

    public final void a(h hVar, I i) {
        a(hVar.c);
        i.a();
    }

    public final /* synthetic */ void a() {
        a(this.d);
    }

    public final void a(String str) {
        if (str == null) {
            return;
        }
        this.f.b(str);
    }
}
