package io.appmetrica.analytics.coreutils.internal.cache;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes9.dex */
public interface CachedDataProvider {

    public static class CachedData<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10989a;
        private volatile long b;
        private volatile long c;
        private long d = 0;
        private Object e = null;

        public CachedData(long j, long j2, String str) {
            this.f10989a = String.format("[CachedData-%s]", str);
            this.b = j;
            this.c = j2;
        }

        public T getData() {
            return (T) this.e;
        }

        public long getExpiryTime() {
            return this.c;
        }

        public long getRefreshTime() {
            return this.b;
        }

        public final boolean isEmpty() {
            return this.e == null;
        }

        public void setData(T t) {
            this.e = t;
            this.d = System.currentTimeMillis();
        }

        public void setExpirationPolicy(long j, long j2) {
            this.b = j;
            this.c = j2;
        }

        public final boolean shouldClearData() {
            if (this.d == 0) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.d;
            return jCurrentTimeMillis > this.c || jCurrentTimeMillis < 0;
        }

        public final boolean shouldUpdateData() {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.d;
            return jCurrentTimeMillis > this.b || jCurrentTimeMillis < 0;
        }

        public String toString() {
            return "CachedData{tag='" + this.f10989a + "', refreshTime=" + this.b + ", expiryTime=" + this.c + ", mCachedTime=" + this.d + ", mCachedData=" + this.e + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
