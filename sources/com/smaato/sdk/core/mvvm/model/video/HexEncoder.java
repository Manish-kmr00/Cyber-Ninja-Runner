package com.smaato.sdk.core.mvvm.model.video;

import com.google.common.base.Ascii;
import com.smaato.sdk.core.util.Objects;
import io.ktor.util.date.GMTDateParser;

/* JADX INFO: loaded from: classes3.dex */
public class HexEncoder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    public String encodeHexString(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'data' specified as non-null is null");
        }
        Objects.requireNonNull(bArr);
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b & 240) >>> 4];
            i += 2;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }
}
