package com.bytedance.adsdk.Og.KZx;

import android.util.Pair;

/* JADX INFO: loaded from: classes5.dex */
public class SD<T> {
    T Og;
    T pA;

    public void pA(T t, T t2) {
        this.pA = t;
        this.Og = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Og(pair.first, this.pA) && Og(pair.second, this.Og);
    }

    private static boolean Og(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.pA;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.Og;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.pA + " " + this.Og + "}";
    }
}
