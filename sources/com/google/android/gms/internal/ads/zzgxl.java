package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public enum zzgxl {
    DOUBLE(0, 1, zzgym.DOUBLE),
    FLOAT(1, 1, zzgym.FLOAT),
    INT64(2, 1, zzgym.LONG),
    UINT64(3, 1, zzgym.LONG),
    INT32(4, 1, zzgym.INT),
    FIXED64(5, 1, zzgym.LONG),
    FIXED32(6, 1, zzgym.INT),
    BOOL(7, 1, zzgym.BOOLEAN),
    STRING(8, 1, zzgym.STRING),
    MESSAGE(9, 1, zzgym.MESSAGE),
    BYTES(10, 1, zzgym.BYTE_STRING),
    UINT32(11, 1, zzgym.INT),
    ENUM(12, 1, zzgym.ENUM),
    SFIXED32(13, 1, zzgym.INT),
    SFIXED64(14, 1, zzgym.LONG),
    SINT32(15, 1, zzgym.INT),
    SINT64(16, 1, zzgym.LONG),
    GROUP(17, 1, zzgym.MESSAGE),
    DOUBLE_LIST(18, 2, zzgym.DOUBLE),
    FLOAT_LIST(19, 2, zzgym.FLOAT),
    INT64_LIST(20, 2, zzgym.LONG),
    UINT64_LIST(21, 2, zzgym.LONG),
    INT32_LIST(22, 2, zzgym.INT),
    FIXED64_LIST(23, 2, zzgym.LONG),
    FIXED32_LIST(24, 2, zzgym.INT),
    BOOL_LIST(25, 2, zzgym.BOOLEAN),
    STRING_LIST(26, 2, zzgym.STRING),
    MESSAGE_LIST(27, 2, zzgym.MESSAGE),
    BYTES_LIST(28, 2, zzgym.BYTE_STRING),
    UINT32_LIST(29, 2, zzgym.INT),
    ENUM_LIST(30, 2, zzgym.ENUM),
    SFIXED32_LIST(31, 2, zzgym.INT),
    SFIXED64_LIST(32, 2, zzgym.LONG),
    SINT32_LIST(33, 2, zzgym.INT),
    SINT64_LIST(34, 2, zzgym.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzgym.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzgym.FLOAT),
    INT64_LIST_PACKED(37, 3, zzgym.LONG),
    UINT64_LIST_PACKED(38, 3, zzgym.LONG),
    INT32_LIST_PACKED(39, 3, zzgym.INT),
    FIXED64_LIST_PACKED(40, 3, zzgym.LONG),
    FIXED32_LIST_PACKED(41, 3, zzgym.INT),
    BOOL_LIST_PACKED(42, 3, zzgym.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzgym.INT),
    ENUM_LIST_PACKED(44, 3, zzgym.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzgym.INT),
    SFIXED64_LIST_PACKED(46, 3, zzgym.LONG),
    SINT32_LIST_PACKED(47, 3, zzgym.INT),
    SINT64_LIST_PACKED(48, 3, zzgym.LONG),
    GROUP_LIST(49, 2, zzgym.MESSAGE),
    MAP(50, 4, zzgym.VOID);

    private static final zzgxl[] zzZ;
    private final int zzab;

    static {
        zzgxl[] zzgxlVarArrValues = values();
        zzZ = new zzgxl[zzgxlVarArrValues.length];
        for (zzgxl zzgxlVar : zzgxlVarArrValues) {
            zzZ[zzgxlVar.zzab] = zzgxlVar;
        }
    }

    zzgxl(int i, int i2, zzgym zzgymVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzgymVar.zza();
        }
        if (i2 == 1) {
            zzgym zzgymVar2 = zzgym.VOID;
            zzgymVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
