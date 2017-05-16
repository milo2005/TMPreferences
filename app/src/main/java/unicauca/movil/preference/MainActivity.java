package unicauca.movil.preference;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.preference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);

        preferences = getSharedPreferences("preference", MODE_PRIVATE);
        String defaultText = getString(R.string.no_data);
        String data = preferences.getString("data",defaultText);

        binding.msgSaved.setText(data);
    }

    public void save(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("data",binding.msg.getText().toString());
        editor.apply();
    }
}
