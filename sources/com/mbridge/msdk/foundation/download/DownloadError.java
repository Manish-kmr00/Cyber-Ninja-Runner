package com.mbridge.msdk.foundation.download;

/* JADX INFO: loaded from: classes8.dex */
public class DownloadError {
    private Exception exception;

    public DownloadError(Exception exc) {
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }
}
