package com.ogury.ad.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.ogury.ad.common.OguryMediation;
import com.ogury.ad.interstitial.ui.InterstitialActivity;
import com.ogury.core.internal.IntegrationLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes13.dex */
public final class s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7399a;
    public final p6 b;
    public final y c;
    public final u7 d;
    public final a8 e;
    public final b8 f;
    public final e7.a g;
    public final OguryMediation h;
    public s i;
    public o6 j;
    public x k;

    public static final class a implements q8 {
        public final /* synthetic */ Activity b;
        public final /* synthetic */ d7 c;

        public a(Activity activity, d7 d7Var) {
            this.b = activity;
            this.c = d7Var;
        }

        @Override // com.ogury.ad.internal.q8
        public final void a(Context context, List<c> ads) {
            Object next;
            r6 overlayAdResponse;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ads, "ads");
            s6.this.getClass();
            Iterator<T> it = ads.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((c) next).v);
            c cVar = (c) next;
            if (cVar == null || (overlayAdResponse = cVar.m) == null) {
                overlayAdResponse = new r6();
            }
            e7.a aVar = s6.this.g;
            Activity activity = this.b;
            aVar.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            g7 overlayScreenArea = new g7(activity);
            Intrinsics.checkNotNullParameter(overlayScreenArea, "overlayScreenArea");
            d7 overlayPosition = this.c;
            Intrinsics.checkNotNullParameter(overlayPosition, "overlayPosition");
            Intrinsics.checkNotNullParameter(overlayAdResponse, "overlayAdResponse");
            int i = overlayPosition.f7282a;
            int iB = (i == 0 || i == 2) ? overlayPosition.b : j7.b((overlayScreenArea.f7307a.getMeasuredWidth() - j7.a(overlayPosition.b)) - overlayAdResponse.b);
            d7 overlayPosition2 = this.c;
            Intrinsics.checkNotNullParameter(overlayPosition2, "overlayPosition");
            Intrinsics.checkNotNullParameter(overlayAdResponse, "overlayAdResponse");
            int i2 = overlayPosition2.f7282a;
            int iB2 = (i2 == 0 || i2 == 1) ? overlayPosition2.c : j7.b((overlayScreenArea.f7307a.getMeasuredHeight() - j7.a(overlayPosition2.c)) - overlayAdResponse.c);
            o6 o6Var = s6.this.j;
            if (o6Var != null) {
                Activity activity2 = this.b;
                Intrinsics.checkNotNullParameter(activity2, "activity");
                Intrinsics.checkNotNullParameter(ads, "ads");
                o6Var.j = activity2;
                try {
                    c cVarRemove = ads.remove(0);
                    q5.a(ads);
                    o6Var.i.d = j7.a(iB);
                    o6Var.i.e = j7.a(iB2);
                    if (cVarRemove.v) {
                        o6Var.c.a(o6Var.f7374a, cVarRemove, new ArrayList());
                        if (!ads.isEmpty()) {
                            o6Var.a(ads.remove(0), ads, activity2, false);
                        }
                    } else {
                        o6Var.a(cVarRemove, ads, activity2, true);
                    }
                } catch (Throwable unused) {
                    u3.f7411a.getClass();
                    o6Var.a();
                }
            }
        }
    }

    public s6(Context context, d adConfig, OguryMediation oguryMediation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        InterstitialActivity.a aVar = InterstitialActivity.d;
        p6 adControllerFactory = new p6();
        y adsSourceFactory = new y(context, adConfig, o.OVERLAY_THUMBNAIL);
        u7 profigHandler = u7.i.a(context);
        a8 publisherActivityFilter = new a8();
        b8 publisherFragmentFilter = new b8();
        e7.a positionCalculatorFactory = e7.f7291a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(adsSourceFactory, "adsSourceFactory");
        Intrinsics.checkNotNullParameter(profigHandler, "profigHandler");
        Intrinsics.checkNotNullParameter(publisherActivityFilter, "publisherActivityFilter");
        Intrinsics.checkNotNullParameter(publisherFragmentFilter, "publisherFragmentFilter");
        Intrinsics.checkNotNullParameter(positionCalculatorFactory, "positionCalculatorFactory");
        this.f7399a = context;
        this.b = adControllerFactory;
        this.c = adsSourceFactory;
        this.d = profigHandler;
        this.e = publisherActivityFilter;
        this.f = publisherFragmentFilter;
        this.g = positionCalculatorFactory;
        this.h = oguryMediation;
    }

    public static final Unit a(s6 s6Var, z7.e it) throws JSONException {
        Intrinsics.checkNotNullParameter(it, "it");
        s6Var.a(it.d, it.e);
        return Unit.INSTANCE;
    }

    public final void b() {
        a().b(new Function1() { // from class: com.ogury.ad.internal.s6$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return s6.a(this.f$0, (z7.e) obj);
            }
        });
    }

    public final void a(int i, int i2) throws JSONException {
        x xVar = this.k;
        if (xVar != null && xVar.r) {
            o6 o6Var = this.j;
            if (o6Var != null) {
                o6Var.a();
            }
            x xVar2 = this.k;
            if (xVar2 != null) {
                xVar2.b();
            }
        }
        x xVar3 = this.k;
        if (xVar3 != null && xVar3.q) {
            xVar3.g();
        }
        p6 p6Var = this.b;
        Context applicationContext = this.f7399a.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        a8 publisherActivityFilter = this.e;
        b8 publisherFragmentFilter = this.f;
        p6Var.getClass();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(publisherActivityFilter, "publisherActivityFilter");
        Intrinsics.checkNotNullParameter(publisherFragmentFilter, "publisherFragmentFilter");
        a7 a7Var = new a7(publisherActivityFilter, publisherFragmentFilter, y8.f7455a, t7.f7405a);
        InterstitialActivity.a aVar = InterstitialActivity.d;
        this.j = new o6(application, a7Var);
        y yVar = this.c;
        x xVar4 = this.k;
        boolean z = xVar4 != null && xVar4.o;
        OguryMediation oguryMediation = this.h;
        Context context = yVar.f7444a;
        yVar.d.getClass();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        x xVar5 = new x(context, string, oguryMediation, yVar.b, yVar.c, z);
        this.k = xVar5;
        xVar5.t = this.i;
        xVar5.w = new n6(i, i2);
        xVar5.a((String) null);
    }

    public final void a(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a().b(new Function1() { // from class: com.ogury.ad.internal.s6$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return s6.a(this.f$0, activity, (z7.e) obj);
            }
        });
    }

    public static final Unit a(s6 s6Var, Activity activity, z7.e it) {
        Intrinsics.checkNotNullParameter(it, "it");
        s6Var.a(activity, new d7(it.f7467a, it.b, it.c));
        return Unit.INSTANCE;
    }

    public final v8<z7.e> a() {
        Function0 callable = new Function0() { // from class: com.ogury.ad.internal.s6$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return s6.a(this.f$0);
            }
        };
        Intrinsics.checkNotNullParameter(callable, "callable");
        return new v8<>(callable, 0);
    }

    public static final z7.e a(s6 s6Var) {
        return s6Var.d.b().d.f.f7472a;
    }

    public final void a(Activity activity, d7 overlayPosition) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(overlayPosition, "overlayPosition");
        if (this.k == null) {
            IntegrationLogger.e("[Ads][Thumbnail][show] Failed to show (no ad loaded)");
            s sVar = this.i;
            if (sVar != null) {
                sVar.e();
            }
        }
        x xVar = this.k;
        if (xVar != null) {
            xVar.a(new a(activity, overlayPosition));
        }
    }
}
