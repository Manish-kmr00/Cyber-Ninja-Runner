package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class cl1 extends k12 {
    public static final Parcelable.Creator<cl1> CREATOR = new a();
    public final long b;
    public final long c;
    public final byte[] d;

    final class a implements Parcelable.Creator<cl1> {
        @Override // android.os.Parcelable.Creator
        public final cl1 createFromParcel(Parcel parcel) {
            return new cl1(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final cl1[] newArray(int i) {
            return new cl1[i];
        }

        a() {
        }
    }

    private cl1(long j, byte[] bArr, long j2) {
        this.b = j2;
        this.c = j;
        this.d = bArr;
    }

    static cl1 a(wf1 wf1Var, int i, long j) {
        long jV = wf1Var.v();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        wf1Var.a(bArr, 0, i2);
        return new cl1(jV, bArr, j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeByteArray(this.d);
    }

    private cl1(Parcel parcel) {
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = (byte[]) x82.a(parcel.createByteArray());
    }
}
