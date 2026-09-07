package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
public enum zzhc {
    DOUBLE(0, 1, zzhs.DOUBLE),
    FLOAT(1, 1, zzhs.FLOAT),
    INT64(2, 1, zzhs.LONG),
    UINT64(3, 1, zzhs.LONG),
    INT32(4, 1, zzhs.INT),
    FIXED64(5, 1, zzhs.LONG),
    FIXED32(6, 1, zzhs.INT),
    BOOL(7, 1, zzhs.BOOLEAN),
    STRING(8, 1, zzhs.STRING),
    MESSAGE(9, 1, zzhs.MESSAGE),
    BYTES(10, 1, zzhs.BYTE_STRING),
    UINT32(11, 1, zzhs.INT),
    ENUM(12, 1, zzhs.ENUM),
    SFIXED32(13, 1, zzhs.INT),
    SFIXED64(14, 1, zzhs.LONG),
    SINT32(15, 1, zzhs.INT),
    SINT64(16, 1, zzhs.LONG),
    GROUP(17, 1, zzhs.MESSAGE),
    DOUBLE_LIST(18, 2, zzhs.DOUBLE),
    FLOAT_LIST(19, 2, zzhs.FLOAT),
    INT64_LIST(20, 2, zzhs.LONG),
    UINT64_LIST(21, 2, zzhs.LONG),
    INT32_LIST(22, 2, zzhs.INT),
    FIXED64_LIST(23, 2, zzhs.LONG),
    FIXED32_LIST(24, 2, zzhs.INT),
    BOOL_LIST(25, 2, zzhs.BOOLEAN),
    STRING_LIST(26, 2, zzhs.STRING),
    MESSAGE_LIST(27, 2, zzhs.MESSAGE),
    BYTES_LIST(28, 2, zzhs.BYTE_STRING),
    UINT32_LIST(29, 2, zzhs.INT),
    ENUM_LIST(30, 2, zzhs.ENUM),
    SFIXED32_LIST(31, 2, zzhs.INT),
    SFIXED64_LIST(32, 2, zzhs.LONG),
    SINT32_LIST(33, 2, zzhs.INT),
    SINT64_LIST(34, 2, zzhs.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzhs.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzhs.FLOAT),
    INT64_LIST_PACKED(37, 3, zzhs.LONG),
    UINT64_LIST_PACKED(38, 3, zzhs.LONG),
    INT32_LIST_PACKED(39, 3, zzhs.INT),
    FIXED64_LIST_PACKED(40, 3, zzhs.LONG),
    FIXED32_LIST_PACKED(41, 3, zzhs.INT),
    BOOL_LIST_PACKED(42, 3, zzhs.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzhs.INT),
    ENUM_LIST_PACKED(44, 3, zzhs.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzhs.INT),
    SFIXED64_LIST_PACKED(46, 3, zzhs.LONG),
    SINT32_LIST_PACKED(47, 3, zzhs.INT),
    SINT64_LIST_PACKED(48, 3, zzhs.LONG),
    GROUP_LIST(49, 2, zzhs.MESSAGE),
    MAP(50, 4, zzhs.VOID);

    private static final zzhc[] zzZ;
    private final int zzab;

    static {
        zzhc[] zzhcVarArrValues = values();
        zzZ = new zzhc[zzhcVarArrValues.length];
        for (zzhc zzhcVar : zzhcVarArrValues) {
            zzZ[zzhcVar.zzab] = zzhcVar;
        }
    }

    zzhc(int i, int i2, zzhs zzhsVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzhsVar.zza();
        }
        if (i2 == 1) {
            zzhs zzhsVar2 = zzhs.VOID;
            zzhsVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
