package com.smaato.sdk.core.network;

import com.json.b9;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class SomaException extends IOException {
    private final Type type;

    public SomaException(Type type) {
        this(type, type.description);
    }

    public SomaException(Type type, String str) {
        super(str);
        this.type = type;
    }

    public SomaException(Type type, Throwable th) {
        super(th);
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public enum Type {
        NO_CONTENT("Server returns empty response."),
        BAD_REQUEST("Client sent invalid request."),
        AGE_RESTRICTED_USER("Age restricted user."),
        BAD_RESPONSE("Internal server error."),
        TIMEOUT_ERROR("Connectivity issue or timeout."),
        CREATIVE_EXPIRED("Creative already expired");

        private final String description;

        Type(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return b9.i.d + name() + "]: " + this.description;
        }
    }
}
