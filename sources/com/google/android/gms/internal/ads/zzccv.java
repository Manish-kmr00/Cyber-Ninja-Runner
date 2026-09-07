package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.safedk.android.internal.partials.AdMobFilesBridge;
import com.safedk.android.internal.partials.AdMobNetworkBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzccv extends zzccs {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzccv(zzcbg zzcbgVar) {
        super(zzcbgVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfpc.zza(zzfpb.zza(), cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String strValueOf = String.valueOf(this.zzg.getAbsolutePath());
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not create preload cache directory at ".concat(strValueOf));
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
            return;
        }
        String strValueOf2 = String.valueOf(this.zzg.getAbsolutePath());
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not set cache file permissions at ".concat(strValueOf2));
        this.zzg = null;
    }

    private final File zza(File file) {
        return new File(zzfpc.zza(zzfpb.zza(), this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0314 A[LOOP:3: B:85:0x0266->B:106:0x0314, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:127:0x0368 A[Catch: RuntimeException -> 0x03b3, IOException -> 0x03b5, TryCatch #2 {IOException -> 0x03b5, blocks: (B:95:0x02b1, B:125:0x035e, B:127:0x0368, B:128:0x0389, B:130:0x0394, B:133:0x039f), top: B:183:0x02b1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0394 A[Catch: RuntimeException -> 0x03b3, IOException -> 0x03b5, TRY_LEAVE, TryCatch #2 {IOException -> 0x03b5, blocks: (B:95:0x02b1, B:125:0x035e, B:127:0x0368, B:128:0x0389, B:130:0x0394, B:133:0x039f), top: B:183:0x02b1 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:167:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:168:0x0402  */
    /* JADX WARN: Code duplicated, block: B:171:0x0420  */
    /* JADX WARN: Code duplicated, block: B:188:0x039c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x02de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x017d A[Catch: RuntimeException -> 0x03cb, IOException | RuntimeException -> 0x03cd, TryCatch #18 {IOException | RuntimeException -> 0x03cd, blocks: (B:51:0x0115, B:53:0x0129, B:69:0x0177, B:71:0x017d, B:73:0x01a0, B:75:0x01b9, B:77:0x01f5), top: B:199:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01a0 A[Catch: RuntimeException -> 0x03cb, IOException | RuntimeException -> 0x03cd, TryCatch #18 {IOException | RuntimeException -> 0x03cd, blocks: (B:51:0x0115, B:53:0x0129, B:69:0x0177, B:71:0x017d, B:73:0x01a0, B:75:0x01b9, B:77:0x01f5), top: B:199:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01b9 A[Catch: RuntimeException -> 0x03cb, IOException | RuntimeException -> 0x03cd, TryCatch #18 {IOException | RuntimeException -> 0x03cd, blocks: (B:51:0x0115, B:53:0x0129, B:69:0x0177, B:71:0x017d, B:73:0x01a0, B:75:0x01b9, B:77:0x01f5), top: B:199:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01f5 A[Catch: RuntimeException -> 0x03cb, IOException | RuntimeException -> 0x03cd, TRY_LEAVE, TryCatch #18 {IOException | RuntimeException -> 0x03cd, blocks: (B:51:0x0115, B:53:0x0129, B:69:0x0177, B:71:0x017d, B:73:0x01a0, B:75:0x01b9, B:77:0x01f5), top: B:199:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x025f  */
    /* JADX WARN: Code duplicated, block: B:89:0x027d A[Catch: RuntimeException -> 0x0318, IOException | RuntimeException -> 0x031a, TryCatch #23 {IOException | RuntimeException -> 0x031a, blocks: (B:84:0x0263, B:85:0x0266, B:87:0x026c, B:89:0x027d, B:91:0x0283, B:93:0x0289), top: B:190:0x0263 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0283 A[Catch: RuntimeException -> 0x0318, IOException | RuntimeException -> 0x031a, TryCatch #23 {IOException | RuntimeException -> 0x031a, blocks: (B:84:0x0263, B:85:0x0266, B:87:0x026c, B:89:0x027d, B:91:0x0283, B:93:0x0289), top: B:190:0x0263 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0289 A[Catch: RuntimeException -> 0x0318, IOException | RuntimeException -> 0x031a, TRY_LEAVE, TryCatch #23 {IOException | RuntimeException -> 0x031a, blocks: (B:84:0x0263, B:85:0x0266, B:87:0x026c, B:89:0x027d, B:91:0x0283, B:93:0x0289), top: B:190:0x0263 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x02b8  */
    /* JADX WARN: Instruction removed from duplicated block: B:127:0x0368, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:167:0x03e9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:168:0x0402, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x017d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:75:0x01b9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x01f5, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzt(final String str) {
        int i;
        String str2;
        String str3;
        int contentLength;
        DecimalFormat decimalFormat;
        String str4;
        int iIntValue;
        ReadableByteChannel readableByteChannelNewChannel;
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        FileOutputStream fileOutputStream;
        String str5;
        FileChannel channel;
        ByteBuffer byteBufferAllocate;
        Clock clockZzC;
        long jCurrentTimeMillis;
        com.google.android.gms.ads.internal.util.zzbx zzbxVar;
        long jLongValue;
        int i2;
        int i3;
        String str6;
        DecimalFormat decimalFormat2;
        int i4;
        ByteBuffer byteBuffer;
        int i5;
        String str7;
        boolean zDelete;
        FileOutputStream fileOutputStream2 = null;
        if (this.zzg == null) {
            zzg(str, null, "noCacheDir", null);
            return false;
        }
        do {
            File file = this.zzg;
            if (file == null) {
                i = 0;
            } else {
                i = 0;
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().endsWith(".done")) {
                        i++;
                    }
                }
            }
            if (i <= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzr)).intValue()) {
                File file3 = new File(zzfpc.zza(zzfpb.zza(), this.zzg, com.google.android.gms.ads.internal.util.client.zzf.zzg(str)));
                File fileZza = zza(file3);
                if (file3.isFile() && fileZza.isFile()) {
                    int length = (int) file3.length();
                    String strValueOf = String.valueOf(str);
                    int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Stream cache hit at ".concat(strValueOf));
                    zzh(str, file3.getAbsolutePath(), length);
                    return true;
                }
                String strValueOf2 = String.valueOf(this.zzg.getAbsolutePath());
                String strValueOf3 = String.valueOf(str);
                Set set = zze;
                String strConcat = strValueOf2.concat(strValueOf3);
                synchronized (set) {
                    if (set.contains(strConcat)) {
                        int i7 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache already in progress at " + str);
                        zzg(str, file3.getAbsolutePath(), "inProgress", null);
                        return false;
                    }
                    set.add(strConcat);
                    String str8 = "error";
                    try {
                        HttpURLConnection httpURLConnectionZzn = zzfqa.zza().zzn(new zzfpz() { // from class: com.google.android.gms.internal.ads.zzccu
                            @Override // com.google.android.gms.internal.ads.zzfpz
                            public final URLConnection zza() throws IOException {
                                int i8 = zzccv.zzd;
                                com.google.android.gms.ads.internal.zzv.zzx();
                                int iIntValue2 = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzP)).intValue();
                                URL url = new URL(str);
                                int i9 = 0;
                                while (true) {
                                    i9++;
                                    if (i9 > 20) {
                                        throw new IOException("Too many redirects (20)");
                                    }
                                    int i10 = zzfpj.zzb;
                                    URLConnection uRLConnectionOpenConnection = url.openConnection();
                                    uRLConnectionOpenConnection.setConnectTimeout(iIntValue2);
                                    uRLConnectionOpenConnection.setReadTimeout(iIntValue2);
                                    if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                                        throw new IOException("Invalid protocol.");
                                    }
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                                    com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                                    zzlVar.zzc(httpURLConnection, null);
                                    httpURLConnection.setInstanceFollowRedirects(false);
                                    int iHttpUrlConnectionGetResponseCode = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                                    zzlVar.zze(httpURLConnection, iHttpUrlConnectionGetResponseCode);
                                    if (iHttpUrlConnectionGetResponseCode / 100 != 3) {
                                        return httpURLConnection;
                                    }
                                    String headerField = httpURLConnection.getHeaderField("Location");
                                    if (headerField == null) {
                                        throw new IOException("Missing Location header in redirect");
                                    }
                                    URL url2 = new URL(url, headerField);
                                    String protocol = url2.getProtocol();
                                    if (protocol == null) {
                                        throw new IOException("Protocol is null");
                                    }
                                    if (!protocol.equals("http") && !protocol.equals("https")) {
                                        throw new IOException("Unsupported scheme: ".concat(protocol));
                                    }
                                    String strConcat2 = "Redirecting to ".concat(headerField);
                                    int i11 = com.google.android.gms.ads.internal.util.zze.zza;
                                    com.google.android.gms.ads.internal.util.client.zzo.zze(strConcat2);
                                    AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                                    url = url2;
                                }
                            }
                        }, 265, -1);
                        if (httpURLConnectionZzn instanceof HttpURLConnection) {
                            HttpURLConnection httpURLConnection = httpURLConnectionZzn;
                            int iHttpUrlConnectionGetResponseCode = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionZzn);
                            if (iHttpUrlConnectionGetResponseCode < 400) {
                                contentLength = httpURLConnectionZzn.getContentLength();
                                if (contentLength < 0) {
                                    int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache aborted, missing content-length header at " + str);
                                    zzg(str, file3.getAbsolutePath(), "contentLengthMissing", null);
                                    set.remove(strConcat);
                                    return false;
                                }
                                decimalFormat = zzf;
                                str4 = decimalFormat.format(contentLength);
                                iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzs)).intValue();
                                if (contentLength > iIntValue) {
                                    int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Content length " + str4 + " exceeds limit at " + str);
                                    zzg(str, file3.getAbsolutePath(), "sizeExceeded", "File too big for full file cache. Size: " + str4);
                                    set.remove(strConcat);
                                    return false;
                                }
                                int i10 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zze("Caching " + str4 + " bytes from " + str);
                                readableByteChannelNewChannel = Channels.newChannel(AdMobNetworkBridge.urlConnectionGetInputStream(httpURLConnectionZzn));
                                fileOutputStreamFileOutputStreamCtor = AdMobFilesBridge.fileOutputStreamCtor(file3);
                                try {
                                    channel = fileOutputStreamFileOutputStreamCtor.getChannel();
                                    byteBufferAllocate = ByteBuffer.allocate(1048576);
                                    clockZzC = com.google.android.gms.ads.internal.zzv.zzC();
                                    jCurrentTimeMillis = clockZzC.currentTimeMillis();
                                    zzbxVar = new com.google.android.gms.ads.internal.util.zzbx(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzO)).longValue());
                                    zzbbz zzbbzVar = zzbci.zzN;
                                    zzbcg zzbcgVarZzc = com.google.android.gms.ads.internal.client.zzbd.zzc();
                                    jLongValue = ((Long) zzbcgVarZzc.zzb(zzbbzVar)).longValue();
                                    fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                                    i2 = 0;
                                    while (true) {
                                        try {
                                            i3 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                            if (i3 >= 0) {
                                                str6 = strConcat;
                                                str5 = str8;
                                                decimalFormat2 = decimalFormat;
                                                fileOutputStream.close();
                                                if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
                                                    com.google.android.gms.ads.internal.util.client.zzo.zze("Preloaded " + decimalFormat2.format(i2) + " bytes from " + str);
                                                }
                                                file3.setReadable(true, false);
                                                if (fileZza.isFile()) {
                                                    fileZza.setLastModified(System.currentTimeMillis());
                                                } else {
                                                    try {
                                                        fileZza.createNewFile();
                                                    } catch (IOException unused) {
                                                    }
                                                }
                                                zzh(str, file3.getAbsolutePath(), i2);
                                                str2 = str6;
                                                try {
                                                    zze.remove(str2);
                                                    return true;
                                                } catch (IOException e) {
                                                    e = e;
                                                    fileOutputStream2 = fileOutputStream;
                                                    str8 = str5;
                                                    str3 = 0;
                                                    if (e instanceof RuntimeException) {
                                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                                    }
                                                    fileOutputStream2.close();
                                                    if (this.zzh) {
                                                        int i11 = com.google.android.gms.ads.internal.util.zze.zza;
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                                    } else {
                                                        int i12 = com.google.android.gms.ads.internal.util.zze.zza;
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                                    }
                                                    if (file3.exists()) {
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                    }
                                                    zzg(str, file3.getAbsolutePath(), str8, str3);
                                                    zze.remove(str2);
                                                    return false;
                                                } catch (RuntimeException e2) {
                                                    e = e2;
                                                    fileOutputStream2 = fileOutputStream;
                                                    str8 = str5;
                                                    str3 = 0;
                                                    if (e instanceof RuntimeException) {
                                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                                    }
                                                    fileOutputStream2.close();
                                                    if (this.zzh) {
                                                        int i13 = com.google.android.gms.ads.internal.util.zze.zza;
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                                    } else {
                                                        int i14 = com.google.android.gms.ads.internal.util.zze.zza;
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                                    }
                                                    if (file3.exists()) {
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                    }
                                                    zzg(str, file3.getAbsolutePath(), str8, str3);
                                                    zze.remove(str2);
                                                    return false;
                                                }
                                            }
                                            i4 = i2 + i3;
                                            try {
                                                try {
                                                    if (i4 <= iIntValue) {
                                                        String str9 = "File too big for full file cache. Size: " + Integer.toString(i4);
                                                        throw new IOException("stream cache file size limit exceeded");
                                                    }
                                                    try {
                                                        byteBufferAllocate.flip();
                                                        while (channel.write(byteBufferAllocate) > 0) {
                                                        }
                                                        byteBufferAllocate.clear();
                                                        if (clockZzC.currentTimeMillis() - jCurrentTimeMillis <= 1000 * jLongValue) {
                                                            String str10 = "Timeout exceeded. Limit: " + Long.toString(jLongValue) + " sec";
                                                            throw new IOException("stream cache time limit exceeded");
                                                        }
                                                        byteBuffer = byteBufferAllocate;
                                                        if (!this.zzh) {
                                                            throw new IOException("abort requested");
                                                        }
                                                        if (zzbxVar.zzb()) {
                                                            str5 = str8;
                                                            i5 = i4;
                                                            str6 = strConcat;
                                                            try {
                                                                try {
                                                                    com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzccm(this, str, file3.getAbsolutePath(), i5, contentLength, false));
                                                                } catch (RuntimeException e3) {
                                                                    e = e3;
                                                                    str2 = str6;
                                                                    fileOutputStream2 = fileOutputStream;
                                                                    str8 = str5;
                                                                    str3 = 0;
                                                                    if (e instanceof RuntimeException) {
                                                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                                                    }
                                                                    fileOutputStream2.close();
                                                                    if (this.zzh) {
                                                                        int i15 = com.google.android.gms.ads.internal.util.zze.zza;
                                                                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                                                    } else {
                                                                        int i16 = com.google.android.gms.ads.internal.util.zze.zza;
                                                                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                                                    }
                                                                    if (file3.exists()) {
                                                                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                                    }
                                                                    zzg(str, file3.getAbsolutePath(), str8, str3);
                                                                    zze.remove(str2);
                                                                    return false;
                                                                }
                                                            } catch (IOException e4) {
                                                                e = e4;
                                                                str2 = str6;
                                                                fileOutputStream2 = fileOutputStream;
                                                                str8 = str5;
                                                                str3 = 0;
                                                                if (e instanceof RuntimeException) {
                                                                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                                                }
                                                                fileOutputStream2.close();
                                                                if (this.zzh) {
                                                                    int i17 = com.google.android.gms.ads.internal.util.zze.zza;
                                                                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                                                } else {
                                                                    int i18 = com.google.android.gms.ads.internal.util.zze.zza;
                                                                    com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                                                }
                                                                if (file3.exists()) {
                                                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                                }
                                                                zzg(str, file3.getAbsolutePath(), str8, str3);
                                                                zze.remove(str2);
                                                                return false;
                                                            }
                                                        } else {
                                                            i5 = i4;
                                                            str6 = strConcat;
                                                            str5 = str8;
                                                        }
                                                        decimalFormat = decimalFormat;
                                                        byteBufferAllocate = byteBuffer;
                                                        iIntValue = iIntValue;
                                                        zzbxVar = zzbxVar;
                                                        str8 = str5;
                                                        channel = channel;
                                                        i2 = i5;
                                                        readableByteChannelNewChannel = readableByteChannelNewChannel;
                                                        strConcat = str6;
                                                        contentLength = contentLength;
                                                    } catch (IOException | RuntimeException e5) {
                                                        e = e5;
                                                        str6 = strConcat;
                                                        str5 = str8;
                                                        str2 = str6;
                                                        fileOutputStream2 = fileOutputStream;
                                                        str8 = str5;
                                                        str3 = 0;
                                                        if (e instanceof RuntimeException) {
                                                            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                                        }
                                                        fileOutputStream2.close();
                                                        if (this.zzh) {
                                                            int i19 = com.google.android.gms.ads.internal.util.zze.zza;
                                                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                                        } else {
                                                            int i110 = com.google.android.gms.ads.internal.util.zze.zza;
                                                            com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                                        }
                                                        if (file3.exists()) {
                                                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                        }
                                                        zzg(str, file3.getAbsolutePath(), str8, str3);
                                                        zze.remove(str2);
                                                        return false;
                                                    }
                                                } catch (IOException | RuntimeException e6) {
                                                    e = e6;
                                                    str3 = zzbcgVarZzc;
                                                    fileOutputStream2 = fileOutputStream;
                                                    str2 = str6;
                                                }
                                            } catch (IOException | RuntimeException e7) {
                                                e = e7;
                                                fileOutputStream2 = fileOutputStream;
                                                str2 = str6;
                                                str3 = 0;
                                                if (e instanceof RuntimeException) {
                                                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                                }
                                                fileOutputStream2.close();
                                                if (this.zzh) {
                                                    int i111 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                                } else {
                                                    int i112 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                                }
                                                if (file3.exists()) {
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                }
                                                zzg(str, file3.getAbsolutePath(), str8, str3);
                                                zze.remove(str2);
                                                return false;
                                            }
                                        } catch (IOException e8) {
                                            e = e8;
                                            str2 = strConcat;
                                            str5 = str8;
                                            fileOutputStream2 = fileOutputStream;
                                            str8 = str5;
                                            str3 = 0;
                                            if (e instanceof RuntimeException) {
                                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                            }
                                            fileOutputStream2.close();
                                            if (this.zzh) {
                                                int i113 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                            } else {
                                                int i114 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                            }
                                            if (file3.exists()) {
                                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                            }
                                            zzg(str, file3.getAbsolutePath(), str8, str3);
                                            zze.remove(str2);
                                            return false;
                                        } catch (RuntimeException e9) {
                                            e = e9;
                                            str2 = strConcat;
                                            str5 = str8;
                                            fileOutputStream2 = fileOutputStream;
                                            str8 = str5;
                                            str3 = 0;
                                            if (e instanceof RuntimeException) {
                                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                            }
                                            fileOutputStream2.close();
                                            if (this.zzh) {
                                                int i115 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                            } else {
                                                int i116 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                            }
                                            if (file3.exists()) {
                                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                            }
                                            zzg(str, file3.getAbsolutePath(), str8, str3);
                                            zze.remove(str2);
                                            return false;
                                        }
                                    }
                                } catch (IOException | RuntimeException e10) {
                                    e = e10;
                                    fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                                }
                            } else {
                                str8 = "badUrl";
                                try {
                                    String str11 = "HTTP request failed. Code: " + Integer.toString(iHttpUrlConnectionGetResponseCode);
                                    try {
                                        throw new IOException("HTTP status code " + iHttpUrlConnectionGetResponseCode + " at " + str);
                                    } catch (IOException | RuntimeException e11) {
                                        e = e11;
                                        str7 = str11;
                                        str2 = strConcat;
                                        str3 = str7;
                                        if (e instanceof RuntimeException) {
                                            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                        }
                                        fileOutputStream2.close();
                                        if (this.zzh) {
                                            int i117 = com.google.android.gms.ads.internal.util.zze.zza;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                        } else {
                                            int i118 = com.google.android.gms.ads.internal.util.zze.zza;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                        }
                                        if (file3.exists()) {
                                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                        }
                                        zzg(str, file3.getAbsolutePath(), str8, str3);
                                        zze.remove(str2);
                                        return false;
                                    }
                                } catch (IOException | RuntimeException e12) {
                                    e = e12;
                                    str7 = null;
                                }
                            }
                        } else {
                            contentLength = httpURLConnectionZzn.getContentLength();
                            if (contentLength < 0) {
                                int i20 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache aborted, missing content-length header at " + str);
                                zzg(str, file3.getAbsolutePath(), "contentLengthMissing", null);
                                set.remove(strConcat);
                                return false;
                            }
                            decimalFormat = zzf;
                            str4 = decimalFormat.format(contentLength);
                            iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzs)).intValue();
                            if (contentLength > iIntValue) {
                                int i21 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Content length " + str4 + " exceeds limit at " + str);
                                zzg(str, file3.getAbsolutePath(), "sizeExceeded", "File too big for full file cache. Size: " + str4);
                                set.remove(strConcat);
                                return false;
                            }
                            int i119 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Caching " + str4 + " bytes from " + str);
                            readableByteChannelNewChannel = Channels.newChannel(AdMobNetworkBridge.urlConnectionGetInputStream(httpURLConnectionZzn));
                            fileOutputStreamFileOutputStreamCtor = AdMobFilesBridge.fileOutputStreamCtor(file3);
                            channel = fileOutputStreamFileOutputStreamCtor.getChannel();
                            byteBufferAllocate = ByteBuffer.allocate(1048576);
                            clockZzC = com.google.android.gms.ads.internal.zzv.zzC();
                            jCurrentTimeMillis = clockZzC.currentTimeMillis();
                            zzbxVar = new com.google.android.gms.ads.internal.util.zzbx(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzO)).longValue());
                            zzbbz zzbbzVar2 = zzbci.zzN;
                            zzbcg zzbcgVarZzc2 = com.google.android.gms.ads.internal.client.zzbd.zzc();
                            jLongValue = ((Long) zzbcgVarZzc2.zzb(zzbbzVar2)).longValue();
                            fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                            i2 = 0;
                            while (true) {
                                i3 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                if (i3 >= 0) {
                                    str6 = strConcat;
                                    str5 = str8;
                                    decimalFormat2 = decimalFormat;
                                    fileOutputStream.close();
                                    if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
                                        com.google.android.gms.ads.internal.util.client.zzo.zze("Preloaded " + decimalFormat2.format(i2) + " bytes from " + str);
                                    }
                                    file3.setReadable(true, false);
                                    if (fileZza.isFile()) {
                                        fileZza.setLastModified(System.currentTimeMillis());
                                    } else {
                                        fileZza.createNewFile();
                                    }
                                    zzh(str, file3.getAbsolutePath(), i2);
                                    str2 = str6;
                                    zze.remove(str2);
                                    return true;
                                }
                                i4 = i2 + i3;
                                if (i4 <= iIntValue) {
                                    String str12 = "File too big for full file cache. Size: " + Integer.toString(i4);
                                    throw new IOException("stream cache file size limit exceeded");
                                }
                                byteBufferAllocate.flip();
                                while (channel.write(byteBufferAllocate) > 0) {
                                }
                                byteBufferAllocate.clear();
                                if (clockZzC.currentTimeMillis() - jCurrentTimeMillis <= 1000 * jLongValue) {
                                    String str13 = "Timeout exceeded. Limit: " + Long.toString(jLongValue) + " sec";
                                    throw new IOException("stream cache time limit exceeded");
                                }
                                byteBuffer = byteBufferAllocate;
                                if (!this.zzh) {
                                    throw new IOException("abort requested");
                                }
                                if (zzbxVar.zzb()) {
                                    str5 = str8;
                                    i5 = i4;
                                    str6 = strConcat;
                                    com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzccm(this, str, file3.getAbsolutePath(), i5, contentLength, false));
                                } else {
                                    i5 = i4;
                                    str6 = strConcat;
                                    str5 = str8;
                                }
                                decimalFormat = decimalFormat;
                                byteBufferAllocate = byteBuffer;
                                iIntValue = iIntValue;
                                zzbxVar = zzbxVar;
                                str8 = str5;
                                channel = channel;
                                i2 = i5;
                                readableByteChannelNewChannel = readableByteChannelNewChannel;
                                strConcat = str6;
                                contentLength = contentLength;
                            }
                        }
                    } catch (IOException | RuntimeException e13) {
                        e = e13;
                        str2 = strConcat;
                        str8 = "error";
                        str3 = 0;
                        fileOutputStream2 = null;
                    }
                    if (e instanceof RuntimeException) {
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException | NullPointerException unused2) {
                    }
                    if (this.zzh) {
                        int i1110 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                    } else {
                        int i1111 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                    }
                    if (file3.exists() && !file3.delete()) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                    }
                    zzg(str, file3.getAbsolutePath(), str8, str3);
                    zze.remove(str2);
                    return false;
                }
            }
            File file4 = this.zzg;
            if (file4 == null) {
                break;
            }
            long j = Long.MAX_VALUE;
            File file5 = null;
            for (File file6 : file4.listFiles()) {
                if (!file6.getName().endsWith(".done")) {
                    long jLastModified = file6.lastModified();
                    if (jLastModified < j) {
                        file5 = file6;
                        j = jLastModified;
                    }
                }
            }
            if (file5 != null) {
                zDelete = file5.delete();
                File fileZza2 = zza(file5);
                if (fileZza2.isFile()) {
                    zDelete &= fileZza2.delete();
                }
            } else {
                zDelete = false;
            }
        } while (zDelete);
        int i22 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to expire stream cache");
        zzg(str, null, "expireFailed", null);
        return false;
    }
}
