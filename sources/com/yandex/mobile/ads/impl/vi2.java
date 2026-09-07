package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class vi2 implements g01.b {
    public static final Parcelable.Creator<vi2> CREATOR = new a();
    public final String b;
    public final String c;

    final class a implements Parcelable.Creator<vi2> {
        @Override // android.os.Parcelable.Creator
        public final vi2 createFromParcel(Parcel parcel) {
            return new vi2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final vi2[] newArray(int i) {
            return new vi2[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "VC: " + this.b + "=" + this.c;
    }

    protected vi2(Parcel parcel) {
        this.b = (String) x82.a(parcel.readString());
        this.c = (String) x82.a(parcel.readString());
    }

    @Override // com.yandex.mobile.ads.impl.g01.b
    public final void a(iw0.a aVar) {
        String str = this.b;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "ALBUM":
                aVar.b(this.c);
                break;
            case "TITLE":
                aVar.i(this.c);
                break;
            case "DESCRIPTION":
                aVar.f(this.c);
                break;
            case "ALBUMARTIST":
                aVar.a(this.c);
                break;
            case "ARTIST":
                aVar.c(this.c);
                break;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        vi2 vi2Var = (vi2) obj;
        return this.b.equals(vi2Var.b) && this.c.equals(vi2Var.c);
    }

    public vi2(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public final int hashCode() {
        return this.c.hashCode() + v3.a(this.b, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
