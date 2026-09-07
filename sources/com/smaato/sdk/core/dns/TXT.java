package com.smaato.sdk.core.dns;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class TXT extends Data {
    private final byte[] blob;
    private List characterStringsCache;
    private String textCache;

    private TXT(byte[] bArr) {
        this.blob = bArr;
    }

    public static TXT parse(DataInputStream dataInputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        dataInputStream.readFully(bArr);
        return new TXT(bArr);
    }

    public String getText() {
        if (this.textCache == null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = getCharacterStrings().iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                if (it.hasNext()) {
                    sb.append(" / ");
                }
            }
            this.textCache = sb.toString();
        }
        return this.textCache;
    }

    private List getCharacterStrings() {
        if (this.characterStringsCache == null) {
            List extents = getExtents();
            ArrayList arrayList = new ArrayList(extents.size());
            Iterator it = extents.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new String((byte[]) it.next(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new AssertionError(e);
                }
            }
            this.characterStringsCache = Collections.unmodifiableList(arrayList);
        }
        return this.characterStringsCache;
    }

    private List getExtents() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] bArr = this.blob;
            if (i >= bArr.length) {
                return arrayList;
            }
            int i2 = bArr[i] & 255;
            int i3 = i + 1;
            int i4 = i2 + i3;
            arrayList.add(Arrays.copyOfRange(bArr, i3, i4));
            i = i4;
        }
    }

    @Override // com.smaato.sdk.core.dns.Data
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.blob);
    }

    @Override // com.smaato.sdk.core.dns.Data
    public Record.Type getType() {
        return Record.Type.TXT;
    }

    public String toString() {
        return "\"" + getText() + "\"";
    }
}
