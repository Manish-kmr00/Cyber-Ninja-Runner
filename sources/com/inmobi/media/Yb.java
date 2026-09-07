package com.inmobi.media;

import com.yandex.div.core.DivActionHandler;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class Yb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E0 f3248a;
    public final String b;
    public final String c;
    public final String d;
    public String e;

    public Yb(E0 e0, String str, String str2, String markupType) {
        Intrinsics.checkNotNullParameter(markupType, "markupType");
        this.f3248a = e0;
        this.b = str;
        this.c = str2;
        this.d = markupType;
    }

    public final LinkedHashMap a() {
        String strM;
        String strQ;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        E0 e0 = this.f3248a;
        if (e0 != null && (strQ = e0.f3053a.q()) != null) {
            linkedHashMap.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, strQ);
        }
        E0 e1 = this.f3248a;
        if (e1 != null) {
            linkedHashMap.put("plId", Long.valueOf(e1.f3053a.I().l()));
        }
        E0 e2 = this.f3248a;
        if (e2 != null && (strM = e2.f3053a.I().m()) != null) {
            linkedHashMap.put("plType", strM);
        }
        E0 e3 = this.f3248a;
        String str = null;
        if (e3 != null) {
            C3418j0 c3418j0Y = e3.f3053a.y();
            Boolean boolO = c3418j0Y != null ? c3418j0Y.o() : null;
            if (boolO != null) {
                linkedHashMap.put("isRewarded", boolO);
            }
        }
        String str2 = this.c;
        if (str2 != null) {
            linkedHashMap.put("creativeId", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            linkedHashMap.put("creativeType", str3);
        }
        linkedHashMap.put("markupType", this.d);
        String str4 = this.e;
        if (str4 != null) {
            str = str4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("triggerSource");
        }
        linkedHashMap.put(DivActionHandler.DivActionReason.TRIGGER, str);
        E0 e4 = this.f3248a;
        if (e4 != null && e4.a().length() > 0) {
            linkedHashMap.put("metadataBlob", this.f3248a.a());
        }
        return linkedHashMap;
    }

    public final void b() {
        Zb zb;
        AtomicBoolean atomicBoolean;
        E0 e0 = this.f3248a;
        if (e0 == null || (zb = e0.b) == null || (atomicBoolean = zb.f3259a) == null || !atomicBoolean.getAndSet(true)) {
            a().put("networkType", C3435k3.q());
            a().put("errorCode", (short) 2180);
            LinkedHashMap linkedHashMapA = a();
            Ob ob = Ob.f3160a;
            Ob.b("AdImpressionSuccessful", linkedHashMapA, Sb.SDK);
        }
    }

    public final void c() {
        Zb zb;
        AtomicBoolean atomicBoolean;
        E0 e0 = this.f3248a;
        if (e0 == null || (zb = e0.b) == null || (atomicBoolean = zb.f3259a) == null || !atomicBoolean.getAndSet(true)) {
            a().put("networkType", C3435k3.q());
            a().put("errorCode", (short) 2177);
            LinkedHashMap linkedHashMapA = a();
            Ob ob = Ob.f3160a;
            Ob.b("AdImpressionSuccessful", linkedHashMapA, Sb.SDK);
        }
    }

    public final void d() {
        Zb zb;
        AtomicBoolean atomicBoolean;
        E0 e0 = this.f3248a;
        if (e0 == null || (zb = e0.b) == null || (atomicBoolean = zb.f3259a) == null || !atomicBoolean.getAndSet(true)) {
            a().put("networkType", C3435k3.q());
            a().put("errorCode", (short) 0);
            LinkedHashMap linkedHashMapA = a();
            Ob ob = Ob.f3160a;
            Ob.b("AdImpressionSuccessful", linkedHashMapA, Sb.SDK);
        }
    }
}
