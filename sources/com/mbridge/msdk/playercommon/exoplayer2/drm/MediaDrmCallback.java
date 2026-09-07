package com.mbridge.msdk.playercommon.exoplayer2.drm;

import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public interface MediaDrmCallback {
    byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest, String str) throws Exception;

    byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws Exception;
}
