package net.pubnative.lite.sdk.vpaid.macros;

import android.location.Location;
import android.text.TextUtils;
import java.util.Locale;
import net.pubnative.lite.sdk.DeviceInfo;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.location.HyBidLocationManager;
import net.pubnative.lite.sdk.utils.EncodingUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ClientMacros {
    private static final String MACRO_CLIENT_UA = "[CLIENTUA]";
    private static final String MACRO_DEVICE_IP = "[DEVICEIP]";
    private static final String MACRO_DEVICE_UA = "[DEVICEUA]";
    private static final String MACRO_IFA = "[IFA]";
    private static final String MACRO_IFA_TYPE = "[IFATYPE]";
    private static final String MACRO_LAT_LONG = "[LATLONG]";
    private static final String MACRO_SERVER_SIDE = "[SERVERSIDE]";
    private static final String MACRO_SERVER_UA = "[SERVERUA]";
    private final String mClientUserAgent;
    private final DeviceInfo mDeviceInfo;
    private final String mDeviceUserAgent;
    private final HyBidLocationManager mLocationManager;

    public ClientMacros() {
        this(HyBid.getDeviceInfo(), HyBid.getLocationManager());
    }

    ClientMacros(DeviceInfo deviceInfo, HyBidLocationManager hyBidLocationManager) {
        this.mDeviceInfo = deviceInfo;
        this.mLocationManager = hyBidLocationManager;
        this.mClientUserAgent = EncodingUtils.urlEncode(String.format(Locale.ENGLISH, "%s/%s %s/%s", "HyBid", "3.3.0", "HyBid VAST Player", "3.3.0"));
        if (deviceInfo != null && deviceInfo.getUserAgent() != null && !TextUtils.isEmpty(deviceInfo.getUserAgent())) {
            this.mDeviceUserAgent = EncodingUtils.urlEncode(deviceInfo.getUserAgent());
        } else {
            this.mDeviceUserAgent = String.valueOf(-1);
        }
    }

    public String processUrl(String str) {
        return str.replace(MACRO_IFA, getIfa()).replace(MACRO_IFA_TYPE, getIfaType()).replace(MACRO_CLIENT_UA, getClientUA()).replace(MACRO_DEVICE_UA, getDeviceUA()).replace(MACRO_SERVER_SIDE, getServerSide()).replace(MACRO_LAT_LONG, getLocation());
    }

    private String getIfa() {
        DeviceInfo deviceInfo = this.mDeviceInfo;
        if (deviceInfo != null) {
            if (deviceInfo.limitTracking()) {
                return String.valueOf(-2);
            }
            if (TextUtils.isEmpty(this.mDeviceInfo.getAdvertisingId())) {
                return String.valueOf(-1);
            }
            return this.mDeviceInfo.getAdvertisingId();
        }
        return String.valueOf(-1);
    }

    private String getIfaType() {
        DeviceInfo deviceInfo = this.mDeviceInfo;
        if (deviceInfo != null) {
            if (deviceInfo.limitTracking()) {
                return String.valueOf(-2);
            }
            return "aaid";
        }
        return String.valueOf(-1);
    }

    private String getClientUA() {
        return this.mClientUserAgent;
    }

    private String getServerUA() {
        return String.valueOf(-1);
    }

    private String getDeviceUA() {
        return this.mDeviceUserAgent;
    }

    private String getServerSide() {
        return "0";
    }

    private String getDeviceIp() {
        return String.valueOf(-1);
    }

    private String getLocation() {
        HyBidLocationManager hyBidLocationManager = this.mLocationManager;
        if (hyBidLocationManager != null) {
            Location userLocation = hyBidLocationManager.getUserLocation();
            if (userLocation != null) {
                return String.format(Locale.ENGLISH, "%.2f,%.2f", Double.valueOf(userLocation.getLatitude()), Double.valueOf(userLocation.getLongitude()));
            }
            return String.valueOf(-1);
        }
        return String.valueOf(-1);
    }
}
