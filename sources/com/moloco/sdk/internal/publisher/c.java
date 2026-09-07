package com.moloco.sdk.internal.publisher;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<s, Duration> f6174a;
    public final long b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6175a;

        static {
            int[] iArr = new int[s.values().length];
            try {
                iArr[s.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[s.BANNER_TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[s.MREC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[s.INTERSTITIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[s.REWARDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[s.NATIVE_BANNER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[s.NATIVE_AD_MEDIATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f6175a = iArr;
        }
    }

    public /* synthetic */ c(Map map, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, j);
    }

    public final Map<s, Duration> a() {
        return this.f6174a;
    }

    public final long b() {
        return this.b;
    }

    public final Map<s, Duration> c() {
        return this.f6174a;
    }

    public final long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.f6174a, cVar.f6174a) && Duration.m9237equalsimpl0(this.b, cVar.b);
    }

    public int hashCode() {
        return (this.f6174a.hashCode() * 31) + Duration.m9260hashCodeimpl(this.b);
    }

    public String toString() {
        return "AdCreatorConfiguration(adTimeouts=" + this.f6174a + ", defaultTimeoutDuration=" + ((Object) Duration.m9281toStringimpl(this.b)) + ')';
    }

    public c(Map<s, Duration> adTimeouts, long j) {
        Intrinsics.checkNotNullParameter(adTimeouts, "adTimeouts");
        this.f6174a = adTimeouts;
        this.b = j;
    }

    public final c a(Map<s, Duration> adTimeouts, long j) {
        Intrinsics.checkNotNullParameter(adTimeouts, "adTimeouts");
        return new c(adTimeouts, j, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c a(c cVar, Map map, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            map = cVar.f6174a;
        }
        if ((i & 2) != 0) {
            j = cVar.b;
        }
        return cVar.a(map, j);
    }

    public /* synthetic */ c(Map map, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        if ((i & 1) != 0) {
            s[] sVarArrValues = s.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(sVarArrValues.length), 16));
            for (s sVar : sVarArrValues) {
                switch (a.f6175a[sVar.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        duration = DurationKt.toDuration(5, DurationUnit.SECONDS);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        duration = DurationKt.toDuration(15, DurationUnit.SECONDS);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                linkedHashMap.put(sVar, Duration.m9230boximpl(duration));
            }
            map = linkedHashMap;
        }
        this(map, (i & 2) != 0 ? DurationKt.toDuration(5, DurationUnit.SECONDS) : j, null);
    }
}
