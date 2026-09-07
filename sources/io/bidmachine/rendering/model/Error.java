package io.bidmachine.rendering.model;

/* JADX INFO: loaded from: classes13.dex */
public class Error {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12409a;

    public Error(String message) {
        this.f12409a = message;
    }

    public static Error create(Throwable throwable) {
        String message = throwable.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        return new Error(message);
    }

    public String getMessage() {
        return this.f12409a;
    }

    public String toString() {
        return getMessage();
    }
}
