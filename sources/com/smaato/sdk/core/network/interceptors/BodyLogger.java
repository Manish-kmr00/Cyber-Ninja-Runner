package com.smaato.sdk.core.network.interceptors;

import android.util.Base64;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes12.dex */
public class BodyLogger extends OutputStream {
    private final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    private boolean isAscii = true;
    private boolean isBlankOnly = true;
    private final Logger logger;

    public BodyLogger(Logger logger) {
        this.logger = logger;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.byteStream.write(i);
        this.isAscii &= i >= 31 && i <= 127;
        this.isBlankOnly &= i == 32;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        for (byte b : bArr) {
            write(b);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] byteArray = this.byteStream.toByteArray();
        if (byteArray.length == 0 || this.isBlankOnly) {
            this.logger.debug(LogDomain.NETWORK, "<Empty body>", new Object[0]);
        } else {
            if (this.isAscii) {
                this.logger.debug(LogDomain.NETWORK, "Body (%d bytes):", Integer.valueOf(byteArray.length));
            } else {
                this.logger.debug(LogDomain.NETWORK, "Base64 Encoded Body (%d bytes):", Integer.valueOf(byteArray.length));
            }
            this.logger.debug(LogDomain.NETWORK, this.isAscii ? new String(byteArray) : Base64.encodeToString(byteArray, 2), new Object[0]);
        }
        super.close();
    }
}
