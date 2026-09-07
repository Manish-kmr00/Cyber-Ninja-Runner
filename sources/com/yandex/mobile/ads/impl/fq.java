package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import com.inmobi.sdk.InMobiSdk;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class fq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final up1 f8918a;

    public fq(up1 requestHelper) {
        Intrinsics.checkNotNullParameter(requestHelper, "requestHelper");
        this.f8918a = requestHelper;
    }

    public final void a(Context context, Uri.Builder builder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        a aVar = new a(builder);
        gq.f9028a.getClass();
        iq iqVar = (iq) gq.a.a(context);
        aVar.invoke("gdpr", iqVar.a());
        aVar.invoke(InMobiSdk.IM_GDPR_CONSENT_IAB, iqVar.b());
        aVar.invoke("parsed_purpose_consents", iqVar.c());
        aVar.invoke("parsed_vendor_consents", iqVar.f());
        aVar.invoke("cmp_present", Integer.valueOf(iqVar.e() ? 1 : 0).toString());
    }

    static final class a extends Lambda implements Function2<String, String, Unit> {
        final /* synthetic */ Uri.Builder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Uri.Builder builder) {
            super(2);
            this.c = builder;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, String str2) {
            String key = str;
            String str3 = str2;
            Intrinsics.checkNotNullParameter(key, "key");
            up1 up1Var = fq.this.f8918a;
            Uri.Builder builder = this.c;
            up1Var.getClass();
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(key, "key");
            if (str3 != null && str3.length() != 0) {
                builder.appendQueryParameter(key, str3);
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function2<String, String, Unit> {
        final /* synthetic */ bn1 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(bn1 bn1Var) {
            super(2);
            this.b = bn1Var;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, String str2) {
            String key = str;
            Intrinsics.checkNotNullParameter(key, "key");
            this.b.a(key, str2);
            return Unit.INSTANCE;
        }
    }

    public static void a(Context context, bn1 queryParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(queryParams, "queryParams");
        b bVar = new b(queryParams);
        gq.f9028a.getClass();
        iq iqVar = (iq) gq.a.a(context);
        bVar.invoke("gdpr", iqVar.a());
        bVar.invoke(InMobiSdk.IM_GDPR_CONSENT_IAB, iqVar.b());
        bVar.invoke("parsed_purpose_consents", iqVar.c());
        bVar.invoke("parsed_vendor_consents", iqVar.f());
        bVar.invoke("cmp_present", Integer.valueOf(iqVar.e() ? 1 : 0).toString());
    }
}
