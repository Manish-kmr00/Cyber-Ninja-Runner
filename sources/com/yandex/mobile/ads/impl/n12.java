package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public final class n12 extends k12 {
    public static final Parcelable.Creator<n12> CREATOR = new a();

    final class a implements Parcelable.Creator<n12> {
        @Override // android.os.Parcelable.Creator
        public final n12 createFromParcel(Parcel parcel) {
            return new n12();
        }

        @Override // android.os.Parcelable.Creator
        public final n12[] newArray(int i) {
            return new n12[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
    }
}
