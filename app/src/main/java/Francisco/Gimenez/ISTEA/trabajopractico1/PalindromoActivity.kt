package Francisco.Gimenez.ISTEA.trabajopractico1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class PalindromoActivity : AppCompatActivity() {

    lateinit var verificar: Button
    lateinit var textoOriginal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palindromo)
        Init()

        verificar.setOnClickListener(View.OnClickListener {

            DarVueltaYComparar()

        })



    }

    fun Init(){
        verificar = findViewById(R.id.b_pali_verificar)
        textoOriginal = findViewById(R.id.e_pali_input)
    }

    fun Reverse(original:String):String{
        var reverse: String = ""
        var originalSEspacio: String = ""

        originalSEspacio = original.replace("\\s+".toRegex(), "")



        for (i in originalSEspacio.length - 1 downTo 0){

            reverse += originalSEspacio[i]
        }

        return reverse
    }

    fun DarVueltaYComparar(){

        var stringOriginal:String = textoOriginal.text.toString()
        var stringReversed = Reverse(stringOriginal)

        stringOriginal = stringOriginal.replace("\\s+".toRegex(), "")

        if(stringReversed.toLowerCase() == stringOriginal.toLowerCase()){
            Toast.makeText(this, "Es un palindromo! ", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, "No es un palindromo ", Toast.LENGTH_LONG).show()
        }
    }
}
