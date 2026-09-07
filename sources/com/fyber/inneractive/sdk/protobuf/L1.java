package com.fyber.inneractive.sdk.protobuf;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public enum L1 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(AbstractC3221s.b),
    ENUM(null),
    MESSAGE(null);

    private final Object defaultDefault;

    L1(Serializable serializable) {
        this.defaultDefault = serializable;
    }
}
