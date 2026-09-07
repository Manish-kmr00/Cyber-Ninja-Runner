package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzaqs implements zzaqt {
    private static final Logger zzb = Logger.getLogger(zzaqs.class.getName());
    final ThreadLocal zza = new zzaqr(this);

    public abstract zzaqw zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final zzaqw zzb(zzhek zzhekVar, zzaqx zzaqxVar) throws IOException {
        int iZza;
        long jZzc;
        long jZzb = zzhekVar.zzb();
        ThreadLocal threadLocal = this.zza;
        ((ByteBuffer) threadLocal.get()).rewind().limit(8);
        do {
            iZza = zzhekVar.zza((ByteBuffer) threadLocal.get());
            if (iZza == 8) {
                ((ByteBuffer) threadLocal.get()).rewind();
                long jZze = zzaqv.zze((ByteBuffer) threadLocal.get());
                byte[] bArr = null;
                if (jZze < 8 && jZze > 1) {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jZze);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                byte[] bArr2 = new byte[4];
                ((ByteBuffer) threadLocal.get()).get(bArr2);
                try {
                    String str = new String(bArr2, C.ISO88591_NAME);
                    if (jZze == 1) {
                        ThreadLocal threadLocal2 = this.zza;
                        ((ByteBuffer) threadLocal2.get()).limit(16);
                        zzhekVar.zza((ByteBuffer) threadLocal2.get());
                        ((ByteBuffer) threadLocal2.get()).position(8);
                        jZzc = zzaqv.zzf((ByteBuffer) threadLocal2.get()) - 16;
                    } else {
                        jZzc = jZze == 0 ? zzhekVar.zzc() - zzhekVar.zzb() : jZze - 8;
                    }
                    if (CommonUrlParts.UUID.equals(str)) {
                        ThreadLocal threadLocal3 = this.zza;
                        ((ByteBuffer) threadLocal3.get()).limit(((ByteBuffer) threadLocal3.get()).limit() + 16);
                        zzhekVar.zza((ByteBuffer) threadLocal3.get());
                        bArr = new byte[16];
                        for (int iPosition = ((ByteBuffer) threadLocal3.get()).position() - 16; iPosition < ((ByteBuffer) threadLocal3.get()).position(); iPosition++) {
                            bArr[iPosition - (((ByteBuffer) threadLocal3.get()).position() - 16)] = ((ByteBuffer) threadLocal3.get()).get(iPosition);
                        }
                        jZzc -= 16;
                    }
                    long j = jZzc;
                    zzaqw zzaqwVarZza = zza(str, bArr, zzaqxVar instanceof zzaqw ? ((zzaqw) zzaqxVar).zza() : "");
                    ThreadLocal threadLocal4 = this.zza;
                    ((ByteBuffer) threadLocal4.get()).rewind();
                    zzaqwVarZza.zzb(zzhekVar, (ByteBuffer) threadLocal4.get(), j, this);
                    return zzaqwVarZza;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (iZza >= 0);
        zzhekVar.zze(jZzb);
        throw new EOFException();
    }
}
