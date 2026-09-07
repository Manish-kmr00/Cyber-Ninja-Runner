package com.inmobi.media;

import android.os.Message;
import com.inmobi.commons.core.configs.Config;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.s2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3549s2 {
    public static void a() {
        if (C3578u2.c.getAndSet(true)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        b();
        a("root", C3517pb.b(), null);
    }

    public static void b() {
        final ArrayList arrayList = new ArrayList();
        C3606w2 c3606w2 = (C3606w2) C3578u2.f.getValue();
        c3606w2.getClass();
        for (Config config : CollectionsKt.filterNotNull(D1.a(c3606w2, null, null, null, null, null, null, 63))) {
            ConcurrentHashMap concurrentHashMap = C3578u2.e;
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            Intrinsics.checkNotNullParameter(config, "<this>");
            HashMap map = AbstractC3351e3.f3298a;
            Config config2 = (Config) concurrentHashMap.put(AbstractC3351e3.b(config.getAccountId$media_release(), config.getType()), config);
            if (config2 == null || config2.getLastUpdateTimeStamp() != config.getLastUpdateTimeStamp()) {
                Intrinsics.checkNotNullParameter(config, "<this>");
                arrayList.add(AbstractC3351e3.b(config.getAccountId$media_release(), config.getType()));
            }
        }
        ((HandlerC3494o2) C3578u2.b.getValue()).post(new Runnable() { // from class: com.inmobi.media.s2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3549s2.a(arrayList);
            }
        });
    }

    public static final void a(List changedConfigKeys) {
        Intrinsics.checkNotNullParameter(changedConfigKeys, "$changedConfigKeys");
        try {
            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
            Iterator it = changedConfigKeys.iterator();
            while (it.hasNext()) {
                Config config = (Config) C3578u2.e.get((String) it.next());
                if (config != null) {
                    LinkedHashMap linkedHashMap = C3578u2.f3440a;
                    b(config);
                }
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0084  */
    public static Config a(String type, String str, InterfaceC3564t2 interfaceC3564t2) {
        Config config;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        Objects.toString(interfaceC3564t2);
        Config configA = AbstractC3351e3.a(str, type);
        if (str == null) {
            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
            return configA;
        }
        Message messageObtainMessage = ((HandlerC3494o2) C3578u2.b.getValue()).obtainMessage();
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = new C3634y2(configA, interfaceC3564t2);
        ((HandlerC3494o2) C3578u2.b.getValue()).sendMessage(messageObtainMessage);
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        Objects.toString(configA);
        String accountId$media_release = configA.getAccountId$media_release();
        if (accountId$media_release != null) {
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            String type2 = configA.getType();
            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
            ConcurrentHashMap concurrentHashMap = C3578u2.e;
            Intrinsics.checkNotNullParameter(type2, "<this>");
            config = (Config) concurrentHashMap.get(AbstractC3351e3.b(accountId$media_release, type2));
            if (config != null) {
                Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                config.getLastUpdateTimeStamp();
            } else {
                config = null;
            }
        } else {
            config = null;
        }
        return config == null ? configA : config;
    }

    public static Config a(String accountId, String type) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        ConcurrentHashMap concurrentHashMap = C3578u2.e;
        Intrinsics.checkNotNullParameter(type, "<this>");
        Config config = (Config) concurrentHashMap.get(AbstractC3351e3.b(accountId, type));
        Config config2 = null;
        if (config != null) {
            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
            config.getLastUpdateTimeStamp();
        } else {
            config = null;
        }
        if (config != null) {
            return config;
        }
        C3606w2 c3606w2 = (C3606w2) C3578u2.f.getValue();
        c3606w2.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        Config config3 = (Config) c3606w2.b("account_id=? AND config_type=?", new String[]{accountId, type});
        if (config3 != null) {
            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
            config3.toString();
            if (AbstractC3420j2.a(config3.getAccountId$media_release()) && config3.getType().length() > 0) {
                Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                ConcurrentHashMap concurrentHashMap2 = C3578u2.e;
                LinkedHashMap linkedHashMap = C3578u2.f3440a;
                Intrinsics.checkNotNullParameter(config3, "<this>");
                concurrentHashMap2.put(AbstractC3351e3.b(config3.getAccountId$media_release(), config3.getType()), config3);
                b(config3);
            }
            config2 = config3;
        }
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        if (config2 != null) {
            config2.getLastUpdateTimeStamp();
        }
        return config2;
    }

    public static void b(Config config) {
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        ArrayList arrayList = (ArrayList) C3578u2.f3440a.get(config);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (((WeakReference) next).get() == null) {
                    it.remove();
                }
            }
        }
        ArrayList arrayList2 = (ArrayList) C3578u2.f3440a.get(config);
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                InterfaceC3564t2 interfaceC3564t2 = (InterfaceC3564t2) ((WeakReference) it2.next()).get();
                if (interfaceC3564t2 != null) {
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    interfaceC3564t2.getClass().toString();
                    interfaceC3564t2.a(config);
                }
            }
        }
    }

    public static Config a(String accountId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter("root", "type");
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        Config configA = a(accountId, "root");
        return configA == null ? AbstractC3351e3.a(accountId, "root") : configA;
    }

    public static void a(Config config) {
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        Message messageObtainMessage = ((HandlerC3494o2) C3578u2.b.getValue()).obtainMessage();
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = config;
        ((HandlerC3494o2) C3578u2.b.getValue()).sendMessage(messageObtainMessage);
    }
}
