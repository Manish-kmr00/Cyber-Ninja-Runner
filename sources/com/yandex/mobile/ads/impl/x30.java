package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class x30 implements Parcelable {
    public static final Parcelable.Creator<x30> CREATOR = new a();
    public final String b;
    public final Uri c;
    public final String d;
    public final List<p22> e;
    public final byte[] f;
    public final String g;
    public final byte[] h;

    final class a implements Parcelable.Creator<x30> {
        @Override // android.os.Parcelable.Creator
        public final x30 createFromParcel(Parcel parcel) {
            return new x30(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final x30[] newArray(int i) {
            return new x30[i];
        }

        a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10618a;
        private final Uri b;
        private String c;
        private List<p22> d;
        private byte[] e;
        private String f;
        private byte[] g;

        public b(Uri uri, String str) {
            this.f10618a = str;
            this.b = uri;
        }

        public final b b(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public final x30 a() {
            String str = this.f10618a;
            Uri uri = this.b;
            String str2 = this.c;
            List listH = this.d;
            if (listH == null) {
                listH = hk0.h();
            }
            return new x30(str, uri, str2, listH, this.e, this.f, this.g);
        }

        public final b b(String str) {
            this.c = str;
            return this;
        }

        public final b a(String str) {
            this.f = str;
            return this;
        }

        public final b a(byte[] bArr) {
            this.g = bArr;
            return this;
        }

        public final b a(ArrayList arrayList) {
            this.d = arrayList;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.d + ":" + this.b;
    }

    x30(Parcel parcel) {
        this.b = (String) x82.a(parcel.readString());
        this.c = Uri.parse((String) x82.a(parcel.readString()));
        this.d = parcel.readString();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add((p22) parcel.readParcelable(p22.class.getClassLoader()));
        }
        this.e = Collections.unmodifiableList(arrayList);
        this.f = parcel.createByteArray();
        this.g = parcel.readString();
        this.h = (byte[]) x82.a(parcel.createByteArray());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    public final x30 a(x30 x30Var) {
        ?? EmptyList;
        if (this.b.equals(x30Var.b)) {
            if (!this.e.isEmpty() && !x30Var.e.isEmpty()) {
                EmptyList = new ArrayList(this.e);
                for (int i = 0; i < x30Var.e.size(); i++) {
                    p22 p22Var = x30Var.e.get(i);
                    if (!EmptyList.contains(p22Var)) {
                        EmptyList.add(p22Var);
                    }
                }
            } else {
                EmptyList = Collections.emptyList();
            }
            return new x30(this.b, x30Var.c, x30Var.d, EmptyList, x30Var.f, x30Var.g, x30Var.h);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x30)) {
            return false;
        }
        x30 x30Var = (x30) obj;
        return this.b.equals(x30Var.b) && this.c.equals(x30Var.c) && x82.a(this.d, x30Var.d) && this.e.equals(x30Var.e) && Arrays.equals(this.f, x30Var.f) && x82.a(this.g, x30Var.g) && Arrays.equals(this.h, x30Var.h);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + (this.b.hashCode() * 961)) * 31;
        String str = this.d;
        int iHashCode2 = (Arrays.hashCode(this.f) + ((this.e.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31;
        String str2 = this.g;
        return Arrays.hashCode(this.h) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c.toString());
        parcel.writeString(this.d);
        parcel.writeInt(this.e.size());
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            parcel.writeParcelable(this.e.get(i2), 0);
        }
        parcel.writeByteArray(this.f);
        parcel.writeString(this.g);
        parcel.writeByteArray(this.h);
    }

    private x30(String str, Uri uri, String str2, List<p22> list, byte[] bArr, String str3, byte[] bArr2) {
        int iA = x82.a(uri, str2);
        if (iA == 0 || iA == 2 || iA == 1) {
            hg.a("customCacheKey must be null for type: " + iA, str3 == null);
        }
        this.b = str;
        this.c = uri;
        this.d = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.e = Collections.unmodifiableList(arrayList);
        this.f = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.g = str3;
        this.h = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : x82.f;
    }
}
