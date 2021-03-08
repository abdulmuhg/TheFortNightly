package com.abdulmughni.personal.thefortnightly.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdulmughni.personal.thefortnightly.R
import com.abdulmughni.personal.thefortnightly.core.data.source.local.entity.ArticleEntity
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.databinding.ItemArticleBinding
import com.bumptech.glide.Glide

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ListViewHolder>() {

    private var listData = ArrayList<Article>()
    var onItemClick: ((Article) -> Unit)? = null

    fun setData(newListData: List<Article>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemArticleBinding.bind(itemView)
        fun bind(data: Article){
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.thumbnail)
                    .into(contentImage)
                titleText.text = data.title
                categoryText.text = data.itemType
                description.text = data.abstracts
                author.text = data.byLine
                publishTimeText.text = data.publishedDate
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size
}