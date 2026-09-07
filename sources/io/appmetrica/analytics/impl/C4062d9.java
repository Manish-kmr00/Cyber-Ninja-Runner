package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.d9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C4062d9 extends AbstractC4392qf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4195ii f11512a;
    public final HashMap b;
    public final H4 c;

    public C4062d9(C4282m5 c4282m5) {
        C4195ii c4195ii = new C4195ii(c4282m5);
        this.f11512a = c4195ii;
        this.c = new H4(c4195ii);
        this.b = a();
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        map.put(EnumC4164hb.EVENT_TYPE_ACTIVATION, new C4152h(this.f11512a));
        map.put(EnumC4164hb.EVENT_TYPE_START, new C4149gl(this.f11512a));
        map.put(EnumC4164hb.EVENT_TYPE_REGULAR, new C4517vg(this.f11512a));
        C4338ob c4338ob = new C4338ob(this.f11512a);
        map.put(EnumC4164hb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c4338ob);
        map.put(EnumC4164hb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c4338ob);
        map.put(EnumC4164hb.EVENT_TYPE_SEND_REFERRER, c4338ob);
        map.put(EnumC4164hb.EVENT_TYPE_CUSTOM_EVENT, c4338ob);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_SET_SESSION_EXTRA;
        C4195ii c4195ii = this.f11512a;
        map.put(enumC4164hb, new C4024bl(c4195ii, c4195ii.t));
        map.put(EnumC4164hb.EVENT_TYPE_APP_OPEN, new Cg(this.f11512a));
        map.put(EnumC4164hb.EVENT_TYPE_PURGE_BUFFER, new Ef(this.f11512a));
        map.put(EnumC4164hb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C4607z6(this.f11512a));
        map.put(EnumC4164hb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new C4242kf(this.f11512a));
        map.put(EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new C4449sn(this.f11512a));
        C4424rn c4424rn = new C4424rn(this.f11512a);
        map.put(EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, c4424rn);
        map.put(EnumC4164hb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT, c4424rn);
        map.put(EnumC4164hb.EVENT_TYPE_ANR, c4338ob);
        EnumC4164hb enumC4164hb2 = EnumC4164hb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        C4195ii c4195ii2 = this.f11512a;
        map.put(enumC4164hb2, new C4024bl(c4195ii2, c4195ii2.e));
        EnumC4164hb enumC4164hb3 = EnumC4164hb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        C4195ii c4195ii3 = this.f11512a;
        map.put(enumC4164hb3, new C4024bl(c4195ii3, c4195ii3.f));
        map.put(EnumC4164hb.EVENT_TYPE_SEND_USER_PROFILE, c4338ob);
        EnumC4164hb enumC4164hb4 = EnumC4164hb.EVENT_TYPE_SET_USER_PROFILE_ID;
        C4195ii c4195ii4 = this.f11512a;
        map.put(enumC4164hb4, new C4024bl(c4195ii4, c4195ii4.k));
        map.put(EnumC4164hb.EVENT_TYPE_SEND_REVENUE_EVENT, c4338ob);
        map.put(EnumC4164hb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c4338ob);
        map.put(EnumC4164hb.EVENT_TYPE_CLEANUP, c4338ob);
        map.put(EnumC4164hb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c4338ob);
        map.put(EnumC4164hb.EVENT_TYPE_WEBVIEW_SYNC, c4338ob);
        map.put(EnumC4164hb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new L9(this.f11512a));
        return map;
    }

    public final C4195ii b() {
        return this.f11512a;
    }

    public final void a(EnumC4164hb enumC4164hb, AbstractC4511va abstractC4511va) {
        this.b.put(enumC4164hb, abstractC4511va);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4392qf
    public final AbstractC4037c9 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC4164hb enumC4164hbA = EnumC4164hb.a(i);
        H4 h4 = this.c;
        if (h4 != null) {
            h4.a(enumC4164hbA, linkedList);
        }
        AbstractC4511va abstractC4511va = (AbstractC4511va) this.b.get(enumC4164hbA);
        if (abstractC4511va != null) {
            abstractC4511va.a(linkedList);
        }
        return new C4012b9(linkedList);
    }

    public final AbstractC4511va a(EnumC4164hb enumC4164hb) {
        return (AbstractC4511va) this.b.get(enumC4164hb);
    }
}
