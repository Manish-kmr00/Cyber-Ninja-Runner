package io.bidmachine;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
class NetworkAssetManager {
    private static final String BID_MACHINE_ASSET_FILE_EXTENSION = "bmnetwork";
    private static final String BID_MACHINE_ASSET_PATH = "bm_networks";
    private static final String KEY_CLASSPATH = "classpath";
    private static final String KEY_NAME = "name";
    private static final String KEY_SDK_VERSION = "sdk_version";
    private static final String KEY_VERSION = "version";
    static final Map<String, NetworkAssetParams> NETWORK_ASSET_PARAMS_MAP = new ConcurrentHashMap();

    NetworkAssetManager() {
    }

    static Map<String, NetworkAssetParams> getNetworkAssetParamsMap(Context context) {
        Map<String, NetworkAssetParams> map = NETWORK_ASSET_PARAMS_MAP;
        if (!map.isEmpty()) {
            return map;
        }
        findNetworks(context);
        return map;
    }

    static void findNetworks(Context context) {
        String[] list;
        if (NETWORK_ASSET_PARAMS_MAP.isEmpty()) {
            try {
                AssetManager assets = context.getAssets();
                if (assets == null || (list = assets.list(BID_MACHINE_ASSET_PATH)) == null) {
                    return;
                }
                for (String str : list) {
                    findNetwork(assets, str);
                }
            } catch (Exception unused) {
            }
        }
    }

    static NetworkAssetParams getNetworkAssetParams(Context context, String str) {
        Map<String, NetworkAssetParams> map = NETWORK_ASSET_PARAMS_MAP;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        try {
            AssetManager assets = context.getAssets();
            if (assets == null) {
                return null;
            }
            return findNetwork(assets, str + ".bmnetwork");
        } catch (Exception unused) {
            return null;
        }
    }

    private static NetworkAssetParams findNetwork(AssetManager assetManager, String str) {
        NetworkAssetParams networkAssetParamsCreateNetworkParams = createNetworkParams(assetManager, str);
        if (networkAssetParamsCreateNetworkParams != null) {
            NETWORK_ASSET_PARAMS_MAP.put(networkAssetParamsCreateNetworkParams.getName(), networkAssetParamsCreateNetworkParams);
        }
        return networkAssetParamsCreateNetworkParams;
    }

    private static NetworkAssetParams createNetworkParams(AssetManager assetManager, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String assetByNetworkName = readAssetByNetworkName(assetManager, str);
            if (TextUtils.isEmpty(assetByNetworkName)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(assetByNetworkName);
            String strOptString = jSONObject.optString("name");
            String strOptString2 = jSONObject.optString("version");
            String strOptString3 = jSONObject.optString(KEY_CLASSPATH);
            String strOptString4 = jSONObject.optString("sdk_version");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                return new NetworkAssetParams(strOptString, strOptString2, strOptString3, strOptString4);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String readAssetByNetworkName(AssetManager assetManager, String str) {
        try {
            return Utils.streamToString(assetManager.open("bm_networks/" + str));
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    static void reset() {
        NETWORK_ASSET_PARAMS_MAP.clear();
    }
}
