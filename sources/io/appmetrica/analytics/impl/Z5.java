package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class Z5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        EnumC4435s9 enumC4435s9;
        Bundle bundle = parcel.readBundle(I6.class.getClassLoader());
        if (bundle.containsKey("CounterReport.Source")) {
            int i = bundle.getInt("CounterReport.Source");
            EnumC4435s9[] enumC4435s9ArrValues = EnumC4435s9.values();
            int length = enumC4435s9ArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    enumC4435s9 = EnumC4435s9.NATIVE;
                    break;
                }
                enumC4435s9 = enumC4435s9ArrValues[i2];
                if (enumC4435s9.f11762a == i) {
                    break;
                }
                i2++;
            }
        } else {
            enumC4435s9 = null;
        }
        C3984a6 c3984a6 = new C3984a6("", "", 0);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = bundle.getInt("CounterReport.Type", -1);
        c3984a6.e = bundle.getInt("CounterReport.CustomType");
        c3984a6.b = StringUtils.ifIsNullToDef(bundle.getString("CounterReport.Value"), "");
        c3984a6.c = bundle.getString("CounterReport.Environment");
        c3984a6.f11459a = bundle.getString("CounterReport.Event");
        c3984a6.f = C3984a6.a(bundle);
        c3984a6.g = bundle.getInt("CounterReport.TRUNCATED");
        c3984a6.h = bundle.getString("CounterReport.ProfileID");
        c3984a6.i = bundle.getLong("CounterReport.CreationElapsedRealtime");
        c3984a6.j = bundle.getLong("CounterReport.CreationTimestamp");
        c3984a6.k = EnumC4237ka.a(Integer.valueOf(bundle.getInt("CounterReport.UniquenessStatus")));
        c3984a6.l = enumC4435s9;
        c3984a6.m = bundle.getBundle("CounterReport.Payload");
        c3984a6.n = bundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(bundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        c3984a6.o = bundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(bundle.getInt("CounterReport.OpenId")) : null;
        c3984a6.p = CollectionUtils.bundleToMap(bundle.getBundle("CounterReport.Extras"));
        return c3984a6;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new C3984a6[i];
    }
}
