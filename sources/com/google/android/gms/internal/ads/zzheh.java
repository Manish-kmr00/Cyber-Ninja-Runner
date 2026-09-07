package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzheh extends zzhef implements zzaqw {
    private int zzg;

    protected zzheh(String str) {
        super("mvhd");
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    protected final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzaqv.zzc(byteBuffer.get());
        zzaqv.zzd(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
