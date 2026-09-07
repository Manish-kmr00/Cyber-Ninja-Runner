package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzvo implements zzuw, zzuv {
    private final zzuw[] zza;
    private zzuv zze;
    private zzxd zzf;
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzwu zzh = new zzui(zzfww.zzn(), zzfww.zzn());
    private final IdentityHashMap zzb = new IdentityHashMap();
    private zzuw[] zzg = new zzuw[0];

    public zzvo(zzuj zzujVar, long[] jArr, zzuw... zzuwVarArr) {
        this.zza = zzuwVarArr;
        for (int i = 0; i < zzuwVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzxa(zzuwVarArr[i], j);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zza(long j, zzma zzmaVar) {
        zzuw[] zzuwVarArr = this.zzg;
        return (zzuwVarArr.length > 0 ? zzuwVarArr[0] : this.zza[0]).zza(j, zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzb() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final long zzc() {
        return this.zzh.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzd() {
        long j = -9223372036854775807L;
        for (zzuw zzuwVar : this.zzg) {
            long jZzd = zzuwVar.zzd();
            if (jZzd == -9223372036854775807L) {
                if (j != -9223372036854775807L && zzuwVar.zze(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (zzuw zzuwVar2 : this.zzg) {
                    if (zzuwVar2 == zzuwVar) {
                        break;
                    }
                    if (zzuwVar2.zze(jZzd) != jZzd) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = jZzd;
            } else if (jZzd != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zze(long j) {
        long jZze = this.zzg[0].zze(j);
        int i = 1;
        while (true) {
            zzuw[] zzuwVarArr = this.zzg;
            if (i >= zzuwVarArr.length) {
                return jZze;
            }
            if (zzuwVarArr[i].zze(jZze) != jZze) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final long zzf(zzyp[] zzypVarArr, boolean[] zArr, zzws[] zzwsVarArr, boolean[] zArr2, long j) {
        int length;
        int length2 = zzypVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i = 0;
        int i2 = 0;
        while (true) {
            length = zzypVarArr.length;
            if (i2 >= length) {
                break;
            }
            zzws zzwsVar = zzwsVarArr[i2];
            Integer num = zzwsVar == null ? null : (Integer) this.zzb.get(zzwsVar);
            iArr[i2] = num == null ? -1 : num.intValue();
            zzyp zzypVar = zzypVarArr[i2];
            if (zzypVar != null) {
                String str = zzypVar.zzg().zzb;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i2] = -1;
            }
            i2++;
        }
        IdentityHashMap identityHashMap = this.zzb;
        identityHashMap.clear();
        zzuw[] zzuwVarArr = this.zza;
        zzws[] zzwsVarArr2 = new zzws[length];
        zzws[] zzwsVarArr3 = new zzws[length];
        zzyp[] zzypVarArr2 = new zzyp[length];
        ArrayList arrayList = new ArrayList(zzuwVarArr.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < zzuwVarArr.length) {
            int i4 = i;
            while (i4 < zzypVarArr.length) {
                zzwsVarArr3[i4] = iArr[i4] == i3 ? zzwsVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzyp zzypVar2 = zzypVarArr[i4];
                    zzypVar2.getClass();
                    zzbm zzbmVar = (zzbm) this.zzd.get(zzypVar2.zzg());
                    zzbmVar.getClass();
                    zzypVarArr2[i4] = new zzvn(zzypVar2, zzbmVar);
                } else {
                    zzypVarArr2[i4] = null;
                }
                i4++;
                arrayList = arrayList;
            }
            ArrayList arrayList2 = arrayList;
            int i5 = i3;
            zzyp[] zzypVarArr3 = zzypVarArr2;
            zzws[] zzwsVarArr4 = zzwsVarArr3;
            long jZzf = zzuwVarArr[i3].zzf(zzypVarArr2, zArr, zzwsVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jZzf;
            } else if (jZzf != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzypVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzws zzwsVar2 = zzwsVarArr4[i6];
                    zzwsVar2.getClass();
                    zzwsVarArr2[i6] = zzwsVar2;
                    identityHashMap.put(zzwsVar2, Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzdc.zzf(zzwsVarArr4[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(zzuwVarArr[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzypVarArr2 = zzypVarArr3;
            zzwsVarArr3 = zzwsVarArr4;
            i = 0;
        }
        int i7 = i;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzwsVarArr2, i7, zzwsVarArr, i7, length);
        this.zzg = (zzuw[]) arrayList3.toArray(new zzuw[i7]);
        this.zzh = new zzui(arrayList3, zzfxm.zzb(arrayList3, new zzftl() { // from class: com.google.android.gms.internal.ads.zzvm
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return ((zzuw) obj).zzg().zzc();
            }
        }));
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzh(long j, boolean z) {
        for (zzuw zzuwVar : this.zzg) {
            zzuwVar.zzh(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzi() throws IOException {
        int i = 0;
        while (true) {
            zzuw[] zzuwVarArr = this.zza;
            if (i >= zzuwVarArr.length) {
                return;
            }
            zzuwVarArr[i].zzi();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* bridge */ /* synthetic */ void zzj(zzwu zzwuVar) {
        zzuv zzuvVar = this.zze;
        zzuvVar.getClass();
        zzuvVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzk(zzuv zzuvVar, long j) {
        this.zze = zzuvVar;
        ArrayList arrayList = this.zzc;
        zzuw[] zzuwVarArr = this.zza;
        Collections.addAll(arrayList, zzuwVarArr);
        for (zzuw zzuwVar : zzuwVarArr) {
            zzuwVar.zzk(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuv
    public final void zzl(zzuw zzuwVar) {
        ArrayList arrayList = this.zzc;
        arrayList.remove(zzuwVar);
        if (arrayList.isEmpty()) {
            zzuw[] zzuwVarArr = this.zza;
            int i = 0;
            for (zzuw zzuwVar2 : zzuwVarArr) {
                i += zzuwVar2.zzg().zzb;
            }
            zzbm[] zzbmVarArr = new zzbm[i];
            int i2 = 0;
            for (int i3 = 0; i3 < zzuwVarArr.length; i3++) {
                zzxd zzxdVarZzg = zzuwVarArr[i3].zzg();
                int i4 = zzxdVarZzg.zzb;
                int i5 = 0;
                while (i5 < i4) {
                    zzbm zzbmVarZzb = zzxdVarZzg.zzb(i5);
                    int i6 = zzbmVarZzb.zza;
                    zzz[] zzzVarArr = new zzz[i6];
                    for (int i7 = 0; i7 < i6; i7++) {
                        zzz zzzVarZzb = zzbmVarZzb.zzb(i7);
                        zzx zzxVarZzb = zzzVarZzb.zzb();
                        String str = zzzVarZzb.zza;
                        if (str == null) {
                            str = "";
                        }
                        zzxVarZzb.zzO(i3 + ":" + str);
                        zzzVarArr[i7] = zzxVarZzb.zzaj();
                    }
                    zzbm zzbmVar = new zzbm(i3 + ":" + zzbmVarZzb.zzb, zzzVarArr);
                    this.zzd.put(zzbmVar, zzbmVarZzb);
                    zzbmVarArr[i2] = zzbmVar;
                    i5++;
                    i2++;
                }
            }
            this.zzf = new zzxd(zzbmVarArr);
            zzuv zzuvVar = this.zze;
            zzuvVar.getClass();
            zzuvVar.zzl(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final void zzm(long j) {
        this.zzh.zzm(j);
    }

    public final zzuw zzn(int i) {
        zzuw zzuwVar = this.zza[i];
        return zzuwVar instanceof zzxa ? ((zzxa) zzuwVar).zzn() : zzuwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzo(zzku zzkuVar) {
        ArrayList arrayList = this.zzc;
        if (arrayList.isEmpty()) {
            return this.zzh.zzo(zzkuVar);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzuw) arrayList.get(i)).zzo(zzkuVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzuw, com.google.android.gms.internal.ads.zzwu
    public final boolean zzp() {
        return this.zzh.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final zzxd zzg() {
        zzxd zzxdVar = this.zzf;
        zzxdVar.getClass();
        return zzxdVar;
    }
}
