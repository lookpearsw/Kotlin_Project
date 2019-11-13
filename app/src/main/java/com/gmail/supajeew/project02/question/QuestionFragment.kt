package com.gmail.supajeew.project02.question

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.gmail.supajeew.project02.R
import com.gmail.supajeew.project02.data.Question
import com.gmail.supajeew.project02.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private lateinit var viewModel: GameViewModel
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(inflater,
            R.layout.fragment_question,container,false)

        Log.i("HomeFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        viewModel.numQuestions = Math.min((viewModel.questions.size  ) / 1, 4)

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
                    viewModel.questionIndex++
                    viewModel.scoreQuestion++
                    // Advance to the next question
                    if (viewModel.questionIndex < viewModel.numQuestions) {
                        currentQuestion = viewModel.questions[viewModel.questionIndex]
                        Toast.makeText(context,"True!", Toast.LENGTH_SHORT).show()
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(
                                QuestionFragmentDirections.actionQuestionFragmentToScoreFragment(
                                    viewModel.scoreQuestion
                                )
                            )
                    }
                } else {

                    view.findNavController()
                        .navigate(
                            QuestionFragmentDirections.actionQuestionFragmentToScoreFragment(
                                viewModel.scoreQuestion
                            )
                        )
                }
            }
            Log.i("checkScore",viewModel.scoreQuestion.toString())
        }

        return binding.root
    }
     //randomize the questions and set the first question
    private fun randomizeQuestions() {
         viewModel.questions.shuffle()
         viewModel.questionIndex = 1
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = viewModel.questions[viewModel.questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()

        var score =  viewModel.scoreQuestion + 1
        (activity as AppCompatActivity).supportActionBar?.title = "QUESTION $score / 3"
    }
}
