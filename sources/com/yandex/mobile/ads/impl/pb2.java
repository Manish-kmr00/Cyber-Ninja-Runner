package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes13.dex */
public final class pb2 {
    static final /* synthetic */ KProperty<Object>[] d = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(pb2.class, "view", "getView()Landroid/view/View;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9911a;
    private final String b;
    private final zn1 c;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.pb2$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.pb2$a[]) from 0x002e: INVOKE (r0v1 com.yandex.mobile.ads.impl.pb2$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        b,
        c,
        d,
        e;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        private a() {
            super(str, i);
        }
    }

    public pb2(View view, a purpose, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        this.f9911a = purpose;
        this.b = str;
        this.c = ao1.a(view);
    }

    public final a b() {
        return this.f9911a;
    }

    public final String a() {
        return this.b;
    }

    public final View c() {
        return (View) this.c.getValue(this, d[0]);
    }
}
