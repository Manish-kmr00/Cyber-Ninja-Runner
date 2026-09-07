package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzben;
import com.google.android.gms.internal.ads.zzdrj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzp extends QueryInfoGenerationCallback {
    private final zzo zza;
    private final zzdrj zzb;
    private final boolean zzc;
    private final int zzd;
    private final long zze = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
    private final Boolean zzf;

    public zzp(zzo zzoVar, boolean z, int i, Boolean bool, zzdrj zzdrjVar) {
        this.zza = zzoVar;
        this.zzc = z;
        this.zzd = i;
        this.zzf = bool;
        this.zzb = zzdrjVar;
    }

    private static long zza() {
        return com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() + ((Long) zzben.zzh.zze()).longValue();
    }

    private final long zzb() {
        return com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - this.zze;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair("sgf_reason", str);
        pairArr[1] = new Pair("se", "query_g");
        pairArr[2] = new Pair("ad_format", AdFormat.BANNER.name());
        pairArr[3] = new Pair("rtype", Integer.toString(6));
        pairArr[4] = new Pair("scar", "true");
        pairArr[5] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[6] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[7] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[8] = new Pair("tpc", true != z ? "0" : "1");
        zzaa.zzd(this.zzb, null, "sgpcf", pairArr);
        this.zza.zzf(z, new zzq(null, str, zza(), i));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        Pair[] pairArr = new Pair[8];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair("ad_format", AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[5] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[6] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[7] = new Pair("tpc", true != z ? "0" : "1");
        zzaa.zzd(this.zzb, null, "sgpcs", pairArr);
        this.zza.zzf(z, new zzq(queryInfo, "", zza(), i));
    }
}
