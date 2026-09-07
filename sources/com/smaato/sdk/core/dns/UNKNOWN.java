package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.util.Objects;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public final class UNKNOWN extends Data {
    private final byte[] data;
    private final Record.Type type;

    private UNKNOWN(DataInputStream dataInputStream, int i, Record.Type type) throws IOException {
        Objects.requireNonNull(type);
        this.type = (Record.Type) Objects.requireNonNull(type);
        byte[] bArr = new byte[i];
        this.data = bArr;
        dataInputStream.readFully(bArr);
    }

    @Override // com.smaato.sdk.core.dns.Data
    public Record.Type getType() {
        return this.type;
    }

    @Override // com.smaato.sdk.core.dns.Data
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.data);
    }

    public static UNKNOWN parse(DataInputStream dataInputStream, int i, Record.Type type) throws IOException {
        return new UNKNOWN(dataInputStream, i, type);
    }
}
