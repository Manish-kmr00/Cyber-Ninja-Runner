package com.digitalturbine.ignite.authenticator.events;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public enum c {
    FAILED_INIT_ENCRYPTION("failed to init encryption"),
    FAILED_EXTRACT_ENCRYPTED_DATA("failed to extract encrypted data"),
    FAILED_STORE_ENCRYPTED_DATA("failed to store encrypted data"),
    IGNITE_SERVICE_UNAVAILABLE("Ignite service unavailable"),
    IGNITE_SERVICE_INVALID_SESSION("Invalid session token"),
    ONE_DT_EMPTY_ENTITY("received empty one dt from the service"),
    ONE_DT_AUTHENTICATOR_DESTROYED("authenticator already destroyed");

    private static final Map<String, c> CONSTANTS = new HashMap();
    private final String value;

    static {
        for (c cVar : values()) {
            CONSTANTS.put(cVar.value, cVar);
        }
    }

    c(String str) {
        this.value = str;
    }

    public final String a() {
        return this.value;
    }
}
