package net.pubnative.lite.sdk.utils.string;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes10.dex */
public abstract class CodePointTranslator extends CharSequenceTranslator {
    public abstract boolean translate(int i, Writer writer) throws IOException;

    @Override // net.pubnative.lite.sdk.utils.string.CharSequenceTranslator
    public final int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        return translate(Character.codePointAt(charSequence, i), writer) ? 1 : 0;
    }
}
