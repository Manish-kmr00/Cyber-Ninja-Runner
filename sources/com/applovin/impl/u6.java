package com.applovin.impl;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.json.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: loaded from: classes5.dex */
public abstract class u6 {
    public static String a(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 2) {
            return "SFBX CMP";
        }
        if (iIntValue == 3) {
            return "Liveramp CMP";
        }
        if (iIntValue == 5) {
            return "UserCentrics CMP";
        }
        if (iIntValue == 6) {
            return "Sourcepoint Dialogue CMP";
        }
        if (iIntValue == 7) {
            return "Didomi CMP";
        }
        if (iIntValue == 27) {
            return "Associated Newspapers Ltd CMP";
        }
        if (iIntValue == 28) {
            return "Onetrust / Cookiepro CMP";
        }
        if (iIntValue == 104) {
            return "AdOcean CMP";
        }
        if (iIntValue == 105) {
            return "Dailymotion CMP";
        }
        if (iIntValue == 302) {
            return "Gravito CMP";
        }
        if (iIntValue == 303) {
            return "Impala CMP";
        }
        if (iIntValue == 414) {
            return "MBEX LTD CMP";
        }
        if (iIntValue == 415) {
            return "Match Group LLC CMP";
        }
        switch (iIntValue) {
            case 10:
                return "InMobi Choice CMP";
            case 14:
                return "Yahoo EMEA CMP";
            case 21:
                return "Traffective CMP";
            case 31:
                return "Consentmanager CMP";
            case 35:
                return "BurdaForward GmbH CMP";
            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                return "Deezer CMP";
            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                return "Uniconsent CMP";
            case 72:
                return "Wirtualna Polska Media S.A. CMP";
            case 76:
                return "Sibbo CMP";
            case 79:
                return "SFR CMP";
            case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_NOT_EXIST /* 84 */:
                return "Alma CMP";
            case 90:
                return "Commanders Act CMP";
            case INVALID_RI_ENDPOINT_VALUE:
                return "Iubenda CMP";
            case INVALID_METRICS_ENDPOINT_VALUE:
                return "Ebay CMP";
            case 134:
                return "Cookiebot CMP";
            case 167:
                return "1&1 Mail & Media GmbH CMP";
            case 171:
                return "Viber Media CMP";
            case 198:
                return "Microsoft Corporation CMP";
            case 212:
                return "Singlespot";
            case 231:
                return "Interia CMP";
            case 237:
                return "ALPRED SL CMP";
            case 246:
                return "Overwolf Ltd. CMP";
            case 258:
                return "Automattic, Inc. CMP";
            case 260:
                return "Axeptio";
            case 273:
                return "One Consent CMP";
            case 280:
                return "Ringier Axel Springer Polska";
            case 300:
                return "Google LLC CMP";
            case 306:
                return "mobile.de CMP";
            case 309:
                return "eBay Kleinanzeigen GmbH CMP";
            case 318:
                return "Seven.One Entertainment Group GmbH CMP";
            case 327:
                return "FunCorp CMP";
            case 329:
                return "wetter.com GmbH CMP";
            case 340:
                return "Ketch CMP";
            case 345:
                return "Axel Springer Deutschland GmbH CMP";
            case 348:
                return "Outfit7 CMP";
            case 355:
                return "Onesecondbefore B.V. CMP";
            case 371:
                return "Société Éditrice du Monde";
            case 385:
                return "freenet.de GmbH CMP";
            case 387:
                return "Learnings CMP";
            case 397:
                return "Autoscout24 CMP";
            case 399:
                return "Transcend CMP";
            case 409:
                return "adjoe GmbH CMP";
            case 421:
                return "Moonee Publishing LTD CMP";
            case 432:
                return "Appodeal Inc CMP";
            case 436:
                return "X-FLOW LTD CMP";
            default:
                switch (iIntValue) {
                    case 350:
                        return "Easybrain CMP";
                    case 351:
                        return "TVP S.A. CMP";
                    case 352:
                        return "Pubtech CMP";
                    default:
                        return null;
                }
        }
    }
}
