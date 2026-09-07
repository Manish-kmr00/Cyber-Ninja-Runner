package com.smaato.sdk.core.mvvm.model;

import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.ad.Expiration;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.network.Response;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.HeaderValueUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdResponseParser {
    protected final AdType adType;
    protected final HeaderValueUtils headerValueUtils;

    protected abstract AdResponse parseResponse(AdResponse.Builder builder, String str, long j) throws IOException;

    public AdResponseParser(AdType adType, HeaderValueUtils headerValueUtils) {
        this.headerValueUtils = headerValueUtils;
        this.adType = adType;
    }

    public AdResponse parseSomaResponse(Response response) throws IOException {
        return parseResponse(initializeAdResponseBuilder(response), getJsonFromBody(response), this.headerValueUtils.getTtl(response.headers()));
    }

    public AdResponse parseUbBid(String str, ImpressionCountingType impressionCountingType, Expiration expiration, String str2, String str3, String str4) throws IOException {
        if (str == null) {
            throw new NullPointerException("'sessionId' specified as non-null is null");
        }
        if (impressionCountingType == null) {
            throw new NullPointerException("'impressionCountingType' specified as non-null is null");
        }
        if (expiration == null) {
            throw new NullPointerException("'expiration' specified as non-null is null");
        }
        if (str2 == null) {
            throw new NullPointerException("'markup' specified as non-null is null");
        }
        long remainingTime = expiration.getRemainingTime();
        return parseResponse(AdResponse.builder().setSessionId(str).setImpressionCountingType(impressionCountingType).setBundleId(str4).setTtlMs(Long.valueOf(remainingTime)).setAdType(this.adType).setSci(str3), str2, remainingTime);
    }

    private String getJsonFromBody(Response response) throws IOException {
        String charSet = this.headerValueUtils.getCharSet(response.headers());
        if (charSet == null) {
            throw new SomaException(SomaException.Type.BAD_RESPONSE, "No char set in response");
        }
        String str = new String(getBytes(response.body().source()), charSet);
        if (str.isEmpty()) {
            throw new SomaException(SomaException.Type.NO_CONTENT, "Ad response is empty");
        }
        return str;
    }

    private AdResponse.Builder initializeAdResponseBuilder(Response response) {
        return AdResponse.builder().setSessionId(this.headerValueUtils.retrieveSessionId(response.headers())).setSci(this.headerValueUtils.retrieveSci(response.headers())).setImpressionCountingType(this.headerValueUtils.retrieveImpressionType(response.headers())).setBundleId(this.headerValueUtils.retrieveBundleId(response.headers())).setTtlMs(Long.valueOf(this.headerValueUtils.getTtl(response.headers()))).setAdType(this.adType);
    }

    private byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65535];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static class ParsingException extends IOException {
        public ParsingException(String str, Throwable th) {
            super(str, th);
        }
    }
}
