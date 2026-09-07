package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class io extends qi0 {
    public static final Parcelable.Creator<io> CREATOR = new a();
    public final String c;
    public final boolean d;
    public final boolean e;
    public final String[] f;
    private final qi0[] g;

    final class a implements Parcelable.Creator<io> {
        @Override // android.os.Parcelable.Creator
        public final io createFromParcel(Parcel parcel) {
            return new io(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final io[] newArray(int i) {
            return new io[i];
        }

        a() {
        }
    }

    io(Parcel parcel) {
        super("CTOC");
        this.c = (String) x82.a(parcel.readString());
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = (String[]) x82.a(parcel.createStringArray());
        int i = parcel.readInt();
        this.g = new qi0[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.g[i2] = (qi0) parcel.readParcelable(qi0.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || io.class != obj.getClass()) {
            return false;
        }
        io ioVar = (io) obj;
        return this.d == ioVar.d && this.e == ioVar.e && x82.a(this.c, ioVar.c) && Arrays.equals(this.f, ioVar.f) && Arrays.equals(this.g, ioVar.g);
    }

    public final int hashCode() {
        int i = ((((this.d ? 1 : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (this.e ? 1 : 0)) * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f);
        parcel.writeInt(this.g.length);
        for (qi0 qi0Var : this.g) {
            parcel.writeParcelable(qi0Var, 0);
        }
    }

    public io(String str, boolean z, boolean z2, String[] strArr, qi0[] qi0VarArr) {
        super("CTOC");
        this.c = str;
        this.d = z;
        this.e = z2;
        this.f = strArr;
        this.g = qi0VarArr;
    }
}
