package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f3060a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;
    public final int h;
    public final D0 i;
    public final Ha j;

    public Ea(J placement, String markupType, String telemetryMetadataBlob, int i, String creativeType, String creativeId, boolean z, int i2, D0 adUnitTelemetryData, Ha renderViewTelemetryData) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(markupType, "markupType");
        Intrinsics.checkNotNullParameter(telemetryMetadataBlob, "telemetryMetadataBlob");
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        Intrinsics.checkNotNullParameter(adUnitTelemetryData, "adUnitTelemetryData");
        Intrinsics.checkNotNullParameter(renderViewTelemetryData, "renderViewTelemetryData");
        this.f3060a = placement;
        this.b = markupType;
        this.c = telemetryMetadataBlob;
        this.d = i;
        this.e = creativeType;
        this.f = creativeId;
        this.g = z;
        this.h = i2;
        this.i = adUnitTelemetryData;
        this.j = renderViewTelemetryData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ea)) {
            return false;
        }
        Ea ea = (Ea) obj;
        return Intrinsics.areEqual(this.f3060a, ea.f3060a) && Intrinsics.areEqual(this.b, ea.b) && Intrinsics.areEqual(this.c, ea.c) && this.d == ea.d && Intrinsics.areEqual(this.e, ea.e) && Intrinsics.areEqual(this.f, ea.f) && this.g == ea.g && this.h == ea.h && Intrinsics.areEqual(this.i, ea.i) && Intrinsics.areEqual(this.j, ea.j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    public final int hashCode() {
        int iHashCode = (this.f.hashCode() + ((this.e.hashCode() + ((Integer.hashCode(this.d) + ((this.c.hashCode() + ((this.b.hashCode() + (this.f3060a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.g;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return Integer.hashCode(this.j.f3090a) + ((this.i.hashCode() + ((Integer.hashCode(this.h) + ((iHashCode + r0) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "RenderViewMetaData(placement=" + this.f3060a + ", markupType=" + this.b + ", telemetryMetadataBlob=" + this.c + ", internetAvailabilityAdRetryCount=" + this.d + ", creativeType=" + this.e + ", creativeId=" + this.f + ", isRewarded=" + this.g + ", adIndex=" + this.h + ", adUnitTelemetryData=" + this.i + ", renderViewTelemetryData=" + this.j + ')';
    }
}
