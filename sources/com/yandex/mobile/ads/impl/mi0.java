package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
public final class mi0 extends ly1 {
    private static final Pattern c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f9641a = ko.c.newDecoder();
    private final CharsetDecoder b = ko.b.newDecoder();

    @Override // com.yandex.mobile.ads.impl.ly1
    protected final g01 a(j01 j01Var, ByteBuffer byteBuffer) {
        String string;
        String str = null;
        try {
            string = this.f9641a.decode(byteBuffer).toString();
            this.f9641a.reset();
            byteBuffer.rewind();
        } catch (CharacterCodingException unused) {
            this.f9641a.reset();
            byteBuffer.rewind();
            try {
                string = this.b.decode(byteBuffer).toString();
                this.b.reset();
                byteBuffer.rewind();
            } catch (CharacterCodingException unused2) {
                this.b.reset();
                byteBuffer.rewind();
                string = null;
            } catch (Throwable th) {
                this.b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } catch (Throwable th2) {
            this.f9641a.reset();
            byteBuffer.rewind();
            throw th2;
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (string == null) {
            return new g01(new oi0(bArr, null, null));
        }
        Matcher matcher = c.matcher(string);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strB = fg.b(strGroup);
                strB.getClass();
                if (strB.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strB.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new g01(new oi0(bArr, str, str2));
    }
}
