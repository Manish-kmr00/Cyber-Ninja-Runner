package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class kx1 implements Parcelable {
    public static final Parcelable.Creator<kx1> CREATOR = new a();
    private final String b;

    public static final class a implements Parcelable.Creator<kx1> {
        @Override // android.os.Parcelable.Creator
        public final kx1 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new kx1(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final kx1[] newArray(int i) {
            return new kx1[i];
        }
    }

    public kx1(String rewardUrl) {
        Intrinsics.checkNotNullParameter(rewardUrl, "rewardUrl");
        this.b = rewardUrl;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kx1) && Intrinsics.areEqual(this.b, ((kx1) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ServerSideReward(rewardUrl=" + this.b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
    }

    public final String c() {
        return this.b;
    }
}
