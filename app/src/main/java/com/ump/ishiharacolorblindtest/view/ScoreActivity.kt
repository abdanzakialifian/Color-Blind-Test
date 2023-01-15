package com.ump.ishiharacolorblindtest.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.flexbox.FlexboxLayoutManager
import com.ump.ishiharacolorblindtest.adapter.AnswerAdapter
import com.ump.ishiharacolorblindtest.databinding.ActivityScoreBinding
import com.ump.ishiharacolorblindtest.model.SavedAnswer


class ScoreActivity : AppCompatActivity() {
    private var onBackPressed = false

    private lateinit var binding: ActivityScoreBinding

    private var parsial = arrayListOf<String>()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        binding.backBtn.setOnClickListener {
            Intent(this, HomeActivity::class.java).apply {
                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
            this.finish()
        }

        val listFromActivity1: ArrayList<SavedAnswer> =
            intent.getSerializableExtra(TEST_RESULT) as ArrayList<SavedAnswer>

        Log.d("SavedAnswer: ", listFromActivity1.toString())

        val answerAdapter = AnswerAdapter()

        binding.recylerviewJawaban.apply {
            setHasFixedSize(true)
            layoutManager = FlexboxLayoutManager(context)
            answerAdapter.setData(listFromActivity1)
            adapter = answerAdapter
        }

        // cek kondisi mata
        val arrSkor = arrayListOf<String>()
        parsial = arrayListOf(
            "12", "3", "2", "70", "21", "-", "-", "-",
            "garis3_1", "-", "-", "3/5", "9/6", "garis4_3"
        )

        val answerList = arrayListOf<String>()

        for ((i, v) in listFromActivity1.withIndex()) {
            answerList.add(i, v.answer)
        }

        Log.i("SavedAnswerList", answerList.toString())

        var isTotal = true
        var isNormal = true
        for ((i, sv) in listFromActivity1.withIndex()) {
            var a = ""
            when {
                sv.answer == sv.correctAns -> {
                    a = sv.answer
                }
                sv.answer == parsial[i] -> {
                    isNormal = false
                    a = parsial[i]
                }
                "/" in parsial[i] -> {
                    a = when (sv.answer) {
                        parsial[i].split("/")[0] -> parsial[i]
                        parsial[i].split("/")[1] -> parsial[i]
                        else -> "-"
                    }
                }
                else -> {
                    isNormal = false
                    a = "-"
                }
            }
            arrSkor.add(a)
        }
        // dua kondisi
        // jika palet 1 jawaban 12 dan sum total adalah 12
        if (arrSkor[0] == "12") {
            val newSkor = arrayListOf<Int>()
            for ((i, ar) in arrSkor.withIndex()) {
                // jawaban pertama skip
                if (i != 0) {
                    // jika jawaban user kedua dst sama dengan jawaban di database maka isTotal = false
                    if (ar != listFromActivity1[i].correctAns) {
                        val a = ar.replace("[^a-zA-Z0-9]".toRegex(), "-")
                        if ("-" in a) {
                            val b = a.replace(a, "0")
                            newSkor.add(b.toInt())
                        } else {
                            newSkor.add(ar.toInt())
                        }
                    }
                } else {
                    newSkor.add(ar.toInt())
                }
            }

            if (newSkor.size != 14) {
                isTotal = false
//                Toast.makeText(this, "accessed size", Toast.LENGTH_SHORT).show()
            }
            if (newSkor.sum() != 12) {
                isTotal = false
//                Toast.makeText(this, "accessed sum", Toast.LENGTH_SHORT).show()
            }

//            Log.d("newSkorSize", "newSkor.size != 14: ${newSkor.size != 14}")
//            Log.d("newSkorSum", "newSkor.sum() != 12: ${newSkor.sum() != 12}")
//            Log.d(
//                "newSkor",
//                "onCreate: $newSkor, size: ${newSkor.size}, sum: ${newSkor.sum()}. isTotal: $isTotal"
//            )
        }

        val res = kunciJawaban(arrSkor, isNormal, isTotal)

        binding.hasilTes.text = res.split("|")[0]
        binding.keterangan.text = res.split("|")[1]
    }

    // semua jawaban ceking manual -> menyesuaikan perubahan konsep terakhir
    private fun kunciJawaban(
        arrSkor: ArrayList<String>, isNormal: Boolean = false, isTotal: Boolean = false
    ): String {
        val normal = arrayListOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        val total = arrayListOf(
            "12", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"
        )
//        val localParsial = arrayListOf(1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1)

//        Log.d("kunci1", "normal: ${normal}, check: ${arrSkor == normal}, size: ${normal.size}")
//        Log.d("kunci2", "total: ${total}, check: ${arrSkor == total}, size: ${total.size}")
//        Log.d("kunci3", "parsial: ${parsial}, check: ${arrSkor == parsial}, size: ${parsial.size}")
//        Log.d("kunci4", "arrSkor: ${arrSkor}, size: ${arrSkor.size}")

        return when {
            isNormal -> {
                "Normal|Lakukan pengecekan mata berkala untuk tetap menjaga kesehatan mata anda."
            }
            arrSkor == parsial -> {
                "Buta Warna Parsial|Kesulitan  dalam  membedakan  warna  tertentu  seperti  merah, hijau dan biru."
            }
            isTotal -> {
                "Buta Warna Total|Hanya dapat melihat warna hitam dan putih saja."
            }
            else -> {
                "Ulangi dan lakukan tes dengan baik|Atau lakukan pemeriksaan ke kedokter untuk hasil lebih lanjut."
            }
        }

    }

    private fun arrayListData(listFromActivity1: ArrayList<SavedAnswer>, which: Int = 3) {
        when (which) {
            1 -> {
                listFromActivity1.add(
                    SavedAnswer("1", "q1", "12", "12"),
                )
                listFromActivity1.add(
                    SavedAnswer("2", "q2", "8", "8"),
                )
                listFromActivity1.add(
                    SavedAnswer("3", "q2", "5", "5"),
                )
                listFromActivity1.add(
                    SavedAnswer("4", "q2", "29", "29"),
                )
                listFromActivity1.add(
                    SavedAnswer("5", "q2", "74", "74"),
                )
                listFromActivity1.add(
                    SavedAnswer("6", "q2", "7", "7"),
                )
                listFromActivity1.add(
                    SavedAnswer("7", "q1", "45", "45"),
                )
                listFromActivity1.add(
                    SavedAnswer("8", "q2", "2", "2"),
                )
                listFromActivity1.add(
                    SavedAnswer("9", "q2", "garis3_3", "garis3_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("10", "q2", "16", "16"),
                )
                listFromActivity1.add(
                    SavedAnswer("11", "q2", "garis2_3", "garis2_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("12", "q2", "35", "35"),
                )
                listFromActivity1.add(
                    SavedAnswer("13", "q1", "96", "96"),
                )
                listFromActivity1.add(
                    SavedAnswer("14", "q1", "garis4_2", "garis4_2"),
                )
            }
            2 -> {
                listFromActivity1.add(
                    SavedAnswer("1", "q1", "12", "12"),
                )
                listFromActivity1.add(
                    SavedAnswer("2", "q2", "3x", "8"),
                )
                listFromActivity1.add(
                    SavedAnswer("3", "q2", "2x", "5"),
                )
                listFromActivity1.add(
                    SavedAnswer("4", "q2", "70x", "29"),
                )
                listFromActivity1.add(
                    SavedAnswer("5", "q2", "21x", "74"),
                )
                listFromActivity1.add(
                    SavedAnswer("6", "q2", "70x", "7"),
                )
                listFromActivity1.add(
                    SavedAnswer("7", "q1", "450x", "45"),
                )
                listFromActivity1.add(
                    SavedAnswer("8", "q2", "20x", "2"),
                )
                listFromActivity1.add(
                    SavedAnswer("9", "q2", "garis3_1x", "garis3_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("10", "q2", "160x", "16"),
                )
                listFromActivity1.add(
                    SavedAnswer("11", "q2", "garis2_2x", "garis2_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("12", "q2", "5x", "35"),
                )
                listFromActivity1.add(
                    SavedAnswer("13", "q1", "6x", "96"),
                )
                listFromActivity1.add(
                    SavedAnswer("14", "q1", "garis4_3x", "garis4_2"),
                )
            }
            3 -> {
                listFromActivity1.add(
                    SavedAnswer("1", "q1", "12", "12"),
                )
                listFromActivity1.add(
                    SavedAnswer("2", "q2", "3", "8"),
                )
                listFromActivity1.add(
                    SavedAnswer("3", "q2", "2", "5"),
                )
                listFromActivity1.add(
                    SavedAnswer("4", "q2", "70", "29"),
                )
                listFromActivity1.add(
                    SavedAnswer("5", "q2", "21", "74"),
                )
                listFromActivity1.add(
                    SavedAnswer("6", "q2", "70", "7"),
                )
                listFromActivity1.add(
                    SavedAnswer("7", "q1", "450", "45"),
                )
                listFromActivity1.add(
                    SavedAnswer("8", "q2", "20", "2"),
                )
                listFromActivity1.add(
                    SavedAnswer("9", "q2", "garis3_1", "garis3_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("10", "q2", "160", "16"),
                )
                listFromActivity1.add(
                    SavedAnswer("11", "q2", "garis2_2", "garis2_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("12", "q2", "5", "35"),
                )
                listFromActivity1.add(
                    SavedAnswer("13", "q1", "6", "96"),
                )
                listFromActivity1.add(
                    SavedAnswer("14", "q1", "garis4_3", "garis4_2"),
                )
            }
            4 -> {
                listFromActivity1.add(
                    SavedAnswer("1", "q1", "12", "12"),
                )
                listFromActivity1.add(
                    SavedAnswer("2", "q2", "3x", "8"),
                )
                listFromActivity1.add(
                    SavedAnswer("3", "q2", "2", "5"),
                )
                listFromActivity1.add(
                    SavedAnswer("4", "q2", "70x", "29"),
                )
                listFromActivity1.add(
                    SavedAnswer("5", "q2", "21x", "74"),
                )
                listFromActivity1.add(
                    SavedAnswer("6", "q2", "70", "7"),
                )
                listFromActivity1.add(
                    SavedAnswer("7", "q1", "450x", "45"),
                )
                listFromActivity1.add(
                    SavedAnswer("8", "q2", "20", "2"),
                )
                listFromActivity1.add(
                    SavedAnswer("9", "q2", "garis3_1", "garis3_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("10", "q2", "160x", "16"),
                )
                listFromActivity1.add(
                    SavedAnswer("11", "q2", "garis2_2", "garis2_3"),
                )
                listFromActivity1.add(
                    SavedAnswer("12", "q2", "5", "35"),
                )
                listFromActivity1.add(
                    SavedAnswer("13", "q1", "6x", "96"),
                )
                listFromActivity1.add(
                    SavedAnswer("14", "q1", "garis4_3", "garis4_2"),
                )
            }
        }
    }

    fun String.containsAlfa(): Boolean {
        for (keyword in "aiueo") {
            if (this.contains(keyword, true)) return true
        }
        return false
    }

    override fun onBackPressed() {
        if (onBackPressed) {
            Intent(this, HomeActivity::class.java).apply {
                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
            this.finish()
        }

        onBackPressed = true
        Handler().postDelayed({ onBackPressed = false }, 2000)
    }

    companion object {
        const val TEST_RESULT = "TEST RESULT"
    }
}