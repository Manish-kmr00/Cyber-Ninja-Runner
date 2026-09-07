package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes13.dex */
public final class v11 implements g01.b {
    public static final Parcelable.Creator<v11> CREATOR = new a();
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;

    final class a implements Parcelable.Creator<v11> {
        @Override // android.os.Parcelable.Creator
        public final v11 createFromParcel(Parcel parcel) {
            return new v11(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final v11[] newArray(int i) {
            return new v11[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.b + ", photoSize=" + this.c + ", photoPresentationTimestampUs=" + this.d + ", videoStartPosition=" + this.e + ", videoSize=" + this.f;
    }

    public v11(long j, long j2, long j3, long j4, long j5) {
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v11.class != obj.getClass()) {
            return false;
        }
        v11 v11Var = (v11) obj;
        return this.b == v11Var.b && this.c == v11Var.c && this.d == v11Var.d && this.e == v11Var.e && this.f == v11Var.f;
    }

    public final int hashCode() {
        long j = this.b;
        int i = (((int) (j ^ (j >>> 32))) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        long j2 = this.c;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.d;
        int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.e;
        int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.f;
        return i4 + ((int) ((j5 >>> 32) ^ j5));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
    }

    private v11(Parcel parcel) {
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
    }
}
