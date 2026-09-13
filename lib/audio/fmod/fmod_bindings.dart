// ignore_for_file: constant_identifier_names, camel_case_types, non_constant_identifier_names
import 'dart:ffi';
import 'dart:io';
import 'package:ffi/ffi.dart';
import 'package:flutter/foundation.dart';

// FMOD Result codes
const int FMOD_OK = 0;

// FMOD Version 2.03.14 (0x00020314)
const int FMOD_VERSION = 0x00020314;

// Flags
const int FMOD_STUDIO_INIT_NORMAL = 0x00000000;
const int FMOD_INIT_NORMAL = 0x00000000;
const int FMOD_STUDIO_LOAD_BANK_NORMAL = 0x00000000;
const int FMOD_STUDIO_LOAD_MEMORY = 0; // FMOD_STUDIO_LOAD_MEMORY_MODE

// Stop modes
const int FMOD_STUDIO_STOP_ALLOWFADEOUT = 0;
const int FMOD_STUDIO_STOP_IMMEDIATE = 1;

// Opaque struct pointers
final class FmodStudioSystem extends Opaque {}

final class FmodStudioEventDescription extends Opaque {}

final class FmodStudioEventInstance extends Opaque {}

final class FmodStudioBus extends Opaque {}

final class FmodStudioBank extends Opaque {}

// C Function Typedefs
typedef FmodStudioSystemCreateC =
    Int32 Function(
      Pointer<Pointer<FmodStudioSystem>> system,
      Uint32 headerversion,
    );
typedef FmodStudioSystemCreateDart =
    int Function(Pointer<Pointer<FmodStudioSystem>> system, int headerversion);

typedef FmodStudioSystemInitializeC =
    Int32 Function(
      Pointer<FmodStudioSystem> system,
      Int32 maxchannels,
      Uint32 studioflags,
      Uint32 flags,
      Pointer<Void> extradriverdata,
    );
typedef FmodStudioSystemInitializeDart =
    int Function(
      Pointer<FmodStudioSystem> system,
      int maxchannels,
      int studioflags,
      int flags,
      Pointer<Void> extradriverdata,
    );

typedef FmodStudioSystemReleaseC =
    Int32 Function(Pointer<FmodStudioSystem> system);
typedef FmodStudioSystemReleaseDart =
    int Function(Pointer<FmodStudioSystem> system);

typedef FmodStudioSystemUpdateC =
    Int32 Function(Pointer<FmodStudioSystem> system);
typedef FmodStudioSystemUpdateDart =
    int Function(Pointer<FmodStudioSystem> system);

typedef FmodStudioSystemLoadBankFileC =
    Int32 Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> filename,
      Uint32 flags,
      Pointer<Pointer<FmodStudioBank>> bank,
    );
typedef FmodStudioSystemLoadBankFileDart =
    int Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> filename,
      int flags,
      Pointer<Pointer<FmodStudioBank>> bank,
    );

typedef FmodStudioSystemLoadBankMemoryC =
    Int32 Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Uint8> buffer,
      Int32 length,
      Int32 mode,
      Uint32 flags,
      Pointer<Pointer<FmodStudioBank>> bank,
    );
typedef FmodStudioSystemLoadBankMemoryDart =
    int Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Uint8> buffer,
      int length,
      int mode,
      int flags,
      Pointer<Pointer<FmodStudioBank>> bank,
    );

typedef FmodStudioSystemUnloadAllC =
    Int32 Function(Pointer<FmodStudioSystem> system);
typedef FmodStudioSystemUnloadAllDart =
    int Function(Pointer<FmodStudioSystem> system);

typedef FmodStudioBankUnloadC = Int32 Function(Pointer<FmodStudioBank> bank);
typedef FmodStudioBankUnloadDart = int Function(Pointer<FmodStudioBank> bank);

typedef FmodStudioSystemGetEventC =
    Int32 Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> pathOrID,
      Pointer<Pointer<FmodStudioEventDescription>> event,
    );
typedef FmodStudioSystemGetEventDart =
    int Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> pathOrID,
      Pointer<Pointer<FmodStudioEventDescription>> event,
    );

typedef FmodStudioSystemGetBusC =
    Int32 Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> pathOrID,
      Pointer<Pointer<FmodStudioBus>> bus,
    );
typedef FmodStudioSystemGetBusDart =
    int Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> pathOrID,
      Pointer<Pointer<FmodStudioBus>> bus,
    );

typedef FmodStudioSystemSetParameterByNameC =
    Int32 Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> name,
      Float value,
      Int32 ignoreseekspeed,
    );
typedef FmodStudioSystemSetParameterByNameDart =
    int Function(
      Pointer<FmodStudioSystem> system,
      Pointer<Utf8> name,
      double value,
      int ignoreseekspeed,
    );

typedef FmodStudioEventDescriptionCreateInstanceC =
    Int32 Function(
      Pointer<FmodStudioEventDescription> eventdescription,
      Pointer<Pointer<FmodStudioEventInstance>> instance,
    );
typedef FmodStudioEventDescriptionCreateInstanceDart =
    int Function(
      Pointer<FmodStudioEventDescription> eventdescription,
      Pointer<Pointer<FmodStudioEventInstance>> instance,
    );

typedef FmodStudioEventInstanceStartC =
    Int32 Function(Pointer<FmodStudioEventInstance> eventinstance);
typedef FmodStudioEventInstanceStartDart =
    int Function(Pointer<FmodStudioEventInstance> eventinstance);

typedef FmodStudioEventInstanceStopC =
    Int32 Function(Pointer<FmodStudioEventInstance> eventinstance, Int32 mode);
typedef FmodStudioEventInstanceStopDart =
    int Function(Pointer<FmodStudioEventInstance> eventinstance, int mode);

typedef FmodStudioEventInstanceReleaseC =
    Int32 Function(Pointer<FmodStudioEventInstance> eventinstance);
typedef FmodStudioEventInstanceReleaseDart =
    int Function(Pointer<FmodStudioEventInstance> eventinstance);

typedef FmodStudioEventInstanceSetParameterByNameC =
    Int32 Function(
      Pointer<FmodStudioEventInstance> eventinstance,
      Pointer<Utf8> name,
      Float value,
      Int32 ignoreseekspeed,
    );
typedef FmodStudioEventInstanceSetParameterByNameDart =
    int Function(
      Pointer<FmodStudioEventInstance> eventinstance,
      Pointer<Utf8> name,
      double value,
      int ignoreseekspeed,
    );

typedef FmodStudioEventInstanceGetTimelinePositionC =
    Int32 Function(
      Pointer<FmodStudioEventInstance> eventinstance,
      Pointer<Int32> position,
    );
typedef FmodStudioEventInstanceGetTimelinePositionDart =
    int Function(
      Pointer<FmodStudioEventInstance> eventinstance,
      Pointer<Int32> position,
    );

typedef FmodStudioEventInstanceSetTimelinePositionC =
    Int32 Function(
      Pointer<FmodStudioEventInstance> eventinstance,
      Int32 position,
    );
typedef FmodStudioEventInstanceSetTimelinePositionDart =
    int Function(Pointer<FmodStudioEventInstance> eventinstance, int position);

typedef FmodStudioBusSetVolumeC =
    Int32 Function(Pointer<FmodStudioBus> bus, Float volume);
typedef FmodStudioBusSetVolumeDart =
    int Function(Pointer<FmodStudioBus> bus, double volume);

typedef FmodStudioBusSetMuteC =
    Int32 Function(Pointer<FmodStudioBus> bus, Int32 mute);
typedef FmodStudioBusSetMuteDart =
    int Function(Pointer<FmodStudioBus> bus, int mute);

typedef FmodStudioBusSetPausedC =
    Int32 Function(Pointer<FmodStudioBus> bus, Int32 paused);
typedef FmodStudioBusSetPausedDart =
    int Function(Pointer<FmodStudioBus> bus, int paused);

/// Low-level FMOD Studio C FFI Bindings.
class FmodBindings {
  static FmodBindings? _instance;
  static FmodBindings get instance {
    _instance ??= FmodBindings._load();
    return _instance!;
  }

  final DynamicLibrary _studioLib;

  late final FmodStudioSystemCreateDart systemCreate;
  late final FmodStudioSystemInitializeDart systemInitialize;
  late final FmodStudioSystemReleaseDart systemRelease;
  late final FmodStudioSystemUpdateDart systemUpdate;
  late final FmodStudioSystemLoadBankFileDart systemLoadBankFile;
  late final FmodStudioSystemLoadBankMemoryDart systemLoadBankMemory;
  late final FmodStudioSystemUnloadAllDart systemUnloadAll;
  late final FmodStudioBankUnloadDart bankUnload;
  late final FmodStudioSystemGetEventDart systemGetEvent;
  late final FmodStudioSystemGetBusDart systemGetBus;
  late final FmodStudioSystemSetParameterByNameDart systemSetParameterByName;
  late final FmodStudioEventDescriptionCreateInstanceDart
  eventDescriptionCreateInstance;
  late final FmodStudioEventInstanceStartDart eventInstanceStart;
  late final FmodStudioEventInstanceStopDart eventInstanceStop;
  late final FmodStudioEventInstanceReleaseDart eventInstanceRelease;
  late final FmodStudioEventInstanceSetParameterByNameDart
  eventInstanceSetParameterByName;
  late final FmodStudioEventInstanceGetTimelinePositionDart
  eventInstanceGetTimelinePosition;
  late final FmodStudioEventInstanceSetTimelinePositionDart
  eventInstanceSetTimelinePosition;
  late final FmodStudioBusSetVolumeDart busSetVolume;
  late final FmodStudioBusSetMuteDart busSetMute;
  late final FmodStudioBusSetPausedDart busSetPaused;

  FmodBindings._(this._studioLib) {
    systemCreate = _studioLib
        .lookupFunction<FmodStudioSystemCreateC, FmodStudioSystemCreateDart>(
          'FMOD_Studio_System_Create',
        );
    systemInitialize = _studioLib
        .lookupFunction<
          FmodStudioSystemInitializeC,
          FmodStudioSystemInitializeDart
        >('FMOD_Studio_System_Initialize');
    systemRelease = _studioLib
        .lookupFunction<FmodStudioSystemReleaseC, FmodStudioSystemReleaseDart>(
          'FMOD_Studio_System_Release',
        );
    systemUpdate = _studioLib
        .lookupFunction<FmodStudioSystemUpdateC, FmodStudioSystemUpdateDart>(
          'FMOD_Studio_System_Update',
        );
    systemLoadBankFile = _studioLib
        .lookupFunction<
          FmodStudioSystemLoadBankFileC,
          FmodStudioSystemLoadBankFileDart
        >('FMOD_Studio_System_LoadBankFile');
    systemLoadBankMemory = _studioLib
        .lookupFunction<
          FmodStudioSystemLoadBankMemoryC,
          FmodStudioSystemLoadBankMemoryDart
        >('FMOD_Studio_System_LoadBankMemory');
    systemUnloadAll = _studioLib
        .lookupFunction<
          FmodStudioSystemUnloadAllC,
          FmodStudioSystemUnloadAllDart
        >('FMOD_Studio_System_UnloadAll');
    bankUnload = _studioLib
        .lookupFunction<FmodStudioBankUnloadC, FmodStudioBankUnloadDart>(
          'FMOD_Studio_Bank_Unload',
        );
    systemGetEvent = _studioLib
        .lookupFunction<
          FmodStudioSystemGetEventC,
          FmodStudioSystemGetEventDart
        >('FMOD_Studio_System_GetEvent');
    systemGetBus = _studioLib
        .lookupFunction<FmodStudioSystemGetBusC, FmodStudioSystemGetBusDart>(
          'FMOD_Studio_System_GetBus',
        );
    systemSetParameterByName = _studioLib
        .lookupFunction<
          FmodStudioSystemSetParameterByNameC,
          FmodStudioSystemSetParameterByNameDart
        >('FMOD_Studio_System_SetParameterByName');
    eventDescriptionCreateInstance = _studioLib
        .lookupFunction<
          FmodStudioEventDescriptionCreateInstanceC,
          FmodStudioEventDescriptionCreateInstanceDart
        >('FMOD_Studio_EventDescription_CreateInstance');
    eventInstanceStart = _studioLib
        .lookupFunction<
          FmodStudioEventInstanceStartC,
          FmodStudioEventInstanceStartDart
        >('FMOD_Studio_EventInstance_Start');
    eventInstanceStop = _studioLib
        .lookupFunction<
          FmodStudioEventInstanceStopC,
          FmodStudioEventInstanceStopDart
        >('FMOD_Studio_EventInstance_Stop');
    eventInstanceRelease = _studioLib
        .lookupFunction<
          FmodStudioEventInstanceReleaseC,
          FmodStudioEventInstanceReleaseDart
        >('FMOD_Studio_EventInstance_Release');
    eventInstanceSetParameterByName = _studioLib
        .lookupFunction<
          FmodStudioEventInstanceSetParameterByNameC,
          FmodStudioEventInstanceSetParameterByNameDart
        >('FMOD_Studio_EventInstance_SetParameterByName');
    eventInstanceGetTimelinePosition = _studioLib
        .lookupFunction<
          FmodStudioEventInstanceGetTimelinePositionC,
          FmodStudioEventInstanceGetTimelinePositionDart
        >('FMOD_Studio_EventInstance_GetTimelinePosition');
    eventInstanceSetTimelinePosition = _studioLib
        .lookupFunction<
          FmodStudioEventInstanceSetTimelinePositionC,
          FmodStudioEventInstanceSetTimelinePositionDart
        >('FMOD_Studio_EventInstance_SetTimelinePosition');
    busSetVolume = _studioLib
        .lookupFunction<FmodStudioBusSetVolumeC, FmodStudioBusSetVolumeDart>(
          'FMOD_Studio_Bus_SetVolume',
        );
    busSetMute = _studioLib
        .lookupFunction<FmodStudioBusSetMuteC, FmodStudioBusSetMuteDart>(
          'FMOD_Studio_Bus_SetMute',
        );
    busSetPaused = _studioLib
        .lookupFunction<FmodStudioBusSetPausedC, FmodStudioBusSetPausedDart>(
          'FMOD_Studio_Bus_SetPaused',
        );
  }

  static FmodBindings _load() {
    DynamicLibrary lib;
    if (Platform.isAndroid) {
      try {
        DynamicLibrary.open('libfmod.so');
        lib = DynamicLibrary.open('libfmodstudio.so');
      } catch (e) {
        debugPrint('[FmodBindings] Error opening native FMOD libraries: $e');
        rethrow;
      }
    } else if (Platform.isWindows) {
      try {
        DynamicLibrary.open('fmod.dll');
        lib = DynamicLibrary.open('fmodstudio.dll');
      } catch (e) {
        debugPrint('[FmodBindings] Note: Windows FMOD dll not in path: $e');
        rethrow;
      }
    } else {
      lib = DynamicLibrary.process();
    }
    return FmodBindings._(lib);
  }
}
