package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqc {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    static zzaqc zza(zzaqd zzaqdVar) throws IOException {
        if (zzaqf.zze(zzaqdVar) != 538247942) {
            throw new IOException();
        }
        String strZzh = zzaqf.zzh(zzaqdVar);
        String strZzh2 = zzaqf.zzh(zzaqdVar);
        long jZzf = zzaqf.zzf(zzaqdVar);
        long jZzf2 = zzaqf.zzf(zzaqdVar);
        long jZzf3 = zzaqf.zzf(zzaqdVar);
        long jZzf4 = zzaqf.zzf(zzaqdVar);
        int iZze = zzaqf.zze(zzaqdVar);
        if (iZze < 0) {
            throw new IOException("readHeaderList size=" + iZze);
        }
        List listEmptyList = iZze == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < iZze; i++) {
            listEmptyList.add(new zzapb(zzaqf.zzh(zzaqdVar).intern(), zzaqf.zzh(zzaqdVar).intern()));
        }
        return new zzaqc(strZzh, strZzh2, jZzf, jZzf2, jZzf3, jZzf4, listEmptyList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    zzaqc(String str, zzaos zzaosVar) {
        String str2 = zzaosVar.zzb;
        long j = zzaosVar.zzc;
        long j2 = zzaosVar.zzd;
        long j3 = zzaosVar.zze;
        long j4 = zzaosVar.zzf;
        List arrayList = zzaosVar.zzh;
        if (arrayList == null) {
            Map map = zzaosVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzapb((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    private zzaqc(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
