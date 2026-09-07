package io.bidmachine;

import android.content.Context;
import android.media.AudioManager;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.DeviceUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class DeviceInfo {
    private static final String OS_NAME = "android";
    private static volatile DeviceInfo instance;
    private final HwInfoCache cache;
    private final Cpu cpu;
    private final Gpu gpu;
    private String hwv;
    private Boolean isRooted;
    public final boolean isTablet;
    public final String manufacturer;
    public final String model;
    public final String osName;
    public final String osVersion;
    public final String phoneCarrier;
    public final String phoneMCCMNC;
    public final float screenDensity;
    public final int screenDpi;
    private Long totalDiskSpaceInMB;
    private final Audio audio = new Audio();
    private final Ram ram = new Ram();

    public static DeviceInfo obtain(Context context) {
        DeviceInfo deviceInfo = instance;
        if (deviceInfo == null) {
            synchronized (DeviceInfo.class) {
                deviceInfo = instance;
                if (deviceInfo == null) {
                    deviceInfo = new DeviceInfo(context);
                    instance = deviceInfo;
                }
            }
        }
        return deviceInfo;
    }

    private DeviceInfo(Context context) {
        HwInfoCache hwInfoCache = new HwInfoCache();
        this.cache = hwInfoCache;
        this.cpu = new Cpu(hwInfoCache);
        this.gpu = new Gpu(hwInfoCache);
        this.osName = "android";
        this.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        this.manufacturer = DeviceUtils.getManufacturer();
        this.model = DeviceUtils.getModel();
        this.screenDpi = DeviceUtils.getScreenDpi(context);
        this.screenDensity = Utils.getScreenDensity(context);
        this.isTablet = DeviceUtils.isTablet(context);
        this.phoneMCCMNC = DeviceUtils.getPhoneMCCMNC(context);
        this.phoneCarrier = DeviceUtils.getPhoneOperator(context);
    }

    boolean isDeviceRooted() {
        Boolean bool = this.isRooted;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = true;
        try {
            String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i]).exists()) {
                    Boolean bool2 = true;
                    this.isRooted = bool2;
                    return bool2.booleanValue();
                }
            }
        } catch (Exception unused) {
        }
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() == null) {
                z = false;
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            this.isRooted = boolValueOf;
            boolean zBooleanValue = boolValueOf.booleanValue();
            if (processExec != null) {
                processExec.destroy();
            }
            return zBooleanValue;
        } catch (Exception unused2) {
            if (processExec != null) {
                processExec.destroy();
            }
            Boolean bool3 = false;
            this.isRooted = bool3;
            return bool3.booleanValue();
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    String getHWV() throws Throwable {
        String str = this.hwv;
        if (str != null) {
            return str;
        }
        String kernelVersionThroughProcVersion = getKernelVersionThroughProcVersion();
        if (!TextUtils.isEmpty(kernelVersionThroughProcVersion)) {
            this.hwv = kernelVersionThroughProcVersion;
            return kernelVersionThroughProcVersion;
        }
        String kernelVersionThroughUName = getKernelVersionThroughUName();
        this.hwv = kernelVersionThroughUName;
        return kernelVersionThroughUName;
    }

    Long getTotalDiskSpaceInMB() {
        Long l = this.totalDiskSpaceInMB;
        if (l != null) {
            return l;
        }
        try {
            if (!Utils.isExternalMemoryAvailable()) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            Long lValueOf = Long.valueOf((statFs.getBlockSizeLong() * statFs.getBlockCountLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            this.totalDiskSpaceInMB = lValueOf;
            return lValueOf;
        } catch (Exception unused) {
            return null;
        }
    }

    Long getAvailableDiskSpaceInMB() {
        try {
            if (!Utils.isExternalMemoryAvailable()) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.valueOf((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getKernelVersionThroughProcVersion() throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        try {
            randomAccessFile = new RandomAccessFile("/proc/version", "r");
            try {
                String line = randomAccessFile.readLine();
                Utils.close(randomAccessFile);
                return line;
            } catch (Exception unused) {
                Utils.close(randomAccessFile);
                return null;
            } catch (Throwable th2) {
                th = th2;
                Utils.close(randomAccessFile);
                throw th;
            }
        } catch (Exception unused2) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.BufferedReader, java.io.Closeable] */
    private String getKernelVersionThroughUName() throws Throwable {
        InputStreamReader inputStreamReader;
        ?? bufferedReader;
        Throwable th;
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("uname -a");
            try {
                inputStreamReader = new InputStreamReader(processExec.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String line = bufferedReader.readLine();
                        Utils.close(bufferedReader);
                        Utils.close(inputStreamReader);
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return line;
                    } catch (Exception unused) {
                        Utils.close(bufferedReader);
                        Utils.close(inputStreamReader);
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.close(bufferedReader);
                        Utils.close(inputStreamReader);
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    bufferedReader = 0;
                } catch (Throwable th3) {
                    bufferedReader = 0;
                    th = th3;
                }
            } catch (Exception unused3) {
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                Utils.close(bufferedReader);
                Utils.close(inputStreamReader);
                if (processExec != null) {
                    processExec.destroy();
                }
                return null;
            } catch (Throwable th4) {
                bufferedReader = 0;
                th = th4;
                inputStreamReader = null;
            }
        } catch (Exception unused4) {
            processExec = null;
            inputStreamReader = null;
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = 0;
            th = th5;
            processExec = null;
        }
    }

    Audio getAudio() {
        return this.audio;
    }

    Cpu getCpu() {
        return this.cpu;
    }

    Gpu getGpu() {
        return this.gpu;
    }

    Ram getRam() {
        return this.ram;
    }

    void updateHwInfo(Context context) throws Throwable {
        this.cpu.update(context);
        this.gpu.update(context);
        this.ram.update();
    }

    static final class Audio {
        Audio() {
        }

        Boolean isRingMuted(Context context) {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager == null) {
                return null;
            }
            int ringerMode = audioManager.getRingerMode();
            boolean z = true;
            if (ringerMode != 0 && ringerMode != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        Float getVolumeLevel(Context context) {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager == null) {
                return null;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? audioManager.getStreamMinVolume(3) : 0;
            int i = streamMaxVolume - streamMinVolume;
            if (i == 0) {
                return Float.valueOf(0.0f);
            }
            return Float.valueOf((streamVolume - streamMinVolume) / i);
        }

        private AudioManager getAudioManager(Context context) {
            return (AudioManager) context.getSystemService("audio");
        }
    }

    static final class Cpu {
        public static final String KEY_NAME = "cpu_name";
        public static final String KEY_VENDOR = "cpu_vendor";
        private final HwInfoCache cache;
        private String name;
        private String vendor;

        Cpu(HwInfoCache hwInfoCache) {
            this.cache = hwInfoCache;
        }

        String getName() {
            return this.name;
        }

        String getVendor() {
            return this.vendor;
        }

        void update(Context context) throws Throwable {
            if (TextUtils.isEmpty(this.name)) {
                this.name = this.cache.read(context, KEY_NAME);
            }
            if (TextUtils.isEmpty(this.vendor)) {
                this.vendor = this.cache.read(context, KEY_VENDOR);
            }
            if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.vendor)) {
                extract();
                this.cache.store(context, KEY_NAME, this.name);
                this.cache.store(context, KEY_VENDOR, this.vendor);
            }
        }

        private void extract() throws Throwable {
            read();
            if (TextUtils.isEmpty(this.name)) {
                this.name = Build.BOARD;
            }
            if (TextUtils.isEmpty(this.vendor)) {
                this.vendor = Build.HARDWARE;
            }
        }

        private void read() throws Throwable {
            RandomAccessFile randomAccessFile;
            Throwable th;
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                while (true) {
                    try {
                        String line = randomAccessFile.readLine();
                        if (line != null) {
                            if (line.startsWith("model name:") || line.startsWith("Hardware:")) {
                                this.name = findValue(line);
                            } else if (line.startsWith("vendor_id:")) {
                                this.vendor = findValue(line);
                            }
                            if (this.name != null && this.vendor != null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception unused) {
                        randomAccessFile2 = randomAccessFile;
                        Utils.close(randomAccessFile2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.close(randomAccessFile);
                        throw th;
                    }
                }
                Utils.close(randomAccessFile);
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        }

        private String findValue(String str) {
            Matcher matcher = Pattern.compile(":\\s*(.*)").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }
    }

    static final class Gpu {
        public static final String KEY_NAME = "gpu_name";
        public static final String KEY_VENDOR = "gpu_vendor";
        private final HwInfoCache cache;
        private String name;
        private String vendor;

        Gpu(HwInfoCache hwInfoCache) {
            this.cache = hwInfoCache;
        }

        String getName() {
            return this.name;
        }

        String getVendor() {
            return this.vendor;
        }

        void update(Context context) throws Throwable {
            if (TextUtils.isEmpty(this.name)) {
                this.name = this.cache.read(context, KEY_NAME);
            }
            if (TextUtils.isEmpty(this.vendor)) {
                this.vendor = this.cache.read(context, KEY_VENDOR);
            }
            if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.vendor)) {
                extract();
                this.cache.store(context, KEY_NAME, this.name);
                this.cache.store(context, KEY_VENDOR, this.vendor);
            }
        }

        private void extract() throws Throwable {
            EGLContext eGLContext;
            EGLSurface eGLSurfaceCreateEGLSurface;
            EGLContext eGLContext2;
            EGLContext eGLContext3;
            EGLDisplay eGLDisplay = null;
            eGLContextCreateEGLContext = null;
            EGLContext eGLContextCreateEGLContext = null;
            EGLSurface eGLSurface = null;
            EGLDisplay eGLDisplay2 = null;
            try {
                EGLDisplay eGLDisplayInitEGLDisplay = initEGLDisplay();
                try {
                    EGLConfig eGLConfigChooseEGLConfig = chooseEGLConfig(eGLDisplayInitEGLDisplay);
                    if (eGLConfigChooseEGLConfig != null) {
                        eGLSurfaceCreateEGLSurface = createEGLSurface(eGLDisplayInitEGLDisplay, eGLConfigChooseEGLConfig);
                        try {
                            eGLContextCreateEGLContext = createEGLContext(eGLDisplayInitEGLDisplay, eGLConfigChooseEGLConfig);
                            makeCurrent(eGLDisplayInitEGLDisplay, eGLSurfaceCreateEGLSurface, eGLContextCreateEGLContext);
                            this.name = GLES20.glGetString(7937);
                            this.vendor = GLES20.glGetString(7936);
                            eGLContext3 = eGLContextCreateEGLContext;
                            eGLSurface = eGLSurfaceCreateEGLSurface;
                        } catch (Exception unused) {
                            eGLContext2 = eGLContextCreateEGLContext;
                            eGLDisplay2 = eGLDisplayInitEGLDisplay;
                            cleanUpEGL(eGLDisplay2, eGLSurfaceCreateEGLSurface, eGLContext2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            eGLContext = eGLContextCreateEGLContext;
                            eGLDisplay = eGLDisplayInitEGLDisplay;
                            cleanUpEGL(eGLDisplay, eGLSurfaceCreateEGLSurface, eGLContext);
                            throw th;
                        }
                    } else {
                        eGLContext3 = null;
                    }
                    cleanUpEGL(eGLDisplayInitEGLDisplay, eGLSurface, eGLContext3);
                } catch (Exception unused2) {
                    eGLSurfaceCreateEGLSurface = null;
                    eGLDisplay2 = eGLDisplayInitEGLDisplay;
                    eGLContext2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    eGLSurfaceCreateEGLSurface = null;
                    eGLDisplay = eGLDisplayInitEGLDisplay;
                    eGLContext = null;
                }
            } catch (Exception unused3) {
                eGLContext2 = null;
                eGLSurfaceCreateEGLSurface = null;
            } catch (Throwable th3) {
                th = th3;
                eGLContext = null;
                eGLSurfaceCreateEGLSurface = null;
            }
        }

        private EGLDisplay initEGLDisplay() {
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            int[] iArr = new int[2];
            EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
            return eGLDisplayEglGetDisplay;
        }

        private EGLConfig chooseEGLConfig(EGLDisplay eGLDisplay) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr = new int[1];
            EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr, 0);
            if (iArr[0] == 0) {
                return null;
            }
            return eGLConfigArr[0];
        }

        private EGLSurface createEGLSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
        }

        private EGLContext createEGLContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        }

        private void makeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLContext eGLContext) {
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        }

        private void cleanUpEGL(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLContext eGLContext) {
            if (eGLDisplay != null) {
                makeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                if (eGLSurface != null) {
                    EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                }
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                }
                EGL14.eglTerminate(eGLDisplay);
            }
        }
    }

    static final class Ram {
        private Long freeMem;
        private Long totalMem;

        Ram() {
        }

        Long getFreeMemBytes() {
            return this.freeMem;
        }

        Long getTotalMemBytes() {
            return this.totalMem;
        }

        void update() throws Throwable {
            RandomAccessFile randomAccessFile;
            Throwable th;
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MEM_INFO, "r");
                while (true) {
                    try {
                        String line = randomAccessFile.readLine();
                        if (line != null) {
                            if (line.startsWith("MemTotal:")) {
                                this.totalMem = parseValue(findValue(line));
                            } else if (line.startsWith("MemAvailable:")) {
                                this.freeMem = parseValue(findValue(line));
                            }
                            if (this.totalMem != null && this.freeMem != null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception unused) {
                        randomAccessFile2 = randomAccessFile;
                        Utils.close(randomAccessFile2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.close(randomAccessFile);
                        throw th;
                    }
                }
                Utils.close(randomAccessFile);
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        }

        private String findValue(String str) {
            Matcher matcher = Pattern.compile("(\\d+)").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }

        private Long parseValue(String str) {
            if (str != null) {
                try {
                    return Long.valueOf(Long.parseLong(str) * 1024);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
    }
}
