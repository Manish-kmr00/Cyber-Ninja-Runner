package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r2 implements Parcelable {
    public static final Parcelable.Creator<r2> CREATOR = new a();
    private final String b;
    private final String c;
    private final String d;

    public static final class a implements Parcelable.Creator<r2> {
        @Override // android.os.Parcelable.Creator
        public final r2 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new r2(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final r2[] newArray(int i) {
            return new r2[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
        out.writeString(this.c);
        out.writeString(this.d);
    }

    public r2(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final String d() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }
}
