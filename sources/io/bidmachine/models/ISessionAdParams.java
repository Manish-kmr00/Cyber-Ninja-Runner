package io.bidmachine.models;

/* JADX INFO: loaded from: classes8.dex */
public interface ISessionAdParams<SelfType> {
    @Deprecated
    SelfType setClickRate(Float f);

    @Deprecated
    SelfType setCompletionRate(Float f);

    @Deprecated
    SelfType setImpressionCount(Integer num);

    @Deprecated
    SelfType setIsUserClickedOnLastAd(Boolean bool);

    SelfType setSessionDuration(Integer num);
}
