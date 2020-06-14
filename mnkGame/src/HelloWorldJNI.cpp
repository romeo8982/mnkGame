#include "HelloWorldJNI.h"
JNIEXPORT void JNICALL Java_HelloWorldJNI_sayHello
  (JNIEnv* env, jobject thisObject) {
    std::cout << "Hello from C++ !!" << std::endl;
}