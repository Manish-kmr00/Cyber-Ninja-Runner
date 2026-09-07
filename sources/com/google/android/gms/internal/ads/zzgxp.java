package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxp;
import com.google.android.gms.internal.ads.zzgxv;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public class zzgxp<MessageType extends zzgxv<MessageType, BuilderType>, BuilderType extends zzgxp<MessageType, BuilderType>> extends zzgvv<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    protected zzgxp(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzcd()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
    }

    private MessageType zza() {
        return (MessageType) this.zzb.zzbj();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzgzq.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    protected /* bridge */ /* synthetic */ zzgvv zzaD(zzgvw zzgvwVar) {
        zzbi((zzgxv) zzgvwVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    /* JADX INFO: renamed from: zzaK */
    public /* bridge */ /* synthetic */ zzgvv zzaW(zzgwt zzgwtVar, zzgxf zzgxfVar) throws IOException {
        zzbk(zzgwtVar, zzgxfVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    /* JADX INFO: renamed from: zzaN */
    public /* bridge */ /* synthetic */ zzgvv zzaZ(byte[] bArr, int i, int i2) throws zzgyk {
        zzbl(bArr, i, i2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    /* JADX INFO: renamed from: zzaO */
    public /* bridge */ /* synthetic */ zzgvv zzba(byte[] bArr, int i, int i2, zzgxf zzgxfVar) throws zzgyk {
        zzbm(bArr, i, i2, zzgxfVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public /* bridge */ /* synthetic */ zzgzf zzaW(zzgwt zzgwtVar, zzgxf zzgxfVar) throws IOException {
        zzbk(zzgwtVar, zzgxfVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public /* bridge */ /* synthetic */ zzgzf zzaZ(byte[] bArr, int i, int i2) throws zzgyk {
        zzbl(bArr, i, i2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public /* bridge */ /* synthetic */ zzgzf zzba(byte[] bArr, int i, int i2, zzgxf zzgxfVar) throws zzgyk {
        zzbm(bArr, i, i2, zzgxfVar);
        return this;
    }

    public final BuilderType zzbg() {
        if (this.zzb.zzcd()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    /* JADX INFO: renamed from: zzbh, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public BuilderType zzaP() {
        BuilderType buildertype = (BuilderType) zzbt().zzcX();
        buildertype.zza = (MessageType) zzbs();
        return buildertype;
    }

    protected BuilderType zzbi(MessageType messagetype) {
        zzbj(messagetype);
        return this;
    }

    public BuilderType zzbj(MessageType messagetype) {
        if (zzbt().equals(messagetype)) {
            return this;
        }
        zzbu();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbk(zzgwt zzgwtVar, zzgxf zzgxfVar) throws IOException {
        zzbu();
        try {
            zzgzq.zza().zzb(this.zza.getClass()).zzh(this.zza, zzgwu.zzq(zzgwtVar), zzgxfVar);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public BuilderType zzbl(byte[] bArr, int i, int i2) throws zzgyk {
        int i3 = zzgxf.zzb;
        int i4 = zzgzq.zza;
        zzbm(bArr, i, i2, zzgxf.zza);
        return this;
    }

    public BuilderType zzbm(byte[] bArr, int i, int i2, zzgxf zzgxfVar) throws zzgyk {
        zzbu();
        try {
            zzgzq.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, i, i + i2, new zzgwb(zzgxfVar));
            return this;
        } catch (zzgyk e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    /* JADX INFO: renamed from: zzbn, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbr() {
        MessageType messagetype = (MessageType) zzbs();
        if (messagetype.zzbw()) {
            return messagetype;
        }
        throw zzbb(messagetype);
    }

    @Override // com.google.android.gms.internal.ads.zzgzf
    /* JADX INFO: renamed from: zzbo, reason: merged with bridge method [inline-methods] */
    public MessageType zzbs() {
        if (!this.zza.zzcd()) {
            return this.zza;
        }
        this.zza.zzbU();
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    /* JADX INFO: renamed from: zzbp, reason: merged with bridge method [inline-methods] */
    public MessageType zzbt() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzgzf zzbq() {
        zzbg();
        return this;
    }

    protected final void zzbu() {
        if (this.zza.zzcd()) {
            return;
        }
        zzbv();
    }

    protected void zzbv() {
        MessageType messagetype = (MessageType) zza();
        zzb(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final boolean zzbw() {
        return zzgxv.zzk(this.zza, false);
    }
}
