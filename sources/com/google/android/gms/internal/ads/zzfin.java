package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfin implements zzgbo {
    final /* synthetic */ zzfgc zza;
    final /* synthetic */ zzfgn zzb;
    final /* synthetic */ zzcxm zzc;
    final /* synthetic */ zzfio zzd;

    zzfin(zzfio zzfioVar, zzfgc zzfgcVar, zzfgn zzfgnVar, zzcxm zzcxmVar) {
        this.zza = zzfgcVar;
        this.zzb = zzfgnVar;
        this.zzc = zzcxmVar;
        this.zzd = zzfioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        zzfgc zzfgcVar = this.zza;
        if (zzfgcVar == null) {
            return;
        }
        zzfgcVar.zzg(false);
        zzfgn zzfgnVar = this.zzb;
        if (zzfgnVar == null) {
            this.zzd.zzf.zzc(zzfgcVar.zzm());
        } else {
            zzfgnVar.zza(zzfgcVar);
            zzfgnVar.zzh();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00da  */
    /* JADX WARN: Code duplicated, block: B:63:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e7  */
    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        byte b;
        int i;
        long j;
        int iHashCode;
        int i2;
        zzfgc zzfgcVar = this.zza;
        com.google.android.gms.ads.internal.util.client.zzt zztVar = (com.google.android.gms.ads.internal.util.client.zzt) obj;
        if (zzfgcVar != null) {
            zzfgcVar.zzg(zztVar == com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
            zzfgn zzfgnVar = this.zzb;
            if (zzfgnVar == null) {
                this.zzd.zzf.zzc(zzfgcVar.zzm());
            } else {
                zzfgnVar.zza(zzfgcVar);
                zzfgnVar.zzh();
            }
        }
        zzcxm zzcxmVar = this.zzc;
        if (zzcxmVar != null) {
            String strZzb = this.zzd.zzd.zzb();
            if (TextUtils.isEmpty(strZzb)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(strZzb);
                Parcelable.Creator<com.google.android.gms.ads.internal.client.zzt> creator = com.google.android.gms.ads.internal.client.zzt.CREATOR;
                String strOptString = jSONObject.optString("type");
                String strOptString2 = jSONObject.optString("precision");
                String strOptString3 = jSONObject.optString("currency");
                long jOptLong = jSONObject.optLong("value", 0L);
                int iHashCode2 = strOptString.hashCode();
                byte b2 = -1;
                if (iHashCode2 != 66934) {
                    if (iHashCode2 != 66944) {
                        if (iHashCode2 == 1349395245 && strOptString.equals("ONE_PIXEL")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strOptString.equals("CPM")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strOptString.equals("CPC")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b != 0) {
                    if (b == 1) {
                        j = jOptLong;
                        i = 2;
                    } else if (b != 2) {
                        i = 0;
                    } else {
                        jOptLong /= 1000;
                        i = 3;
                    }
                    iHashCode = strOptString2.hashCode();
                    if (iHashCode != -2131980260) {
                        if (iHashCode != 399232571) {
                            if (iHashCode == 1271254246 && strOptString2.equals("PUBLISHER_PROVIDED")) {
                                b2 = 1;
                            }
                        } else if (strOptString2.equals("PRECISE")) {
                            b2 = 2;
                        }
                    } else if (strOptString2.equals("ESTIMATED")) {
                        b2 = 0;
                    }
                    if (b2 != 0) {
                        i2 = 1;
                    } else if (b2 != 1) {
                        i2 = 2;
                    } else if (b2 != 2) {
                        i2 = 0;
                    } else {
                        i2 = 3;
                    }
                    zzcxmVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, i2, strOptString3, j));
                }
                i = 1;
                j = jOptLong;
                iHashCode = strOptString2.hashCode();
                if (iHashCode != -2131980260) {
                    if (iHashCode != 399232571) {
                        if (iHashCode == 1271254246) {
                            b2 = 1;
                        }
                    } else if (strOptString2.equals("PRECISE")) {
                        b2 = 2;
                    }
                } else if (strOptString2.equals("ESTIMATED")) {
                    b2 = 0;
                }
                if (b2 != 0) {
                    i2 = 1;
                } else if (b2 != 1) {
                    i2 = 2;
                } else if (b2 != 2) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
                zzcxmVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, i2, strOptString3, j));
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "UrlPinger.pingUrl");
            }
        }
    }
}
