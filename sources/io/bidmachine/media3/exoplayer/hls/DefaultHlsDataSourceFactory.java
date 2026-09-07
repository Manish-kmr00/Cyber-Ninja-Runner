package io.bidmachine.media3.exoplayer.hls;

import io.bidmachine.media3.datasource.DataSource;

/* JADX INFO: loaded from: classes10.dex */
public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {
    private final DataSource.Factory dataSourceFactory;

    public DefaultHlsDataSourceFactory(DataSource.Factory factory) {
        this.dataSourceFactory = factory;
    }

    @Override // io.bidmachine.media3.exoplayer.hls.HlsDataSourceFactory
    public DataSource createDataSource(int i) {
        return this.dataSourceFactory.createDataSource();
    }
}
