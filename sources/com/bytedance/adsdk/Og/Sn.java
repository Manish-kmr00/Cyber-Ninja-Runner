package com.bytedance.adsdk.Og;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class Sn<K, V> {
    private int JG;
    private int KZx;
    private int ML;
    private int Og;
    private int SD;
    private int ZZv;
    private int omh;
    private final LinkedHashMap<K, V> pA;

    protected int Og(K k, V v) {
        return 1;
    }

    protected V Og(K k) {
        return null;
    }

    public Sn(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.KZx = i;
        this.pA = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V pA(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.pA.get(k);
            if (v != null) {
                this.SD++;
                return v;
            }
            this.omh++;
            V vOg = Og(k);
            if (vOg == null) {
                return null;
            }
            synchronized (this) {
                this.ML++;
                vPut = this.pA.put(k, vOg);
                if (vPut != null) {
                    this.pA.put(k, vPut);
                } else {
                    this.Og += KZx(k, vOg);
                }
            }
            if (vPut != null) {
                return vPut;
            }
            pA(this.KZx);
            return vOg;
        }
    }

    public final V pA(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.ZZv++;
            this.Og += KZx(k, v);
            vPut = this.pA.put(k, v);
            if (vPut != null) {
                this.Og -= KZx(k, vPut);
            }
        }
        pA(this.KZx);
        return vPut;
    }

    public void pA(int i) {
        while (true) {
            synchronized (this) {
                if (this.Og < 0 || (this.pA.isEmpty() && this.Og != 0)) {
                    break;
                }
                if (this.Og > i && !this.pA.isEmpty()) {
                    Map.Entry<K, V> next = this.pA.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.pA.remove(key);
                    this.Og -= KZx(key, value);
                    this.JG++;
                }
                return;
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    private int KZx(K k, V v) {
        int iOg = Og(k, v);
        if (iOg >= 0) {
            return iOg;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.SD;
        i2 = this.omh + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.KZx), Integer.valueOf(this.SD), Integer.valueOf(this.omh), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
