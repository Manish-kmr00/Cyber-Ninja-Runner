package io.bidmachine.media3.datasource.cache;

import io.bidmachine.media3.datasource.DataSpec;

/* JADX INFO: loaded from: classes13.dex */
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new CacheKeyFactory() { // from class: io.bidmachine.media3.datasource.cache.CacheKeyFactory$$ExternalSyntheticLambda0
        @Override // io.bidmachine.media3.datasource.cache.CacheKeyFactory
        public final String buildCacheKey(DataSpec dataSpec) {
            return CacheKeyFactory.lambda$static$0(dataSpec);
        }
    };

    String buildCacheKey(DataSpec dataSpec);

    static /* synthetic */ String lambda$static$0(DataSpec dataSpec) {
        return dataSpec.key != null ? dataSpec.key : dataSpec.uri.toString();
    }
}
