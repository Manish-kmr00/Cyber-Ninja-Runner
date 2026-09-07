package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fp implements Parcelable {
    public static final Parcelable.Creator<fp> CREATOR = new a();
    private final int b;
    private final String c;

    public static final class a implements Parcelable.Creator<fp> {
        @Override // android.os.Parcelable.Creator
        public final fp createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new fp(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final fp[] newArray(int i) {
            return new fp[i];
        }
    }

    public fp(int i, String rewardType) {
        Intrinsics.checkNotNullParameter(rewardType, "rewardType");
        this.b = i;
        this.c = rewardType;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fp)) {
            return false;
        }
        fp fpVar = (fp) obj;
        return this.b == fpVar.b && Intrinsics.areEqual(this.c, fpVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (Integer.hashCode(this.b) * 31);
    }

    public final String toString() {
        return "ClientSideReward(rewardAmount=" + this.b + ", rewardType=" + this.c + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.b);
        out.writeString(this.c);
    }

    public final int c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }
}
