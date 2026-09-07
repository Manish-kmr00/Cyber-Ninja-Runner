package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j80 implements Parcelable {
    public static final Parcelable.Creator<j80> CREATOR = new a();
    private final String b;
    private final long c;

    public static final class a implements Parcelable.Creator<j80> {
        @Override // android.os.Parcelable.Creator
        public final j80 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new j80(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final j80[] newArray(int i) {
            return new j80[i];
        }
    }

    public j80(String url, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.b = url;
        this.c = j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j80)) {
            return false;
        }
        j80 j80Var = (j80) obj;
        return Intrinsics.areEqual(this.b, j80Var.b) && this.c == j80Var.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.c) + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "FalseClick(url=" + this.b + ", interval=" + this.c + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
        out.writeLong(this.c);
    }

    public final long c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }
}
