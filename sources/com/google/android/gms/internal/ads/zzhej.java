package com.google.android.gms.internal.ads;

import com.json.b9;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public class zzhej implements Iterator, Closeable, zzaqx {
    private static final zzaqw zza = new zzhei("eof ");
    protected zzaqt zzb;
    protected zzhek zzc;
    zzaqw zzd = null;
    long zze = 0;
    long zzf = 0;
    private final List zzg = new ArrayList();

    static {
        zzheq.zzb(zzhej.class);
    }

    public void close() throws IOException {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzaqw zzaqwVar = this.zzd;
        if (zzaqwVar == zza) {
            return false;
        }
        if (zzaqwVar != null) {
            return true;
        }
        try {
            this.zzd = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzd = zza;
            return false;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(b9.i.d);
        int i = 0;
        while (true) {
            List list = this.zzg;
            if (i >= list.size()) {
                sb.append(b9.i.e);
                return sb.toString();
            }
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzaqw) list.get(i)).toString());
            i++;
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzaqw next() {
        zzaqw zzaqwVarZzb;
        zzaqw zzaqwVar = this.zzd;
        if (zzaqwVar != null && zzaqwVar != zza) {
            this.zzd = null;
            return zzaqwVar;
        }
        zzhek zzhekVar = this.zzc;
        if (zzhekVar == null || this.zze >= this.zzf) {
            this.zzd = zza;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzhekVar) {
                this.zzc.zze(this.zze);
                zzaqwVarZzb = this.zzb.zzb(this.zzc, this);
                this.zze = this.zzc.zzb();
            }
            return zzaqwVarZzb;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public final List zzd() {
        return (this.zzc == null || this.zzd == zza) ? this.zzg : new zzhep(this.zzg, this);
    }

    public final void zze(zzhek zzhekVar, long j, zzaqt zzaqtVar) throws IOException {
        this.zzc = zzhekVar;
        this.zze = zzhekVar.zzb();
        zzhekVar.zze(zzhekVar.zzb() + j);
        this.zzf = zzhekVar.zzb();
        this.zzb = zzaqtVar;
    }
}
