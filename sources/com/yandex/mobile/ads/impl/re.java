package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public final class re implements g01.b {
    public static final Parcelable.Creator<re> CREATOR = new a();
    public final int b;
    public final String c;

    final class a implements Parcelable.Creator<re> {
        @Override // android.os.Parcelable.Creator
        public final re createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            string.getClass();
            return new re(parcel.readInt(), string);
        }

        @Override // android.os.Parcelable.Creator
        public final re[] newArray(int i) {
            return new re[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Ait(controlCode=" + this.b + ",url=" + this.c + ")";
    }

    public re(int i, String str) {
        this.b = i;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeInt(this.b);
    }
}
