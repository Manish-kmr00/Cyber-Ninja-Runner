package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzccc {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzaqz zzaqzVar;
        zzaqy zzaqyVar;
        long j = this.zza;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator it = new zzaqu(new zzccb(byteBufferDuplicate), zzccf.zzb).zzd().iterator();
            while (true) {
                zzaqzVar = null;
                if (!it.hasNext()) {
                    zzaqyVar = null;
                    break;
                }
                zzaqw zzaqwVar = (zzaqw) it.next();
                if (zzaqwVar instanceof zzaqy) {
                    zzaqyVar = (zzaqy) zzaqwVar;
                    break;
                }
            }
            for (zzaqw zzaqwVar2 : zzaqyVar.zzd()) {
                if (zzaqwVar2 instanceof zzaqz) {
                    zzaqzVar = (zzaqz) zzaqwVar2;
                    break;
                }
            }
            long jZzc = (zzaqzVar.zzc() * 1000) / zzaqzVar.zzd();
            this.zza = jZzc;
            return jZzc;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
