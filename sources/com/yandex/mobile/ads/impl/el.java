package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class el implements Parcelable {
    public static final Parcelable.Creator<el> CREATOR = new a();
    private final List<ba> b;
    private final d01 c;

    public static final class a implements Parcelable.Creator<el> {
        @Override // android.os.Parcelable.Creator
        public final el createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(ba.CREATOR.createFromParcel(parcel));
            }
            return new el(arrayList, parcel.readInt() == 0 ? null : d01.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final el[] newArray(int i) {
            return new el[i];
        }
    }

    public el(ArrayList adUnitIdBiddingSettingsList, d01 d01Var) {
        Intrinsics.checkNotNullParameter(adUnitIdBiddingSettingsList, "adUnitIdBiddingSettingsList");
        this.b = adUnitIdBiddingSettingsList;
        this.c = d01Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof el)) {
            return false;
        }
        el elVar = (el) obj;
        return Intrinsics.areEqual(this.b, elVar.b) && Intrinsics.areEqual(this.c, elVar.c);
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        d01 d01Var = this.c;
        return iHashCode + (d01Var == null ? 0 : d01Var.hashCode());
    }

    public final String toString() {
        return "BiddingSettings(adUnitIdBiddingSettingsList=" + this.b + ", mediationPrefetchSettings=" + this.c + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        List<ba> list = this.b;
        out.writeInt(list.size());
        Iterator<ba> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i);
        }
        d01 d01Var = this.c;
        if (d01Var == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            d01Var.writeToParcel(out, i);
        }
    }

    public final List<ba> c() {
        return this.b;
    }

    public final d01 d() {
        return this.c;
    }
}
