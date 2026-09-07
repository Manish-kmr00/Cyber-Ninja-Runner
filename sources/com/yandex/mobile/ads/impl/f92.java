package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f8879a;
    private String b;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.f92$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.f92$a[]) from 0x00a7: INVOKE (r0v1 com.yandex.mobile.ads.impl.f92$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class a {
        c("success"),
        d("application_inactive"),
        e("inconsistent_asset_value"),
        f("no_ad_view"),
        g("no_visible_ads"),
        h("no_visible_required_assets"),
        i("not_added_to_hierarchy"),
        j("not_visible_for_percent"),
        k("required_asset_can_not_be_visible"),
        l("required_asset_is_not_subview"),
        m("superview_hidden"),
        n("too_small"),
        o("visible_area_too_small");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) p.clone();
        }

        private a(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    public f92(a status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.f8879a = status;
    }

    public final a b() {
        return this.f8879a;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }
}
