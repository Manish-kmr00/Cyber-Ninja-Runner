package com.inmobi.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class Z5 implements Parcelable {
    public static final X5 CREATOR = new X5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3297a6 f3254a;
    public final String b;
    public final int c;
    public final long d;
    public final Lazy e;
    public int f;
    public String g;

    public Z5(C3297a6 landingPageTelemetryMetaData, String urlType, int i, long j) {
        Intrinsics.checkNotNullParameter(landingPageTelemetryMetaData, "landingPageTelemetryMetaData");
        Intrinsics.checkNotNullParameter(urlType, "urlType");
        this.f3254a = landingPageTelemetryMetaData;
        this.b = urlType;
        this.c = i;
        this.d = j;
        this.e = LazyKt.lazy(Y5.f3244a);
        this.f = -1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Z5)) {
            return false;
        }
        Z5 z5 = (Z5) obj;
        return Intrinsics.areEqual(this.f3254a, z5.f3254a) && Intrinsics.areEqual(this.b, z5.b) && this.c == z5.c && this.d == z5.d;
    }

    public final int hashCode() {
        return Long.hashCode(this.d) + ((Integer.hashCode(this.c) + ((this.b.hashCode() + (this.f3254a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "LandingPageTelemetryControlInfo(landingPageTelemetryMetaData=" + this.f3254a + ", urlType=" + this.b + ", counter=" + this.c + ", startTime=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.f3254a.f3266a);
        parcel.writeString(this.f3254a.b);
        parcel.writeString(this.f3254a.c);
        parcel.writeString(this.f3254a.d);
        parcel.writeString(this.f3254a.e);
        parcel.writeString(this.f3254a.f);
        parcel.writeString(this.f3254a.g);
        parcel.writeByte(this.f3254a.h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f3254a.i);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
    }

    public /* synthetic */ Z5(C3297a6 c3297a6, String str, int i, int i2) {
        this(c3297a6, str, (i2 & 4) != 0 ? 0 : i, SystemClock.elapsedRealtime());
    }
}
