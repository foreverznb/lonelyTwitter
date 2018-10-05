/*
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 *
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;
    private ArrayList<String> Array_1 = new ArrayList<String>();
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private ArrayAdapter<Tweet> adapter;
    //private ArrayList <Tweet> empty_list = new ArrayList<Tweet>();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
        //Button EmotionButton = (Button) findViewById(R.id.add);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                tweets.clear();
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                ImportantTweet newTweet = new ImportantTweet();

                try {
                    newTweet.setMessage(text);
                    newTweet.setDate(new Date());
                    //saveInFile(" Happy! " + text + "  " , new Date(System.currentTimeMillis()));
                    tweets.add(newTweet);
                    adapter.notifyDataSetChanged();
                    saveInFile();
                } catch (TweetTooLongException e) {

                }

                //saveInFile(text, new Date(System.currentTimeMillis()));
                //text += " on ";
				/*String modified_text = "";

				final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
				String selection = mySpinner.getSelectedItem().toString();

				if (selection.compareTo("Happy") == 0){

					//String text_1 = bodyText.getText().toString();
					modified_text = " Happy! "+text + " on " + new Date(System.currentTimeMillis());

					saveInFile(" Happy! " + text + "  " , new Date(System.currentTimeMillis()));
				}
				else if (selection.compareTo("Sad") == 0){

					//String text_1 = bodyText.getText().toString();
					modified_text = " Sad! "+text + " on "+ new Date(System.currentTimeMillis());
					saveInFile(" Sad! "+text + "   ", new Date(System.currentTimeMillis()));
				}
				else if (selection.compareTo("Angry") == 0){
					//String text_1 = bodyText.getText().toString();
					modified_text = " Angry!  "+text + " on "+ new Date(System.currentTimeMillis());
					saveInFile(" Angry!  " + text + "   ", new Date(System.currentTimeMillis()));
				}
				else{
					//String text_1 = bodyText.getText().toString();
					modified_text = " Thrilled!  "+text + " on "+ new Date(System.currentTimeMillis());
					saveInFile(" Thrilled!  " + text + "   ", new Date(System.currentTimeMillis()));
				}

				tweets.add(modified_text);
				//ArrayAdapter<String> adapter = new ArrayAdapter<String>(LonelyTwitterActivity.this, android.R.layout.simple_expandable_list_item_1, tweets);
				adapter.notifyDataSetChanged();
				//oldTweetsList.setAdapter(adapter);
				//((EditText)findViewById(R.id.body)).setText(" ");

                */
                //finish();

            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweets);
        oldTweetsList.setAdapter(adapter);
    }

    private void loadFromFile() {
        //ArrayList<String> tweets = new ArrayList<String>();
        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            Gson gson = new Gson();
            Type listTweetType = new TypeToken<ArrayList<ImportantTweet>>() {
            }.getType();
            tweets = gson.fromJson(reader, listTweetType);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block

            //tweets = new ArrayList<Tweet>();
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //return tweets.toArray(new String[tweets.size()]);
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson(tweets, writer);
            writer.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}