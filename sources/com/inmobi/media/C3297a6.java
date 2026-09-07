package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.a6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3297a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3266a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final String i;

    public C3297a6(long j, String impressionId, String placementType, String adType, String markupType, String creativeType, String metaDataBlob, boolean z, String landingScheme) {
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(markupType, "markupType");
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        Intrinsics.checkNotNullParameter(metaDataBlob, "metaDataBlob");
        Intrinsics.checkNotNullParameter(landingScheme, "landingScheme");
        this.f3266a = j;
        this.b = impressionId;
        this.c = placementType;
        this.d = adType;
        this.e = markupType;
        this.f = creativeType;
        this.g = metaDataBlob;
        this.h = z;
        this.i = landingScheme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3297a6)) {
            return false;
        }
        C3297a6 c3297a6 = (C3297a6) obj;
        return this.f3266a == c3297a6.f3266a && Intrinsics.areEqual(this.b, c3297a6.b) && Intrinsics.areEqual(this.c, c3297a6.c) && Intrinsics.areEqual(this.d, c3297a6.d) && Intrinsics.areEqual(this.e, c3297a6.e) && Intrinsics.areEqual(this.f, c3297a6.f) && Intrinsics.areEqual(this.g, c3297a6.g) && this.h == c3297a6.h && Intrinsics.areEqual(this.i, c3297a6.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    public final int hashCode() {
        int iHashCode = (this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (Long.hashCode(this.f3266a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.h;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return this.i.hashCode() + ((iHashCode + r1) * 31);
    }

    public final String toString() {
        return "LandingPageTelemetryMetaData(placementId=" + this.f3266a + ", impressionId=" + this.b + ", placementType=" + this.c + ", adType=" + this.d + ", markupType=" + this.e + ", creativeType=" + this.f + ", metaDataBlob=" + this.g + ", isRewarded=" + this.h + ", landingScheme=" + this.i + ')';
    }
}
