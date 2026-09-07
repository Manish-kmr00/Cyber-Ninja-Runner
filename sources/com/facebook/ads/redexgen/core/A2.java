package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi;
import com.google.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class A2 extends Handler {
    public static byte[] A04;
    public static String[] A05 = {"4udqyVbWZXJvSc0AlbflTWwfFOYrDaDf", "2YLZ8zu95yTf3T209", "2VJPb0Yp69Qd6undQokFBSWI7sS3NGkE", "Nq0QHebF7aCImjCS8", "WfWu3jj6ZslW8HMUv7JinXygwhejXyBb", "C4PEiJW5iwJTin2vYgbWRkUl1o", "sWvNSKALPWxj", "lJrPEKSWvzui7DJNo"};
    public static final String A06;
    public final Context A00;
    public final AudienceNetworkRemoteServiceApi.MessageHandler A01;
    public final AudienceNetworkRemoteServiceApi.PackageVerifier A02;
    public final C2645j9 A03;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        byte[] bArr = {-8, -16, -13, -5, -16, -14, -66, -53, -53, -56, -37, -59, -49, -37, -62, -47, -54, -54, -63, -56, -37, -56, -53, -61, -61, -63, -64, -13, -12, -14, -1, -31, -28, -1, -23, -28, -1, -21, -27, -7, 17, Ascii.DC2, Ascii.DLE, Ascii.GS, 0, 19, Ascii.FF, 2, 10, 3, Ascii.GS, 9, 3, Ascii.ETB, -48, -47, -49, -36, -48, -62, -49, -45, -58, -64, -62, -36, -62, -43, -47, -49, -66, -48, Ascii.NAK, Ascii.SYN, Ascii.DC4, 33, Ascii.NAK, 7, Ascii.DC4, Ascii.CAN, Ascii.VT, 5, 7, 33, Ascii.NAK, 6, Ascii.CR, 33, Ascii.CAN, 7, Ascii.DC4, Ascii.NAK, Ascii.VT, 17, Ascii.DLE};
        if (A05[5].length() == 23) {
            throw new RuntimeException();
        }
        A05[5] = "AJ3";
        A04 = bArr;
    }

    static {
        A04();
        A06 = A2.class.getSimpleName();
    }

    public A2(Context context, AudienceNetworkRemoteServiceApi.MessageHandler messageHandler, AudienceNetworkRemoteServiceApi.PackageVerifier packageVerifier) {
        super(Looper.getMainLooper());
        this.A00 = context;
        this.A02 = packageVerifier;
        this.A03 = C2645j9.A00();
        this.A01 = messageHandler;
    }

    public static Bundle A00() {
        Bundle bundle = new Bundle();
        bundle.putString(A03(72, 23, 92), A03(0, 6, 92));
        bundle.putString(A03(54, 18, 23), new JSONObject().toString());
        return bundle;
    }

    private C2816ly A01(C2812lu c2812lu, String str) {
        C2816ly c2816ly = new C2816ly(c2812lu, this.A03, str);
        c2816ly.A0G(c2812lu.A0B(), c2812lu.A07());
        return c2816ly;
    }

    private C2813lv A02(C2800li c2800li, String str) {
        C2813lv c2813lv = new C2813lv(c2800li, this.A03, str);
        c2813lv.A0J(c2800li.A05, c2800li.A02, c2800li.A08);
        return c2813lv;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) throws Throwable {
        String strVerifyPackage;
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A01 != null && this.A01.handleMessage(msg)) {
                return;
            }
            Messenger messenger = msg.replyTo;
            if (msg.what == 1) {
                if (messenger != null) {
                    C2645j9.A00().A07(2, null, A00(), messenger);
                    return;
                }
                return;
            }
            String callingAppPackage = msg.getData().getString(A03(27, 13, 58));
            if (callingAppPackage == null) {
                return;
            }
            C2699k1 c2699k1A05 = C13766p.A05(this.A00, callingAppPackage);
            c2699k1A05.A0F().AIY(msg.getData().getBoolean(A03(6, 21, 22), false));
            if (this.A02 != null) {
                strVerifyPackage = this.A02.verifyPackage(this.A00, msg, msg.getData().getString(A03(40, 14, 88)));
            } else {
                strVerifyPackage = null;
            }
            if (strVerifyPackage == null) {
                if (messenger != null) {
                    C2645j9.A00().A07(20, callingAppPackage, null, messenger);
                }
                c2699k1A05.A0F().AH2();
                return;
            }
            switch (msg.what) {
                case 1010:
                    if (messenger == null) {
                        return;
                    }
                    C14629z c14629zA04 = C2645j9.A00().A04(callingAppPackage);
                    if (c14629zA04 == null) {
                        c14629zA04 = C2645j9.A00().A05(callingAppPackage, messenger, strVerifyPackage);
                    }
                    C2812lu intAdModel = C3X.A04(c2699k1A05, msg.getData(), strVerifyPackage);
                    if (c14629zA04.A00 == null) {
                        c14629zA04.A00 = A01(intAdModel, callingAppPackage);
                    } else if (c14629zA04.A00 instanceof C2816ly) {
                        ((C2816ly) c14629zA04.A00).A0G(intAdModel.A0B(), intAdModel.A07());
                    }
                    C2645j9.A00().A07(1011, callingAppPackage, A00(), messenger);
                    return;
                case 1012:
                case 2002:
                    C2645j9.A00().A08(callingAppPackage);
                    return;
                case 2000:
                    if (messenger == null) {
                        return;
                    }
                    C14629z c14629zA05 = C2645j9.A00().A04(callingAppPackage);
                    if (c14629zA05 == null) {
                        c14629zA05 = C2645j9.A00().A05(callingAppPackage, messenger, strVerifyPackage);
                    }
                    C2800li c2800liA05 = C3X.A05(c2699k1A05, msg.getData(), strVerifyPackage);
                    if (c14629zA05.A00 == null) {
                        c14629zA05.A00 = A02(c2800liA05, callingAppPackage);
                    } else if (c14629zA05.A00 instanceof C2813lv) {
                        C2813lv c2813lv = (C2813lv) c14629zA05.A00;
                        String adId = c2800liA05.A05;
                        c2813lv.A0J(adId, c2800liA05.A02, c2800liA05.A08);
                    }
                    C2645j9.A00().A07(2001, callingAppPackage, A00(), messenger);
                    return;
                case 2003:
                    C3G c3gA03 = C2645j9.A00().A03(callingAppPackage);
                    if (c3gA03 instanceof C2813lv) {
                        RewardData rewardDataA01 = C3Y.A01(msg.getData());
                        C2813lv c2813lv2 = (C2813lv) c3gA03;
                        if (rewardDataA01 != null) {
                            c2813lv2.A0I(rewardDataA01);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            if (A05[5].length() == 23) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[6] = "nIV8RMn07Ah5";
            strArr[1] = "ZacTvu5dUvRq7FGBf";
            BQ.A00(th, this);
        }
    }
}
