package br.com.rm95608.enzo.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.rm95608.enzo.R
import br.com.rm95608.enzo.ui.list.ReposActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var detailsButton: Button
    private lateinit var reposButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.narutonameEditText) // ID correto
        detailsButton = findViewById(R.id.detailsButton) // ID correto
        reposButton = findViewById(R.id.reposButton) // ID correto

        detailsButton.setOnClickListener {
            val naruto = editText.text
            if (naruto.isNotEmpty()) {
                val intent = Intent(this, NarutoDetailsActivity::class.java)
                intent.putExtra("NARUTO", naruto)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, insira um id de personagem.", Toast.LENGTH_SHORT).show()
            }
        }

        reposButton.setOnClickListener {
            val naruto = editText.text
            if (naruto.isNotEmpty()) {
                val intent = Intent(this, ReposActivity::class.java)
                intent.putExtra("NARUTO", naruto)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, insira o id de personagem,", Toast.LENGTH_SHORT).show()
            }
        }
    }
}