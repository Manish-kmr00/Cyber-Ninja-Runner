package com.facebook.ads.redexgen.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import com.facebook.ads.internal.util.common.FbValidationUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3M {
    public static byte[] A00;
    public static String[] A01 = {"NpBoDzCQyjOF8OFx9MsnsgXANanqzzj6", "RSaml0mwJ5MGBXbUX4Y7eJ496TcnwqpH", "O6M6", "HC1y", "xJAb", "6P21Vz3Cvscq5f42i51asuNZrA3r2siu", "D2rYJRkohSsxhH", "5Vn2BbDuwzZpkNg8pcGLkugAGTBH17kk"};
    public static final String A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Base64.padSymbol, 32, 32, 32, 48, 48, 48, 48, 48, 48, 48, 48, 48, 33, 33, 33, 33, 33, 33, 33, 33, 49, 49, 49, 44, 78, 101, 98, 104, 101, 98, 107, 44, 120, 99, 44, 127, 105, 126, 122, 101, 111, 105, 44, 127, 121, 111, 111, 105, 127, 127, 44, 49, 44, 44, 85, 66, 89, 83, 91, 82, 72, 82, 79, 67, 69, 86, 68, 72, 92, 82, 78, 73, 78, 72, 69, 73, 95, 72, 76, 83, 89, 95, 69, 95, 66, 78, 72, 91, 73, Ascii.DC2, Ascii.NAK, 19, Ascii.RS, Ascii.DC2, 4, 19, Ascii.ETB, 8, 2, 4, Ascii.RS, Ascii.DC2, 5, 10, Ascii.RS, Ascii.ETB, 4, 19, Ascii.DC2, 8, Ascii.SO, Ascii.SI, 77, 65, 67, 0, 72, 79, 77, 75, 76, 65, 65, 69, 0, 79, 74, 93, 0, 71, SignedBytes.MAX_POWER_OF_TWO, 90, 75, 92, SignedBytes.MAX_POWER_OF_TWO, 79, 66, 0, 71, 94, 77, 0, 111, 91, 74, 71, 75, SignedBytes.MAX_POWER_OF_TWO, 77, 75, 96, 75, 90, 89, 65, 92, 69, 124, 75, 67, 65, 90, 75, 125, 75, 92, 88, 71, 77, 75, Ascii.US, 19, 17, 82, Ascii.SUB, Ascii.GS, Ascii.US, Ascii.EM, Ascii.RS, 19, 19, Ascii.ETB, 82, Ascii.ETB, Ascii.GS, 8, Ascii.GS, Ascii.DC2, Ascii.GS};
    }

    static {
        A01();
        A02 = C3M.class.getSimpleName();
    }

    public static void A02(C2698k0 c2698k0, Message message) {
        Bundle bundle = message.getData().getBundle(A00(55, 17, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
        if (bundle != null) {
            AnonymousClass92.A05(c2698k0, bundle.getString(A00(90, 23, 32)), bundle.getString(A00(72, 18, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE)));
        }
    }

    public static boolean A03(Context context, String str) {
        PackageManager packageManager;
        if (!A00(171, 19, 29).equals(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            boolean validationPassed = FbValidationUtils.isFbSigningCertificateValid(FbValidationUtils.getSigningCertificate(packageManager.getPackageInfo(str, 64)));
            return validationPassed;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0037  */
    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a1  */
    public static boolean A04(C2698k0 c2698k0, boolean z, ServiceConnection serviceConnection) {
        boolean forceBypassValidation;
        boolean forceBypassValidation2;
        boolean z2 = false;
        if (c2698k0.A05().AAD()) {
            if (!z) {
                boolean zA1W = C14499m.A1W(c2698k0);
                if (A01[1].charAt(26) == '5') {
                    throw new RuntimeException();
                }
                A01[7] = "wVoKdL5DefY3vFtz3wgH19EGFsYG1twM";
                if (!zA1W) {
                    forceBypassValidation = false;
                }
            }
            forceBypassValidation = true;
        } else {
            forceBypassValidation = false;
        }
        if (forceBypassValidation) {
            forceBypassValidation2 = true;
        } else {
            boolean forceBypassValidation3 = A03(c2698k0, AbstractC14529p.A04(z));
            if (forceBypassValidation3) {
                forceBypassValidation2 = true;
            } else {
                forceBypassValidation2 = false;
            }
        }
        if (!forceBypassValidation2) {
            return false;
        }
        Intent intent = new Intent();
        if (z) {
            z2 = true;
        } else {
            boolean forceBypassValidation4 = c2698k0.A05().AAD();
            if (forceBypassValidation4) {
                boolean forceBypassValidation5 = C14499m.A1W(c2698k0);
                if (forceBypassValidation5) {
                    z2 = true;
                }
            }
        }
        boolean zBindService = c2698k0.bindService(intent.setComponent(new ComponentName(AbstractC14529p.A04(z2), A00(113, 58, 79))), serviceConnection, 1);
        boolean forceBypassValidation6 = c2698k0.A05().AAD();
        if (forceBypassValidation6) {
            String str = A00(13, 42, 109) + zBindService + A00(0, 13, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        }
        return zBindService;
    }
}
