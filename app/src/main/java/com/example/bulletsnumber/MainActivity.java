package com.example.bulletsnumber;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView textView;
    EditText editText;
    Button btn_clear, btn_counter;
    Spinner spinner;

    final String[] bulltes = {"1", "\u25CF", "☛", "❯", "✖", "»", "➥", "\u25A0", "\u25A1", "\u25BA", "\u2605", "➠", "✓", "⍟", "✮", "✰", "➮", "➤"};
    int cursorPosition = 1;


    int index;
    int bulletNo = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.edittext);
        btn_clear = findViewById(R.id.btn_clear_text);
        btn_counter = findViewById(R.id.btn_c);
        spinner = findViewById(R.id.spinner);


        /* Set Spinner Adapter*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bulltes);
        spinner.setAdapter(adapter);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                textView.setText("");
                index = 0;
                cursorPosition = 0;
                bulletNo = 1;

            }
        });
        btn_counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(addBulletsNo(editText.getText().toString()));
                String str_text = textView.getText().toString();

                int curLine;
                int nextLine;
                int lineCount = textView.getLineCount();
                int mbulletno = 0;

                for (int i = 0; i < lineCount; i++) {

                    curLine = textView.getLayout().getLineStart(i);
                    nextLine = textView.getLayout().getLineEnd(i);
                    String per_line_length = textView.getText().toString().substring(curLine, nextLine);         // per line length
//                    Log.i(TAG, "onClick: result   " + result.length());
//                    Log.i(TAG, "onClick: result   " + result);
//                    difference = (nextLine - 1) - (curLine);
//                    Log.i(TAG, "onClick: pos::=      " + (curLine) + "    ..........  " + (nextLine - 1));
//                    Log.i(TAG, "onClick: difference          " + difference);
                    /* For Number bullets */
                    if (spinner.getSelectedItemId() == 0) {

                        if (per_line_length.endsWith("\n")) {
                            mbulletno++;
                        }
                        // last line
                        if (i == (lineCount - 1)) {
                            if (per_line_length.length() == 4) {
                                mbulletno--;
                                Log.i(TAG, "onClick: 0 ");
                                StringBuilder myName = new StringBuilder(str_text);
                                myName.setCharAt(curLine, ' ');
                                myName.setCharAt(curLine + 1, ' ');
                                str_text = myName.toString();
                            }
                          /*  if (per_line_length.length() == 4 && i == 0) {
                                Log.i(TAG, "onClick: 1 ");
                                StringBuilder myName = new StringBuilder(str_text);
                                myName.setCharAt(curLine, ' ');
                                myName.setCharAt(curLine + 1, ' ');
                                str_text = myName.toString();
                            }*/
                            if (per_line_length.length() == 5) {
                                if ((mbulletno + 1) >= 10) {
                                    mbulletno--;
                                    Log.i(TAG, "onClick: 2 ");
                                    StringBuilder myName = new StringBuilder(str_text);
                                    myName.setCharAt(curLine, ' ');
                                    myName.setCharAt(curLine + 1, ' ');
                                    myName.setCharAt(curLine + 2, ' ');
                                    str_text = myName.toString();
                                }
                            }
                            // random line
                        } else {
                            if (per_line_length.length() == 4) {
                                Log.i(TAG, "onClick: 3 ");
                                mbulletno--;
                                StringBuilder myName = new StringBuilder(str_text);
                                myName.setCharAt(curLine, ' ');
                                myName.setCharAt(curLine + 1, ' ');
                                str_text = myName.toString();
                            }
                            if (per_line_length.length() == 5) {
                                Log.i(TAG, "onClick: 4 ");
                                mbulletno--;
                                StringBuilder myName = new StringBuilder(str_text);
                                myName.setCharAt(curLine, ' ');
                                myName.setCharAt(curLine + 1, ' ');
                                str_text = myName.toString();
                            }
                           /* if (i == 0 && per_line_length.length() == 5) {
                                Log.i(TAG, "onClick: 5 ");
                                StringBuilder myName = new StringBuilder(str_text);
                                myName.setCharAt(curLine, ' ');
                                myName.setCharAt(curLine + 1, ' ');
                                myName.setCharAt(curLine + 2, ' ');
                                str_text = myName.toString();
                            }*/
                            if (per_line_length.length() == 6) {
                                if (mbulletno >= 10) {
                                    mbulletno--;
                                    Log.i(TAG, "onClick: 6 ");
                                    StringBuilder myName = new StringBuilder(str_text);
                                    myName.setCharAt(curLine, ' ');
                                    myName.setCharAt(curLine + 1, ' ');
                                    myName.setCharAt(curLine + 2, ' ');
                                    str_text = myName.toString();
                                }
                            }
                            if (per_line_length.length() == 5) {
                                if (mbulletno >= 10) {
                                    mbulletno--;
                                    Log.i(TAG, "onClick: 7 ");
                                    StringBuilder myName = new StringBuilder(str_text);
                                    myName.setCharAt(curLine, ' ');
                                    myName.setCharAt(curLine + 1, ' ');
                                    myName.setCharAt(curLine + 2, ' ');
                                    str_text = myName.toString();
                                }
                            }
                        }
                        Log.i(TAG, "onClick: result   " + per_line_length.length() + " line no " + i + "  last " + (lineCount - 1) + "  bulletsno   " + (mbulletno));
                        /* For Symbol bullets */
                    } else {
                        // for last line
                        if (i == (lineCount - 1)) {
                            if (per_line_length.length() == 3) {
                                StringBuilder myName = new StringBuilder(str_text);
                                myName.setCharAt(curLine, ' ');
                                str_text = myName.toString();
                            }
                            // random line
                        } else if (per_line_length.length() == 4) {
                            StringBuilder myName = new StringBuilder(str_text);
                            myName.setCharAt(curLine, ' ');
                            str_text = myName.toString();

                        } else if (per_line_length.length() == 3) {
                            StringBuilder myName = new StringBuilder(str_text);
                            myName.setCharAt(curLine, ' ');
                            str_text = myName.toString();
                        }
                    }
                }
                textView.setText(str_text);
                Log.i(TAG, "onClick: --------------------------------------- ");

            }
        });
    }


    public String addBulletsNo(String text) {
        // For Number Bullet
        if (spinner.getSelectedItemId() == 0) {
            StringBuilder textBuilder = new StringBuilder(text);
            textBuilder.insert(0, spinner.getSelectedItem().toString() + ".   ");
            text = textBuilder.toString();
            // For symbol Bullet
        } else {
            StringBuilder textBuilder = new StringBuilder(text);
            textBuilder.insert(0, spinner.getSelectedItem().toString() + "  ");
            text = textBuilder.toString();
        }
        String newText;
        int no = 1;

        int char_counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                // For Number Bullet
                if (spinner.getSelectedItemId() == 0) {
                    no++;
                    Log.i(TAG, "addBulletsNo: char_counter  " + char_counter + " no:: - " + no);
                    if (char_counter <= 5) {
                        no--;
                    } else if (char_counter <= 6) {
                        if (no > 10) {
                            no--;
                        }
                    }
                    newText = text.substring(0, i + 1) + no + ".  " + text.substring(i + 1);
                    // For symbol Bullet
                } else {
                    newText = text.substring(0, i + 1) + spinner.getSelectedItem().toString() + "  " + text.substring(i + 1);
                }
                char_counter = 0;
                text = newText;
            }
            char_counter++;
        }
        // For Number Bullet
        if (spinner.getSelectedItemId() == 0) {
            StringBuilder textBuilder = new StringBuilder(text);
            textBuilder.deleteCharAt(3);
            text = textBuilder.toString();
        }
        return text;
    }
}
