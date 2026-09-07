package com.smaato.sdk.core.gdpr;

import com.smaato.sdk.core.locationaware.LocationAware;
import com.smaato.sdk.core.util.Objects;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes3.dex */
public final class SomaGdprV2Utils implements SomaGdprUtils {
    private final LocationAware locationAware;

    SomaGdprV2Utils(LocationAware locationAware) {
        this.locationAware = locationAware;
    }

    @Override // com.smaato.sdk.core.gdpr.SomaGdprUtils
    public SomaGdprData createSomaGdprData(CmpData cmpData) {
        Objects.requireNonNull(cmpData, "cmpData must not be null for SomaGdprData::from");
        CmpV2Data cmpV2Data = (CmpV2Data) cmpData;
        SubjectToGdpr subjectToGdpr = cmpV2Data.getSubjectToGdpr();
        String consentString = cmpV2Data.getConsentString();
        EnumMap enumMap = new EnumMap(PiiParam.class);
        for (PiiParam piiParam : PiiParam.values()) {
            enumMap.put(piiParam, Boolean.TRUE);
        }
        return new SomaGdprData(subjectToGdpr, consentString, enumMap, this.locationAware, 2);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.gdpr.SomaGdprV2Utils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr;

        static {
            int[] iArr = new int[SubjectToGdpr.values().length];
            $SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr = iArr;
            try {
                iArr[SubjectToGdpr.CMP_GDPR_ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr[SubjectToGdpr.CMP_GDPR_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr[SubjectToGdpr.CMP_GDPR_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
