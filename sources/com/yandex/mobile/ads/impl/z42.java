package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes12.dex */
public final class z42 extends k12 {
    public static final Parcelable.Creator<z42> CREATOR = new a();
    public final long b;
    public final long c;

    final class a implements Parcelable.Creator<z42> {
        @Override // android.os.Parcelable.Creator
        public final z42 createFromParcel(Parcel parcel) {
            return new z42(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final z42[] newArray(int i) {
            return new z42[i];
        }

        a() {
        }
    }

    private z42(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    static z42 a(wf1 wf1Var, long j, i52 i52Var) {
        long jA = a(j, wf1Var);
        return new z42(jA, i52Var.b(jA));
    }

    static long a(long j, wf1 wf1Var) {
        long jT = wf1Var.t();
        if ((128 & jT) != 0) {
            return 8589934591L & ((((jT & 1) << 32) | wf1Var.v()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
    }
}
