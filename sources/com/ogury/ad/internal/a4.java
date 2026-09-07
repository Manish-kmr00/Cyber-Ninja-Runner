package com.ogury.ad.internal;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x5 f7258a;
    public final g1 b;
    public final Context c;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public a(Object obj) {
            super(1, obj, u3.class, "e", "e(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable p0 = th;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((u3) this.receiver).getClass();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public b(Object obj) {
            super(1, obj, u3.class, "e", "e(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable p0 = th;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((u3) this.receiver).getClass();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public c(Object obj) {
            super(1, obj, u3.class, "e", "e(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable p0 = th;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((u3) this.receiver).getClass();
            return Unit.INSTANCE;
        }
    }

    public a4(x5 x5Var, g1 g1Var, Context context) {
        this.f7258a = x5Var;
        this.b = g1Var;
        this.c = context;
    }

    public static final Unit b() {
        return Unit.INSTANCE;
    }

    public static final Unit c() {
        return Unit.INSTANCE;
    }

    public final void a(h9 h9Var) throws JSONException {
        com.ogury.ad.internal.c cVar = h9Var.b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", h9Var.f7448a);
        jSONObject.put("campaign", cVar.g);
        jSONObject.put(com.ironsource.b9.h.F0, cVar.f);
        jSONObject.put("advert", cVar.b);
        jSONObject.put("ad_unit_id", cVar.n.f7379a);
        String versionName = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0).versionName;
        Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
        jSONObject.put("version_publisher_app", versionName);
        JSONObject jSONObjectA = this.b.a();
        jSONObjectA.put("content", jSONObject);
        h1 h1VarC = this.f7258a.c(h9Var.b.C, jSONObjectA);
        c consumer = new c(u3.f7411a);
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        h1VarC.c = consumer;
        h1VarC.b(new Function0() { // from class: com.ogury.ad.internal.a4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a4.c();
            }
        });
    }

    public final void a(f fVar) throws JSONException {
        com.ogury.ad.internal.c cVar = fVar.b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("campaign_id", cVar.g);
        jSONObject.put("advert_id", cVar.b);
        jSONObject.put("advertiser_id", cVar.f);
        jSONObject.put("ad_unit_id", cVar.n.f7379a);
        jSONObject.put("url", fVar.c);
        jSONObject.put("source", fVar.d);
        String str = fVar.e;
        if (str != null) {
            jSONObject.put("tracker_pattern", str);
        }
        String str2 = fVar.f;
        if (str2 != null) {
            jSONObject.put("tracker_url", str2);
        }
        JSONObject jSONObjectA = this.b.a();
        jSONObjectA.put("content", jSONObject);
        h1 h1VarB = this.f7258a.b(fVar.b.E, jSONObjectA);
        a consumer = new a(u3.f7411a);
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        h1VarB.c = consumer;
        h1VarB.b(new Function0() { // from class: com.ogury.ad.internal.a4$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a4.a();
            }
        });
    }

    public final void a(k7 k7Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", k7Var.f7448a);
        jSONObject.put("timestamp_diff", 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("content", jSONObject);
        h1 h1VarA = this.f7258a.a(k7Var.b, jSONObject2);
        b consumer = new b(u3.f7411a);
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        h1VarA.c = consumer;
        h1VarA.b(new Function0() { // from class: com.ogury.ad.internal.a4$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a4.b();
            }
        });
    }

    public static final Unit a() {
        return Unit.INSTANCE;
    }
}
