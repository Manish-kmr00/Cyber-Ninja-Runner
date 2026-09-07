package com.facebook.ads.redexgen.core;

import android.view.View;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1781Nj implements SharedViewpointManager {
    public static boolean A08;
    public static byte[] A09;
    public static String[] A0A = {"BoSaZzMMCoBoab6kFzr2tWGVTni5", "Vk9jbaVPkS6rtGXBWv67wEIKcLe3GnXQ", "GJsVZyBqNYZRU43kGmqANe", "Uv9MZIJr", "GbPwVrzkFOEMxWNTB1P9oG5CUgrItJXy", "gWutc4DO", "1FOrRj10jdO8", "rnakDij4LZYpzXru71B"};
    public InterfaceC2953oW A00;
    public C2941oH A01;
    public final InterfaceC2966ol A03;
    public final InterfaceC2954oX A04;
    public final ViewpointQeConfig A05;
    public final ViewpointRegistrationHook A06;
    public final LinkedHashMap<Integer, Runnable> A07 = new LinkedHashMap<>();
    public final InterfaceC2953oW A02 = new C1782Nk(this);

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-28, 85, 84, 56, 75, 77, 79, 89, 90, 75, 88, -10, -11, -36, -11, -7, -20, -18, -16, -6, -5, -20, -7};
    }

    static {
        A04();
        A08 = false;
    }

    public C1781Nj(ViewpointQeConfig viewpointQeConfig, InterfaceC2966ol interfaceC2966ol, InterfaceC2954oX interfaceC2954oX, ViewpointRegistrationHook viewpointRegistrationHook) {
        this.A05 = viewpointQeConfig;
        this.A03 = interfaceC2966ol;
        this.A04 = interfaceC2954oX;
        this.A06 = viewpointRegistrationHook;
    }

    public static C1781Nj A01() {
        return new C1781Nj(new ViewpointQeConfig(), new C1784Nm(), null, null);
    }

    private void A05(AbstractC2957oa abstractC2957oa, InterfaceC2962of interfaceC2962of, InterfaceC1780Nh interfaceC1780Nh) {
        this.A01 = C2941oH.A00(this.A05, abstractC2957oa, interfaceC2962of, interfaceC1780Nh);
        if (0 != 0) {
            this.A01.A01(null);
        }
        this.A01.A02(this.A02);
        String[] strArr = A0A;
        if (strArr[4].charAt(11) == strArr[1].charAt(11)) {
            throw new RuntimeException();
        }
        A0A[7] = "2MhPhimmgHBptxasGUILH2";
    }

    private void A06(DspViewableNode dspViewableNode, C2963oi c2963oi) {
        C2941oH c2941oH = this.A01;
        if (c2941oH != null && dspViewableNode != null) {
            if (this.A05.A00 && c2963oi != null) {
                c2941oH.A04(dspViewableNode, c2963oi);
            } else {
                c2941oH.A03(dspViewableNode);
            }
            if (0 != 0) {
                throw new NullPointerException(A02(11, 12, 29));
            }
        }
    }

    private void A07(DspViewableNode dspViewableNode, C2963oi c2963oi, C2959oc c2959oc, ViewpointRegistrationHookConfigIdentifier viewpointRegistrationHookConfigIdentifier) {
        C2941oH c2941oH = this.A01;
        if (c2941oH != null && dspViewableNode != null && c2959oc != null) {
            if (this.A05.A00 && c2963oi != null) {
                c2959oc.A02 = dspViewableNode.hashCode() + A02(0, 1, 27) + c2959oc.A08 + c2963oi;
                c2941oH.A05(dspViewableNode, c2963oi, c2959oc);
            } else {
                c2941oH.A06(dspViewableNode, c2959oc);
            }
            if (0 != 0 && viewpointRegistrationHookConfigIdentifier != null) {
                throw new NullPointerException(A02(1, 10, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
            }
        }
    }

    public final void A08(View view) {
        A06(view != null ? ViewpointViewNode.A00(view) : null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oc != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public final void A09(View view, C2959oc<?, ?> c2959oc) {
        A07(view != null ? ViewpointViewNode.A00(view) : null, null, c2959oc, null);
    }

    public final void A0A(AbstractC2957oa abstractC2957oa, View view) {
        if (abstractC2957oa != null && view != null) {
            A05(abstractC2957oa, new C1783Nl(view, this.A03), new C2R(null));
        }
    }
}
