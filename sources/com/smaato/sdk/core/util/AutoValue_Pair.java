package com.smaato.sdk.core.util;

/* JADX INFO: loaded from: classes14.dex */
final class AutoValue_Pair<F, S> extends Pair<F, S> {
    private final Object first;
    private final Object second;

    AutoValue_Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    @Override // com.smaato.sdk.core.util.Pair
    public F first() {
        return (F) this.first;
    }

    @Override // com.smaato.sdk.core.util.Pair
    public S second() {
        return (S) this.second;
    }

    public String toString() {
        return "Pair{first=" + this.first + ", second=" + this.second + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        Object obj2 = this.first;
        if (obj2 != null ? obj2.equals(pair.first()) : pair.first() == null) {
            Object obj3 = this.second;
            if (obj3 == null) {
                if (pair.second() == null) {
                    return true;
                }
            } else if (obj3.equals(pair.second())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.first;
        int iHashCode = ((obj == null ? 0 : obj.hashCode()) ^ 1000003) * 1000003;
        Object obj2 = this.second;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }
}
