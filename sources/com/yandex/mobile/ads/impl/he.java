package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class he extends qi0 {
    public static final Parcelable.Creator<he> CREATOR = new a();
    public final String c;
    public final String d;
    public final int e;
    public final byte[] f;

    final class a implements Parcelable.Creator<he> {
        @Override // android.os.Parcelable.Creator
        public final he createFromParcel(Parcel parcel) {
            return new he(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final he[] newArray(int i) {
            return new he[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0
    public final String toString() {
        return this.b + ": mimeType=" + this.c + ", description=" + this.d;
    }

    he(Parcel parcel) {
        super("APIC");
        this.c = (String) x82.a(parcel.readString());
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = (byte[]) x82.a(parcel.createByteArray());
    }

    @Override // com.yandex.mobile.ads.impl.g01.b
    public final void a(iw0.a aVar) {
        aVar.a(this.e, this.f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || he.class != obj.getClass()) {
            return false;
        }
        he heVar = (he) obj;
        return this.e == heVar.e && x82.a(this.c, heVar.c) && x82.a(this.d, heVar.d) && Arrays.equals(this.f, heVar.f);
    }

    public final int hashCode() {
        int i = (this.e + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str = this.c;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        return Arrays.hashCode(this.f) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public he(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeByteArray(this.f);
    }
}
