package com.ogury.ad.interstitial.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.json.b9;
import com.ogury.ad.internal.a2;
import com.ogury.ad.internal.b2;
import com.ogury.ad.internal.b3;
import com.ogury.ad.internal.c3;
import com.ogury.ad.internal.f1;
import com.ogury.ad.internal.h;
import com.ogury.ad.internal.j4;
import com.ogury.ad.internal.o;
import com.ogury.ad.internal.q;
import com.ogury.ad.internal.r;
import com.ogury.ad.internal.u2;
import com.ogury.ad.internal.v2;
import com.ogury.ad.internal.y2;
import com.ogury.ad.internal.z1;
import com.ogury.ad.internal.z2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterstitialActivity f7478a;
    public final h b;
    public final j4 c;

    public /* synthetic */ a(InterstitialActivity interstitialActivity, Intent intent, com.ogury.ad.internal.c cVar, List list) {
        this(interstitialActivity, intent, cVar, list, u2.f7410a, a2.f7257a);
    }

    public final j4 a() {
        j4 j4Var = this.c;
        if (j4Var != null) {
            return j4Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adController");
        return null;
    }

    public final h b() {
        h hVar = this.b;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adLayout");
        return null;
    }

    public a(InterstitialActivity activity, Intent intent, com.ogury.ad.internal.c ad, List<com.ogury.ad.internal.c> ads, u2 adControllerFactory, a2 expandCacheStore) {
        r rVar;
        v2 v2Var;
        j4 j4Var;
        j4 j4Var2;
        j4 j4Var3;
        j4 j4Var4;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(ads, "ads");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(expandCacheStore, "expandCacheStore");
        this.f7478a = activity;
        int intExtra = intent.getIntExtra(b9.a.t, 0);
        j4 j4Var5 = null;
        if (intExtra == 0) {
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            h adLayout = new h(applicationContext);
            this.b = adLayout;
            o oVar = ad.x;
            InterstitialActivity.a aVar = InterstitialActivity.d;
            b2 expandToInterstitialViewCommand = new b2(oVar);
            adControllerFactory.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(adLayout, "adLayout");
            Intrinsics.checkNotNullParameter(expandToInterstitialViewCommand, "expandToInterstitialViewCommand");
            Application application = activity.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            j4 j4Var6 = new j4(new j4.a(application, adLayout, expandToInterstitialViewCommand, true));
            this.c = j4Var6;
            j4Var6.C = new c();
            boolean z = ad.m.f7395a;
            String str = ad.n.f7379a;
            Application application2 = activity.getApplication();
            Intrinsics.checkNotNullExpressionValue(application2, "getApplication(...)");
            c3 c3Var = new c3(new v2(application2), activity, new f1(), z, str);
            Intrinsics.checkNotNullParameter(c3Var, "<set-?>");
            j4Var6.B = c3Var;
            z2 z2Var = new z2(this);
            Intrinsics.checkNotNullParameter(z2Var, "<set-?>");
            j4Var6.E = z2Var;
            j4Var6.a(ad, ads);
        } else if (intExtra == 1) {
            String stringExtra = intent.getStringExtra("expand_cache_item_id");
            expandCacheStore.getClass();
            z1 z1Var = (z1) TypeIntrinsics.asMutableMap(a2.b).remove(stringExtra);
            if (z1Var != null) {
                h hVar = z1Var.c;
                this.b = hVar;
                j4 j4Var7 = z1Var.d;
                this.c = j4Var7;
                if (q.a(ad)) {
                    Application application3 = activity.getApplication();
                    Intrinsics.checkNotNullExpressionValue(application3, "getApplication(...)");
                    v2Var = new v2(application3);
                } else {
                    v2Var = null;
                }
                if (z1Var.f7458a.c()) {
                    if (j4Var7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adController");
                        j4Var3 = null;
                    } else {
                        j4Var3 = j4Var7;
                    }
                    FrameLayout frameLayout = z1Var.b;
                    if (j4Var7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adController");
                        j4Var4 = null;
                    } else {
                        j4Var4 = j4Var7;
                    }
                    b3 b3Var = new b3(frameLayout, activity, j4Var4.D);
                    j4Var3.getClass();
                    Intrinsics.checkNotNullParameter(b3Var, "<set-?>");
                    j4Var3.B = b3Var;
                } else {
                    if (j4Var7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adController");
                        j4Var = null;
                    } else {
                        j4Var = j4Var7;
                    }
                    if (j4Var7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adController");
                        j4Var2 = null;
                    } else {
                        j4Var2 = j4Var7;
                    }
                    c3 c3Var2 = new c3(v2Var, activity, j4Var2.D, ad.m.f7395a, ad.n.f7379a);
                    j4Var.getClass();
                    Intrinsics.checkNotNullParameter(c3Var2, "<set-?>");
                    j4Var.B = c3Var2;
                }
                if (j4Var7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adController");
                    j4Var7 = null;
                }
                z2 z2Var2 = new z2(this);
                j4Var7.getClass();
                Intrinsics.checkNotNullParameter(z2Var2, "<set-?>");
                j4Var7.E = z2Var2;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adLayout");
                    hVar = null;
                }
                hVar.c();
            } else {
                throw new IllegalStateException("Cache Item not found".toString());
            }
        } else {
            throw new IllegalStateException(("Wrong mode " + intExtra).toString());
        }
        if (q.a(ad)) {
            rVar = null;
        } else {
            j4 j4Var8 = this.c;
            if (j4Var8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adController");
                j4Var8 = null;
            }
            rVar = j4Var8.D;
        }
        j4 j4Var9 = this.c;
        if (j4Var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adController");
        } else {
            j4Var5 = j4Var9;
        }
        y2 y2Var = new y2(rVar, this);
        j4Var5.getClass();
        Intrinsics.checkNotNullParameter(y2Var, "<set-?>");
        j4Var5.D = y2Var;
    }
}
