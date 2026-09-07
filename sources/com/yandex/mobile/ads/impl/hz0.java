package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class hz0 implements Parcelable {
    public static final Parcelable.Creator<hz0> CREATOR = new a();
    private final String b;
    private final Map<String, String> c;
    private final List<String> d;
    private final List<String> e;
    private final List<String> f;
    private final t4 g;
    private final Map<String, String> h;

    public static final class a implements Parcelable.Creator<hz0> {
        @Override // android.os.Parcelable.Creator
        public final hz0 createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i);
            for (int i2 = 0; i2 != i; i2++) {
                linkedHashMap2.put(parcel.readString(), parcel.readString());
            }
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList3 = parcel.createStringArrayList();
            t4 t4VarCreateFromParcel = parcel.readInt() == 0 ? null : t4.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i3 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            return new hz0(string, linkedHashMap2, arrayListCreateStringArrayList, arrayListCreateStringArrayList2, arrayListCreateStringArrayList3, t4VarCreateFromParcel, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final hz0[] newArray(int i) {
            return new hz0[i];
        }
    }

    public hz0(String adapter, Map<String, String> networkData, List<String> list, List<String> list2, List<String> list3, t4 t4Var, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(networkData, "networkData");
        this.b = adapter;
        this.c = networkData;
        this.d = list;
        this.e = list2;
        this.f = list3;
        this.g = t4Var;
        this.h = map;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hz0)) {
            return false;
        }
        hz0 hz0Var = (hz0) obj;
        return Intrinsics.areEqual(this.b, hz0Var.b) && Intrinsics.areEqual(this.c, hz0Var.c) && Intrinsics.areEqual(this.d, hz0Var.d) && Intrinsics.areEqual(this.e, hz0Var.e) && Intrinsics.areEqual(this.f, hz0Var.f) && Intrinsics.areEqual(this.g, hz0Var.g) && Intrinsics.areEqual(this.h, hz0Var.h);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + (this.b.hashCode() * 31)) * 31;
        List<String> list = this.d;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.e;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.f;
        int iHashCode4 = (iHashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
        t4 t4Var = this.g;
        int iHashCode5 = (iHashCode4 + (t4Var == null ? 0 : t4Var.hashCode())) * 31;
        Map<String, String> map = this.h;
        return iHashCode5 + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        return "MediationNetwork(adapter=" + this.b + ", networkData=" + this.c + ", impressionTrackingUrls=" + this.d + ", clickTrackingUrls=" + this.e + ", adResponseTrackingUrls=" + this.f + ", adImpressionData=" + this.g + ", biddingInfo=" + this.h + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
        Map<String, String> map = this.c;
        out.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
        out.writeStringList(this.d);
        out.writeStringList(this.e);
        out.writeStringList(this.f);
        t4 t4Var = this.g;
        if (t4Var == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            t4Var.writeToParcel(out, i);
        }
        Map<String, String> map2 = this.h;
        if (map2 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(map2.size());
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            out.writeString(entry2.getKey());
            out.writeString(entry2.getValue());
        }
    }

    public final String e() {
        return this.b;
    }

    public final Map<String, String> i() {
        return this.c;
    }

    public final List<String> h() {
        return this.d;
    }

    public final List<String> g() {
        return this.e;
    }

    public final List<String> d() {
        return this.f;
    }

    public final t4 c() {
        return this.g;
    }

    public final Map<String, String> f() {
        return this.h;
    }
}
