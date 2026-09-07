package com.smaato.sdk.core.network.interceptors;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.Headers;
import com.smaato.sdk.core.network.HttpNoResponseBodyException;
import com.smaato.sdk.core.network.Interceptor;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes12.dex */
public class LoggingInterceptor implements Interceptor {
    static final int MAX_BODY_LENGTH_BYTES = 2097152;
    private final Logger logger;
    private final boolean loggingEnabled;

    public LoggingInterceptor(Boolean bool, Logger logger) {
        this.loggingEnabled = bool.booleanValue();
        this.logger = logger;
    }

    @Override // com.smaato.sdk.core.network.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        if (this.loggingEnabled) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                Request requestLogRequestAndRestoreBody = logRequestAndRestoreBody(chain.request());
                jCurrentTimeMillis = System.currentTimeMillis();
                return logResponseAndRestoreBody(chain.proceed(requestLogRequestAndRestoreBody), System.currentTimeMillis() - jCurrentTimeMillis);
            } catch (Exception e) {
                if (e instanceof HttpNoResponseBodyException) {
                    logResponse((HttpNoResponseBodyException) e, System.currentTimeMillis() - jCurrentTimeMillis, chain.request());
                } else {
                    log(e);
                }
                throw e;
            }
        }
        return chain.proceed(chain.request());
    }

    private Request logRequestAndRestoreBody(Request request) {
        this.logger.info(LogDomain.NETWORK, "--> %s %s", request.method(), request.uri().toString());
        logHeaders(request.headers());
        return logAndRestoreBody(request);
    }

    private Response logResponseAndRestoreBody(Response response, long j) {
        this.logger.info(LogDomain.NETWORK, "<-- %d (%dms) %s", Integer.valueOf(response.responseCode()), Long.valueOf(j), response.request().uri().toString());
        logHeaders(response.headers());
        return logAndRestoreBody(response);
    }

    private void logResponse(HttpNoResponseBodyException httpNoResponseBodyException, long j, Request request) {
        Logger logger = this.logger;
        LogDomain logDomain = LogDomain.NETWORK;
        logger.info(logDomain, "<-- %d (%dms) %s", Integer.valueOf(httpNoResponseBodyException.getResponseCode()), Long.valueOf(j), request.uri().toString());
        logHeaders(httpNoResponseBodyException.getHeaders());
        this.logger.info(logDomain, "Error reading body: %s", httpNoResponseBodyException.getMessage());
    }

    private void log(Throwable th) {
        this.logger.error(LogDomain.NETWORK, th, "<-- HTTP FAILED", new Object[0]);
    }

    private void logHeaders(Headers headers) {
        for (String str : headers.names()) {
            this.logger.debug(LogDomain.NETWORK, "%s: %s", str, UByte$$ExternalSyntheticBackport0.m(", ", headers.values(str)));
        }
    }

    private Request logAndRestoreBody(Request request) {
        final byte[] intoByteArray;
        if (request.body() == null) {
            this.logger.debug(LogDomain.NETWORK, "No request body", new Object[0]);
            return request;
        }
        try {
            BodyLogger bodyLogger = new BodyLogger(this.logger);
            try {
                intoByteArray = readIntoByteArray(request.body());
                bodyLogger.write(intoByteArray);
                bodyLogger.close();
            } catch (Throwable th) {
                try {
                    bodyLogger.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            intoByteArray = new byte[0];
            this.logger.debug(LogDomain.NETWORK, th3, "--> Logging body failed", new Object[0]);
        }
        return request.buildUpon().body(new Request.Body() { // from class: com.smaato.sdk.core.network.interceptors.LoggingInterceptor$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.network.Request.Body
            public final void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(intoByteArray);
            }
        }).build();
    }

    private Response logAndRestoreBody(Response response) {
        byte[] intoByteArray;
        long jContentLength = response.body().contentLength();
        if (jContentLength > 2097152) {
            this.logger.debug(LogDomain.NETWORK, "Logging skipped for this body. Response body size %d bytes is too large to log. Max body limit to log is %d bytes", Long.valueOf(jContentLength), 2097152);
            return response;
        }
        try {
            InputStream inputStreamSource = response.body().source();
            try {
                BodyLogger bodyLogger = new BodyLogger(this.logger);
                try {
                    intoByteArray = readIntoByteArray(inputStreamSource);
                    if (intoByteArray.length < 2097152) {
                        bodyLogger.write(intoByteArray);
                    }
                    bodyLogger.close();
                    if (inputStreamSource != null) {
                        inputStreamSource.close();
                    }
                    return response.buildUpon().body(createBody(jContentLength, intoByteArray)).build();
                } catch (Throwable th) {
                    try {
                        bodyLogger.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (inputStreamSource != null) {
                    try {
                        inputStreamSource.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Throwable th5) {
            intoByteArray = new byte[0];
            this.logger.debug(LogDomain.NETWORK, th5, "<Logging body failed>", new Object[0]);
        }
    }

    private byte[] readIntoByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            int i = inputStream.read(bArr, 0, 16384);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private byte[] readIntoByteArray(Request.Body body) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        body.writeTo(byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private Response.Body createBody(final long j, final byte[] bArr) {
        return new Response.Body() { // from class: com.smaato.sdk.core.network.interceptors.LoggingInterceptor.1
            @Override // com.smaato.sdk.core.network.Response.Body
            public InputStream source() {
                return new ByteArrayInputStream(bArr);
            }

            @Override // com.smaato.sdk.core.network.Response.Body
            public long contentLength() {
                return j;
            }
        };
    }
}
