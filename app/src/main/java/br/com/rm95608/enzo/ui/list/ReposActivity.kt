package br.com.rm95608.enzo.ui.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rm95608.enzo.R
import br.com.rm95608.enzo.api.NarutoApi
import br.com.rm95608.enzo.data.RetrofitClient
import br.com.rm95608.enzo.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var reposAdapter: ReposAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_repo)

        recyclerView = findViewById(R.id.reposTextView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val naruto = intent.getStringExtra("NARUTO") ?: return

        val service = RetrofitClient.getInstance().create(NarutoApi::class.java)
        service.getNarutoRepos(naruto).enqueue(object : Callback<List<Repository>> {
            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
                if (response.isSuccessful) {
                    // Inicialize o adapter com a lista de repositórios
                    reposAdapter = ReposAdapter(response.body() ?: emptyList())
                    recyclerView.adapter = reposAdapter
                } else {
                    Toast.makeText(this@ReposActivity, "Erro ao carregar repositórios.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Toast.makeText(this@ReposActivity, "Falha na conexão.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}