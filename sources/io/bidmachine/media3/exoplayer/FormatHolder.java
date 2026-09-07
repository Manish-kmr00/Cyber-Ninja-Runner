package io.bidmachine.media3.exoplayer;

import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.exoplayer.drm.DrmSession;

/* JADX INFO: loaded from: classes7.dex */
public final class FormatHolder {
    public DrmSession drmSession;
    public Format format;

    public void clear() {
        this.drmSession = null;
        this.format = null;
    }
}
