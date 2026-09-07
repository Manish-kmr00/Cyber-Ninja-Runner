package net.pubnative.lite.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.BatteryManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.pubnative.lite.sdk.location.HyBidLocationManager;
import net.pubnative.lite.sdk.models.IdApp;
import net.pubnative.lite.sdk.models.IdBattery;
import net.pubnative.lite.sdk.models.IdDevice;
import net.pubnative.lite.sdk.models.IdGgl;
import net.pubnative.lite.sdk.models.IdLocation;
import net.pubnative.lite.sdk.models.IdModel;
import net.pubnative.lite.sdk.models.IdOs;
import net.pubnative.lite.sdk.models.IdPrivacy;
import net.pubnative.lite.sdk.models.IdUser;
import net.pubnative.lite.sdk.models.IdUserVendor;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.PNCrypto;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class VgiIdManager {
    private static final String KEY_VGI_ID = "VGI_id";
    private static final String PREFERENCES_VGI_ID = "net.pubnative.lite.vgiid";
    private static final String TAG = "VgiIdManager";
    private final String mAppToken;
    private final Context mContext;
    private final SharedPreferences mPreferences;

    public VgiIdManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPreferences = applicationContext.getSharedPreferences(PREFERENCES_VGI_ID, 0);
        this.mAppToken = HyBid.getAppToken();
    }

    public void init() {
        UserDataManager userDataManager = HyBid.getUserDataManager();
        DeviceInfo deviceInfo = HyBid.getDeviceInfo();
        HyBidLocationManager locationManager = HyBid.getLocationManager();
        IdModel idModel = new IdModel();
        idModel.apps = getApps(userDataManager, deviceInfo);
        idModel.device = getDevice(deviceInfo);
        idModel.users = getUsers(deviceInfo, locationManager);
        setVgiIdModel(idModel);
    }

    public IdModel getVgiIdModel() {
        JSONObject jSONObject;
        String string = this.mPreferences.getString(KEY_VGI_ID, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String strDecryptString = PNCrypto.decryptString(string, this.mAppToken);
            if (strDecryptString != null) {
                jSONObject = new JSONObject(strDecryptString);
            } else {
                jSONObject = new JSONObject();
            }
            return new IdModel(jSONObject);
        } catch (Exception e) {
            Logger.e(TAG, e.getMessage());
            HyBid.reportException(e);
            return null;
        }
    }

    public void setVgiIdModel(IdModel idModel) {
        if (idModel != null) {
            try {
                String strEncryptString = PNCrypto.encryptString(idModel.toJson().toString(), this.mAppToken);
                SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                editorEdit.putString(KEY_VGI_ID, strEncryptString);
                editorEdit.apply();
            } catch (Exception e) {
                Logger.e(TAG, e.getMessage());
                HyBid.reportException(e);
            }
        }
    }

    private List<IdApp> getApps(UserDataManager userDataManager, DeviceInfo deviceInfo) {
        ArrayList arrayList = new ArrayList();
        IdApp idApp = new IdApp();
        IdPrivacy idPrivacy = new IdPrivacy();
        idPrivacy.iab_ccpa = userDataManager.getIABUSPrivacyString();
        idPrivacy.tcfv2 = userDataManager.getIABGDPRConsentString();
        idPrivacy.lat = Boolean.valueOf(deviceInfo.limitTracking());
        idApp.bundle_id = HyBid.getBundleId();
        idApp.privacy = idPrivacy;
        arrayList.add(idApp);
        return arrayList;
    }

    private IdDevice getDevice(DeviceInfo deviceInfo) {
        IdDevice idDevice = new IdDevice();
        idDevice.id = Build.ID;
        IdOs idOs = new IdOs();
        idOs.name = "Android";
        idOs.version = deviceInfo.getOSVersion();
        IdBattery idBattery = new IdBattery();
        Long lValueOf = Long.valueOf(getBatteryCapacity(this.mContext));
        if (lValueOf.longValue() != -1) {
            idBattery.capacity = String.valueOf(lValueOf);
        }
        idBattery.charging = isBatteryCharging(this.mContext);
        idDevice.os = idOs;
        idDevice.manufacture = Build.MANUFACTURER;
        idDevice.model = Build.MODEL;
        idDevice.brand = Build.BRAND;
        idDevice.battery = idBattery;
        return idDevice;
    }

    private List<IdUser> getUsers(DeviceInfo deviceInfo, HyBidLocationManager hyBidLocationManager) {
        ArrayList arrayList = new ArrayList();
        IdUser idUser = new IdUser();
        IdUserVendor idUserVendor = new IdUserVendor();
        IdGgl idGgl = new IdGgl();
        idGgl.GAID = deviceInfo.getAdvertisingId();
        idUserVendor.GGL = idGgl;
        ArrayList arrayList2 = new ArrayList();
        IdLocation idLocation = new IdLocation();
        if (hyBidLocationManager != null && hyBidLocationManager.getUserLocation() != null) {
            Location userLocation = hyBidLocationManager.getUserLocation();
            idLocation.lat = String.format(Locale.ENGLISH, "%.2f", Double.valueOf(userLocation.getLatitude()));
            idLocation.lon = String.format(Locale.ENGLISH, "%.2f", Double.valueOf(userLocation.getLongitude()));
            idLocation.accuracy = String.valueOf(userLocation.getAccuracy());
            idLocation.ts = String.valueOf(userLocation.getTime());
        }
        arrayList2.add(idLocation);
        idUser.vendors = idUserVendor;
        idUser.locations = arrayList2;
        arrayList.add(idUser);
        return arrayList;
    }

    private long getBatteryCapacity(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return -1L;
        }
        Integer numValueOf = Integer.valueOf(batteryManager.getIntProperty(1));
        Integer numValueOf2 = Integer.valueOf(batteryManager.getIntProperty(4));
        if (numValueOf.intValue() == Integer.MIN_VALUE || numValueOf2.intValue() == Integer.MIN_VALUE) {
            return -1L;
        }
        return ((long) (numValueOf.intValue() / numValueOf2.intValue())) * 100;
    }

    private Boolean isBatteryCharging(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager != null) {
            return Boolean.valueOf(batteryManager.isCharging());
        }
        return null;
    }
}
