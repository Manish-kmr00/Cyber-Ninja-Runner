package com.yandex.mobile.ads.impl;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Unit;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d31 extends xn {
    static final /* synthetic */ KProperty<Object>[] g = {ta.a(d31.class, "viewPager", "getViewPager()Landroidx/viewpager2/widget/ViewPager2;", 0)};
    private final n31 c;
    private final g31 d;
    private final zn1 e;
    private a f;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.d31$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.d31$a[]) from 0x001a: INVOKE (r0v1 com.yandex.mobile.ads.impl.d31$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        c;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }

        private a() {
            super(str, i);
        }
    }

    public d31(ViewPager2 viewPager, n31 multiBannerSwiper, g31 multiBannerEventTracker) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(multiBannerSwiper, "multiBannerSwiper");
        Intrinsics.checkNotNullParameter(multiBannerEventTracker, "multiBannerEventTracker");
        this.c = multiBannerSwiper;
        this.d = multiBannerEventTracker;
        this.e = ao1.a(viewPager);
        this.f = a.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Unit unit;
        ViewPager2 viewPager2 = (ViewPager2) this.e.getValue(this, g[0]);
        if (viewPager2 != null) {
            if (oh2.b(viewPager2) > 0) {
                RecyclerView.Adapter adapter = viewPager2.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount != 0) {
                    int currentItem = viewPager2.getCurrentItem();
                    if (currentItem == 0) {
                        this.f = a.b;
                    } else if (currentItem == itemCount - 1) {
                        this.f = a.c;
                    }
                } else {
                    a();
                }
                int iOrdinal = this.f.ordinal();
                if (iOrdinal == 0) {
                    this.c.a();
                } else if (iOrdinal == 1) {
                    this.c.b();
                }
                this.d.a();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            a();
        }
    }
}
