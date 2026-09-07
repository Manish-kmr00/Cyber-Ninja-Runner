package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzvs extends zzug {
    private static final zzap zza;
    private final zzva[] zzb;
    private final List zzc;
    private final zzbl[] zzd;
    private final ArrayList zze;
    private int zzf = -1;
    private long[][] zzg;
    private zzvp zzh;
    private final zzuj zzi;

    static {
        zzad zzadVar = new zzad();
        zzadVar.zza("MergingMediaSource");
        zza = zzadVar.zzc();
    }

    public zzvs(boolean z, boolean z2, zzuj zzujVar, zzva... zzvaVarArr) {
        this.zzb = zzvaVarArr;
        this.zzi = zzujVar;
        this.zze = new ArrayList(Arrays.asList(zzvaVarArr));
        this.zzc = new ArrayList(zzvaVarArr.length);
        int i = 0;
        while (true) {
            int length = zzvaVarArr.length;
            if (i >= length) {
                this.zzd = new zzbl[length];
                this.zzg = new long[0][];
                new HashMap();
                zzfyc.zzb(8).zzb(2).zza();
                return;
            }
            this.zzc.add(new ArrayList());
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    protected final /* bridge */ /* synthetic */ void zzA(Object obj, zzva zzvaVar, zzbl zzblVar) {
        int iZzb;
        Integer num = (Integer) obj;
        if (this.zzh != null) {
            return;
        }
        if (this.zzf == -1) {
            iZzb = zzblVar.zzb();
            this.zzf = iZzb;
        } else {
            int iZzb2 = zzblVar.zzb();
            int i = this.zzf;
            if (iZzb2 != i) {
                this.zzh = new zzvp(0);
                return;
            }
            iZzb = i;
        }
        if (this.zzg.length == 0) {
            this.zzg = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iZzb, this.zzd.length);
        }
        ArrayList arrayList = this.zze;
        arrayList.remove(zzvaVar);
        zzbl[] zzblVarArr = this.zzd;
        zzblVarArr[num.intValue()] = zzblVar;
        if (arrayList.isEmpty()) {
            zzo(zzblVarArr[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzG(zzuw zzuwVar) {
        zzvo zzvoVar = (zzvo) zzuwVar;
        int i = 0;
        while (true) {
            zzva[] zzvaVarArr = this.zzb;
            if (i >= zzvaVarArr.length) {
                return;
            }
            List list = (List) this.zzc.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((zzvq) list.get(i2)).zzb.equals(zzuwVar)) {
                    list.remove(i2);
                    break;
                }
            }
            zzvaVarArr[i].zzG(zzvoVar.zzn(i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final zzuw zzI(zzuy zzuyVar, zzze zzzeVar, long j) {
        zzbl[] zzblVarArr = this.zzd;
        zzva[] zzvaVarArr = this.zzb;
        int length = zzvaVarArr.length;
        zzuw[] zzuwVarArr = new zzuw[length];
        int iZza = zzblVarArr[0].zza(zzuyVar.zza);
        for (int i = 0; i < length; i++) {
            zzuy zzuyVarZza = zzuyVar.zza(zzblVarArr[i].zzf(iZza));
            zzuwVarArr[i] = zzvaVarArr[i].zzI(zzuyVarZza, zzzeVar, j - this.zzg[iZza][i]);
            ((List) this.zzc.get(i)).add(new zzvq(zzuyVarZza, zzuwVarArr[i], null));
        }
        return new zzvo(this.zzi, this.zzg[iZza], zzuwVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final zzap zzJ() {
        zzva[] zzvaVarArr = this.zzb;
        return zzvaVarArr.length > 0 ? zzvaVarArr[0].zzJ() : zza;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zztx
    protected final void zzn(zzhe zzheVar) {
        super.zzn(zzheVar);
        int i = 0;
        while (true) {
            zzva[] zzvaVarArr = this.zzb;
            if (i >= zzvaVarArr.length) {
                return;
            }
            zzB(Integer.valueOf(i), zzvaVarArr[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zztx
    protected final void zzq() {
        super.zzq();
        Arrays.fill(this.zzd, (Object) null);
        this.zzf = -1;
        this.zzh = null;
        ArrayList arrayList = this.zze;
        arrayList.clear();
        Collections.addAll(arrayList, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zztx, com.google.android.gms.internal.ads.zzva
    public final void zzt(zzap zzapVar) {
        this.zzb[0].zzt(zzapVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    protected final /* bridge */ /* synthetic */ zzuy zzy(Object obj, zzuy zzuyVar) {
        int iIntValue = ((Integer) obj).intValue();
        List list = this.zzc;
        List list2 = (List) list.get(iIntValue);
        for (int i = 0; i < list2.size(); i++) {
            if (((zzvq) list2.get(i)).zza.equals(zzuyVar)) {
                return ((zzvq) ((List) list.get(0)).get(i)).zza;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzva
    public final void zzz() throws IOException {
        zzvp zzvpVar = this.zzh;
        if (zzvpVar != null) {
            throw zzvpVar;
        }
        super.zzz();
    }
}
