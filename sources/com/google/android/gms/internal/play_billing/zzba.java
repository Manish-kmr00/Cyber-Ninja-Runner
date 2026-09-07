package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzba {
    private final String zza;
    private final zzaz zzb;
    private zzaz zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzaz zzazVar = this.zzb.zzb;
        String str = "";
        while (zzazVar != null) {
            Object obj = zzazVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzazVar = zzazVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzba zza(@CheckForNull Object obj) {
        zzaz zzazVar = new zzaz();
        this.zzc.zzb = zzazVar;
        this.zzc = zzazVar;
        zzazVar.zza = obj;
        return this;
    }

    /* synthetic */ zzba(String str, zzbb zzbbVar) {
        zzaz zzazVar = new zzaz();
        this.zzb = zzazVar;
        this.zzc = zzazVar;
        str.getClass();
        this.zza = str;
    }
}
