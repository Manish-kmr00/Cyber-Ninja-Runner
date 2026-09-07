package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public final class M2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final M2 f3131a;
    public static LinkedList b;
    public static LinkedList c;
    public static SignalsConfig d;
    public static AdConfig e;
    public static byte[] f;
    public static String g;

    static {
        List<String> listEmptyList;
        AdConfig.ContextualDataConfig contextualData;
        M2 m2 = new M2();
        f3131a = m2;
        LinkedList linkedList = new LinkedList();
        b = linkedList;
        Object objClone = linkedList.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
        c = (LinkedList) objClone;
        L2 l2 = new L2();
        K2 k2 = new K2();
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("signals", C3517pb.b(), l2);
        d = configA instanceof SignalsConfig ? (SignalsConfig) configA : null;
        Config configA2 = C3549s2.a("ads", C3517pb.b(), k2);
        e = configA2 instanceof AdConfig ? (AdConfig) configA2 : null;
        SignalsConfig signalsConfig = d;
        f = G3.a(signalsConfig != null ? signalsConfig.getKA() : null);
        AdConfig adConfig = e;
        if (adConfig == null || (contextualData = adConfig.getContextualData()) == null || (listEmptyList = contextualData.getSkipFields()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(N2.j);
        arrayList.removeAll(listEmptyList);
        g = CollectionsKt.joinToString$default(arrayList, StringUtils.COMMA, null, null, 0, null, null, 62, null);
        Context contextD = C3517pb.d();
        if (contextD != null) {
            Intrinsics.checkNotNull("M2");
            ConcurrentHashMap concurrentHashMap = K5.b;
            K5 k5A = J5.a(contextD, "c_data_store");
            Context contextD2 = C3517pb.d();
            int vak = 1;
            if (contextD2 != null) {
                K5 k5A2 = J5.a(contextD2, "c_data_store");
                Intrinsics.checkNotNullParameter("akv", "key");
                vak = k5A2.f3112a.getInt("akv", 1);
            }
            SignalsConfig signalsConfig2 = d;
            if (signalsConfig2 == null || signalsConfig2.getVAK() != vak) {
                Intrinsics.checkNotNull("M2");
                SignalsConfig signalsConfig3 = d;
                if (signalsConfig3 != null) {
                    vak = signalsConfig3.getVAK();
                }
                k5A.a("akv", vak);
                m2.d();
            }
        }
    }

    public static final void a() {
        AdConfig.ContextualDataConfig contextualData;
        AdConfig.ContextualDataConfig contextualData2;
        AdConfig.ContextualDataConfig contextualData3;
        Intrinsics.checkNotNull("M2");
        long jCurrentTimeMillis = System.currentTimeMillis();
        AdConfig adConfig = e;
        int maxAdRecords = 0;
        long expiryTime = jCurrentTimeMillis - (((long) ((adConfig == null || (contextualData3 = adConfig.getContextualData()) == null) ? 0 : contextualData3.getExpiryTime())) * 1000);
        AdConfig adConfig2 = e;
        a(expiryTime, (adConfig2 == null || (contextualData2 = adConfig2.getContextualData()) == null) ? 0 : contextualData2.getMaxAdRecords());
        Object objClone = b.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
        c = (LinkedList) objClone;
        AdConfig adConfig3 = e;
        if (adConfig3 != null && (contextualData = adConfig3.getContextualData()) != null) {
            maxAdRecords = contextualData.getMaxAdRecords();
        }
        Intrinsics.checkNotNull("M2");
        I2 i2 = (I2) AbstractC3415ib.d.getValue();
        i2.getClass();
        i2.a("id NOT IN (SELECT id FROM ( SELECT id FROM c_data WHERE timestamp > " + expiryTime + " ORDER BY timestamp DESC LIMIT " + maxAdRecords + ") foo);", null);
    }

    public static String b() {
        AdConfig.ContextualDataConfig contextualData;
        Intrinsics.checkNotNull("M2");
        if (g.length() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        long jCurrentTimeMillis = System.currentTimeMillis();
        AdConfig adConfig = e;
        long expiryTime = jCurrentTimeMillis - (((long) ((adConfig == null || (contextualData = adConfig.getContextualData()) == null) ? 0 : contextualData.getExpiryTime())) * 1000);
        LinkedList linkedList = c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedList) {
            if (((F3) obj).b >= expiryTime) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(StringsKt.trim((CharSequence) ((F3) it.next()).f3066a).toString());
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static boolean c() {
        boolean z;
        AdConfig.ContextualDataConfig contextualData;
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            K5 k5A = J5.a(contextD, "c_data_store");
            Intrinsics.checkNotNullParameter("isEnabled", "key");
            z = k5A.f3112a.getBoolean("isEnabled", true);
        } else {
            z = true;
        }
        if (!z) {
            Intrinsics.checkNotNull("M2");
            return false;
        }
        AdConfig adConfig = e;
        boolean z2 = ((adConfig == null || (contextualData = adConfig.getContextualData()) == null) ? 1 : contextualData.getMaxAdRecords()) > 0;
        Intrinsics.checkNotNull("M2");
        return z2;
    }

    public final void d() {
        synchronized (this) {
            Intrinsics.checkNotNull("M2");
            I2 i2 = (I2) AbstractC3415ib.d.getValue();
            i2.getClass();
            try {
                C3309b3.a(i2.f3045a, null, null);
            } catch (Exception unused) {
            }
            LinkedList linkedList = new LinkedList();
            b = linkedList;
            Object objClone = linkedList.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
            c = (LinkedList) objClone;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static void a(long j, int i) {
        Intrinsics.checkNotNull("M2");
        for (int size = b.size(); size > i; size--) {
            b.remove();
        }
        Intrinsics.checkNotNull("M2");
        Iterator it = b.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (((F3) next).b >= j) {
                return;
            } else {
                it.remove();
            }
        }
    }
}
