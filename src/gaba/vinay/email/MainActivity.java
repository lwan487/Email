package gaba.vinay.email;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText recipient=(EditText)findViewById(R.id.recipient);
		final EditText subject=(EditText)findViewById(R.id.subject);
		final EditText body=(EditText)findViewById(R.id.body);
		Button send=(Button)findViewById(R.id.send);
		
		
		
		send.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// Launching News Feed Screen
				String reci=recipient.getText().toString();
				String sub=subject.getText().toString();
				String bod=body.getText().toString();
				if(reci=="" || sub=="" || bod=="")
				{
					Toast.makeText(MainActivity.this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();
				}
				else
				{
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL  , new String[]{reci});
				i.putExtra(Intent.EXTRA_SUBJECT, sub);
				i.putExtra(Intent.EXTRA_TEXT   , bod);
				try {
				    startActivity(Intent.createChooser(i, "Send mail..."));
				} catch (android.content.ActivityNotFoundException ex) {
				    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}}
			}
		});
		
	}

	
}
