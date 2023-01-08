package com.ump.ishiharacolorblindtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ump.ishiharacolorblindtest.R
import com.ump.ishiharacolorblindtest.databinding.ItemListChoiceBinding
import com.ump.ishiharacolorblindtest.helper.blueBackgroundRound10
import com.ump.ishiharacolorblindtest.helper.textColorBlack
import com.ump.ishiharacolorblindtest.helper.textColorWhite
import com.ump.ishiharacolorblindtest.helper.whiteBackgroundRound10

class MultipleChoiceAdapter :
    RecyclerView.Adapter<MultipleChoiceAdapter.MultipleChoiceViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private var listMultipleChoice = ArrayList<String>()
    private var selectedItemPosition = -1

    fun setListMultipleChoice(listMultipleChoice: ArrayList<String>) {
        this.listMultipleChoice = listMultipleChoice
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class MultipleChoiceViewHolder(private val binding: ItemListChoiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, positions: Int) {
            binding.apply {
                imgChoice.setImageResource(
                    itemView.resources.getIdentifier(
                        item, "drawable", itemView.context.packageName
                    )
                )

                val numberOfChoice = positions + 1
                tvChoice.text =
                    itemView.resources.getString(R.string.selected, numberOfChoice.toString())

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(item)
                    selectedItemPosition = positions
                    notifyDataSetChanged()
                }

                if (selectedItemPosition == positions) {
                    layoutChoice.blueBackgroundRound10(itemView.context)
                    tvChoice.textColorWhite(itemView.context)
                } else {
                    layoutChoice.whiteBackgroundRound10(itemView.context)
                    tvChoice.textColorBlack(itemView.context)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleChoiceViewHolder =
        ItemListChoiceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ).run {
            MultipleChoiceViewHolder(this)
        }

    override fun onBindViewHolder(holder: MultipleChoiceViewHolder, position: Int) {
        holder.bind(listMultipleChoice[position], position)
    }

    override fun getItemCount(): Int = listMultipleChoice.size

    interface OnItemClickCallback {
        fun onItemClicked(answer: String)
    }
}