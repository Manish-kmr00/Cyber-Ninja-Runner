package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hi2 {
    private static final String g = "https://mobile.yandexadexchange.net";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b8 f9100a;
    private final ji2 b;
    private final up1 c;
    private final fq d;
    private final h50 e;
    private final dx1 f;

    public hi2(b8 adRequestProvider, ji2 requestReporter, up1 requestHelper, fq cmpRequestConfigurator, h50 encryptedQueryConfigurator, dx1 sensitiveModeChecker) {
        Intrinsics.checkNotNullParameter(adRequestProvider, "adRequestProvider");
        Intrinsics.checkNotNullParameter(requestReporter, "requestReporter");
        Intrinsics.checkNotNullParameter(requestHelper, "requestHelper");
        Intrinsics.checkNotNullParameter(cmpRequestConfigurator, "cmpRequestConfigurator");
        Intrinsics.checkNotNullParameter(encryptedQueryConfigurator, "encryptedQueryConfigurator");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        this.f9100a = adRequestProvider;
        this.b = requestReporter;
        this.c = requestHelper;
        this.d = cmpRequestConfigurator;
        this.e = encryptedQueryConfigurator;
        this.f = sensitiveModeChecker;
    }

    public final fi2 a(Context context, o3 adConfiguration, gi2 requestConfiguration, Object requestTag, ii2 requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        String strA = requestConfiguration.a();
        String strB = requestConfiguration.b();
        b8 b8Var = this.f9100a;
        Map<String, String> parameters = requestConfiguration.getParameters();
        b8Var.getClass();
        HashMap mapA = b8.a(parameters);
        l50 l50VarK = adConfiguration.k();
        String strG = l50VarK.g();
        String strE = l50VarK.e();
        String strA2 = l50VarK.a();
        if (strA2 == null || strA2.length() == 0) {
            strA2 = g;
        }
        Uri.Builder builder = Uri.parse(strA2).buildUpon().appendPath(com.moloco.sdk.internal.services.bidtoken.s.f6343a).appendPath("vmap").appendPath(strA).appendQueryParameter("video-category-id", strB);
        this.f.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (!dx1.a(context)) {
            up1 up1Var = this.c;
            Intrinsics.checkNotNull(builder);
            up1Var.getClass();
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(CommonUrlParts.UUID, "key");
            if (strG != null && strG.length() != 0) {
                builder.appendQueryParameter(CommonUrlParts.UUID, strG);
            }
            this.c.getClass();
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter("mauid", "key");
            if (strE != null && strE.length() != 0) {
                builder.appendQueryParameter("mauid", strE);
            }
        }
        fq fqVar = this.d;
        Intrinsics.checkNotNull(builder);
        fqVar.a(context, builder);
        if (mapA != null) {
            for (Map.Entry entry : mapA.entrySet()) {
                builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
        }
        new n50(context, adConfiguration).a(context, builder);
        h50 h50Var = this.e;
        String string = builder.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        fi2 fi2Var = new fi2(context, adConfiguration, h50Var.a(context, string), new ri2(requestListener), requestConfiguration, this.b, new ei2(), sc1.a());
        fi2Var.b(requestTag);
        return fi2Var;
    }
}
