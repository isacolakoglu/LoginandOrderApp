package com.example.loginandorderapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val fullnameId = findViewById<EditText>(R.id.profileFullNameTxt)
        val emailId = findViewById<EditText>(R.id.profileEmailOrPhoneTxt)
        val passwordId = findViewById<EditText>(R.id.profilePasswordTxt)
        val kayitolbutonId = findViewById<Button>(R.id.kayitBtn)
        val checkboxId = findViewById<CheckBox>(R.id.agreementCheckbox)
        val radiobuttonId = findViewById<RadioButton>(R.id.radioButtonMale)
        val radiobuttonId2 = findViewById<RadioButton>(R.id.radioButtonFemale)

        var profileFullNameTxt: EditText



        kayitolbutonId.setOnClickListener(View.OnClickListener {
            if(fullnameId.text.toString().isNotEmpty())
            {
                // Check email address -- Validation
                if (emailId.text.toString().isValidEmail())
                {
                    if(emailId.text.toString().matches(emailAddressRegex!!.toRegex()))
                    {
                        if(passwordId.text.toString().isNotEmpty())
                        {
                            // Check Password Length
                            if (passwordId.text.length >= 8)
                            {
                                if (radiobuttonId.isChecked || radiobuttonId2.isChecked)
                                {
                                    // Check Agreements Checkbox
                                    if (checkboxId.isChecked)
                                    {
                                        val intent = Intent(applicationContext, OrderActivity::class.java)
                                        startActivity(intent)
                                        callActivity()

                                    }
                                    else
                                    {
                                        Toast.makeText(this, "Lütfen KVKK sözleşmesini işaretleyiniz.", Toast.LENGTH_LONG)
                                            .show()
                                    }
                                }
                                else
                                {
                                    Toast.makeText(this, "Lütfen Cinsiyetinizi Belirleyiniz.", Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                            else
                            {
                                Toast.makeText(
                                    this,
                                    "Şifrenizin karakter sayısı 8 den az olmamalı.",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                        else
                        {
                            Toast.makeText(this, "Lütfen Şifrenizi Doldurunuz.", Toast.LENGTH_LONG).show()
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "@yalova.edu.tr formatında olmalıdır.", Toast.LENGTH_LONG).show()
                    }
                }
                else
                {
                    Toast.makeText(this, "Lütfen Email adresinizi kontrol ediniz.", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(this, "Lütfen isminizi doldurunuz.", Toast.LENGTH_LONG).show()
            }
        })
    }
    val emailAddressRegex: String? = "[a-zA-Z0-9._-]+@yalova.edu.tr"

    // String Extension Function for Email Validation
    private fun String.isValidEmail() =
        !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun callActivity() {
        val editText = findViewById<EditText>(R.id.profileFullNameTxt)
        val message = editText.text.toString()
        val intent = Intent(this, OrderActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE", message)
            startActivity(it)
        }
    }

    /*private fun callActivity1()
    {
        val editText1 = findViewById<EditText>(R.id.profileEmailOrPhoneTxt)
        val message1 = editText1.text.toString()

        val intent = Intent(this, OrderActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE", message1)

            startActivity(it)
        }
    }

     */
}