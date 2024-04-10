package ru.kuznetsov.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
private const val EXTRA_ASNWER_IS_TRUE  = "ru.kuznetsov.geoquiz.answer_is_true"
internal const val ANSWER_SHOWN = "ru.kuznetsov.geoquiz.answer_shown"

class CheatActivity : AppCompatActivity() {
    private var answerIsTrue = false
    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        answerIsTrue = intent.getBooleanExtra(EXTRA_ASNWER_IS_TRUE, false)
        answerTextView = findViewById(R.id.answer_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)
        showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
            setAnswerShownResult(true)
        }
    }
companion object{
    fun newIntent(packagecontext: Context, answerIsTrue: Boolean):Intent{
        return Intent(packagecontext, CheatActivity::class.java).apply {
            putExtra(EXTRA_ASNWER_IS_TRUE, answerIsTrue)
        }
    }
}
private fun setAnswerShownResult(isAnswerShown: Boolean){
    val data = Intent().apply {
        putExtra(ANSWER_SHOWN, isAnswerShown)
    }
    setResult(Activity.RESULT_OK, data)
}




}


