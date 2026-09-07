package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class kq0 implements Parcelable {
    public static final Parcelable.Creator<kq0> CREATOR = new a();
    private final String b;
    private final String c;
    private final boolean d;

    public static final class a implements Parcelable.Creator<kq0> {
        @Override // android.os.Parcelable.Creator
        public final kq0 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new kq0(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final kq0[] newArray(int i) {
            return new kq0[i];
        }
    }

    public kq0(String apiFramework, String url, boolean z) {
        Intrinsics.checkNotNullParameter(apiFramework, "apiFramework");
        Intrinsics.checkNotNullParameter(url, "url");
        this.b = apiFramework;
        this.c = url;
        this.d = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kq0)) {
            return false;
        }
        kq0 kq0Var = (kq0) obj;
        return Intrinsics.areEqual(this.b, kq0Var.b) && Intrinsics.areEqual(this.c, kq0Var.c) && this.d == kq0Var.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + v3.a(this.c, this.b.hashCode() * 31, 31);
    }

    public final String toString() {
        return "JavaScriptResource(apiFramework=" + this.b + ", url=" + this.c + ", browserOptional=" + this.d + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
        out.writeString(this.c);
        out.writeInt(this.d ? 1 : 0);
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }
}
