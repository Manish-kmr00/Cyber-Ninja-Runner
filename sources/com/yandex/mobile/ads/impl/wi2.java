package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public final class wi2 extends vi2 {
    public static final Parcelable.Creator<wi2> CREATOR = new a();

    final class a implements Parcelable.Creator<wi2> {
        @Override // android.os.Parcelable.Creator
        public final wi2 createFromParcel(Parcel parcel) {
            return new wi2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final wi2[] newArray(int i) {
            return new wi2[i];
        }

        a() {
        }
    }

    wi2(Parcel parcel) {
        super(parcel);
    }

    public wi2(String str, String str2) {
        super(str, str2);
    }
}
