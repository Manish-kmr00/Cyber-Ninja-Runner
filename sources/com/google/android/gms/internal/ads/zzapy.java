package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public class zzapy implements zzapc {
    protected final zzaqa zza;
    private final zzapx zzb;

    public zzapy(zzapx zzapxVar) {
        zzaqa zzaqaVar = new zzaqa(4096);
        this.zzb = zzapxVar;
        this.zza = zzaqaVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:117:0x021e  */
    /* JADX WARN: Code duplicated, block: B:144:0x026e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c5  */
    @Override // com.google.android.gms.internal.ads.zzapc
    public zzapf zza(zzapj zzapjVar) throws Throwable {
        zzaqh zzaqhVarZza;
        byte[] bArr;
        int iZzb;
        zzaql zzaqlVar;
        zzapf zzapfVar;
        zzaql zzaqlVar2;
        int iZzb2;
        Map mapEmptyMap;
        byte[] byteArray;
        byte[] bArrZzb;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                zzaos zzaosVarZzd = zzapjVar.zzd();
                if (zzaosVarZzd == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str = zzaosVarZzd.zzb;
                    if (str != null) {
                        map.put(HttpHeaders.IF_NONE_MATCH, str);
                    }
                    long j = zzaosVarZzd.zzd;
                    if (j > 0) {
                        map.put(HttpHeaders.IF_MODIFIED_SINCE, zzaqg.zzc(j));
                    }
                    mapEmptyMap = map;
                }
                zzaqhVarZza = this.zzb.zza(zzapjVar, mapEmptyMap);
                try {
                    int iZzb3 = zzaqhVarZza.zzb();
                    List listZzd = zzaqhVarZza.zzd();
                    if (iZzb3 == 304) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        zzaos zzaosVarZzd2 = zzapjVar.zzd();
                        if (zzaosVarZzd2 == null) {
                            return new zzapf(304, (byte[]) null, true, jElapsedRealtime2, listZzd);
                        }
                        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                        if (!listZzd.isEmpty()) {
                            Iterator it = listZzd.iterator();
                            while (it.hasNext()) {
                                treeSet.add(((zzapb) it.next()).zza());
                            }
                        }
                        ArrayList arrayList = new ArrayList(listZzd);
                        List list = zzaosVarZzd2.zzh;
                        if (list != null) {
                            if (!list.isEmpty()) {
                                for (zzapb zzapbVar : zzaosVarZzd2.zzh) {
                                    if (!treeSet.contains(zzapbVar.zza())) {
                                        arrayList.add(zzapbVar);
                                    }
                                }
                            }
                        } else if (!zzaosVarZzd2.zzg.isEmpty()) {
                            for (Map.Entry entry : zzaosVarZzd2.zzg.entrySet()) {
                                if (!treeSet.contains(entry.getKey())) {
                                    arrayList.add(new zzapb((String) entry.getKey(), (String) entry.getValue()));
                                }
                            }
                        }
                        return new zzapf(304, zzaosVarZzd2.zza, true, jElapsedRealtime2, (List) arrayList);
                    }
                    InputStream inputStreamZzc = zzaqhVarZza.zzc();
                    if (inputStreamZzc != null) {
                        int iZza = zzaqhVarZza.zza();
                        zzaqa zzaqaVar = this.zza;
                        zzaqn zzaqnVar = new zzaqn(zzaqaVar, iZza);
                        try {
                            bArrZzb = zzaqaVar.zzb(1024);
                            while (true) {
                                try {
                                    int i = inputStreamZzc.read(bArrZzb);
                                    if (i == -1) {
                                        break;
                                    }
                                    zzaqnVar.write(bArrZzb, 0, i);
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        inputStreamZzc.close();
                                    } catch (IOException unused) {
                                        zzapv.zzd("Error occurred when closing InputStream", new Object[0]);
                                    }
                                    zzaqaVar.zza(bArrZzb);
                                    zzaqnVar.close();
                                    throw th;
                                }
                            }
                            byteArray = zzaqnVar.toByteArray();
                            try {
                                inputStreamZzc.close();
                            } catch (IOException unused2) {
                                zzapv.zzd("Error occurred when closing InputStream", new Object[0]);
                            }
                            zzaqaVar.zza(bArrZzb);
                            zzaqnVar.close();
                        } catch (Throwable th2) {
                            th = th2;
                            bArrZzb = null;
                        }
                    } else {
                        byteArray = new byte[0];
                    }
                    byte[] bArr2 = byteArray;
                    try {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (zzapv.zzb || jElapsedRealtime3 > 3000) {
                            zzapv.zza("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", zzapjVar, Long.valueOf(jElapsedRealtime3), bArr2 != null ? Integer.valueOf(bArr2.length) : "null", Integer.valueOf(iZzb3), Integer.valueOf(zzapjVar.zzy().zza()));
                        }
                        if (iZzb3 < 200 || iZzb3 > 299) {
                            throw new IOException();
                        }
                        return new zzapf(iZzb3, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listZzd);
                    } catch (IOException e) {
                        e = e;
                        bArr = bArr2;
                        if (e instanceof SocketTimeoutException) {
                            zzaqlVar = new zzaql("socket", new zzapr(), null);
                        } else {
                            if (!(e instanceof MalformedURLException)) {
                                throw new RuntimeException("Bad URL ".concat(String.valueOf(zzapjVar.zzk())), e);
                            }
                            if (zzaqhVarZza != null) {
                                throw new zzapg(e);
                            }
                            iZzb = zzaqhVarZza.zzb();
                            zzapv.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb), zzapjVar.zzk());
                            if (bArr != null) {
                                zzapfVar = new zzapf(iZzb, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaqhVarZza.zzd());
                                if (iZzb == 401 && iZzb != 403) {
                                    if (iZzb < 400 || iZzb > 499) {
                                        throw new zzapq(zzapfVar);
                                    }
                                    throw new zzaow(zzapfVar);
                                }
                                zzaqlVar = new zzaql("auth", new zzaor(zzapfVar), null);
                            } else {
                                zzaqlVar = new zzaql("network", new zzape(), null);
                            }
                        }
                        zzaqlVar2 = zzaqlVar;
                        zzaox zzaoxVarZzy = zzapjVar.zzy();
                        iZzb2 = zzapjVar.zzb();
                        try {
                            zzaoxVarZzy.zzc(zzaqlVar2.zzb);
                            zzapjVar.zzm(String.format("%s-retry [timeout=%s]", zzaqlVar2.zza, Integer.valueOf(iZzb2)));
                        } catch (zzaps e2) {
                            zzapjVar.zzm(String.format("%s-timeout-giveup [timeout=%s]", zzaqlVar2.zza, Integer.valueOf(iZzb2)));
                            throw e2;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bArr = null;
                    if (e instanceof SocketTimeoutException) {
                        zzaqlVar = new zzaql("socket", new zzapr(), null);
                    } else {
                        if (!(e instanceof MalformedURLException)) {
                            throw new RuntimeException("Bad URL ".concat(String.valueOf(zzapjVar.zzk())), e);
                        }
                        if (zzaqhVarZza != null) {
                            throw new zzapg(e);
                        }
                        iZzb = zzaqhVarZza.zzb();
                        zzapv.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb), zzapjVar.zzk());
                        if (bArr != null) {
                            zzapfVar = new zzapf(iZzb, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaqhVarZza.zzd());
                            if (iZzb == 401) {
                            }
                            zzaqlVar = new zzaql("auth", new zzaor(zzapfVar), null);
                        } else {
                            zzaqlVar = new zzaql("network", new zzape(), null);
                        }
                    }
                    zzaqlVar2 = zzaqlVar;
                    zzaox zzaoxVarZzy2 = zzapjVar.zzy();
                    iZzb2 = zzapjVar.zzb();
                    zzaoxVarZzy2.zzc(zzaqlVar2.zzb);
                    zzapjVar.zzm(String.format("%s-retry [timeout=%s]", zzaqlVar2.zza, Integer.valueOf(iZzb2)));
                }
            } catch (IOException e4) {
                e = e4;
                zzaqhVarZza = null;
                bArr = null;
            }
            zzapjVar.zzm(String.format("%s-retry [timeout=%s]", zzaqlVar2.zza, Integer.valueOf(iZzb2)));
        }
    }
}
