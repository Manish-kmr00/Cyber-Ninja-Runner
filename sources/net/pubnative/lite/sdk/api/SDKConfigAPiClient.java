package net.pubnative.lite.sdk.api;

import android.content.Context;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.models.AtomConfigResponse;
import net.pubnative.lite.sdk.network.PNHttpClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class SDKConfigAPiClient {
    String mAppToken;
    Context mContext;
    String url = "";
    private final Boolean ATOM_DEFAULT_VALUE = false;

    public interface AtomConfigListener {
        void onAtomValueFetched(Boolean bool);
    }

    public SDKConfigAPiClient(Context context) {
        this.mContext = context;
    }

    public void fetchConfig(final AtomConfigListener atomConfigListener) {
        String str = this.mAppToken;
        if (str == null || str.isEmpty() || this.mContext == null) {
            atomConfigListener.onAtomValueFetched(this.ATOM_DEFAULT_VALUE);
            return;
        }
        String str2 = String.format(this.url, this.mAppToken);
        this.url = str2;
        PNHttpClient.makeRequest(this.mContext, str2, null, null, false, true, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.api.SDKConfigAPiClient.1
            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onSuccess(String str3, Map<String, List<String>> map) {
                SDKConfigAPiClient.this.processStream(str3, atomConfigListener);
            }

            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onFailure(Throwable th) {
                atomConfigListener.onAtomValueFetched(SDKConfigAPiClient.this.ATOM_DEFAULT_VALUE);
            }
        });
    }

    public void processStream(String str, AtomConfigListener atomConfigListener) {
        try {
            processStream(new AtomConfigResponse(new JSONObject(str)), atomConfigListener);
        } catch (Error | Exception unused) {
            atomConfigListener.onAtomValueFetched(this.ATOM_DEFAULT_VALUE);
        }
    }

    public void processStream(AtomConfigResponse atomConfigResponse, AtomConfigListener atomConfigListener) {
        if (atomConfigResponse == null || atomConfigResponse.configs == null || atomConfigResponse.configs.app_level == null) {
            atomConfigListener.onAtomValueFetched(this.ATOM_DEFAULT_VALUE);
        } else if ("ok".equals(atomConfigResponse.status)) {
            fetchAtomConfigValue(atomConfigResponse, atomConfigListener);
        } else {
            atomConfigListener.onAtomValueFetched(this.ATOM_DEFAULT_VALUE);
        }
    }

    private void fetchAtomConfigValue(AtomConfigResponse atomConfigResponse, AtomConfigListener atomConfigListener) {
        atomConfigListener.onAtomValueFetched(atomConfigResponse.configs.isAtomEnabled());
    }

    public void setAppToken(String str) {
        this.mAppToken = str;
    }
}
