package io.bidmachine.media3.exoplayer.offline;

import io.bidmachine.media3.common.StreamKey;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface FilterableManifest<T> {
    T copy(List<StreamKey> list);
}
