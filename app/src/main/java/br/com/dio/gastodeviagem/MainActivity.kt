package br.com.dio.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalc.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalc) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOK()) {
            if(editAutonomy.text.toString() == "0") {
                Toast.makeText(this, "KMs por Litro deve ser diferente de zero", Toast.LENGTH_LONG)
                    .show()
                textResult.text = "R$ 0"
            }else {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()
                val result = (distance * price) / autonomy
                textResult.text =
                    "R$ ${"%.2f".format(result)}" /*Pega o Id do texto de onde vai aparecer o resultado no app, e transforma o texto no resultado*/
            }
        }else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG)
                .show() //Mostra uma notificação na tela
            textResult.text = "R$ 0"
        }
    }

    fun validationOK(): Boolean { /* Se algum campo estiver vazio, não calcule nada.*/

        if (editDistance.text.toString() != ""
            && editPrice.text.toString() != ""
            && editAutonomy.text.toString() != "")
            return true

        return false
    }


}