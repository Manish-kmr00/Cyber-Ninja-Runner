package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.yandex.mobile.ads.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class cc0 {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.cc0$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.cc0$a[]) from 0x0013: INVOKE (r0v1 com.yandex.mobile.ads.impl.cc0$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        /* JADX INFO: Fake field, exist only in values array */
        EF10(R.font.monetization_ads_internal_font_medium, R.font.monetization_ads_internal_font_bold);

        public static final /* synthetic */ int g = 0;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        private a(int i, int i2) {
            super("YSText", 0);
            this.b = i;
            this.c = i;
            this.d = i;
            this.e = i2;
        }

        public final int a() {
            return this.e;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.d;
        }

        public final int d() {
            return this.c;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8588a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                int i = a.g;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f8588a = iArr;
        }
    }

    public static bc0 a(Context context) {
        Typeface font;
        Typeface font2;
        Typeface font3;
        Typeface font4;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        String strT = cu1VarA != null ? cu1VarA.t() : null;
        if (strT == null) {
            return null;
        }
        try {
            a aVarValueOf = a.valueOf(strT);
            if (b.f8588a[aVarValueOf.ordinal()] != 1) {
                throw new NoWhenBranchMatchedException();
            }
            try {
                font = ResourcesCompat.getFont(context, aVarValueOf.b());
            } catch (Throwable unused) {
                font = null;
            }
            try {
                font2 = ResourcesCompat.getFont(context, aVarValueOf.d());
            } catch (Throwable unused2) {
                font2 = null;
            }
            try {
                font3 = ResourcesCompat.getFont(context, aVarValueOf.c());
            } catch (Throwable unused3) {
                font3 = null;
            }
            try {
                font4 = ResourcesCompat.getFont(context, aVarValueOf.a());
            } catch (Throwable unused4) {
                font4 = null;
            }
            return new bc0(font, font2, font3, font4);
        } catch (Throwable unused5) {
            return null;
        }
    }
}
