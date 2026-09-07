package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public final class c40 implements Comparator<b>, Parcelable {
    public static final Parcelable.Creator<c40> CREATOR = new a();
    private final b[] b;
    private int c;
    public final String d;
    public final int e;

    final class a implements Parcelable.Creator<c40> {
        @Override // android.os.Parcelable.Creator
        public final c40 createFromParcel(Parcel parcel) {
            return new c40(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final c40[] newArray(int i) {
            return new c40[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final int compare(b bVar, b bVar2) {
        b bVar3 = bVar;
        b bVar4 = bVar2;
        UUID uuid = qm.f10035a;
        if (uuid.equals(bVar3.c)) {
            return uuid.equals(bVar4.c) ? 0 : 1;
        }
        return bVar3.c.compareTo(bVar4.c);
    }

    c40(Parcel parcel) {
        this.d = parcel.readString();
        b[] bVarArr = (b[]) x82.a((b[]) parcel.createTypedArray(b.CREATOR));
        this.b = bVarArr;
        this.e = bVarArr.length;
    }

    public final c40 a(String str) {
        return x82.a(this.d, str) ? this : new c40(str, false, this.b);
    }

    public final int hashCode() {
        if (this.c == 0) {
            String str = this.d;
            this.c = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.b);
        }
        return this.c;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c40.class != obj.getClass()) {
            return false;
        }
        c40 c40Var = (c40) obj;
        return x82.a(this.d, c40Var.d) && Arrays.equals(this.b, c40Var.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeTypedArray(this.b, 0);
    }

    private c40(String str, boolean z, b... bVarArr) {
        this.d = str;
        bVarArr = z ? (b[]) bVarArr.clone() : bVarArr;
        this.b = bVarArr;
        this.e = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public c40(ArrayList arrayList) {
        this(null, false, (b[]) arrayList.toArray(new b[0]));
    }

    public c40(b... bVarArr) {
        this(null, true, bVarArr);
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();
        private int b;
        public final UUID c;
        public final String d;
        public final String e;
        public final byte[] f;

        final class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i) {
                return new b[i];
            }

            a() {
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        b(Parcel parcel) {
            this.c = new UUID(parcel.readLong(), parcel.readLong());
            this.d = parcel.readString();
            this.e = (String) x82.a(parcel.readString());
            this.f = parcel.createByteArray();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return x82.a(this.d, bVar.d) && x82.a(this.e, bVar.e) && x82.a(this.c, bVar.c) && Arrays.equals(this.f, bVar.f);
        }

        public final int hashCode() {
            if (this.b == 0) {
                int iHashCode = this.c.hashCode() * 31;
                String str = this.d;
                this.b = Arrays.hashCode(this.f) + v3.a(this.e, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
            }
            return this.b;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.c.getMostSignificantBits());
            parcel.writeLong(this.c.getLeastSignificantBits());
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeByteArray(this.f);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.c = (UUID) hg.a(uuid);
            this.d = str;
            this.e = (String) hg.a(str2);
            this.f = bArr;
        }
    }

    public final b a(int i) {
        return this.b[i];
    }
}
