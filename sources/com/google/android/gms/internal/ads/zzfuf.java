package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfuf extends zzfuj {
    final /* synthetic */ zzfth zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfuf(zzful zzfulVar, CharSequence charSequence, zzfth zzfthVar) {
        super(zzfulVar, charSequence);
        this.zza = zzfthVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfuj
    final int zzc(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfuj
    final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzftw.zzb(i, length, "index");
        while (i < length) {
            if (this.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
