package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgxh extends zzgxg {
    zzgxh() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxg
    final void zza(Object obj) {
        ((zzgxr) obj).zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzgxg
    final void zzb(zzhba zzhbaVar, Map.Entry entry) throws IOException {
        zzgxs zzgxsVar = (zzgxs) entry.getKey();
        if (!zzgxsVar.zzc) {
            zzhay zzhayVar = zzhay.DOUBLE;
            switch (zzgxsVar.zzb) {
                case DOUBLE:
                    zzhbaVar.zzf(zzgxsVar.zza, ((Double) entry.getValue()).doubleValue());
                    break;
                case FLOAT:
                    zzhbaVar.zzo(zzgxsVar.zza, ((Float) entry.getValue()).floatValue());
                    break;
                case INT64:
                    zzhbaVar.zzt(zzgxsVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case UINT64:
                    zzhbaVar.zzK(zzgxsVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case INT32:
                    zzhbaVar.zzr(zzgxsVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case FIXED64:
                    zzhbaVar.zzm(zzgxsVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case FIXED32:
                    zzhbaVar.zzk(zzgxsVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case BOOL:
                    zzhbaVar.zzb(zzgxsVar.zza, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case STRING:
                    zzhbaVar.zzG(zzgxsVar.zza, (String) entry.getValue());
                    break;
                case GROUP:
                    zzhbaVar.zzq(zzgxsVar.zza, entry.getValue(), zzgzq.zza().zzb(entry.getValue().getClass()));
                    break;
                case MESSAGE:
                    zzhbaVar.zzv(zzgxsVar.zza, entry.getValue(), zzgzq.zza().zzb(entry.getValue().getClass()));
                    break;
                case BYTES:
                    zzhbaVar.zzd(zzgxsVar.zza, (zzgwn) entry.getValue());
                    break;
                case UINT32:
                    zzhbaVar.zzI(zzgxsVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case ENUM:
                    zzhbaVar.zzr(zzgxsVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED32:
                    zzhbaVar.zzx(zzgxsVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED64:
                    zzhbaVar.zzz(zzgxsVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case SINT32:
                    zzhbaVar.zzB(zzgxsVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SINT64:
                    zzhbaVar.zzD(zzgxsVar.zza, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzhay zzhayVar2 = zzhay.DOUBLE;
        switch (zzgxsVar.zzb) {
            case DOUBLE:
                zzhab.zzt(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case FLOAT:
                zzhab.zzx(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case INT64:
                zzhab.zzA(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case UINT64:
                zzhab.zzI(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case INT32:
                zzhab.zzz(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case FIXED64:
                zzhab.zzw(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case FIXED32:
                zzhab.zzv(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case BOOL:
                zzhab.zzr(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case STRING:
                zzhab.zzG(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzhab.zzy(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgzq.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzhab.zzB(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgzq.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                zzhab.zzs(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar);
                break;
            case UINT32:
                zzhab.zzH(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case ENUM:
                zzhab.zzz(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case SFIXED32:
                zzhab.zzC(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case SFIXED64:
                zzhab.zzD(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case SINT32:
                zzhab.zzE(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
            case SINT64:
                zzhab.zzF(zzgxsVar.zza, (List) entry.getValue(), zzhbaVar, zzgxsVar.zzd);
                break;
        }
    }
}
