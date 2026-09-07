package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbwu extends zzbvz {
    private final String zza;
    private final int zzb;

    public zzbwu(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final int zze() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final String zzf() throws RemoteException {
        return this.zza;
    }

    public zzbwu(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
