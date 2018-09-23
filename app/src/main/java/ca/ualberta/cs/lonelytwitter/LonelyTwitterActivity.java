package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList <String> Array_1 = new ArrayList<String>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        //Button EmotionButton = (Button) findViewById(R.id.add);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				ImportantTweet importantTweet = new ImportantTweet();
				try {
					importantTweet.setMessage(text);
				} catch (TweetTooLongException e) {

				}

				//saveInFile(text, new Date(System.currentTimeMillis()));
				//text += " on ";
				String modified_text = "";

				final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
				String selection = mySpinner.getSelectedItem().toString();

				if (selection.compareTo("Happy") == 0){

					//String text_1 = bodyText.getText().toString();
					modified_text = " Happy! "+text + " on " + new Date(System.currentTimeMillis());

					saveInFile(" Happy! "+text , new Date(System.currentTimeMillis()));
				}
				else if (selection.compareTo("Sad") == 0){

					//String text_1 = bodyText.getText().toString();
					modified_text = " Sad! "+text + " on "+ new Date(System.currentTimeMillis());
					saveInFile(" Sad! "+text, new Date(System.currentTimeMillis()));
				}
				else if (selection.compareTo("Angry") == 0){
					//String text_1 = bodyText.getText().toString();
					modified_text = " Angry!  "+text + " on "+ new Date(System.currentTimeMillis());
					saveInFile(" Angry!  " + text, new Date(System.currentTimeMillis()));
				}
				else{
					//String text_1 = bodyText.getText().toString();
					modified_text = " Thrilled!  "+text + " on "+ new Date(System.currentTimeMillis());
					saveInFile(" Thrilled!  " + text, new Date(System.currentTimeMillis()));
				}

				Array_1.add(modified_text);
				ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(LonelyTwitterActivity.this, android.R.layout.simple_expandable_list_item_1, Array_1);
				oldTweetsList.setAdapter(adapter_1);
				((EditText)findViewById(R.id.body)).setText(" ");


				//finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}

	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
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