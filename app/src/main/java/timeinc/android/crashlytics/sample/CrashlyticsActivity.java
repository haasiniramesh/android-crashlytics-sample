package timeinc.android.crashlytics.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class CrashlyticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        logUser();

        setContentView(R.layout.activity_crashlytics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crashlytics, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_custom_logging) {
            Crashlytics.log("Higgs-Boson detected! Running out...");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logUser() {
        Log.d(this.getClass().getSimpleName(), "logUser");
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("00003");
        Crashlytics.setUserEmail("anandhar@timeinc.com");
        Crashlytics.setUserName("Anandhar");
    }

    public void forceCrash(View view) {
        Crashlytics.setString("last_ui_action", "Article_open");
        Crashlytics.setFloat("last_article_id", 11111);
        Crashlytics.setBool("last_is_from_notification", false);
        Crashlytics.setDouble("last_user_id",00003);
        throw new NullPointerException("This is a crash");
    }


}
