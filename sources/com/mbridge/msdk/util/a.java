package com.mbridge.msdk.util;

import android.text.TextUtils;

/* JADX INFO: compiled from: AllTypeErrorMsgToCodeUtils.java */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static int a(int i, String str) {
        int i2;
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            int i3 = 15;
            if (str.startsWith("errorCode: ") && str.length() > 16) {
                return Integer.parseInt(str.substring(11, 15));
            }
            if (!str.equals("do not have sorceList")) {
                if (!str.equals("Network error,UnknownHostException")) {
                    if (!str.equals("v3 is timeout")) {
                        if (!str.equals("Current unit is loading!") && !str.equals("current unit is loading")) {
                            if (!str.equals("Network error,I/O exception response null")) {
                                if (!str.equals("Network error,ConnectException")) {
                                    if (!str.equals("Network error,socket timeout exception")) {
                                        if (!str.equals("Network error,disconnected network exception")) {
                                            if (!str.equals("Network error,timeout exception")) {
                                                if (!str.startsWith("Network error,please check state code")) {
                                                    if (!str.equals("Network error,I/O exception contents null")) {
                                                        if (!str.equals("Network unknown error")) {
                                                            if (str.equals("Network error,I/O exception")) {
                                                                i2 = i + 600;
                                                                i3 = 13;
                                                            } else if (str.equals("web env is not support")) {
                                                                i2 = i + 600;
                                                                i3 = 14;
                                                            } else if (str.equals("Network error,unknown")) {
                                                                i2 = i + 600;
                                                            } else if (str.equals("Network error，sslp exception")) {
                                                                i2 = i + 600;
                                                                i3 = 16;
                                                            } else if (str.startsWith("Cast exception, return data")) {
                                                                i2 = i + 600;
                                                                i3 = 17;
                                                            } else if (str.equals("REQUEST_TIMEOUT")) {
                                                                i2 = i + 700;
                                                            } else if (str.startsWith("The server returns an exception")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("APP ALREADY INSTALLED") || str.equals("Need show campaign list is NULL!")) {
                                                                i2 = i + 700;
                                                            } else if (str.startsWith("load no ad")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("EXCEPTION_UNIT_NOT_FOUND_IN_APP")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("EXCEPTION_UNIT_BIDDING_TYPE_ERROR")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("No video campaign")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("EXCEPTION_RETURN_EMPTY")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("EXCEPTION_APP_PLATFORM_ERROR")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("EXCEPTION_SERVICE_REQUEST_OS_VERSION_REQUIRED")) {
                                                                i2 = i + 700;
                                                            } else if (str.equals("banner res load failed")) {
                                                                i2 = i + 800;
                                                            } else if (str.equals("resource load timeout is tpl: false")) {
                                                                i2 = i + 800;
                                                            } else if (str.startsWith("resource download failed")) {
                                                                i2 = i + 800;
                                                            } else if (str.equals("temp preload success but isReady false")) {
                                                                i2 = i + 800;
                                                            } else if (str.equals("temp resource download failed")) {
                                                                i2 = i + 800;
                                                            } else if (str.equals("tpl temp resource download failed")) {
                                                                i2 = i + 800;
                                                            } else if (str.equals("resource load timeout is tpl: true")) {
                                                                i2 = i + 800;
                                                            } else {
                                                                if (!str.startsWith("https://") && !str.startsWith(com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v)) {
                                                                    if (str.equals("mraid resource write fail")) {
                                                                        i2 = i + 800;
                                                                    } else if (str.startsWith("data save failed:")) {
                                                                        i2 = i + 800;
                                                                    } else {
                                                                        if (!str.equals("resource load timeout")) {
                                                                            if (str.startsWith("tpl temp preload failed")) {
                                                                                i2 = i + 800;
                                                                            }
                                                                            return i;
                                                                        }
                                                                        i2 = i + 800;
                                                                    }
                                                                }
                                                                i2 = i + 800;
                                                            }
                                                            return i2 + i3;
                                                        }
                                                        i2 = i + 600;
                                                        i3 = 12;
                                                        return i2 + i3;
                                                    }
                                                    i2 = i + 600;
                                                    i3 = 11;
                                                    return i2 + i3;
                                                }
                                                i2 = i + 600;
                                                i3 = 10;
                                                return i2 + i3;
                                            }
                                            i2 = i + 600;
                                            i3 = 9;
                                            return i2 + i3;
                                        }
                                        i2 = i + 600;
                                        i3 = 8;
                                        return i2 + i3;
                                    }
                                    i2 = i + 600;
                                    i3 = 7;
                                    return i2 + i3;
                                }
                                i2 = i + 600;
                                i3 = 6;
                                return i2 + i3;
                            }
                            i2 = i + 600;
                            i3 = 5;
                            return i2 + i3;
                        }
                        i2 = i + 600;
                        i3 = 4;
                        return i2 + i3;
                    }
                    i2 = i + 600;
                    i3 = 3;
                    return i2 + i3;
                }
                i2 = i + 600;
                i3 = 2;
                return i2 + i3;
            }
            i2 = i + 600;
            i3 = 1;
            return i2 + i3;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int b(int i, String str) {
        return i + 900;
    }
}
