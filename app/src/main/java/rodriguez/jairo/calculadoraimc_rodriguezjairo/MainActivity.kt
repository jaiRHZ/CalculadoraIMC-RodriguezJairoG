package rodriguez.jairo.calculadoraimc_rodriguezjairo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){

    lateinit var weight: EditText
    lateinit var height: EditText
    lateinit var buttonCalculate: Button
    lateinit var imc: TextView
    lateinit var range: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById(R.id.weight)
        height = findViewById(R.id.height)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        imc = findViewById(R.id.imc)
        range = findViewById(R.id.range)

        buttonCalculate.setOnClickListener {

            val weightValue = weight.text.toString().toDouble()
            val heightValue = height.text.toString().toDouble()

            val imcValue = calculateIMC(weightValue, heightValue)

            imc.text = "IMC: %.2f".format(imcValue)
            range.text = getRange(imcValue)
            range.setBackgroundResource(getRangeColor(imcValue))

        }
    }

    private fun calculateIMC(weight: Double, height: Double): Double{

        return weight / (height * height)

    }

    private fun getRange(imc: Double): String{

        return when{

            imc < 18.5 -> "Bajo Peso"
            imc < 25 -> "Normal"
            imc < 30 -> "Sobrepeso"
            imc < 35 -> "Obesidad grado 1"
            imc < 40 -> "Obesidad grado 2"
            else -> "Obesidad grado 3"

        }
    }

    private fun getRangeColor(imc: Double): Int{

        return when{

            imc <18.5 -> R.color.orange
            imc <25 -> R.color.green
            imc <30 -> R.color.greenish
            imc <35 -> R.color.yellow
            imc <40 -> R.color.orange
            else -> R.color.red

        }
    }

}