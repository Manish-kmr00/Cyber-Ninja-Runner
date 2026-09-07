package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.safedk.android.analytics.brandsafety.l;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdzx extends zzdzy {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcuf zzd;
    private final TelephonyManager zze;
    private final zzdzp zzf;
    private zzbbn.zzq zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbbn.zzaf.zzd.CONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbbn.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbbn.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbbn.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbbn.zzaf.zzd.DISCONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbbn.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbbn.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbbn.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbbn.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbbn.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbbn.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbbn.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbbn.zzaf.zzd.CONNECTING);
    }

    zzdzx(Context context, zzcuf zzcufVar, zzdzp zzdzpVar, zzdzl zzdzlVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzdzlVar, zzgVar);
        this.zzc = context;
        this.zzd = zzcufVar;
        this.zzf = zzdzpVar;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    static /* bridge */ /* synthetic */ zzbbn.zzab zza(zzdzx zzdzxVar, Bundle bundle) {
        zzbbn.zzab.zzb zzbVar;
        zzbbn.zzab.zza zzaVarZza = zzbbn.zzab.zza();
        int i = bundle.getInt(l.R, -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzdzxVar.zzg = zzbbn.zzq.ENUM_TRUE;
        } else {
            zzdzxVar.zzg = zzbbn.zzq.ENUM_FALSE;
            if (i == 0) {
                zzaVarZza.zzd(zzbbn.zzab.zzc.CELL);
            } else if (i != 1) {
                zzaVarZza.zzd(zzbbn.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarZza.zzd(zzbbn.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzbbn.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzbbn.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzbbn.zzab.zzb.LTE;
                    break;
                default:
                    zzbVar = zzbbn.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarZza.zzc(zzbVar);
        }
        return zzaVarZza.zzbr();
    }

    static /* bridge */ /* synthetic */ zzbbn.zzaf.zzd zzb(zzdzx zzdzxVar, Bundle bundle) {
        return (zzbbn.zzaf.zzd) zzb.get(zzfcd.zza(zzfcd.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbbn.zzaf.zzd.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzdzx zzdzxVar, boolean z, ArrayList arrayList, zzbbn.zzab zzabVar, zzbbn.zzaf.zzd zzdVar) {
        zzbbn.zzaf.zza.C0272zza c0272zzaZzn = zzbbn.zzaf.zza.zzn();
        c0272zzaZzn.zzn(arrayList);
        Context context = zzdzxVar.zzc;
        c0272zzaZzn.zzD(zzg(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0));
        c0272zzaZzn.zzE(com.google.android.gms.ads.internal.zzv.zzr().zzg(context, zzdzxVar.zze));
        zzdzp zzdzpVar = zzdzxVar.zzf;
        c0272zzaZzn.zzM(zzdzpVar.zze());
        c0272zzaZzn.zzL(zzdzpVar.zzb());
        c0272zzaZzn.zzG(zzdzpVar.zza());
        c0272zzaZzn.zzH(zzdVar);
        c0272zzaZzn.zzJ(zzabVar);
        c0272zzaZzn.zzK(zzdzxVar.zzg);
        c0272zzaZzn.zzN(zzg(z));
        c0272zzaZzn.zzP(zzdzpVar.zzd());
        c0272zzaZzn.zzO(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        c0272zzaZzn.zzQ(zzg(Settings.Global.getInt(context.getContentResolver(), "wifi_on", 0) != 0));
        return c0272zzaZzn.zzbr().zzaV();
    }

    private static final zzbbn.zzq zzg(boolean z) {
        return z ? zzbbn.zzq.ENUM_TRUE : zzbbn.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgbs.zzr(this.zzd.zzb(new Bundle()), new zzdzw(this, z), zzbzk.zzg);
    }
}
