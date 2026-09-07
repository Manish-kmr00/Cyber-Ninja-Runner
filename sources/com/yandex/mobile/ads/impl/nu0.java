package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class nu0 implements g01.b {
    public static final Parcelable.Creator<nu0> CREATOR = new a();
    public final String b;
    public final byte[] c;
    public final int d;
    public final int e;

    final class a implements Parcelable.Creator<nu0> {
        @Override // android.os.Parcelable.Creator
        public final nu0 createFromParcel(Parcel parcel) {
            return new nu0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final nu0[] newArray(int i) {
            return new nu0[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "mdta: key=" + this.b;
    }

    public nu0(int i, int i2, String str, byte[] bArr) {
        this.b = str;
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }

    private nu0(Parcel parcel) {
        this.b = (String) x82.a(parcel.readString());
        this.c = (byte[]) x82.a(parcel.createByteArray());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || nu0.class != obj.getClass()) {
            return false;
        }
        nu0 nu0Var = (nu0) obj;
        return this.b.equals(nu0Var.b) && Arrays.equals(this.c, nu0Var.c) && this.d == nu0Var.d && this.e == nu0Var.e;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.c) + v3.a(this.b, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31)) * 31) + this.d) * 31) + this.e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
