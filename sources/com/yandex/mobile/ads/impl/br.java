package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageView;
import com.yandex.mobile.ads.R;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f8533a;
    private final int b;
    private final d41 c;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.br$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.br$a[]) from 0x0024: INVOKE (r0v1 com.yandex.mobile.ads.impl.br$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    private static final class a {
        b,
        c,
        d;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }

        private a() {
            super(str, i);
        }
    }

    public br(ot nativeAdAssets, int i, d41 nativeAdAdditionalViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(nativeAdAdditionalViewProvider, "nativeAdAdditionalViewProvider");
        this.f8533a = nativeAdAssets;
        this.b = i;
        this.c = nativeAdAdditionalViewProvider;
    }

    public final ImageView a(View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        return a(parentView, a.b, this.f8533a.e());
    }

    public final ImageView b(View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        return a(parentView, a.c, this.f8533a.g());
    }

    private final ImageView a(View container, a aVar, qt qtVar) {
        a aVar2;
        qt qtVarG = this.f8533a.g();
        qt qtVarE = this.f8533a.e();
        if (qtVarG != null) {
            aVar2 = a.c;
        } else if (qtVarE != null) {
            aVar2 = a.b;
        } else {
            aVar2 = a.d;
        }
        if (qtVar == null || aVar2 != aVar) {
            return null;
        }
        int iD = qtVar.d();
        int iB = qtVar.b();
        int i = this.b;
        if (i <= iD && i <= iB) {
            this.c.getClass();
            Intrinsics.checkNotNullParameter(container, "container");
            return (ImageView) container.findViewById(R.id.icon_large);
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        return (ImageView) container.findViewById(R.id.icon_small);
    }
}
