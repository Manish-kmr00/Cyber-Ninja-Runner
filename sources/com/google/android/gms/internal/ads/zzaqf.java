package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import com.safedk.android.internal.partials.AdMobFilesBridge;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqf implements zzaot {
    private final zzaqe zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaqf(zzaqe zzaqeVar, int i) {
        this.zzc = zzaqeVar;
    }

    static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    static String zzh(zzaqd zzaqdVar) throws IOException {
        return new String(zzm(zzaqdVar, zzf(zzaqdVar)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] zzm(zzaqd zzaqdVar, long j) throws IOException {
        long jZza = zzaqdVar.zza();
        if (j >= 0 && j <= jZza) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzaqdVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jZza);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzaqc zzaqcVar) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            this.zzb += zzaqcVar.zza - ((zzaqc) map.get(str)).zza;
        } else {
            this.zzb += zzaqcVar.zza;
        }
        map.put(str, zzaqcVar);
    }

    private final void zzp(String str) {
        zzaqc zzaqcVar = (zzaqc) this.zza.remove(str);
        if (zzaqcVar != null) {
            this.zzb -= zzaqcVar.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final synchronized zzaos zza(String str) {
        zzaqc zzaqcVar = (zzaqc) this.zza.get(str);
        if (zzaqcVar == null) {
            return null;
        }
        File fileZzg = zzg(str);
        try {
            zzaqd zzaqdVar = new zzaqd(new BufferedInputStream(new FileInputStream(fileZzg)), fileZzg.length());
            try {
                String str2 = zzaqc.zza(zzaqdVar).zzb;
                if (!TextUtils.equals(str, str2)) {
                    zzapv.zza("%s: key=%s, found=%s", fileZzg.getAbsolutePath(), str, str2);
                    zzp(str);
                    zzaqdVar.close();
                    return null;
                }
                byte[] bArrZzm = zzm(zzaqdVar, zzaqdVar.zza());
                zzaos zzaosVar = new zzaos();
                zzaosVar.zza = bArrZzm;
                zzaosVar.zzb = zzaqcVar.zzc;
                zzaosVar.zzc = zzaqcVar.zzd;
                zzaosVar.zzd = zzaqcVar.zze;
                zzaosVar.zze = zzaqcVar.zzf;
                zzaosVar.zzf = zzaqcVar.zzg;
                List<zzapb> list = zzaqcVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzapb zzapbVar : list) {
                    treeMap.put(zzapbVar.zza(), zzapbVar.zzb());
                }
                zzaosVar.zzg = treeMap;
                zzaosVar.zzh = Collections.unmodifiableList(list);
                zzaqdVar.close();
                return zzaosVar;
            } catch (Throwable th) {
                zzaqdVar.close();
                throw th;
            }
        } catch (IOException e) {
            zzapv.zza("%s: %s", fileZzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final synchronized void zzb() {
        try {
            File fileZza = this.zzc.zza();
            if (fileZza.exists()) {
                File[] fileArrListFiles = fileZza.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        try {
                            long length = file.length();
                            zzaqd zzaqdVar = new zzaqd(new BufferedInputStream(new FileInputStream(file)), length);
                            try {
                                zzaqc zzaqcVarZza = zzaqc.zza(zzaqdVar);
                                zzaqcVarZza.zza = length;
                                zzo(zzaqcVarZza.zzb, zzaqcVarZza);
                                zzaqdVar.close();
                            } catch (Throwable th) {
                                zzaqdVar.close();
                                throw th;
                            }
                        } catch (IOException unused) {
                            file.delete();
                        }
                    }
                }
            } else if (!fileZza.mkdirs()) {
                zzapv.zzb("Unable to create cache dir %s", fileZza.getAbsolutePath());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final synchronized void zzc(String str, boolean z) {
        zzaos zzaosVarZza = zza(str);
        if (zzaosVarZza != null) {
            zzaosVarZza.zzf = 0L;
            zzaosVarZza.zze = 0L;
            zzd(str, zzaosVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final synchronized void zzd(String str, zzaos zzaosVar) {
        long j = this.zzb;
        int length = zzaosVar.zza.length;
        long j2 = j + ((long) length);
        int i = this.zzd;
        if (j2 <= i || length <= i * 0.9f) {
            File fileZzg = zzg(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(AdMobFilesBridge.fileOutputStreamCtor(fileZzg));
                zzaqc zzaqcVar = new zzaqc(str, zzaosVar);
                try {
                    zzj(bufferedOutputStream, 538247942);
                    zzl(bufferedOutputStream, zzaqcVar.zzb);
                    String str2 = zzaqcVar.zzc;
                    if (str2 == null) {
                        str2 = "";
                    }
                    zzl(bufferedOutputStream, str2);
                    zzk(bufferedOutputStream, zzaqcVar.zzd);
                    zzk(bufferedOutputStream, zzaqcVar.zze);
                    zzk(bufferedOutputStream, zzaqcVar.zzf);
                    zzk(bufferedOutputStream, zzaqcVar.zzg);
                    List<zzapb> list = zzaqcVar.zzh;
                    if (list != null) {
                        zzj(bufferedOutputStream, list.size());
                        for (zzapb zzapbVar : list) {
                            zzl(bufferedOutputStream, zzapbVar.zza());
                            zzl(bufferedOutputStream, zzapbVar.zzb());
                        }
                    } else {
                        zzj(bufferedOutputStream, 0);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.write(zzaosVar.zza);
                    bufferedOutputStream.close();
                    zzaqcVar.zza = fileZzg.length();
                    zzo(str, zzaqcVar);
                    long j3 = this.zzb;
                    int i2 = this.zzd;
                    if (j3 >= i2) {
                        if (zzapv.zzb) {
                            zzapv.zzd("Pruning old cache entries.", new Object[0]);
                        }
                        long j4 = this.zzb;
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator it = this.zza.entrySet().iterator();
                        int i3 = 0;
                        while (it.hasNext()) {
                            zzaqc zzaqcVar2 = (zzaqc) ((Map.Entry) it.next()).getValue();
                            String str3 = zzaqcVar2.zzb;
                            if (zzg(str3).delete()) {
                                this.zzb -= zzaqcVar2.zza;
                            } else {
                                zzapv.zza("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                            }
                            it.remove();
                            i3++;
                            if (this.zzb < i2 * 0.9f) {
                                break;
                            }
                        }
                        if (zzapv.zzb) {
                            zzapv.zzd("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.zzb - j4), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                        }
                    }
                } catch (IOException e) {
                    zzapv.zza("%s", e.toString());
                    bufferedOutputStream.close();
                    zzapv.zza("Failed to write header for %s", fileZzg.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException unused) {
                if (!fileZzg.delete()) {
                    zzapv.zza("Could not clean up file %s", fileZzg.getAbsolutePath());
                }
                if (!this.zzc.zza().exists()) {
                    zzapv.zza("Re-initializing cache after external clearing.", new Object[0]);
                    this.zza.clear();
                    this.zzb = 0L;
                    zzb();
                }
            }
        }
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean zDelete = zzg(str).delete();
        zzp(str);
        if (zDelete) {
            return;
        }
        zzapv.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public zzaqf(File file, int i) {
        this.zzc = new zzaqb(this, file);
    }
}
