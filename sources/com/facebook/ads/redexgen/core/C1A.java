package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1A extends C14308s implements Comparable<C1A> {
    public static String[] A01 = {"ran8r3bbGDbR2a1gDWU5lb7Fgn", "dTmyrA7YFcKbYf0LrJoFfr67FcMx0hzr", "gSA52fXGv0ufdZsOQWejnsz81JMpf4s0", "giootV7fP1Iqlyf6PXDusp6fRB1OHnoA", "imEjrHyWcwPkTLW2AuZQ95pr6X1Uuep5", "LIUSRbO5m5uPiWM1rUqsC7oi7V", "uNuCmpHfD5iDt3eF8SqdNkuH99TMJuUk", "gON4nDwXsQTtFgUiIiqbZWnO9lKaP0yV"};
    public long A00;

    public C1A() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C1A c1a) {
        if (A05() != c1a.A05()) {
            return A05() ? 1 : -1;
        }
        long j = this.A01;
        String[] strArr = A01;
        if (strArr[1].charAt(22) != strArr[3].charAt(22)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[1] = "9Zy61pIRN8y5UXKYM9SXwx6UXCrUXVPt";
        strArr2[3] = "jKTAjuiy3tLIL6J9kTYSiU6gQwJ1dDyD";
        long j2 = j - c1a.A01;
        if (j2 == 0) {
            j2 = this.A00 - c1a.A00;
            if (j2 == 0) {
                return 0;
            }
        }
        return j2 > 0 ? 1 : -1;
    }
}
