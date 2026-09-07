package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public enum zzhay {
    DOUBLE(zzhaz.DOUBLE, 1),
    FLOAT(zzhaz.FLOAT, 5),
    INT64(zzhaz.LONG, 0),
    UINT64(zzhaz.LONG, 0),
    INT32(zzhaz.INT, 0),
    FIXED64(zzhaz.LONG, 1),
    FIXED32(zzhaz.INT, 5),
    BOOL(zzhaz.BOOLEAN, 0),
    STRING(zzhaz.STRING, 2),
    GROUP(zzhaz.MESSAGE, 3),
    MESSAGE(zzhaz.MESSAGE, 2),
    BYTES(zzhaz.BYTE_STRING, 2),
    UINT32(zzhaz.INT, 0),
    ENUM(zzhaz.ENUM, 0),
    SFIXED32(zzhaz.INT, 5),
    SFIXED64(zzhaz.LONG, 1),
    SINT32(zzhaz.INT, 0),
    SINT64(zzhaz.LONG, 0);

    private final zzhaz zzt;

    zzhay(zzhaz zzhazVar, int i) {
        this.zzt = zzhazVar;
    }

    public final zzhaz zza() {
        return this.zzt;
    }
}
