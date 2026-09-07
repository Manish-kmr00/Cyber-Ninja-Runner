package com.smaato.sdk.core.mvvm.model.video;

import com.smaato.sdk.core.util.Objects;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public class Md5Digester {
    private static final String MD_5_DIGEST_NAME = "MD5";
    private final Charset charset;
    private final HexEncoder hexEncoder;

    public Md5Digester(Charset charset, HexEncoder hexEncoder) {
        this.charset = (Charset) Objects.requireNonNull(charset);
        this.hexEncoder = (HexEncoder) Objects.requireNonNull(hexEncoder);
    }

    public String md5Hex(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("'data' specified as non-null is null");
        }
        Objects.requireNonNull(str);
        return this.hexEncoder.encodeHexString(getMd5Digest().digest(str.getBytes(this.charset)));
    }

    private synchronized MessageDigest getMd5Digest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5");
    }
}
