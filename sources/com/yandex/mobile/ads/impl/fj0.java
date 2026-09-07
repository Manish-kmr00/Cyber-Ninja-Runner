package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.json.mediationsdk.utils.IronSourceConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public abstract class fj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f8900a;

    protected abstract float a(float f);

    public abstract d a(Context context, int i, int i2, int i3);

    public fj0(float f) {
        this.f8900a = a(f);
    }

    protected final float a() {
        return this.f8900a;
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8901a;
        private final int b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f8901a == dVar.f8901a && this.b == dVar.b;
        }

        public final int hashCode() {
            return Integer.hashCode(this.b) + (Integer.hashCode(this.f8901a) * 31);
        }

        public final String toString() {
            return "Size(width=" + this.f8901a + ", height=" + this.b + ")";
        }

        public d(int i, int i2) {
            this.f8901a = i;
            this.b = i2;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.f8901a;
        }
    }

    public static final class a extends fj0 {
        @Override // com.yandex.mobile.ads.impl.fj0
        public final d a(Context context, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            int iCoerceAtMost = RangesKt.coerceAtMost(oh2.a(context, a()), i);
            return new d(iCoerceAtMost, MathKt.roundToInt(i3 * (iCoerceAtMost / i2)));
        }

        public a(float f) {
            super(f);
        }

        @Override // com.yandex.mobile.ads.impl.fj0
        protected final float a(float f) {
            return RangesKt.coerceAtLeast(f, 10.0f);
        }
    }

    public static final class b extends fj0 {
        @Override // com.yandex.mobile.ads.impl.fj0
        public final d a(Context context, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            int iRoundToInt = MathKt.roundToInt(i * a());
            return new d(iRoundToInt, MathKt.roundToInt(i3 * (iRoundToInt / i2)));
        }

        public b(float f) {
            super(f);
        }

        @Override // com.yandex.mobile.ads.impl.fj0
        protected final float a(float f) {
            return RangesKt.coerceIn(f, 0.01f, 1.0f);
        }
    }

    public static final class c extends fj0 {
        @Override // com.yandex.mobile.ads.impl.fj0
        public final d a(Context context, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            int iA = oh2.a(context, IronSourceConstants.USING_CACHE_FOR_INIT_EVENT);
            int iRoundToInt = MathKt.roundToInt(i * a());
            if (i2 > iRoundToInt) {
                i3 = MathKt.roundToInt(i3 / (i2 / iRoundToInt));
                i2 = iRoundToInt;
            }
            if (i3 > iA) {
                i2 = MathKt.roundToInt(i2 / (i3 / iA));
            } else {
                iA = i3;
            }
            return new d(i2, iA);
        }

        public c(float f) {
            super(f);
        }

        @Override // com.yandex.mobile.ads.impl.fj0
        protected final float a(float f) {
            return RangesKt.coerceIn(f, 0.01f, 1.0f);
        }
    }
}
