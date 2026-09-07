package com.moloco.sdk.internal.client_metrics_data;

/* JADX INFO: loaded from: classes12.dex */
public enum a {
    SDKInitAttempt("sdk_init_attempt"),
    SDKInitSuccess("sdk_init_success"),
    SDKInitFailure("sdk_init_failure"),
    SDKPerformInitAttempt("sdk_perform_init_attempt"),
    SDKFetchInitAttempt("sdk_fetch_init_attempt"),
    SDKInitCacheRead("sdk_init_cache_read"),
    SDKInitCacheWrite("sdk_init_cache_write"),
    SDKInitCacheClear("sdk_init_cache_clear"),
    CreateAd("create_ad"),
    LoadAdAttempt("load_ad_attempted"),
    LoadAdSuccess("load_ad_success"),
    LoadAdFailed("load_ad_failed"),
    NativeAdLoadAdAttempted("native_ad_load_attempted"),
    NativeLoadAd("native_ad_load"),
    BidTokenGetRequest("bid_token_get_request"),
    BidTokenGetResponse("bid_token_get_response"),
    BidTokenFetch("bid_token_fetch"),
    BidTokenDurationTimeoutOneSecond("bid_token_duration_crossed_1s"),
    BidTokenDurationTimeoutThreeSecond("bid_token_duration_crossed_3s"),
    ServerBidTokenFetch("sbt_fetch"),
    ServerBidTokenCached("sbt_cached"),
    ServerBidTokenApiFetch("sbt_api_fetch"),
    ServerBidTokenAsyncRefresh("sbt_async_fetch"),
    ClientBidTokenBuild("bid_token_build"),
    ClientBidTokenCached("cbt_cached"),
    ShowAdAttempt("show_ad_attempted"),
    ShowAdSuccess("show_ad_success"),
    ShowAdFailed("show_ad_failed"),
    AdClicked("ad_clicked"),
    CrashDetected("crash_detected");

    public final String F;

    a(String str) {
        this.F = str;
    }

    public final String b() {
        return this.F;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.F;
    }
}
