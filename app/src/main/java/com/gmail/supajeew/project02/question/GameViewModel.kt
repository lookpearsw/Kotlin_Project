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
            text = "ข้อใดคือคำว่า \"สวัสดี\" ในภาษาสิงคโปร์?",
            answers = listOf("หนี ห่าว", "ไจ้เจี้ยน", "หวานอัน")
        ),
        Question(
            text = "คำว่า \"ไจ้เจี้ยน\" หมายความว่าอะไรบ้าง?",
            answers = listOf("พบกันใหม่, ลาก่อน", "ขอบคุณ, ไม่เป็นไร", "เชิญ, ยินดีต้อนรับ")
        ),
        Question(
            text = "คำว่า \"สบายดี\" ตรงกับคำใด?",
            answers = listOf("หนี ห่าว", "หนี หาย", "สบายใจ")
        ),
        Question(
            text = "คำว่า \"บู๋ชื่อ\" หมายความว่าอะไร?",
            answers = listOf("ไม่ใช่", "ใช่", "ไม่บอก")
        ),
        Question(
            text = "คำว่า \"เทียน ชี เหิ่น เร่อ\" แปลว่าอะไร?",
            answers = listOf("อากาศร้อนมาก", "อากาศเย็นสบาย", "อากาศดีมาก")
        ),
        Question(
            text = "คำว่า \"ชื่อ\" มีความหมายว่าอะไร?",
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
