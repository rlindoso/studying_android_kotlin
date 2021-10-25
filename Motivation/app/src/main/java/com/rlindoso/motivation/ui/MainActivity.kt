package com.rlindoso.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.rlindoso.motivation.R
import com.rlindoso.motivation.infra.MotivationConstants
import com.rlindoso.motivation.infra.SecurityPreferences
import com.rlindoso.motivation.infra.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        textName.text = getString(R.string.hello_name, name)

        imageAll.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
        handleNewPhrase()

        buttonNewPhrase.setOnClickListener(this)
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)

        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.white))

        when (id) {
            R.id.imageAll -> {
                imageAll.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
                if (mPhraseFilter != MotivationConstants.PHRASEFILTER.ALL) handleNewPhrase()
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
                if (mPhraseFilter != MotivationConstants.PHRASEFILTER.HAPPY) handleNewPhrase()
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
                if (mPhraseFilter != MotivationConstants.PHRASEFILTER.MORNING) handleNewPhrase()
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }

    }

    private fun handleNewPhrase() {
        textPhrase.text = Mock().getPhrase(mPhraseFilter)
    }
}