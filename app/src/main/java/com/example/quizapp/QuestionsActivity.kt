package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvAnswerOne: TextView? = null
    private var tvAnswerTwo: TextView? = null
    private var tvAnswerThree: TextView? = null
    private var tvAnswerFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById((R.id.progressBar))
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.question)
        ivImage = findViewById(R.id.ivImage)
        tvAnswerOne = findViewById(R.id.answer1)
        tvAnswerTwo = findViewById(R.id.answer2)
        tvAnswerThree = findViewById(R.id.answer3)
        tvAnswerFour = findViewById(R.id.answer4)
        btnSubmit = findViewById(R.id.buttonSubmit)
        mQuestionsList = Constants.getQuestions()
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        tvAnswerOne?.setOnClickListener(this)
        tvAnswerTwo?.setOnClickListener(this)
        tvAnswerThree?.setOnClickListener(this)
        tvAnswerFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()


    }

    private fun setQuestion() {
        defaultOpt()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvAnswerOne?.text = question.optionOne
        tvAnswerTwo?.text = question.optionTwo
        tvAnswerThree?.text = question.optionThree
        tvAnswerFour?.text = question.optionFour
        ivImage?.setImageResource(question.image)

        if(mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "Finish"
        } else {
            btnSubmit?.text = "Next"
        }
    }

    private fun defaultOpt() {
        val options = ArrayList<TextView>()
        tvAnswerOne?.let{
            options.add(0, it)
        }
        tvAnswerTwo?.let{
            options.add(1, it)
        }
        tvAnswerThree?.let{
            options.add(2, it)
        }
        tvAnswerFour?.let{
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.border_question
            )
        }

    }

    private fun selectedOption(tv:TextView, selectedOptionNum: Int) {
        defaultOpt()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_border
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.answer1 -> {
                tvAnswerOne?.let{
                    selectedOption(it, 1)
                }
            }
            R.id.answer2 -> {
                tvAnswerTwo?.let{
                    selectedOption(it, 2)
                }
            }
            R.id.answer3 -> {
                tvAnswerThree?.let{
                    selectedOption(it, 3)
                }
            }
            R.id.answer4 -> {
                tvAnswerFour?.let{
                    selectedOption(it, 4)
                }
            }

            R.id.buttonSubmit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else ->{
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.border_questionvar2)
                    }else{
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.border_questionvar1)

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.text = "Finish"
                    } else {
                        btnSubmit?.text = "Next"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tvAnswerOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvAnswerTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tvAnswerThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvAnswerFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}