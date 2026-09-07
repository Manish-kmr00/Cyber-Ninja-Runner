package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes4.dex */
public final class rq extends qi0 {
    public static final Parcelable.Creator<rq> CREATOR = new a();
    public final String c;
    public final String d;
    public final String e;

    final class a implements Parcelable.Creator<rq> {
        @Override // android.os.Parcelable.Creator
        public final rq createFromParcel(Parcel parcel) {
            return new rq(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final rq[] newArray(int i) {
            return new rq[i];
        }

        a() {
        }
    }

    @Override // com.yandex.mobile.ads.impl.qi0
    public final String toString() {
        return this.b + ": language=" + this.c + ", description=" + this.d;
    }

    rq(Parcel parcel) {
        super("COMM");
        this.c = (String) x82.a(parcel.readString());
        this.d = (String) x82.a(parcel.readString());
        this.e = (String) x82.a(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rq.class != obj.getClass()) {
            return false;
        }
        rq rqVar = (rq) obj;
        return x82.a(this.d, rqVar.d) && x82.a(this.c, rqVar.c) && x82.a(this.e, rqVar.e);
    }

    public final int hashCode() {
        String str = this.c;
        int iHashCode = ((str != null ? str.hashCode() : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String str2 = this.d;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
    }

    public rq(String str, String str2, String str3) {
        super("COMM");
        this.c = str;
        this.d = str2;
        this.e = str3;
    }
}
