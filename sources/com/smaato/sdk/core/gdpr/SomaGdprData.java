package com.smaato.sdk.core.gdpr;

import com.smaato.sdk.core.locationaware.LocationAware;
import com.smaato.sdk.core.util.Objects;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public class SomaGdprData {
    private final String consentString;
    private final int gdprVersion;
    private final LocationAware locationAware;
    private final EnumMap piiParamToConsentMap;
    private final SubjectToGdpr subjectToGdpr;

    SomaGdprData(SubjectToGdpr subjectToGdpr, String str, EnumMap<PiiParam, Boolean> enumMap, LocationAware locationAware, int i) {
        this.subjectToGdpr = (SubjectToGdpr) Objects.requireNonNull(subjectToGdpr, "subjectToGdpr must not be null for SomaGdprData::new");
        this.consentString = (String) Objects.requireNonNull(str, "consentString must not be null for SomaGdprData::new");
        EnumMap enumMap2 = new EnumMap((EnumMap) Objects.requireNonNull(enumMap, "piiParamToConsentMap must not be null for SomaGdprData::new"));
        this.piiParamToConsentMap = enumMap2;
        this.locationAware = locationAware;
        this.gdprVersion = i;
        Iterator it = enumMap2.entrySet().iterator();
        while (it.hasNext()) {
            if (((Map.Entry) it.next()).getValue() == null) {
                throw new IllegalArgumentException("piiParamToConsentMap must not contain null value for SomaGdprData::new");
            }
        }
    }

    public SubjectToGdpr getSubjectToGdpr() {
        return this.subjectToGdpr;
    }

    public Boolean isGdprEnabled() {
        SubjectToGdpr subjectToGdpr = this.subjectToGdpr;
        if (subjectToGdpr == SubjectToGdpr.CMP_GDPR_UNKNOWN) {
            return Boolean.valueOf(this.locationAware.isConsentCountry());
        }
        return Boolean.valueOf(subjectToGdpr == SubjectToGdpr.CMP_GDPR_ENABLED);
    }

    public String getConsentString() {
        return this.consentString;
    }

    public boolean isUsageAllowedFor(PiiParam piiParam) {
        return Objects.equals(this.piiParamToConsentMap.get(piiParam), Boolean.TRUE);
    }

    public int getGdprVersion() {
        return this.gdprVersion;
    }

    public String toString() {
        return "SomaGdprData{subjectToGdpr=" + this.subjectToGdpr + ", consentString='" + this.consentString + "', piiParamToConsentMap=" + this.piiParamToConsentMap + AbstractJsonLexerKt.END_OBJ;
    }
}
