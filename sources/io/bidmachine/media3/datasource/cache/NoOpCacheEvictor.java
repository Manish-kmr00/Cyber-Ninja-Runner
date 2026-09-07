package io.bidmachine.media3.datasource.cache;

/* JADX INFO: loaded from: classes13.dex */
public final class NoOpCacheEvictor implements CacheEvictor {
    @Override // io.bidmachine.media3.datasource.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override // io.bidmachine.media3.datasource.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
    }

    @Override // io.bidmachine.media3.datasource.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
    }

    @Override // io.bidmachine.media3.datasource.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    @Override // io.bidmachine.media3.datasource.cache.CacheEvictor
    public void onStartFile(Cache cache, String str, long j, long j2) {
    }

    @Override // io.bidmachine.media3.datasource.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return false;
    }
}
