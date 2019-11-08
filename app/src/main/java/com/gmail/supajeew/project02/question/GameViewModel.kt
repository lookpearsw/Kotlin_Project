package com.gmail.supajeew.project02.question


import android.util.Log
import androidx.lifecycle.ViewModel
import com.gmail.supajeew.project02.data.Question

class GameViewModel : ViewModel() {
    var scoreQuestion = 0
    var questionIndex = 0
    var numQuestions: Int = 0
    val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "ข้อใดคือคำว่าสวัสดีในภาษาสิงคโปร์?",
            answers = listOf("หนี ห่าว", "ไจ้เจี้ยน", "หวานอัน")
        ),
        Question(
            text = "คำว่า ไจ้เจี้ยน ในภาษาสิงคโปร์มีความหมายว่าอะไร?",
            answers = listOf("พบกันใหม่", "ขอบคุณ", "เชิญ")
        ),
        Question(
            text = "คำว่า สบายดี ในภาษาสิงคโปร์เหมือนกับคำใด",
            answers = listOf("หนี ห่าว", "หนี หาย", "ชื่อ")
        ),
        Question(
            text = "คำว่า ชื่อ มีความหมายว่าอะไร",
            answers = listOf("ใช่", "นามสกุล", "ชื่อเล่น")
        )
    )
    init {
        Log.i("HomeViewModel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("HomeViewModel", "GameViewModel destroyed!")
    }
}
