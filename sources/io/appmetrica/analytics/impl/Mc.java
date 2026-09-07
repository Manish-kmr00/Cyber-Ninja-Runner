package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* JADX INFO: loaded from: classes5.dex */
public final class Mc {
    public static final SparseArray c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11257a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new Mc("jvm", "binder"));
        EnumC4164hb enumC4164hb2 = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new Mc("jvm", SDKConstants.PARAM_INTENT));
        EnumC4164hb enumC4164hb3 = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new Mc("jvm", "file"));
        EnumC4164hb enumC4164hb4 = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new Mc("jni_native", "file"));
        EnumC4164hb enumC4164hb5 = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new Mc("jni_native", "file"));
    }

    public Mc(String str, String str2) {
        this.f11257a = str;
        this.b = str2;
    }
}
