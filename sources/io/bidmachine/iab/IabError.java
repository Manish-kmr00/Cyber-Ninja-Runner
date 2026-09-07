package io.bidmachine.iab;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public class IabError {
    public static final int ERROR_CODE_BAD_CONTENT = 3;
    public static final int ERROR_CODE_EXPIRED = 6;
    public static final int ERROR_CODE_INCORRECT_STATE = 4;
    public static final int ERROR_CODE_INTERNAL = 0;
    public static final int ERROR_CODE_NO_FILL = 7;
    public static final int ERROR_CODE_NO_NETWORK = 1;
    public static final int ERROR_CODE_NO_REQUIRED_ARGUMENTS = 2;
    public static final int ERROR_CODE_PLACEHOLDER_TIMEOUT = 5;
    public static final IabError NO_NETWORK = new IabError(1, "No internet connection");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12182a;
    private final String b;

    public IabError(int code, String message) {
        this.f12182a = code;
        this.b = message;
    }

    public static IabError badContent(String message) {
        return new IabError(3, message);
    }

    public static IabError expired(String message) {
        return new IabError(6, message);
    }

    public static IabError incorrectState(String message) {
        return new IabError(4, message);
    }

    public static IabError internal(String message) {
        return new IabError(0, message);
    }

    public static IabError noFIll(String message) {
        return new IabError(7, message);
    }

    public static IabError noRequiredArguments(String message) {
        return new IabError(2, message);
    }

    public static IabError placeholder(String message) {
        return new IabError(5, message);
    }

    public static IabError throwable(String internalMessage, Throwable throwable) {
        if (throwable != null) {
            try {
                StringBuilder sb = new StringBuilder(internalMessage);
                sb.append(" - ");
                sb.append(throwable.getClass().getName());
                String message = throwable.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    sb.append(": ");
                    sb.append(message);
                }
                return internal(sb.toString());
            } catch (Throwable unused) {
            }
        }
        return internal(internalMessage);
    }

    public int getCode() {
        return this.f12182a;
    }

    public String getMessage() {
        return this.b;
    }

    public String toString() {
        return String.format("(%s) %s", Integer.valueOf(this.f12182a), this.b);
    }
}
