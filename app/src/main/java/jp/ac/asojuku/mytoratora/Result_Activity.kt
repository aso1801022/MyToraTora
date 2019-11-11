package jp.ac.asojuku.mytoratora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result_.*

class Result_Activity : AppCompatActivity() {
    val oba=0//おば（ぐー）
    val kato=1 //かと（チョキ）
    val tora=2//tora(パー）

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_)
        val id=intent.getIntExtra("MY_TORA",0);

        val myTora:Int;

        myTora=when(id){

            R.id.oba -> {
                mytoraImage.setImageResource(R.drawable.sport_walking_oldwoman)//おばさん＝グー
                oba
                }
            R.id.kato -> {
                mytoraImage.setImageResource(R.drawable.nigaoe_katoukiyomasa)//キヨマサ＝チョキ
                kato
            }
            R.id.tora -> {
                mytoraImage.setImageResource(R.drawable.uchidenokoduchi_eto03_tora)//とら＝パー
                tora
            }
            else->oba
        }
        //コンピュータの手を決める

        val micoHand =(Math.random()*3).toInt()
        when(micoHand){
            oba -> micoImage.setImageResource(R.drawable.sport_walking_oldwoman)//おばさん＝グー
            kato -> micoImage.setImageResource(R.drawable.nigaoe_katoukiyomasa)//キヨマサ＝チョキ
            tora -> micoImage.setImageResource(R.drawable.uchidenokoduchi_eto03_tora)//とら＝パー

        }
        val gameResult =(micoHand-myTora+3)%3;
        when(gameResult){
            0->resultLabel.setText(R.string.draw);//あいこ
            1->resultLabel.setText(R.string.win);//勝ち
            2->resultLabel.setText(R.string.lose);//負け
        }
        backButton.setOnClickListener{finish()}


        }
    }

