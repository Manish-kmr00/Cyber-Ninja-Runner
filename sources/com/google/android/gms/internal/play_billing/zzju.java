package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
public enum zzju {
    DOUBLE(zzjv.DOUBLE, 1),
    FLOAT(zzjv.FLOAT, 5),
    INT64(zzjv.LONG, 0),
    UINT64(zzjv.LONG, 0),
    INT32(zzjv.INT, 0),
    FIXED64(zzjv.LONG, 1),
    FIXED32(zzjv.INT, 5),
    BOOL(zzjv.BOOLEAN, 0),
    STRING(zzjv.STRING, 2),
    GROUP(zzjv.MESSAGE, 3),
    MESSAGE(zzjv.MESSAGE, 2),
    BYTES(zzjv.BYTE_STRING, 2),
    UINT32(zzjv.INT, 0),
    ENUM(zzjv.ENUM, 0),
    SFIXED32(zzjv.INT, 5),
    SFIXED64(zzjv.LONG, 1),
    SINT32(zzjv.INT, 0),
    SINT64(zzjv.LONG, 0);

    private final zzjv zzt;

    zzju(zzjv zzjvVar, int i) {
        this.zzt = zzjvVar;
    }

    public final zzjv zza() {
        return this.zzt;
    }
}
