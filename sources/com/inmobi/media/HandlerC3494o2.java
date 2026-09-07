package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.o2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class HandlerC3494o2 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3384a;
    public final LinkedHashMap b;
    public Map c;
    public ThreadPoolExecutor d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3494o2(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f3384a = new ArrayList();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    /* JADX WARN: Code duplicated, block: B:76:0x02c3  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        boolean z;
        Map map;
        A2 a2;
        boolean zBooleanValue;
        ThreadPoolExecutor threadPoolExecutor;
        Intrinsics.checkNotNullParameter(message, "message");
        if (C3578u2.d.get()) {
            Unit unit = null;
            ThreadPoolExecutor threadPoolExecutor2 = null;
            ThreadPoolExecutor threadPoolExecutor3 = null;
            Unit unit2 = null;
            boolean zBooleanValue2 = false;
            switch (message.what) {
                case 0:
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    Object obj = message.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.inmobi.commons.core.configs.ConfigFetchInputs");
                    C3634y2 c3634y2 = (C3634y2) obj;
                    Config config = c3634y2.f3483a;
                    LinkedHashMap linkedHashMap = C3578u2.f3440a;
                    InterfaceC3564t2 interfaceC3564t2 = c3634y2.b;
                    if (interfaceC3564t2 != null) {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        interfaceC3564t2.toString();
                        ArrayList arrayList = (ArrayList) C3578u2.f3440a.get(config);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(new WeakReference(interfaceC3564t2));
                        C3578u2.f3440a.put(config, arrayList);
                    }
                    if (C3578u2.c.get()) {
                        String accountId$media_release = config.getAccountId$media_release();
                        if (accountId$media_release != null) {
                            String type = config.getType();
                            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                            Config configA = AbstractC3351e3.a(accountId$media_release, type);
                            if (((C3606w2) C3578u2.f.getValue()).b("root", accountId$media_release)) {
                                Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                C3549s2.a(AbstractC3351e3.a(accountId$media_release, "root"));
                            } else {
                                Config configA2 = C3549s2.a(accountId$media_release);
                                Intrinsics.checkNotNull(configA2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                                RootConfig rootConfig = (RootConfig) configA2;
                                long lastUpdateTimeStamp = rootConfig.getLastUpdateTimeStamp();
                                long expiryForType = rootConfig.getExpiryForType(rootConfig.getType());
                                Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                long j = 1000;
                                byte b = System.currentTimeMillis() - lastUpdateTimeStamp > expiryForType * j;
                                Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                if (b != false) {
                                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                    C3549s2.a(AbstractC3351e3.a(accountId$media_release, "root"));
                                }
                                if (!Intrinsics.areEqual("root", type)) {
                                    if (((C3606w2) C3578u2.f.getValue()).b(type, accountId$media_release)) {
                                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                        C3549s2.a(configA);
                                    } else {
                                        Config configA3 = C3549s2.a(accountId$media_release, type);
                                        long lastUpdateTimeStamp2 = configA3 != null ? configA3.getLastUpdateTimeStamp() : 0L;
                                        long expiryForType2 = rootConfig.getExpiryForType(type);
                                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                        zBooleanValue2 = System.currentTimeMillis() - lastUpdateTimeStamp2 > expiryForType2 * j;
                                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                        if (zBooleanValue2) {
                                            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                            C3549s2.a(configA);
                                        }
                                    }
                                }
                            }
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                            config.getType();
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        config.getType();
                    }
                    break;
                case 1:
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    Object obj2 = message.obj;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.Config");
                    Config config2 = (Config) obj2;
                    String accountId$media_release2 = config2.getAccountId$media_release();
                    if (accountId$media_release2 != null) {
                        String type2 = config2.getType();
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        LinkedHashMap linkedHashMap2 = C3578u2.f3440a;
                        Config configA4 = C3549s2.a(accountId$media_release2);
                        Intrinsics.checkNotNull(configA4, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                        Map map2 = (Map) this.b.get(new C3508p2(((RootConfig) configA4).getUrlForType(type2), accountId$media_release2));
                        if (map2 != null && map2.containsKey(type2)) {
                            zBooleanValue2 = true;
                        }
                        Map map3 = this.c;
                        boolean z2 = (map3 == null || !map3.containsKey(type2)) ? zBooleanValue2 : true;
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        config2.getType();
                        if (z2) {
                            Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                            config2.getType();
                        } else {
                            this.f3384a.add(config2);
                            if (!hasMessages(2)) {
                                Message messageObtain = Message.obtain();
                                messageObtain.what = 2;
                                messageObtain.obj = accountId$media_release2;
                                sendMessage(messageObtain);
                            }
                        }
                        unit2 = Unit.INSTANCE;
                    }
                    if (unit2 == null) {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        config2.getType();
                    }
                    break;
                case 2:
                    LinkedHashMap linkedHashMap3 = C3578u2.f3440a;
                    Object obj3 = message.obj;
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    Config configA5 = C3549s2.a((String) obj3);
                    Intrinsics.checkNotNull(configA5, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    sendEmptyMessageDelayed(3, ((RootConfig) configA5).getWaitTime() * 1000);
                    break;
                case 3:
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    for (Config config3 : this.f3384a) {
                        String accountId$media_release3 = config3.getAccountId$media_release();
                        if (accountId$media_release3 != null) {
                            LinkedHashMap linkedHashMap4 = C3578u2.f3440a;
                            Config configA6 = C3549s2.a(accountId$media_release3);
                            Intrinsics.checkNotNull(configA6, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                            C3508p2 c3508p2 = new C3508p2(((RootConfig) configA6).getUrlForType(config3.getType()), accountId$media_release3);
                            Map map4 = (Map) this.b.get(c3508p2);
                            if (map4 == null) {
                                map4 = new HashMap();
                                this.b.put(c3508p2, map4);
                            }
                            map4.put(config3.getType(), config3);
                        }
                    }
                    this.f3384a.clear();
                    ThreadPoolExecutor threadPoolExecutor4 = this.d;
                    if (threadPoolExecutor4 == null || !threadPoolExecutor4.isShutdown()) {
                        threadPoolExecutor3 = this.d;
                    } else {
                        this.d = null;
                    }
                    if (threadPoolExecutor3 == null) {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        int i = S3.f3188a;
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
                        String strF = C3578u2.f();
                        Intrinsics.checkNotNullExpressionValue(strF, "access$getTAG$cp(...)");
                        ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(1, 1, 5L, timeUnit, linkedBlockingDeque, new V4(strF));
                        threadPoolExecutor5.allowCoreThreadTimeOut(true);
                        this.d = threadPoolExecutor5;
                        sendEmptyMessage(4);
                    }
                    break;
                case 4:
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    if (this.b.isEmpty()) {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        sendEmptyMessage(5);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        Map.Entry entry = (Map.Entry) this.b.entrySet().iterator().next();
                        this.c = (Map) entry.getValue();
                        this.b.remove(entry.getKey());
                        C3508p2 c3508p3 = (C3508p2) entry.getKey();
                        Map map5 = this.c;
                        Intrinsics.checkNotNull(map5);
                        String str = ((C3508p2) entry.getKey()).b;
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        Objects.toString(c3508p3);
                        LinkedHashMap linkedHashMap5 = C3578u2.f3440a;
                        Config configA7 = C3549s2.a(str);
                        Intrinsics.checkNotNull(configA7, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                        RootConfig rootConfig2 = (RootConfig) configA7;
                        int retryInterval = rootConfig2.getRetryInterval();
                        int maxRetries = rootConfig2.getMaxRetries();
                        C3545rc c3545rc = new C3545rc(rootConfig2.getIncludeIds());
                        if (rootConfig2.getIpAddrTPSupport().isEmpty()) {
                            z = false;
                        } else {
                            Boolean bool = I9.b;
                            if (bool != null) {
                                zBooleanValue = bool.booleanValue();
                            } else {
                                Context contextD = C3517pb.d();
                                if (contextD != null) {
                                    ConcurrentHashMap concurrentHashMap = K5.b;
                                    K5 k5A = J5.a(contextD, "user_info_store");
                                    Intrinsics.checkNotNullParameter("user_age_restricted", "key");
                                    I9.b = Boolean.valueOf(k5A.f3112a.getBoolean("user_age_restricted", false));
                                }
                                Boolean bool2 = I9.b;
                                zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
                            }
                            if (zBooleanValue) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        boolean zA = X3.a(X3.f3234a, false, 1, null);
                        if (zA || !map5.containsKey("root")) {
                            map = map5;
                        } else {
                            HashMap map6 = new HashMap(1);
                            Object obj4 = map5.get("root");
                            Intrinsics.checkNotNull(obj4);
                            map6.put("root", obj4);
                            map = map6;
                            zA = true;
                        }
                        A2 a3 = new A2(map, c3545rc, c3508p3.f3396a, maxRetries, retryInterval, zA, str, z);
                        if (map5.containsKey("root")) {
                            String fallbackUrlForRootType = rootConfig2.getFallbackUrlForRootType();
                            HashMap map7 = new HashMap(1);
                            Object obj5 = map5.get("root");
                            Intrinsics.checkNotNull(obj5);
                            map7.put("root", obj5);
                            a2 = new A2(map7, c3545rc, fallbackUrlForRootType, maxRetries, retryInterval, zA, str, z);
                        } else {
                            a2 = null;
                        }
                        RunnableC3648z2 runnableC3648z2 = new RunnableC3648z2(this, a3, a2);
                        try {
                            ThreadPoolExecutor threadPoolExecutor6 = this.d;
                            if (threadPoolExecutor6 == null || !threadPoolExecutor6.isShutdown()) {
                                threadPoolExecutor2 = this.d;
                            } else {
                                this.d = null;
                            }
                            if (threadPoolExecutor2 != null) {
                                threadPoolExecutor2.execute(runnableC3648z2);
                            }
                        } catch (OutOfMemoryError unused) {
                            C3578u2.f();
                            if (this.b.isEmpty()) {
                                Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                                sendEmptyMessage(5);
                                return;
                            }
                            return;
                        }
                    }
                    break;
                case 5:
                    ThreadPoolExecutor threadPoolExecutor7 = this.d;
                    if (threadPoolExecutor7 == null || !threadPoolExecutor7.isShutdown()) {
                        threadPoolExecutor = this.d;
                    } else {
                        this.d = null;
                        threadPoolExecutor = null;
                    }
                    if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                        this.c = null;
                        this.b.clear();
                        removeMessages(3);
                        threadPoolExecutor.shutdownNow();
                        break;
                    }
                    break;
                case 6:
                    Object obj6 = message.obj;
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse");
                    C2 c2 = (C2) obj6;
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    if (c2.c != null) {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        c2.f3038a.getType();
                    } else if (c2.b == 304) {
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        c2.f3038a.getType();
                        Config config4 = c2.f3038a;
                        if (config4.getAccountId$media_release() != null) {
                            C3606w2 c3606w2 = (C3606w2) C3578u2.f.getValue();
                            String type3 = config4.getType();
                            String accountId = config4.getAccountId$media_release();
                            Intrinsics.checkNotNull(accountId);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            c3606w2.getClass();
                            Intrinsics.checkNotNullParameter(type3, "type");
                            Intrinsics.checkNotNullParameter(accountId, "accountId");
                            Intrinsics.checkNotNullExpressionValue("w2", "TAG");
                            Intrinsics.checkNotNullParameter(type3, "type");
                            Config config5 = (Config) c3606w2.b("account_id=? AND config_type=?", new String[]{accountId, type3});
                            if (config5 != null) {
                                config5.setLastUpdateTimeStamp(jCurrentTimeMillis);
                                c3606w2.a(config5, "account_id=? AND config_type=?", new String[]{accountId, type3});
                            }
                        }
                    } else {
                        if (Intrinsics.areEqual(c2.f3038a.getType(), "root")) {
                            Config config6 = c2.f3038a;
                            Intrinsics.checkNotNull(config6, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                            if (((RootConfig) config6).getIpAddrTPSupport().isEmpty()) {
                                T4.a();
                            }
                        }
                        C3606w2 c3606w3 = (C3606w2) C3578u2.f.getValue();
                        Config config7 = c2.f3038a;
                        c3606w3.getClass();
                        Intrinsics.checkNotNullParameter(config7, "config");
                        try {
                            if (config7.getAccountId$media_release() != null) {
                                Intrinsics.checkNotNullExpressionValue("w2", "TAG");
                                config7.getType();
                                config7.getAccountId$media_release();
                                c3606w3.a(config7, "account_id=? AND config_type=?", new String[]{config7.getAccountId$media_release(), config7.getType()});
                                break;
                            }
                        } catch (Exception unused2) {
                        }
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        c2.f3038a.getType();
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        Objects.toString(c2.f3038a.toJson());
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        c2.f3038a.getAccountId$media_release();
                        Config config8 = c2.f3038a;
                        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                        config8.getType();
                        config8.getAccountId$media_release();
                        ConcurrentHashMap concurrentHashMap2 = C3578u2.e;
                        LinkedHashMap linkedHashMap6 = C3578u2.f3440a;
                        Intrinsics.checkNotNullParameter(config8, "<this>");
                        HashMap map8 = AbstractC3351e3.f3298a;
                        concurrentHashMap2.put(AbstractC3351e3.b(config8.getAccountId$media_release(), config8.getType()), config8);
                        C3549s2.b(c2.f3038a);
                    }
                    break;
                case 7:
                    Object obj7 = message.obj;
                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type com.inmobi.commons.core.configs.ConfigNetworkResponse.IPAddress");
                    F2 f2 = (F2) obj7;
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    Objects.toString(f2);
                    if (f2 instanceof E2) {
                        Boolean bool3 = I9.b;
                        if (bool3 != null) {
                            zBooleanValue2 = bool3.booleanValue();
                        } else {
                            Context contextD2 = C3517pb.d();
                            if (contextD2 != null) {
                                ConcurrentHashMap concurrentHashMap3 = K5.b;
                                K5 k5A2 = J5.a(contextD2, "user_info_store");
                                Intrinsics.checkNotNullParameter("user_age_restricted", "key");
                                I9.b = Boolean.valueOf(k5A2.f3112a.getBoolean("user_age_restricted", false));
                            }
                            Boolean bool4 = I9.b;
                            if (bool4 != null) {
                                zBooleanValue2 = bool4.booleanValue();
                            }
                        }
                        if (zBooleanValue2) {
                            T4.a();
                        } else {
                            Lazy lazy = T4.f3200a;
                            String ipAddress = ((E2) f2).f3055a;
                            Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
                            T4.b = ipAddress;
                            K5 k5 = (K5) T4.f3200a.getValue();
                            if (k5 != null) {
                                Intrinsics.checkNotNullParameter("cip", "key");
                                SharedPreferences.Editor editorEdit = k5.f3112a.edit();
                                editorEdit.putString("cip", ipAddress);
                                editorEdit.apply();
                                Unit unit3 = Unit.INSTANCE;
                            }
                            Intrinsics.checkNotNull(T4.c);
                        }
                    } else if (f2 instanceof D2) {
                        T4.a();
                    }
                    break;
                default:
                    Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                    break;
            }
        }
    }
}
