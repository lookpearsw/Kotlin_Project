package com.gmail.supajeew.project02


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
  private  var scoreQuestion = 0
    data class Question(
        val text: String,
        val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "ข้อใดคือคำว่าสวัสดีในภาษาสิงคโปร์?",
            answers = listOf("หนี ห่าว", "ไจ้เจี้ยน", "หวานอัน")),
        Question(text = "คำว่า ไจ้เจี้ยน ในภาษาสิงคโปร์มีความหมายว่าอะไร?",
            answers = listOf("พบกันใหม่", "ขอบคุณ", "เชิญ")),
        Question(text = "คำว่า สบายดี ในภาษาสิงคโปร์เหมือนกับคำใด",
            answers = listOf("หนี ห่าว", "หนี หาย", "ชื่อ")),
        Question(text = "คำว่า ชื่อ มีความหมายว่าอะไร",
            answers = listOf("ใช่", "นามสกุล", "ชื่อเล่น"))
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size  ) / 1, 4)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(inflater,
            R.layout.fragment_question,container,false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.ans1_radioButton -> answerIndex = 0
                    R.id.ans2_radioButton -> answerIndex = 1
                    R.id.ans3_radioButton -> answerIndex = 2
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    scoreQuestion++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(QuestionFragmentDirections
                                .actionQuestionFragmentToScoreFragment(scoreQuestion))

                    }
                } else {
                    view.findNavController()
                        .navigate(QuestionFragmentDirections
                            .actionQuestionFragmentToScoreFragment(scoreQuestion))
                }
            }
            Log.i("checkScore",scoreQuestion.toString())
        }

        return binding.root
    }
    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 1
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()

        (activity as AppCompatActivity).supportActionBar?.title = "QUESTION"
    }
}
