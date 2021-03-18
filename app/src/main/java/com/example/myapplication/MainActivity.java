package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // #1)
    private TextView answerTv;
    private EditText numEt1, numEt2;
//..

    //#4
    private String numTxt1, numTxt2;  // сюда помешаем наш numEt1, numEt1 и получаем текст
    private int numTv1, numTv2; // а сюда конвертируем наш numTxt1 , numTet2
    private int answerMath; // сюда будем писать ответы <answerMath = numTxt1 + numTet2> и.д
    private String answerString ; //№8.2  конвертируем answerMath сюда в стринг
//..
    private ImageButton button; //№8.0 наша кнопка для получение ответа

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(); // #3)  инициализация метода просто пишем имя метода
        clickListener();// инициализация нашего клика

    }

    //#2
    private void init() {
        // специальный метод для инициализации....  всегда так надо делить !
        answerTv = findViewById(R.id.answerTv);
        numEt1 = findViewById(R.id.numEt1);
        numEt2 = findViewById(R.id.numEt2);
        button = findViewById(R.id.button);
    }

    //..

    //#5 специальный метод для конвертации
    private void getText() {
        numTxt1 = numEt1.getText().toString();//сюда помешаем наш numEt1 <getText().toString()> для получение текста внутри numEt1
        numTxt2 = numEt2.getText().toString();//сюда помешаем наш numEt2 <getText().toString()> для получение текста внутри numEt2

        numTv1 = Integer.parseInt(numTxt1);// в numTv1  конвертируем наш numTxt1
        numTv2 = Integer.parseInt(numTxt2);// в numTv2  конвертируем наш numTxt2
        // вот и получили значение виде int для математических операции numTv1,  numTv2
    }
    //#6 mathOperations
    public void mathOperations() {
        answerMath = numTv1 + numTv2; // ответ присваиваем сюда answerMath
        answerString = Integer.toString(answerMath); // здесь мы конвертируем на Sting наш ответ answerMath
    }
    //#7 sendToTextView
    public void sendToTextView(){
        answerTv.setText(answerString);//готова мы отправили в ТextView наш ответ
    }

    //№8.1здесь будет клики
    public void clickListener(){
        button.setOnClickListener(v -> {
            getText();
            mathOperations();
            sendToTextView();
        });
    }

}