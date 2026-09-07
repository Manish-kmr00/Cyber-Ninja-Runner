package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzful {
    private final zzfuk zza;

    private zzful(zzfuk zzfukVar) {
        int i = zzftg.zzb;
        this.zza = zzfukVar;
    }

    public static zzful zza(int i) {
        final int i2 = 4000;
        return new zzful(new zzfuk(i2) { // from class: com.google.android.gms.internal.ads.zzfuc
            @Override // com.google.android.gms.internal.ads.zzfuk
            public final Iterator zza(zzful zzfulVar, CharSequence charSequence) {
                return new zzfuh(zzfulVar, charSequence, 4000);
            }
        });
    }

    public static zzful zzb(final zzfth zzfthVar) {
        return new zzful(new zzfuk() { // from class: com.google.android.gms.internal.ads.zzfud
            @Override // com.google.android.gms.internal.ads.zzfuk
            public final Iterator zza(zzful zzfulVar, CharSequence charSequence) {
                return new zzfuf(zzfulVar, charSequence, zzfthVar);
            }
        });
    }

    public static zzful zzc(Pattern pattern) {
        final zzftn zzftnVar = new zzftn(pattern);
        zzftw.zzi(!((zzftm) zzftnVar.zza("")).zza.matches(), "The pattern may not match the empty string: %s", zzftnVar);
        return new zzful(new zzfuk() { // from class: com.google.android.gms.internal.ads.zzfue
            @Override // com.google.android.gms.internal.ads.zzfuk
            public final Iterator zza(zzful zzfulVar, CharSequence charSequence) {
                return new zzfug(zzfulVar, charSequence, zzftnVar.zza(charSequence));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return this.zza.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfui(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itZzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZzg.hasNext()) {
            arrayList.add((String) itZzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
