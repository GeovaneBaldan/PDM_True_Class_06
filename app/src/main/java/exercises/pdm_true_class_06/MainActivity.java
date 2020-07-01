package exercises.pdm_true_class_06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.mainmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuCalc:
                Intent intent = new Intent(getApplicationContext(), CalculateAvg.class);
                startActivity(intent);
                return true;

            case R.id.menuClose:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("Closing the app");
                dialog.setMessage("Do you really want to close the app?");

                dialog.setPositiveButton("Close", new DialogOkListener());
                dialog.setNegativeButton("Cancel", new DialogCancelListener());

                dialog.setCancelable(false);
                dialog.create();
                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class DialogCancelListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();

            Toast.makeText(getApplicationContext(), "Canceling...", Toast.LENGTH_SHORT).show();
        }
    }

    private class DialogOkListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();

            Toast.makeText(getApplicationContext(), "Exiting...", Toast.LENGTH_SHORT).show();
        }
    }

}