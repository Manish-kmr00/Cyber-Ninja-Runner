package com.pubmatic.sdk.video;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBTrackerHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class POBVastErrorHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBTrackerHandler f7784a;

    public POBVastErrorHandler(POBTrackerHandler pOBTrackerHandler) {
        this.f7784a = pOBTrackerHandler;
    }

    private boolean a(POBVastError pOBVastError) {
        return (pOBVastError == null || convertToPOBError(pOBVastError) == null) ? false : true;
    }

    public static POBError convertToPOBError(POBVastError pOBVastError) {
        int errorCode = pOBVastError.getErrorCode();
        if (errorCode != 200 && errorCode != 201 && errorCode != 405) {
            if (errorCode != 900) {
                switch (errorCode) {
                    case 100:
                    case 101:
                    case 102:
                        return new POBError(1007, pOBVastError.getErrorMessage());
                    default:
                        switch (errorCode) {
                            case 300:
                                break;
                            case 301:
                            case 304:
                                return new POBError(1005, pOBVastError.getErrorMessage());
                            default:
                                switch (errorCode) {
                                    case 400:
                                    case 403:
                                        break;
                                    case 401:
                                        break;
                                    case 402:
                                        return new POBError(1003, pOBVastError.getErrorMessage());
                                    default:
                                        switch (errorCode) {
                                            case 500:
                                            case 503:
                                                break;
                                            case 501:
                                            case 502:
                                                break;
                                            default:
                                                return null;
                                        }
                                        break;
                                }
                            case 302:
                            case 303:
                                return new POBError(1002, pOBVastError.getErrorMessage());
                        }
                        break;
                }
            }
            return new POBError(1006, pOBVastError.getErrorMessage());
        }
        return new POBError(1009, pOBVastError.getErrorMessage());
    }

    public void executeVastErrors(List<String> list, POBVastError pOBVastError) {
        executeVastErrorsWithMacros(list, null, pOBVastError, null);
    }

    public void executeVastErrorsWithMacros(List<String> list, Map<Object, Object> map, POBVastError pOBVastError, Map<String, String> map2) {
        POBLog.debug("POBVastErrorHandler", POBVideoLogConstants.MSG_ERROR_HANDLER_VAST_ERROR, pOBVastError.toString());
        if (list == null || list.isEmpty()) {
            POBLog.warn("POBVastErrorHandler", POBVideoLogConstants.MSG_ERROR_HANDLER_ERROR_EMPTY_TRACKER_URLS, new Object[0]);
            return;
        }
        if (!a(pOBVastError)) {
            POBLog.warn("POBVastErrorHandler", POBVideoLogConstants.MSG_ERROR_HANDLER_ERROR_EXECUTING_TRACKER, Integer.valueOf(pOBVastError.getErrorCode()));
            return;
        }
        if (map == null) {
            map = Collections.synchronizedMap(new HashMap(1));
        }
        map.put("[ERRORCODE]", "" + pOBVastError.getErrorCode());
        this.f7784a.handleTrackersForError(list, map, map2);
    }
}
