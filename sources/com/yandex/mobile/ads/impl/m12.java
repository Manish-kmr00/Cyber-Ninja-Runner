package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class m12 extends k12 {
    public static final Parcelable.Creator<m12> CREATOR = new a();
    public final long b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final long g;
    public final long h;
    public final List<b> i;
    public final boolean j;
    public final long k;
    public final int l;
    public final int m;
    public final int n;

    final class a implements Parcelable.Creator<m12> {
        @Override // android.os.Parcelable.Creator
        public final m12 createFromParcel(Parcel parcel) {
            return new m12(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final m12[] newArray(int i) {
            return new m12[i];
        }

        a() {
        }
    }

    private m12(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<b> list, boolean z5, long j4, int i, int i2, int i3) {
        this.b = j;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = j2;
        this.h = j3;
        this.i = Collections.unmodifiableList(list);
        this.j = z5;
        this.k = j4;
        this.l = i;
        this.m = i2;
        this.n = i3;
    }

    static m12 a(wf1 wf1Var, long j, i52 i52Var) {
        List list;
        int iZ;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        boolean z4;
        int iT;
        int iT2;
        boolean z5;
        long jV;
        wf1 wf1Var2 = wf1Var;
        long jV2 = wf1Var.v();
        boolean z6 = (wf1Var.t() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z6) {
            list = listEmptyList;
            iZ = 0;
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            z4 = false;
            iT = 0;
            iT2 = 0;
        } else {
            int iT3 = wf1Var.t();
            boolean z7 = (iT3 & 128) != 0;
            boolean z8 = (iT3 & 64) != 0;
            boolean z9 = (iT3 & 32) != 0;
            boolean z10 = (iT3 & 16) != 0;
            long jA = (!z8 || z10) ? -9223372036854775807L : z42.a(j, wf1Var2);
            if (!z8) {
                int iT4 = wf1Var.t();
                ArrayList arrayList = new ArrayList(iT4);
                int i = 0;
                while (i < iT4) {
                    int iT5 = wf1Var.t();
                    long jA2 = !z10 ? z42.a(j, wf1Var2) : -9223372036854775807L;
                    arrayList.add(new b(iT5, jA2, i52Var.b(jA2)));
                    i++;
                    wf1Var2 = wf1Var;
                }
                listEmptyList = arrayList;
            }
            if (z9) {
                long jT = wf1Var.t();
                boolean z11 = (128 & jT) != 0;
                jV = ((((jT & 1) << 32) | wf1Var.v()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                jV = -9223372036854775807L;
            }
            iZ = wf1Var.z();
            iT = wf1Var.t();
            iT2 = wf1Var.t();
            list = listEmptyList;
            z4 = z8;
            long j4 = jA;
            z3 = z5;
            j3 = jV;
            z2 = z10;
            z = z7;
            j2 = j4;
        }
        return new m12(jV2, z6, z, z4, z2, j2, i52Var.b(j2), list, z3, j3, iZ, iT, iT2);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9589a;
        public final long b;
        public final long c;

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        private b(int i, long j, long j2) {
            this.f9589a = i;
            this.b = j;
            this.c = j2;
        }
    }

    private m12(Parcel parcel) {
        this.b = parcel.readLong();
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.e = parcel.readByte() == 1;
        this.f = parcel.readByte() == 1;
        this.g = parcel.readLong();
        this.h = parcel.readLong();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(b.a(parcel));
        }
        this.i = Collections.unmodifiableList(arrayList);
        this.j = parcel.readByte() == 1;
        this.k = parcel.readLong();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
        int size = this.i.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.i.get(i2);
            parcel.writeInt(bVar.f9589a);
            parcel.writeLong(bVar.b);
            parcel.writeLong(bVar.c);
        }
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
    }
}
