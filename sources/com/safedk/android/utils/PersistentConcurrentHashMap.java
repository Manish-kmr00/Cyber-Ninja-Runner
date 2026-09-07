package com.safedk.android.utils;

import android.content.SharedPreferences;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.FullScreenActivitiesCollection;
import com.safedk.android.analytics.brandsafety.RedirectData;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.base.StatsEvent;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class PersistentConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8150a = "SafeDKCache";
    private static final String d = "PersistentConcurrentHashMap";
    public String b;
    private LinkedHashSet<K> h;
    private String e = "";
    private int f = -1;
    private final ExecutorService g = Executors.newSingleThreadExecutor();
    protected AtomicBoolean c = new AtomicBoolean(true);

    public void a(String str) {
        this.e += com.safedk.android.analytics.brandsafety.l.ad + str;
        Logger.d(d, "sdk_null_check added value " + str);
    }

    public String a() {
        return this.e;
    }

    public PersistentConcurrentHashMap(String sharePrefsKey) {
        a(sharePrefsKey, -1);
    }

    public PersistentConcurrentHashMap(String sharePrefsKey, int capacityLimit) {
        a(sharePrefsKey, capacityLimit);
    }

    private synchronized void a(String str, int i) {
        if (str != null) {
            if (!str.isEmpty()) {
                this.b = str;
                this.f = i;
                if (i > -1) {
                    this.h = new LinkedHashSet<>(i, 1.0f);
                    Logger.d(d, "PersistentConcurrentHashMap filename = " + e() + ", capacity limit = " + i);
                }
                Logger.d(d, "PersistentConcurrentHashMap instance created, filename = " + e());
                h();
            }
        }
        throw new InvalidParameterException("argument sharePrefsKey cannot be empty");
    }

    public PersistentConcurrentHashMap() {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0041  */
    public synchronized K b() {
        K next;
        if (this.h != null) {
            Iterator<K> it = this.h.iterator();
            if (it.hasNext()) {
                next = it.next();
                Logger.d(d, "instance created, filename = " + e() + " getFirst returned key " + next.toString());
            } else {
                next = null;
            }
        } else {
            next = null;
        }
        return next;
    }

    private PersistentConcurrentHashMap(int initialCapacity) throws InvalidObjectException {
        throw new InvalidObjectException("This constructor is intentionally inaccessible");
    }

    private PersistentConcurrentHashMap(Map m) throws InvalidObjectException {
        throw new InvalidObjectException("This constructor is intentionally inaccessible");
    }

    private PersistentConcurrentHashMap(int initialCapacity, float loadFactor) throws InvalidObjectException {
        throw new InvalidObjectException("This constructor is intentionally inaccessible");
    }

    private PersistentConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel) throws InvalidObjectException {
        throw new InvalidObjectException("This constructor is intentionally inaccessible");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public synchronized void putAll(Map map) {
        Logger.v(d, "putAll started");
        for (K k : map.keySet()) {
            put(k, map.get(k));
            if (this.h != null) {
                this.h.add(k);
            }
        }
        if (this.c.get()) {
            f();
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public synchronized V put(K key, V value) {
        if (keySet().contains(key)) {
            super.remove(key);
            if (this.h != null) {
                this.h.remove(key);
            }
            Logger.d(d, "put filename = " + e() + ", removed existing key " + key);
        }
        super.put(key, value);
        d();
        if (this.h != null) {
            this.h.add(key);
        }
        Logger.d(d, "put filename = " + e() + ", added key " + key);
        if (this.c.get()) {
            f();
        }
        return value;
    }

    private synchronized void d() {
        if (this.f > -1 && size() > this.f) {
            K kB = b();
            if (kB != null) {
                remove(kB);
                Logger.d(d, "remove oldest entry if necessary, filename = " + e() + ", removed key " + kB);
            } else {
                Logger.d(d, "remove oldest entry if necessary, filename = " + e() + ", first item is null");
            }
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized boolean remove(Object key, Object value) {
        V vRemove;
        vRemove = remove(key);
        if (this.h != null) {
            this.h.remove(key);
        }
        Logger.d(d, "remove filename = " + e() + ", removed key " + vRemove);
        return vRemove != null;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public synchronized V remove(Object obj) {
        V v;
        try {
            if (obj == null) {
                Logger.d(d, "remove filename = " + e() + ", key is null, skipping");
                v = null;
            } else {
                v = (V) super.remove(obj);
                if (this.h != null) {
                    this.h.remove(obj);
                }
                Logger.v(d, "remove filename=" + e() + ", removed key " + obj);
                if (this.c.get()) {
                    f();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return v;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized boolean replace(K key, V oldValue, V newValue) {
        boolean zReplace;
        zReplace = super.replace(key, oldValue, newValue);
        Logger.d(d, "replace filename = " + e() + ", replace key " + key.toString());
        if (this.c.get()) {
            f();
        }
        return zReplace;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized V replace(K k, V v) {
        V v2;
        v2 = (V) super.replace(k, v);
        Logger.d(d, "replace filename = " + e() + ", replace key " + k.toString());
        if (this.c.get()) {
            f();
        }
        return v2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "SafeDKCache_" + this.b;
    }

    public boolean c() {
        return this.c.get();
    }

    public void a(boolean z) {
        this.c.set(z);
        if (this.c.get()) {
            f();
        }
    }

    private void f() {
        this.g.execute(new Runnable() { // from class: com.safedk.android.utils.PersistentConcurrentHashMap.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.d(PersistentConcurrentHashMap.d, "saveMap started, map key=" + PersistentConcurrentHashMap.this.e() + ", size before filtering=" + PersistentConcurrentHashMap.this.entrySet().size());
                try {
                    SharedPreferences sharedPreferences = SafeDK.getInstance().m().getSharedPreferences(PersistentConcurrentHashMap.this.e(), 0);
                    if (sharedPreferences != null) {
                        String strA = i.a(PersistentConcurrentHashMap.this.g());
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        if (sharedPreferences.contains(PersistentConcurrentHashMap.this.b)) {
                            editorEdit.remove(PersistentConcurrentHashMap.this.b).apply();
                        }
                        editorEdit.putString(PersistentConcurrentHashMap.this.b, strA);
                        editorEdit.apply();
                        Logger.v(PersistentConcurrentHashMap.d, "Map saved, key=" + PersistentConcurrentHashMap.this.e() + ", content length=" + (strA != null ? Integer.valueOf(strA.length()) : "null"));
                        return;
                    }
                    Logger.d(PersistentConcurrentHashMap.d, "saveMap cannot get share prefs object");
                } catch (Exception e) {
                    Logger.d(PersistentConcurrentHashMap.d, "Exception while saving map data", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMap<K, V> g() {
        Set<K> setKeySet;
        V next;
        long jV = SafeDK.getInstance().V();
        FullScreenActivitiesCollection fullScreenActivitiesCollection = (ConcurrentHashMap<K, V>) new ConcurrentHashMap();
        if (!isEmpty() && values().iterator().hasNext()) {
            synchronized (this) {
                next = values().iterator().next();
            }
            if (next instanceof CreativeInfo) {
                jV = CreativeInfoManager.a(((CreativeInfo) next).S(), AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_THRESHOLD, jV);
            } else if (next instanceof List) {
                List list = (List) next;
                if (!list.isEmpty() && (list.get(0) instanceof CreativeInfo)) {
                    jV = CreativeInfoManager.a(((CreativeInfo) list.get(0)).S(), AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_THRESHOLD, jV);
                }
            }
        }
        Logger.d(d, "filtering items for saving started, key=" + this.b + ", map contains=" + size() + ", max items=" + jV);
        if (size() <= jV) {
            synchronized (this) {
                fullScreenActivitiesCollection.putAll(this);
            }
        } else {
            synchronized (this) {
                setKeySet = keySet();
            }
            for (K k : setKeySet) {
                V v = get(k);
                if (v instanceof CreativeInfo) {
                    if (a((CreativeInfo) v) && fullScreenActivitiesCollection.size() <= jV) {
                        fullScreenActivitiesCollection.put(k, v);
                    }
                } else if (v instanceof List) {
                    List list2 = (List) v;
                    if (list2.isEmpty() || !(list2.get(0) instanceof CreativeInfo)) {
                        if (fullScreenActivitiesCollection.size() <= jV) {
                            fullScreenActivitiesCollection.put(k, v);
                        }
                    } else if (a((CreativeInfo) list2.get(0)) && fullScreenActivitiesCollection.size() <= jV) {
                        fullScreenActivitiesCollection.put(k, v);
                    }
                } else if (v != null && fullScreenActivitiesCollection.size() <= jV) {
                    fullScreenActivitiesCollection.put(k, v);
                }
            }
        }
        Logger.d(d, "filtering items for saving " + e() + " Filtered map contains " + fullScreenActivitiesCollection.size());
        return fullScreenActivitiesCollection;
    }

    private boolean a(CreativeInfo creativeInfo) {
        if (!SafeDK.getInstance().W().contains(creativeInfo.S())) {
            return false;
        }
        if (creativeInfo.ab() != null && creativeInfo.ab().before(new Timestamp(System.currentTimeMillis()))) {
            return false;
        }
        return true;
    }

    private void h() {
        Logger.d(d, "loadMap started, map key=" + e());
        try {
            try {
                try {
                    SharedPreferences sharedPreferences = SafeDK.getInstance().m().getSharedPreferences(e(), 0);
                    new ConcurrentHashMap();
                    if (sharedPreferences != null) {
                        String string = sharedPreferences.getString(this.b, null);
                        if (string != null) {
                            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) i.a(string);
                            Logger.d(d, "loadMap (" + e() + ") content length = " + string.length() + ", concurrentHashMap size = " + concurrentHashMap.size());
                            this.c.set(false);
                            for (Map.Entry<K, V> entry : concurrentHashMap.entrySet()) {
                                if (entry.getValue() instanceof CreativeInfo) {
                                    CreativeInfo creativeInfo = (CreativeInfo) entry.getValue();
                                    if (creativeInfo != null) {
                                        Logger.d(d, "loadMap including item " + creativeInfo.N() + " ,AdType is " + creativeInfo.M().name() + ", persistentContentSize(" + e() + "):" + string.length());
                                        creativeInfo.a(com.safedk.android.analytics.brandsafety.l.c, new com.safedk.android.analytics.brandsafety.l.a[0]);
                                        creativeInfo.af();
                                        put(entry.getKey(), entry.getValue());
                                        if (this.h != null) {
                                            this.h.add(entry.getKey());
                                        }
                                    }
                                } else if (entry.getValue() instanceof List) {
                                    List list = (List) entry.getValue();
                                    if (!list.isEmpty() && (list.get(0) instanceof CreativeInfo)) {
                                        CreativeInfo creativeInfo2 = (CreativeInfo) list.get(0);
                                        Logger.d(d, "loadMap including item " + creativeInfo2.N() + " ,AdType is " + creativeInfo2.M().name() + ", persistentContentSize(" + e() + "):" + string.length());
                                        creativeInfo2.a(com.safedk.android.analytics.brandsafety.l.c, new com.safedk.android.analytics.brandsafety.l.a[0]);
                                        creativeInfo2.af();
                                        put(entry.getKey(), entry.getValue());
                                        if (this.h != null) {
                                            this.h.add(entry.getKey());
                                        }
                                    }
                                } else if (entry.getValue() instanceof Boolean) {
                                    put(entry.getKey(), entry.getValue());
                                    if (this.h != null) {
                                        this.h.add(entry.getKey());
                                    }
                                } else if (entry.getValue() instanceof StatsEvent) {
                                    put(entry.getKey(), entry.getValue());
                                    if (this.h != null) {
                                        this.h.add(entry.getKey());
                                    }
                                } else if (entry.getValue() instanceof RedirectData) {
                                    Logger.d(d, "loadMap item key: " + entry.getKey() + ", value: " + entry.getValue());
                                    put(entry.getKey(), entry.getValue());
                                    if (this.h != null) {
                                        this.h.add(entry.getKey());
                                    }
                                }
                            }
                        } else {
                            Logger.d(d, "loadMap map is empty");
                        }
                        Logger.d(d, "loadMap loaded map " + e() + " : " + size() + " items");
                    }
                    this.c.set(true);
                } catch (InvalidClassException e) {
                    Logger.d(d, "loadMap Exception loading Map from file : " + e.getMessage(), e);
                    f();
                    this.c.set(true);
                } catch (IllegalArgumentException e2) {
                    Logger.d(d, "loadMap Data mismatch exception loading Map from file : " + e2.getMessage(), e2);
                    f();
                    this.c.set(true);
                }
            } catch (Throwable th) {
                Logger.e(d, "loadMap Error loading Map from file", th);
                f();
                this.c.set(true);
            }
        } catch (Throwable th2) {
            this.c.set(true);
            throw th2;
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public synchronized void clear() {
        super.clear();
        f();
    }
}
