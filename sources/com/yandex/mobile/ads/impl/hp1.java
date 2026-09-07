package com.yandex.mobile.ads.impl;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes12.dex */
public final class hp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9124a;
    private final Map<String, Object> b;
    private final f c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f9125a = StringsKt.capitalize("yandex");
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v43 com.yandex.mobile.ads.impl.hp1$b[], still in use, count: 1, list:
  (r0v43 com.yandex.mobile.ads.impl.hp1$b[]) from 0x0319: INVOKE (r0v43 com.yandex.mobile.ads.impl.hp1$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        c("ad_loading_result"),
        d("ad_rendering_result"),
        e("adapter_auto_refresh"),
        f("adapter_invalid"),
        g("adapter_request"),
        h("adapter_response"),
        i("adapter_bidder_token_request"),
        j("adtune"),
        k(Reporting.Key.AD_REQUEST),
        l(Reporting.Key.AD_RESPONSE),
        m("vast_request"),
        n("vast_response"),
        o("vast_wrapper_request"),
        p("vast_wrapper_response"),
        q("video_ad_start"),
        r("video_ad_complete"),
        s("video_ad_player_error"),
        t("vmap_request"),
        u("vmap_response"),
        v("rendering_start"),
        w("dsp_rendering_start"),
        x("impression_tracking_start"),
        y("impression_tracking_success"),
        z("impression_tracking_failure"),
        A("forced_impression_tracking_failure"),
        B("adapter_action"),
        C("click"),
        D("close"),
        E("feedback"),
        F("deeplink"),
        G("show_social_actions"),
        H("bound_assets"),
        I("rendered_assets"),
        J("rebind"),
        K("binding_failure"),
        L("expected_view_missing"),
        M("returned_to_app"),
        N("reward"),
        O("video_ad_rendering_result"),
        P("multibanner_event"),
        Q("ad_view_size_info"),
        R("dsp_impression_tracking_start"),
        S("dsp_impression_tracking_success"),
        T("dsp_impression_tracking_failure"),
        U("dsp_forced_impression_tracking_failure"),
        V(CreativeInfo.f),
        W("open_bidding_token_generation_result"),
        X("sdk_configuration_success"),
        Y("sdk_configuration_failure"),
        Z("tracking_event"),
        a0("ad_verification_result"),
        b0("sdk_configuration_request"),
        c0("activity_result_opened");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d0.clone();
        }

        private b(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.hp1$c[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.hp1$c[]) from 0x0034: INVOKE (r0v1 com.yandex.mobile.ads.impl.hp1$c[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class c {
        c("success"),
        d("error"),
        e("no_ads"),
        /* JADX INFO: Fake field, exist only in values array */
        EF43("filtered");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(cVarArr);
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f.clone();
        }

        private c(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hp1(b reportType, Map<String, ? extends Object> reportData, f fVar) {
        this(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), fVar);
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hp1)) {
            return false;
        }
        hp1 hp1Var = (hp1) obj;
        return Intrinsics.areEqual(this.f9124a, hp1Var.f9124a) && Intrinsics.areEqual(this.b, hp1Var.b) && Intrinsics.areEqual(this.c, hp1Var.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.f9124a.hashCode() * 31)) * 31;
        f fVar = this.c;
        return iHashCode + (fVar == null ? 0 : fVar.hashCode());
    }

    public final String toString() {
        return "Report(eventName=" + this.f9124a + ", data=" + this.b + ", abExperiments=" + this.c + ")";
    }

    public final String c() {
        return this.f9124a;
    }

    public final Map<String, Object> b() {
        return this.b;
    }

    public final f a() {
        return this.c;
    }

    public hp1(String eventName, Map<String, Object> data, f fVar) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f9124a = eventName;
        this.b = data;
        this.c = fVar;
        data.put("sdk_version", "7.12.1");
    }
}
