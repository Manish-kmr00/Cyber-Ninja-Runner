package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public final class ge0 extends qi0 {
    public static final Parcelable.Creator<ge0> CREATOR = new a();
    public final String c;
    public final String d;
    public final String e;
    public final byte[] f;

    final class a implements Parcelable.Creator<ge0> {
        @Override // android.os.Parcelable.Creator
        public final ge0 createFromParcel(Parcel parcel) {
            return new ge0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ge0[] newArray(int i) {
            return new ge0[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0
    public final String toString() {
        return this.b + ": mimeType=" + this.c + ", filename=" + this.d + ", description=" + this.e;
    }

    ge0(Parcel parcel) {
        super("GEOB");
        this.c = (String) x82.a(parcel.readString());
        this.d = (String) x82.a(parcel.readString());
        this.e = (String) x82.a(parcel.readString());
        this.f = (byte[]) x82.a(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ge0.class != obj.getClass()) {
            return false;
        }
        ge0 ge0Var = (ge0) obj;
        return x82.a(this.c, ge0Var.c) && x82.a(this.d, ge0Var.d) && x82.a(this.e, ge0Var.e) && Arrays.equals(this.f, ge0Var.f);
    }

    public final int hashCode() {
        String str = this.c;
        int iHashCode = ((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str2 = this.d;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        return Arrays.hashCode(this.f) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public ge0(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeByteArray(this.f);
    }
}
