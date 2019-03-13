package br.com.fiap.componentes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var campo1: EditText
    lateinit var botao: Button
    lateinit var campo2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        campo1 = findViewById(R.id.editText)
        campo2 = findViewById(R.id.editText)
        botao = findViewById(R.id.button)

        botao.setOnClickListener{

            var campoDoNome = campo1.text.toString()
            var campoDoTelefone = campo2.text.toString()
            var Ratingbar = ratingBar.rating.toString()

            Toast.makeText(applicationContext,
                    "nome: "+campoDoNome+"\nnúmero: "+campoDoTelefone+"\nseu rating: "+Ratingbar,
                    Toast.LENGTH_LONG).show()
        }
        ratingBar.setOnRatingBarChangeListener{
            ratingBar, rating, fromUser -> rating
            Toast.makeText(applicationContext,
                    "" + rating,
                    Toast.LENGTH_LONG).show()
        }
        ratingBar.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(ratingBar: RatingBar?,
                                         rating: Float,
                                         fromUser: Boolean) {
                Toast.makeText(applicationContext,
                        "" + rating,
                        Toast.LENGTH_LONG).show()
            }

        })

        checkBox.setOnCheckedChangeListener{
            buttonView, isChecked ->
            exibirMensagem(isChecked)
        }
        toggleButton.setOnCheckedChangeListener{
            buttonView, isChecked ->
            exibirMensagem(isChecked)
        }
        switch1.setOnCheckedChangeListener{
            buttonView, isChecked ->
            exibirMensagem(isChecked)
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?,
                                           progress: Int,
                                           fromUser: Boolean) {
                textView.text = "" + progress

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext,
                        "Começou",
                        Toast.LENGTH_LONG).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext,
                        "Parou",
                        Toast.LENGTH_LONG).show()
            }
        })

        radioGroup.setOnCheckedChangeListener {
            group, checkedId ->
            var opcaoSelecionada: RadioButton = findViewById(checkedId)

            Toast.makeText(applicationContext, opcaoSelecionada.text, Toast.LENGTH_LONG).show()
        }

        var opcoes = arrayOf("Opcao1","Opcao 2", "Opcao 3")
        spinner.adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, opcoes)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var opcaoSelecionada = opcoes[position]
                Toast.makeText(applicationContext, opcaoSelecionada, Toast.LENGTH_LONG) .show()
            }

        }
    }

    private fun exibirMensagem(isChecked: Boolean) {
        var texto = if (isChecked) "Ligado" else "Desligado"
        Toast.makeText(applicationContext,
                texto,
                Toast.LENGTH_LONG).show()
    }
}
