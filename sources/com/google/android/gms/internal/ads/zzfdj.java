package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.json.nu;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfdj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfdj> CREATOR = new zzfdk();

    @Nullable
    public final Context zza;
    public final zzfdg zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfdg[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfdj(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfdg[] zzfdgVarArrValues = zzfdg.values();
        this.zzh = zzfdgVarArrValues;
        int[] iArrZza = zzfdh.zza();
        this.zzl = iArrZza;
        int[] iArrZza2 = zzfdi.zza();
        this.zzm = iArrZza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = zzfdgVarArrValues[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = iArrZza[i5];
        this.zzk = i6;
        int i7 = iArrZza2[i6];
    }

    @Nullable
    public static zzfdj zza(zzfdg zzfdgVar, Context context) {
        if (zzfdgVar == zzfdg.Rewarded) {
            return new zzfdj(context, zzfdgVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgp)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgv)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgx)).intValue(), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgz), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgr), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgt));
        }
        if (zzfdgVar == zzfdg.Interstitial) {
            return new zzfdj(context, zzfdgVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgq)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgw)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgy)).intValue(), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgA), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgs), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgu));
        }
        if (zzfdgVar != zzfdg.AppOpen) {
            return null;
        }
        return new zzfdj(context, zzfdgVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgD)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgF)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgG)).intValue(), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgB), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgC), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgE));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    private zzfdj(@Nullable Context context, zzfdg zzfdgVar, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfdg.values();
        this.zzl = zzfdh.zza();
        this.zzm = zzfdi.zza();
        this.zza = context;
        this.zzi = zzfdgVar.ordinal();
        this.zzb = zzfdgVar;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else {
            i4 = (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        nu.g.equals(str3);
        this.zzk = 0;
    }
}
