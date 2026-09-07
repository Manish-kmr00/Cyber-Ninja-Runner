package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.facebook.login.LoginLogger;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class hh1 implements n82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s62 f9096a;
    private final n62 b;
    private final zp1 c;
    private final l82 d;
    private final Context e;

    @Override // com.yandex.mobile.ads.impl.n82
    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strA = this.d.a(url);
        int i = iw1.l;
        gh1 request = new gh1(this.e, strA, new a(url, iw1.a.a().a(this.e), this.b, this.f9096a));
        zp1 zp1Var = this.c;
        Context context = this.e;
        synchronized (zp1Var) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(request, "request");
            dd1.a(context).a(request);
        }
    }

    public /* synthetic */ hh1(Context context, o3 o3Var, s62 s62Var) {
        n62 n62Var = new n62(context, o3Var);
        int i = zp1.c;
        this(context, o3Var, s62Var, n62Var, zp1.a.a(), new l82(context));
    }

    public hh1(Context context, o3 adConfiguration, s62 trackingUrlType, n62 trackingReporter, zp1 requestManager, l82 urlModifier) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(trackingUrlType, "trackingUrlType");
        Intrinsics.checkNotNullParameter(trackingReporter, "trackingReporter");
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        Intrinsics.checkNotNullParameter(urlModifier, "urlModifier");
        this.f9096a = trackingUrlType;
        this.b = trackingReporter;
        this.c = requestManager;
        this.d = urlModifier;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.e = applicationContext;
    }

    private static final class a implements pk.a<tc1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9097a;
        private final cu1 b;
        private final n62 c;
        private final s62 d;

        public a(String trackingUrl, cu1 cu1Var, n62 trackingReporter, s62 trackingUrlType) {
            Intrinsics.checkNotNullParameter(trackingUrl, "trackingUrl");
            Intrinsics.checkNotNullParameter(trackingReporter, "trackingReporter");
            Intrinsics.checkNotNullParameter(trackingUrlType, "trackingUrlType");
            this.f9097a = trackingUrl;
            this.b = cu1Var;
            this.c = trackingReporter;
            this.d = trackingUrlType;
        }

        @Override // com.yandex.mobile.ads.impl.qq1.a
        public final void a(ki2 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            Object[] args = {this.f9097a, error.toString()};
            int i = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("tracking_result", LoginLogger.EVENT_EXTRAS_FAILURE);
            String lowerCase = this.d.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            pairArr[1] = TuplesKt.to("tracking_url_type", lowerCase);
            String message = error.getMessage();
            if (message == null) {
                message = "Unknown Volley error";
            }
            pairArr[2] = TuplesKt.to("error_message", message);
            Map mapMutableMapOf = MapsKt.mutableMapOf(pairArr);
            n62 n62Var = this.c;
            hp1.b bVar = hp1.b.c;
            n62Var.a(mapMutableMapOf, this.b);
        }

        @Override // com.yandex.mobile.ads.impl.qq1.b
        public final void a(Object obj) {
            tc1 response = (tc1) obj;
            Intrinsics.checkNotNullParameter(response, "response");
            int i = response.f10286a;
            Object[] args = {this.f9097a, Integer.valueOf(i)};
            int i2 = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            Pair pair = TuplesKt.to("tracking_result", "success");
            String lowerCase = this.d.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Map mapMutableMapOf = MapsKt.mutableMapOf(pair, TuplesKt.to("tracking_url_type", lowerCase), TuplesKt.to("code", Integer.valueOf(i)));
            n62 n62Var = this.c;
            hp1.b bVar = hp1.b.c;
            n62Var.a(mapMutableMapOf, this.b);
        }
    }
}
