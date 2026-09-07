package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g01 implements Parcelable {
    public static final Parcelable.Creator<g01> CREATOR = new a();
    private final b[] b;

    final class a implements Parcelable.Creator<g01> {
        @Override // android.os.Parcelable.Creator
        public final g01 createFromParcel(Parcel parcel) {
            return new g01(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final g01[] newArray(int i) {
            return new g01[i];
        }

        a() {
        }
    }

    public interface b extends Parcelable {
        default gc0 a() {
            return null;
        }

        default void a(iw0.a aVar) {
        }

        default byte[] b() {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "entries=" + Arrays.toString(this.b);
    }

    g01(Parcel parcel) {
        this.b = new b[parcel.readInt()];
        int i = 0;
        while (true) {
            b[] bVarArr = this.b;
            if (i >= bVarArr.length) {
                return;
            }
            bVarArr[i] = (b) parcel.readParcelable(b.class.getClassLoader());
            i++;
        }
    }

    public final int c() {
        return this.b.length;
    }

    public final g01 a(b... bVarArr) {
        return bVarArr.length == 0 ? this : new g01((b[]) x82.a((Object[]) this.b, (Object[]) bVarArr));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g01.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((g01) obj).b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b.length);
        for (b bVar : this.b) {
            parcel.writeParcelable(bVar, 0);
        }
    }

    public g01(List<? extends b> list) {
        this.b = (b[]) list.toArray(new b[0]);
    }

    public g01(b... bVarArr) {
        this.b = bVarArr;
    }

    public final g01 a(g01 g01Var) {
        return g01Var == null ? this : a(g01Var.b);
    }

    public final b a(int i) {
        return this.b[i];
    }
}
