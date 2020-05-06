package com.example.quizapp

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1 // number of question
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        // to hide status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mQuestionsList = Constants.getQuestions()

        // populate views
        setQuestion()

        tv_option_one.setOnClickListener (this)
        tv_option_two.setOnClickListener (this)
        tv_option_three.setOnClickListener (this)
        tv_option_four.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {selectedOptionView(tv_option_one, 1)}
            R.id.tv_option_two -> {selectedOptionView(tv_option_two, 2)}
            R.id.tv_option_three -> {selectedOptionView(tv_option_three, 3)}
            R.id.tv_option_four -> {selectedOptionView(tv_option_four, 4)}
        }
    }

    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentPosition-1] // Getting the question from the list
        // set default for options each time we set question
        defaultOptionsView()

        // put the question data into the UI components
        progressBar.progress = mCurrentPosition
        tv_progress.text = getString(R.string.tv_progress, mCurrentPosition, progressBar.max)

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(ContextCompat.getColor(this,R.color.defaultOptionColor))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        // reset previous choice to default before choosing new one
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(ContextCompat.getColor(this, R.color.tvColor))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg)

    }

}
