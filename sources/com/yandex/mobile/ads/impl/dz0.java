package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class dz0 implements Parcelable {
    public static final Parcelable.Creator<dz0> CREATOR = new a();
    private final List<hz0> b;
    private Map<String, String> c;

    public static final class a implements Parcelable.Creator<dz0> {
        @Override // android.os.Parcelable.Creator
        public final dz0 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(hz0.CREATOR.createFromParcel(parcel));
            }
            int i3 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new dz0(arrayList, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final dz0[] newArray(int i) {
            return new dz0[i];
        }
    }

    public dz0(ArrayList mediationNetworks, Map passbackParameters) {
        Intrinsics.checkNotNullParameter(mediationNetworks, "mediationNetworks");
        Intrinsics.checkNotNullParameter(passbackParameters, "passbackParameters");
        this.b = mediationNetworks;
        this.c = passbackParameters;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        List<hz0> list = this.b;
        out.writeInt(list.size());
        Iterator<hz0> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i);
        }
        Map<String, String> map = this.c;
        out.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
    }

    public final List<hz0> c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.c;
    }
}
