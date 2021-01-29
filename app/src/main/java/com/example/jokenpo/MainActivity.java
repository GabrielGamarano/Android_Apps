package com.example.jokenpo;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView principal;
    private ImageView jogador;
    private ImageView pedra;
    private ImageView papel;
    private ImageView tesoura;
    private TextView comando;
    private TextView titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();

        final ImageView jogada = jogador;
     pedra.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Pedra(v);
             jogada.setImageResource(R.drawable.pedra);
         }
     });

     papel.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Papel(v);
             jogada.setImageResource(R.drawable.papel);
         }
     });

     tesoura.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Tesoura(v);
             jogada.setImageResource(R.drawable.tesoura);
         }
     });

    }

    protected void initVariables(){
        principal = findViewById(R.id.imageViewPrincipal);
        jogador = findViewById(R.id.imageViewJogador);
        pedra = findViewById(R.id.imageViewPedra);
        papel = findViewById(R.id.imageViewPapel);
        tesoura = findViewById(R.id.imageViewTesoura);
        comando = findViewById(R.id.textViewCondicao);
        titulo = findViewById(R.id.textViewTitulo);

    }

    protected void Pedra(View view){
        this.opcaoApp("Pedra");

    }
    protected void Papel(View view){
        this.opcaoApp("Papel");

    }
    protected void Tesoura(View view){
        this.opcaoApp("Tesoura");

    }

    public void opcaoApp(String opcaoSelecionada){
        ImageView App = principal;
        TextView resultado = titulo;
        int rand = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[rand];
        String ultimaEscolha = escolhaApp;

        switch (escolhaApp){
            case "Pedra":
                App.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                App.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                App.setImageResource(R.drawable.tesoura);
                break;
        }

        
        if (
                (escolhaApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
                (escolhaApp == "Papel" && opcaoSelecionada == "Pedra")   ||
                (escolhaApp == "Tesoura" && opcaoSelecionada == "Papel")
            ){
                resultado.setText("Você Perdeu!");
        }else if (
                (opcaoSelecionada == "Pedra" && escolhaApp == "Tesoura") ||
                (opcaoSelecionada == "Papel" && escolhaApp =="Pedra")  ||
                (opcaoSelecionada == "Tesoura" && escolhaApp == "Papel")
        ){
            resultado.setText("Você Ganhou!!");
        }else{
            resultado.setText("Empate, tente de novo.");
        }


    }

}