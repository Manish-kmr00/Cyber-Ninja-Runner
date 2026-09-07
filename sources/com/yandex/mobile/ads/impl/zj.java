package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public abstract class zj<T> extends b62<o3, o8<T>> {
    private final o3 C;
    private final String D;
    private final yc1<T> E;
    private final lx1 F;
    private final o4 G;
    private final e8 H;
    private final Context I;
    private final fq1 J;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ zj(Context context, o3 o3Var, String str, String str2, yc1 yc1Var, xp1 xp1Var, pk.a aVar, eq1 eq1Var, lx1 lx1Var, int i) {
        lx1 lx1VarA;
        if ((i & 256) != 0) {
            lx1.f9575a.getClass();
            lx1VarA = lx1.a.a(context);
        } else {
            lx1VarA = lx1Var;
        }
        this(context, o3Var, str, str2, yc1Var, xp1Var, aVar, eq1Var, lx1VarA, new o4(), new e8());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zj(Context context, o3 adConfiguration, String url, String query, yc1<T> networkResponseParserCreator, xp1 xp1Var, pk.a<o8<T>> listener, eq1<o3, o8<T>> requestReporter, lx1 sessionStorage, o4 adIdHeaderProvider, e8 adRequestRetryPolicyCreator) {
        super(context, adConfiguration, 1, url, listener, adConfiguration, requestReporter, xp1Var, 1792);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(networkResponseParserCreator, "networkResponseParserCreator");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(requestReporter, "requestReporter");
        Intrinsics.checkNotNullParameter(sessionStorage, "sessionStorage");
        Intrinsics.checkNotNullParameter(adIdHeaderProvider, "adIdHeaderProvider");
        Intrinsics.checkNotNullParameter(adRequestRetryPolicyCreator, "adRequestRetryPolicyCreator");
        adConfiguration.k().getClass();
        this.C = adConfiguration;
        this.D = query;
        this.E = networkResponseParserCreator;
        this.F = sessionStorage;
        this.G = adIdHeaderProvider;
        this.H = adRequestRetryPolicyCreator;
        this.I = context.getApplicationContext();
        String str = "Loading data ... url: " + url + ", query: " + query;
        op0.e(new Object[0]);
        a(context);
        this.J = fq1.e;
    }

    @Override // com.yandex.mobile.ads.impl.pk
    protected final fq1 w() {
        return this.J;
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public Map<String, String> e() {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        String strA = this.F.a();
        if (strA != null) {
            String str = "Loading data ... sessionData: " + strA;
            op0.e(new Object[0]);
        }
        String strA2 = sh0.N.a();
        o4 o4Var = this.G;
        Context context = this.I;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        mapCreateMapBuilder.put(strA2, o4Var.b(context));
        String strA3 = sh0.O.a();
        o4 o4Var2 = this.G;
        Context context2 = this.I;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        mapCreateMapBuilder.put(strA3, o4Var2.a(context2));
        mapCreateMapBuilder.putAll(this.C.k().d());
        return MapsKt.build(mapCreateMapBuilder);
    }

    private final o8<T> a(tc1 tc1Var, Map<String, String> map, qs qsVar) {
        yc1<T> yc1Var = this.E;
        Context context = this.I;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        pi2 pi2VarA = yc1Var.a(context, this.C);
        sh0 sh0Var = sh0.L;
        String strA = kf0.a(map, sh0Var);
        String str = "Loading data ... saving header: " + sh0Var.a() + "=" + strA;
        op0.e(new Object[0]);
        this.F.a(strA);
        return pi2VarA.a(tc1Var, map, qsVar);
    }

    @Override // com.yandex.mobile.ads.impl.b62
    protected final qq1<o8<T>> a(tc1 response, int i) {
        qs qsVar;
        Intrinsics.checkNotNullParameter(response, "response");
        a(Integer.valueOf(i));
        if (b(response, i)) {
            Map<String, String> mapEmptyMap = response.c;
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            a(mapEmptyMap);
            String value = kf0.a(mapEmptyMap, sh0.f);
            if (value == null) {
                value = "";
            }
            qs.c.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            qs[] qsVarArrValues = qs.values();
            int length = qsVarArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    qsVar = null;
                    break;
                }
                qsVar = qsVarArrValues[i2];
                if (Intrinsics.areEqual(qsVar.a(), value)) {
                    break;
                }
                i2++;
            }
            if (qsVar == this.C.b()) {
                o8<T> o8VarA = a(response, mapEmptyMap, qsVar);
                if (204 != i) {
                    qq1<o8<T>> qq1VarA = qq1.a(o8VarA, th0.a(response));
                    Intrinsics.checkNotNullExpressionValue(qq1VarA, "success(...)");
                    return qq1VarA;
                }
            }
        }
        int i3 = r3.d;
        qq1<o8<T>> qq1VarA2 = qq1.a(r3.a.a(response));
        Intrinsics.checkNotNullExpressionValue(qq1VarA2, "error(...)");
        return qq1VarA2;
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public final String l() {
        StringBuilder sb = new StringBuilder();
        if (f() == 0) {
            sb.append(this.D);
        }
        List<an1> listF = this.C.k().f();
        if (sb.length() > 0 && !listF.isEmpty()) {
            sb.append(com.ironsource.b9.i.c);
        }
        sb.append(CollectionsKt.joinToString$default(listF, com.ironsource.b9.i.c, null, null, 0, null, a.b, 30, null));
        String string = Uri.parse(super.l()).buildUpon().encodedQuery(sb.toString()).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    static final class a extends Lambda implements Function1<an1, CharSequence> {
        public static final a b = new a();

        a() {
            super(1);
        }

        public static String a(an1 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getKey() + "=" + it.getValue();
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ CharSequence invoke(an1 an1Var) {
            return a(an1Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public final byte[] b() throws zh {
        if (1 == f()) {
            try {
                String str = this.D;
                Charset charsetForName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                byte[] bytes = str.getBytes(charsetForName);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            } catch (UnsupportedEncodingException unused) {
                String str2 = "Unsupported Encoding while trying to get the bytes of " + this.D + " using UTF-8";
                op0.a(new Object[0]);
            }
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.b62, com.yandex.mobile.ads.impl.pk, com.yandex.mobile.ads.impl.np1
    public final ki2 b(ki2 requestError) {
        Intrinsics.checkNotNullParameter(requestError, "requestError");
        op0.c(new Object[0]);
        int i = r3.d;
        return super.b((ki2) r3.a.a(requestError.b));
    }

    private final void a(Context context) {
        Integer numR;
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        a(this.H.a(context, (cu1VarA == null || (numR = cu1VarA.R()) == null) ? this.C.h() : numR.intValue()));
    }

    protected boolean b(tc1 networkResponse, int i) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        if (200 != i) {
            return false;
        }
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        byte[] bArr = networkResponse.b;
        if (bArr != null) {
            return (bArr.length == 0) ^ true;
        }
        return false;
    }
}
