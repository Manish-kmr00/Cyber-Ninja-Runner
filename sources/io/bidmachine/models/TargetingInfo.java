package io.bidmachine.models;

import android.location.Location;
import io.bidmachine.utils.Gender;

/* JADX INFO: loaded from: classes9.dex */
public interface TargetingInfo {
    String getCity();

    String getCountry();

    Location getDeviceLocation();

    Gender getGender();

    String[] getKeywords();

    String getStoreUrl();

    Integer getUserAge();

    Integer getUserBirthdayYear();

    String getUserId();

    String getZip();

    Boolean isPaid();
}
