package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.protobuf.sdk.App;

/* JADX INFO: loaded from: classes8.dex */
final class AppReleaseParams {
    AppReleaseParams() {
    }

    void build(Context context, com.explorestack.protobuf.adcom.Context.App.Builder builder) {
        builder.setRelease(buildReleaseInfo(context));
    }

    void build(Context context, App.Builder builder) {
        builder.setRelease(buildReleaseInfo(context));
    }

    private com.explorestack.protobuf.adcom.Context.App.Release buildReleaseInfo(Context context) {
        BuildInfo buildInfoObtain = BuildInfo.obtain(context);
        com.explorestack.protobuf.adcom.Context.App.Release.Builder builderNewBuilder = com.explorestack.protobuf.adcom.Context.App.Release.newBuilder();
        builderNewBuilder.setType(getBuildType(buildInfoObtain));
        String sha1Signature = buildInfoObtain.getSha1Signature(context);
        if (!TextUtils.isEmpty(sha1Signature)) {
            builderNewBuilder.setSignatureSHA1(sha1Signature);
        }
        String sha256Signature = buildInfoObtain.getSha256Signature(context);
        if (!TextUtils.isEmpty(sha256Signature)) {
            builderNewBuilder.setSignatureSHA256(sha256Signature);
        }
        return builderNewBuilder.build();
    }

    private String getBuildType(BuildInfo buildInfo) {
        if (buildInfo.isDebuggable()) {
            return "debug";
        }
        return "release";
    }
}
