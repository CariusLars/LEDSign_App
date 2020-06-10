package com.example.ledsign.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ledsign.R


/**
 * General commands fragment
 */
class CommandFragment : Fragment(){

    // Initialize UI elements
    private lateinit var brightnessBar: SeekBar
    private lateinit var brightnessValue: TextView
    private lateinit var scrollingTextEditable: EditText
    private lateinit var buttonScrollingText: Button
    private lateinit var staticTextEditable: EditText
    private lateinit var buttonStaticText: Button
    private lateinit var buttonScoreboardStart: Button
    private lateinit var buttonScoreboardA: Button
    private lateinit var buttonScoreboardB: Button
    private lateinit var buttonStrobo: Button
    private lateinit var buttonColorStrobo: Button
    private lateinit var buttonRainbow: Button
    private lateinit var buttonStaticColor: Button
    private lateinit var buttonReset: Button

    //Initialize states
    private var stateScrollingText = false
    private var stateStaticText = false
    private var stateScoreboard = false
    private var stateStrobo = false
    private var stateColorStrobo = false
    private var stateRainbow = false
    private var stateStaticColor = false

    //override fun onCreate(savedInstanceState: Bundle?) {
    //    super.onCreate(savedInstanceState)
    //}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_commands, container, false)
        
        //Initialize UI objects
        brightnessValue = root.findViewById(R.id.brightnessValue)
        brightnessBar = root.findViewById(R.id.brightnessBar)
        brightnessBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                val brightnessPercentage = (i/2.55).toInt()
                brightnessValue.text = "$brightnessPercentage %"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Todo: Send UDP message
                //current value: seekBar.progress
            }
        })
        scrollingTextEditable = root.findViewById(R.id.scrollingEditText)
        buttonScrollingText = root.findViewById(R.id.scrollingTextButton)
        buttonScrollingText.setOnClickListener { _ ->
            when(stateScrollingText){
                false -> {
                    stateScrollingText = true
                    buttonScrollingText.text = getString(R.string.button_scrolling_text_cancel)
                    //Todo: Send UDP message
                }
                true -> {
                    stateScrollingText = false
                    buttonScrollingText.text = getString(R.string.button_scrolling_text)
                    scrollingTextEditable.setText("")
                    //Todo: Send UDP message
                }
            }
        }

        staticTextEditable = root.findViewById(R.id.staticEditText)
        buttonStaticText = root.findViewById(R.id.staticTextButton)
        buttonStaticText.setOnClickListener { _ ->
            when(stateStaticText){
                false -> {
                    stateStaticText = true
                    buttonStaticText.text = getString(R.string.button_static_text_cancel)
                    //Todo: Send UDP message
                }
                true -> {
                    stateStaticText = false
                    buttonStaticText.text = getString(R.string.button_static_text)
                    staticTextEditable.setText("")
                    //Todo: Send UDP message
                }
            }
        }

        buttonScoreboardStart = root.findViewById(R.id.scoreboardStartButton)
        buttonScoreboardStart.setOnClickListener { _ ->
            when (stateScoreboard){
                false -> {
                    stateScoreboard = true
                    buttonScoreboardStart.text = getString(R.string.button_scoreboard_start_cancel)
                    //Todo: Send UDP message
                }
                true -> {
                    stateScoreboard = false
                    buttonScoreboardStart.text = getString(R.string.button_scoreboard_start)
                    //Todo: Send UDP message
                }
            }
        }
        buttonScoreboardA = root.findViewById(R.id.scoreboardAButton)
        buttonScoreboardA.setOnClickListener { _ ->
            //Todo: Send UDP message
        }
        buttonScoreboardB = root.findViewById(R.id.scoreboardBButton)
        buttonScoreboardB.setOnClickListener { _ ->
            //Todo: Send UDP message
        }

        buttonStrobo = root.findViewById(R.id.stroboButton)
        buttonStrobo.setOnClickListener { _ ->
            when(stateStrobo){
                false -> {
                    stateStrobo = true
                    buttonStrobo.text = getString(R.string.button_strobo_cancel)
                    // Todo: Send UDP message
                }
                true -> {
                    stateStrobo = false
                    buttonStrobo.text = getString(R.string.button_strobo)
                    // Todo: Send UDP message
                }
            }
        }

        buttonColorStrobo = root.findViewById(R.id.colorStroboButton)
        buttonColorStrobo.setOnClickListener { _ ->
            when(stateColorStrobo){
                false -> {
                    stateColorStrobo = true
                    buttonColorStrobo.text = getString(R.string.button_color_strobo_cancel)
                    // Todo: Send UDP message
                }
                true -> {
                    stateColorStrobo = false
                    buttonColorStrobo.text = getString(R.string.button_color_strobo)
                    // Todo: Send UDP message
                }
            }
        }

        buttonRainbow = root.findViewById(R.id.rainbowButton)
        buttonRainbow.setOnClickListener { _ ->
            when(stateRainbow){
                false -> {
                    stateRainbow = true
                    buttonRainbow.text = getString(R.string.button_rainbow_cancel)
                    // Todo: Send UDP message
                }
                true -> {
                    stateRainbow = false
                    buttonRainbow.text = getString(R.string.button_rainbow)
                    // Todo: Send UDP message
                }
            }
        }

        buttonStaticColor = root.findViewById(R.id.staticColorButton)
        buttonStaticColor.setOnClickListener { _ ->
            when(stateStaticColor){
                false -> {
                    stateStaticColor = true
                    buttonStaticColor.text = getString(R.string.button_static_color_cancel)
                    // Todo: Send UDP message
                }
                true -> {
                    stateStaticColor = false
                    buttonStaticColor.text = getString(R.string.button_static_color)
                    // Todo: Send UDP message
                }
            }
        }

        buttonReset = root.findViewById(R.id.resetButton)
        buttonReset.setOnClickListener { _ ->
            //Todo: Send UDP message
        }
        return root
            }

            companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private const val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            @JvmStatic
            fun newInstance(sectionNumber: Int): CommandFragment {
                return CommandFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_SECTION_NUMBER, sectionNumber)
                    }
                }
            }
        }

        }