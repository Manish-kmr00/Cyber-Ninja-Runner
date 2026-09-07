package com.bytedance.sdk.component.ML.KZx.pA;

import android.util.Log;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class KZx<K, V> {
    private int JG;
    private int KZx;
    private int ML;
    private int Og;
    private int SD;
    private int ZZv;
    private int omh;
    private final LinkedHashMap<K, SoftReference<V>> pA;

    protected int Og(K k, V v) {
        return 1;
    }

    protected V Og(K k) {
        return null;
    }

    public KZx(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.KZx = i;
        this.pA = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V pA(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.pA.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.SD++;
                    return v;
                }
                this.pA.remove(k);
            } else {
                v = null;
            }
            this.omh++;
            V vOg = Og(k);
            if (vOg == null) {
                return null;
            }
            synchronized (this) {
                this.ML++;
                SoftReference<V> softReferencePut = this.pA.put(k, new SoftReference<>(vOg));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.pA.put(k, softReferencePut);
                } else {
                    this.Og += KZx(k, vOg);
                }
            }
            if (v != null) {
                return v;
            }
            pA(this.KZx);
            return vOg;
        }
    }

    public final V pA(K k, V v) {
        V v2;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.ZZv++;
            this.Og += KZx(k, v);
            SoftReference<V> softReferencePut = this.pA.put(k, new SoftReference<>(v));
            if (softReferencePut != null) {
                v2 = softReferencePut.get();
                if (v2 != null) {
                    this.Og -= KZx(k, v2);
                }
            } else {
                v2 = null;
            }
        }
        pA(this.KZx);
        return v2;
    }

    public void pA(int i) {
        while (true) {
            synchronized (this) {
                if (this.Og < 0 || (this.pA.isEmpty() && this.Og != 0)) {
                    break;
                    break;
                }
                if (this.Og <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.pA.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                K key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.pA.remove(key);
                if (value != null) {
                    this.Og -= KZx(key, value.get());
                }
                this.JG++;
            }
        }
        Log.e("LruCache", "oom maybe occured, clear cache. size= " + this.Og + ", maxSize: " + i);
        this.Og = 0;
        this.pA.clear();
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
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.KZx), Integer.valueOf(this.SD), Integer.valueOf(this.omh), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
