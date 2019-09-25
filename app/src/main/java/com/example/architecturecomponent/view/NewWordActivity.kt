package com.example.architecturecomponent.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.architecturecomponent.R
import com.example.architecturecomponent.utils.EXTRA_KEY_MEANING
import com.example.architecturecomponent.utils.EXTRA_KEY_WORD
import com.example.architecturecomponent.utils.RESULT_ERROR
import com.example.architecturecomponent.utils.RESULT_SAVE

class NewWordActivity : AppCompatActivity() {

    private lateinit var mWordEditText: EditText
    private lateinit var mMeaningEditText: EditText
    private lateinit var mSaveBtn: Button
    private lateinit var mDeleteBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        mWordEditText = findViewById(R.id.word_text)
        mMeaningEditText = findViewById(R.id.meaning_text)
        mSaveBtn = findViewById(R.id.btn_save)
        mDeleteBtn = findViewById(R.id.btn_delete)

        mSaveBtn.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(mWordEditText.text) || TextUtils.isEmpty(mMeaningEditText.text)){
                setResult(RESULT_ERROR, intent)
            }else{
                intent.putExtra(EXTRA_KEY_WORD, mWordEditText.text.toString())
                intent.putExtra(EXTRA_KEY_MEANING, mMeaningEditText.text.toString())
                setResult(RESULT_SAVE, intent)
            }
            finish()
        }

        mDeleteBtn.setOnClickListener {
            //TODO delete action
        }

    }
}
