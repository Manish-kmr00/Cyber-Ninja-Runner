package com.yandex.mobile.ads.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class tj1 {
    public static <T> sj1<T> a(sj1<? super T> sj1Var, sj1<? super T> sj1Var2) {
        sj1Var.getClass();
        sj1Var2.getClass();
        return new a(Arrays.asList(sj1Var, sj1Var2));
    }

    private static class a<T> implements sj1<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends sj1<? super T>> b;

        private a(List<? extends sj1<? super T>> list) {
            this.b = list;
        }

        @Override // com.yandex.mobile.ads.impl.sj1
        public final boolean apply(T t) {
            for (int i = 0; i < this.b.size(); i++) {
                if (!this.b.get(i).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode() + 306654252;
        }

        public final boolean equals(@CheckForNull Object obj) {
            if (obj instanceof a) {
                return this.b.equals(((a) obj).b);
            }
            return false;
        }

        public final String toString() {
            List<? extends sj1<? super T>> list = this.b;
            StringBuilder sb = new StringBuilder("Predicates.and(");
            boolean z = true;
            for (T t : list) {
                if (!z) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                sb.append(t);
                z = false;
            }
            return sb.append(')').toString();
        }
    }
}
