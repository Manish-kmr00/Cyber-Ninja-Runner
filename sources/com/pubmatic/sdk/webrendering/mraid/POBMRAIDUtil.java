package com.pubmatic.sdk.webrendering.mraid;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.json.b9;
import com.playon.bridge.Ad;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.internal.partials.PubMaticFilesBridge;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.pubnative.lite.sdk.mraid.nativefeature.MRAIDNativeFeatureProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBMRAIDUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f7886a = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ", "yyyy-MM-dd'T'HH:mmZ", "yyyy-MM-dd'T'HH:mmXXX"};

    static boolean a(Context context, Bitmap bitmap, String str) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        Uri uriFromFile;
        OutputStream outputStreamOpenOutputStream = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", str);
                    contentValues.put("_display_name", str);
                    contentValues.put(Ad.MIME_TYPE, "image/jpeg");
                    contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
                    contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
                    ContentResolver contentResolver = context.getContentResolver();
                    uriFromFile = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    if (uriFromFile != null) {
                        outputStreamOpenOutputStream = contentResolver.openOutputStream(uriFromFile);
                    }
                } else {
                    File file = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)), str);
                    fileOutputStreamFileOutputStreamCtor = PubMaticFilesBridge.fileOutputStreamCtor(file);
                    try {
                        uriFromFile = Uri.fromFile(file);
                        outputStreamOpenOutputStream = fileOutputStreamFileOutputStreamCtor;
                    } catch (Exception e) {
                        e = e;
                        outputStreamOpenOutputStream = fileOutputStreamFileOutputStreamCtor;
                        POBLog.debug("POBMRAIDUtil", "Not able to store image : " + e.getLocalizedMessage(), new Object[0]);
                        if (outputStreamOpenOutputStream != null) {
                            try {
                                outputStreamOpenOutputStream.flush();
                                outputStreamOpenOutputStream.close();
                            } catch (IOException unused) {
                                POBLog.debug("POBMRAIDUtil", "Unable to close the outputStream.", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStreamFileOutputStreamCtor != null) {
                            try {
                                fileOutputStreamFileOutputStreamCtor.flush();
                                fileOutputStreamFileOutputStreamCtor.close();
                            } catch (IOException unused2) {
                                POBLog.debug("POBMRAIDUtil", "Unable to close the outputStream.", new Object[0]);
                            }
                        }
                        throw th;
                    }
                }
                if (outputStreamOpenOutputStream == null) {
                    POBLog.debug("POBMRAIDUtil", "Not able to store image.", new Object[0]);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.flush();
                            outputStreamOpenOutputStream.close();
                        } catch (IOException unused3) {
                            POBLog.debug("POBMRAIDUtil", "Unable to close the outputStream.", new Object[0]);
                        }
                    }
                    return false;
                }
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.flush();
                outputStreamOpenOutputStream.close();
                POBLog.debug("POBMRAIDUtil", "Image stored at :" + uriFromFile, new Object[0]);
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(uriFromFile);
                context.sendBroadcast(intent);
                try {
                    outputStreamOpenOutputStream.flush();
                    outputStreamOpenOutputStream.close();
                    return true;
                } catch (IOException unused4) {
                    POBLog.debug("POBMRAIDUtil", "Unable to close the outputStream.", new Object[0]);
                    return true;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamFileOutputStreamCtor = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    private static String b(JSONObject jSONObject) {
        byte b;
        StringBuilder sb = new StringBuilder();
        try {
            if (jSONObject.has("frequency")) {
                String string = jSONObject.getString("frequency");
                int i = jSONObject.has("interval") ? Integer.parseInt(jSONObject.getString("interval")) : -1;
                int iHashCode = string.hashCode();
                if (iHashCode != -791707519) {
                    if (iHashCode != 95346201) {
                        if (iHashCode == 1236635661 && string.equals("monthly")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (string.equals("daily")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (string.equals("weekly")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    sb.append("FREQ=DAILY;");
                    if (i != -1) {
                        sb.append("INTERVAL=");
                        sb.append(i);
                        sb.append(";");
                    }
                } else if (b == 1) {
                    sb.append("FREQ=WEEKLY;");
                    if (i != -1) {
                        sb.append("INTERVAL=");
                        sb.append(i);
                        sb.append(";");
                    }
                    if (jSONObject.has("daysInWeek")) {
                        String strB = b(jSONObject.getJSONArray("daysInWeek"));
                        if (strB == null) {
                            throw new IllegalArgumentException("invalid ");
                        }
                        sb.append("BYDAY=");
                        sb.append(strB);
                        sb.append(";");
                    }
                } else {
                    if (b != 2) {
                        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                    }
                    sb.append("FREQ=MONTHLY;");
                    if (i != -1) {
                        sb.append("INTERVAL=");
                        sb.append(i);
                        sb.append(";");
                    }
                    if (jSONObject.has("daysInMonth")) {
                        String strA = a(jSONObject.getJSONArray("daysInMonth"));
                        if (strA == null) {
                            throw new IllegalArgumentException();
                        }
                        sb.append("BYMONTHDAY=");
                        sb.append(strA);
                        sb.append(";");
                    }
                }
            }
            return sb.toString();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
        }
    }

    protected static JSONObject getHeightWidthJson(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
        } catch (JSONException unused) {
            POBLog.error("POBMRAIDUtil", "JSON Exception, Not able to generate JSON for given width :" + i + " and height " + i2 + " !", new Object[0]);
        }
        return jSONObject;
    }

    protected static String getMRAIDEnvironment(String str, String str2, Boolean bool, Boolean bool2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", MraidEnvironmentProperties.VERSION);
            jSONObject.put("sdk", "PubMatic_OpenWrap_SDK");
            jSONObject.put("sdkVersion", "4.5.1");
            if (str != null) {
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_ID, str);
            }
            if (str2 != null) {
                jSONObject.put(POBConstants.KEY_IFA, str2);
            }
            if (bool != null) {
                jSONObject.put("limitAdTracking", bool);
            }
            if (bool2 != null) {
                jSONObject.put("coppa", bool2);
            }
        } catch (JSONException unused) {
            POBLog.error("POBMRAIDUtil", "JSON Exception, not able to generate MRAID environment.", new Object[0]);
        }
        return "<script> window.MRAID_ENV = " + jSONObject + "</script>";
    }

    protected static JSONObject getRectJson(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i3);
            jSONObject.put("height", i4);
            jSONObject.put(VastAttributes.HORIZONTAL_POSITION, i);
            jSONObject.put(VastAttributes.VERTICAL_POSITION, i2);
        } catch (JSONException unused) {
            POBLog.error("POBMRAIDUtil", "JSON Exception, Not able to generate JSON for x:" + i + " ,y:" + i2 + " ,width:" + i3 + " ,height:" + i4 + " !", new Object[0]);
        }
        return jSONObject;
    }

    protected static POBViewRect getResizeValues(int i, int i2, int i3, int i4, boolean z, POBViewRect pOBViewRect, int i5, int i6) {
        int i7;
        int screenWidth = POBUtils.getScreenWidth();
        int screenHeight = POBUtils.getScreenHeight();
        int i8 = i + pOBViewRect.getxPosition();
        int i9 = i2 + pOBViewRect.getyPosition();
        int i10 = 0;
        if (i3 >= screenWidth && i4 >= screenHeight) {
            return new POBViewRect(false, "Size must be smaller than the max size.");
        }
        if (i3 < 50 || i4 < 50) {
            return new POBViewRect(false, "Size must be greater than the 50x50 size.");
        }
        if (z) {
            int i11 = i8 + i3;
            if (i11 < i5 || i11 > screenWidth || i9 < 0 || i9 > screenHeight - i6) {
                return new POBViewRect(false, "Not able to show Close Button! No Space for close Button.");
            }
        } else {
            if (i3 > screenWidth) {
                i3 = screenWidth;
            }
            if (i4 > screenHeight) {
                i4 = screenHeight;
            }
            if (i8 < 0) {
                i7 = 0;
            } else {
                int i12 = i8 + i3;
                if (i12 > screenWidth) {
                    i7 = (int) (((double) i8) - ((double) (i12 - screenWidth)));
                } else {
                    i7 = i8;
                }
            }
            if (i9 >= 0) {
                int i13 = i9 + i4;
                if (i13 > screenHeight) {
                    i10 = (int) (((double) i9) - ((double) (i13 - screenHeight)));
                } else {
                    i10 = i9;
                }
            }
            i8 = (int) (((double) i8) - ((double) (i8 - i7)));
            i9 = (int) (((double) i9) - ((double) (i9 - i10)));
        }
        return new POBViewRect(POBUtils.convertDpToPixel(i8), POBUtils.convertDpToPixel(i9), POBUtils.convertDpToPixel(i4), POBUtils.convertDpToPixel(i3), true, "Ok");
    }

    static Map a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject.has("description")) {
            map.put("title", jSONObject.getString("description"));
            if (jSONObject.has("start") && jSONObject.getString("start") != null) {
                Date dateA = a(jSONObject.getString("start"));
                if (dateA != null) {
                    map.put(MRAIDNativeFeatureProvider.EXTRA_EVENT_BEGIN_TIME, Long.valueOf(dateA.getTime()));
                    if (jSONObject.has("end") && jSONObject.getString("end") != null) {
                        Date dateA2 = a(jSONObject.getString("end"));
                        if (dateA2 != null) {
                            map.put("endTime", Long.valueOf(dateA2.getTime()));
                        } else {
                            POBLog.error("POBMRAIDUtil", "Invalid end format. end must be(yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx)", new Object[0]);
                        }
                        if (jSONObject.has("location")) {
                            map.put(MRAIDNativeFeatureProvider.EVENT_LOCATION, jSONObject.getString("location"));
                        }
                        if (jSONObject.has("summary")) {
                            map.put("description", jSONObject.getString("summary"));
                        }
                        if (jSONObject.has("transparency")) {
                            map.put("availability", Integer.valueOf(jSONObject.getString("transparency").equals(b9.h.T) ? 1 : 0));
                        }
                        if (jSONObject.has("recurrence")) {
                            map.put("rrule", b(jSONObject.getJSONObject("recurrence")));
                        }
                        return map;
                    }
                    throw new IllegalArgumentException("Invalid end.end can't be null.");
                }
                POBLog.error("POBMRAIDUtil", "Invalid start format. start must be(yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx)", new Object[0]);
                throw new IllegalArgumentException("Invalid start format. start must be(yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx)");
            }
            throw new IllegalArgumentException("Invalid start. start can't be null.");
        }
        throw new IllegalArgumentException("Invalid description. Description can't be null.");
    }

    private static String b(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            POBLog.error("POBMRAIDUtil", "Must have at least 1 day of the week if specifying repeating weekly.", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        for (int i = 0; i < jSONArray.length(); i++) {
            int iOptInt = jSONArray.optInt(i);
            if (iOptInt == 7) {
                iOptInt = 0;
            }
            if (!zArr[iOptInt]) {
                sb.append(b(iOptInt));
                sb.append(StringUtils.COMMA);
                zArr[iOptInt] = true;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static Date a(String str) {
        Date date = null;
        for (String str2 : f7886a) {
            try {
                date = new SimpleDateFormat(str2, Locale.US).parse(str);
                if (date != null) {
                    break;
                }
            } catch (ParseException e) {
                POBLog.error("POBMRAIDUtil", "Not able to parse date. %s", e.getLocalizedMessage());
            }
        }
        return date;
    }

    private static String a(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            POBLog.error("POBMRAIDUtil", "must have at least 1 day of the month if specifying repeating weekly", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        for (int i = 0; i < jSONArray.length(); i++) {
            int iOptInt = jSONArray.optInt(i);
            int i2 = iOptInt + 31;
            if (!zArr[i2]) {
                sb.append(a(iOptInt));
                sb.append(StringUtils.COMMA);
                zArr[i2] = true;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String b(int i) {
        switch (i) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                POBLog.error("POBMRAIDUtil", "invalid day of week %s", Integer.valueOf(i));
                return null;
        }
    }

    private static String a(int i) {
        if (i != 0 && i >= -31 && i <= 31) {
            return "" + i;
        }
        POBLog.error("POBMRAIDUtil", "invalid day of month " + i, new Object[0]);
        return null;
    }

    static boolean a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (telephonyManager == null || telephonyManager.getSimState() == 1) ? false : true;
        } catch (Exception e) {
            POBLog.warn("POBMRAIDUtil", "Not able to get TelephonyManager. Error: %s", e.getMessage());
            return false;
        }
    }
}
