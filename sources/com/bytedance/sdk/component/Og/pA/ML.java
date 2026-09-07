package com.bytedance.sdk.component.Og.pA;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ML extends Sn {
    List<String> Og;
    List<String> pA;

    ML(List<String> list, List<String> list2) {
        this.pA = list;
        this.Og = list2;
    }

    public static final class pA {
        private final List<String> pA = new ArrayList();
        private final List<String> Og = new ArrayList();

        public pA pA(String str, String str2) {
            this.pA.add(str);
            this.Og.add(str2);
            return this;
        }

        public ML pA() {
            return new ML(this.pA, this.Og);
        }
    }
}
