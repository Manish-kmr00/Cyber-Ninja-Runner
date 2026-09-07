package io.bidmachine.media3.exoplayer.drm;

import io.bidmachine.media3.common.C;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.decoder.CryptoConfig;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public final class ErrorStateDrmSession implements DrmSession {
    private final DrmSession.DrmSessionException error;

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public CryptoConfig getCryptoConfig() {
        return null;
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public void release(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public boolean requiresSecureDecoder(String str) {
        return false;
    }

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(drmSessionException);
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public DrmSession.DrmSessionException getError() {
        return this.error;
    }

    @Override // io.bidmachine.media3.exoplayer.drm.DrmSession
    public final UUID getSchemeUuid() {
        return C.UUID_NIL;
    }
}
