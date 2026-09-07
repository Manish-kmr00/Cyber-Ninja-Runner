package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.internal.partials.AdMobFilesBridge;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawb {
    private static final String zzc = "zzawb";
    protected final Context zza;
    private ExecutorService zzd;
    private DexClassLoader zze;
    private zzavg zzf;
    private byte[] zzg;
    private final boolean zzj;
    private zzavb zzm;
    private zzaus zzn;
    private final Map zzo;
    private zzavu zzq;
    private volatile AdvertisingIdClient zzh = null;
    private volatile boolean zzi = false;
    private volatile zzasu zzk = null;
    private Future zzl = null;
    protected boolean zzb = false;
    private boolean zzp = false;

    private zzawb(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzj = applicationContext != null;
        context = applicationContext != null ? applicationContext : context;
        this.zza = context;
        this.zzo = new HashMap();
        if (this.zzq != null) {
            return;
        }
        this.zzq = new zzavu(context);
    }

    public static zzawb zzg(Context context, String str, String str2, boolean z, zzavb zzavbVar) throws Throwable {
        zzawb zzawbVar = new zzawb(context);
        try {
            zzawbVar.zzd = Executors.newCachedThreadPool(new zzavx());
            zzawbVar.zzi = z;
            if (z) {
                zzawbVar.zzd.submit(new zzavy(zzawbVar));
            }
            zzawbVar.zzd.execute(new zzawa(zzawbVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                Context context2 = zzawbVar.zza;
                googleApiAvailabilityLight.getApkVersion(context2);
                zzawbVar.zzb = googleApiAvailabilityLight.isGooglePlayServicesAvailable(context2) == 0;
            } catch (Throwable unused) {
            }
            if (zzavbVar != null) {
                zzawbVar.zzm = zzavbVar;
            } else {
                zzawbVar.zzn(0, true);
            }
            if (zzawe.zzc()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdA)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzavg zzavgVar = new zzavg(null);
            zzawbVar.zzf = zzavgVar;
            try {
                try {
                    byte[] bArrZzb = zzatp.zzb("g129pKJBWxhacrLEHuWXKufldwMr7QofwALdgN3mAiM=", false);
                    if (bArrZzb.length != 32) {
                        throw new zzavf(zzavgVar);
                    }
                    byte[] bArr = new byte[16];
                    ByteBuffer.wrap(bArrZzb, 4, 16).get(bArr);
                    for (int i = 0; i < 16; i++) {
                        bArr[i] = (byte) (bArr[i] ^ 68);
                    }
                    zzawbVar.zzg = bArr;
                    try {
                        try {
                            Context context3 = zzawbVar.zza;
                            File cacheDir = context3.getCacheDir();
                            if (cacheDir == null && (cacheDir = context3.getDir("dex", 0)) == null) {
                                throw new zzavr();
                            }
                            File file = new File(String.format("%s/%s.jar", cacheDir, "1742425615165"));
                            if (!file.exists()) {
                                byte[] bArrZzb2 = zzawbVar.zzf.zzb(zzawbVar.zzg, "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");
                                file.createNewFile();
                                FileOutputStream fileOutputStreamFileOutputStreamCtor = AdMobFilesBridge.fileOutputStreamCtor(file);
                                if (Build.VERSION.SDK_INT >= 33) {
                                    file.setReadOnly();
                                }
                                fileOutputStreamFileOutputStreamCtor.write(bArrZzb2, 0, bArrZzb2.length);
                                fileOutputStreamFileOutputStreamCtor.close();
                            }
                            zzawbVar.zzv(cacheDir, "1742425615165");
                            try {
                                try {
                                    zzawbVar.zze = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context3.getClassLoader());
                                    zzw(file);
                                    zzawbVar.zzu(cacheDir, "1742425615165");
                                    zzx(String.format("%s/%s.dex", cacheDir, "1742425615165"));
                                    zzawbVar.zzn = new zzaus(zzawbVar);
                                    zzawbVar.zzp = true;
                                } catch (SecurityException e) {
                                    throw new zzavr(e);
                                }
                            } catch (Throwable th) {
                                zzw(file);
                                zzawbVar.zzu(cacheDir, "1742425615165");
                                zzx(String.format("%s/%s.dex", cacheDir, "1742425615165"));
                                throw th;
                            }
                        } catch (FileNotFoundException e2) {
                            throw new zzavr(e2);
                        } catch (IOException e3) {
                            throw new zzavr(e3);
                        }
                    } catch (zzavf e4) {
                        throw new zzavr(e4);
                    } catch (NullPointerException e5) {
                        throw new zzavr(e5);
                    }
                    return zzawbVar;
                } catch (IllegalArgumentException e6) {
                    throw new zzavf(zzavgVar, e6);
                }
            } catch (zzavf e7) {
                throw new zzavr(e7);
            }
        } catch (zzavr unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzt() {
        try {
            if (this.zzh == null && this.zzj) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzh = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzh = null;
        }
    }

    private final void zzu(File file, String str) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        File file2 = new File(String.format("%s/%s.tmp", file, "1742425615165"));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1742425615165"));
        if (file3.exists()) {
            long length = file3.length();
            if (length > 0) {
                byte[] bArr = new byte[(int) length];
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file3);
                    try {
                        try {
                            if (fileInputStream2.read(bArr) <= 0) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused) {
                                }
                                zzw(file3);
                                return;
                            }
                            System.out.print(POBConstants.TEST_MODE);
                            System.out.print(POBConstants.TEST_MODE);
                            System.out.print(POBConstants.TEST_MODE);
                            zzasx zzasxVarZza = zzasy.zza();
                            byte[] bytes = Build.VERSION.SDK.getBytes();
                            zzgwn zzgwnVar = zzgwn.zzb;
                            zzasxVarZza.zzc(zzgwn.zzv(bytes, 0, bytes.length));
                            byte[] bytes2 = "1742425615165".getBytes();
                            zzasxVarZza.zzd(zzgwn.zzv(bytes2, 0, bytes2.length));
                            byte[] bytes3 = this.zzf.zza(this.zzg, bArr).getBytes();
                            zzasxVarZza.zza(zzgwn.zzv(bytes3, 0, bytes3.length));
                            byte[] bArrZzf = zzatw.zzf(bytes3);
                            zzasxVarZza.zzb(zzgwn.zzv(bArrZzf, 0, bArrZzf.length));
                            file2.createNewFile();
                            fileOutputStreamFileOutputStreamCtor = AdMobFilesBridge.fileOutputStreamCtor(file2);
                            try {
                                byte[] bArrZzaV = ((zzasy) zzasxVarZza.zzbr()).zzaV();
                                fileOutputStreamFileOutputStreamCtor.write(bArrZzaV, 0, bArrZzaV.length);
                                fileOutputStreamFileOutputStreamCtor.close();
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused2) {
                                }
                                try {
                                    fileOutputStreamFileOutputStreamCtor.close();
                                } catch (IOException unused3) {
                                }
                                zzw(file3);
                                return;
                            } catch (zzavf | IOException | NoSuchAlgorithmException unused4) {
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                if (fileOutputStreamFileOutputStreamCtor != null) {
                                    try {
                                        fileOutputStreamFileOutputStreamCtor.close();
                                    } catch (IOException unused6) {
                                    }
                                }
                                zzw(file3);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (zzavf | IOException | NoSuchAlgorithmException unused7) {
                            fileOutputStreamFileOutputStreamCtor = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStreamFileOutputStreamCtor = null;
                    }
                    fileInputStream = fileInputStream2;
                } catch (zzavf | IOException | NoSuchAlgorithmException unused8) {
                    fileOutputStreamFileOutputStreamCtor = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStreamFileOutputStreamCtor = null;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                    }
                }
                if (fileOutputStreamFileOutputStreamCtor != null) {
                    try {
                        fileOutputStreamFileOutputStreamCtor.close();
                    } catch (IOException unused10) {
                    }
                }
                zzw(file3);
                throw th;
            }
        }
    }

    private final boolean zzv(File file, String str) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        File file2 = new File(String.format("%s/%s.tmp", file, "1742425615165"));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1742425615165"));
        if (!file3.exists()) {
            FileInputStream fileInputStream = null;
            try {
                long length = file2.length();
                if (length <= 0) {
                    zzw(file2);
                    return false;
                }
                byte[] bArr = new byte[(int) length];
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                try {
                    try {
                        if (fileInputStream2.read(bArr) <= 0) {
                            Log.d(zzc, "Cannot read the cache data.");
                            zzw(file2);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                            return false;
                        }
                        try {
                            try {
                                zzasy zzasyVarZzc = zzasy.zzc(bArr, zzgxf.zza());
                                if ("1742425615165".equals(new String(zzasyVarZzc.zzh().zzA())) && Arrays.equals(zzasyVarZzc.zzf().zzA(), zzatw.zzf(zzasyVarZzc.zzd().zzA())) && Arrays.equals(zzasyVarZzc.zzg().zzA(), Build.VERSION.SDK.getBytes())) {
                                    byte[] bArrZzb = this.zzf.zzb(this.zzg, new String(zzasyVarZzc.zzd().zzA()));
                                    file3.createNewFile();
                                    fileOutputStreamFileOutputStreamCtor = AdMobFilesBridge.fileOutputStreamCtor(file3);
                                    try {
                                        fileOutputStreamFileOutputStreamCtor.write(bArrZzb, 0, bArrZzb.length);
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException unused2) {
                                        }
                                        try {
                                            fileOutputStreamFileOutputStreamCtor.close();
                                            return true;
                                        } catch (IOException unused3) {
                                            return true;
                                        }
                                    } catch (zzavf | IOException | NoSuchAlgorithmException unused4) {
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException unused5) {
                                            }
                                        }
                                        if (fileOutputStreamFileOutputStreamCtor != null) {
                                            try {
                                                fileOutputStreamFileOutputStreamCtor.close();
                                            } catch (IOException unused6) {
                                            }
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException unused7) {
                                            }
                                        }
                                        if (fileOutputStreamFileOutputStreamCtor == null) {
                                            throw th;
                                        }
                                        try {
                                            fileOutputStreamFileOutputStreamCtor.close();
                                            throw th;
                                        } catch (IOException unused8) {
                                            throw th;
                                        }
                                    }
                                }
                                zzw(file2);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused9) {
                                }
                                return false;
                            } catch (NullPointerException unused10) {
                                fileInputStream2.close();
                                return false;
                            }
                        } catch (IOException unused11) {
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStreamFileOutputStreamCtor = null;
                    }
                } catch (zzavf | IOException | NoSuchAlgorithmException unused12) {
                    fileOutputStreamFileOutputStreamCtor = null;
                }
            } catch (zzavf | IOException | NoSuchAlgorithmException unused13) {
                fileOutputStreamFileOutputStreamCtor = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStreamFileOutputStreamCtor = null;
            }
        }
        return false;
    }

    private static final void zzw(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            Log.d(zzc, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        }
    }

    private static final void zzx(String str) {
        zzw(new File(str));
    }

    public final int zza() {
        if (this.zzn != null) {
            return zzaus.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzasu zzc() {
        zzavb zzavbVar = this.zzm;
        if (zzavbVar == null) {
            return this.zzk;
        }
        if (zzavbVar.zza() == null || !zzavbVar.zza().isDone()) {
            return zzasu.zzc();
        }
        try {
            return (zzasu) this.zzm.zza().get();
        } catch (InterruptedException | ExecutionException unused) {
            return zzasu.zzc();
        }
    }

    public final zzaus zzd() {
        return this.zzn;
    }

    public final zzavg zze() {
        return this.zzf;
    }

    final zzavu zzf() {
        return this.zzq;
    }

    public final DexClassLoader zzh() {
        return this.zze;
    }

    public final Method zzi(String str, String str2) {
        zzaxn zzaxnVar = (zzaxn) this.zzo.get(new Pair(str, str2));
        if (zzaxnVar == null) {
            return null;
        }
        return zzaxnVar.zza();
    }

    public final ExecutorService zzj() {
        return this.zzd;
    }

    public final Future zzk() {
        zzavb zzavbVar = this.zzm;
        return zzavbVar != null ? zzavbVar.zza() : this.zzl;
    }

    final void zzn(int i, boolean z) {
        if (this.zzb) {
            Future<?> futureSubmit = this.zzd.submit(new zzavz(this, i, true));
            if (i == 0) {
                this.zzl = futureSubmit;
            }
        }
    }

    public final boolean zzo() {
        return this.zzb;
    }

    public final boolean zzp() {
        return this.zzp;
    }

    public final boolean zzq() {
        return this.zzq.zza();
    }

    public final boolean zzr(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        Map map = this.zzo;
        if (map.containsKey(pair)) {
            return false;
        }
        map.put(pair, new zzaxn(this, str, str2, clsArr));
        return true;
    }

    public final byte[] zzs() {
        return this.zzg;
    }
}
