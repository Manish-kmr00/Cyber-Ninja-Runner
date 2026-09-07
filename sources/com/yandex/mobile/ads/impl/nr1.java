package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nr1 implements Parcelable {
    public static final Parcelable.Creator<nr1> CREATOR = new b();
    private final boolean b;
    private final fp c;
    private final kx1 d;

    public static final class b implements Parcelable.Creator<nr1> {
        @Override // android.os.Parcelable.Creator
        public final nr1 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new nr1(parcel.readInt() != 0, parcel.readInt() == 0 ? null : fp.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? kx1.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final nr1[] newArray(int i) {
            return new nr1[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nr1)) {
            return false;
        }
        nr1 nr1Var = (nr1) obj;
        return this.b == nr1Var.b && Intrinsics.areEqual(this.c, nr1Var.c) && Intrinsics.areEqual(this.d, nr1Var.d);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.b) * 31;
        fp fpVar = this.c;
        int iHashCode2 = (iHashCode + (fpVar == null ? 0 : fpVar.hashCode())) * 31;
        kx1 kx1Var = this.d;
        return iHashCode2 + (kx1Var != null ? kx1Var.hashCode() : 0);
    }

    public final String toString() {
        return "RewardData(serverSideRewardType=" + this.b + ", clientSideReward=" + this.c + ", serverSideReward=" + this.d + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.b ? 1 : 0);
        fp fpVar = this.c;
        if (fpVar == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            fpVar.writeToParcel(out, i);
        }
        kx1 kx1Var = this.d;
        if (kx1Var == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            kx1Var.writeToParcel(out, i);
        }
    }

    public nr1(boolean z, fp fpVar, kx1 kx1Var) {
        this.b = z;
        this.c = fpVar;
        this.d = kx1Var;
    }

    public final boolean e() {
        return this.b;
    }

    public final fp c() {
        return this.c;
    }

    public final kx1 d() {
        return this.d;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9749a;
        private fp b;
        private kx1 c;

        public final a a(fp fpVar) {
            this.b = fpVar;
            return this;
        }

        public final a a(kx1 kx1Var) {
            this.c = kx1Var;
            return this;
        }

        public final a a(boolean z) {
            this.f9749a = z;
            return this;
        }

        public final nr1 a() {
            return new nr1(this.f9749a, this.b, this.c);
        }
    }
}
