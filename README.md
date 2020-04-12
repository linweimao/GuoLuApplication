# GuoLuApplication
NDK开发之锅炉压力系统

1. 创建一个项目，名字叫GuoLu

   1. 写 JNI.java（或者：在MainActivity里面写，得到锅炉压力值的native方法 getPressure()）

   2. 在 Android.mk 文件中配置生成 .so文件的名称

      Android.mk
      ```java
      LOCAL_PATH := $(call my-dir)
      include $(CLEAR_VARS)
      
      LOCAL_LDLIBS := -llog
      LOCAL_MODULE := guolu
      LOCAL_SRC_FILES := GuoLu.c
      
      include $(BUILD_SHARED_LIBRARY)
      ```

      Application.mk
      ```java
      APP_ABI := all
      APP_STL := stlport_static
      ```

2. 分析实现的原理

3. 在C代码中写锅炉压力值，返回给Java

   ```c
   int getPressure(){
   	int pressure = rand()%250;
   	return pressure;
   } 
   ```

   在 C 代码中实现如下：

   ```c
   
   #include <stdio.h>
   #include <stdlib.h>
   #include <jni.h>
   
   
   /*
    * 得到锅炉的压力值
    * 0~250之间
   */
   
   int getPressure(){
      int pressure = rand()%250;
      return pressure;
   }
   
   /*
    * 从锅炉感应器中得到锅炉压力值
   */
   jint  Java_com_lwm_guoluapplication_MainActivity_getPressure(JNIEnv *env, jobject instance) {
       int pressur = getPressure();
       return pressur;
   }
   ```

4. 在视图中动态绘制

