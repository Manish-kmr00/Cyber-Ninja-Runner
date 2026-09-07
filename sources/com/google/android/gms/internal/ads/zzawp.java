package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawp extends zzaxo {
    private static final zzaxp zzh = new zzaxp();
    private final zzarv zzi;
    private final Context zzj;
    private final zzatt zzk;

    public zzawp(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2, Context context, zzarm zzarmVar, zzarv zzarvVar, zzatt zzattVar) {
        super(zzawbVar, "I6IO+LQt3rQ7IR+La1Wf05vP+T+JXIE2+dXiYoVRp9J6etcZYK5uAv7Y0XaXL0/V", "0eX3+h8Ltl5Zobd4L6G06UqDuFfRlHQ71PPApHgzDdE=", zzarzVar, i, 27);
        this.zzj = context;
        this.zzi = zzarvVar;
        this.zzk = zzattVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzatq zzc() throws IllegalAccessException, InvocationTargetException {
        int iZza;
        String str;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcT)).booleanValue()) {
            iZza = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcY)).intValue();
        } else {
            iZza = this.zzi.zza();
        }
        zzatq zzatqVar = new zzatq((String) this.zze.invoke(null, this.zzj, false, ""));
        zzatt zzattVar = this.zzk;
        if (zzattVar == null || zzattVar.zza() == null) {
            str = ExifInterface.LONGITUDE_EAST;
        } else {
            try {
                str = (String) zzattVar.zza().get(iZza, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                str = ExifInterface.LONGITUDE_EAST;
            }
        }
        zzatqVar.zza = str;
        return zzatqVar;
    }

    private final String zzd() {
        try {
            zzawb zzawbVar = this.zza;
            if (zzawbVar.zzk() != null) {
                zzawbVar.zzk().get();
            }
            zzasu zzasuVarZzc = zzawbVar.zzc();
            if (zzasuVarZzc == null || !zzasuVarZzc.zzaf()) {
                return null;
            }
            return zzasuVarZzc.zzg();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i;
        zzatq zzatqVarZzc;
        zzatq zzatqVar;
        zzaxp zzaxpVar = zzh;
        Context context = this.zzj;
        AtomicReference atomicReferenceZza = zzaxpVar.zza(context.getPackageName());
        synchronized (atomicReferenceZza) {
            zzatq zzatqVar2 = (zzatq) atomicReferenceZza.get();
            if (zzatqVar2 == null || zzawe.zzd(zzatqVar2.zza) || zzatqVar2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzatqVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                boolean z = false;
                if (zzawe.zzd(null)) {
                    (!zzawe.zzd(null) ? false : false).booleanValue();
                    i = 3;
                } else {
                    i = 5;
                }
                if (this.zzk != null) {
                    zzatqVarZzc = zzc();
                } else {
                    if (i == 3 && !this.zzi.zzd()) {
                        z = true;
                    }
                    Boolean boolValueOf = Boolean.valueOf(z);
                    Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcH);
                    String strZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcG)).booleanValue() ? zzb() : null;
                    if (bool.booleanValue() && this.zza.zzo() && zzawe.zzd(strZzb)) {
                        strZzb = zzd();
                    }
                    zzatq zzatqVar3 = new zzatq((String) this.zze.invoke(null, context, boolValueOf, strZzb));
                    if (zzawe.zzd(zzatqVar3.zza) || zzatqVar3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                        int i2 = i - 1;
                        if (i2 == 3) {
                            String strZzd = zzd();
                            if (!zzawe.zzd(strZzd)) {
                                zzatqVar3.zza = strZzd;
                            }
                        } else if (i2 == 4) {
                            throw null;
                        }
                    }
                    zzatqVarZzc = zzatqVar3;
                }
                atomicReferenceZza.set(zzatqVarZzc);
            }
            zzatqVar = (zzatq) atomicReferenceZza.get();
        }
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            if (zzatqVar != null) {
                zzarzVar.zzv(zzatqVar.zza);
                zzarzVar.zzV(zzatqVar.zzb);
                zzarzVar.zzX(zzatqVar.zzc);
                zzarzVar.zzi(zzatqVar.zzd);
                zzarzVar.zzu(zzatqVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
            byte[] bArrZzf = zzawe.zzf((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcI));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzf)));
            if (!Build.TYPE.equals(POBConstants.KEY_USER)) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzawe.zzf((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcJ)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zza.zzj();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            final zzgcm zzgcmVarZze = zzgcm.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzaxq
                @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                public final void onChecksumsReady(List list) {
                    zzgcm zzgcmVar = zzgcmVarZze;
                    if (list == null) {
                        zzgcmVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                            if (apkChecksum.getType() == 8) {
                                zzgcmVar.zzc(zzawe.zzb(apkChecksum.getValue()));
                                return;
                            }
                        }
                        zzgcmVar.zzc(null);
                    } catch (Throwable unused) {
                        zzgcmVar.zzc(null);
                    }
                }
            });
            return (String) zzgcmVarZze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
