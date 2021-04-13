package Francisco.Gimenez.ISTEA.trabajopractico1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var grados : Button
    lateinit var palindromo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init();

        grados.setOnClickListener(View.OnClickListener {
            ChangeActivity(this,CelsiusActivity::class.java)
        })
        palindromo.setOnClickListener(View.OnClickListener {
            val intento: Intent = Intent(this,PalindromoActivity::class.java)

            startActivity(intento)
        })
    }

    fun Init(){
        grados = findViewById(R.id.b_conversor)
        palindromo = findViewById(R.id.b_palindromos)

    }

    fun <T>ChangeActivity(context: Context, nuevaVista:Class<T>){
        val intento: Intent = Intent(context,nuevaVista)

        startActivity(intento)
    }


}