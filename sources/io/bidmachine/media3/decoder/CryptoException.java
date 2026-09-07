package io.bidmachine.media3.decoder;

/* JADX INFO: loaded from: classes10.dex */
public class CryptoException extends Exception {
    public final int errorCode;

    public CryptoException(int i, String str) {
        super(str);
        this.errorCode = i;
    }
}
