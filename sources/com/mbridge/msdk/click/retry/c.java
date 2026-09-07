package com.mbridge.msdk.click.retry;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: WaitRetryLruMemoryCache.java */
/* JADX INFO: loaded from: classes11.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, b> f4756a;
    private final int b;
    private int c;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.f4756a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int b(String str, b bVar) {
        return 1;
    }

    public final b a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            b bVar = this.f4756a.get(str);
            if (bVar != null) {
                return bVar;
            }
            return null;
        }
    }

    public final void b(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            b bVarRemove = this.f4756a.remove(str);
            if (bVarRemove != null) {
                this.c -= b(str, bVarRemove);
            }
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
    }

    public final boolean a(String str, b bVar) {
        if (str != null && bVar != null) {
            synchronized (this) {
                this.c += b(str, bVar);
                b bVarPut = this.f4756a.put(str, bVar);
                if (bVarPut != null) {
                    this.c -= b(str, bVarPut);
                }
            }
            a(this.b);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.c < 0 || (this.f4756a.isEmpty() && this.c != 0)) {
                    break;
                }
                if (this.c > i && !this.f4756a.isEmpty()) {
                    Map.Entry<String, b> next = this.f4756a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    try {
                        int iB = b(key, next.getValue());
                        this.f4756a.remove(key);
                        this.c -= iB;
                    } catch (Throwable unused) {
                    }
                }
                return;
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f4756a.keySet());
        }
        return hashSet;
    }
}
