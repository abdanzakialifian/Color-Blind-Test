package com.ump.ishiharacolorblindtest.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ump.ishiharacolorblindtest.R
import com.ump.ishiharacolorblindtest.databinding.ItemJawabanBinding
import com.ump.ishiharacolorblindtest.model.SavedAnswer

class AnswerAdapter : RecyclerView.Adapter<AnswerAdapter.ListViewHolder>() {
    private var savedAnswer = ArrayList<SavedAnswer>()
    private val number = arrayListOf<Int>()

    fun setData(list: List<SavedAnswer>?) {
        if (list == null) return
        this.savedAnswer.clear()
        this.savedAnswer.addAll(list)
        for (i in 1..savedAnswer.size) {
            number.add(i)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ListViewHolder {
        val viewBinding =
            ItemJawabanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindData(savedAnswer[position], number[position])
    }

    override fun getItemCount(): Int {
        return savedAnswer.size
    }

    @SuppressLint("SetTextI18n")
    class ListViewHolder(private val binding: ItemJawabanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(savedAnswer: SavedAnswer, i: Int) {
            with(binding) {
                noPlate.text =
                    itemView.context.resources.getString(
                        R.string.no_plate, savedAnswer.questionNumber
                    )
                if (savedAnswer.answer != savedAnswer.correctAns) {
                    imgPlate.setImageResource(R.drawable.ic_uncheck)
                    imgPlate.imageTintList =
                        ColorStateList.valueOf(itemView.context.resources.getColor(R.color.uncheck_color))
                } else {
                    imgPlate.setImageResource(R.drawable.ic_check)
                    imgPlate.imageTintList =
                        ColorStateList.valueOf(itemView.context.resources.getColor(R.color.check_color))
                }
                itemView.setOnClickListener {
                    val a = when (savedAnswer.questionNumber) {
                        "9" -> when (savedAnswer.answer) {
                            "garis3_1" -> {
                                "2"
                            }
                            "garis3_2" -> {
                                "8"
                            }
                            else -> {
                                "tidak ada"
                            }
                        }
                        "11" -> when (savedAnswer.answer) {
                            "garis2_1" -> {
                                "pilihan 1"
                            }
                            "garis2_2" -> {
                                "pilihan 2"
                            }
                            else -> {
                                "pilihan 3"
                            }
                        }
                        "14" -> when (savedAnswer.answer) {
                            "garis4_1" -> {
                                "pilihan 1"
                            }
                            "garis4_2" -> {
                                "pilihan 2"
                            }
                            else -> {
                                "pilihan 3"
                            }
                        }
                        else -> {
                            savedAnswer.answer
                        }
                    }
                    Toast.makeText(
                        itemView.context, "Anda menjawab: $a", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}