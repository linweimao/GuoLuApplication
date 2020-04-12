LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_LDLIBS := -llog
LOCAL_MODULE := guolu
LOCAL_SRC_FILES := GuoLu.c

include $(BUILD_SHARED_LIBRARY)
