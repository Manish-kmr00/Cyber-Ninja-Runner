package com.pubmatic.sdk.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class POBError {
    public static final int AD_ALREADY_SHOWN = 2001;
    public static final int AD_EXPIRED = 1011;
    public static final int AD_NOT_READY = 2002;
    public static final int AD_REQUEST_NOT_ALLOWED = 1012;
    public static final int CLIENT_SIDE_AUCTION_LOST = 3001;
    public static final int INTERNAL_ERROR = 1006;
    public static final int INVALID_CONFIG = 1013;
    public static final int INVALID_REQUEST = 1001;
    public static final int INVALID_RESPONSE = 1007;
    public static final int INVALID_REWARD_SELECTED = 5001;
    public static final int NETWORK_ERROR = 1003;
    public static final int NO_ADS_AVAILABLE = 1002;
    public static final int OPENWRAP_SIGNALING_ERROR = 1010;
    public static final int RENDER_ERROR = 1009;
    public static final int REQUEST_CANCELLED = 1008;
    public static final int REWARD_NOT_SELECTED = 5002;
    public static final int SERVER_ERROR = 1004;
    public static final int TIMEOUT_ERROR = 1005;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7551a;
    private String b;
    private Map c;

    public POBError(int i, String str) {
        this.f7551a = i;
        if (i == 2001) {
            this.b = "ALREADY_SHOWN: " + str;
        }
        if (i == 2002) {
            this.b = "NOT_READY: " + str;
            return;
        }
        if (i == 3001) {
            this.b = "CLIENT_SIDE_AUCTION_LOST: " + str;
            return;
        }
        if (i == 5001) {
            this.b = "INVALID_REWARD_SELECTED: " + str;
            return;
        }
        if (i == 5002) {
            this.b = "REWARD_NOT_SELECTED: " + str;
            return;
        }
        switch (i) {
            case 1001:
                this.b = "INVALID_REQUEST: " + str;
                break;
            case 1002:
                this.b = "NO_ADS_AVAILABLE: " + str;
                break;
            case 1003:
                this.b = "NETWORK_ERROR: " + str;
                break;
            case 1004:
                this.b = "SERVER_ERROR: " + str;
                break;
            case 1005:
                this.b = "TIMEOUT_ERROR: " + str;
                break;
            case 1006:
                this.b = "INTERNAL_ERROR: " + str;
                break;
            case 1007:
                this.b = "INVALID_RESPONSE: " + str;
                break;
            case 1008:
                this.b = "REQUEST_CANCELLED: " + str;
                break;
            case 1009:
                this.b = "RENDER_ERROR: " + str;
                break;
            case 1010:
                this.b = "OPENWRAP_SIGNALING_ERROR: " + str;
                break;
            case 1011:
                this.b = "AD_EXPIRED: " + str;
                break;
            case 1012:
                this.b = "AD_REQUEST_NOT_ALLOWED: " + str;
                break;
            default:
                this.b = str;
                break;
        }
    }

    public void addExtraInfo(String str, Object obj) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, obj);
    }

    public int getErrorCode() {
        return this.f7551a;
    }

    public String getErrorMessage() {
        return this.b;
    }

    public Map<String, Object> getExtraInfo() {
        return this.c;
    }

    @Deprecated
    public void setErrorCode(int i) {
        this.f7551a = i;
    }

    @Deprecated
    public void setErrorMessage(String str) {
        this.b = str;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.c = map;
    }

    public String toString() {
        return "POBError{errorCode=" + this.f7551a + ", errorMessage='" + this.b + "'}";
    }

    public Object getExtraInfo(String str) {
        Map map = this.c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
