package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgmj {
    public static final zzgvs zza = zzgvs.zzb(new byte[0]);

    public static final zzgvs zza(int i) {
        return zzgvs.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzgvs zzb(int i) {
        return zzgvs.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
