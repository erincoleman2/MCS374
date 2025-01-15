package com.example.geoquiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Snackbar



class MainActivity : ComponentActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)


        trueButton.setOnClickListener {

          // need to make a snackbar that goes in here
            /*
            Snackbar.make(it, R.string.correct_toast, Snackbar.LENGTH_LONG)
                .setAction("Show Toast") {
                    val toastTrue = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT)
                    toastTrue.setGravity(Gravity.TOP,0,0)
                    toastTrue.show()
                }
                .show()

             */
        }


        falseButton.setOnClickListener{view:View ->
            Toast.makeText(this,
                R.string.incorrect_message,
                Toast.LENGTH_SHORT).show()
        }
    }
}

