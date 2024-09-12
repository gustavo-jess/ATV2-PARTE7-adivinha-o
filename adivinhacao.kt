package br.unipar.atividade07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var randomNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        randomNumber = Random.nextInt(1, 101)

        val guessEditText: EditText = findViewById(R.id.guessEditText)
        val checkButton: Button = findViewById(R.id.checkButton)
        val feedbackTextView: TextView = findViewById(R.id.feedbackTextView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkButton.setOnClickListener {
            val userGuess = guessEditText.text.toString().toIntOrNull()
            feedbackTextView.text = when {
                userGuess == null -> "Por favor, insira um número válido."
                userGuess < randomNumber -> "Seu palpite é muito baixo."
                userGuess > randomNumber -> "Seu palpite é muito alto."
                else -> "Parabéns! Você acertou!"
            }
        }
    }
}



<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/guessEditText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Digite seu palpite"
        android:inputType="number"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/checkButton"
        android:layout_margin="16dp" />

    <Button
        android:id="@+id/checkButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Verificar Palpite"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/guessEditText"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_margin="16dp"/>

    <TextView
        android:id="@+id/feedbackTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text=""
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/checkButton"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_margin="16dp"/>

</androidx.constraintlayout.widget.ConstraintLayout>
