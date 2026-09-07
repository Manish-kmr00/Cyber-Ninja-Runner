package io.bidmachine.media3.datasource;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public final class PlaceholderDataSource implements DataSource {
    public static final PlaceholderDataSource INSTANCE = new PlaceholderDataSource();
    public static final DataSource.Factory FACTORY = new DataSource.Factory() { // from class: io.bidmachine.media3.datasource.PlaceholderDataSource$$ExternalSyntheticLambda0
        @Override // io.bidmachine.media3.datasource.DataSource.Factory
        public final DataSource createDataSource() {
            return PlaceholderDataSource.$r8$lambda$VWUsRLycdDyVdl6CMYZpsBoyBBs();
        }
    };

    public static /* synthetic */ PlaceholderDataSource $r8$lambda$VWUsRLycdDyVdl6CMYZpsBoyBBs() {
        return new PlaceholderDataSource();
    }

    @Override // io.bidmachine.media3.datasource.DataSource
    public void addTransferListener(TransferListener transferListener) {
    }

    @Override // io.bidmachine.media3.datasource.DataSource
    public void close() {
    }

    @Override // io.bidmachine.media3.datasource.DataSource
    public Uri getUri() {
        return null;
    }

    private PlaceholderDataSource() {
    }

    @Override // io.bidmachine.media3.datasource.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // io.bidmachine.media3.common.DataReader
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
