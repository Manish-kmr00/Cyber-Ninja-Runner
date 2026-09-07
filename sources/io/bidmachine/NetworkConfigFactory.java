package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.AdNetwork;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
class NetworkConfigFactory {
    private static final String KEY_FORMAT = "format";
    private static final String KEY_NETWORK = "network";
    private static final String KEY_AD_UNITS = "ad_units";
    private static final String[] PRIVATE_FIELDS = {"network", "format", KEY_AD_UNITS};

    NetworkConfigFactory() {
    }

    static NetworkConfig create(Context context, AdNetwork adNetwork) {
        NetworkConfig networkConfigCreate;
        if (context == null) {
            return null;
        }
        final String name = adNetwork.getName();
        if (TextUtils.isEmpty(name) || (networkConfigCreate = create(context, name, adNetwork.getCustomParamsMap())) == null) {
            return null;
        }
        for (AdNetwork.AdUnit adUnit : adNetwork.getAdUnitsList()) {
            AdsFormat adsFormatByRemoteName = AdsFormat.byRemoteName(adUnit.getAdFormat());
            if (adsFormatByRemoteName != null) {
                networkConfigCreate.withMediationConfig(adsFormatByRemoteName, adUnit.getCustomParamsMap());
            } else {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Network (%s) adUnit register fail: %s not provided", name, "format");
                    }
                });
            }
        }
        return networkConfigCreate;
    }

    static NetworkConfig create(Context context, JSONObject jSONObject) {
        final String string;
        if (context == null) {
            return null;
        }
        try {
            string = jSONObject.getString("network");
            try {
                final NetworkConfig networkConfigCreate = create(context, string, Utils.toMap(jSONObject));
                if (networkConfigCreate == null) {
                    return null;
                }
                JSONArray jSONArray = jSONObject.getJSONArray(KEY_AD_UNITS);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    AdsFormat adsFormatByRemoteName = AdsFormat.byRemoteName(jSONObject2.getString("format"));
                    if (adsFormatByRemoteName != null) {
                        networkConfigCreate.withMediationConfig(adsFormatByRemoteName, filterParams(Utils.toMap(jSONObject2)));
                    } else {
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda2
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                return String.format("Network (%s) adUnit register fail: %s not provided", string, "format");
                            }
                        });
                    }
                }
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda3
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Load network from json config completed successfully: %s", networkConfigCreate.getNetworkKey());
                    }
                });
                return networkConfigCreate;
            } catch (Throwable th) {
                th = th;
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda4
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Network (%s) load fail!", string);
                    }
                });
                Logger.w(th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            string = null;
        }
    }

    private static NetworkConfig create(Context context, final String str, Map<String, String> map) {
        NetworkAssetParams networkAssetParams = NetworkAssetManager.getNetworkAssetParams(context, str);
        if (networkAssetParams == null) {
            return null;
        }
        try {
            return (NetworkConfig) Class.forName(networkAssetParams.getClasspath()).getConstructor(Map.class).newInstance(filterParams(map));
        } catch (Throwable th) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Network (%s) load fail!", str);
                }
            });
            Logger.w(th);
            return null;
        }
    }

    private static Map<String, String> filterParams(Map<String, String> map) {
        if (map != null) {
            try {
                for (String str : PRIVATE_FIELDS) {
                    map.remove(str);
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }
}
