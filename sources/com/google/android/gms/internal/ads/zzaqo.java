package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public class zzaqo extends zzapj {
    private final Object zza;
    private final zzapo zzb;

    public zzaqo(int i, String str, zzapo zzapoVar, zzapn zzapnVar) {
        super(i, str, zzapnVar);
        this.zza = new Object();
        this.zzb = zzapoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapj
    protected final zzapp zzh(zzapf zzapfVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapfVar.zzb;
            Map map = zzapfVar.zzc;
            String str3 = C.ISO88591_NAME;
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                for (int i = 1; i < strArrSplit.length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapfVar.zzb);
        }
        return zzapp.zzb(str, zzaqg.zzb(zzapfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzapj
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzapo zzapoVar;
        synchronized (this.zza) {
            zzapoVar = this.zzb;
        }
        zzapoVar.zza(str);
    }
}
