package com.google.android.gms.internal.ads;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzftq {
    private final String zza;
    private final zzftp zzb;
    private zzftp zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzftp zzftpVar = this.zzb.zzb;
        String str = "";
        while (zzftpVar != null) {
            Object obj = zzftpVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzftpVar = zzftpVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzftq zza(Object obj) {
        zzftp zzftpVar = new zzftp();
        this.zzc.zzb = zzftpVar;
        this.zzc = zzftpVar;
        zzftpVar.zza = obj;
        return this;
    }

    /* synthetic */ zzftq(String str, zzftr zzftrVar) {
        zzftp zzftpVar = new zzftp();
        this.zzb = zzftpVar;
        this.zzc = zzftpVar;
        str.getClass();
        this.zza = str;
    }
}
