package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafg extends zzacn {
    public zzafg(final zzadn zzadnVar, int i, long j, long j2) {
        long j3;
        Objects.requireNonNull(zzadnVar);
        zzack zzackVar = new zzack() { // from class: com.google.android.gms.internal.ads.zzafd
            @Override // com.google.android.gms.internal.ads.zzack
            public final long zza(long j4) {
                return zzadnVar.zzb(j4);
            }
        };
        zzafe zzafeVar = new zzafe(zzadnVar, i, null);
        long jZza = zzadnVar.zza();
        long j4 = zzadnVar.zzj;
        int i2 = zzadnVar.zzd;
        if (i2 > 0) {
            j3 = ((((long) i2) + ((long) zzadnVar.zzc)) / 2) + 1;
        } else {
            int i3 = zzadnVar.zza;
            int i4 = zzadnVar.zzb;
            long j5 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            if (i3 == i4 && i3 > 0) {
                j5 = i3;
            }
            j3 = (((j5 * ((long) zzadnVar.zzg)) * ((long) zzadnVar.zzh)) / 8) + 64;
        }
        super(zzackVar, zzafeVar, jZza, 0L, j4, j, j2, j3, Math.max(6, zzadnVar.zzc));
    }
}
