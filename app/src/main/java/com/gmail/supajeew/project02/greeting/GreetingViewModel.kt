package com.gmail.supajeew.project02.greeting

import androidx.lifecycle.ViewModel
import com.gmail.supajeew.project02.data.Greeting

class GreetingViewModel: ViewModel() {
    var data = listOf(
        Greeting("หนี ห่าว","สวัสดี"),
        Greeting("ซี่ยย เซี่ย","ขอบคุณ"),
        Greeting("หนี ห่าว","สบายดีไหม"),
        Greeting("เหิ่น เกา ซิ่ง เริ่น ชื่อ หนี่","ยินดีที่ได้รู้จัก"),
        Greeting("ไจ้เจี้ยน","พบกันใหม่"),
        Greeting("หวานอัน","นอนหลับฝันดี"),
        Greeting("ฮวน หยิง","เชิญ"),
        Greeting("ชื่อ","ใช่"),
        Greeting("บู๋ชื่อ","ไม่ใช่"),
        Greeting("เทียน ชี เหิ่น ห่าว","อากาศดีจัง"),
        Greeting("เทียน ชี เหิ่น เร่อ","อากาศร้อนมาก"),
        Greeting("เทียน ชี เหิ่น เหลิ่ง","อากาศหนาวมาก"),
        Greeting("เหมย เฉิน เมอ","ไม่เป็นไร"),
        Greeting("ไจ้เจี้ยน","ลาก่อน")

    )
}