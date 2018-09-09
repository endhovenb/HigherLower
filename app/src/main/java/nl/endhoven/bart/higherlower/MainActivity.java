package nl.endhoven.bart.higherlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int iCorrectGuesses = 0;
    private int iCurrentImageIndex = 0;
    private int iHighScore = 0;
    private int[] mImageNames;
    private ImageView mImageView;
    private ArrayAdapter mAdapter;

    private TextView mTextViewHighScore;
    private TextView mTextViewScore;

    private ListView mListView;
    private List<Dices> mDices;
    private int iDice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize
        mImageView = findViewById(R.id.img_Dices);
        mListView = findViewById(R.id.lstAnswers);
        mTextViewHighScore = (TextView) findViewById(R.id.txtHighscore);
        mTextViewScore = (TextView) findViewById(R.id.txtScore);

        mDices = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mDices);
        mListView.setAdapter(mAdapter);

        //Create array of drawables
        mImageNames = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6};

        mImageView.setImageResource(mImageNames[0]);
        mTextViewHighScore.setText(" Score: " +iCorrectGuesses);

        //Random int for next dice
        iDice = new Random().nextInt(6);;


        FloatingActionButton fabHigher = (FloatingActionButton) findViewById(R.id.fabHigher);
        fabHigher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( iDice > iCurrentImageIndex){
                    iCorrectGuesses++;
                    iCurrentImageIndex = iDice;
                    mImageView.setImageResource(mImageNames[iDice]);
                }
                else{
                    System.out.println("Failed!");
                    iCorrectGuesses = 0;
                    mImageView.setImageResource(mImageNames[iDice]);

                }
                if (iCorrectGuesses > iHighScore){
                    iHighScore = iCorrectGuesses;
                    mTextViewHighScore.setText(" High-Score: " +iHighScore);
                }
                mTextViewScore.setText(" Score: " +iCorrectGuesses);
                iDice = new Random().nextInt(6);;
            }
        });

        FloatingActionButton fabLower = (FloatingActionButton) findViewById(R.id.fabLower);
        fabLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( iDice < iCurrentImageIndex){
                    iCorrectGuesses++;
                    iCurrentImageIndex = iDice;
                    mImageView.setImageResource(mImageNames[iDice]);
                }
                else{
                    System.out.println("Failed!");
                    iCorrectGuesses = 0;
                    mImageView.setImageResource(mImageNames[iDice]);
                }
                if (iCorrectGuesses > iHighScore){
                    iHighScore = iCorrectGuesses;
                    mTextViewHighScore.setText(" High-Score: " +iHighScore);
                }
                mTextViewScore.setText(" Score: " +iCorrectGuesses);
                iDice = new Random().nextInt(6);;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
