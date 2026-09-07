package com.facebook.ads.redexgen.core;

import com.google.common.base.ElementTypesAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public final class C2596iK {
    public final int A00;
    public final AbstractC1814Os A01;
    public final InterfaceC2595iJ A02;
    public final boolean A03;

    public C2596iK(InterfaceC2595iJ strategy) {
        this(strategy, false, AbstractC1814Os.A03(), Integer.MAX_VALUE);
    }

    public C2596iK(InterfaceC2595iJ strategy, boolean omitEmptyStrings, AbstractC1814Os trimmer, int limit) {
        this.A02 = strategy;
        this.A03 = omitEmptyStrings;
        this.A01 = trimmer;
        this.A00 = limit;
    }

    public static C2596iK A02(char separator) {
        return A03(AbstractC1814Os.A02(separator));
    }

    public static C2596iK A03(final AbstractC1814Os separatorMatcher) {
        AbstractC2589iD.A04(separatorMatcher);
        return new C2596iK(new C1811Op(separatorMatcher));
    }

    private Iterator<String> A04(CharSequence sequence) {
        return this.A02.AAa(this, sequence);
    }

    public final List<String> A06(CharSequence sequence) {
        AbstractC2589iD.A04(sequence);
        Iterator<String> itA04 = A04(sequence);
        List<String> result = new ArrayList<>();
        while (itA04.hasNext()) {
            result.add(itA04.next());
        }
        return Collections.unmodifiableList(result);
    }
}
