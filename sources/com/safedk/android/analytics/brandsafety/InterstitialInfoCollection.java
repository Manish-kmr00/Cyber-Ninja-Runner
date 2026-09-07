package com.safedk.android.analytics.brandsafety;

import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class InterstitialInfoCollection extends ConcurrentHashMap<String, n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8015a = "InterstitialInfoCollection";

    public List<n> a(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<String> it = keySet().iterator();
            while (it.hasNext()) {
                n nVar = get(it.next());
                if (nVar != null && !nVar.U && nVar.c() != null && nVar.c().equals(str)) {
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    public n a(String str, boolean z) {
        Logger.d(f8015a, "get by view address, viewAddress = " + str);
        if (str == null) {
            Logger.d(f8015a, "get by view address, view is null, exiting");
            return null;
        }
        if (str.contains("@")) {
            str = str.substring(str.indexOf(64) + 1);
            Logger.d(f8015a, "get by view address, viewAddress cut to " + str);
        }
        synchronized (this) {
            Iterator<String> it = keySet().iterator();
            while (it.hasNext()) {
                n nVar = get(it.next());
                if (nVar != null) {
                    if (z && nVar.U) {
                        Logger.d(f8015a, "get by view address - skipping ad that was already finished with event id - " + nVar.w());
                    } else {
                        Logger.d(f8015a, "get by view address, searching by viewAddress " + str + ", view hierarchy : " + nVar.x() + " is ad finished? " + nVar.U);
                        if (nVar.K != null && nVar.K.equals(str)) {
                            Logger.d(f8015a, "get by view address, found. viewAddress = " + str + " with event id: " + nVar.w());
                            return nVar;
                        }
                        if (nVar.x() != null && nVar.x().contains(str)) {
                            Logger.d(f8015a, "get by view address, found in views hierarchy . viewAddress = " + str + " with event id: " + nVar.w());
                            return nVar;
                        }
                    }
                }
            }
            return null;
        }
    }

    public n b(String str) {
        n nVar;
        Logger.d(f8015a, "get by activity address, viewAddress = " + str);
        if (str == null) {
            Logger.d(f8015a, "get by activity address, view is null, exiting");
            return null;
        }
        synchronized (this) {
            Iterator<String> it = keySet().iterator();
            while (it.hasNext()) {
                nVar = get(it.next());
                if (nVar != null && nVar.ac != null && nVar.ac.endsWith(str)) {
                    Logger.d(f8015a, "get by activity address, found by " + nVar.ac);
                }
            }
            nVar = null;
        }
        return nVar;
    }

    public boolean c(String str) {
        boolean z;
        Logger.d(f8015a, "contains activity address, viewAddress = " + str + ", keys = " + keySet());
        if (str == null) {
            Logger.d(f8015a, "contains activity address, view is null, exiting");
            return false;
        }
        synchronized (this) {
            Iterator<String> it = keySet().iterator();
            while (it.hasNext()) {
                n nVar = get(it.next());
                if (nVar != null && nVar.ac != null && nVar.ac.endsWith(str)) {
                    Logger.d(f8015a, "contains activity address, found by " + nVar.ac);
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public n d(String str) {
        if (str == null) {
            Logger.d(f8015a, "get by eventId, eventId is null, exiting");
            return null;
        }
        if (!containsKey(str)) {
            return null;
        }
        Logger.d(f8015a, "get by eventId, found by eventId " + str);
        return get(str);
    }

    public n e(String str) {
        n nVar;
        if (str == null) {
            Logger.d(f8015a, "get by adId, adId is null, exiting");
            return null;
        }
        synchronized (this) {
            Iterator<String> it = keySet().iterator();
            while (it.hasNext()) {
                nVar = get(it.next());
                if (nVar != null && nVar.j() != null && nVar.j().N().equals(str)) {
                    Logger.d(f8015a, "get by adId, found by adid " + str);
                }
            }
            nVar = null;
        }
        return nVar;
    }

    public boolean a() {
        Iterator<n> it = values().iterator();
        boolean z = true;
        while (it.hasNext()) {
            z = z && it.next().aq;
        }
        return z;
    }

    public String b() {
        HashSet hashSet = new HashSet();
        synchronized (this) {
            Iterator<n> it = values().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().c());
            }
        }
        return hashSet.toString();
    }

    protected int a(boolean z) {
        int i = 0;
        if (!z) {
            return size();
        }
        synchronized (this) {
            Iterator<n> it = values().iterator();
            while (it.hasNext()) {
                n next = it.next();
                i = (next == null || next.ap != null) ? i : i + 1;
            }
        }
        return i;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public int size() {
        return super.size();
    }

    public synchronized List<n> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (n nVar : values()) {
            if (nVar != null && nVar.ap == null) {
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InterstitialInfoCollection : ");
        synchronized (this) {
            for (n nVar : values()) {
                sb.append("[ ");
                if (nVar != null) {
                    if (nVar.v != null) {
                        sb.append("maxSdk=").append(nVar.v);
                    }
                    if (nVar.L != null) {
                        sb.append(",eventId=").append(nVar.L);
                    }
                    if (nVar.ap != null && nVar.ap.get() != null) {
                        sb.append(",interstitialActivity=").append(nVar.ap.get().toString());
                    }
                    if (nVar.K != null) {
                        sb.append(",viewAddress=").append(nVar.K);
                    }
                    sb.append(",isAdFinished=").append(nVar.U);
                }
                sb.append(" ] ");
            }
        }
        return sb.toString();
    }
}
