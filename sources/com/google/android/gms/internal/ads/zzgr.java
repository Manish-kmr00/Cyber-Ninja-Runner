package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.net.HttpHeaders;
import com.safedk.android.internal.partials.AdMobNetworkBridge;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgr extends zzfx implements zzgz {
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgy zze;
    private final zzgy zzf;
    private zzgj zzg;
    private HttpURLConnection zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;

    /* synthetic */ zzgr(String str, int i, int i2, boolean z, boolean z2, zzgy zzgyVar, zzftx zzftxVar, boolean z3, zzgq zzgqVar) {
        super(true);
        this.zzd = str;
        this.zzb = i;
        this.zzc = i2;
        this.zza = z;
        this.zze = zzgyVar;
        this.zzf = new zzgy();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0070  */
    private final HttpURLConnection zzk(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        StringBuilder sb;
        String string;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzb);
        httpURLConnection.setReadTimeout(this.zzc);
        HashMap map2 = new HashMap();
        map2.putAll(this.zze.zza());
        map2.putAll(this.zzf.zza());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j != 0) {
            sb = new StringBuilder("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        } else if (j2 == -1) {
            string = null;
        } else {
            j = 0;
            sb = new StringBuilder("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        }
        if (string != null) {
            httpURLConnection.setRequestProperty("Range", string);
        }
        String str = this.zzd;
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, true != z ? "identity" : "gzip");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(false);
        int i2 = zzgj.zzh;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL url, String str, zzgj zzgjVar) throws zzgv {
        if (str == null) {
            throw new zzgv("Null location redirect", zzgjVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new zzgv("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgjVar, 2001, 1);
            }
            if (this.zza || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new zzgv("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", zzgjVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new zzgv(e, zzgjVar, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            try {
                AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            } catch (Exception e) {
                zzdx.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:13:0x002c A[Catch: IOException -> 0x0036, TRY_LEAVE, TryCatch #0 {IOException -> 0x0036, blocks: (B:4:0x0004, B:6:0x000d, B:9:0x0018, B:10:0x001e, B:13:0x002c), top: B:18:0x0004 }] */
    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws zzgv {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzl;
            if (j != -1) {
                long j2 = j - this.zzm;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                    InputStream inputStream = this.zzi;
                    int i4 = zzeu.zza;
                    i3 = inputStream.read(bArr, i, i2);
                    if (i3 == -1) {
                        this.zzm += (long) i3;
                        zzg(i3);
                        return i3;
                    }
                }
            } else {
                InputStream inputStream2 = this.zzi;
                int i5 = zzeu.zza;
                i3 = inputStream2.read(bArr, i, i2);
                if (i3 == -1) {
                    this.zzm += (long) i3;
                    zzg(i3);
                    return i3;
                }
            }
            return -1;
        } catch (IOException e) {
            zzgj zzgjVar = this.zzg;
            int i6 = zzeu.zza;
            throw zzgv.zza(e, zzgjVar, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ba  */
    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws zzgv {
        int i;
        HttpURLConnection httpURLConnectionZzk;
        byte[] bArrZzb;
        long j;
        this.zzg = zzgjVar;
        this.zzm = 0L;
        this.zzl = 0L;
        zzi(zzgjVar);
        try {
            URL url = new URL(zzgjVar.zza.toString());
            int i2 = zzgjVar.zzb;
            byte[] bArr = zzgjVar.zzc;
            long j2 = zzgjVar.zze;
            long j3 = zzgjVar.zzf;
            boolean zZzb = zzgjVar.zzb(1);
            try {
                if (this.zza) {
                    URL urlZzl = url;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i3 > 20) {
                            i = 1;
                            throw new zzgv(new NoRouteToHostException("Too many redirects: " + i4), zzgjVar, 2001, 1);
                        }
                        long j4 = j3;
                        long j5 = j2;
                        URL url2 = urlZzl;
                        HttpURLConnection httpURLConnectionZzk2 = zzk(urlZzl, 1, null, j2, j3, zZzb, false, zzgjVar.zzd);
                        int iHttpUrlConnectionGetResponseCode = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionZzk2);
                        String headerField = httpURLConnectionZzk2.getHeaderField("Location");
                        if (iHttpUrlConnectionGetResponseCode != 300 && iHttpUrlConnectionGetResponseCode != 301 && iHttpUrlConnectionGetResponseCode != 302 && iHttpUrlConnectionGetResponseCode != 303 && iHttpUrlConnectionGetResponseCode != 307 && iHttpUrlConnectionGetResponseCode != 308) {
                            httpURLConnectionZzk = httpURLConnectionZzk2;
                            break;
                        }
                        i = 1;
                        try {
                            AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionZzk2);
                            urlZzl = zzl(url2, headerField, zzgjVar);
                            i3 = i4;
                            j3 = j4;
                            j2 = j5;
                        } catch (IOException e) {
                            e = e;
                        }
                        e = e;
                        zzm();
                        throw zzgv.zza(e, zzgjVar, i);
                    }
                }
                httpURLConnectionZzk = zzk(url, 1, null, j2, j3, zZzb, true, zzgjVar.zzd);
                this.zzh = httpURLConnectionZzk;
                this.zzk = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionZzk);
                String responseMessage = httpURLConnectionZzk.getResponseMessage();
                int i5 = this.zzk;
                if (i5 < 200 || i5 > 299) {
                    Map<String, List<String>> headerFields = httpURLConnectionZzk.getHeaderFields();
                    if (this.zzk == 416) {
                        if (zzgjVar.zze == zzha.zzb(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                            this.zzj = true;
                            zzj(zzgjVar);
                            long j6 = zzgjVar.zzf;
                            if (j6 != -1) {
                                return j6;
                            }
                            return 0L;
                        }
                    }
                    InputStream errorStream = httpURLConnectionZzk.getErrorStream();
                    try {
                        bArrZzb = errorStream != null ? zzfzm.zzb(errorStream) : zzeu.zzc;
                    } catch (IOException unused) {
                        bArrZzb = zzeu.zzc;
                    }
                    byte[] bArr2 = bArrZzb;
                    zzm();
                    throw new zzgx(this.zzk, responseMessage, this.zzk == 416 ? new zzgf(2008) : null, headerFields, zzgjVar, bArr2);
                }
                httpURLConnectionZzk.getContentType();
                if (this.zzk == 200) {
                    j = zzgjVar.zze;
                    if (j == 0) {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionZzk.getHeaderField("Content-Encoding"));
                if (zEqualsIgnoreCase) {
                    this.zzl = zzgjVar.zzf;
                } else {
                    long j7 = zzgjVar.zzf;
                    if (j7 != -1) {
                        this.zzl = j7;
                    } else {
                        long jZza = zzha.zza(httpURLConnectionZzk.getHeaderField("Content-Length"), httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        this.zzl = jZza != -1 ? jZza - j : -1L;
                    }
                }
                try {
                    this.zzi = AdMobNetworkBridge.urlConnectionGetInputStream(httpURLConnectionZzk);
                    if (zEqualsIgnoreCase) {
                        this.zzi = new GZIPInputStream(this.zzi);
                    }
                    this.zzj = true;
                    zzj(zzgjVar);
                    if (j != 0) {
                        try {
                            byte[] bArr3 = new byte[4096];
                            while (j > 0) {
                                int iMin = (int) Math.min(j, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                                InputStream inputStream = this.zzi;
                                int i6 = zzeu.zza;
                                int i7 = inputStream.read(bArr3, 0, iMin);
                                if (Thread.currentThread().isInterrupted()) {
                                    throw new zzgv(new InterruptedIOException(), zzgjVar, 2000, 1);
                                }
                                if (i7 == -1) {
                                    throw new zzgv(zzgjVar, 2008, 1);
                                }
                                j -= (long) i7;
                                zzg(i7);
                            }
                        } catch (IOException e2) {
                            zzm();
                            if (e2 instanceof zzgv) {
                                throw ((zzgv) e2);
                            }
                            throw new zzgv(e2, zzgjVar, 2000, 1);
                        }
                    }
                    return this.zzl;
                } catch (IOException e3) {
                    zzm();
                    throw new zzgv(e3, zzgjVar, 2000, 1);
                }
            } catch (IOException e4) {
                e = e4;
                i = 1;
            }
        } catch (IOException e5) {
            e = e5;
            i = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        zzgj zzgjVar = this.zzg;
        if (zzgjVar != null) {
            return zzgjVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws zzgv {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zzgj zzgjVar = this.zzg;
                    int i = zzeu.zza;
                    throw new zzgv(e, zzgjVar, 2000, 3);
                }
            }
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
            this.zzh = null;
            this.zzg = null;
        } catch (Throwable th) {
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
            this.zzh = null;
            this.zzg = null;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfx, com.google.android.gms.internal.ads.zzge
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        return httpURLConnection == null ? zzfwz.zzd() : new zzgp(httpURLConnection.getHeaderFields());
    }
}
