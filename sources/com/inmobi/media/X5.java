package com.inmobi.media;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class X5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        long j = parcel.readLong();
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        String str4 = string4 == null ? "" : string4;
        String string5 = parcel.readString();
        String str5 = string5 == null ? "" : string5;
        String string6 = parcel.readString();
        String str6 = string6 == null ? "" : string6;
        boolean z = parcel.readByte() != 0;
        String string7 = parcel.readString();
        C3297a6 c3297a6 = new C3297a6(j, str, str2, str3, str4, str5, str6, z, string7 == null ? "" : string7);
        String string8 = parcel.readString();
        Z5 z5 = new Z5(c3297a6, string8 == null ? "" : string8, parcel.readInt(), parcel.readLong());
        z5.f = parcel.readInt();
        z5.g = parcel.readString();
        return z5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Z5[i];
    }
}
