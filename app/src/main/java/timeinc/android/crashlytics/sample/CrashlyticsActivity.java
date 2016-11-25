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
        int id = item.getItemId();

        if (id == R.id.log_action_1) {
            Crashlytics.log("opened default news section...");
            return true;
        } else if (id == R.id.log_action_1) {
            Crashlytics.log("opened default score section...");
            return true;
        } else if (id == R.id.log_action_2) {
            Crashlytics.log("opened default mysi section...");
            return true;
        } else if (id == R.id.log_action_3) {
            Crashlytics.log("opened default 10spot section...");
            return true;
        } else if (id == R.id.log_action_4) {
            Crashlytics.log("opened default opened article, article id: 0000001");
            return true;
        } else if (id == R.id.log_action_5) {
            Crashlytics.log("opened default opened article, article id: 0000002");
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void logUser() {
        Log.d(this.getClass().getSimpleName(), "logUser");
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("333333");
        Crashlytics.setUserEmail("anandhar3@timeinc.com");
        Crashlytics.setUserName("Anandhar3");
    }

    public void forceCrash(View view) {
        triggerExceptionOne();
    }

    protected void triggerExceptionOne() {
        Crashlytics.setString("last_ui_action", "Open Article");
        Crashlytics.setFloat("last_article_id", 0000001);
        Crashlytics.setBool("is_from_notification", false);
        Crashlytics.setDouble("user_id", 111111);
        throw new ArrayIndexOutOfBoundsException("Test: invalid team data");
    }

    public void crashMe(View view) {
        triggerExceptionTwo();
    }

    protected void triggerExceptionTwo() {
        Crashlytics.setString("last_ui_action", "Open Score");
        Crashlytics.setFloat("last_article_id", 0000002);
        Crashlytics.setBool("is_from_notification", true);
        Crashlytics.setDouble("user_id", 222222);
        throw new IllegalStateException("Test: parsing failed, invalid json");
    }

}
