package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzftn extends zzftj implements Serializable {
    private final Pattern zza;

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzftj
    public final zzfti zza(CharSequence charSequence) {
        return new zzftm(this.zza.matcher(charSequence));
    }

    zzftn(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }
}
