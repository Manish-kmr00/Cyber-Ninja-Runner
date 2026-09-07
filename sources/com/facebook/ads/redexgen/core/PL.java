package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PL {
    public static String[] A0B = {"FZUTEEo5yQEkrXuWchCqsTpObFXXea7X", "npFxmkkI3BwvG8sLAHLefWgraCGzL2hA", "7TNS65kycv8Lt", "gHtv5ojoh98zX2uiKsAZehQg5EIlXVbb", "k6Pcwm0oRadbgReCb358aHJYtAtn7n", "XbExd065htWUIbkauOrcStjr4mN0Tfuu", "avVMNcEJPyVjQcZdXWMfUdo8s8", "R1CMqfVcvF4s1ZZQ"};
    public final Uri A00;
    public final List<Integer> A01;

    @Deprecated
    public final List<Integer> A02;
    public final Map<String, String> A03;

    @Deprecated
    public final Map<String, String> A04;
    public final UUID A05;

    @Deprecated
    public final UUID A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final byte[] A0A;

    public PL(PK pk) {
        byte[] bArrCopyOf;
        AbstractC2388es.A08((pk.A04 && pk.A00 == null) ? false : true);
        this.A05 = (UUID) AbstractC2388es.A01(pk.A03);
        this.A06 = this.A05;
        this.A00 = pk.A00;
        this.A04 = pk.A02;
        this.A03 = pk.A02;
        this.A08 = pk.A05;
        this.A07 = pk.A04;
        this.A09 = pk.A06;
        this.A02 = pk.A01;
        this.A01 = pk.A01;
        if (pk.A07 != null) {
            bArrCopyOf = Arrays.copyOf(pk.A07, pk.A07.length);
        } else {
            bArrCopyOf = null;
        }
        this.A0A = bArrCopyOf;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PL)) {
            return false;
        }
        PL pl = (PL) obj;
        if (this.A05.equals(pl.A05) && AbstractC2471gE.A1E(this.A00, pl.A00)) {
            Map<String, String> map = this.A03;
            if (A0B[5].charAt(27) != '0') {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[3] = "AWDgeGskOpENxfufLCM5pOEKRHs2RpkB";
            strArr[0] = "Lr4kXKbqcuT6VTurUgiw2lAWMU0woPfT";
            if (AbstractC2471gE.A1E(map, pl.A03) && this.A08 == pl.A08 && this.A07 == pl.A07 && this.A09 == pl.A09 && this.A01.equals(pl.A01) && Arrays.equals(this.A0A, pl.A0A)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.A05.hashCode() * 31) + (this.A00 != null ? this.A00.hashCode() : 0)) * 31) + this.A03.hashCode();
        if (A0B[7].length() != 16) {
            throw new RuntimeException();
        }
        A0B[4] = "yLhRGssFNmeRbbeLC4ll21K0QJz7pb";
        return (((((((((iHashCode * 31) + (this.A08 ? 1 : 0)) * 31) + (this.A07 ? 1 : 0)) * 31) + (this.A09 ? 1 : 0)) * 31) + this.A01.hashCode()) * 31) + Arrays.hashCode(this.A0A);
    }
}
