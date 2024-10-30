package br.com.rm95608.enzo.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rm95608.enzo.R
import br.com.rm95608.enzo.model.Repository

class ReposAdapter(private val repos: List<Repository>) : RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoNameTextView: TextView = itemView.findViewById(R.id.repoNameTextView)
        val repoIdTextView: TextView = itemView.findViewById(R.id.repoIdTextView)
        val repoImageView: TextView = itemView.findViewById(R.id.repoImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_item, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repos[position]
        holder.repoNameTextView.text = repo.name
        holder.repoIdTextView.text = repo.id.toString() ?: "N/A"
        holder.repoImageView.text = repo.images.toString()
    }

    override fun getItemCount() = repos.size
}
