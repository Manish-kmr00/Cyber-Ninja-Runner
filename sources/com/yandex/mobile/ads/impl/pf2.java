package com.yandex.mobile.ads.impl;

import android.graphics.Matrix;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class pf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yy1 f9922a;
    private final yy1 b;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.pf2$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.pf2$a[]) from 0x001a: INVOKE (r0v1 com.yandex.mobile.ads.impl.pf2$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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

    public pf2(yy1 viewSize, yy1 videoSize) {
        Intrinsics.checkNotNullParameter(viewSize, "viewSize");
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        this.f9922a = viewSize;
        this.b = videoSize;
    }

    private final Matrix a(float f, float f2, a aVar) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            Matrix matrix = new Matrix();
            matrix.setScale(f, f2, 0.0f, 0.0f);
            return matrix;
        }
        if (iOrdinal == 1) {
            float fB = this.f9922a.b() / 2.0f;
            float fA = this.f9922a.a() / 2.0f;
            Matrix matrix2 = new Matrix();
            matrix2.setScale(f, f2, fB, fA);
            return matrix2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Matrix a(qf2 videoScaleType) {
        Intrinsics.checkNotNullParameter(videoScaleType, "videoScaleType");
        yy1 yy1Var = this.b;
        if (yy1Var.b() > 0 && yy1Var.a() > 0) {
            yy1 yy1Var2 = this.f9922a;
            if (yy1Var2.b() > 0 && yy1Var2.a() > 0) {
                int iOrdinal = videoScaleType.ordinal();
                if (iOrdinal == 0) {
                    return a(1.0f, 1.0f, a.b);
                }
                if (iOrdinal == 1) {
                    float fB = this.f9922a.b() / this.b.b();
                    float fA = this.f9922a.a() / this.b.a();
                    float fMin = Math.min(fB, fA);
                    return a(fMin / fB, fMin / fA, a.c);
                }
                if (iOrdinal == 2) {
                    float fB2 = this.f9922a.b() / this.b.b();
                    float fA2 = this.f9922a.a() / this.b.a();
                    float fMax = Math.max(fB2, fA2);
                    return a(fMax / fB2, fMax / fA2, a.c);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return null;
    }
}
