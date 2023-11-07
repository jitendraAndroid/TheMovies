#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_jkhetle_themovies_TheMoviesApplication_stringFromJNI(JNIEnv *env, jobject object) {
    std::string auth_token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMTZiMjIxMWQzYTUwYjA3MmViNGYwNmU1ZjRjZDY4OCIsInN1YiI6IjY1M2UzY2ExNTA3MzNjMDBmZjRhOTNmMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.T7JMfFx_dcWD1PP5FLe0_CB6d4bhgsebuAO-_nKWSnk";
    return env->NewStringUTF(auth_token.c_str());
}