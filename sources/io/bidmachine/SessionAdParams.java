package io.bidmachine;

import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.models.ISessionAdParams;
import io.bidmachine.models.RequestParams;

/* JADX INFO: loaded from: classes13.dex */
public final class SessionAdParams extends RequestParams<SessionAdParams> implements ISessionAdParams<SessionAdParams> {
    private Integer sessionDuration;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    public SessionAdParams setSessionDuration(Integer num) {
        if (num == null || num.intValue() >= 0) {
            this.sessionDuration = num;
        } else {
            Logger.e("session duration shouldn't be negative");
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setImpressionCount(Integer num) {
        Logger.w("The method setImpressionCount is no longer supported and has no effect.");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setClickRate(Float f) {
        Logger.w("The method setClickRate is no longer supported and has no effect.");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setIsUserClickedOnLastAd(Boolean bool) {
        Logger.w("The method setIsUserClickedOnLastAd is no longer supported and has no effect.");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setCompletionRate(Float f) {
        Logger.w("The method setCompletionRate is no longer supported and has no effect.");
        return this;
    }

    @Override // io.bidmachine.models.RequestParams
    public void merge(SessionAdParams sessionAdParams) {
        this.sessionDuration = (Integer) Utils.oneOf(this.sessionDuration, sessionAdParams.sessionDuration);
    }

    void fillUserExtension(Struct.Builder builder) {
        if (this.sessionDuration != null) {
            builder.putFields(POBConstants.KEY_SESSION_DURATION, Value.newBuilder().setNumberValue(this.sessionDuration.intValue()).build());
        }
    }

    Integer getSessionDuration() {
        return this.sessionDuration;
    }

    void clear() {
        this.sessionDuration = null;
    }
}
