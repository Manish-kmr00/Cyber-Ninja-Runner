package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class al1 extends qi0 {
    public static final Parcelable.Creator<al1> CREATOR = new a();
    public final String c;
    public final byte[] d;

    final class a implements Parcelable.Creator<al1> {
        @Override // android.os.Parcelable.Creator
        public final al1 createFromParcel(Parcel parcel) {
            return new al1(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final al1[] newArray(int i) {
            return new al1[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0
    public final String toString() {
        return this.b + ": owner=" + this.c;
    }

    al1(Parcel parcel) {
        super("PRIV");
        this.c = (String) x82.a(parcel.readString());
        this.d = (byte[]) x82.a(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || al1.class != obj.getClass()) {
            return false;
        }
        al1 al1Var = (al1) obj;
        return x82.a(this.c, al1Var.c) && Arrays.equals(this.d, al1Var.d);
    }

    public final int hashCode() {
        String str = this.c;
        return Arrays.hashCode(this.d) + (((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeByteArray(this.d);
    }

    public al1(String str, byte[] bArr) {
        super("PRIV");
        this.c = str;
        this.d = bArr;
    }
}
