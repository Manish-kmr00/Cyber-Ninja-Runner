package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.json.mediationsdk.utils.IronSourceConstants;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ql, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4398ql implements InterfaceC4422rl {
    public static final Map k = Collections.unmodifiableMap(new C4323nl());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11739a;
    public final C4320ni b;
    public final C4597yl c;
    public final Handler d;
    public PublicLogger e;
    public final C4348ol f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public C4398ql(Context context, C4320ni c4320ni, Ke ke, Handler handler) {
        this(c4320ni, new C4597yl(context, ke), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            C4597yl c4597yl = this.c;
            c4597yl.getClass();
            if (!In.a((Map) map) && !In.a(map, c4597yl.e)) {
                c4597yl.e = new HashMap(map);
                c4597yl.g = true;
                c4597yl.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new C4373pl(this, startupParamsCallback), map);
            } else {
                a(new Bundle(), startupParamsCallback);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x007f A[Catch: all -> 0x0115, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:10:0x0082, B:12:0x00b1, B:13:0x00b8, B:15:0x00be, B:16:0x00c5, B:18:0x00da, B:21:0x00e5, B:22:0x00f1, B:19:0x00df, B:9:0x007f), top: B:29:0x0063 }] */
    public final void b(Bundle bundle) {
        IdentifiersResult identifiersResultA = C4231k4.a(bundle, "Uuid");
        IdentifiersResult identifiersResultA2 = C4231k4.a(bundle, "DeviceId");
        IdentifiersResult identifiersResultA3 = C4231k4.a(bundle, "DeviceIdHash");
        IdentifiersResult identifiersResultA4 = C4231k4.a(bundle, "AdUrlReport");
        IdentifiersResult identifiersResultA5 = C4231k4.a(bundle, "AdUrlGet");
        IdentifiersResult identifiersResultA6 = C4231k4.a(bundle, "Clids");
        IdentifiersResult identifiersResultA7 = C4231k4.a(bundle, "RequestClids");
        IdentifiersResult identifiersResultA8 = C4231k4.a(bundle, IronSourceConstants.TYPE_GAID);
        IdentifiersResult identifiersResultA9 = C4231k4.a(bundle, "HOAID");
        IdentifiersResult identifiersResultA10 = C4231k4.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult identifiersResultA11 = C4231k4.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        C4038ca c4038caA = C4231k4.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        C4597yl c4597yl = this.c;
        synchronized (c4597yl) {
            IdentifiersResult identifiersResult = (IdentifiersResult) c4597yl.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                Mn mn = c4597yl.o;
                String str = identifiersResult.id;
                mn.getClass();
                if (!Mn.a(str)) {
                    c4597yl.c(identifiersResultA);
                }
            } else {
                c4597yl.c(identifiersResultA);
            }
            c4597yl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, identifiersResultA2);
            c4597yl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, identifiersResultA3);
            c4597yl.b.put("appmetrica_google_adv_id", identifiersResultA8);
            c4597yl.b.put("appmetrica_huawei_oaid", identifiersResultA9);
            c4597yl.b.put("appmetrica_yandex_adv_id", identifiersResultA10);
            c4597yl.l.a(identifiersResultA11);
            c4597yl.m.a(c4038caA);
            if (!C4597yl.a(identifiersResultA5)) {
                c4597yl.b.put("appmetrica_get_ad_url", identifiersResultA5);
            }
            if (!C4597yl.a(identifiersResultA4)) {
                c4597yl.b.put("appmetrica_report_ad_url", identifiersResultA4);
            }
            c4597yl.f = j;
            W3 w3 = c4597yl.k;
            HashMap map = c4597yl.e;
            HashMap mapA = AbstractC4288mb.a(identifiersResultA7.id);
            w3.getClass();
            if (In.a((Map) map) ? In.a((Map) mapA) : map.equals(mapA)) {
                c4597yl.b.put("appmetrica_clids", identifiersResultA6);
                c4597yl.g = false;
            }
            c4597yl.h = j2;
            c4597yl.c();
        }
        C4455t4.i().k().a(bundle2, new SdkIdentifiers(identifiersResultA.id, identifiersResultA2.id, identifiersResultA3.id));
        h();
    }

    public final H6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final C4088ea e() {
        C4038ca c4038ca;
        C4597yl c4597yl = this.c;
        Z9 z9 = c4597yl.n;
        C3988aa c3988aa = c4597yl.m;
        synchronized (c3988aa) {
            c4038ca = c3988aa.b;
        }
        z9.getClass();
        Boolean bool = c4038ca.f11492a;
        return new C4088ea();
    }

    public final long f() {
        return this.c.f;
    }

    public final String g() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_UUID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final void h() {
        WeakHashMap weakHashMap = new WeakHashMap();
        for (Map.Entry entry : this.h.entrySet()) {
            List list = (List) entry.getValue();
            if (this.c.a((Collection) list)) {
                weakHashMap.put((StartupParamsCallback) entry.getKey(), list);
            }
        }
        Iterator it = weakHashMap.entrySet().iterator();
        while (it.hasNext()) {
            StartupParamsCallback startupParamsCallback = (StartupParamsCallback) ((Map.Entry) it.next()).getKey();
            if (startupParamsCallback != null) {
                a(new Bundle(), startupParamsCallback);
            }
        }
        weakHashMap.clear();
    }

    public final void i() {
        synchronized (this.g) {
            if (!this.j || this.c.b()) {
                this.j = true;
                a(this.f11739a, this.f, this.i);
            }
        }
    }

    public C4398ql(C4320ni c4320ni, C4597yl c4597yl, Handler handler) {
        this.f11739a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = c4320ni;
        this.c = c4597yl;
        this.d = handler;
        this.f = new C4348ol(this);
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, H6 h6, Map map) {
        I6 i6 = new I6(this.d, h6);
        C4320ni c4320ni = this.b;
        c4320ni.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new C4089eb(i6, list, map));
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = C9.f11086a;
        C4082e4 c4082e4 = new C4082e4("", "", 1536, 0, anonymousInstance);
        c4082e4.m = bundle;
        W4 w4 = c4320ni.f11687a;
        c4320ni.a(C4320ni.a(c4082e4, w4), w4, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (In.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap mapB = AbstractC4199im.b(map);
            this.i = mapB;
            this.b.a(mapB);
            C4597yl c4597yl = this.c;
            c4597yl.getClass();
            if (!In.a((Map) mapB) && !In.a(mapB, c4597yl.e)) {
                c4597yl.e = new HashMap(mapB);
                c4597yl.g = true;
                c4597yl.c();
            }
        }
    }

    public final void b(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        synchronized (this.g) {
            b(bundle);
            h();
            if (startupParamsCallback != null) {
                a(bundle, startupParamsCallback);
            }
        }
    }

    public final void a(String str) {
        synchronized (this.g) {
            this.b.a(str);
        }
    }

    public final void b(List<String> list) {
        synchronized (this.g) {
            List list2 = this.c.d;
            if (In.a((Collection) list)) {
                if (!In.a((Collection) list2)) {
                    C4597yl c4597yl = this.c;
                    c4597yl.d = null;
                    c4597yl.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!In.a(list, list2)) {
                C4597yl c4597yl2 = this.c;
                c4597yl2.d = list;
                c4597yl2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        EnumC4273ll enumC4273ll;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    enumC4273ll = EnumC4273ll.UNKNOWN;
                    if (i == 1) {
                        enumC4273ll = EnumC4273ll.NETWORK;
                    } else if (i == 2) {
                        enumC4273ll = EnumC4273ll.PARSE;
                    }
                } else {
                    enumC4273ll = null;
                }
                if (enumC4273ll == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        enumC4273ll = EnumC4273ll.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, enumC4273ll, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C4178i0 c4178i0 = this.b.d;
                synchronized (c4178i0.f) {
                    c4178i0.c = false;
                    c4178i0.c();
                }
            }
        }
    }

    public final void b(String str) {
        synchronized (this.g) {
            this.b.b(str);
        }
    }

    public final Map<String, String> b() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get("appmetrica_clids");
        String str = identifiersResult == null ? null : identifiersResult.id;
        if (!TextUtils.isEmpty(str)) {
            return AbstractC4288mb.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap map = new HashMap();
        C4597yl c4597yl = this.c;
        synchronized (c4597yl) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) c4597yl.b.get(str);
                if (identifiersResult != null) {
                    map.put(str, c4597yl.c.a(identifiersResult));
                }
            }
            c4597yl.l.a(list, map);
            c4597yl.m.a(list, map);
        }
        return new StartupParamsCallback.Result(map);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C4178i0 c4178i0 = this.b.d;
            synchronized (c4178i0.f) {
                c4178i0.c = true;
                c4178i0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        C4597yl c4597yl = this.c;
        M m = c4597yl.j;
        IdentifiersResult identifiersResult = (IdentifiersResult) c4597yl.b.get("appmetrica_google_adv_id");
        IdentifiersResult identifiersResult2 = (IdentifiersResult) c4597yl.b.get("appmetrica_huawei_oaid");
        IdentifiersResult identifiersResult3 = (IdentifiersResult) c4597yl.b.get("appmetrica_yandex_adv_id");
        m.getClass();
        return new AdvIdentifiersResult(M.a(identifiersResult), M.a(identifiersResult2), M.a(identifiersResult3));
    }
}
