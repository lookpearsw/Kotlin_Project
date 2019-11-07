package com.gmail.supajeew.project02


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.gmail.supajeew.project02.databinding.FragmentHomeBinding
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_score.*

class QuestionFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "ข้อใดคือคำว่าสวัสดีในภาษาสิงคโปร์?",
            answers = listOf("หนี ห่าว", "ไจ้เจี้ยน", "หวานอัน")),
        Question(text = "คำว่า ไจ้เจี้ยน ในภาษาสิงคโปร์ หมายความว่าอะไร?",
            answers = listOf("ขอบคุณ", "เชิญ", "พบกันใหม่")),
        Question(text = "คำว่า สบายดี ในภาษาสิงคโปร์เหมือนกับคำใด",
            answers = listOf("หนี หาย", "หนี ห่าว", "ชื่อ"))
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size) / 1, 2)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(inflater,
            R.layout.fragment_question,container,false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
//        binding.game = this

        // Set the onClickListener for the submitButton
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

                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(R.id.action_questionFragment_to_scoreFragment)
                    }
                } else {
                    view.findNavController()
                        .navigate(R.id.action_questionFragment_to_scoreFragment)
                }
            }
        }

        return binding.root
    }
    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
//        answers.shuffle()
//        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.game, questionIndex + 1, numQuestions)
    }
}
