package com.google.android.gms.internal.ads;

import com.json.cc;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfwz implements Map, Serializable {
    private transient zzfxb zza;
    private transient zzfxb zzb;
    private transient zzfwr zzc;

    zzfwz() {
    }

    public static zzfwz zzc(Map map) {
        Set setEntrySet = map.entrySet();
        zzfwy zzfwyVar = new zzfwy(setEntrySet instanceof Collection ? setEntrySet.size() : 4);
        zzfwyVar.zzb(setEntrySet);
        return zzfwyVar.zzc();
    }

    public static zzfwz zzd() {
        return zzfyn.zza;
    }

    public static zzfwz zze(Object obj, Object obj2) {
        zzfvt.zzb("dialog_not_shown_reason", obj2);
        return zzfyn.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return zzfxt.zzb(this, obj);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzfyy.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfvt.zza(size, ContentDisposition.Parameters.Size);
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append(cc.T);
            sb.append(entry.getValue());
            z = false;
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    abstract zzfwr zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzfwr values() {
        zzfwr zzfwrVar = this.zzc;
        if (zzfwrVar != null) {
            return zzfwrVar;
        }
        zzfwr zzfwrVarZza = zza();
        this.zzc = zzfwrVarZza;
        return zzfwrVarZza;
    }

    abstract zzfxb zzf();

    abstract zzfxb zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzfxb entrySet() {
        zzfxb zzfxbVar = this.zza;
        if (zzfxbVar != null) {
            return zzfxbVar;
        }
        zzfxb zzfxbVarZzf = zzf();
        this.zza = zzfxbVarZzf;
        return zzfxbVarZzf;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzfxb keySet() {
        zzfxb zzfxbVar = this.zzb;
        if (zzfxbVar != null) {
            return zzfxbVar;
        }
        zzfxb zzfxbVarZzg = zzg();
        this.zzb = zzfxbVarZzg;
        return zzfxbVarZzg;
    }
}
