package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ho extends qi0 {
    public static final Parcelable.Creator<ho> CREATOR = new a();
    public final String c;
    public final int d;
    public final int e;
    public final long f;
    public final long g;
    private final qi0[] h;

    final class a implements Parcelable.Creator<ho> {
        @Override // android.os.Parcelable.Creator
        public final ho createFromParcel(Parcel parcel) {
            return new ho(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ho[] newArray(int i) {
            return new ho[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    ho(Parcel parcel) {
        super("CHAP");
        this.c = (String) x82.a(parcel.readString());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        int i = parcel.readInt();
        this.h = new qi0[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.h[i2] = (qi0) parcel.readParcelable(qi0.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ho.class != obj.getClass()) {
            return false;
        }
        ho hoVar = (ho) obj;
        return this.d == hoVar.d && this.e == hoVar.e && this.f == hoVar.f && this.g == hoVar.g && x82.a(this.c, hoVar.c) && Arrays.equals(this.h, hoVar.h);
    }

    public final int hashCode() {
        int i = (((((((this.d + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.e) * 31) + ((int) this.f)) * 31) + ((int) this.g)) * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        parcel.writeInt(this.h.length);
        for (qi0 qi0Var : this.h) {
            parcel.writeParcelable(qi0Var, 0);
        }
    }

    public ho(String str, int i, int i2, long j, long j2, qi0[] qi0VarArr) {
        super("CHAP");
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = j;
        this.g = j2;
        this.h = qi0VarArr;
    }
}
