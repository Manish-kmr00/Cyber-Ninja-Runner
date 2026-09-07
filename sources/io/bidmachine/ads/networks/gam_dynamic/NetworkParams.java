package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import com.explorestack.protobuf.Struct;

/* JADX INFO: loaded from: classes4.dex */
public interface NetworkParams {
    Struct getExt(Context context);

    String getNetworkKey();

    String getNetworkName();
}
