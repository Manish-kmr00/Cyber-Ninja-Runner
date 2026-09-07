package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;
import com.json.b9;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfif {
    private final com.google.android.gms.ads.internal.util.client.zzx zza;
    private final com.google.android.gms.ads.internal.util.client.zzu zzb;
    private final zzgce zzc;
    private final zzfig zzd;

    public zzfif(com.google.android.gms.ads.internal.util.client.zzx zzxVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzgce zzgceVar, zzfig zzfigVar) {
        this.zza = zzxVar;
        this.zzb = zzuVar;
        this.zzc = zzgceVar;
        this.zzd = zzfigVar;
    }

    public static /* synthetic */ ListenableFuture zzc(zzfif zzfifVar, int i, long j, String str, com.google.android.gms.ads.internal.util.client.zzt zztVar) {
        if (zztVar != com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE) {
            return zzgbs.zzh(zztVar);
        }
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = zzfifVar.zza;
        long jZzb = zzxVar.zzb();
        if (i != 1) {
            jZzb = (long) (zzxVar.zza() * j);
        }
        return zzfifVar.zze(str, jZzb, i + 1);
    }

    public final ListenableFuture zzd(String str) {
        try {
            return zze(str, 0L, 1);
        } catch (NullPointerException | RejectedExecutionException unused) {
            return zzgbs.zzh(com.google.android.gms.ads.internal.util.client.zzt.PERMANENT_FAILURE);
        }
    }

    private final ListenableFuture zze(final String str, final long j, final int i) {
        final String str2;
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.zza;
        if (i > zzxVar.zzc()) {
            zzfig zzfigVar = this.zzd;
            if (zzfigVar == null || !zzxVar.zzd()) {
                return zzgbs.zzh(com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE);
            }
            zzfigVar.zza(str, "", 2);
            return zzgbs.zzh(com.google.android.gms.ads.internal.util.client.zzt.BUFFERED);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziG)).booleanValue()) {
            Uri uri = Uri.parse(str);
            String encodedQuery = uri.getEncodedQuery();
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            builderClearQuery.appendQueryParameter("pa", Integer.toString(i));
            str2 = String.valueOf(builderClearQuery.build()) + b9.i.c + encodedQuery;
        } else {
            str2 = str;
        }
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzfie
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzfif.zzc(this.zza, i, j, str, (com.google.android.gms.ads.internal.util.client.zzt) obj);
            }
        };
        if (j == 0) {
            zzgce zzgceVar = this.zzc;
            return zzgbs.zzn(zzgceVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfid
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzb.zza(str2);
                }
            }), zzgazVar, zzgceVar);
        }
        zzgce zzgceVar2 = this.zzc;
        return zzgbs.zzn(zzgceVar2.schedule(new Callable() { // from class: com.google.android.gms.internal.ads.zzfic
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzb.zza(str2);
            }
        }, j, TimeUnit.MILLISECONDS), zzgazVar, zzgceVar2);
    }
}
