package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public final class v50 implements g01.b {
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final byte[] f;
    private int g;
    private static final gc0 h = new gc0.a().e("application/id3").a();
    private static final gc0 i = new gc0.a().e("application/x-scte35").a();
    public static final Parcelable.Creator<v50> CREATOR = new a();

    final class a implements Parcelable.Creator<v50> {
        @Override // android.os.Parcelable.Creator
        public final v50 createFromParcel(Parcel parcel) {
            return new v50(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final v50[] newArray(int i) {
            return new v50[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.b + ", id=" + this.e + ", durationMs=" + this.d + ", value=" + this.c;
    }

    v50(Parcel parcel) {
        this.b = (String) x82.a(parcel.readString());
        this.c = (String) x82.a(parcel.readString());
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = (byte[]) x82.a(parcel.createByteArray());
    }

    @Override // com.yandex.mobile.ads.impl.g01.b
    public final gc0 a() {
        String str = this.b;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return i;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return h;
            default:
                return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.g01.b
    public final byte[] b() {
        if (a() != null) {
            return this.f;
        }
        return null;
    }

    public final int hashCode() {
        if (this.g == 0) {
            String str = this.b;
            int iHashCode = ((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
            String str2 = this.c;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j = this.d;
            int i2 = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.e;
            this.g = Arrays.hashCode(this.f) + ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31);
        }
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v50.class != obj.getClass()) {
            return false;
        }
        v50 v50Var = (v50) obj;
        return this.d == v50Var.d && this.e == v50Var.e && x82.a(this.b, v50Var.b) && x82.a(this.c, v50Var.c) && Arrays.equals(this.f, v50Var.f);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeByteArray(this.f);
    }

    public v50(String str, String str2, long j, long j2, byte[] bArr) {
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = j2;
        this.f = bArr;
    }
}
