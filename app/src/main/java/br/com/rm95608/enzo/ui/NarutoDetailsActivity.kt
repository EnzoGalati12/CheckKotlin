package br.com.rm95608.enzo.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.rm95608.enzo.R
import br.com.rm95608.enzo.api.NarutoApi
import br.com.rm95608.enzo.data.RetrofitClient
import br.com.rm95608.enzo.model.Naruto
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NarutoDetailsActivity : AppCompatActivity() {

    private lateinit var narutoNameTextView: TextView
    private lateinit var ocuppationTextView: TextView
    private lateinit var avatarImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.naruto_details)

        // Inicializando as Views com os IDs corretos
        narutoNameTextView = findViewById(R.id.narutoNameTextView)
        ocuppationTextView = findViewById(R.id.ocuppationTextView)
        avatarImageView = findViewById(R.id.avatarImageView)

        val username = intent.getStringExtra("NARUTO") ?: return

        val service = RetrofitClient.getInstance().create(NarutoApi::class.java)
        service.getNarutoInfo(username).enqueue(object : Callback<Naruto> {
            override fun onResponse(call: Call<Naruto>, response: Response<Naruto>) {
                if (response.isSuccessful) {
                    val naruto = response.body()
                    narutoNameTextView.text = naruto?.name ?: "Nome não disponível"
                    ocuppationTextView.text = "Seguidores: ${naruto?.personal?.occupation ?: 0}"
                    Glide.with(this@NarutoDetailsActivity).load(naruto?.images).into(avatarImageView)
                }
            }

            override fun onFailure(call: Call<Naruto>, t: Throwable) {
                // Tratar falha
                Toast.makeText(this@NarutoDetailsActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}