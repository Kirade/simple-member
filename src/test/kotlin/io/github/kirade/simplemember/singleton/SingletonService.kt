package io.github.kirade.simplemember.singleton

class SingletonService private constructor(){
    companion object {
         private var instance: SingletonService? = null

        fun getInstance(): SingletonService {
            return instance ?: synchronized(this) {
                SingletonService().also { instance = it}
            }
        }
    }

    fun logic() {
        println("싱글턴 객체 로직 호출")
    }
}

object SingletonServiceObject {}
