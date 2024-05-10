package com.jyotsna.androidkeepstate

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textInfo: TextView
    private lateinit var editText: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var switchButton: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textInfo = findViewById(R.id.text_info)
        editText = findViewById(R.id.edit_text)
        checkBox = findViewById(R.id.check_box)
        switchButton = findViewById(R.id.switch_button)

        button.setOnClickListener {
            textInfo.text = "I have been clicked"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saveText", textInfo.text.toString())
        outState.putString("saveEditText", editText.text.toString())
        outState.putBoolean("saveCheckBox", checkBox.isChecked)
        outState.putBoolean("saveSwitch", switchButton.isChecked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textInfo.text = savedInstanceState.getString("saveText")
        editText.setText(savedInstanceState.getString("saveEditText"))
        checkBox.isChecked = savedInstanceState.getBoolean("saveCheckBox")
        switchButton.isChecked = savedInstanceState.getBoolean("saveSwitch")
    }
}
