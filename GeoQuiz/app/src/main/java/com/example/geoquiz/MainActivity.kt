package com.example.geoquiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.android.material.snackbar.Snackbar
import com.example.geoquiz.databinding.ActivityMainBinding



class MainActivity : ComponentActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.questionTextView.setOnClickListener{
            currentIndex = (currentIndex+1) % questionBank.size
            updateQuestion()
        }

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener{view:View ->
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex+1) % questionBank.size
            updateQuestion()
        }
        binding.prev_button.setOnClickListener{
            currentIndex = (currentIndex-1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()

    }
    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(given: Boolean){
        val correct = questionBank[currentIndex].answer
        if (given == correct){
            //Snackbar.make(binding, R.string.correct_message, Snackbar.LENGTH_SHORT).show()
            Toast.makeText(this,
                R.string.correct_message,
                Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,
                R.string.incorrect_message,
                Toast.LENGTH_SHORT).show()

            //get the id of the message to show
            val messageResId = if (given == correct) {
                R.string.correct_message
            }
            else
            { R.string.incorrect_message
            }

        //make a toast with that message
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT) .show()
        }
    }
}

