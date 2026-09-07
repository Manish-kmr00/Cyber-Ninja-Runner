package com.google.android.gms.internal.measurement;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkx<T> implements zzll<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmg.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzkt zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlb zzn;
    private final zzkd zzo;
    private final zzmf<?, ?> zzp;
    private final zziz<?> zzq;
    private final zzkm zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzmg.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzmg.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzmn zzmnVar, Class<?> cls, zzhv zzhvVar) throws IOException {
        switch (zzkw.zza[zzmnVar.ordinal()]) {
            case 1:
                int iZzd = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Boolean.valueOf(zzhvVar.zzb != 0);
                return iZzd;
            case 2:
                return zzhw.zza(bArr, i, zzhvVar);
            case 3:
                zzhvVar.zzc = Double.valueOf(zzhw.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzhvVar.zzc = Integer.valueOf(zzhw.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzhvVar.zzc = Long.valueOf(zzhw.zzd(bArr, i));
                return i + 8;
            case 8:
                zzhvVar.zzc = Float.valueOf(zzhw.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzhw.zzc(bArr, i, zzhvVar);
                zzhvVar.zzc = Integer.valueOf(zzhvVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Long.valueOf(zzhvVar.zzb);
                return iZzd2;
            case 14:
                return zzhw.zza(zzlh.zza().zza((Class) cls), bArr, i, i2, zzhvVar);
            case 15:
                int iZzc2 = zzhw.zzc(bArr, i, zzhvVar);
                zzhvVar.zzc = Integer.valueOf(zzio.zze(zzhvVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Long.valueOf(zzio.zza(zzhvVar.zzb));
                return iZzd3;
            case 17:
                return zzhw.zzb(bArr, i, zzhvVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v243 */
    /* JADX WARN: Type inference failed for: r0v245 */
    /* JADX WARN: Type inference failed for: r0v246 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.google.android.gms.internal.measurement.zzlm, com.google.android.gms.internal.measurement.zzlm<T extends com.google.android.gms.internal.measurement.zzjf<T>, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zza(T t) {
        int i;
        ?? r16;
        ?? r5;
        ?? r15;
        int iZza;
        int iZzb;
        int iZzd;
        int iZzd2;
        int iZzi;
        int iZzj;
        ?? r1;
        Unsafe unsafe = zzb;
        ?? r9 = 0;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int iZzh = 0;
        int i4 = 1048575;
        while (i3 < this.zzc.length) {
            int iZzc = zzc(i3);
            int i5 = (267386880 & iZzc) >>> 20;
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (i5 <= 17) {
                if (i8 != i4) {
                    r1 = i8 == i2 ? r9 : unsafe.getInt(t, i8);
                    i4 = i8;
                }
                i = i4;
                r16 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i4;
                r16 = r2 == true ? 1 : 0;
                r5 = r9;
            }
            long j = iZzc & i2;
            if (i5 >= zzje.DOUBLE_LIST_PACKED.zza()) {
                zzje.SINT64_LIST_PACKED.zza();
            }
            ?? r17 = r5;
            switch (i5) {
                case 0:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzit.zza(i6, 0.0d);
                        r15 = r15;
                        iZzh += iZza;
                    }
                    break;
                case 1:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzit.zza(i6, 0.0f);
                        r15 = r15;
                        iZzh += iZza;
                    }
                    break;
                case 2:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzit.zzd(i6, unsafe.getLong(t, j));
                        r15 = r15;
                        iZzh += iZza;
                    }
                    break;
                case 3:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzit.zzg(i6, unsafe.getLong(t, j));
                        r15 = r15;
                        iZzh += iZza;
                    }
                    break;
                case 4:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzit.zzg(i6, unsafe.getInt(t, j));
                        r15 = r15;
                        iZzh += iZza;
                    }
                    break;
                case 5:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzit.zzc(i6, 0L);
                        r15 = r15;
                        iZzh += iZza;
                    }
                    break;
                case 6:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        r15 = 0;
                        iZza = zzit.zzf(i6, 0);
                        iZzh += iZza;
                    } else {
                        r15 = 0;
                    }
                    break;
                case 7:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zzb(i6, true);
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 8:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzia) {
                            iZzb = zzit.zzc(i6, (zzia) object);
                        } else {
                            iZzb = zzit.zzb(i6, (String) object);
                        }
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 9:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzln.zza(i6, unsafe.getObject(t, j), zze(i3));
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 10:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zzc(i6, (zzia) unsafe.getObject(t, j));
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 11:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zzj(i6, unsafe.getInt(t, j));
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 12:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zze(i6, unsafe.getInt(t, j));
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 13:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzh += zzit.zzh(i6, 0);
                    }
                    r15 = 0;
                    break;
                case 14:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zze(i6, 0L);
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 15:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zzi(i6, unsafe.getInt(t, j));
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 16:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zzf(i6, unsafe.getLong(t, j));
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 17:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzb = zzit.zzb(i6, (zzkt) unsafe.getObject(t, j), zze(i3));
                        iZzh += iZzb;
                    }
                    r15 = 0;
                    break;
                case 18:
                    iZzd = zzln.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 19:
                    iZzd = zzln.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 20:
                    iZzd = zzln.zzf(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 21:
                    iZzd = zzln.zzj(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 22:
                    iZzd = zzln.zze(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 23:
                    iZzd = zzln.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 24:
                    iZzd = zzln.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 25:
                    iZzd = zzln.zza(i6, (List<?>) unsafe.getObject(t, j), (boolean) r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 26:
                    iZzd = zzln.zzb(i6, (List) unsafe.getObject(t, j));
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 27:
                    iZzd = zzln.zzb(i6, (List<?>) unsafe.getObject(t, j), zze(i3));
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 28:
                    iZzd = zzln.zza(i6, (List<zzia>) unsafe.getObject(t, j));
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 29:
                    iZzd = zzln.zzi(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 30:
                    iZzd = zzln.zzb(i6, (List<Integer>) unsafe.getObject(t, j), (boolean) r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 31:
                    iZzd = zzln.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 32:
                    iZzd = zzln.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 33:
                    iZzd = zzln.zzg(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 34:
                    iZzd = zzln.zzh(i6, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 35:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 36:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 37:
                    iZzd2 = zzln.zzf((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 38:
                    iZzd2 = zzln.zzj((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 39:
                    iZzd2 = zzln.zze((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 40:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 41:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 42:
                    iZzd2 = zzln.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 43:
                    iZzd2 = zzln.zzi((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 44:
                    iZzd2 = zzln.zzb((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 45:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 46:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 47:
                    iZzd2 = zzln.zzg((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 48:
                    iZzd2 = zzln.zzh((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i6);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 49:
                    iZzd = zzln.zza(i6, (List<zzkt>) unsafe.getObject(t, j), zze(i3));
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 50:
                    iZzd = this.zzr.zza(i6, unsafe.getObject(t, j), zzf(i3));
                    iZzh += iZzd;
                    r15 = r9;
                    break;
                case 51:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zza(i6, 0.0d);
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 52:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zza(i6, 0.0f);
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 53:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzd(i6, zzd(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 54:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzg(i6, zzd(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 55:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzg(i6, zzc(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 56:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzc(i6, 0L);
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 57:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzf(i6, (int) r9);
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzb(i6, true);
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzc(t, i6, i3)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzia) {
                            iZzd = zzit.zzc(i6, (zzia) object2);
                        } else {
                            iZzd = zzit.zzb(i6, (String) object2);
                        }
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 60:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzln.zza(i6, unsafe.getObject(t, j), zze(i3));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 61:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzc(i6, (zzia) unsafe.getObject(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 62:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzj(i6, zzc(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 63:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zze(i6, zzc(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 64:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzh(i6, (int) r9);
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 65:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zze(i6, 0L);
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 66:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzi(i6, zzc(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case 67:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzf(i6, zzd(t, j));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzit.zzb(i6, (zzkt) unsafe.getObject(t, j), zze(i3));
                        iZzh += iZzd;
                    }
                    r15 = r9;
                    break;
                default:
                    r15 = r9;
                    break;
            }
            i3 += 3;
            i4 = i;
            r9 = r15;
            r2 = r16;
            i2 = 1048575;
        }
        ?? r18 = r9;
        zzmf<?, ?> zzmfVar = this.zzp;
        int iZza2 = iZzh + zzmfVar.zza(zzmfVar.zzd(t));
        if (!this.zzh) {
            return iZza2;
        }
        zzjd zzjdVarZza = this.zzq.zza(t);
        ?? r10 = r18;
        ?? Zza = r18;
        while (r10 < zzjdVarZza.zza.zza()) {
            Map.Entry entryZza = zzjdVarZza.zza.zza(r10);
            r10++;
            Zza += zzjd.zza((zzjf<?>) entryZza.getKey(), entryZza.getValue());
        }
        ?? Zza2 = Zza;
        for (Map.Entry entry : zzjdVarZza.zza.zzb()) {
            Zza2 += zzjd.zza((zzjf<?>) entry.getKey(), entry.getValue());
        }
        return iZza2 + Zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            int iHashCode = 37;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjm.zza(Double.doubleToLongBits(zzmg.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzmg.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzmg.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzmg.zze(t, j);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzmg.zze(t, j);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 53:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 55:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzmg.zze(t, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 60:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 61:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 62:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 63:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 65:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 66:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 67:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzq.zza(t).hashCode() : iHashCode2;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzmg.zze(t, j)).intValue();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 35181. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zza(T r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.measurement.zzhv r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzhv):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzmg.zze(t, j)).longValue();
    }

    private final zzjo zzd(int i) {
        return (zzjo) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0259  */
    /* JADX WARN: Code duplicated, block: B:125:0x025c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0273  */
    /* JADX WARN: Code duplicated, block: B:129:0x0276  */
    static <T> zzkx<T> zza(Class<T> cls, zzkr zzkrVar, zzlb zzlbVar, zzkd zzkdVar, zzmf<?, ?> zzmfVar, zziz<?> zzizVar, zzkm zzkmVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        zzlj zzljVar;
        boolean z;
        int iObjectFieldOffset;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        int i20;
        Field fieldZza;
        int i21;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        Object obj;
        Field fieldZza2;
        int i25;
        Object obj2;
        Field fieldZza3;
        int i26;
        char cCharAt10;
        int i27;
        char cCharAt11;
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        if (zzkrVar instanceof zzlj) {
            zzlj zzljVar2 = (zzlj) zzkrVar;
            String strZzd = zzljVar2.zzd();
            int length = strZzd.length();
            char c = 55296;
            if (strZzd.charAt(0) >= 55296) {
                int i30 = 1;
                while (true) {
                    i = i30 + 1;
                    if (strZzd.charAt(i30) < 55296) {
                        break;
                    }
                    i30 = i;
                }
            } else {
                i = 1;
            }
            int i31 = i + 1;
            int iCharAt3 = strZzd.charAt(i);
            if (iCharAt3 >= 55296) {
                int i32 = iCharAt3 & 8191;
                int i33 = 13;
                while (true) {
                    i29 = i31 + 1;
                    cCharAt13 = strZzd.charAt(i31);
                    if (cCharAt13 < 55296) {
                        break;
                    }
                    i32 |= (cCharAt13 & 8191) << i33;
                    i33 += 13;
                    i31 = i29;
                }
                iCharAt3 = i32 | (cCharAt13 << i33);
                i31 = i29;
            }
            if (iCharAt3 == 0) {
                iCharAt = 0;
                iCharAt2 = 0;
                i5 = 0;
                i6 = 0;
                i2 = 0;
                i4 = 0;
                iArr = zza;
                i3 = 0;
            } else {
                int i34 = i31 + 1;
                int iCharAt4 = strZzd.charAt(i31);
                if (iCharAt4 >= 55296) {
                    int i35 = iCharAt4 & 8191;
                    int i36 = 13;
                    while (true) {
                        i14 = i34 + 1;
                        cCharAt8 = strZzd.charAt(i34);
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i35 |= (cCharAt8 & 8191) << i36;
                        i36 += 13;
                        i34 = i14;
                    }
                    iCharAt4 = i35 | (cCharAt8 << i36);
                    i34 = i14;
                }
                int i37 = i34 + 1;
                int iCharAt5 = strZzd.charAt(i34);
                if (iCharAt5 >= 55296) {
                    int i38 = iCharAt5 & 8191;
                    int i39 = 13;
                    while (true) {
                        i13 = i37 + 1;
                        cCharAt7 = strZzd.charAt(i37);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i38 |= (cCharAt7 & 8191) << i39;
                        i39 += 13;
                        i37 = i13;
                    }
                    iCharAt5 = i38 | (cCharAt7 << i39);
                    i37 = i13;
                }
                int i40 = i37 + 1;
                int iCharAt6 = strZzd.charAt(i37);
                if (iCharAt6 >= 55296) {
                    int i41 = iCharAt6 & 8191;
                    int i42 = 13;
                    while (true) {
                        i12 = i40 + 1;
                        cCharAt6 = strZzd.charAt(i40);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i41 |= (cCharAt6 & 8191) << i42;
                        i42 += 13;
                        i40 = i12;
                    }
                    iCharAt6 = i41 | (cCharAt6 << i42);
                    i40 = i12;
                }
                int i43 = i40 + 1;
                int iCharAt7 = strZzd.charAt(i40);
                if (iCharAt7 >= 55296) {
                    int i44 = iCharAt7 & 8191;
                    int i45 = 13;
                    while (true) {
                        i11 = i43 + 1;
                        cCharAt5 = strZzd.charAt(i43);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i44 |= (cCharAt5 & 8191) << i45;
                        i45 += 13;
                        i43 = i11;
                    }
                    iCharAt7 = i44 | (cCharAt5 << i45);
                    i43 = i11;
                }
                int i46 = i43 + 1;
                iCharAt = strZzd.charAt(i43);
                if (iCharAt >= 55296) {
                    int i47 = iCharAt & 8191;
                    int i48 = 13;
                    while (true) {
                        i10 = i46 + 1;
                        cCharAt4 = strZzd.charAt(i46);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i47 |= (cCharAt4 & 8191) << i48;
                        i48 += 13;
                        i46 = i10;
                    }
                    iCharAt = i47 | (cCharAt4 << i48);
                    i46 = i10;
                }
                int i49 = i46 + 1;
                iCharAt2 = strZzd.charAt(i46);
                if (iCharAt2 >= 55296) {
                    int i50 = iCharAt2 & 8191;
                    int i51 = 13;
                    while (true) {
                        i9 = i49 + 1;
                        cCharAt3 = strZzd.charAt(i49);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i50 |= (cCharAt3 & 8191) << i51;
                        i51 += 13;
                        i49 = i9;
                    }
                    iCharAt2 = i50 | (cCharAt3 << i51);
                    i49 = i9;
                }
                int i52 = i49 + 1;
                int iCharAt8 = strZzd.charAt(i49);
                if (iCharAt8 >= 55296) {
                    int i53 = iCharAt8 & 8191;
                    int i54 = 13;
                    while (true) {
                        i8 = i52 + 1;
                        cCharAt2 = strZzd.charAt(i52);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i53 |= (cCharAt2 & 8191) << i54;
                        i54 += 13;
                        i52 = i8;
                    }
                    iCharAt8 = i53 | (cCharAt2 << i54);
                    i52 = i8;
                }
                int i55 = i52 + 1;
                int iCharAt9 = strZzd.charAt(i52);
                if (iCharAt9 >= 55296) {
                    int i56 = iCharAt9 & 8191;
                    int i57 = 13;
                    while (true) {
                        i7 = i55 + 1;
                        cCharAt = strZzd.charAt(i55);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i56 |= (cCharAt & 8191) << i57;
                        i57 += 13;
                        i55 = i7;
                    }
                    iCharAt9 = i56 | (cCharAt << i57);
                    i55 = i7;
                }
                i2 = (iCharAt4 << 1) + iCharAt5;
                i3 = iCharAt4;
                iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
                i4 = iCharAt9;
                i31 = i55;
                i5 = iCharAt6;
                i6 = iCharAt7;
            }
            Unsafe unsafe = zzb;
            Object[] objArrZze = zzljVar2.zze();
            Class<?> cls2 = zzljVar2.zza().getClass();
            int[] iArr2 = new int[iCharAt * 3];
            Object[] objArr = new Object[iCharAt << 1];
            int i58 = i4 + iCharAt2;
            int i59 = i4;
            int i60 = i58;
            int i61 = 0;
            int i62 = 0;
            while (i31 < length) {
                int i63 = i31 + 1;
                int iCharAt10 = strZzd.charAt(i31);
                if (iCharAt10 >= c) {
                    int i64 = iCharAt10 & 8191;
                    int i65 = i63;
                    int i66 = 13;
                    while (true) {
                        i28 = i65 + 1;
                        cCharAt12 = strZzd.charAt(i65);
                        if (cCharAt12 < c) {
                            break;
                        }
                        i64 |= (cCharAt12 & 8191) << i66;
                        i66 += 13;
                        i65 = i28;
                    }
                    iCharAt10 = i64 | (cCharAt12 << i66);
                    i15 = i28;
                } else {
                    i15 = i63;
                }
                int i67 = i15 + 1;
                int iCharAt11 = strZzd.charAt(i15);
                if (iCharAt11 >= c) {
                    int i68 = iCharAt11 & 8191;
                    int i69 = i67;
                    int i70 = 13;
                    while (true) {
                        i27 = i69 + 1;
                        cCharAt11 = strZzd.charAt(i69);
                        if (cCharAt11 < c) {
                            break;
                        }
                        i68 |= (cCharAt11 & 8191) << i70;
                        i70 += 13;
                        i69 = i27;
                    }
                    iCharAt11 = i68 | (cCharAt11 << i70);
                    i16 = i27;
                } else {
                    i16 = i67;
                }
                int i71 = iCharAt11 & 255;
                int i72 = length;
                if ((iCharAt11 & 1024) != 0) {
                    iArr[i62] = i61;
                    i62++;
                }
                int i73 = i6;
                if (i71 >= 51) {
                    int i74 = i16 + 1;
                    int iCharAt12 = strZzd.charAt(i16);
                    char c2 = 55296;
                    if (iCharAt12 >= 55296) {
                        int i75 = iCharAt12 & 8191;
                        int i76 = 13;
                        while (true) {
                            i26 = i74 + 1;
                            cCharAt10 = strZzd.charAt(i74);
                            if (cCharAt10 < c2) {
                                break;
                            }
                            i75 |= (cCharAt10 & 8191) << i76;
                            i76 += 13;
                            i74 = i26;
                            c2 = 55296;
                        }
                        iCharAt12 = i75 | (cCharAt10 << i76);
                        i74 = i26;
                    }
                    int i77 = i71 - 51;
                    int i78 = i74;
                    if (i77 == 9 || i77 == 17) {
                        i23 = i2 + 1;
                        objArr[((i61 / 3) << 1) + 1] = objArrZze[i2];
                    } else {
                        if (i77 == 12 && (zzljVar2.zzb().equals(zzle.PROTO2) || (iCharAt11 & 2048) != 0)) {
                            i23 = i2 + 1;
                            objArr[((i61 / 3) << 1) + 1] = objArrZze[i2];
                        }
                        i24 = iCharAt12 << 1;
                        obj = objArrZze[i24];
                        if (obj instanceof Field) {
                            fieldZza2 = (Field) obj;
                        } else {
                            fieldZza2 = zza(cls2, (String) obj);
                            objArrZze[i24] = fieldZza2;
                        }
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza2);
                        i25 = i24 + 1;
                        obj2 = objArrZze[i25];
                        if (obj2 instanceof Field) {
                            fieldZza3 = (Field) obj2;
                        } else {
                            fieldZza3 = zza(cls2, (String) obj2);
                            objArrZze[i25] = fieldZza3;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza3);
                        zzljVar = zzljVar2;
                        strZzd = strZzd;
                        i17 = i2;
                        i18 = i78;
                        i20 = 0;
                        z = true;
                    }
                    i2 = i23;
                    i24 = iCharAt12 << 1;
                    obj = objArrZze[i24];
                    if (obj instanceof Field) {
                        fieldZza2 = (Field) obj;
                    } else {
                        fieldZza2 = zza(cls2, (String) obj);
                        objArrZze[i24] = fieldZza2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza2);
                    i25 = i24 + 1;
                    obj2 = objArrZze[i25];
                    if (obj2 instanceof Field) {
                        fieldZza3 = (Field) obj2;
                    } else {
                        fieldZza3 = zza(cls2, (String) obj2);
                        objArrZze[i25] = fieldZza3;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza3);
                    zzljVar = zzljVar2;
                    strZzd = strZzd;
                    i17 = i2;
                    i18 = i78;
                    i20 = 0;
                    z = true;
                } else {
                    i17 = i2 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZze[i2]);
                    if (i71 == 9 || i71 == 17) {
                        zzljVar = zzljVar2;
                        objArr[((i61 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i71 == 27 || i71 == 49) {
                            zzljVar = zzljVar2;
                            i22 = i2 + 2;
                            objArr[((i61 / 3) << 1) + 1] = objArrZze[i17];
                        } else if (i71 == 12 || i71 == 30 || i71 == 44) {
                            zzljVar = zzljVar2;
                            if (zzljVar2.zzb() == zzle.PROTO2 || (iCharAt11 & 2048) != 0) {
                                i22 = i2 + 2;
                                objArr[((i61 / 3) << 1) + 1] = objArrZze[i17];
                            }
                        } else if (i71 == 50) {
                            int i79 = i59 + 1;
                            iArr[i59] = i61;
                            int i80 = (i61 / 3) << 1;
                            int i81 = i2 + 2;
                            objArr[i80] = objArrZze[i17];
                            if ((iCharAt11 & 2048) != 0) {
                                i17 = i2 + 3;
                                objArr[i80 + 1] = objArrZze[i81];
                                zzljVar = zzljVar2;
                                i59 = i79;
                            } else {
                                i59 = i79;
                                i17 = i81;
                                zzljVar = zzljVar2;
                            }
                        } else {
                            zzljVar = zzljVar2;
                        }
                        i17 = i22;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((iCharAt11 & 4096) == 0 || i71 > 17) {
                        z = true;
                        iObjectFieldOffset = 1048575;
                        i18 = i16;
                        i19 = 0;
                    } else {
                        i18 = i16 + 1;
                        int iCharAt13 = strZzd.charAt(i16);
                        if (iCharAt13 >= 55296) {
                            int i82 = iCharAt13 & 8191;
                            int i83 = 13;
                            while (true) {
                                i21 = i18 + 1;
                                cCharAt9 = strZzd.charAt(i18);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i82 |= (cCharAt9 & 8191) << i83;
                                i83 += 13;
                                i18 = i21;
                            }
                            iCharAt13 = i82 | (cCharAt9 << i83);
                            i18 = i21;
                        }
                        z = true;
                        int i84 = (i3 << 1) + (iCharAt13 / 32);
                        Object obj3 = objArrZze[i84];
                        if (obj3 instanceof Field) {
                            fieldZza = (Field) obj3;
                        } else {
                            fieldZza = zza(cls2, (String) obj3);
                            objArrZze[i84] = fieldZza;
                        }
                        i19 = iCharAt13 % 32;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza);
                    }
                    if (i71 >= 18 && i71 <= 49) {
                        iArr[i60] = iObjectFieldOffset3;
                        i60++;
                    }
                    int i85 = i19;
                    iObjectFieldOffset2 = iObjectFieldOffset3;
                    i20 = i85;
                }
                int i86 = i61 + 1;
                iArr2[i61] = iCharAt10;
                int i87 = i61 + 2;
                int i88 = i3;
                iArr2[i86] = (i71 << 20) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | iObjectFieldOffset2;
                i61 += 3;
                iArr2[i87] = (i20 << 20) | iObjectFieldOffset;
                i31 = i18;
                i2 = i17;
                length = i72;
                zzljVar2 = zzljVar;
                strZzd = strZzd;
                i6 = i73;
                i3 = i88;
                i5 = i5;
                c = 55296;
            }
            zzlj zzljVar3 = zzljVar2;
            return new zzkx<>(iArr2, objArr, i5, i6, zzljVar3.zza(), zzljVar3.zzb(), false, iArr, i4, i58, zzlbVar, zzkdVar, zzmfVar, zzizVar, zzkmVar);
        }
        throw new NoSuchMethodError();
    }

    private final zzll zze(int i) {
        int i2 = (i / 3) << 1;
        zzll zzllVar = (zzll) this.zzd[i2];
        if (zzllVar != null) {
            return zzllVar;
        }
        zzll<T> zzllVarZza = zzlh.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzllVarZza;
        return zzllVarZza;
    }

    private static zzme zze(Object obj) {
        zzjk zzjkVar = (zzjk) obj;
        zzme zzmeVar = zzjkVar.zzb;
        if (zzmeVar != zzme.zzc()) {
            return zzmeVar;
        }
        zzme zzmeVarZzd = zzme.zzd();
        zzjkVar.zzb = zzmeVarZzd;
        return zzmeVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmf<UT, UB> zzmfVar, Object obj2) {
        zzjo zzjoVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzmg.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzjoVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzjoVarZzd, ub, zzmfVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjo zzjoVar, UB ub, zzmf<UT, UB> zzmfVar, Object obj) {
        zzkk<?, ?> zzkkVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzjoVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmfVar.zzc(obj);
                }
                zzif zzifVarZzc = zzia.zzc(zzkl.zza(zzkkVarZza, next.getKey(), next.getValue()));
                try {
                    zzkl.zza(zzifVarZzc.zzb(), zzkkVarZza, next.getKey(), next.getValue());
                    zzmfVar.zza(ub, i2, zzifVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzll zzllVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc((Object) t, i)) {
            return zzllVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzllVarZze.zza();
        if (object != null) {
            zzllVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzll zzllVarZze = zze(i2);
        if (!zzc(t, i, i2)) {
            return zzllVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzllVarZze.zza();
        if (object != null) {
            zzllVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private zzkx(int[] iArr, Object[] objArr, int i, int i2, zzkt zzktVar, zzle zzleVar, boolean z, int[] iArr2, int i3, int i4, zzlb zzlbVar, zzkd zzkdVar, zzmf<?, ?> zzmfVar, zziz<?> zzizVar, zzkm zzkmVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzktVar instanceof zzjk;
        this.zzh = zzizVar != null && zzizVar.zza(zzktVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzlbVar;
        this.zzo = zzkdVar;
        this.zzp = zzmfVar;
        this.zzq = zzizVar;
        this.zzg = zzktVar;
        this.zzr = zzkmVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzc(T t) {
        if (zzg(t)) {
            if (t instanceof zzjk) {
                zzjk zzjkVar = (zzjk) t;
                zzjkVar.zzc(Integer.MAX_VALUE);
                zzjkVar.zza = 0;
                zzjkVar.zzcl();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzc = zzc(i);
                long j = 1048575 & iZzc;
                int i2 = (iZzc & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 != 60 && i2 != 68) {
                        switch (i2) {
                            case 17:
                                if (zzc((Object) t, i)) {
                                    zze(i).zzc(zzb.getObject(t, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzo.zzb(t, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzr.zzc(object));
                                }
                                break;
                        }
                    } else if (zzc(t, this.zzc[i], i)) {
                        zze(i).zzc(zzb.getObject(t, j));
                    }
                } else if (zzc((Object) t, i)) {
                    zze(i).zzc(zzb.getObject(t, j));
                }
            }
            this.zzp.zzf(t);
            if (this.zzh) {
                this.zzq.zzc(t);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza(t, j, zzmg.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zzc((Object) t2, i)) {
                        zzmg.zzc(t, j, zzmg.zzh(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zzc((Object) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzln.zza(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzc(t2, i2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzc(t2, i2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzln.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzln.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:165:0x0620 A[Catch: all -> 0x0295, TryCatch #1 {all -> 0x0295, blocks: (B:153:0x05f4, B:163:0x061b, B:165:0x0620, B:166:0x0625, B:49:0x00c9, B:50:0x00db, B:51:0x00ed, B:52:0x00ff, B:53:0x0110, B:54:0x0121, B:56:0x012b, B:59:0x0132, B:60:0x0139, B:61:0x0146, B:62:0x0157, B:63:0x0164, B:64:0x0175, B:66:0x0180, B:67:0x0191, B:68:0x01a2, B:69:0x01b3, B:70:0x01c4, B:71:0x01d5, B:72:0x01e6, B:73:0x01f7, B:74:0x0209, B:76:0x0219, B:80:0x023a, B:77:0x0223, B:79:0x022b, B:81:0x024b, B:82:0x025d, B:83:0x026b, B:84:0x0279, B:85:0x0287), top: B:189:0x05f4 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0631 A[LOOP:3: B:169:0x062d->B:171:0x0631, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x0645  */
    /* JADX WARN: Code duplicated, block: B:183:0x0657 A[LOOP:2: B:181:0x0653->B:183:0x0657, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:185:0x066b  */
    /* JADX WARN: Code duplicated, block: B:208:0x062b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzli] */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, zzli zzliVar, zzix zzixVar) throws Throwable {
        zzmf zzmfVar;
        int i;
        zzmf zzmfVar2;
        T t2;
        Object obj;
        zziz<?> zzizVar;
        zzix zzixVar2;
        Object obj2;
        int i2;
        T t3 = t;
        zzix zzixVar3 = zzixVar;
        zzixVar.getClass();
        zzf(t);
        zzmf zzmfVar3 = this.zzp;
        zziz<?> zzizVar2 = this.zzq;
        Object objZza = null;
        zzjd zzjdVarZzb = null;
        while (true) {
            try {
                int iZzc = zzliVar.zzc();
                int iZza = zza(iZzc);
                if (iZza < 0) {
                    if (iZzc == Integer.MAX_VALUE) {
                        for (int i3 = this.zzl; i3 < this.zzm; i3++) {
                            objZza = zza(t, this.zzk[i3], objZza, (zzmf<UT, Object>) zzmfVar3, t);
                        }
                        if (objZza != null) {
                            zzmfVar3.zzb(t3, objZza);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objZza2 = !this.zzh ? null : zzizVar2.zza(zzixVar3, this.zzg, iZzc);
                        if (objZza2 != null) {
                            if (zzjdVarZzb == null) {
                                zzjdVarZzb = zzizVar2.zzb(t3);
                            }
                            zzjd zzjdVar = zzjdVarZzb;
                            zzmfVar2 = zzmfVar3;
                            t2 = t3;
                            try {
                                objZza = zzizVar2.zza(t, zzliVar, objZza2, zzixVar, zzjdVar, objZza, zzmfVar2);
                                zzjdVarZzb = zzjdVar;
                            } catch (Throwable th) {
                                th = th;
                                t3 = t2;
                                zzmfVar = zzmfVar2;
                                while (i < this.zzm) {
                                    objZza = zza(t, this.zzk[i], objZza, (zzmf<UT, Object>) zzmfVar, t);
                                }
                                if (objZza != null) {
                                    zzmfVar.zzb(t3, objZza);
                                }
                                throw th;
                            }
                        } else {
                            zzmfVar2 = zzmfVar3;
                            t2 = t3;
                            zzmfVar2.zza((zzli) zzliVar);
                            if (objZza == null) {
                                objZza = zzmfVar2.zzc(t2);
                            }
                            zzjdVarZzb = zzjdVarZzb;
                            if (!zzmfVar2.zza(objZza, (zzli) zzliVar)) {
                                int i4 = this.zzl;
                                while (i4 < this.zzm) {
                                    zzmf zzmfVar4 = zzmfVar2;
                                    objZza = zza(t, this.zzk[i4], objZza, (zzmf<UT, Object>) zzmfVar4, t);
                                    i4++;
                                    t2 = t2;
                                    zzmfVar2 = zzmfVar4;
                                }
                                T t4 = t2;
                                zzmf zzmfVar5 = zzmfVar2;
                                if (objZza != null) {
                                    zzmfVar5.zzb(t4, objZza);
                                    return;
                                }
                                return;
                            }
                        }
                        t3 = t2;
                        zzmfVar3 = zzmfVar2;
                    } catch (Throwable th2) {
                        th = th2;
                        zzmfVar = zzmfVar3;
                        t3 = t3;
                        while (i < this.zzm) {
                            objZza = zza(t, this.zzk[i], objZza, (zzmf<UT, Object>) zzmfVar, t);
                        }
                        if (objZza != null) {
                            zzmfVar.zzb(t3, objZza);
                        }
                        throw th;
                    }
                } else {
                    zzmfVar = zzmfVar3;
                    t3 = t3;
                    try {
                        int iZzc2 = zzc(iZza);
                        switch ((267386880 & iZzc2) >>> 20) {
                            case 0:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza(t3, iZzc2 & 1048575, zzliVar.zza());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 1:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzb());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 2:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzl());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 3:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzo());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 4:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzg());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 5:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzk());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 6:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzf());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 7:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zzc(t3, iZzc2 & 1048575, zzliVar.zzs());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 8:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zza((Object) t3, iZzc2, (zzli) zzliVar);
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 9:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzkt zzktVar = (zzkt) zza((Object) t3, iZza);
                                zzliVar.zzb(zzktVar, zze(iZza), zzixVar2);
                                zza(t3, iZza, zzktVar);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 10:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza(t3, iZzc2 & 1048575, zzliVar.zzp());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 11:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzj());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 12:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                int iZze = zzliVar.zze();
                                zzjo zzjoVarZzd = zzd(iZza);
                                if (zzjoVarZzd != null && !zzjoVarZzd.zza(iZze)) {
                                    objZza = zzln.zza(t3, iZzc, iZze, obj2, zzmfVar);
                                    zzizVar2 = zzizVar;
                                    zzixVar3 = zzixVar2;
                                    zzmfVar3 = zzmfVar;
                                }
                                zzmg.zza((Object) t3, iZzc2 & 1048575, iZze);
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 13:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzh());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 14:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzm());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 15:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzi());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 16:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzn());
                                zzb((Object) t3, iZza);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 17:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzkt zzktVar2 = (zzkt) zza((Object) t3, iZza);
                                zzliVar.zza(zzktVar2, zze(iZza), zzixVar2);
                                zza(t3, iZza, zzktVar2);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 18:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzc(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 19:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzg(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 20:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzi(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 21:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzq(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 22:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzh(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 23:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzf(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 24:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zze(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 25:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zza(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 26:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                if (zzg(iZzc2)) {
                                    zzliVar.zzo(this.zzo.zza(t3, iZzc2 & 1048575));
                                } else {
                                    zzliVar.zzn(this.zzo.zza(t3, iZzc2 & 1048575));
                                }
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 27:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzb(this.zzo.zza(t3, iZzc2 & 1048575), zze(iZza), zzixVar2);
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 28:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzb(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 29:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzp(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 30:
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                List listZza = this.zzo.zza(t3, iZzc2 & 1048575);
                                zzliVar.zzd(listZza);
                                objZza = zzln.zza(t, iZzc, listZza, zzd(iZza), objZza, zzmfVar);
                                zzizVar2 = zzizVar;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 31:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzj(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 32:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzk(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 33:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzl(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 34:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzm(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 35:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzc(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 36:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzg(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 37:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzi(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 38:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzq(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 39:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzh(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 40:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzf(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 41:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zze(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 42:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zza(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 43:
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzliVar.zzp(this.zzo.zza(t3, iZzc2 & 1048575));
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 44:
                                List listZza2 = this.zzo.zza(t3, iZzc2 & 1048575);
                                zzliVar.zzd(listZza2);
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                objZza = zzln.zza(t, iZzc, listZza2, zzd(iZza), objZza, zzmfVar);
                                zzizVar2 = zzizVar;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 45:
                                zzliVar.zzj(this.zzo.zza(t3, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 46:
                                zzliVar.zzk(this.zzo.zza(t3, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 47:
                                zzliVar.zzl(this.zzo.zza(t3, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 48:
                                zzliVar.zzm(this.zzo.zza(t3, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 49:
                                zzliVar.zza(this.zzo.zza(t3, iZzc2 & 1048575), zze(iZza), zzixVar3);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 50:
                                Object objZzf = zzf(iZza);
                                long jZzc = zzc(iZza) & 1048575;
                                Object objZze = zzmg.zze(t3, jZzc);
                                if (objZze == null) {
                                    objZze = this.zzr.zzb(objZzf);
                                    zzmg.zza(t3, jZzc, objZze);
                                } else if (this.zzr.zzf(objZze)) {
                                    Object objZzb = this.zzr.zzb(objZzf);
                                    this.zzr.zza(objZzb, objZze);
                                    zzmg.zza(t3, jZzc, objZzb);
                                    objZze = objZzb;
                                }
                                zzliVar.zza(this.zzr.zze(objZze), this.zzr.zza(objZzf), zzixVar3);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 51:
                                zzmg.zza(t3, iZzc2 & 1048575, Double.valueOf(zzliVar.zza()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 52:
                                zzmg.zza(t3, iZzc2 & 1048575, Float.valueOf(zzliVar.zzb()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 53:
                                zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzl()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 54:
                                zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzo()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 55:
                                zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzg()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 56:
                                zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzk()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 57:
                                zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzf()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                                zzmg.zza(t3, iZzc2 & 1048575, Boolean.valueOf(zzliVar.zzs()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                                zza((Object) t3, iZzc2, (zzli) zzliVar);
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 60:
                                zzkt zzktVar3 = (zzkt) zza(t3, iZzc, iZza);
                                zzliVar.zzb(zzktVar3, zze(iZza), zzixVar3);
                                zza(t3, iZzc, iZza, zzktVar3);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 61:
                                zzmg.zza(t3, iZzc2 & 1048575, zzliVar.zzp());
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 62:
                                zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzj()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 63:
                                int iZze2 = zzliVar.zze();
                                zzjo zzjoVarZzd2 = zzd(iZza);
                                if (zzjoVarZzd2 == null || zzjoVarZzd2.zza(iZze2)) {
                                    zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(iZze2));
                                    zzb(t3, iZzc, iZza);
                                    obj2 = objZza;
                                    zzizVar = zzizVar2;
                                    zzixVar2 = zzixVar3;
                                    zzizVar2 = zzizVar;
                                    objZza = obj2;
                                    zzixVar3 = zzixVar2;
                                } else {
                                    objZza = zzln.zza(t3, iZzc, iZze2, objZza, zzmfVar);
                                    t3 = t3;
                                }
                                zzmfVar3 = zzmfVar;
                                break;
                            case 64:
                                zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzh()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 65:
                                zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzm()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 66:
                                zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzi()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case 67:
                                zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzn()));
                                zzb(t3, iZzc, iZza);
                                obj2 = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzizVar2 = zzizVar;
                                objZza = obj2;
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                                try {
                                    zzkt zzktVar4 = (zzkt) zza(t3, iZzc, iZza);
                                    zzliVar.zza(zzktVar4, zze(iZza), zzixVar3);
                                    zza(t3, iZzc, iZza, zzktVar4);
                                    obj2 = objZza;
                                    zzizVar = zzizVar2;
                                    zzixVar2 = zzixVar3;
                                    zzizVar2 = zzizVar;
                                    objZza = obj2;
                                } catch (zzjv unused) {
                                    obj = objZza;
                                    zzizVar = zzizVar2;
                                    zzixVar2 = zzixVar3;
                                    objZza = obj;
                                    zzmfVar.zza((zzli) zzliVar);
                                    if (objZza == null) {
                                        objZza = zzmfVar.zzc(t3);
                                    }
                                    if (!zzmfVar.zza(objZza, (zzli) zzliVar)) {
                                        for (i2 = this.zzl; i2 < this.zzm; i2++) {
                                            objZza = zza(t, this.zzk[i2], objZza, (zzmf<UT, Object>) zzmfVar, t);
                                        }
                                        if (objZza != null) {
                                            zzmfVar.zzb(t3, objZza);
                                            return;
                                        }
                                        return;
                                    }
                                    zzizVar2 = zzizVar;
                                }
                                zzixVar3 = zzixVar2;
                                zzmfVar3 = zzmfVar;
                                break;
                            default:
                                obj = objZza;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                if (obj == null) {
                                    try {
                                        objZza = zzmfVar.zzc(t3);
                                    } catch (zzjv unused2) {
                                        objZza = obj;
                                        zzmfVar.zza((zzli) zzliVar);
                                        if (objZza == null) {
                                            objZza = zzmfVar.zzc(t3);
                                        }
                                        if (!zzmfVar.zza(objZza, (zzli) zzliVar)) {
                                            while (i2 < this.zzm) {
                                                objZza = zza(t, this.zzk[i2], objZza, (zzmf<UT, Object>) zzmfVar, t);
                                            }
                                            if (objZza != null) {
                                                zzmfVar.zzb(t3, objZza);
                                                return;
                                            }
                                            return;
                                        }
                                        zzizVar2 = zzizVar;
                                        zzixVar3 = zzixVar2;
                                        zzmfVar3 = zzmfVar;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        objZza = obj;
                                        for (i = this.zzl; i < this.zzm; i++) {
                                            objZza = zza(t, this.zzk[i], objZza, (zzmf<UT, Object>) zzmfVar, t);
                                        }
                                        if (objZza != null) {
                                            zzmfVar.zzb(t3, objZza);
                                        }
                                        throw th;
                                    }
                                } else {
                                    objZza = obj;
                                }
                                try {
                                    try {
                                        if (!zzmfVar.zza(objZza, (zzli) zzliVar)) {
                                            for (int i5 = this.zzl; i5 < this.zzm; i5++) {
                                                objZza = zza(t, this.zzk[i5], objZza, (zzmf<UT, Object>) zzmfVar, t);
                                            }
                                            if (objZza != null) {
                                                zzmfVar.zzb(t3, objZza);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (zzjv unused3) {
                                        zzmfVar.zza((zzli) zzliVar);
                                        if (objZza == null) {
                                            objZza = zzmfVar.zzc(t3);
                                        }
                                        if (!zzmfVar.zza(objZza, (zzli) zzliVar)) {
                                            while (i2 < this.zzm) {
                                                objZza = zza(t, this.zzk[i2], objZza, (zzmf<UT, Object>) zzmfVar, t);
                                            }
                                            if (objZza != null) {
                                                zzmfVar.zzb(t3, objZza);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    zzizVar2 = zzizVar;
                                    zzixVar3 = zzixVar2;
                                    zzmfVar3 = zzmfVar;
                                } catch (Throwable th4) {
                                    th = th4;
                                    while (i < this.zzm) {
                                        objZza = zza(t, this.zzk[i], objZza, (zzmf<UT, Object>) zzmfVar, t);
                                    }
                                    if (objZza != null) {
                                        zzmfVar.zzb(t3, objZza);
                                    }
                                    throw th;
                                }
                                break;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, byte[] bArr, int i, int i2, zzhv zzhvVar) throws IOException {
        zza(t, bArr, i, i2, 0, zzhvVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((Object) t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzll zzllVarZze = zze(i);
            if (!zzc((Object) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzllVarZze.zza();
                    zzllVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((Object) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzllVarZze.zza();
                zzllVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzllVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc(t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzll zzllVarZze = zze(i);
            if (!zzc(t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzllVarZze.zza();
                    zzllVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb(t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzllVarZze.zza();
                zzllVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzllVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzli zzliVar) throws IOException {
        if (zzg(i)) {
            zzmg.zza(obj, i & 1048575, zzliVar.zzr());
        } else if (this.zzi) {
            zzmg.zza(obj, i & 1048575, zzliVar.zzq());
        } else {
            zzmg.zza(obj, i & 1048575, zzliVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzmg.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzmg.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzmg.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((Object) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb(t, i, i2);
    }

    private final <K, V> void zza(zzna zznaVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznaVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzna zznaVar) throws IOException {
        if (obj instanceof String) {
            zznaVar.zza(i, (String) obj);
        } else {
            zznaVar.zza(i, (zzia) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:176:0x054a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, zzna zznaVar) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        Unsafe unsafe;
        boolean z2;
        Iterator itZzc;
        Map.Entry<?, ?> entry2;
        zzna zznaVar2 = zznaVar;
        int i5 = 267386880;
        int i6 = 1048575;
        if (zznaVar.zza() == 2) {
            zza(this.zzp, t, zznaVar2);
            if (this.zzh) {
                zzjd<T> zzjdVarZza = this.zzq.zza(t);
                if (zzjdVarZza.zza.isEmpty()) {
                    itZzc = null;
                    entry2 = null;
                } else {
                    itZzc = zzjdVarZza.zzc();
                    entry2 = (Map.Entry) itZzc.next();
                }
            } else {
                itZzc = null;
                entry2 = null;
            }
            for (int length = this.zzc.length - 3; length >= 0; length -= 3) {
                int iZzc = zzc(length);
                int i7 = this.zzc[length];
                while (entry2 != null && this.zzq.zza(entry2) > i7) {
                    this.zzq.zza(zznaVar2, entry2);
                    entry2 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
                }
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zza(i7, zzmg.zza(t, iZzc & 1048575));
                        }
                        break;
                    case 1:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zza(i7, zzmg.zzb(t, iZzc & 1048575));
                        }
                        break;
                    case 2:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzb(i7, zzmg.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 3:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zze(i7, zzmg.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 4:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzc(i7, zzmg.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 5:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zza(i7, zzmg.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 6:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzb(i7, zzmg.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 7:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zza(i7, zzmg.zzh(t, iZzc & 1048575));
                        }
                        break;
                    case 8:
                        if (zzc((Object) t, length)) {
                            zza(i7, zzmg.zze(t, iZzc & 1048575), zznaVar2);
                        }
                        break;
                    case 9:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzb(i7, zzmg.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case 10:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zza(i7, (zzia) zzmg.zze(t, iZzc & 1048575));
                        }
                        break;
                    case 11:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzf(i7, zzmg.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 12:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zza(i7, zzmg.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 13:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzd(i7, zzmg.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 14:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzc(i7, zzmg.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 15:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zze(i7, zzmg.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 16:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zzd(i7, zzmg.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 17:
                        if (zzc((Object) t, length)) {
                            zznaVar2.zza(i7, zzmg.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case 18:
                        zzln.zzb(this.zzc[length], (List<Double>) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 19:
                        zzln.zzf(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 20:
                        zzln.zzh(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 21:
                        zzln.zzn(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 22:
                        zzln.zzg(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 23:
                        zzln.zze(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 24:
                        zzln.zzd(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 25:
                        zzln.zza(this.zzc[length], (List<Boolean>) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 26:
                        zzln.zzb(this.zzc[length], (List<String>) zzmg.zze(t, iZzc & 1048575), zznaVar2);
                        break;
                    case 27:
                        zzln.zzb(this.zzc[length], (List<?>) zzmg.zze(t, iZzc & 1048575), zznaVar2, zze(length));
                        break;
                    case 28:
                        zzln.zza(this.zzc[length], (List<zzia>) zzmg.zze(t, iZzc & 1048575), zznaVar2);
                        break;
                    case 29:
                        zzln.zzm(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 30:
                        zzln.zzc(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 31:
                        zzln.zzi(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 32:
                        zzln.zzj(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 33:
                        zzln.zzk(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 34:
                        zzln.zzl(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, false);
                        break;
                    case 35:
                        zzln.zzb(this.zzc[length], (List<Double>) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 36:
                        zzln.zzf(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 37:
                        zzln.zzh(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 38:
                        zzln.zzn(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 39:
                        zzln.zzg(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 40:
                        zzln.zze(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 41:
                        zzln.zzd(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 42:
                        zzln.zza(this.zzc[length], (List<Boolean>) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 43:
                        zzln.zzm(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 44:
                        zzln.zzc(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 45:
                        zzln.zzi(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 46:
                        zzln.zzj(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 47:
                        zzln.zzk(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 48:
                        zzln.zzl(this.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar2, true);
                        break;
                    case 49:
                        zzln.zza(this.zzc[length], (List<?>) zzmg.zze(t, iZzc & 1048575), zznaVar2, zze(length));
                        break;
                    case 50:
                        zza(zznaVar2, i7, zzmg.zze(t, iZzc & 1048575), length);
                        break;
                    case 51:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zza(i7, zza(t, iZzc & 1048575));
                        }
                        break;
                    case 52:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zza(i7, zzb(t, iZzc & 1048575));
                        }
                        break;
                    case 53:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzb(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 54:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zze(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 55:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzc(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 56:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zza(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 57:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzb(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zza(i7, zze(t, iZzc & 1048575));
                        }
                        break;
                    case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                        if (zzc(t, i7, length)) {
                            zza(i7, zzmg.zze(t, iZzc & 1048575), zznaVar2);
                        }
                        break;
                    case 60:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzb(i7, zzmg.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case 61:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zza(i7, (zzia) zzmg.zze(t, iZzc & 1048575));
                        }
                        break;
                    case 62:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzf(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 63:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zza(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 64:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzd(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 65:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzc(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 66:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zze(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 67:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zzd(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                        if (zzc(t, i7, length)) {
                            zznaVar2.zza(i7, zzmg.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.zzq.zza(zznaVar2, entry2);
                entry2 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
            }
            return;
        }
        if (this.zzh) {
            zzjd<T> zzjdVarZza2 = this.zzq.zza(t);
            if (zzjdVarZza2.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzd = zzjdVarZza2.zzd();
                entry = (Map.Entry) itZzd.next();
                it = itZzd;
            }
        } else {
            entry = null;
            it = null;
        }
        int length2 = this.zzc.length;
        Unsafe unsafe2 = zzb;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i9 < length2) {
            int iZzc2 = zzc(i9);
            int[] iArr = this.zzc;
            int i11 = iArr[i9];
            int i12 = (iZzc2 & i5) >>> 20;
            if (i12 <= 17) {
                int i13 = iArr[i9 + 2];
                int i14 = i13 & i6;
                if (i14 != i10) {
                    i8 = i14 == i6 ? 0 : unsafe2.getInt(t, i14);
                    i10 = i14;
                } else {
                    it = it;
                }
                i2 = i8;
                i3 = 1 << (i13 >>> 20);
                i = i10;
            } else {
                it = it;
                i = i10;
                i2 = i8;
                i3 = 0;
            }
            while (entry != null && this.zzq.zza(entry) <= i11) {
                this.zzq.zza(zznaVar2, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzc2 & 1048575;
            switch (i12) {
                case 0:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zza(i11, zzmg.zza(t, j));
                    }
                    break;
                case 1:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zza(i11, zzmg.zzb(t, j));
                    }
                    break;
                case 2:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzb(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zze(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzc(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zza(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzb(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zza(i11, zzmg.zzh(t, j));
                    }
                    break;
                case 8:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zza(i11, unsafe.getObject(t, j), zznaVar2);
                    }
                    break;
                case 9:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzb(i11, unsafe.getObject(t, j), zze(i4));
                    }
                    break;
                case 10:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zza(i11, (zzia) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzf(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zza(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzd(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzc(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zze(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    i = i;
                    if (zza(t, i4, i, i2, i3)) {
                        zznaVar2.zzd(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    z = false;
                    entry = entry;
                    i4 = i9;
                    length2 = length2;
                    unsafe = unsafe2;
                    if (zza(t, i9, i, i2, i3)) {
                        zznaVar2 = zznaVar;
                        zznaVar2.zza(i11, unsafe.getObject(t, j), zze(i4));
                    } else {
                        zznaVar2 = zznaVar;
                    }
                    i = i;
                    break;
                case 18:
                    z2 = false;
                    zzln.zzb(this.zzc[i9], (List<Double>) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 19:
                    z2 = false;
                    zzln.zzf(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 20:
                    z2 = false;
                    zzln.zzh(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 21:
                    z2 = false;
                    zzln.zzn(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 22:
                    z2 = false;
                    zzln.zzg(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 23:
                    z2 = false;
                    zzln.zze(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 24:
                    z2 = false;
                    zzln.zzd(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 25:
                    z2 = false;
                    zzln.zza(this.zzc[i9], (List<Boolean>) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 26:
                    zzln.zzb(this.zzc[i9], (List<String>) unsafe2.getObject(t, j), zznaVar2);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 27:
                    zzln.zzb(this.zzc[i9], (List<?>) unsafe2.getObject(t, j), zznaVar2, zze(i9));
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 28:
                    zzln.zza(this.zzc[i9], (List<zzia>) unsafe2.getObject(t, j), zznaVar2);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 29:
                    z2 = false;
                    zzln.zzm(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 30:
                    z2 = false;
                    zzln.zzc(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 31:
                    z2 = false;
                    zzln.zzi(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 32:
                    z2 = false;
                    zzln.zzj(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 33:
                    z2 = false;
                    zzln.zzk(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 34:
                    z2 = false;
                    zzln.zzl(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 35:
                    zzln.zzb(this.zzc[i9], (List<Double>) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 36:
                    zzln.zzf(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 37:
                    zzln.zzh(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 38:
                    zzln.zzn(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 39:
                    zzln.zzg(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 40:
                    zzln.zze(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 41:
                    zzln.zzd(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 42:
                    zzln.zza(this.zzc[i9], (List<Boolean>) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 43:
                    zzln.zzm(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 44:
                    zzln.zzc(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 45:
                    zzln.zzi(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 46:
                    zzln.zzj(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 47:
                    zzln.zzk(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 48:
                    zzln.zzl(this.zzc[i9], (List) unsafe2.getObject(t, j), zznaVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 49:
                    zzln.zza(this.zzc[i9], (List<?>) unsafe2.getObject(t, j), zznaVar2, zze(i9));
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 50:
                    zza(zznaVar2, i11, unsafe2.getObject(t, j), i9);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 51:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zza(i11, zza(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 52:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zza(i11, zzb(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 53:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzb(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 54:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zze(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 55:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzc(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 56:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zza(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 57:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzb(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zza(i11, zze(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    if (zzc(t, i11, i9)) {
                        zza(i11, unsafe2.getObject(t, j), zznaVar2);
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 60:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzb(i11, unsafe2.getObject(t, j), zze(i9));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 61:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zza(i11, (zzia) unsafe2.getObject(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 62:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzf(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 63:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zza(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 64:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzd(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 65:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzc(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 66:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zze(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 67:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zzd(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    if (zzc(t, i11, i9)) {
                        zznaVar2.zza(i11, unsafe2.getObject(t, j), zze(i9));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                default:
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
            }
            i9 = i4 + 3;
            i8 = i2;
            unsafe2 = unsafe;
            i6 = 1048575;
            it = it;
            entry = entry;
            length2 = length2;
            i10 = i;
            i5 = 267386880;
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzq.zza(zznaVar2, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        zza(this.zzp, t, zznaVar2);
    }

    private static <UT, UB> void zza(zzmf<UT, UB> zzmfVar, T t, zzna zznaVar) throws IOException {
        zzmfVar.zzb(zzmfVar.zzd(t), zznaVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((Object) t, i) == zzc((Object) t2, i);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final boolean zzb(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean zZza = true;
            if (i < length) {
                int iZzc = zzc(i);
                long j = iZzc & 1048575;
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzmg.zza(t, j)) != Double.doubleToLongBits(zzmg.zza(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzmg.zzb(t, j)) != Float.floatToIntBits(zzmg.zzb(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 2:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 3:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 4:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 5:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 6:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 7:
                        if (!zzc(t, t2, i) || zzmg.zzh(t, j) != zzmg.zzh(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 8:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 9:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 10:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 11:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 12:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 13:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 14:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 15:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 16:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 17:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zZza = zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j));
                        break;
                    case 50:
                        zZza = zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                        long jZzb = zzb(i) & 1048575;
                        if (zzmg.zzc(t, jZzb) != zzmg.zzc(t2, jZzb) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                            zZza = false;
                        }
                        break;
                }
                if (!zZza) {
                    return false;
                }
                i += 3;
            } else {
                if (!this.zzp.zzd(t).equals(this.zzp.zzd(t2))) {
                    return false;
                }
                if (this.zzh) {
                    return this.zzq.zza(t).equals(this.zzq.zza(t2));
                }
                return true;
            }
        }
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return (zzmg.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmg.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmg.zzb(t, j2)) != 0;
            case 2:
                return zzmg.zzd(t, j2) != 0;
            case 3:
                return zzmg.zzd(t, j2) != 0;
            case 4:
                return zzmg.zzc(t, j2) != 0;
            case 5:
                return zzmg.zzd(t, j2) != 0;
            case 6:
                return zzmg.zzc(t, j2) != 0;
            case 7:
                return zzmg.zzh(t, j2);
            case 8:
                Object objZze = zzmg.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzia) {
                    return !zzia.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmg.zze(t, j2) != null;
            case 10:
                return !zzia.zza.equals(zzmg.zze(t, j2));
            case 11:
                return zzmg.zzc(t, j2) != 0;
            case 12:
                return zzmg.zzc(t, j2) != 0;
            case 13:
                return zzmg.zzc(t, j2) != 0;
            case 14:
                return zzmg.zzd(t, j2) != 0;
            case 15:
                return zzmg.zzc(t, j2) != 0;
            case 16:
                return zzmg.zzd(t, j2) != 0;
            case 17:
                return zzmg.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f7 A[LOOP:2: B:52:0x00e6->B:57:0x00f7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzll] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzll] */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final boolean zzd(T t) {
        int i;
        int i2;
        List list;
        ?? Zze;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzl) {
            int i7 = this.zzk[i6];
            int i8 = this.zzc[i7];
            int iZzc = zzc(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(t, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzc) != 0 && !zza(t, i7, i, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & iZzc) >>> 20;
            if (i12 == 9 || i12 == 17) {
                if (zza(t, i7, i, i2, i11) && !zza((Object) t, iZzc, zze(i7))) {
                    return false;
                }
            } else if (i12 == 27) {
                list = (List) zzmg.zze(t, iZzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    Zze = zze(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!Zze.zzd(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (i12 == 60 || i12 == 68) {
                if (zzc(t, i8, i7) && !zza((Object) t, iZzc, zze(i7))) {
                    return false;
                }
            } else if (i12 == 49) {
                list = (List) zzmg.zze(t, iZzc & 1048575);
                if (list.isEmpty()) {
                    Zze = zze(i7);
                    while (i3 < list.size()) {
                        if (!Zze.zzd(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i12 != 50) {
                continue;
            } else {
                Map<?, ?> mapZzd = this.zzr.zzd(zzmg.zze(t, iZzc & 1048575));
                if (mapZzd.isEmpty()) {
                    continue;
                } else if (this.zzr.zza(zzf(i7)).zzc.zzb() == zzmx.MESSAGE) {
                    ?? Zza = 0;
                    for (Object obj : mapZzd.values()) {
                        if (Zza == 0) {
                            Zza = Zza;
                            Zza = zzlh.zza().zza((Class) obj.getClass());
                        }
                        Zza = Zza;
                        if (!Zza.zzd(obj)) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return !this.zzh || this.zzq.zza(t).zzg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzll zzllVar) {
        return zzllVar.zzd(zzmg.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzjk) {
            return ((zzjk) obj).zzcn();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzmg.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzmg.zze(t, j)).booleanValue();
    }
}
