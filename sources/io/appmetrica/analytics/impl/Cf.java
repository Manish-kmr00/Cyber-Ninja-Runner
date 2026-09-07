package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public abstract class Cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f11090a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap map = new HashMap();
        EnumC4621zk enumC4621zk = EnumC4621zk.FOREGROUND;
        map.put(enumC4621zk, 0);
        EnumC4621zk enumC4621zk2 = EnumC4621zk.BACKGROUND;
        map.put(enumC4621zk2, 1);
        f11090a = Collections.unmodifiableMap(map);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, enumC4621zk);
        sparseArray.put(1, enumC4621zk2);
        b = sparseArray;
        HashMap map2 = new HashMap();
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_INIT;
        map2.put(enumC4164hb, 1);
        EnumC4164hb enumC4164hb2 = EnumC4164hb.EVENT_TYPE_REGULAR;
        map2.put(enumC4164hb2, 4);
        EnumC4164hb enumC4164hb3 = EnumC4164hb.EVENT_TYPE_SEND_REFERRER;
        map2.put(enumC4164hb3, 5);
        EnumC4164hb enumC4164hb4 = EnumC4164hb.EVENT_TYPE_ALIVE;
        map2.put(enumC4164hb4, 7);
        EnumC4164hb enumC4164hb5 = EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        map2.put(enumC4164hb5, 26);
        EnumC4164hb enumC4164hb6 = EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT;
        map2.put(enumC4164hb6, 26);
        EnumC4164hb enumC4164hb7 = EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        map2.put(enumC4164hb7, 26);
        EnumC4164hb enumC4164hb8 = EnumC4164hb.EVENT_TYPE_ANR;
        map2.put(enumC4164hb8, 25);
        EnumC4164hb enumC4164hb9 = EnumC4164hb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        map2.put(enumC4164hb9, 26);
        EnumC4164hb enumC4164hb10 = EnumC4164hb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        map2.put(enumC4164hb10, 26);
        EnumC4164hb enumC4164hb11 = EnumC4164hb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        map2.put(enumC4164hb11, 27);
        EnumC4164hb enumC4164hb12 = EnumC4164hb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        map2.put(enumC4164hb12, 27);
        EnumC4164hb enumC4164hb13 = EnumC4164hb.EVENT_TYPE_FIRST_ACTIVATION;
        map2.put(enumC4164hb13, 13);
        EnumC4164hb enumC4164hb14 = EnumC4164hb.EVENT_TYPE_START;
        map2.put(enumC4164hb14, 2);
        EnumC4164hb enumC4164hb15 = EnumC4164hb.EVENT_TYPE_APP_OPEN;
        map2.put(enumC4164hb15, 16);
        EnumC4164hb enumC4164hb16 = EnumC4164hb.EVENT_TYPE_APP_UPDATE;
        map2.put(enumC4164hb16, 17);
        EnumC4164hb enumC4164hb17 = EnumC4164hb.EVENT_TYPE_PERMISSIONS;
        map2.put(enumC4164hb17, 18);
        EnumC4164hb enumC4164hb18 = EnumC4164hb.EVENT_TYPE_APP_FEATURES;
        map2.put(enumC4164hb18, 19);
        EnumC4164hb enumC4164hb19 = EnumC4164hb.EVENT_TYPE_SEND_USER_PROFILE;
        map2.put(enumC4164hb19, 20);
        EnumC4164hb enumC4164hb20 = EnumC4164hb.EVENT_TYPE_SEND_REVENUE_EVENT;
        map2.put(enumC4164hb20, 21);
        EnumC4164hb enumC4164hb21 = EnumC4164hb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        map2.put(enumC4164hb21, 40);
        EnumC4164hb enumC4164hb22 = EnumC4164hb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        map2.put(enumC4164hb22, 35);
        map2.put(EnumC4164hb.EVENT_TYPE_CLEANUP, 29);
        EnumC4164hb enumC4164hb23 = EnumC4164hb.EVENT_TYPE_WEBVIEW_SYNC;
        map2.put(enumC4164hb23, 38);
        EnumC4164hb enumC4164hb24 = EnumC4164hb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        map2.put(enumC4164hb24, 42);
        c = Collections.unmodifiableMap(map2);
        HashMap map3 = new HashMap();
        B8 b8 = new B8();
        H8 h8 = new H8(new L8());
        C8 c8 = new C8();
        C4529w3 c4529w3 = new C4529w3(new L8());
        C4300mn c4300mn = new C4300mn(new L8());
        C4591yf c4591yf = new C4591yf();
        Z8 z8A = C3987a9.a();
        z8A.b = c4591yf;
        z8A.c = c4591yf;
        C3987a9 c3987a9 = new C3987a9(z8A);
        Z8 z8A2 = C3987a9.a();
        z8A2.b = h8;
        C3987a9 c3987a10 = new C3987a9(z8A2);
        Z8 z8A3 = C3987a9.a();
        z8A3.b = c4529w3;
        C3987a9 c3987a11 = new C3987a9(z8A3);
        Z8 z8A4 = C3987a9.a();
        z8A4.b = c4300mn;
        C3987a9 c3987a12 = new C3987a9(z8A4);
        Z8 z8A5 = C3987a9.a();
        z8A5.f11447a = b8;
        C3987a9 c3987a13 = new C3987a9(z8A5);
        Z8 z8A6 = C3987a9.a();
        z8A6.b = new Rn(new H8());
        C3987a9 c3987a14 = new C3987a9(z8A6);
        map3.put(enumC4164hb2, c3987a10);
        Z8 z8A7 = C3987a9.a();
        z8A7.b = new Af();
        map3.put(enumC4164hb3, new C3987a9(z8A7));
        Z8 z8A8 = C3987a9.a();
        z8A8.f11447a = b8;
        z8A8.b = c8;
        z8A8.e = new C4036c8();
        z8A8.f = new C4061d8();
        map3.put(enumC4164hb4, new C3987a9(z8A8));
        map3.put(enumC4164hb9, c3987a9);
        map3.put(enumC4164hb10, c3987a9);
        map3.put(enumC4164hb11, c3987a11);
        map3.put(enumC4164hb12, c3987a11);
        map3.put(enumC4164hb5, c3987a11);
        map3.put(enumC4164hb6, c3987a11);
        map3.put(enumC4164hb7, c3987a11);
        map3.put(enumC4164hb8, c3987a11);
        Z8 z8A9 = C3987a9.a();
        z8A9.f11447a = new B8();
        z8A9.b = c4529w3;
        map3.put(enumC4164hb14, new C3987a9(z8A9));
        EnumC4164hb enumC4164hb25 = EnumC4164hb.EVENT_TYPE_CUSTOM_EVENT;
        Z8 z8A10 = C3987a9.a();
        z8A10.d = new Bf();
        map3.put(enumC4164hb25, new C3987a9(z8A10));
        map3.put(enumC4164hb15, c3987a10);
        map3.put(enumC4164hb17, c3987a13);
        map3.put(enumC4164hb18, c3987a13);
        map3.put(enumC4164hb19, c3987a11);
        map3.put(enumC4164hb20, c3987a11);
        map3.put(enumC4164hb21, c3987a11);
        map3.put(enumC4164hb22, c3987a12);
        map3.put(enumC4164hb, c3987a14);
        map3.put(enumC4164hb16, c3987a14);
        map3.put(enumC4164hb13, c3987a10);
        map3.put(enumC4164hb23, c3987a10);
        map3.put(enumC4164hb24, c3987a11);
        d = Collections.unmodifiableMap(map3);
    }

    public static C4336o9 a(Long l, Long l2, Boolean bool) {
        C4336o9 c4336o9 = new C4336o9();
        if (l != null) {
            c4336o9.f11700a = l.longValue();
            c4336o9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            c4336o9.c = l2.longValue();
        }
        if (bool != null) {
            c4336o9.d = bool.booleanValue();
        }
        return c4336o9;
    }

    public static void a(C4286m9 c4286m9) {
        C4236k9[] c4236k9Arr = c4286m9.c;
        if (c4236k9Arr != null) {
            for (C4236k9 c4236k9 : c4236k9Arr) {
            }
        }
    }
}
