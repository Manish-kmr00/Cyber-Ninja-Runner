package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public final class p22 implements Comparable<p22>, Parcelable {
    public static final Parcelable.Creator<p22> CREATOR = new a();
    public final int b;
    public final int c;
    public final int d;

    final class a implements Parcelable.Creator<p22> {
        @Override // android.os.Parcelable.Creator
        public final p22 createFromParcel(Parcel parcel) {
            return new p22(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final p22[] newArray(int i) {
            return new p22[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.b + "." + this.c + "." + this.d;
    }

    @Override // java.lang.Comparable
    public final int compareTo(p22 p22Var) {
        p22 p22Var2 = p22Var;
        int i = this.b - p22Var2.b;
        if (i != 0) {
            return i;
        }
        int i2 = this.c - p22Var2.c;
        return i2 == 0 ? this.d - p22Var2.d : i2;
    }

    public p22(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p22.class != obj.getClass()) {
            return false;
        }
        p22 p22Var = (p22) obj;
        return this.b == p22Var.b && this.c == p22Var.c && this.d == p22Var.d;
    }

    public final int hashCode() {
        return (((this.b * 31) + this.c) * 31) + this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    p22(Parcel parcel) {
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }
}
