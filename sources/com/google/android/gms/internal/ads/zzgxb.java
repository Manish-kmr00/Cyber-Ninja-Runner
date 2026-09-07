package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgxb implements zzhba {
    private final zzgxa zza;

    private zzgxb(zzgxa zzgxaVar) {
        zzgyi.zzc(zzgxaVar, "output");
        this.zza = zzgxaVar;
        zzgxaVar.zze = this;
    }

    public static zzgxb zza(zzgxa zzgxaVar) {
        zzgxb zzgxbVar = zzgxaVar.zze;
        return zzgxbVar != null ? zzgxbVar : new zzgxb(zzgxaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzs(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzq(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzt(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzM(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzd(int i, zzgwn zzgwnVar) throws IOException {
        this.zza.zzN(i, zzgwnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzN(i, (zzgwn) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzq(int i, Object obj, zzgzz zzgzzVar) throws IOException {
        zzgxa zzgxaVar = this.zza;
        zzgxaVar.zzs(i, 3);
        zzgzzVar.zzj((zzgzg) obj, zzgxaVar.zze);
        zzgxaVar.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzv(int i, Object obj, zzgzz zzgzzVar) throws IOException {
        this.zza.zzn(i, (zzgzg) obj, zzgzzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzgwn) {
            this.zza.zzp(i, (zzgwn) obj);
        } else {
            this.zza.zzo(i, (zzgzg) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgys)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzgys zzgysVar = (zzgys) list;
        while (i2 < list.size()) {
            Object objZzc = zzgysVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzq(i, (String) objZzc);
            } else {
                this.zza.zzN(i, (zzgwn) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzgxa.zzD(((Integer) list.get(i3)).intValue());
            }
            zzgxaVar.zzu(iZzD);
            while (i2 < list.size()) {
                zzgxaVar.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxw zzgxwVar = (zzgxw) list;
        if (!z) {
            while (i2 < zzgxwVar.size()) {
                this.zza.zzt(i, zzgxwVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzgxwVar.size(); i4++) {
            iZzD2 += zzgxa.zzD(zzgxwVar.zzd(i4));
        }
        zzgxaVar2.zzu(iZzD2);
        while (i2 < zzgxwVar.size()) {
            zzgxaVar2.zzu(zzgxwVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgyv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxa.zzE(((Long) list.get(i3)).longValue());
            }
            zzgxaVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgxaVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyv zzgyvVar = (zzgyv) list;
        if (!z) {
            while (i2 < zzgyvVar.size()) {
                this.zza.zzv(i, zzgyvVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgyvVar.size(); i4++) {
            iZzE2 += zzgxa.zzE(zzgyvVar.zza(i4));
        }
        zzgxaVar2.zzu(iZzE2);
        while (i2 < zzgyvVar.size()) {
            zzgxaVar2.zzw(zzgyvVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzgxaVar.zzu(i3);
            while (i2 < list.size()) {
                zzgxaVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxw zzgxwVar = (zzgxw) list;
        if (!z) {
            while (i2 < zzgxwVar.size()) {
                this.zza.zzh(i, zzgxwVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxwVar.size(); i6++) {
            zzgxwVar.zzd(i6);
            i5 += 4;
        }
        zzgxaVar2.zzu(i5);
        while (i2 < zzgxwVar.size()) {
            zzgxaVar2.zzi(zzgxwVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgyv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzgxaVar.zzu(i3);
            while (i2 < list.size()) {
                zzgxaVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyv zzgyvVar = (zzgyv) list;
        if (!z) {
            while (i2 < zzgyvVar.size()) {
                this.zza.zzj(i, zzgyvVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyvVar.size(); i6++) {
            zzgyvVar.zza(i6);
            i5 += 8;
        }
        zzgxaVar2.zzu(i5);
        while (i2 < zzgyvVar.size()) {
            zzgxaVar2.zzk(zzgyvVar.zza(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgwd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzM(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzgxaVar.zzu(i3);
            while (i2 < list.size()) {
                zzgxaVar.zzL(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzgwd zzgwdVar = (zzgwd) list;
        if (!z) {
            while (i2 < zzgwdVar.size()) {
                this.zza.zzM(i, zzgwdVar.zzh(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgwdVar.size(); i6++) {
            zzgwdVar.zzh(i6);
            i5++;
        }
        zzgxaVar2.zzu(i5);
        while (i2 < zzgwdVar.size()) {
            zzgxaVar2.zzL(zzgwdVar.zzh(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxa.zzE(((Integer) list.get(i3)).intValue());
            }
            zzgxaVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgxaVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxw zzgxwVar = (zzgxw) list;
        if (!z) {
            while (i2 < zzgxwVar.size()) {
                this.zza.zzl(i, zzgxwVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgxwVar.size(); i4++) {
            iZzE2 += zzgxa.zzE(zzgxwVar.zzd(i4));
        }
        zzgxaVar2.zzu(iZzE2);
        while (i2 < zzgxwVar.size()) {
            zzgxaVar2.zzm(zzgxwVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgyv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzgxaVar.zzu(i3);
            while (i2 < list.size()) {
                zzgxaVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyv zzgyvVar = (zzgyv) list;
        if (!z) {
            while (i2 < zzgyvVar.size()) {
                this.zza.zzj(i, zzgyvVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyvVar.size(); i6++) {
            zzgyvVar.zza(i6);
            i5 += 8;
        }
        zzgxaVar2.zzu(i5);
        while (i2 < zzgyvVar.size()) {
            zzgxaVar2.zzk(zzgyvVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxc)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzgxaVar.zzu(i3);
            while (i2 < list.size()) {
                zzgxaVar.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzgxc zzgxcVar = (zzgxc) list;
        if (!z) {
            while (i2 < zzgxcVar.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzgxcVar.zzd(i2)));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxcVar.size(); i6++) {
            zzgxcVar.zzd(i6);
            i5 += 8;
        }
        zzgxaVar2.zzu(i5);
        while (i2 < zzgxcVar.size()) {
            zzgxaVar2.zzk(Double.doubleToRawLongBits(zzgxcVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxm)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzgxaVar.zzu(i3);
            while (i2 < list.size()) {
                zzgxaVar.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzgxm zzgxmVar = (zzgxm) list;
        if (!z) {
            while (i2 < zzgxmVar.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzgxmVar.zzd(i2)));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxmVar.size(); i6++) {
            zzgxmVar.zzd(i6);
            i5 += 4;
        }
        zzgxaVar2.zzu(i5);
        while (i2 < zzgxmVar.size()) {
            zzgxaVar2.zzi(Float.floatToRawIntBits(zzgxmVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzgxaVar.zzu(i3);
            while (i2 < list.size()) {
                zzgxaVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxw zzgxwVar = (zzgxw) list;
        if (!z) {
            while (i2 < zzgxwVar.size()) {
                this.zza.zzh(i, zzgxwVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxwVar.size(); i6++) {
            zzgxwVar.zzd(i6);
            i5 += 4;
        }
        zzgxaVar2.zzu(i5);
        while (i2 < zzgxwVar.size()) {
            zzgxaVar2.zzi(zzgxwVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxw)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgxa zzgxaVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzgxaVar.zzt(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar2 = this.zza;
            zzgxaVar2.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzD += zzgxa.zzD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzgxaVar2.zzu(iZzD);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzgxaVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzgxw zzgxwVar = (zzgxw) list;
        if (!z) {
            while (i2 < zzgxwVar.size()) {
                zzgxa zzgxaVar3 = this.zza;
                int iZzd = zzgxwVar.zzd(i2);
                zzgxaVar3.zzt(i, (iZzd >> 31) ^ (iZzd + iZzd));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar4 = this.zza;
        zzgxaVar4.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzgxwVar.size(); i4++) {
            int iZzd2 = zzgxwVar.zzd(i4);
            iZzD2 += zzgxa.zzD((iZzd2 >> 31) ^ (iZzd2 + iZzd2));
        }
        zzgxaVar4.zzu(iZzD2);
        while (i2 < zzgxwVar.size()) {
            int iZzd3 = zzgxwVar.zzd(i2);
            zzgxaVar4.zzu((iZzd3 >> 31) ^ (iZzd3 + iZzd3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgyv)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgxa zzgxaVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzgxaVar.zzv(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar2 = this.zza;
            zzgxaVar2.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzE += zzgxa.zzE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzgxaVar2.zzu(iZzE);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzgxaVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzgyv zzgyvVar = (zzgyv) list;
        if (!z) {
            while (i2 < zzgyvVar.size()) {
                zzgxa zzgxaVar3 = this.zza;
                long jZza = zzgyvVar.zza(i2);
                zzgxaVar3.zzv(i, (jZza >> 63) ^ (jZza + jZza));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar4 = this.zza;
        zzgxaVar4.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgyvVar.size(); i4++) {
            long jZza2 = zzgyvVar.zza(i4);
            iZzE2 += zzgxa.zzE((jZza2 >> 63) ^ (jZza2 + jZza2));
        }
        zzgxaVar4.zzu(iZzE2);
        while (i2 < zzgyvVar.size()) {
            long jZza3 = zzgyvVar.zza(i2);
            zzgxaVar4.zzw((jZza3 >> 63) ^ (jZza3 + jZza3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxa.zzE(((Integer) list.get(i3)).intValue());
            }
            zzgxaVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgxaVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxw zzgxwVar = (zzgxw) list;
        if (!z) {
            while (i2 < zzgxwVar.size()) {
                this.zza.zzl(i, zzgxwVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgxwVar.size(); i4++) {
            iZzE2 += zzgxa.zzE(zzgxwVar.zzd(i4));
        }
        zzgxaVar2.zzu(iZzE2);
        while (i2 < zzgxwVar.size()) {
            zzgxaVar2.zzm(zzgxwVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhba
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgyv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgxa zzgxaVar = this.zza;
            zzgxaVar.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxa.zzE(((Long) list.get(i3)).longValue());
            }
            zzgxaVar.zzu(iZzE);
            while (i2 < list.size()) {
                zzgxaVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyv zzgyvVar = (zzgyv) list;
        if (!z) {
            while (i2 < zzgyvVar.size()) {
                this.zza.zzv(i, zzgyvVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgxa zzgxaVar2 = this.zza;
        zzgxaVar2.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgyvVar.size(); i4++) {
            iZzE2 += zzgxa.zzE(zzgyvVar.zza(i4));
        }
        zzgxaVar2.zzu(iZzE2);
        while (i2 < zzgyvVar.size()) {
            zzgxaVar2.zzw(zzgyvVar.zza(i2));
            i2++;
        }
    }
}
