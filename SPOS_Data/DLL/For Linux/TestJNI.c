#include <stdio.h>
#include <jni.h>
#include "TestJNI.h"
JNIEXPORT jint JNICALL Java_TestJNI_add(JNIEnv *env, jobject thisObj, jint n1, jint n2){

jint res;

res = n1+n2;

return res;

}

JNIEXPORT jint JNICALL Java_TestJNI_sub(JNIEnv *env , jobject thisObj, jint n1, jint n2){

jint res;

res =  n1-n2;

return res;

}
/*
//DefineClass

jclass DefineClass(JNIEnv *env, const char *name, jobject loader,
const jbyte *buf, jsize bufLen);

Loads a class from a buffer of raw class data. The buffer containing the raw class data is not referenced by the VM after the DefineClass call returns, and it may be discarded if desired.

LINKAGE:

Index 5 in the JNIEnv interface function table.
PARAMETERS:

env: the JNI interface pointer.

name: the name of the class or interface to be defined. The string is encoded in modified UTF-8.

loader: a class loader assigned to the defined class.

buf: buffer containing the .class file data.

bufLen: buffer length.
RETURNS:

Returns a Java class object or NULL if an error occurs.
*/


