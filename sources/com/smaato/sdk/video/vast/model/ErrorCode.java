package com.smaato.sdk.video.vast.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes8.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ErrorCode {
    public static final int CONDITIONAL_AD_REJECTED_ERROR = 408;
    public static final int COULD_NOT_DISPLAY_MEDIA_FILE_ERROR = 405;
    public static final int COULD_NOT_FIND_LINEAR_OR_MEDIAFILE_ERROR = 401;
    public static final int COULD_NOT_FIND_SUPPORTED_COMPANION_ERROR = 604;
    public static final int COULD_NOT_FIND_SUPPORTED_MEDIA_FILE_ERROR = 403;
    public static final int DIFFERENT_DURATION_EXPECTED_ERROR = 202;
    public static final int DIFFERENT_LINEARITY_EXPECTED_ERROR = 201;
    public static final int DIFFERENT_SIZE_EXPECTED_ERROR = 203;
    public static final int GENERAL_COMPANION_AD_ERROR = 600;
    public static final int GENERAL_LINEAR_ERROR = 400;
    public static final int GENERAL_VPAID_ERROR = 901;
    public static final int GENERAL_WRAPPER_ERROR = 300;
    public static final int INLINE_AD_DISPLAY_TIMEOUT_ERROR = 304;
    public static final int INLINE_CATEGORY_VIOLATES_BLOCKED_CATEGORIES_ERROR = 205;
    public static final int INTERACTIVE_UNIT_NOT_EXECUTED_ERROR = 409;
    public static final int MEDIAFILE_REQUEST_TIMEOUT_ERROR = 402;
    public static final int NOT_EXPECTED_AD_TRAFFICKING_ERROR = 200;
    public static final int NO_AD_CATEGORY_PROVIDED_ERROR = 204;
    public static final int NO_VAST_AFTER_WRAPPER_ERROR = 303;
    public static final int TOO_MANY_WRAPPER_REDIRECTS_ERROR = 302;
    public static final int UNABLE_TO_DISPLAY_COMPANION_AD_DIMENSION_ARE_NOT_ALLIGNED_ERROR = 601;
    public static final int UNABLE_TO_DISPLAY_COMPANION_AD_ERROR = 602;
    public static final int UNABLE_TO_FETCH_COMPANION_AD_RESOURCE_ERROR = 603;
    public static final int UNDEFINED_ERROR = 900;
    public static final int VAST_VERSION_RESPONSE_NOT_SUPPORTED_ERROR = 102;
    public static final int VERIFICATION_UNIT_NOT_EXECUTED_ERROR = 410;
    public static final int WRAPPER_REQUEST_TIMEOUT_ERROR = 301;
    public static final int XML_PARSING_ERROR = 100;
    public static final int XML_SCHEMA_VALIDATION_ERROR = 101;
}
