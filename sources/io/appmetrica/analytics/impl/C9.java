package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public abstract class C9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f11086a;
    public static final EnumSet b;
    public static final EnumSet c;
    public static final EnumSet d;
    public static final EnumSet e;
    public static final EnumSet f;
    public static final EnumSet g;
    public static final EnumSet h;
    public static final List i;
    public static final List j;

    static {
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        EnumC4164hb enumC4164hb2 = EnumC4164hb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        EnumC4164hb enumC4164hb3 = EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        EnumC4164hb enumC4164hb4 = EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        EnumC4164hb enumC4164hb5 = EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT;
        EnumC4164hb enumC4164hb6 = EnumC4164hb.EVENT_TYPE_ANR;
        f11086a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        EnumC4164hb enumC4164hb7 = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        EnumC4164hb enumC4164hb8 = EnumC4164hb.EVENT_TYPE_PURGE_BUFFER;
        EnumC4164hb enumC4164hb9 = EnumC4164hb.EVENT_TYPE_SEND_REFERRER;
        EnumC4164hb enumC4164hb10 = EnumC4164hb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        EnumC4164hb enumC4164hb11 = EnumC4164hb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        EnumC4164hb enumC4164hb12 = EnumC4164hb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        EnumC4164hb enumC4164hb13 = EnumC4164hb.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(enumC4164hb7, enumC4164hb8, enumC4164hb9, enumC4164hb10, enumC4164hb11, EnumC4164hb.EVENT_TYPE_ACTIVATION, enumC4164hb12, enumC4164hb13);
        c = EnumSet.of(EnumC4164hb.EVENT_TYPE_UPDATE_FOREGROUND_TIME, enumC4164hb4);
        EnumC4164hb enumC4164hb14 = EnumC4164hb.EVENT_TYPE_REGULAR;
        d = EnumSet.of(enumC4164hb4, enumC4164hb5, enumC4164hb3, enumC4164hb, enumC4164hb2, EnumC4164hb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, enumC4164hb12, enumC4164hb14, EnumC4164hb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, EnumC4164hb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, EnumC4164hb.EVENT_TYPE_SEND_REVENUE_EVENT, EnumC4164hb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, enumC4164hb8, EnumC4164hb.EVENT_TYPE_INIT, EnumC4164hb.EVENT_TYPE_SEND_USER_PROFILE, EnumC4164hb.EVENT_TYPE_SET_USER_PROFILE_ID, enumC4164hb9, enumC4164hb10, enumC4164hb11, EnumC4164hb.EVENT_TYPE_FIRST_ACTIVATION, EnumC4164hb.EVENT_TYPE_START, EnumC4164hb.EVENT_TYPE_APP_OPEN, EnumC4164hb.EVENT_TYPE_APP_UPDATE, enumC4164hb6);
        e = EnumSet.of(enumC4164hb14);
        f = EnumSet.of(enumC4164hb14);
        g = EnumSet.of(enumC4164hb12);
        h = EnumSet.of(EnumC4164hb.EVENT_TYPE_ALIVE, enumC4164hb8, enumC4164hb13);
        i = Arrays.asList(0, 6145, Integer.valueOf(FragmentTransaction.TRANSIT_FRAGMENT_OPEN), 8224);
        EnumC4164hb enumC4164hb15 = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        j = Arrays.asList(12290);
    }
}
