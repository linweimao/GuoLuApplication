//
// Created by 林伟茂 on 2020/4/12.
//

#include <stdio.h>
#include <stdlib.h>
#include <jni.h>


/*
 * 得到锅炉的压力值
 * 0~250之间
*/

int pressure = 20;
int getPressure(){
	int incease = rand()%20;
    pressure += incease;
	return pressure;
}

/*
 * 从锅炉感应器中得到锅炉压力值
*/
jint  Java_com_lwm_guoluapplication_MainActivity_getPressure(JNIEnv *env, jobject instance) {
    int pressur = getPressure();
    return pressur;
}