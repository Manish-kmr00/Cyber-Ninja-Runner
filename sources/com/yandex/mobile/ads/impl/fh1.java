package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class fh1 implements g01.b {
    public static final Parcelable.Creator<fh1> CREATOR = new a();
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final byte[] i;

    final class a implements Parcelable.Creator<fh1> {
        @Override // android.os.Parcelable.Creator
        public final fh1 createFromParcel(Parcel parcel) {
            return new fh1(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final fh1[] newArray(int i) {
            return new fh1[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Picture: mimeType=" + this.c + ", description=" + this.d;
    }

    public fh1(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = bArr;
    }

    @Override // com.yandex.mobile.ads.impl.g01.b
    public final void a(iw0.a aVar) {
        aVar.a(this.b, this.i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fh1.class != obj.getClass()) {
            return false;
        }
        fh1 fh1Var = (fh1) obj;
        return this.b == fh1Var.b && this.c.equals(fh1Var.c) && this.d.equals(fh1Var.d) && this.e == fh1Var.e && this.f == fh1Var.f && this.g == fh1Var.g && this.h == fh1Var.h && Arrays.equals(this.i, fh1Var.i);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.i) + ((((((((v3.a(this.d, v3.a(this.c, (this.b + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31, 31), 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeByteArray(this.i);
    }

    fh1(Parcel parcel) {
        this.b = parcel.readInt();
        this.c = (String) x82.a(parcel.readString());
        this.d = (String) x82.a(parcel.readString());
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = (byte[]) x82.a(parcel.createByteArray());
    }
}
