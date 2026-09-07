package com.ogury.ad.internal;

import com.mbridge.msdk.foundation.tools.SameMD5;
import com.ogury.core.internal.IntegrationLogger;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes13.dex */
public final class x3 {
    public static String a(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            Charset charsetForName = Charset.forName("US-ASCII");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = s.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes, 0, s.length());
            byte[] bArrDigest = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, bArrDigest);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%0" + (bArrDigest.length << 1) + VastAttributes.HORIZONTAL_POSITION, Arrays.copyOf(new Object[]{bigInteger}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (NoSuchAlgorithmException e) {
            IntegrationLogger.e(e);
            return "";
        }
    }
}
