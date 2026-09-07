package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class u01 extends qi0 {
    public static final Parcelable.Creator<u01> CREATOR = new a();
    public final int c;
    public final int d;
    public final int e;
    public final int[] f;
    public final int[] g;

    final class a implements Parcelable.Creator<u01> {
        @Override // android.os.Parcelable.Creator
        public final u01 createFromParcel(Parcel parcel) {
            return new u01(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final u01[] newArray(int i) {
            return new u01[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public u01(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = iArr;
        this.g = iArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u01.class != obj.getClass()) {
            return false;
        }
        u01 u01Var = (u01) obj;
        return this.c == u01Var.c && this.d == u01Var.d && this.e == u01Var.e && Arrays.equals(this.f, u01Var.f) && Arrays.equals(this.g, u01Var.g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.g) + ((Arrays.hashCode(this.f) + ((((((this.c + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.d) * 31) + this.e) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeIntArray(this.f);
        parcel.writeIntArray(this.g);
    }

    u01(Parcel parcel) {
        super("MLLT");
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = (int[]) x82.a(parcel.createIntArray());
        this.g = (int[]) x82.a(parcel.createIntArray());
    }
}
