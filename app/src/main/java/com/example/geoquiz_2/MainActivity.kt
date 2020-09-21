package com.example.geoquiz_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var  trueButton: Button
    private lateinit var falseButton:Button
    private lateinit var nextButton: ImageButton
    private lateinit var previousButton:ImageButton
    private lateinit var questionTextView: TextView
    private var questionBank = listOf(
            Question(R.string.question_text, true),
            Question(R.string.question_text1, false),
            Question(R.string.question_text2, false),
            Question(R.string.question_text3, false),
            Question(R.string.question_text4, true),
            )
private var currentIndex = 0
    private fun updateQuestion() {
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)    }

    private fun checkAnswer(userAnswer:Boolean){
        var correctAnswer=questionBank[currentIndex].answer
        var messageResId= if(userAnswer==correctAnswer){
            R.string.correct_toast
        }
        else{R.string.incorrect_toast}
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton=findViewById(R.id.true_button)
        falseButton=findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener{
            checkAnswer(true)
        }
        falseButton.setOnClickListener{
            checkAnswer(false)
        }

   questionTextView.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

    nextButton.setOnClickListener {
    currentIndex = (currentIndex +1) % questionBank.size
    updateQuestion()
}

  previousButton.setOnClickListener {
 if(currentIndex==0 || currentIndex<0) currentIndex=questionBank.size
 currentIndex = (currentIndex -1) % questionBank.size
              updateQuestion()
  }
     updateQuestion()
    }
}
