package com.google.zxing.datamatrix.encoder;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: loaded from: classes12.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, 205, 109, 39, 176, 21, 155, 197, 251, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 155, 21, 5, 172, 254, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 17, 138, 110, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 130, 250, 162, 181, 102, 120, 84, 179, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 95, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 31, 19, 38, 22, 153, 247, 105, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 2, 245, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 242, 8, 175, 95, 100, 9, 167, 105, Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 111, 57, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 172, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 96, 32, 117, 22, 238, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 23, 37, 90, 170, 205, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 92, 253, 225, 19}, new int[]{175, 9, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 238, 12, 17, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 208, 100, 29, 175, 170, 230, 192, Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, 235, 150, 159, 36, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 38, 200, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 54, 228, POBNativeConstants.POB_NATIVE_MAIN_IMG_H, Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 250, 106, 185, Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, 175, 64, 114, 71, 161, 44, 147, 6, 27, Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 86, 47, 11, 204}, new int[]{Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 136, 248, 180, 234, 197, 158, 177, 68, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 93, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 232, 96, 210, 231, 136, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i5, strCreateECCBlock.charAt(i6));
                    i5 += interleavedBlockCount;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            }
            if (iArr[i6] == i3) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
        }
        int[] iArr2 = FACTORS[i6];
        char[] cArr = new char[i3];
        for (int i7 = 0; i7 < i3; i7++) {
            cArr[i7] = 0;
        }
        for (int i8 = i; i8 < i + i2; i8++) {
            int i9 = i3 - 1;
            int iCharAt = cArr[i9] ^ charSequence.charAt(i8);
            while (i9 > 0) {
                if (iCharAt != 0 && (i5 = iArr2[i9]) != 0) {
                    char c = cArr[i9 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i9] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i5]) % 255] ^ c);
                } else {
                    cArr[i9] = cArr[i9 - 1];
                }
                i9--;
            }
            if (iCharAt != 0 && (i4 = iArr2[0]) != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i4]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            cArr2[i10] = cArr[(i3 - i10) - 1];
        }
        return String.valueOf(cArr2);
    }
}
