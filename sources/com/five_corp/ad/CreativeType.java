package com.five_corp.ad;

/* JADX INFO: loaded from: classes11.dex */
public enum CreativeType {
    NOT_LOADED(0),
    MOVIE(1),
    IMAGE(2);

    public final int value;

    CreativeType(int i) {
        this.value = i;
    }

    public static CreativeType get(int i) throws com.five_corp.ad.internal.exception.a {
        for (CreativeType creativeType : values()) {
            if (creativeType.value == i) {
                return creativeType;
            }
        }
        throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.b1, i);
    }
}
