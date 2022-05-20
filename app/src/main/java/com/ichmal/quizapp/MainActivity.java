package com.ichmal.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;
    TextView score, question;
    private Question nQuestions = new Question();
    private String nAnswer;
    private int nScore = 0;
    private int nQuestionsLenght = nQuestions.nQuestion.length;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        score.setText("Score: "+nScore);

        updateQuestion(r.nextInt(nQuestionsLenght));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer1.getText() == nAnswer){
                    nScore++;
                    score.setText("Score: "+nScore);
                    Correct();
                    updateQuestion(r.nextInt(nQuestionsLenght));
                } else {
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer2.getText() == nAnswer){
                    nScore++;
                    score.setText("Score: "+nScore);
                    Correct();
                    updateQuestion(r.nextInt(nQuestionsLenght));
                } else {
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer3.getText() == nAnswer){
                    nScore++;
                    score.setText("Score: "+nScore);
                    Correct();
                    updateQuestion(r.nextInt(nQuestionsLenght));
                } else {
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer4.getText() == nAnswer){
                    nScore++;
                    score.setText("Score: "+nScore);
                    Correct();
                    updateQuestion(r.nextInt(nQuestionsLenght));
                } else {
                    gameOver();
                }
            }
        });
    }
    private void updateQuestion(int num){
        question.setText(nQuestions.getQuestion(num));
        answer1.setText(nQuestions.getChoice1(num));
        answer2.setText(nQuestions.getChoice2(num));
        answer3.setText(nQuestions.getChoice3(num));
        answer4.setText(nQuestions.getChoice4(num));

        nAnswer = nQuestions.getCorrectAnswer(num);
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is "+ nScore +" points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(MainActivity.this, HomeScreen.class));
                                finish();
                            }
                        })
                .setNegativeButton("EXIT",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        System.exit(0);
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void Correct(){
        Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog optionDialog = builder.create();

        builder.setTitle("Back");
        builder.setMessage("Do you sure to back? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startActivity(new Intent(MainActivity.this, HomeScreen.class));
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                optionDialog.dismiss();
            }
        });
        builder.show();
    }
}