package com.safedk.android.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.t;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.analytics.events.RedirectEvent;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.LinkedHashSetWithItemLimit;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.PersistentConcurrentHashMap;
import com.safedk.android.utils.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class StatsCollector implements com.safedk.android.internal.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f7953a = 0;
    private static final String c = "StatsCollector";
    private static final String d = "SafeDKEvents.";
    private static StatsCollector e;
    private static boolean n;
    private static boolean p = false;
    private static boolean q = false;
    private static final Object r = new Object();
    private SharedPreferences i;
    private volatile AtomicBoolean j;
    private StatsReporter l;
    private String o;
    private PersistentConcurrentHashMap<String, StatsEvent> f = new PersistentConcurrentHashMap<>();
    private final LinkedHashSetWithItemLimit<String> g = new LinkedHashSetWithItemLimit<>(10);
    private Map<String, t> h = new HashMap();
    public AtomicLong b = new AtomicLong(0);
    private AtomicBoolean k = new AtomicBoolean(false);
    private final ExecutorService m = Executors.newSingleThreadExecutor();

    public enum EventType {
        Network,
        Launch,
        Thread,
        Location,
        CaughtException,
        UserDataAccess,
        ActiveUser,
        BrandSafety,
        AdIntelligenceFill,
        ANR,
        UserSession,
        crash,
        redirect
    }

    public static boolean a() {
        return p;
    }

    public static void a(boolean z) {
        p = z;
    }

    public static boolean b() {
        return q;
    }

    public static void b(boolean z) {
        synchronized (r) {
            Logger.d(c, "setActiveMode to " + z);
            n = z;
            e = null;
        }
    }

    public static StatsCollector c() {
        StatsCollector statsCollector = null;
        if (!p && !SafeDK.b()) {
            Logger.d(c, "Reporter thread has not been initialized yet");
        } else {
            synchronized (r) {
                if (e == null) {
                    e = new StatsCollector(300, com.safedk.android.internal.b.getInstance().isInBackground(), 5000, null, n.a(SafeDK.getInstance().m()));
                }
                statsCollector = e;
            }
        }
        return statsCollector;
    }

    private StatsCollector(int interval, boolean isBackground, int maximumEventsSize, StatsReporter statsReporter, String processName) {
        this.o = null;
        this.o = d + processName;
        Logger.d(c, "Initializing Stats collector");
        a(interval, isBackground, statsReporter);
        if (n) {
            com.safedk.android.internal.b.getInstance().registerBackgroundForegroundListener(this);
        }
    }

    public void d() {
        this.m.execute(new Runnable() { // from class: com.safedk.android.analytics.StatsCollector.1
            @Override // java.lang.Runnable
            public void run() {
                PersistentConcurrentHashMap persistentConcurrentHashMap;
                HashSet<StatsEvent> hashSet;
                try {
                    Logger.d(StatsCollector.c, "Attempting to load Stats events from storage.");
                    try {
                        persistentConcurrentHashMap = new PersistentConcurrentHashMap(StatsCollector.this.o);
                    } catch (Throwable th) {
                        Logger.d(StatsCollector.c, "Error loading events from storage file " + StatsCollector.this.o + " : " + th.getMessage());
                        persistentConcurrentHashMap = new PersistentConcurrentHashMap();
                    }
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    if (StatsCollector.this.f != null && StatsCollector.this.f.size() > 0) {
                        synchronized (StatsCollector.r) {
                            concurrentHashMap.putAll(StatsCollector.this.f);
                        }
                        Logger.d(StatsCollector.c, "Stats repository contains " + concurrentHashMap.size() + " items. they will be added to the stored ones.");
                    } else {
                        Logger.d(StatsCollector.c, "Stats repository does not contain previously accumulated events.");
                    }
                    for (V v : persistentConcurrentHashMap.values()) {
                        if (v instanceof BrandSafetyEvent) {
                            BrandSafetyEvent brandSafetyEvent = (BrandSafetyEvent) v;
                            if (brandSafetyEvent.g() != null && !brandSafetyEvent.g().toLowerCase().endsWith(POBConstants.KEY_IMPRESSION)) {
                                Log.d(StatsCollector.c, "brandSafetyEvent revenue event field check, field nullified,  original value = " + brandSafetyEvent.g());
                                brandSafetyEvent.a((String) null);
                            }
                        }
                    }
                    synchronized (StatsCollector.r) {
                        StatsCollector.this.f = persistentConcurrentHashMap;
                        hashSet = new HashSet(StatsCollector.this.f.values());
                    }
                    Logger.d(StatsCollector.c, StatsCollector.this.f.size() + " events loaded from storage");
                    for (StatsEvent statsEvent : hashSet) {
                        Logger.d(StatsCollector.c, "Setting event maturity, next_session, first_session (" + SafeDK.getInstance().e() + ") for stored event. key " + (statsEvent.b() != null ? statsEvent.b() : null));
                        statsEvent.b(true);
                        statsEvent.c(true);
                        statsEvent.a(SafeDK.getInstance().e());
                        if (!TextUtils.isEmpty(StatsCollector.this.f.a())) {
                            Logger.d(StatsCollector.c, "sdk_null_check sc added value" + StatsCollector.this.f.a());
                        }
                    }
                    if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                        StatsCollector.this.f.a(false);
                        for (StatsEvent statsEvent2 : concurrentHashMap.values()) {
                            Logger.d(StatsCollector.c, "adding previously accumulated event to the stats repository : " + statsEvent2.toString());
                            StatsCollector.this.b(statsEvent2);
                        }
                        StatsCollector.this.f.a(true);
                    }
                    Logger.d(StatsCollector.c, "Completed Loading events from storage. " + StatsCollector.this.f.size() + " items loaded");
                    boolean unused = StatsCollector.q = true;
                    if (StatsCollector.this.f.size() > 0) {
                        Logger.d(StatsCollector.c, StatsCollector.this.f.size() + " event(s) will be reported");
                        StatsCollector.this.d(true);
                    }
                    SafeDK.getInstance().k();
                } catch (Throwable th2) {
                    Logger.d(StatsCollector.c, "Error loading events from storage : " + th2.getMessage(), th2);
                }
            }
        });
    }

    public PersistentConcurrentHashMap<String, StatsEvent> e() {
        return this.f;
    }

    public ConcurrentHashMap<String, StatsEvent> a(EventType eventType) {
        Set<String> setKeySet;
        ConcurrentHashMap<String, StatsEvent> concurrentHashMap = new ConcurrentHashMap<>();
        synchronized (r) {
            setKeySet = this.f.keySet();
        }
        for (String str : setKeySet) {
            StatsEvent statsEvent = this.f.get(str);
            if (statsEvent != null && statsEvent.a().equals(eventType)) {
                Logger.d(c, "Get events by type adding event with key " + str);
                concurrentHashMap.put(statsEvent.b(), statsEvent);
            }
        }
        return concurrentHashMap;
    }

    public Map<String, t> f() {
        return this.h;
    }

    public boolean a(String str, String str2) {
        return this.h != null && this.h.containsKey(str) && this.h.get(str).c().equals(str2);
    }

    private void a(Context context, String str) {
        this.i = context.getSharedPreferences(str, 0);
        this.i.edit().clear().commit();
        Logger.d(c, "Old StatsRepository data cleared");
    }

    public void a(int i, boolean z, int i2, StatsReporter statsReporter) {
        a(i, z, statsReporter);
        this.k.set(true);
    }

    private void a(int i, boolean z, StatsReporter statsReporter) {
        f7953a = i;
        this.b.set(n.b(System.currentTimeMillis()));
        this.j = new AtomicBoolean(z);
        this.l = statsReporter;
    }

    public void a(StatsEvent statsEvent) {
        b(Collections.singletonList(statsEvent));
    }

    public void a(List<StatsEvent> list) {
        b(list);
    }

    private void b(final List<StatsEvent> list) {
        if (n) {
            this.m.execute(new Runnable() { // from class: com.safedk.android.analytics.StatsCollector.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.b(StatsCollector.c, "received stats safety event " + list + ", isOnUiThread = " + n.c());
                        if (!StatsCollector.this.j.get()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                StatsCollector.this.b((StatsEvent) it.next());
                            }
                            StatsCollector.this.d(false);
                            return;
                        }
                        for (StatsEvent statsEvent : list) {
                            if (statsEvent.a_() && !statsEvent.k().equals(SafeDK.f7941a)) {
                                StatsCollector.this.b(statsEvent);
                                StatsCollector.this.d(true);
                            } else {
                                Logger.d(StatsCollector.c, "Saving bundle to disk : " + statsEvent.toString());
                                StatsCollector.this.b(statsEvent);
                            }
                        }
                    } catch (Throwable th) {
                        Logger.e(StatsCollector.c, "Error adding event: " + th.getMessage(), th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        }
    }

    void b(StatsEvent statsEvent) {
        String strB = statsEvent.b();
        k();
        if (strB != null) {
            if (this.f.containsKey(strB)) {
                StatsEvent statsEvent2 = this.f.get(strB);
                if (statsEvent2 != null) {
                    statsEvent2.b(statsEvent);
                    synchronized (r) {
                        this.f.put(strB, statsEvent2);
                    }
                    Logger.d(c, "Event " + strB + " found. Aggregating. event = " + statsEvent2.d().toString() + ", isOnUiThread = " + n.c());
                    return;
                }
                return;
            }
            if (!this.g.contains(strB)) {
                synchronized (r) {
                    this.f.put(strB, statsEvent);
                }
                Logger.d(c, "Event " + strB + " found. Adding. event = " + statsEvent.d().toString() + ", isOnUiThread = " + n.c());
                return;
            }
            Logger.d(c, "Event " + strB + " found. Already reported. event = " + statsEvent.d().toString() + ", isOnUiThread = " + n.c());
            return;
        }
        Logger.d(c, "Event key is null, cannot add to events repository.");
    }

    public void a(String str) {
        StatsEvent statsEventRemove;
        k();
        if (str != null) {
            synchronized (r) {
                statsEventRemove = this.f.remove(str);
            }
            if (statsEventRemove != null) {
                Logger.d(c, "Event successfully removed from events repository, key=" + str);
                return;
            } else {
                Logger.d(c, "Event to remove wasn't found in events repository, key=" + str);
                return;
            }
        }
        Logger.d(c, "Event key is null, cannot remove from events repository.");
    }

    @Override // com.safedk.android.internal.a
    public void g() {
        if (n) {
            Logger.d(c, "onBackground started");
            this.j.set(true);
            this.m.execute(new Runnable() { // from class: com.safedk.android.analytics.StatsCollector.3
                @Override // java.lang.Runnable
                public void run() {
                    StatsCollector.this.d(true);
                }
            });
        }
    }

    @Override // com.safedk.android.internal.a
    public void h() {
        if (n) {
            Logger.d(c, "onForeground started");
            this.j.set(false);
            this.m.execute(new Runnable() { // from class: com.safedk.android.analytics.StatsCollector.4
                @Override // java.lang.Runnable
                public void run() {
                    StatsCollector.this.d(true);
                }
            });
        }
    }

    public boolean i() {
        return com.safedk.android.internal.b.getInstance().getForegroundActivity() == null || this.j.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        try {
            synchronized (r) {
                if (this.f == null || this.f.size() == 0) {
                    Logger.d(c, "sendEvents no events to report, skipping");
                } else {
                    HashSet<StatsEvent> hashSet = new HashSet(this.f.values());
                    Logger.d(c, "sendEvents started, persistImmatureEvents=" + z + ", isOnUiThread = " + n.c());
                    HashSet hashSet2 = new HashSet();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        StatsEvent statsEvent = (StatsEvent) it.next();
                        n.b(c, "sendEvents, key=" + statsEvent.b() + ", mature=" + statsEvent.a_() + ", event details " + statsEvent.toString());
                        if (!statsEvent.a_()) {
                            hashSet2.add(statsEvent);
                            it.remove();
                        }
                    }
                    if (hashSet.size() > 0) {
                        Logger.d(c, "sendEvents " + hashSet);
                    }
                    k();
                    boolean zIsInBackground = com.safedk.android.internal.b.getInstance().isInBackground();
                    boolean zI = i();
                    Logger.d(c, "foregroundActivity is null? " + zIsInBackground + ", is background? " + this.j.get());
                    ArrayList<Bundle> arrayListA = this.l.a(hashSet);
                    if (arrayListA.size() > 0 && !zI) {
                        Logger.d(c, "sendEvents sending the following events (" + arrayListA.size() + ") : " + arrayListA.toString());
                        this.l.a(arrayListA);
                        for (Bundle bundle : arrayListA) {
                            if (SafeDK.getInstance().A() != null && SafeDK.getInstance().A().i() != null) {
                                Logger.d(c, "eventIds removed " + bundle.getString("event_id") + " found banner eventId = " + SafeDK.getInstance().A().i().remove(bundle.getString("event_id")));
                            }
                            if (bundle.containsKey("event_type") && bundle.getString("event_type").equals("impression")) {
                                Logger.d(c, "sendEvents removing brand safety event  " + bundle.getString("impression_id"));
                                synchronized (r) {
                                    this.f.remove(bundle.getString("impression_id"));
                                }
                            } else if (bundle.containsKey("event_type") && bundle.getString("event_type").equals(RedirectEvent.b)) {
                                Logger.d(c, "sendEvents removing redirect event for key  " + RedirectEvent.b(bundle) + ", exists ? " + this.f.containsKey(RedirectEvent.b(bundle)));
                                synchronized (r) {
                                    this.f.remove(RedirectEvent.b(bundle));
                                }
                            } else {
                                Logger.d(c, "sendEvents Cannot remove event from stats repository " + bundle.toString());
                            }
                        }
                        if (SafeDK.getInstance().A() != null) {
                            Logger.d(c, "eventIds remaining : " + SafeDK.getInstance().A().i());
                        }
                    } else if (zI) {
                        Logger.d(c, "sendEvents will not report because the app is in the background");
                    }
                    if (z) {
                        Logger.d(c, "sendEvents persisting immature events");
                        if (hashSet2.size() > 0) {
                            Logger.d(c, hashSet2.size() + " sendEvents events to save");
                            Iterator it2 = hashSet2.iterator();
                            while (it2.hasNext()) {
                                b((StatsEvent) it2.next());
                            }
                        }
                    } else if (this.f != null && hashSet != null && this.f.size() > 0 && hashSet.size() > 0) {
                        Logger.d(c, "Before removing stats. repository size = " + this.f.size() + ", events (" + hashSet.size() + ") :" + hashSet.toString());
                        for (StatsEvent statsEvent2 : hashSet) {
                            Logger.d(c, "event key is " + statsEvent2.b());
                            synchronized (r) {
                                this.f.remove(statsEvent2.b(), statsEvent2);
                            }
                            this.g.add(statsEvent2.b());
                        }
                        Logger.d(c, "After removing stats events (" + this.f.size() + ") :" + this.f);
                    }
                }
            }
        } catch (Exception e2) {
            Logger.d(c, "error sending event: " + e2.getMessage(), e2);
            new CrashReporter().caughtException(e2);
        }
    }

    private void k() {
        if (this.l == null) {
            Logger.d(c, "statsReporter is null, initializing");
            StatsReporter.a();
            this.l = StatsReporter.b();
        }
    }
}
