package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: com.inmobi.media.e9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3357e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0 f3302a;

    public C3357e9(C0 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3302a = adUnit;
    }

    public final byte[] a() {
        D dH0 = this.f3302a.h0();
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("h-user-agent", C3517pb.k()));
        if (mapHashMapOf != null) {
            HashMap map = dH0.k;
            if (map != null) {
                map.putAll(mapHashMapOf);
            }
        } else {
            dH0.getClass();
        }
        dH0.f();
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("root", C3517pb.b(), null);
        RootConfig rootConfig = configA instanceof RootConfig ? (RootConfig) configA : null;
        if (rootConfig != null && rootConfig.getMonetizationDisabled()) {
            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MONETIZATION_DISABLED), (short) 2012);
        }
        if (!dH0.d) {
            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED), (short) 2141);
        }
        byte[] bytes = dH0.c().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
