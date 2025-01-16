package com.example.hellokittyquiz

import androidx.annotation.StringRes

// making a data class
//each class object is a question, consisting of a question with
// an id and a boolean answer
data class Question (@StringRes val textResId: Int, val answer: Boolean){

}