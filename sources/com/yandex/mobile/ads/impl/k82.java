package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes10.dex */
public final class k82 extends qi0 {
    public static final Parcelable.Creator<k82> CREATOR = new a();
    public final String c;
    public final String d;

    final class a implements Parcelable.Creator<k82> {
        @Override // android.os.Parcelable.Creator
        public final k82 createFromParcel(Parcel parcel) {
            return new k82(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final k82[] newArray(int i) {
            return new k82[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0
    public final String toString() {
        return this.b + ": url=" + this.d;
    }

    k82(Parcel parcel) {
        super((String) x82.a(parcel.readString()));
        this.c = parcel.readString();
        this.d = (String) x82.a(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k82.class != obj.getClass()) {
            return false;
        }
        k82 k82Var = (k82) obj;
        return this.b.equals(k82Var.b) && x82.a(this.c, k82Var.c) && x82.a(this.d, k82Var.d);
    }

    public final int hashCode() {
        int iA = v3.a(this.b, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31);
        String str = this.c;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public k82(String str, String str2, String str3) {
        super(str);
        this.c = str2;
        this.d = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
