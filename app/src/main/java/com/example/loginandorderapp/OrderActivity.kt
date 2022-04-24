package com.example.loginandorderapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.loginandorderapp.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_order)

        val hesaplaId = findViewById<Button>(R.id.HesaplaBtn)
        val smallbuttonId = findViewById<RadioButton>(R.id.SmallRadioBtn)
        val mediumbuttonId = findViewById<RadioButton>(R.id.MediumRadioBtn)
        val largebuttonId = findViewById<RadioButton>(R.id.LargeRadioBtn)

        val smallbuttonId2 = findViewById<RadioButton>(R.id.SmallRadioBtn2)
        val mediumbuttonId2 = findViewById<RadioButton>(R.id.MediumRadioBtn2)
        val largebuttonId2 = findViewById<RadioButton>(R.id.LargeRadioBtn2)

        fun hesapla()
        {

        }



        // 3rd Party Library Example -- Upload Profile Picture with Glide
        binding.buttonPopulate.setOnClickListener{

            val url ="https://img.icons8.com/ios-glyphs/344/user--v1.png"

            val imagePath = binding.profileUser
            Glide.with(this)
                .load(url)
                .into(imagePath)
        }

        hesaplaId.setOnClickListener(View.OnClickListener {
            if(smallbuttonId.isChecked || mediumbuttonId.isChecked || largebuttonId.isChecked)
            {
                if(smallbuttonId2.isChecked || mediumbuttonId2.isChecked || largebuttonId2.isChecked)
                {

                }
                else
                {
                    Toast.makeText(this, "Lütfen yemeğin herhangi bir opsiyonunu seçiniz.", Toast.LENGTH_LONG)
                        .show()
                }

            }
            else
            {
                Toast.makeText(this, "Lütfen yemeğin herhangi bir opsiyonunu seçiniz.", Toast.LENGTH_LONG)
                    .show()
            }
        })


        val imageView = findViewById<ImageView>(R.id.profileUser)

        val message = intent.getStringExtra("EXTRA_MESSAGE")

        val AdSoyadText = findViewById<TextView>(R.id.AdSoyadText).apply {
            text = message
        }

        val message1 = intent.getStringExtra("EXTRA_MESSAGE")

        val EmailText = findViewById<TextView>(R.id.EmailText).apply {
            text = message1
        }

        /*val URL = "https://www.petihtiyac.com/Data/Blog/1/198.jpg"
        imageView.setOnClickListener{
            Glide.with(this).load(URL).into(imageView)
        }

         */

        /*val url = ("https://www.petihtiyac.com/Data/Blog/1/198.jpg")
        Glide.with(this)
            .load("https://www.petihtiyac.com/Data/Blog/1/198.jpg")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .transform(CircleCrop())
            .into(imageView)
            */
    }
}