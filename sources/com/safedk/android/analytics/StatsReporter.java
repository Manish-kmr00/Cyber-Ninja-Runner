package com.safedk.android.analytics;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.c;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes7.dex */
public class StatsReporter implements AppLovinCommunicatorPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7959a = "StatsReporter";
    private static StatsReporter b;
    private static final ExecutorService c = Executors.newSingleThreadExecutor();

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return AppLovinBridge.f7952a;
    }

    public static synchronized void a() {
        b = new StatsReporter();
    }

    public static synchronized StatsReporter b() {
        return b;
    }

    public void a(final ArrayList<Bundle> arrayList) {
        try {
            c.execute(new Runnable() { // from class: com.safedk.android.analytics.StatsReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (arrayList.size() > 0) {
                            Logger.d(StatsReporter.f7959a, "Starting report stats events!, isOnUiThread = " + n.c());
                            AppLovinBridge.a((ArrayList<Bundle>) arrayList, StatsReporter.this);
                        }
                    } catch (Throwable th) {
                        Logger.e(StatsReporter.f7959a, "Caught exception while creating json data", th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.e(f7959a, "failed during report events: " + arrayList, th);
            new CrashReporter().caughtException(th);
        }
    }

    public ArrayList<Bundle> a(Set<StatsEvent> set) {
        Logger.d(f7959a, "filters reports and bundle started, events to send : " + (set == null ? "null" : Integer.valueOf(set.size())) + ", isOnUiThread = " + n.c());
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            for (StatsEvent statsEvent : set) {
                boolean z = false;
                if (SafeDK.b() && (statsEvent.a().equals(StatsCollector.EventType.BrandSafety) || statsEvent.a().equals(StatsCollector.EventType.redirect))) {
                    z = true;
                }
                Logger.d(f7959a, "filters reports and bundle Event type = " + statsEvent.a() + "; should report = " + z);
                Bundle bundleD = statsEvent.d();
                n.b(f7959a, "filters reports and bundle " + statsEvent.a() + " event:" + n.a(bundleD));
                if (z) {
                    Set<String> setE = statsEvent.e();
                    if (setE != null) {
                        HashSet hashSet = new HashSet();
                        for (String str : setE) {
                            if (!bundleD.containsKey(str)) {
                                hashSet.add(str);
                            }
                        }
                        if (hashSet.size() > 0) {
                            Logger.d(f7959a, "filters reports and bundle *** missing fields: " + hashSet);
                        }
                    }
                    arrayList.add(statsEvent.a(bundleD));
                    n.b(f7959a, "filters reports and bundle event to be reported : " + bundleD.toString());
                }
            }
        } catch (Exception e) {
            Logger.e(f7959a, "Exception filtering events for report", e);
        }
        return arrayList;
    }

    public synchronized boolean a(CreativeInfo creativeInfo, c cVar) {
        boolean z;
        Bundle bundle = cVar.A;
        Logger.d(f7959a, "notify Max started , CI = " + creativeInfo + ", applovin data = " + bundle + ", isOnUiThread = " + n.c());
        if (creativeInfo != null && creativeInfo.ad() != null && bundle != null) {
            String strZ = com.safedk.android.analytics.brandsafety.b.a(cVar, creativeInfo) ? cVar.z() : creativeInfo.ad();
            Logger.d(f7959a, "Will notify Max about match, creative id = " + strZ);
            AppLovinBridge.reportMaxCreativeId(bundle, strZ, b());
            z = true;
        } else {
            Logger.d(f7959a, "Cannot notify Max about match");
            z = false;
        }
        return z;
    }
}
