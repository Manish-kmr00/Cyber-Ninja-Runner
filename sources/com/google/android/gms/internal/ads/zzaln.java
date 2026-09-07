package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaln {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzalm
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((zzaln) obj).zzb.zzb, ((zzaln) obj2).zzb.zzb);
        }
    };
    private final zzalo zzb;
    private final int zzc;

    /* synthetic */ zzaln(zzalo zzaloVar, int i, zzalr zzalrVar) {
        this.zzb = zzaloVar;
        this.zzc = i;
    }
}
