package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class hl extends qi0 {
    public static final Parcelable.Creator<hl> CREATOR = new a();
    public final byte[] c;

    final class a implements Parcelable.Creator<hl> {
        @Override // android.os.Parcelable.Creator
        public final hl createFromParcel(Parcel parcel) {
            return new hl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final hl[] newArray(int i) {
            return new hl[i];
        }

        a() {
        }
    }

    hl(Parcel parcel) {
        super((String) x82.a(parcel.readString()));
        this.c = (byte[]) x82.a(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || hl.class != obj.getClass()) {
            return false;
        }
        hl hlVar = (hl) obj;
        return this.b.equals(hlVar.b) && Arrays.equals(this.c, hlVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.c) + v3.a(this.b, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
    }

    public hl(String str, byte[] bArr) {
        super(str);
        this.c = bArr;
    }
}
