package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzggx {
    public static final /* synthetic */ int zza = 0;
    private static final zzgdi zzb = zzgli.zzd("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzgcy.class, zzgsn.SYMMETRIC, zzgtp.zzg());
    private static final zzglx zzc = new zzglx() { // from class: com.google.android.gms.internal.ads.zzggv
        @Override // com.google.android.gms.internal.ads.zzglx
        public final zzgdh zza(zzgdv zzgdvVar, Integer num) {
            int i = zzggx.zza;
            return zzghg.zzc((zzghl) zzgdvVar, num);
        }
    };
    private static final zzgna zzd = zzgna.zzb(new zzgmy() { // from class: com.google.android.gms.internal.ads.zzggw
        @Override // com.google.android.gms.internal.ads.zzgmy
        public final Object zza(zzgdh zzgdhVar) throws GeneralSecurityException {
            zzghg zzghgVar = (zzghg) zzgdhVar;
            int i = zzggx.zza;
            String strZzd = zzghgVar.zzd().zzd();
            zzgen zzgenVarZzb = zzghgVar.zzd().zzb();
            zzgcy zzgcyVarZzb = zzgdt.zza(strZzd).zzb();
            int i2 = zzggu.zza;
            try {
                return zzgjy.zzc(new zzggu(zzgst.zzf(zzgeb.zzb(zzgenVarZzb), zzgxf.zza()), zzgcyVarZzb), zzghgVar.zzb());
            } catch (zzgyk e) {
                throw new GeneralSecurityException(e);
            }
        }
    }, zzghg.class, zzgcy.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzgko.zza(1)) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        int i = zzghq.zza;
        zzghq.zze(zzgmi.zzc());
        zzgly.zzb().zzc(zzc, zzghl.class);
        zzgmf.zza().zzc(zzd);
        zzgkx.zzc().zzd(zzb, true);
    }
}
