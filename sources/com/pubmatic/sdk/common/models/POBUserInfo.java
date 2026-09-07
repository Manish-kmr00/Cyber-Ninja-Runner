package com.pubmatic.sdk.common.models;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class POBUserInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7588a;
    private Gender b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private final Map h = Collections.synchronizedMap(new HashMap());

    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7589a;

        Gender(String str) {
            this.f7589a = str;
        }

        public String getValue() {
            return this.f7589a;
        }
    }

    public void addDataProvider(POBDataProvider pOBDataProvider) {
        if (pOBDataProvider == null || POBUtils.isNullOrEmpty(pOBDataProvider.getName()) || pOBDataProvider.getSegments().isEmpty()) {
            POBLog.warn("POBUserInfo", POBCommonConstants.MSG_INVALID_DATA, "Data Provider");
            return;
        }
        String name = pOBDataProvider.getName();
        if (this.h.containsKey(name)) {
            POBLog.warn("POBUserInfo", POBCommonConstants.MSG_DUPLICATE_FIELD, "Data Provider", "provider name");
        } else {
            this.h.put(name, pOBDataProvider);
        }
    }

    public int getBirthYear() {
        return this.f7588a;
    }

    public String getCity() {
        return this.c;
    }

    public POBDataProvider getDataProvider(String str) {
        return (POBDataProvider) this.h.get(str);
    }

    public List<POBDataProvider> getDataProviders() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.h.entrySet()) {
            if (entry != null) {
                arrayList.add((POBDataProvider) entry.getValue());
            }
        }
        return arrayList;
    }

    public Gender getGender() {
        return this.b;
    }

    public String getKeywords() {
        return this.g;
    }

    public String getMetro() {
        return this.d;
    }

    public String getRegion() {
        return this.f;
    }

    public String getZip() {
        return this.e;
    }

    public void removeAllDataProviders() {
        this.h.clear();
    }

    public POBDataProvider removeDataProvider(String str) {
        return (POBDataProvider) this.h.remove(str);
    }

    public void setBirthYear(int i) {
        if (i > 0) {
            this.f7588a = i;
        }
    }

    public void setCity(String str) {
        this.c = str;
    }

    public void setGender(Gender gender) {
        this.b = gender;
    }

    public void setKeywords(String str) {
        this.g = str;
    }

    public void setMetro(String str) {
        this.d = str;
    }

    public void setRegion(String str) {
        this.f = str;
    }

    public void setZip(String str) {
        this.e = str;
    }
}
