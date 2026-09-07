package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes10.dex */
public final class m02 implements g01.b {
    public static final Parcelable.Creator<m02> CREATOR = new a();
    public final float b;
    public final int c;

    final class a implements Parcelable.Creator<m02> {
        @Override // android.os.Parcelable.Creator
        public final m02 createFromParcel(Parcel parcel) {
            return new m02(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final m02[] newArray(int i) {
            return new m02[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.b + ", svcTemporalLayerCount=" + this.c;
    }

    public m02(int i, float f) {
        this.b = f;
        this.c = i;
    }

    private m02(Parcel parcel) {
        this.b = parcel.readFloat();
        this.c = parcel.readInt();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m02.class != obj.getClass()) {
            return false;
        }
        m02 m02Var = (m02) obj;
        return this.b == m02Var.b && this.c == m02Var.c;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.b).hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.b);
        parcel.writeInt(this.c);
    }
}
