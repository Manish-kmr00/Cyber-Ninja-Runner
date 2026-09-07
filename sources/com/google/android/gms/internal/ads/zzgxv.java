package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxp;
import com.google.android.gms.internal.ads.zzgxv;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public abstract class zzgxv<MessageType extends zzgxv<MessageType, BuilderType>, BuilderType extends zzgxp<MessageType, BuilderType>> extends zzgvw<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Class<?>, zzgxv<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzham zzt = zzham.zzc();

    protected static zzgxx zzbA() {
        return zzgwd.zzd();
    }

    protected static zzgxx zzbB(zzgxx zzgxxVar) {
        int size = zzgxxVar.size();
        return zzgxxVar.zzf(size + size);
    }

    protected static zzgxy zzbC() {
        return zzgxc.zze();
    }

    protected static zzgxy zzbD(zzgxy zzgxyVar) {
        int size = zzgxyVar.size();
        return zzgxyVar.zzf(size + size);
    }

    protected static zzgyc zzbE() {
        return zzgxm.zze();
    }

    protected static zzgyc zzbF(zzgyc zzgycVar) {
        int size = zzgycVar.size();
        return zzgycVar.zzf(size + size);
    }

    protected static zzgyd zzbG() {
        return zzgxw.zzg();
    }

    protected static zzgyd zzbH(zzgyd zzgydVar) {
        int size = zzgydVar.size();
        return zzgydVar.zzf(size + size);
    }

    protected static zzgyg zzbI() {
        return zzgyv.zzh();
    }

    protected static zzgyg zzbJ(zzgyg zzgygVar) {
        int size = zzgygVar.size();
        return zzgygVar.zzf(size + size);
    }

    protected static <E> zzgyh<E> zzbK() {
        return zzgzr.zzd();
    }

    protected static <E> zzgyh<E> zzbL(zzgyh<E> zzgyhVar) {
        int size = zzgyhVar.size();
        return zzgyhVar.zzf(size + size);
    }

    static Object zzbP(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzbQ(zzgzg zzgzgVar, String str, Object[] objArr) {
        return new zzgzs(zzgzgVar, str, objArr);
    }

    static Method zzbR(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    protected static <T extends zzgxv> void zzbZ(Class<T> cls, T t) {
        t.zzbV();
        zzc.put(cls, t);
    }

    public static <ContainingType extends zzgzg, Type> zzgxt<ContainingType, Type> zzbe(ContainingType containingtype, zzgzg zzgzgVar, zzgya zzgyaVar, int i, zzhay zzhayVar, boolean z, Class cls) {
        return new zzgxt<>(containingtype, zzgzr.zzd(), zzgzgVar, new zzgxs(zzgyaVar, i, zzhayVar, true, z), cls);
    }

    public static <ContainingType extends zzgzg, Type> zzgxt<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzgzg zzgzgVar, zzgya zzgyaVar, int i, zzhay zzhayVar, Class cls) {
        return new zzgxt<>(containingtype, type, zzgzgVar, new zzgxs(zzgyaVar, i, zzhayVar, false, false), cls);
    }

    static <T extends zzgxv> T zzbh(Class<T> cls) {
        zzgxv<?, ?> zzgxvVarZzbt = zzc.get(cls);
        if (zzgxvVarZzbt == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgxvVarZzbt = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgxvVarZzbt == null) {
            zzgxvVarZzbt = ((zzgxv) zzhas.zzg(cls)).zzbt();
            if (zzgxvVarZzbt == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzgxvVarZzbt);
        }
        return zzgxvVarZzbt;
    }

    protected static <T extends zzgxv<T, ?>> T zzbk(T t, InputStream inputStream) throws zzgyk {
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        T t2 = (T) zzg(t, inputStream, zzgxf.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbl(T t, InputStream inputStream, zzgxf zzgxfVar) throws zzgyk {
        T t2 = (T) zzg(t, inputStream, zzgxfVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbm(T t, zzgwn zzgwnVar) throws zzgyk {
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        T t2 = (T) zzbr(t, zzgwnVar, zzgxf.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbn(T t, zzgwt zzgwtVar) throws zzgyk {
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        return (T) zzbs(t, zzgwtVar, zzgxf.zza);
    }

    protected static <T extends zzgxv<T, ?>> T zzbo(T t, InputStream inputStream) throws zzgyk {
        zzgwt zzgwtVarZzG = zzgwt.zzG(inputStream, 4096);
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        T t2 = (T) zzbz(t, zzgwtVarZzG, zzgxf.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbp(T t, ByteBuffer byteBuffer) throws zzgyk {
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        return (T) zzbv(t, byteBuffer, zzgxf.zza);
    }

    protected static <T extends zzgxv<T, ?>> T zzbq(T t, byte[] bArr) throws zzgyk {
        int length = bArr.length;
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        T t2 = (T) zzi(t, bArr, 0, length, zzgxf.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbr(T t, zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        T t2 = (T) zzh(t, zzgwnVar, zzgxfVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbs(T t, zzgwt zzgwtVar, zzgxf zzgxfVar) throws zzgyk {
        T t2 = (T) zzbz(t, zzgwtVar, zzgxfVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbu(T t, InputStream inputStream, zzgxf zzgxfVar) throws zzgyk {
        T t2 = (T) zzbz(t, zzgwt.zzG(inputStream, 4096), zzgxfVar);
        zzf(t2);
        return t2;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0035  */
    protected static <T extends zzgxv<T, ?>> T zzbv(T t, ByteBuffer byteBuffer, zzgxf zzgxfVar) throws zzgyk {
        zzgwt zzgwtVarZzH;
        int i = zzgwt.zze;
        boolean z = false;
        if (byteBuffer.hasArray()) {
            zzgwtVarZzH = zzgwt.zzH(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), false);
        } else if (byteBuffer.isDirect()) {
            int i2 = zzgwr.zza;
            if (zzhas.zzB()) {
                zzgwtVarZzH = new zzgwr(byteBuffer, z, null);
            } else {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining];
                byteBuffer.duplicate().get(bArr);
                zzgwtVarZzH = zzgwt.zzH(bArr, 0, iRemaining, true);
            }
        } else {
            int iRemaining2 = byteBuffer.remaining();
            byte[] bArr2 = new byte[iRemaining2];
            byteBuffer.duplicate().get(bArr2);
            zzgwtVarZzH = zzgwt.zzH(bArr2, 0, iRemaining2, true);
        }
        T t2 = (T) zzbs(t, zzgwtVarZzH, zzgxfVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzbx(T t, byte[] bArr, zzgxf zzgxfVar) throws zzgyk {
        T t2 = (T) zzi(t, bArr, 0, bArr.length, zzgxfVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgxv<T, ?>> T zzby(T t, zzgwt zzgwtVar) throws zzgyk {
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        return (T) zzbz(t, zzgwtVar, zzgxf.zza);
    }

    static <T extends zzgxv<T, ?>> T zzbz(T t, zzgwt zzgwtVar, zzgxf zzgxfVar) throws zzgyk {
        T t2 = (T) t.zzbj();
        try {
            zzgzz zzgzzVarZzb = zzgzq.zza().zzb(t2.getClass());
            zzgzzVarZzb.zzh(t2, zzgwu.zzq(zzgwtVar), zzgxfVar);
            zzgzzVarZzb.zzf(t2);
            return t2;
        } catch (zzgyk e) {
            if (e.zzb()) {
                throw new zzgyk(e);
            }
            throw e;
        } catch (zzhak e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgyk) {
                throw ((zzgyk) e3.getCause());
            }
            throw new zzgyk(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgyk) {
                throw ((zzgyk) e4.getCause());
            }
            throw e4;
        }
    }

    private int zzc(zzgzz<?> zzgzzVar) {
        if (zzgzzVar != null) {
            return zzgzzVar.zza(this);
        }
        return zzgzq.zza().zzb(getClass()).zza(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends zzgxr<MessageType, BuilderType>, BuilderType, T> zzgxt<MessageType, T> zzd(zzgxd<MessageType, T> zzgxdVar) {
        return (zzgxt) zzgxdVar;
    }

    private static <T extends zzgxv<T, ?>> T zzf(T t) throws zzgyk {
        if (t == null || t.zzbw()) {
            return t;
        }
        throw t.zzaP().zza();
    }

    private static <T extends zzgxv<T, ?>> T zzg(T t, InputStream inputStream, zzgxf zzgxfVar) throws zzgyk {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            zzgwt zzgwtVarZzG = zzgwt.zzG(new zzgvu(inputStream, zzgwt.zzE(i, inputStream)), 4096);
            T t2 = (T) zzbz(t, zzgwtVarZzG, zzgxfVar);
            zzgwtVarZzG.zzy(0);
            return t2;
        } catch (zzgyk e) {
            if (e.zzb()) {
                throw new zzgyk(e);
            }
            throw e;
        } catch (IOException e2) {
            throw new zzgyk(e2);
        }
    }

    private static <T extends zzgxv<T, ?>> T zzh(T t, zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        zzgwt zzgwtVarZzl = zzgwnVar.zzl();
        T t2 = (T) zzbz(t, zzgwtVarZzl, zzgxfVar);
        zzgwtVarZzl.zzy(0);
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends zzgxv<T, ?>> T zzi(T t, byte[] bArr, int i, int i2, zzgxf zzgxfVar) throws zzgyk {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzbj();
        try {
            zzgzz zzgzzVarZzb = zzgzq.zza().zzb(t2.getClass());
            zzgzzVarZzb.zzi(t2, bArr, i, i + i2, new zzgwb(zzgxfVar));
            zzgzzVarZzb.zzf(t2);
            return t2;
        } catch (zzgyk e) {
            if (e.zzb()) {
                throw new zzgyk(e);
            }
            throw e;
        } catch (zzhak e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgyk) {
                throw ((zzgyk) e3.getCause());
            }
            throw new zzgyk(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private void zzj() {
        if (this.zzt == zzham.zzc()) {
            this.zzt = zzham.zzf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends zzgxv<T, ?>> boolean zzk(T t, boolean z) {
        byte bByteValue = ((Byte) t.zzdc(zzgxu.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzgzq.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.zzdc(zzgxu.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t, null);
        }
        return zZzl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgzq.zza().zzb(getClass()).zzk(this, (zzgxv) obj);
    }

    public int hashCode() {
        if (zzcd()) {
            return zzaW();
        }
        if (zzcc()) {
            zzca(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzgzi.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgvw
    int zzaL() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgvw
    int zzaM(zzgzz zzgzzVar) {
        if (!zzcd()) {
            if (zzaL() != Integer.MAX_VALUE) {
                return zzaL();
            }
            int iZzc = zzc(zzgzzVar);
            zzaS(iZzc);
            return iZzc;
        }
        int iZzc2 = zzc(zzgzzVar);
        if (iZzc2 >= 0) {
            return iZzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzc2);
    }

    @Override // com.google.android.gms.internal.ads.zzgvw
    public zzgzl zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    @Override // com.google.android.gms.internal.ads.zzgvw
    void zzaS(int i) {
        if (i >= 0) {
            this.zzd = i | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
    }

    int zzaW() {
        return zzgzq.zza().zzb(getClass()).zzb(this);
    }

    int zzaX() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzgzg
    public int zzaY() {
        return zzaM(null);
    }

    protected final <MessageType extends zzgxv<MessageType, BuilderType>, BuilderType extends zzgxp<MessageType, BuilderType>> BuilderType zzaZ() {
        return (BuilderType) zzdc(zzgxu.NEW_BUILDER, null, null);
    }

    public final zzgzo<MessageType> zzbN() {
        return (zzgzo) zzdc(zzgxu.GET_PARSER, null, null);
    }

    Object zzbO() throws Exception {
        return zzdc(zzgxu.BUILD_MESSAGE_INFO, null, null);
    }

    void zzbS() {
        this.zzq = 0;
    }

    void zzbT() {
        zzaS(Integer.MAX_VALUE);
    }

    protected void zzbU() {
        zzgzq.zza().zzb(getClass()).zzf(this);
        zzbV();
    }

    void zzbV() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected void zzbW(int i, zzgwn zzgwnVar) {
        zzj();
        zzham zzhamVar = this.zzt;
        zzhamVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhamVar.zzj((i << 3) | 2, zzgwnVar);
    }

    protected final void zzbX(zzham zzhamVar) {
        this.zzt = zzham.zze(this.zzt, zzhamVar);
    }

    protected void zzbY(int i, int i2) {
        zzj();
        zzham zzhamVar = this.zzt;
        zzhamVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhamVar.zzj(i << 3, Long.valueOf(i2));
    }

    protected final <MessageType extends zzgxv<MessageType, BuilderType>, BuilderType extends zzgxp<MessageType, BuilderType>> BuilderType zzba(MessageType messagetype) {
        BuilderType buildertype = (BuilderType) zzaZ();
        buildertype.zzbj(messagetype);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzg
    /* JADX INFO: renamed from: zzbb, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcX() {
        return (BuilderType) zzdc(zzgxu.NEW_BUILDER, null, null);
    }

    /* JADX INFO: renamed from: zzbc, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzbM() {
        BuilderType buildertype = (BuilderType) zzdc(zzgxu.NEW_BUILDER, null, null);
        buildertype.zzbj(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    /* JADX INFO: renamed from: zzbi, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbt() {
        return (MessageType) zzdc(zzgxu.GET_DEFAULT_INSTANCE, null, null);
    }

    MessageType zzbj() {
        return (MessageType) zzdc(zzgxu.NEW_MUTABLE_INSTANCE, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final boolean zzbw() {
        return zzk(this, true);
    }

    @Override // com.google.android.gms.internal.ads.zzgzg
    public void zzcY(zzgxa zzgxaVar) throws IOException {
        zzgzq.zza().zzb(getClass()).zzj(this, zzgxb.zza(zzgxaVar));
    }

    void zzca(int i) {
        this.zzq = i;
    }

    boolean zzcc() {
        return zzaX() == 0;
    }

    boolean zzcd() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    protected boolean zzce(int i, zzgwt zzgwtVar) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        zzj();
        return this.zzt.zzm(i, zzgwtVar);
    }

    protected abstract Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2);
}
