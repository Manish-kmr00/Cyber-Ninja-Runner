package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public final class oi0 implements g01.b {
    public static final Parcelable.Creator<oi0> CREATOR = new a();
    public final byte[] b;
    public final String c;
    public final String d;

    final class a implements Parcelable.Creator<oi0> {
        @Override // android.os.Parcelable.Creator
        public final oi0 createFromParcel(Parcel parcel) {
            return new oi0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final oi0[] newArray(int i) {
            return new oi0[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    oi0(Parcel parcel) {
        this.b = (byte[]) hg.a(parcel.createByteArray());
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    @Override // com.yandex.mobile.ads.impl.g01.b
    public final void a(iw0.a aVar) {
        String str = this.c;
        if (str != null) {
            aVar.i(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || oi0.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((oi0) obj).b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public final String toString() {
        return "ICY: title=\"" + this.c + "\", url=\"" + this.d + "\", rawMetadata.length=\"" + this.b.length + "\"";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public oi0(byte[] bArr, String str, String str2) {
        this.b = bArr;
        this.c = str;
        this.d = str2;
    }
}
