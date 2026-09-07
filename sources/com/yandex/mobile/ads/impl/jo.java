package com.yandex.mobile.ads.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class jo implements sj1<Character> {

    static abstract class c extends a {
        private final String b = (String) rj1.a("CharMatcher.none()");

        c() {
        }

        public final String toString() {
            return this.b;
        }
    }

    public abstract boolean a(char c2);

    protected jo() {
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        rj1.b(i, length);
        while (i < length) {
            if (a(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static abstract class a extends jo {
        a() {
        }

        @Override // com.yandex.mobile.ads.impl.sj1
        @Deprecated
        public final boolean apply(Character ch) {
            return a(ch.charValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class d extends c {
        static final d c = new d();

        @Override // com.yandex.mobile.ads.impl.jo
        public final boolean a(char c2) {
            return false;
        }

        private d() {
        }

        @Override // com.yandex.mobile.ads.impl.jo
        public final int a(CharSequence charSequence, int i) {
            rj1.b(i, charSequence.length());
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends a {
        private final char b;

        b(char c) {
            this.b = c;
        }

        @Override // com.yandex.mobile.ads.impl.jo
        public final boolean a(char c) {
            return c == this.b;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.is('");
            char c = this.b;
            char[] cArr = new char[6];
            cArr[0] = AbstractJsonLexerKt.STRING_ESC;
            cArr[1] = AbstractJsonLexerKt.UNICODE_ESC;
            cArr[2] = 0;
            cArr[3] = 0;
            cArr[4] = 0;
            cArr[5] = 0;
            for (int i = 0; i < 4; i++) {
                cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
                c = (char) (c >> 4);
            }
            return sb.append(String.copyValueOf(cArr)).append("')").toString();
        }
    }
}
